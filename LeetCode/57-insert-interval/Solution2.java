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

    // Step 1: Insert the newInterval into the correct position in the result list
    if (index == intervals.length) {
      // If index is equal to the length of intervals, append newInterval to the end
      result.add(newInterval);
    } else {
      // Otherwise, insert newInterval at the found index and append remaining intervals
      result.add(newInterval);
      for (int i = index; i < intervals.length; i++) {
        result.add(intervals[i]);
      }
    }

    // Step 2: Merge overlapping intervals in the result list
    List<int[]> merged = new ArrayList<>();
    for (int[] interval : result) {
      int size = merged.size();
      if (size == 0 || merged.get(size - 1)[1] < interval[0]) {
        // If merged list is empty or current interval does not overlap with the last interval, add
        // it to merged list
        merged.add(interval);
      } else {
        // If current interval overlaps with the last interval in the merged list, update the end of
        // the last interval
        merged.get(size - 1)[1] = Math.max(merged.get(size - 1)[1], interval[1]);
      }
    }

    // Convert the merged list to an array and return it
    return merged.toArray(new int[merged.size()][]);
  }

  /**
   * Helper function to perform binary search to find the correct insertion point for the new
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
        // Move to the right half if the middle interval's start is less than newInterval's start
        low = mid + 1;
      } else {
        // Move to the left half if the middle interval's start is greater than or equal to
        // newInterval's start
        high = mid - 1;
      }
    }

    // Return the insertion index
    return low;
  }
}
