package sorting;

import java.util.Arrays;

public class InsertionSort implements SortingAlgo{
    public static void main(String[] args) {
        SortTesting.test(new InsertionSort());
    }

    @Override
    public void sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
             int j = i - 1;
             int tmp = array[i];
             while (j >= 0 && array[j] > tmp) {
                 array[j+1] = array[j];
                 j -= 1;
             }
             array[j+1] = tmp;
        }
    }
}
