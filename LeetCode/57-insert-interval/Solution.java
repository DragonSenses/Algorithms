import java.util.ArrayList;
import java.util.List;

/**
 * The Solution class provides a method to insert a new interval into an array of non-overlapping
 * intervals, merging overlapping intervals if necessary.
 */
class Solution {

  /**
   * Inserts a new interval into a list of non-overlapping intervals, merging overlapping intervals
   * if necessary.
   *
   * @param intervals The array of non-overlapping intervals, sorted in ascending order by start
   *        value.
   * @param newInterval The new interval to be inserted, represented by a start and end value.
   * @return The array of intervals after inserting the new interval, sorted in ascending order by
   *         start value, with no overlapping intervals.
   */
  public int[][] insert(int[][] intervals, int[] newInterval) {
    List<int[]> result = new ArrayList<>();
    int i = 0, n = intervals.length;

    // Step 1: Insert all intervals before newInterval
    while (i < n && intervals[i][1] < newInterval[0]) {
      result.add(intervals[i]);
      i++;
    }

    // Step 2: Merge newInterval with overlapping intervals
    while (i < n && intervals[i][0] <= newInterval[1]) {
      newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
      newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
      i++;
    }
    result.add(newInterval); // Add the merged interval

    // Step 3: Add remaining intervals after newInterval
    while (i < n) {
      result.add(intervals[i]);
      i++;
    }

    // Convert list to array
    return result.toArray(new int[result.size()][]);
  }
}
