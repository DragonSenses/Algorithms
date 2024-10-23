import java.util.ArrayList;
import java.util.List;

/**
 * This class provides a solution to the problem of finding all possible
 * combinations of k numbers chosen from the range [1, n].
 */
class Solution {
  List<List<Integer>> output = new ArrayList<>();
  int n;
  int k;

  /**
   * Uses backtracking to generate all possible combinations.
   *
   * @param first The starting number to add to the current combination.
   * @param curr  The current combination being constructed.
   */
  private void backtrack(int first, List<Integer> curr) {
    // If the combination is complete, add it to the output list
    if (curr.size() == k) {
      output.add(new ArrayList<>(curr));
    }

    for (int i = first; i <= n; ++i) {
      // Add i into the current combination
      curr.add(i);

      // Use next integers to complete the combination
      backtrack(i + 1, curr);

      // Remove last element to backtrack
      curr.remove(curr.size() - 1);
    }
  }

  /**
   * Returns all possible combinations of k numbers chosen from the range [1, n].
   *
   * @param n The upper limit of the range.
   * @param k The number of elements in each combination.
   * @return A list of all possible combinations.
   */
  public List<List<Integer>> combine(int n, int k) {
    this.n = n;
    this.k = k;
    backtrack(1, new ArrayList<>());
    return output;
  }
}
