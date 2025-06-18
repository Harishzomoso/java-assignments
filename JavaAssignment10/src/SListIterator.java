public class SListIterator<T> {
    private SList.Node<T> current;
    private SList.Node<T> previous;

    public SListIterator(SList.Node<T> head) {
        this.current = head;
        this.previous = head;
    }

    // Insert after current
    public void insert(T data) {
        SList.Node<T> newNode = new SList.Node<>(data);
        newNode.next = current.next;
        current.next = newNode;
        current = newNode;
    }

    // Remove current node
    public void remove() {
        if (current.next != null) {
            current.next = current.next.next;
        }
    }

    public boolean hasNext() {
        return current.next != null;
    }

    public T next() {
        previous = current;
        current = current.next;
        return current.data;
    }
}
