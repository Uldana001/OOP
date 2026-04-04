import java.util.ArrayList;
import java.util.Iterator;

public class Task3 {
    interface MyCollection<E> {
        boolean add(E element);
        boolean remove(Object element);
        boolean contains(Object element);
        int size();
        boolean isEmpty();
        void clear();
        Iterator<E> iterator();
    }

    static class SimpleList<E> implements MyCollection<E> {
        private ArrayList<E> data = new ArrayList<>();

        public boolean add(E element) {
            data.add(element);
            System.out.println("Added: " + element);
            return true;
        }

        public boolean remove(Object element) {
            boolean removed = data.remove(element);
            if (removed) System.out.println("Removed: " + element);
            else System.out.println("Not found: " + element);
            return removed;
        }

        public boolean contains(Object element) {
            return data.contains(element);
        }

        public int size() {
            return data.size();
        }

        public boolean isEmpty() {
            return data.isEmpty();
        }

        public void clear() {
            data.clear();
            System.out.println("Collection cleared.");
        }

        public Iterator<E> iterator() {
            return data.iterator();
        }
    }
    public static void main(String[] args) {

        SimpleList<String> list = new SimpleList<>();

        System.out.println("Is empty: " + list.isEmpty());

        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");

        System.out.println("Size: " + list.size());

        System.out.println("Contains Banana: " + list.contains("Banana"));
        System.out.println("Contains Mango: " + list.contains("Mango"));

        System.out.print("All items: ");
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();

        list.remove("Banana");
        list.remove("Mango");

        System.out.println("Size after remove: " + list.size());

        list.clear();
        System.out.println("Is empty after clear: " + list.isEmpty());
    }
}