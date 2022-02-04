package sorting;

public class BubbleSort implements SortingAlgo{
    public static void main(String[] args) {
        SortTesting.test(new BubbleSort());
    }
    @Override
    public void sort(int[] array) {
        boolean swapped = true;
        int tmp;
        while (swapped) {
            swapped = false;
            for (int k = 0; k < array.length - 1; k++) {
                if (array[k+1] < array[k]) {
                    tmp = array[k];
                    array[k] = array[k+1];
                    array[k+1] = tmp;
                    swapped = true;
                }
            }
        }
    }
}
