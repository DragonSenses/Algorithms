/**
 * Finds all starting indices of concatenated substrings in the given string.
 *
 * @param s - The input string to search in.
 * @param words - The array of words to form concatenated substrings.
 * @returns An array of starting indices of the concatenated substrings.
 */
function findSubstring(s: string, words: string[]): number[] {
  const indices: number[] = [];
  if (words.length === 0 || words[0].length === 0 || s.length === 0) {
    return indices;
  }

  const wordLength = words[0].length; // Length of each word
  const k = words.length; // Total number of words
  const wordCount: Map<string, number> = new Map();

  // Populate the wordCount map with the frequency of each word
  for (const word of words) {
    wordCount.set(word, (wordCount.get(word) || 0) + 1);
  }

  // Iterate over each possible starting point in the string `s`
  for (let i = 0; i < wordLength; i++) {
    slidingWindow(i, s, wordCount, indices, wordLength, k);
  }

  return indices;
}

/**
 * Applies a sliding window approach to find valid starting indices.
 *
 * @param start - The starting index for the sliding window.
 * @param s - The input string to search in.
 * @param wordCount - The map containing word frequencies.
 * @param indices - The list of starting indices of concatenated substrings.
 * @param wordLength - The length of each word.
 * @param k - The total number of words.
 */
function slidingWindow(
  start: number,
  s: string,
  wordCount: Map<string, number>,
  indices: number[],
  wordLength: number,
  k: number
): void {
  const currentCount: Map<string, number> = new Map();
  let wordsUsed = 0; // Count of words used in the current window
  let left = start; // Left pointer for the sliding window

  // Iterate over the string `s` in steps of wordLength
  for (let right = start; right + wordLength <= s.length; right += wordLength) {
    const sub = s.substring(right, right + wordLength);

    // If the word is part of the words array
    if (wordCount.has(sub)) {
      currentCount.set(sub, (currentCount.get(sub) || 0) + 1);
      wordsUsed++;

      // If there are more occurrences of "sub" than needed, slide the window to the right
      while ((currentCount.get(sub) || 0) > (wordCount.get(sub) || 0)) {
        const leftWord = s.substring(left, left + wordLength);
        currentCount.set(leftWord, (currentCount.get(leftWord) || 0) - 1);
        wordsUsed--;
        left += wordLength;
      }

      // If all words are used, record the starting index
      if (wordsUsed === k) {
        indices.push(left);
      }
    } else {
      // Reset the window if the word is not part of the words array
      currentCount.clear();
      wordsUsed = 0;
      left = right + wordLength;
    }
  }
}
