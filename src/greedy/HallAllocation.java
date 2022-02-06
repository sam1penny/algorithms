package greedy;

import java.util.Arrays;

public class HallAllocation {
    public static class Timing implements Comparable<Timing>{
        public final int start;
        public final int end;

        Timing(int start, int end) {
            this.start = start;
            this.end = end;
        }

        // sort by finishing time
        @Override
        public int compareTo(Timing o) {
            return end - o.end;
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
        //Timing[] ts = new Timing[]{new Timing(4, 9), new Timing(3, 7), new Timing(7, 9)};
        System.out.println(greedy(ts));
    }

    public static int greedy(Timing[] timings) {
        Arrays.sort(timings);
        int s = 0;
        int cnt = 0;
        for (int i = 0; i < timings.length; i++) {
            if (s > timings[i].start) {
                continue;
            }
            s = timings[i].end;
            cnt += 1;
        }
        return cnt;
    }
}
