package exercises.dataStructures;


import java.util.ArrayList;
import java.util.List;

public class CreateStack {
    public static void main(String[] args) {

        Stack stack = new Stack();
        stack.push(6);
        stack.push(4);
        stack.push(8);
        int peekedElement = stack.peek();
        int poppedElement = stack.pop();
        stack.push(69);
        stack.push(73);
        int searchingElementIndex = stack.search(69);
        int stackSize = stack.getSize();

        System.out.println("Peeked element: " + peekedElement +
                "\nPopped element: " + poppedElement +
                "\nSearching element index: " + searchingElementIndex +
                "\nStack size: " + stackSize);

        printStack(stack);

    }
    static void printStack(Stack stack) {
        System.out.print("All stack elements: ");
        for (int i = 0; i < stack.getSize(); i++) {
            System.out.print(stack.get(i) + " ");
        }
    }

    private static class Stack {
        private final List<Integer> list;

        public Stack() {
            this.list = new ArrayList<>();
        }

        public void push(int e) {
            list.add(e);
        }

        public int pop() {
            if (isEmpty()) {
                throw new IllegalArgumentException("Stack is empty");
            }
            int lastElement = list.size() - 1;
            return  list.remove(lastElement);
        }

        public int peek() {
            if (isEmpty()) {
                System.out.println("Stack is empty");
            }
            int lastElement = list.size() - 1;
            return list.get(lastElement);
        }

        public int search(int element) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) == element) {
                    return i;
                }
            }
            return Integer.parseInt(null);
        }

        public int getSize() {
            return list.size();
        }

        public boolean isEmpty() {
            return list.isEmpty();
        }

        public int get(int index) {
            return list.get(index);
        }
    }
}
