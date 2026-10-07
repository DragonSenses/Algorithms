/**
 * Finds all starting indices in s where the substring is an
 * anagram of p. An anagram is defined by identical character
 * frequency counts, regardless of ordering.
 *
 * Uses a fixed-size sliding window and two frequency arrays
 * to compare character counts in O(n) time.
 *
 * @param s Main string to search
 * @param p Pattern whose anagrams should be located
 * @returns Array of starting indices where an anagram of p occurs
 */
function findAnagrams(s: string, p: string): number[] {
  // Collect all valid starting indices
  const result: number[] = [];

  // If s is shorter than p, no anagram can exist
  if (s.length < p.length) return result;

  // Frequency arrays for pattern p and sliding window
  const pCount = new Array(26).fill(0);
  const windowCount = new Array(26).fill(0);

  // Populate pCount with character frequencies of p
  for (const c of p) {
    pCount[c.charCodeAt(0) - 97]++;
  }

  // Fixed window size equal to length of p
  const windowSize = p.length;

  // Slide window across s
  for (let i = 0; i < s.length; i++) {
    // Add current character to window frequency
    windowCount[s.charCodeAt(i) - 97]++;

    // Remove leftmost character once window exceeds size
    if (i >= windowSize) {
      windowCount[s.charCodeAt(i - windowSize) - 97]--;
    }

    // Compare window frequencies with p frequencies
    let match = true;
    for (let j = 0; j < 26; j++) {
      if (windowCount[j] !== pCount[j]) {
        match = false;
        break;
      }
    }

    // Record starting index if anagram found
    if (match) {
      result.push(i - windowSize + 1);
    }
  }

  return result;
};