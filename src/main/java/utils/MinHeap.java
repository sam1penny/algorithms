package utils;

public class MinHeap<T extends Comparable<T>> {

    private T[] array;
    private int iEnd;

    public MinHeap() {
        this.array = (T[]) new Comparable[5];
        this.iEnd = 0;
    }

    public MinHeap(T[] arr) {
        this.array = (T[]) new Comparable[arr.length];
        this.iEnd = 0;
        for (T tree : arr) {
            insert(tree);
        }

    }

    private void doubleSize() {
        if (array.length == 0) {
            array = (T[]) new Comparable[1];
            return;
        }

        T[] newArray = (T[]) new Comparable[array.length * 2];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }

    public void insert(T e) {
        if (iEnd == array.length) {
            doubleSize();
        }

        array[iEnd] = e;
        int iChild = iEnd;
        int iParent = (iChild - 1) / 2;
        T tmp;
        while (iParent >= 0 && array[iParent].compareTo(array[iChild]) > 0) {
            tmp = array[iParent];
            array[iParent] = array[iChild];
            array[iChild] = tmp;

            iChild = iParent;
            iParent = (iChild - 1) / 2;
        }
        iEnd++;
    }

    public int length() {
        return iEnd;
    }

    public T popMin() {
        if (iEnd == 0) {
            return null;
        }

        T popped = array[0];
        array[0] = array[--iEnd];

        heapify_range(iEnd, 0);

        return popped;
    }

    private void heapify_range(int iEnd, int iRoot) {
        int j = iRoot;
        int l = 2 * iRoot + 1;
        int r = 2 * iRoot + 2;
        if (l < iEnd && array[j].compareTo(array[l]) > 0) {
            j = l;
        }
        if (r < iEnd && array[j].compareTo(array[r]) > 0) {
            j = r;
        }
        if (j != iRoot) {
            T tmp = array[iRoot];
            array[iRoot] = array[j];
            array[j] = tmp;
            heapify_range(iEnd, j);
        }
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < iEnd; i++) {
            s.append(array[i]).append(",");
        }
        return s.toString();
    }

}
