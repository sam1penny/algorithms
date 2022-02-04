package sorting;

public class QuickSort implements SortingAlgo{
    public static void main(String[] args) {
        SortTesting.test(new QuickSort());
    }

    public static void quicksortSubArray(int[] a, int iBegin, int iEnd) {
        if (iEnd - iBegin < 2) {
            return;
        }
        int iPivot = partition(a, iBegin, iEnd);
        quicksortSubArray(a, iBegin, iPivot);
        quicksortSubArray(a, iPivot + 1, iEnd);

    }

    public static int partition(int[] a, int iBegin, int iEnd) {
        int iPivot = iEnd - 1;
        int iLeft = iBegin;
        int iRight = iPivot;
        int tmp;
        while (iLeft < iRight) {
            while (iLeft < iRight && a[iLeft] <= a[iPivot]) {
                iLeft += 1;
            }
            while (iLeft < iRight && a[iRight - 1] > a[iPivot]) {
                iRight -= 1;
            }
            if (iLeft < iRight) {
                tmp = a[iLeft];
                a[iLeft] = a[iRight - 1];
                a[iRight - 1] = tmp;
                iLeft += 1;
                iRight -= 1;
            }
        }
        tmp = a[iPivot];
        a[iPivot] = a[iRight];
        a[iRight] = tmp;
        iPivot = iRight;
        return iPivot;

    }

    @Override
    public void sort(int[] array) {
        quicksortSubArray(array, 0, array.length);
    }
}
