package book1.Arrays;

public class SeriesOfIdenticalElements {
    public static void main(String[] args) {

        int[] array = {2, 1, 1, 1, 1, 1, 2, 3, 3, 3, 3, 3, 3, 2, 1};
        int maxCurrnt = array[0];
        int maxCount = 1;

        int max = maxCurrnt;
        int count = 1;

        for (int index = 1; index < array.length; index++) {
            if (max == array[index]){
                count += 1;
            }else {
                if (count > maxCount){
                    maxCount = count;
                    maxCurrnt = max;
                }
                count = 1;
            }
            max = array[index];
        }
        for (int i = 0; i < maxCount; i++){
            System.out.print(maxCurrnt + " ");
        }
    }
}
