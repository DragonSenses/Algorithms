import java.util.ArrayList;
import java.util.List;

/**
 * Solution class to generate all combinations of well-formed parentheses.
 */
public class Solution {

  /**
   * Generates all combinations of well-formed parentheses for a given number of
   * pairs.
   *
   * @param n the number of pairs of parentheses
   * @return a list of strings, each string representing a valid combination of
   *         parentheses
   */
  public List<String> generateParenthesis(int n) {
    List<String> result = new ArrayList<>();
    // Start the backtracking process with an empty string and zero counts for open
    // and close parentheses
    backtrack(result, "", 0, 0, n);
    return result;
  }

  /**
   * Helper method to perform backtracking to generate valid parentheses
   * combinations.
   *
   * @param result  the list to store all valid combinations
   * @param current the current string being built
   * @param open    the number of open parentheses used so far
   * @param close   the number of close parentheses used so far
   * @param max     the total number of pairs of parentheses
   */
  private void backtrack(List<String> result, String current, int open, int close, int max) {
    // Base case: if the current string has reached the maximum length (2 * max),
    // add it to the result list
    if (current.length() == max * 2) {
      result.add(current);
      return;
    }

    // If the number of open parentheses is less than the maximum allowed, add an
    // open parenthesis and recurse
    if (open < max) {
      backtrack(result, current + "(", open + 1, close, max);
    }

    // If the number of close parentheses is less than the number of open
    // parentheses, add a close parenthesis and recurse
    if (close < open) {
      backtrack(result, current + ")", open, close + 1, max);
    }
  }
}
