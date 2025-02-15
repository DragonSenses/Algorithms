import java.util.ArrayList;
import java.util.List;

class Solution {
  public int[][] insert(int[][] intervals, int[] newInterval) {
    List<int[]> result = new ArrayList<>();
    int i = 0;
    int n = intervals.length;

    // Add all intervals that come before the new interval
    while (i < n && intervals[i][1] < newInterval[0]) {
        result.add(intervals[i]);
        i++;
    }

    // Merge all overlapping intervals with the new interval
    while (i < n && intervals[i][0] <= newInterval[1]) {
        newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
        newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
        i++;
    }
    result.add(newInterval);

    // Add all intervals that come after the new interval
    while (i < n) {
        result.add(intervals[i]);
        i++;
    }

    return result.stream().mapToInt(Integer::intValue).toArray();
  }
}
