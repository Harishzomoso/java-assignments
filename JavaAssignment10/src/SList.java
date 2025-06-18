public class SList<T> {
    static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
        }
    }

    private Node<T> head = new Node<>(null); // dummy head

    public SListIterator<T> iterator() {
        return new SListIterator<>(head);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<T> current = head.next;
        while (current != null) {
            sb.append(current.data).append(" -> ");
            current = current.next;
        }
        sb.append("null");
        return sb.toString();
    }
}

