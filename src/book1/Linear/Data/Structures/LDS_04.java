package book1.Linear.Data.Structures;

import java.util.ArrayList;
import java.util.List;

public class LDS_04 {
    public static void main(String[] args) {

        /*Write a method that finds the longest subsequence of equal numbers in a given List<int> and
        returns the result as new List<int>. Write a program to test whether the method works correctly.*/

        ArrayList<Integer> listOfIntegers = new ArrayList<>();
        listOfIntegers.add(66);
        listOfIntegers.add(12);
        listOfIntegers.add(6);
        listOfIntegers.add(6);
        listOfIntegers.add(6);
        listOfIntegers.add(3);
        listOfIntegers.add(3);
        listOfIntegers.add(9);
        listOfIntegers.add(9);
        listOfIntegers.add(9);
        listOfIntegers.add(9);

        longestSubsequence(listOfIntegers);

    }
    public static void longestSubsequence(List<Integer> list) {

        int position = 0;
        int bestPosition = 0;
        int count = 1;
        int bestCount = 0;
        ArrayList<Integer> listOfSequenceElements = new ArrayList<>();

        for (int i = 1; i < list.size(); i++) {

            if (list.get(i).equals(list.get(i - 1))) {
                count++;
                position = i;
                if (count > bestCount) {
                    bestCount = count;
                    bestPosition = position;
                }
            } else {
                count = 1;
                position = 0;
            }
        }
        int startPosition = bestPosition - bestCount + 1;
        int endPosition = startPosition + bestCount;

        for (int i = startPosition; i < endPosition; i++) {
            listOfSequenceElements.add(list.get(i));
        }

        for (int current : listOfSequenceElements) {
            System.out.print(current + " ");
        }
    }
}
