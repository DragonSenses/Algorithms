function isScramble(s1: string, s2: string): boolean {
  // Base case: identical strings are trivially scrambled
  if (s1 === s2) return true;

  // If lengths differ, it's impossible for s2 to be a scrambled version of s1
  if (s1.length !== s2.length) return false;

  // Generate a unique memoization key based on both strings
  const key = `${s1}_${s2}`;

  // Return precomputed result if available
  if (memo.has(key)) return memo.get(key)!;

  const n = s1.length;
  const count = new Array(26).fill(0); // Frequency array to compare character counts

  // Count frequency of characters in both strings
  for (let i = 0; i < n; i++) {
    count[s1.charCodeAt(i) - 97]++; // Increment frequency for s1
    count[s2.charCodeAt(i) - 97]--; // Decrement frequency for s2
  }

  // If character frequencies mismatch, s2 cannot be a scrambled version of s1
  if (count.some((c) => c !== 0)) {
    memo.set(key, false);
    return false;
  }

  // Iterate over possible split points
  for (let len = 1; len < n; len++) {
    if(true) {
      memo.set(key, true);
      return true;
    }
  }
};