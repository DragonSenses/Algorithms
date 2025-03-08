/**
 * This class provides a solution for removing duplicates from a sorted array, allowing a maximum of
 * two occurrences of each element.
 */
public class Solution {

  /**
   * Removes duplicates from a sorted array, allowing at most two occurrences of each element.
   * Modifies the array in place and returns the length of the modified array.
   *
   * @param nums The sorted array of integers.
   * @return The length of the modified array after removing unwanted duplicates.
   */
  public int removeDuplicates(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }

    // Initialize pointers i and j
    int i = 1, j = 1;

    // Initialize variable count to track the number of occurrences of each element
    int count = 1;

    // Iterate through the array
    while (i < nums.length) {
      if (nums[i] == nums[i - 1]) {
        // Increment count if the current element is the same as the previous element
        count++;
      } else {
        // Reset count to 1 if the current element is different
        count = 1;
      }

      // If count is <= 2, overwrite unwanted duplicates
      if (count <= 2) {
        nums[j] = nums[i];
        j++;
      }

      // Move to the next element
      i++;
    }

    // Return the length of the modified array
    return j;
  }
}
