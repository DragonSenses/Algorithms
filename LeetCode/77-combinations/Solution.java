import java.util.ArrayList;
import java.util.List;

/**
 * This class provides a solution to the problem of finding all possible
 * combinations of k numbers chosen from the range [1, n].
 */
class Solution {
  /**
   * Returns all possible combinations of k numbers chosen from the range [1, n].
   *
   * @param n The upper limit of the range.
   * @param k The number of elements in each combination.
   * @return A list of all possible combinations.
   */
  public List<List<Integer>> combine(int n, int k) {
    List<List<Integer>> output = new ArrayList<>();
    backtrack(1, n, k, new ArrayList<>(), output);
    return output;
  }

  /**
   * Uses backtracking to generate all possible combinations.
   *
   * @param start  The starting number to add to the current combination.
   * @param n      The upper limit of the range.
   * @param k      The number of elements in each combination.
   * @param curr   The current combination being constructed.
   * @param output The list to store all possible combinations.
   */
  private void backtrack(int start, int n, int k, List<Integer> curr, List<List<Integer>> output) {
    // If the combination is complete, add it to the output list
    if (curr.size() == k) {
      output.add(new ArrayList<>(curr));
      return;
    }

    // Iterate over the range from `start` to `n`
    for (int i = start; i <= n; ++i) {
      // Add i into the current combination
      curr.add(i);

      // Use next integers to complete the combination
      backtrack(i + 1, n, k, curr, output);

      // Remove last element to backtrack
      curr.remove(curr.size() - 1);
    }
  }
}
