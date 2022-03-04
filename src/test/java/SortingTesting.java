import net.jqwik.api.Arbitraries;
import net.jqwik.api.Arbitrary;
import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.Provide;
import sorting.BubbleSort;
import sorting.CountingSort;
import sorting.HeapSort;
import sorting.InsertionSort;
import sorting.QuickSort;
import sorting.QuickSortMedianOfMedians;
import sorting.RadixSort;
import sorting.SortingStatistics;

public class SortingTesting {

    @Property
    boolean bubbleSortWorks(@ForAll int[] unsorted) {

        new BubbleSort().sort(unsorted);
        return isSorted(unsorted);
    }

    @Property
    boolean countingSortWorks(@ForAll("positive") int[] unsorted) {
        new CountingSort().sort(unsorted);
        return SortingStatistics.verify(unsorted);
    }
    @Property
    boolean heapSortWorks(@ForAll int[] unsorted) {
        new HeapSort().sort(unsorted);
        return SortingStatistics.verify(unsorted);
    }
    @Property
    boolean insertionSortWorks(@ForAll int[] unsorted) {
        new InsertionSort().sort(unsorted);
        return SortingStatistics.verify(unsorted);
    }
    @Property
    boolean quickSortWorks(@ForAll int[] unsorted) {
        new QuickSort().sort(unsorted);
        return SortingStatistics.verify(unsorted);
    }
    @Property
    boolean radixSortWorks(@ForAll("positive") int[] unsorted) {
        new RadixSort().sort(unsorted);
        return SortingStatistics.verify(unsorted);
    }
    @Property
    boolean quickSortMedianOfMediansWorks(@ForAll int[] unsorted) {
        new QuickSortMedianOfMedians().sort(unsorted);
        return SortingStatistics.verify(unsorted);
    }

    @Provide
    Arbitrary<int[]> positive() {
        return Arbitraries.integers().between(0, 1000).array(int[].class).ofMinSize(2).ofMaxSize(50);
    }


    public static boolean isSorted(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] > a[i+1]) {
                return false;
            }
        }
        return true;
    }



}
