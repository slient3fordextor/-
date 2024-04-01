package MathNum;

import java.util.Arrays;

public class Solution2 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int[][] result = new int[intervals.length][2];
        int index = -1;
        for (int i = 0; i < intervals.length; i++) {
            int[] cur = intervals[i];
            if (index == -1 || cur[0] > result[index][1]) {
                index++;
                result[index] = cur;
            } else {
                result[index][1] = Math.max(result[index][1], cur[1]);
            }
        }
        return Arrays.copyOf(result, index + 1);
    }
}
