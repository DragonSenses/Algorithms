/**
 * Compares two frequency maps for exact key-value equality.
 *
 * Two maps are considered equal when:
 * - They contain the same number of keys.
 * - Every key exists in both maps.
 * - Every key maps to the same frequency value.
 *
 * @param a First frequency map
 * @param b Second frequency map
 * @returns True if both maps contain identical key-value pairs;
 *          otherwise, false
 */
function mapsEqual(
  a: Map<string, number>,
  b: Map<string, number>
): boolean {
  if (a.size !== b.size) return false;

  for (const [key, val] of a) {
    if (b.get(key) !== val) return false;
  }

  return true;
}

/**
 * Finds all starting indices of p's anagrams in s using a
 * fixed-size sliding window and frequency maps.
 *
 * The algorithm maintains:
 * - A frequency map for the pattern string p.
 * - A frequency map for the current window in s.
 *
 * As the window moves, character frequencies are updated
 * incrementally. Whenever the two frequency maps match,
 * the current window is an anagram of p.
 *
 * @param s The string to search
 * @param p The pattern whose anagrams should be located
 * @returns An array containing the starting indices of all
 *          anagrams of p found within s
 */
function findAnagrams(s: string, p: string): number[] {
  const result: number[] = [];

  // An anagram cannot exist if the pattern is longer than the input.
  if (s.length < p.length) return result;

  // Reference frequencies for p.
  const pCount: Map<string, number> = new Map();

  // Frequencies for the current sliding window in s.
  const sCount: Map<string, number> = new Map();

  // Build the reference frequency map.
  for (const c of p) {
    pCount.set(c, (pCount.get(c) ?? 0) + 1);
  }

  const windowSize = p.length;

  // Slide a fixed-length window across s.
  for (let i = 0; i < s.length; i++) {
    // Add the newest character entering the window.
    const rightChar = s[i];
    sCount.set(rightChar, (sCount.get(rightChar) ?? 0) + 1);

    // Remove the oldest character once the window exceeds its size.
    if (i >= windowSize) {
      const leftChar = s[i - windowSize];
      const newCount = (sCount.get(leftChar) ?? 0) - 1;

      if (newCount === 0) {
        sCount.delete(leftChar);
      } else {
        sCount.set(leftChar, newCount);
      }
    }

    // Matching frequency maps indicate an anagram.
    if (mapsEqual(sCount, pCount)) {
      result.push(i - windowSize + 1);
    }
  }

  return result;
}
