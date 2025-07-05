import java.util.Arrays;

/**
 * This solution uses a sorting and linear scan approach.
 * After sorting the array, any duplicates will appear consecutively.
 * A single pass is then used to compare adjacent elements.
 */
public class Solution2 {

  /**
   * Determines whether the input array contains any duplicate integers.
   *
   * Time Complexity: O(n log n) due to sorting.
   * Space Complexity: O(1) assuming in-place sort.
   *
   * @param nums the input array of integers
   * @return true if a duplicate element is found; false otherwise
   */
  public boolean containsDuplicate(int[] nums) {
    // Sort the array so duplicates become adjacent
    Arrays.sort(nums);

    // Scan the sorted array for any adjacent duplicates
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] == nums[i - 1]) {
        return true; // Found a duplicate
      }
    }

    // No duplicates found
    return false;
  }
}