import java.util.Iterator;

public class ChainStack<Item> implements Iterable<Item> {
    private Node head;

    private int size;

    private class Node {
        Item item;
        Node next;
    }

    public ChainStack() {}

    public void push(Item item) {
        Node node = new Node();
        node.item = item;
        if (head == null) {
            head = node;
        } else {
            node.next = head;
            head = node;
        }
        size++;
    }

    public Item pop() {
        if (isEmpty()) {
            return null;
        }
        Item item = head.item;
        head = head.next;
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
        private int n = size;

        private Node node = head;

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

    /*
    public static void main(String[] args) {
        ChainStack<Integer> stack = new ChainStack<Integer>();
        for (int i = 0; i < 100; i++) {
            if ((i & 1) == 0) {
                stack.push(i);
            } else if (!stack.isEmpty() && i < 70) {
                System.out.println(stack.pop());
            }
        }

        System.out.println("=======================");
        for (Integer num : stack) {
            System.out.println(num);
        }

        System.out.println("======================");
        System.out.println("stack size == " + stack.size());
    }
    */
}
