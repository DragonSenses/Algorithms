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
    const index = Math.floor(k / factorials[i - 1]);
  }
};