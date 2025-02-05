/**
 * Finds all starting indices of concatenated substrings in the given string `s`
 * that match any permutation of the words in `words`.
 *
 * @param s - The input string to search within.
 * @param words - The array of words to concatenate and search for.
 * @returns An array of starting indices of concatenated substrings.
 */
function findSubstring(s: string, words: string[]): number[] {
  const indices: number[] = [];

  // Edge case handling: return empty array if any input condition is invalid
  if (words.length === 0 || words[0].length === 0 || s.length === 0) {
    return indices;
  }

  // Initialize variables
  const wordCount: { [key: string]: number } = {};
  const wordLength = words[0].length;
  const k = words.length;
  const substringSize = wordLength * k;

  // Populate the wordCount hashmap with the frequency of each word
  for (const word of words) {
    wordCount[word] = (wordCount[word] || 0) + 1;
  }

  /**
   * Checks if a valid concatenated substring starts at index `i` in the given string `s`.
   *
   * @param i - The starting index to check.
   * @returns `true` if a valid concatenated substring starts at index `i`, otherwise `false`.
   */
  function check(i: number): boolean {
    const remaining = { ...wordCount }; // Copy the original word count for this index
    let wordsUsed = 0;

    // Iterate through the substring and check for matching words
    for (let j = i; j < i + substringSize; j += wordLength) {
      const sub = s.substring(j, j + wordLength);
      if (remaining[sub] != null && remaining[sub] > 0) {
        remaining[sub] -= 1;
        wordsUsed += 1;
      } else {
        return false; // Break the loop if the word is not found or count is zero
      }
    }

    return wordsUsed === k; // Return true if all words are used
  }

  // Iterate over each possible starting point in the string `s`
  for (let i = 0; i <= s.length - substringSize; i++) {
    if (check(i)) {
      indices.push(i); // Add the starting index to the result if valid
    }
  }

  return indices;
}
