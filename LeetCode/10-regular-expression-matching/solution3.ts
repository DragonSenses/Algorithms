/**
 * Determines if a given text matches a given pattern.
 * This function employs dynamic programming with an iterative, bottom-up 
 * tabulation approach
 *
 * @param s The input text string to be matched.
 * @param p The pattern string, which can include '.' and '*' as special characters.
 * @return Returns true if the text matches the pattern, false otherwise.
 */
function isMatch(s: string, p: string): boolean {
  const n = s.length;
  const m = p.length;

  // Define the Table for dynamic programming
  const dp: boolean[][] = Array.from({ length: n + 1 }, () =>
    Array(m + 1).fill(false)
  );

  // Initialize Base Cases
  dp[n][m] = true; // An empty pattern matches an empty text

  // Fill the Table with the bottom-up approach
  for (let i = n; i >= 0; i--) {
    for (let j = m - 1; j >= 0; j--) {
      // Check if the current characters match
      const firstMatch = i < n && (p[j] === s[i] || p[j] === ".");

      // Handle the '*' wildcard character
      if (j + 1 < m && p[j + 1] === "*") {
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
