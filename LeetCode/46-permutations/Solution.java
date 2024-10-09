import java.util.ArrayList;
import java.util.List;

/**
 * This class provides methods for generating all permutations of an array of
 * integers
 * using backtracking.
 */
public class Solution {

  /**
   * Generates all permutations of the given array of integers.
   *
   * @param nums the array of integers to permute
   * @return a list of all permutations
   */
  public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    backtrack(nums, 0, result);
    return result;
  }

  /**
   * Helper method to generate permutations using backtracking.
   *
   * @param nums   the array of integers to permute
   * @param first  the index of the first integer to consider for the current
   *               permutation
   * @param result the list to store all permutations
   */
  private void backtrack(int[] nums, int first, List<List<Integer>> result) {
    // Base case: If the first integer to consider has index equal to the length of
    // nums, the current permutation is complete.
    if (first == nums.length) {
      List<Integer> currentPermutation = new ArrayList<>();
      for (int num : nums) {
        currentPermutation.add(num);
      }
      result.add(currentPermutation);
      return;
    }

    // Iterate over the integers from index 'first' to the end of the array
    for (int i = first; i < nums.length; i++) {
      // Swap the current index with the 'first' index to place the i-th integer first
      // in the permutation
      swap(nums, first, i);
      // Recursively generate permutations for the next position
      backtrack(nums, first + 1, result);
      // Backtrack by undoing the swap
      swap(nums, first, i);
    }
  }

  /**
   * Swaps two elements in the given array.
   *
   * @param nums the array of integers
   * @param i    the index of the first element to swap
   * @param j    the index of the second element to swap
   */
  private void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }
}
