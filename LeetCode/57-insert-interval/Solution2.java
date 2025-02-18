import java.util.ArrayList;
import java.util.List;

class Solution2 {

  /**
   * Inserts a new interval into a list of non-overlapping intervals and merges any overlapping
   * intervals.
   *
   * @param intervals a sorted list of non-overlapping intervals
   * @param newInterval the new interval to be inserted
   * @return a new list of intervals with the new interval inserted and merged if necessary
   */
  public int[][] insert(int[][] intervals, int[] newInterval) {
    List<int[]> result = new ArrayList<>();

    // Find the correct insertion index for the new interval using binary search
    int index = findInsertPosition(intervals, newInterval);

    // Insert all intervals before the insertion index
    for (int i = 0; i < index; i++) {
      result.add(intervals[i]);
    }

    // Insert the new interval and merge overlapping intervals
    if (result.isEmpty() || result.get(result.size() - 1)[1] < newInterval[0]) {
      result.add(newInterval);
    } else {
      result.get(result.size() - 1)[1] = Math.max(result.get(result.size() - 1)[1], newInterval[1]);
    }

    // Insert the rest of the intervals and merge if necessary
    for (int i = index; i < intervals.length; i++) {
      int[] interval = intervals[i];
      int size = result.size();
      if (result.get(size - 1)[1] < interval[0]) {
        result.add(interval);
      } else {
        result.get(size - 1)[1] = Math.max(result.get(size - 1)[1], interval[1]);
      }
    }

    return result.toArray(new int[result.size()][]);
  }

  /**
   * Auxiliary function to perform binary search to find the correct insertion point for the new
   * interval.
   *
   * @param intervals a sorted list of non-overlapping intervals
   * @param newInterval the new interval to be inserted
   * @return the index at which the new interval should be inserted
   */
  private int findInsertPosition(int[][] intervals, int[] newInterval) {
    int low = 0;
    int high = intervals.length - 1;

    while (low <= high) {
      int mid = low + (high - low) / 2;
      if (intervals[mid][0] < newInterval[0]) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }

    return low;
  }
}
