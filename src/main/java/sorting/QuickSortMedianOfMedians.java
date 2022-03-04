package sorting;

import java.util.Arrays;

public class QuickSortMedianOfMedians implements SortingAlgo{
    public static void main(String[] args) {
        SortingStatistics.test(new QuickSortMedianOfMedians());
    }

    public static int select(int[] array, int low, int high, int k) {
        if (high - low < 10) {
            Arrays.sort(array, low, high);
            int newk = (high - low < 5) ? (high - low) / 2 : k;
            return low + newk;
        }

        int np = (int) Math.ceil((high - low) / 5.);
        int sublow;
        int subhigh;
        int tmp;

        for (int i = 0; i < np; i++) {
            sublow = low + 5*i;
            subhigh = (i+1 == np) ? high: sublow+5;
            int kth = select(array, sublow, subhigh, 2);
            //move median to start of subarray
            tmp = array[low+i];
            array[low+i] = array[kth];
            array[kth] = tmp;
        }

        int pivotToUse = select(array, low, low+np, np / 2);

        //swap pivot to end of array
        tmp = array[pivotToUse];
        array[pivotToUse] = array[high - 1];
        array[high - 1] = tmp;

        //partition here
        int iPivot = QuickSort.partition(array, low, high);
        if (low + k == iPivot) {
            return low + k;
        }
        else if (low + k < iPivot) {
            return select(array, low, iPivot, k);
        }
        else {
            return select(array, iPivot + 1, high, k - (iPivot - low) - 1);
        }
    }

    private void sortWithMedianOfMediansSubarray(int array[], int iBegin, int iEnd) {
        if (iEnd - iBegin < 2) {
            return;
        }

        int medianOfMediansIndex = select(array, iBegin, iEnd, (iEnd - iBegin) / 2);
        int tmp;
        tmp = array[medianOfMediansIndex];
        array[medianOfMediansIndex] = array[iEnd - 1];
        array[iEnd-1] = tmp;

        int iPivot = QuickSort.partition(array, iBegin, iEnd);
        sortWithMedianOfMediansSubarray(array, iBegin, iPivot);
        sortWithMedianOfMediansSubarray(array, iPivot + 1, iEnd);
    }

    @Override
    public void sort(int[] array) {
        sortWithMedianOfMediansSubarray(array, 0, array.length);
    }
}
