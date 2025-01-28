public class Solution3 {
  public boolean isMatch(String text, String pattern) {
    int n = text.length();
    int m = pattern.length();

    // Define the Table
    boolean[][] dp = new boolean[n + 1][m + 1];

    // Initialize Base Cases
    dp[n][m] = true;

    // Fill the Table
    for (int i = n; i >= 0; i--) {
      for (int j = m - 1; j >= 0; j--) {
        boolean firstMatch =
            (i < n && (pattern.charAt(j) == text.charAt(i) || pattern.charAt(j) == '.'));

        if (j + 1 < m && pattern.charAt(j + 1) == '*') {
          dp[i][j] = dp[i][j + 2] || (firstMatch && dp[i + 1][j]);
        } else {
          dp[i][j] = firstMatch && dp[i + 1][j + 1];
        }
      }
    }

    // Return Result
    return dp[0][0];
  }
}
