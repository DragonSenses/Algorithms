import java.util.HashMap;
import java.util.Map;

public class Solution2 {
  // Memoization table to store results of subproblems
  private final Map<String, Boolean> memo = new HashMap<>();

  /**
   * Main method to initiate the matching process.
   * @param text The input text string to be matched.
   * @param pattern The pattern string, which can include '.' and '*' as special characters.
   * @return Returns true if the text matches the pattern, false otherwise.
   */
  public boolean isMatch(String text, String pattern) {
    return dp(0, 0, text, pattern);
  }

  /**
   * Recursive function to check if text[i:] matches pattern[j:].
   * This function uses dynamic programming memoization to optimize the recursive approach.
   * @param i The current index in the text string.
   * @param j The current index in the pattern string.
   * @param text The input text string.
   * @param pattern The pattern string.
   * @return Returns true if the substring matches, false otherwise.
   */
  private boolean dp(int i, int j, String text, String pattern) {
    // Create a unique key for the current state
    String key = i + "," + j;

    // Check if the result for this state is already in the memoization table
    if (memo.containsKey(key)) {
      return memo.get(key);
    }

    // Base case: if pattern is exhausted, check if text is also exhausted
    if (j == pattern.length()) {
      return i == text.length();
    }

    // Check if the first character matches
    boolean firstMatch = (i < text.length() && (pattern.charAt(j) == text.charAt(i) || pattern.charAt(j) == '.'));

    boolean result;
    // Handle the '*' wildcard
    if (j + 1 < pattern.length() && pattern.charAt(j + 1) == '*') {
      // Consider two cases: ignoring '*' or using '*' to match one or more characters
      result = (dp(i, j + 2, text, pattern) || (firstMatch && dp(i + 1, j, text, pattern)));
    } else {
      // No '*', proceed to the next characters
      result = firstMatch && dp(i + 1, j + 1, text, pattern);
    }

    // Store the result in the memoization table
    memo.put(key, result);
    return result;
  }
}
