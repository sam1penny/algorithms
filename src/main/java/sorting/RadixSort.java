package sorting;

import java.util.Arrays;

public class RadixSort implements SortingAlgo {
    public static void main(String[] args) {
        SortingStatistics.test(new RadixSort());
    }

    @Override
    public void sort(int[] array) {
        int maxNum = Arrays.stream(array).max().getAsInt();
        int dignum = 0;
        while (maxNum > 0) {
            maxNum /= 10;
            dignum += 1;
        }
        int unit = 1;
        for (int i = 0; i < dignum; i++){
            modifiedCountingSort(array, unit, 10);
        unit *= 10;
        }
    }


    public static void modifiedCountingSort(int[] array, int unit, int range) {
        int[] numcount = new int[range];
        for (int num: array) {
            numcount[num / unit % range] += 1;
        }



        int spos = 0;
        int tmp;
        int[] startpositions = numcount;
        for (int i = 0; i < numcount.length; i++) {
            tmp = numcount[i];
            numcount[i] = spos;
            spos += tmp;
        }

        int[] newarr = new int[array.length];
        for (int num: array) {
            newarr[startpositions[num / unit % range]] = num;
            startpositions[num / unit % range] += 1;
        }

        // copy back into existing array
        for (int i = 0; i < array.length; i++) {
            array[i] = newarr[i];
        }
    }
}
