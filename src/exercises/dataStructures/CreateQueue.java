package exercises.dataStructures;

import java.util.ArrayList;
import java.util.List;

public class CreateQueue {
    public static void main(String[] args) {

        Queue queue = new Queue();

        queue.offer(6);
        queue.offer(4);
        queue.offer(8);
        queue.offer(63);
        int pooledElement = queue.pool();
        int peekedElement = queue.peek();

        System.out.println("Pooled element is: " + pooledElement +
                "\nPeeked element is: " + peekedElement);

        printQueue(queue);
    }
    private static void printQueue(Queue queue) {
        System.out.print("Here is all Queue elements: ");
        for (int i = 0; i < queue.getSize(); i++) {
            System.out.print(queue.get(i) + " ");
        }
    }

    public static class Queue {
        private final List<Integer> list;

        public Queue() {
            this.list = new ArrayList<>();
        }

        public void offer(int x) {
            list.add(x);
        }

        public int pool() {
            if (isEmpty()) {
                throw new IllegalArgumentException("Queue is empty");
            }
            return list.remove(0);
        }
        public int peek() {
            if (isEmpty()) {
                throw new IllegalArgumentException("Queue is empty");
            }
            return list.get(0);
        }

        public boolean isEmpty() {
            return list.isEmpty();
        }

        public int getSize() {
            return list.size();
        }

        public int get(int index) {
            return list.get(index);
        }
    }
}
