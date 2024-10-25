import java.util.ArrayList;
import java.util.List;

/**
 * The Solution class provides a method to generate all possible subsets (the
 * power set) of a given integer array.
 */
class Solution {

  /**
   * Generates all subsets of the given integer array.
   *
   * @param nums The input array of unique integers.
   * @return A list of all possible subsets.
   */
  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> output = new ArrayList<>(); // List to store all subsets
    int n = nums.length; // Length of the input array

    // Iterate over the range to generate all bitmasks from 0..00 to 1..11
    for (int i = (int) Math.pow(2, n); i < (int) Math.pow(2, n + 1); ++i) {
      // Generate bitmask, from 0..00 to 1..11
      String bitmask = Integer.toBinaryString(i).substring(1);

      // Append subset corresponding to that bitmask
      List<Integer> curr = new ArrayList<>();
      for (int j = 0; j < n; ++j) {
        if (bitmask.charAt(j) == '1') {
          curr.add(nums[j]);
        }
      }
      output.add(curr); // Add the current subset to the output list
    }
    return output;
  }
}
