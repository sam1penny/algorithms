package sorting;

public class InsertionSort implements SortingAlgo{
    public static void main(String[] args) {
        SortTesting.test(new InsertionSort());
    }

    @Override
    public void sort(int[] array) {
        for (int i = 1; i < array.length; i++) {

             int j = i;
             int tmp;
             while (j >= 1 && array[j-1] > array[j]) {
                 tmp = array[j];
                 array[j] = array[j-1];
                 array[j-1] = tmp;
                 j -= 1;
             }

        }
    }
}
