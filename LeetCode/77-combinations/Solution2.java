import java.util.ArrayList;
import java.util.List;

/**
 * Solution2 class provides a method to generate all possible combinations of k
 * numbers out of the range [1, n] in lexicographic order.
 */
public class Solution2 {

  /**
   * Generates all combinations of k numbers out of the range [1, n].
   *
   * @param n The upper limit of the range.
   * @param k The number of elements in each combination.
   * @return A list of all possible combinations.
   */
  public List<List<Integer>> combine(int n, int k) {
    List<List<Integer>> output = new ArrayList<>(); // List to store all combinations
    int[] nums = new int[k + 1]; // Array to store the current combination and sentinel

    // Initialize the nums array with the first k elements and a sentinel value
    for (int i = 0; i < k; i++) {
      nums[i] = i + 1;
    }
    nums[k] = n + 1; // Sentinel value to mark the end

    int j = 0; // Pointer to traverse the nums array

    // Generate combinations in lexicographic order
    while (j < k) {
      // Collect the first k elements (excluding the sentinel) into a combination
      List<Integer> combination = new ArrayList<>();
      for (int i = 0; i < k; i++) {
        combination.add(nums[i]);
      }
      output.add(combination); // Add the combination to the output list

      // Find the first number in nums that can be incremented
      j = 0;
      while (j < k && nums[j] + 1 == nums[j + 1]) {
        nums[j] = j + 1; // Reset the current number to its smallest possible value
        j++;
      }
      nums[j]++; // Increment the number to move to the next combination
    }
    return output;
  }
}
