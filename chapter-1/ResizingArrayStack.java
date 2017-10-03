import java.util.Iterator;

public class ResizingArrayStack<Item> implements Iterable<Item> {

    private Item[] items = (Item[]) new Object[1];

    private int size = 0;

    public ResizingArrayStack() {}

    public void push(Item item) {
        if (size == items.length) {
            resize(2 * size);
        }
        items[size++] = item;
    }

    public Item pop() {
        if (isEmpty()) {
          return null;
        }
        Item item = items[--size];
        items[size] = null;
        if (size > 0 && size == items.length / 4) {
            resize(items.length / 2);
        }

        return item;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void resize(int max) {
        Item[] newItem = (Item[]) new Object[max];
        for (int i = 0; i < items.length; i++) {
            newItem[i] = items[i];
        }
        items = newItem;
    }

    public Iterator<Item> iterator() {
        return new ArrayIterator();
    }

    private class ArrayIterator implements Iterator<Item> {
        private int n = size;

        public boolean hasNext() {
            return n > 0;
        }

        public Item next() {
            return items[n--];
        }

        public void remove() {}
    }

    public static void main(String[] args) {
        ResizingArrayStack<Integer> stack = new ResizingArrayStack<Integer>();
        for (int i = 0; i < 100; i++) {
            if ((i & 1) == 0) {
                stack.push(i);
            } else if (!stack.isEmpty() && i < 80) {
                System.out.println(i);
            }
        }

        System.out.println("==============================");
        System.out.println("stack size == " + stack.size());

        System.out.println("==============================");
        for (Integer num : stack) {
          System.out.println(num);
        }
    }

}
