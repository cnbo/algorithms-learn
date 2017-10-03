public class FixedCapacityStack<Item> {
    private Item[] items;

    private int size;

    public FixedCapacityStack(int cap) {
        items = (Item[]) new Object[cap];
    }

    public void push(Item item) {
       items[size++] = item;
    }

    public Item pop() {
       return items[--size];
    }

    public boolean isEmpty() {
       return size == 0;
    }

    public int size() {
       return size;
    }

    public static void main(String[] args) {
        FixedCapacityStack<Integer> stack = new FixedCapacityStack<Integer>(100);
        for (int i = 0; i < 100; i++) {
            if ((i & 1) == 0) {
                stack.push(i);
            } else if (!stack.isEmpty() && i < 70) {
                System.out.println(stack.pop());
            }
        }

        System.out.println("stack size == " + stack.size());
    }

}
