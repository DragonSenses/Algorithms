/**
 * Generates the k-th permutation sequence of numbers 1 through n.
 *
 * @param n The range of numbers (1 to n).
 * @param k The k-th sequence to find.
 * @return The permutation sequence as a string.
 */
function getPermutation(n: number, k: number): string {
  // Generate input array with numbers [1, 2, ..., n]
  const nums: number[] = Array.from({ length: n }, (_, i) => i + 1);

  // Compute factorials from 0! to (n-1)!
  const factorials: number[] = [1];
  for (let i = 1; i <= n; i++) {
    factorials[i] = factorials[i - 1] * i;
  }

  // Convert k to zero-based index
  k--;

  // Build the permutation using factorial representation
  let result = "";
  for (let i = n; i > 0; i--) {
    // Determine which element to pick
    const index = Math.floor(k / factorials[i - 1]);
    // Append selected number
    result += nums[index];
    // Remove used element to maintain uniqueness
    nums.splice(index, 1);
    // Update k for next selection
    k %= factorials[i - 1];
  }

  return result;
};