package dynamic_programming;


public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String word1 = "amputation";
        String word2 = "sprain";
        long startTime = System.nanoTime();
        int ans = topDown(word1, word2);
        long elapsedTime = System.nanoTime() - startTime;
        System.out.println("Top down result: " + ans + ", Elapsed time: " + (double) elapsedTime / 1000000);
        startTime = System.nanoTime();
        ans = bottomUp(word1, word2);
        elapsedTime = System.nanoTime() - startTime;
        System.out.println("Bottom up result: " + ans + ", Elapsed time: " + (double) elapsedTime / 1000000);
    }


    public static int topDown(String s1, String s2) {
        int[][] dp = new int[s1.length()][s2.length()];
        //set to default value of -1
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        return topDownHelper(s1.toCharArray(), s2.toCharArray(), s1.length()-1, s2.length()-1, dp);
    }

    private static int topDownHelper(char[] x, char[] y, int i, int j, int[][] dp) {
        if (i < 0 || j < 0) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        else {
            int t;
            if (x[i] == y[j]) {
                t = 1 + topDownHelper(x, y, i - 1, j - 1, dp);
            } else {
                t = Math.max(topDownHelper(x, y, i - 1, j, dp), topDownHelper(x, y, i, j - 1, dp));
            }
            dp[i][j] = t;
            return dp[i][j];
        }
    }

    public static int bottomUp(char[] x, char[] y) {
        int[][] dp = new int[x.length][y.length];
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < y.length; j++) {
                if (x[i] == y[j]) {
                    //dp[i][j] = 1 + dp[i-1][j-1];
                    dp[i][j] = 1 + getWithDefault(dp, i-1, j-1, 0);
                }
                else {
                    dp[i][j] = Math.max(getWithDefault(dp, i-1, j, 0), getWithDefault(dp, i, j-1, 0));
                }
            }
        }
        return dp[x.length-1][y.length-1];
    }

    public static int bottomUp(String s1, String s2) {
        return bottomUp(s1.toCharArray(), s2.toCharArray());
    }

    private static int getWithDefault(int[][] array, int y, int x, int defaultValue) {
        if (y < 0 || y >= array.length || x < 0 || x >= array[0].length) {
            return defaultValue;
        }
        return array[y][x];
    }
}
