

public class Main {
    public static void main(String[] args) {
        SList<String> list = new SList<>();
        SListIterator<String> it = list.iterator();

        it.insert("One");
        it.insert("Two");
        it.insert("Three");

        System.out.println("List after insertion: " + list);

        // Move iterator to beginning
        SListIterator<String> it2 = list.iterator();
        while (it2.hasNext()) {
            String val = it2.next();
            if (val.equals("Two")) {
                it2.remove(); // removes "Two"
            }
        }

        System.out.println("List after removal: " + list);
    }
}

