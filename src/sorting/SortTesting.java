package sorting;

import java.util.Random;


public class SortTesting {

    private static final int size = 10000;
    private static final int min = 0;
    private static final int max = 1000;


    public static boolean verify(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] > a[i+1]) {
                return false;
            }
        }
        return true;
    }

    public static void test(SortingAlgo s) {
        int[] a = new Random().ints(size, min, max).toArray();
        long startTime = System.nanoTime();
        s.sort(a);
        long elapsedTime = System.nanoTime() - startTime;
        System.out.println("------------------New Test------------------");
        System.out.println(String.format("Test statistics: length = %d, minimum int = %d, maximum int = %d", size, min, max));
        System.out.println("Test result: " + (verify(a) ? "passed!" : "failed!"));
        System.out.println(String.format("ElapsedTime: %d ms", elapsedTime / 1000));
    }
}
