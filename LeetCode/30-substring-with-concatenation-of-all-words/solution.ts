/**
 * Finds the starting indices of all substrings in the string `s` that are concatenations of all
 * words in the given array `words`.
 *
 * @param s - The input string.
 * @param words - The array of words.
 * @returns A list of starting indices of all concatenated substrings in `s`.
 */
function findSubstring(s: string, words: string[]): number[] {
  // Initialize result array to hold starting indices of valid substrings.
  const result: number[] = [];

  // Return empty result if input string or words array is empty.
  if (!s || words.length === 0) {
    return result;
  }

  // Length of input string `s`.
  const n = s.length;

  // Number of words in `words` array.
  const k = words.length;

  // Length of each word (assumed to be the same for all words).
  const wordLength = words[0].length;

  // Total length of the concatenated substring (all words combined).
  const substringSize = wordLength * k;

  // Hash table to count occurrences of each word in `words` array.
  const wordCount: { [key: string]: number } = {};
  for (const word of words) {
    wordCount[word] = (wordCount[word] || 0) + 1;
  }

  /**
   * Checks if a valid concatenated substring starts at the given index.
   *
   * @param start - The starting index to check.
   * @returns True if a valid substring starts at the given index, false otherwise.
   */
  const check = (start: number): boolean => {
    // Create a copy of wordCount for the current index.
    const remaining: { [key: string]: number } = { ...wordCount };
    let wordsUsed = 0;

    // Iterate through the substring in groups of wordLength.
    for (let j = start; j < start + k * wordLength; j += wordLength) {
      const sub = s.substr(j, wordLength);
      if (remaining[sub] && remaining[sub] > 0) {
        remaining[sub]--;
        wordsUsed++;
      } else {
        return false;
      }
    }

    return wordsUsed === k;
  };

  // Check all possible starting indices.
  for (let i = 0; i <= n - substringSize; i++) {
    if (check(i)) {
      result.push(i);
    }
  }

  // Return the result array containing all valid starting indices.
  return result;
}
