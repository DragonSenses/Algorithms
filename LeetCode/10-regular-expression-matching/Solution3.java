public class Solution3 {

  /**
   * Main method to initiate the matching process, which determines if a given text matches a given
   * pattern. This function employs dynamic programming with an iterative, bottom-up tabulation
   * method
   * 
   * @param text The input text string to be matched.
   * @param pattern The pattern string, which can include '.' and '*' as special characters.
   * @return Returns true if the text matches the pattern, false otherwise.
   */
  public boolean isMatch(String text, String pattern) {
    int n = text.length();
    int m = pattern.length();

    // Define the Table for dynamic programming
    boolean[][] dp = new boolean[n + 1][m + 1];

    // Initialize Base Cases
    dp[n][m] = true; // An empty pattern matches an empty text

    // Fill the Table with the bottom-up approach
    for (int i = n; i >= 0; i--) {
      for (int j = m - 1; j >= 0; j--) {
        // Check if the current characters match
        boolean firstMatch =
            (i < n && (pattern.charAt(j) == text.charAt(i) || pattern.charAt(j) == '.'));

        // Handle the '*' wildcard character
        if (j + 1 < m && pattern.charAt(j + 1) == '*') {
          // Consider two cases: ignoring '*' or using '*' to match one or more characters
          dp[i][j] = dp[i][j + 2] || (firstMatch && dp[i + 1][j]);
        } else {
          // No '*', proceed to the next characters
          dp[i][j] = firstMatch && dp[i + 1][j + 1];
        }
      }
    }

    // Return the result of the matching process
    return dp[0][0];
  }
}
