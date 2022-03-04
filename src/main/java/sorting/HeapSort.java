package sorting;

public class HeapSort implements SortingAlgo {
    public static void main(String[] args) {
        SortingStatistics.test(new HeapSort());
    }

    public void sort(int[] a) {
        for (int k = a.length / 2 - 1; k >= 0; k--) {
            heapify(a, a.length, k);
        }
        int temp;
        for (int k = a.length; k > 1; k--) {
            temp = a[0];
            a[0] = a[k - 1];
            a[k - 1] = temp;
            heapify(a, k - 1, 0);
        }

    }

    public static void heapify(int[] arr, int iEnd, int iRoot) {
        int j = iRoot;
        int l = 2 * iRoot + 1;
        int r = 2 * iRoot + 2;
        if (l < iEnd && arr[j] < arr[l]) {
            j = l;
        }
        if (r < iEnd && arr[j] < arr[r]) {
            j = r;
        }

        if (j != iRoot) {
            int tmp = arr[iRoot];
            arr[iRoot] = arr[j];
            arr[j] = tmp;
            heapify(arr, iEnd, j);
        }
    }
}
