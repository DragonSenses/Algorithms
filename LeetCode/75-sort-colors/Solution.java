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
      switch (nums[curr]) {
        case 0:
          // Swap current element with the element at p0
          int temp0 = nums[p0];
          nums[p0] = nums[curr];
          nums[curr] = temp0;
          p0++;
          curr++;
          break;
        case 2:
          // Swap current element with the element at p2
          int temp2 = nums[p2];
          nums[p2] = nums[curr];
          nums[curr] = temp2;
          p2--;
          break;
        default:
          curr++;
          break;
      }
    }
  }
}