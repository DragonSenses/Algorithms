/**
 * Determines if a given text matches a given pattern.
 * This function uses dynamic programming memoization to optimize the recursive approach.
 *
 * @param s - The input text string to be matched.
 * @param p - The pattern string, which can include '.' and '*' as special characters.
 * @returns {boolean} - Returns true if the text matches the pattern, false otherwise.
 */
function isMatch(s: string, p: string): boolean {
  // Memoization table to store results of subproblems
  const memo: { [key: string]: boolean } = {};

  /**
   * Recursive function to check if text[i:] matches pattern[j:].
   * @param i - The current index in the text string.
   * @param j - The current index in the pattern string.
   * @returns {boolean} - Returns true if the substring matches, false otherwise.
   */
  function dp(i: number, j: number): boolean {
    // Create a unique key for the current state
    const key = `${i},${j}`;

    // Check if the result for this state is already in the memoization table
    if (key in memo) {
      return memo[key];
    }

    // Base case: if pattern is exhausted, check if text is also exhausted
    if (j === p.length) {
      return i === s.length;
    }

    // Check if the first character matches
    const firstMatch = i < s.length && (p[j] === s[i] || p[j] === ".");

    let result: boolean;
    // Handle the '*' wildcard
    if (j + 1 < p.length && p[j + 1] === "*") {
      // Consider two cases: ignoring '*' or using '*' to match one or more characters
      result = dp(i, j + 2) || (firstMatch && dp(i + 1, j));
    } else {
      // No '*', proceed to the next characters
      result = firstMatch && dp(i + 1, j + 1);
    }

    // Store the result in the memoization table
    memo[key] = result;
    return result;
  }

  // Start the recursion from the beginning of the text and pattern
  return dp(0, 0);
}
