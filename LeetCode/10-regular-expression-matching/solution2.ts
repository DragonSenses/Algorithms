function isMatch(s: string, p: string): boolean {
  const memo: { [key: string]: boolean } = {};

  // Recursive function to check if text[i:] matches pattern[j:]
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

    memo[key] = result;
    return result;
  }

  return dp(0, 0);
}