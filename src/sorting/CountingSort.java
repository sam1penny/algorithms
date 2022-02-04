package sorting;

public class CountingSort implements SortingAlgo {
    public static void main(String[] args) {
        SortTesting.test(new CountingSort());
    }

    @Override
    public void sort(int[] array) {
        int maxnum = 0;
        for (int num: array) {
            maxnum = Math.max(maxnum, num);
        }
        int[] numcount = new int[maxnum+1];
        for (int num: array) {
            numcount[num] += 1;
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
            newarr[startpositions[num]] = num;
            startpositions[num] += 1;
        }

        // copy back into existing array
        for (int i = 0; i < array.length; i++) {
            array[i] = newarr[i];
        }
    }
}
