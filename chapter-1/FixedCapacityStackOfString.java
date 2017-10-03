public class FixedCapacityStackOfString {

    private String[] strs;

    private int size;

    public FixedCapacityStackOfString(int cap) {
        strs = new String[cap];
    }

    public void push(String item) {
        strs[size++] = item;
    }

    public String pop() {
        return strs[--size];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        FixedCapacityStackOfString stack = new FixedCapacityStackOfString(100);
        for (int i = 0; i < 50; i++) {
            stack.push("test");
        }
        System.out.println("stack size == " + stack.size());
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
