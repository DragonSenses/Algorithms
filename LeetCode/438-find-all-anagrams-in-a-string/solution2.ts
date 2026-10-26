/**
 * Compares two maps for exact key-value equality.
 */
function mapsEqual(a: Map<string, number>, b: Map<string, number>): boolean {
  if (a.size !== b.size) return false;

  for (const [key, val] of a) {
    if (b.get(key) !== val) return false;
  }

  return true;
}

function findAnagrams(s: string, p: string): number[] {
  const result: number[] = [];

  // If s is shorter than p, no anagram can exist
  if (s.length < p.length) return result;

  // Frequency map for pattern p
  const pCount: Map<string, number> = new Map();
  // Frequency map for current sliding window
  const sCount: Map<string, number> = new Map();

  // Build reference frequency map for p
  for (const c of p) {
    pCount.set(c, (pCount.get(c) ?? 0) + 1);
  }

  const windowSize = p.length;

  // Slide window across s
  for (let i = 0; i < s.length; i++) {
    const rightChar = s[i];
    sCount.set(rightChar, (sCount.get(rightChar) ?? 0) + 1);

    // Remove leftmost char once window exceeds size
    if (i >= windowSize) {
      const leftChar = s[i - windowSize];
      const newCount = (sCount.get(leftChar) ?? 0) - 1;

      if (newCount === 0) {
        sCount.delete(leftChar);
      } else {
        sCount.set(leftChar, newCount);
      }
    }

  }

}
