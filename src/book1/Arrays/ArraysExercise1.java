package book1.Arrays;

public class ArraysExercise1 {
    public static void main(String[] args) {

        int[] array = new int[] {
                0, 5, 10, 20, 20, 25, 30, 8, 9, 10,
                50, 12, 13, 14, 15, 30, 35, 95, 90, 95
        };
        for (int index = 0; index < array.length; index++){
            if (index * 5 == array[index]){
                System.out.printf("%d ", array[index]);
            }
        }
    }
}
