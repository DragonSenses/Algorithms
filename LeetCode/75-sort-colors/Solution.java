public class Solution {

  /**
   * Sorts the given array in-place so that objects of the same color are
   * adjacent, with the colors in the order red, white, and blue.
   *
   * @param nums The array of integers representing the colors.
   */
  public static void sortColors(int[] nums) {
    // Initialize pointers for boundaries
    int p0 = 0, curr = 0;
    int p2 = nums.length - 1;

    // Traverse the array
    while (curr <= p2) {
      if (nums[curr] == 0) {
        // Swap current element with the element at p0
        int temp = nums[p0];
        nums[p0] = nums[curr];
        nums[curr] = temp;
        p0++;
        curr++;
      } else if (nums[curr] == 2) {
        // Swap current element with the element at p2
        int temp = nums[p2];
        nums[p2] = nums[curr];
        nums[curr] = temp;
        p2--;
      } else {
        curr++;
      }
    }
  }
}