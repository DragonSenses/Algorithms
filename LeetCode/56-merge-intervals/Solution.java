import java.util.Arrays;
import java.util.LinkedList;

public class Solution {
  public static int[][] merge(int[][] intervals) {
    // Step 1: Sort the intervals based on the start value
    Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

    // Step 2: Initialize a linked list to hold the merged intervals
    LinkedList<int[]> merged = new LinkedList<>();

    // Step 3: Iterate through the sorted intervals
    for (int[] interval : intervals) {
      // If the list of merged intervals is empty or the current interval does not overlap with the
      // previous one
      if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
        // Append the current interval to the merged list
        merged.add(interval);
      } else {
        // Merge the current interval with the last merged interval
        merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
      }
    }

    // Convert the list to an array before returning
    return merged.toArray(new int[merged.size()][]);
  }
}