import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2 {

  /**
   * Generates all combinations of well-formed parentheses using the
   * divide-and-conquer approach.
   *
   * @param n the number of pairs of parentheses
   * @return a list of all combinations of well-formed parentheses
   */
  public List<String> generateParenthesis(int n) {
    // Base case
    if (n == 0) {
      return new ArrayList<>(Arrays.asList(""));
    }

    List<String> result = new ArrayList<>();

    // Iterate over possible splits
    for (int open_count = 0; open_count < n; open_count++) {
      // Generate left and right subproblems
      for (String leftPart : generateParenthesis(open_count)) {
        for (String rightPart : generateParenthesis(n - open_count - 1)) {
          // Construct valid strings
          result.add("(" + leftPart + ")" + rightPart);
        }
      }
    }

    // Return result
    return result;
  }
}
