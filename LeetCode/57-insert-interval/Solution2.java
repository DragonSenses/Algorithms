import java.util.ArrayList;
import java.util.List;

class Solution2 {
  public int[][] insert(int[][] intervals, int[] newInterval) {
    List<int[]> result = new ArrayList<>();
    int index = findInsertPosition(intervals, newInterval);
    
    // Insert the newInterval into intervals
    if (index == intervals.length) {
      result.add(newInterval);
    } else {
      result.add(newInterval);
      for (int i = index; i < intervals.length; i++) {
        result.add(intervals[i]);
      }
    }
    
    // Merge overlapping intervals
    List<int[]> merged = new ArrayList<>();
    for (int[] interval : result) {
      int size = merged.size();
      if (size == 0 || merged.get(size - 1)[1] < interval[0]) {
        merged.add(interval);
      } else {
        merged.get(size - 1)[1] = Math.max(merged.get(size - 1)[1], interval[1]);
      }
    }
    
    return merged.toArray(new int[merged.size()][]);
  }

  // Auxiliary function to perform binary search to find the insertion point
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