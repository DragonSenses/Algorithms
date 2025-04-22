import java.util.ArrayList;
import java.util.List;

/**
 * Solution class to find the k-th permutation sequence.
 */
class Solution {

  /**
   * Generates the k-th permutation sequence of numbers 1 through n.
   * 
   * @param n The range of numbers (1 to n).
   * @param k The k-th sequence to find.
   * @return The permutation sequence as a string.
   */
  public String getPermutation(int n, int k) {
    // Generate input list with numbers [1, 2, ..., n]
    List<Integer> nums = new ArrayList<>();
    for (int i = 1; i <= n; i++) {
      nums.add(i);
    }

    // Compute factorials from 0! to (N-1)!
    int[] factorials = new int[n + 1];
    factorials[0] = 1;
    for (int i = 1; i <= n; i++) {
      factorials[i] = factorials[i - 1] * i;
    }

    // Convert k to zero-based index
    k--;

    // Build the permutation using factorial representation
    StringBuilder permutation = new StringBuilder();
    for (int i = n; i > 0; i--) {
      // Determine which element to pick
      int index = k / factorials[i - 1];
      // Add selected number to the permutation
      permutation.append(nums.get(index));
      // Remove used element to maintain uniqueness
      nums.remove(index);
      // Update k for next selection
      k %= factorials[i - 1];
    }

    // Return the final permutation sequence
    return permutation.toString();
  }
}
