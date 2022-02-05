package dynamic_programming;

import java.util.Arrays;

public class HallAllocation {
    public static class Timing implements Comparable<Timing>{
        public final int start;
        public final int end;

        Timing(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Timing o) {
            if (start != o.start) {
                return start - o.start;
            }
            else {
                return end - o.end;
            }
        }

        @Override
        public String toString() {
            return "[" + start + "," + end + "]";
        }
    }

    public static void main(String[] args) {
        Timing[] ts = new Timing[]{new Timing(0, 4), new Timing(1, 2), new Timing(2, 4), new Timing(3, 6),
                new Timing(3, 6), new Timing(3, 6), new Timing(5, 8),
                new Timing(7, 9), new Timing(8, 11), new Timing(9, 12),
                new Timing(9, 12), new Timing(9, 12), new Timing(12, 15)};
        //Timing[] ts = new Timing[]{new Timing(5, 7), new Timing(4, 10), new Timing(4, 9)};
        Arrays.sort(ts);
        System.out.println(dp(ts));

    }

    public static int dp(Timing[] timings) {
        int mx = 0;
        for (Timing t: timings) {
            mx = Math.max(mx, t.start);
        }
        int[][] dp = new int[timings.length][mx+1];
        //set default value
        for (int i = 0; i < timings.length; i++) {
            for (int j = 0; j < mx+1; j++) {
                dp[i][j] = -1;
            }
        }
        return dpHelper(timings, 0, 0, dp);
    }

    public static int dpHelper(Timing[] timings, int i, int s, int[][] dp) {
        // timings is required to be sorted for this to work
        if (i == timings.length) {
            return 0;
        }
        if (dp[i][s] != -1) {
            return dp[i][s];
        }
        else {
            if (s > timings[i].start) {
                dp[i][s] = dpHelper(timings, i+1, s, dp);
            }
            else {
                dp[i][s] = Math.max(dpHelper(timings, i+1, s, dp), 1 + dpHelper(timings, i+1, timings[i].end, dp));
            }
            return dp[i][s];
        }
    }

}
