package exercises.dataStructures;

public class CreateQueue {
    public static void main(String[] args) {

        Queue queue = new Queue(5);

        queue.offer(73);
        queue.offer(2);
        queue.offer(8);
        queue.offer(4);
        queue.offer(5);
        int firstPolled = queue.poll();
        int size = queue.getSize();
        queue.offer(6);
        queue.poll();
        queue.offer(10);
        int containsThisNum = 66;
        boolean contains = queue.contains(containsThisNum);

        printQueue(queue.getArr());
        System.out.println("\nFirst polled num is: " + firstPolled);
        System.out.println("The Queue size to '6' including is: " + size);

        System.out.println("Is contains: " + containsThisNum + " -> " + contains);

        String descending = "Descending";
        String ascending = "Ascending";

        int[] sortedArr = queue.sort(descending);
        System.out.println("Here is a Descending sort arr: ");
        printQueue(sortedArr);

        System.out.println();

        sortedArr = queue.sort(ascending);
        System.out.println("Here is a Ascending sort arr: ");
        printQueue(sortedArr);


    }

    public static void printQueue(int[] arr) {
        for (int k : arr) {
            System.out.print(k + " ");
        }
    }
    public static class Queue {
        private int[] arr;
        private final int length;
        private int top;

        public Queue(int length) {
            this.length = length;
            this.arr = new int[length];
            this.top = 0;
        }

        public int[] getArr() {
            return arr;
        }

        public void offer(int x) {
            if (isFull()) {
                System.out.println("Queue is Full");
                return;
            }
            arr[top++] += x;
        }

        public int poll() {
            if (isEmpty()) {
                System.out.println("Queue is Empty");
            }
            int removedElement = arr[0];
            arr = removeFirstElement();
            top--;
            return removedElement;
        }
        public int[] sort(String ascendingOrDescending) {
            int Index;
            if (ascendingOrDescending.equals("Ascending")) {
                for (int i = 0; i < arr.length - 1; i++) {
                    Index = i;

                    for (int j = i + 1; j < arr.length; j++) {
                        if (arr[j] < arr[Index]) {
                            Index = j;
                        }
                        int temp = arr[Index];
                        arr[Index] = arr[i];
                        arr[i] = temp;
                    }
                }
                return arr;

            } else if (ascendingOrDescending.equals("Descending")) {
                for (int i = 0; i < arr.length - 1; i++) {
                    Index = i;

                    for (int j = i + 1; j < arr.length; j++) {
                        if (arr[j] > arr[Index]) {
                            Index = j;
                        }
                        int temp = arr[Index];
                        arr[Index] = arr[i];
                        arr[i] = temp;
                    }
                }
                return arr;
            }
            return getArr();
        }

        public boolean contains(int element) {
            for (int k : arr) {
                if (k == element) {
                    return true;
                }
            }
            return false;
        }

        public int getSize() {
            return top;
        }

        public boolean isEmpty() {
            return top < 0;
        }

        public boolean isFull() {
            return top == length;
        }

        public int[] removeFirstElement() {
            int[] secondArr = new int[length];
            int k = 0;
            for (int i = 0; i < arr.length; i++) {
                if (i != k) {
                    secondArr[i - 1] = arr[i];
                }
            }
            return secondArr;
        }
    }
}
