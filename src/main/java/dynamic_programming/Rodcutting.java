package dynamic_programming;

public class Rodcutting {
    public static void main(String[] args) {
        int[] costs = new int[] {0, 1, 5, 8, 9, 10, 17, 17, 20, 24, 30, 29, 32, 35, 30, 20, 43, 43};
        System.out.println(Rodcutting.dp(costs, 1));
        for (int x = 1; x < costs.length; x++) {
            long startTime = System.nanoTime();
            int dpans = dp(costs, x);
            long elapsedTime = System.nanoTime() - startTime;
            System.out.println("Dynamic program time (ms): " + (double) elapsedTime / 1000000);
            startTime = System.nanoTime();
            int bfans = bruteforce(costs, x);
            elapsedTime = System.nanoTime() - startTime;
            System.out.println("Brute force program time (ms): " + (double) elapsedTime / 1000000);
            System.out.println("answer (dp): " + dpans + ", answer (bf): " + bfans);
        }
    }

    public static int dp(int[] costs, int i) {
        int[] optimals = new int[i+1];
        for (int j = 1; j <= i; j++) {
            int max =Integer.MIN_VALUE;
            for (int k = 1; k <= j; k++) {
                max = Math.max(max, costs[k] + optimals[j - k]);
            }
            optimals[j] = max;
        }
        return optimals[i];
    }

    //assume costs input includes costs[0] = 0
    public static int bruteforce(int[] costs, int i) {
        if (i == 0) {
            return 0;
        }
        int max = 0;
        for (int x = 1; x <= i; x++) {
            max = Math.max(max, costs[x]  + bruteforce(costs, i - x));
        }
        return max;
    }
}
