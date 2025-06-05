const memo = new Map<string, boolean>();

function isScramble(s1: string, s2: string): boolean {
  // Base case: identical strings are trivially scrambled
  if (s1 === s2) return true;

  // If lengths differ, it's impossible for s2 to be a scrambled version of s1
  if (s1.length !== s2.length) return false;

  // Generate a unique memoization key based on both strings
  const key = `${s1}_${s2}`;

  // Return precomputed result if available
  if (memo.has(key)) return memo.get(key)!;

  // If character frequencies mismatch, s2 cannot be a scrambled version of s1
  if (!hasMatchingCharacterCounts(s1, s2)) {
    memo.set(key, false);
    return false;
  }

  const n = s1.length;

  for (let len = 1; len < n; len++) {
    if (isScrambleNoSwap(s1, s2, len) || isScrambleWithSwap(s1, s2, len)) {
      memo.set(key, true);
      return true;
    }
  }

  // Store result in memoization and return false if no valid scramble is found
  memo.set(key, false);
  return false;
}

function hasMatchingCharacterCounts(s1: string, s2: string): boolean {
  const count = new Array(26).fill(0); // Frequency array to compare character counts

  // Count frequency of characters in both strings
  for (let i = 0; i < s1.length; i++) {
    count[s1.charCodeAt(i) - 97]++; // Increment frequency for s1
    count[s2.charCodeAt(i) - 97]--; // Decrement frequency for s2
  }

  // If character frequencies mismatch, s2 cannot be a scrambled version of s1
  return !count.some((c) => c !== 0);
}

function isScrambleNoSwap(s1: string, s2: string, len: number): boolean {
  return (
    isScramble(s1.substring(0, len), s2.substring(0, len)) &&
    isScramble(s1.substring(len), s2.substring(len))
  );
}

function isScrambleWithSwap(s1: string, s2: string, len: number): boolean {
  const n = s1.length;
  return (
    isScramble(s1.substring(0, len), s2.substring(n - len)) &&
    isScramble(s1.substring(len), s2.substring(0, n - len))
  );
}
