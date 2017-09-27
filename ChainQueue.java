import java.util.Iterator;

public class ChainQueue<Item> implements Iterable<Item> {
    private Node first;

    private Node last;

    private int size;

    private class Node {
        Item item;
        Node next;
    }

    public ChainQueue() {}

    public void enqueue(Item item) {
        Node node = new Node();
        node.item = item;
        if (first == null && last == null) {
            first = node;
            last = node;
        } else {
            last.next = node;
            last = node;
        }
        size++;
    }

    public Item dequeue() {
        if (isEmpty()) {
            return null;
        }
        Item item = first.item;
        first = first.next;
        size--;

        return item;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        private Node node = first;

        private int n = size;

        public boolean hasNext() {
            return n > 0;
        }

        public Item next() {
            Item item = node.item;
            node = node.next;
            n--;
            return item;
        }

        public void remove() {}
    }

    public static void main(String[] args) {
        ChainQueue<Integer> queue = new ChainQueue<Integer>();

        for (int i = 0; i < 100; i++) {
            if (i < 80) {
                queue.enqueue(i);
            } else {
                System.out.println(queue.dequeue());
            }
        }

        System.out.println("==========================");
        for (Integer num : queue) {
            System.out.println(num);
        }

        System.out.println("==========================");
        System.out.println("queue size == " + queue.size());
    }
}
