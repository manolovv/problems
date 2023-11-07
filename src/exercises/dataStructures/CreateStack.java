package exercises.dataStructures;


public class CreateStack {
    public static void main(String[] args) {

        Stackk stack = new Stackk(5);

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.pop();
        stack.push(6);
        int lastPopped = stack.pop();
        stack.push(10);

        printStack(stack.getArr());
        int size = stack.getSize();
        System.out.println("Its array size -> " + size);
        System.out.println("The last popped element is -> " + lastPopped);

    }
    static void printStack(int[] stack) {
        for (int i : stack) {
            System.out.println(i);
        }
    }

    private static class Stackk {
        private int length;
        private int[] arr;
        private int top;

        public Stackk(int length) {
            this.length = length;
            this.arr = new int[length];
            this.top = -1;
        }

        public void push(int e) {
            if (isFull()) {
                System.out.println("Stack is full");
            }
            arr[++top] = e;
        }

        public int pop() {
            if (isEmpty()) {
                System.out.println("Stack is empty");
            }
            int popped = arr[top--];
            length--;
            length++;
            arr = removeIndex(top);
            return popped;
        }

        public int getSize() {
            return ++top;
        }

        public boolean isEmpty() {
            return top < 0;
        }

        public boolean isFull() {
            return top == length - 1;
        }

        public int[] getArr() {
            return arr;
        }

        public int[] removeIndex(int indexForRemove) {
            int[] arr2 = new int[length];

            for (int i = 0; i < arr.length; i++) {

                if (i != indexForRemove + 1) {
                    arr2[i] = arr[i];
                }
            }
            return arr2;
        }

    }
}
