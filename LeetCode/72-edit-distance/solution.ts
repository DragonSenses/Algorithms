/**
 * Calculates the minimum number of operations required to convert one word to another.
 * The allowed operations are insertion, deletion, and replacement.
 *
 * @param {string} word1 - The source string to be transformed.
 * @param {string} word2 - The target string to transform into.
 * @returns {number} The minimum number of operations required.
 */
function minDistance(word1: string, word2: string): number {
  // Initialize the memoization table with -1
  const memo: number[][] = Array.from({ length: word1.length + 1 }, () => Array(word2.length + 1).fill(-1));
  return computeEditDistance(word1, word2, word1.length, word2.length, memo);
}

/**
 * Recursive auxiliary function to compute the edit distance between two words.
 *
 * @param {string} word1 - The source string to be transformed.
 * @param {string} word2 - The target string to transform into.
 * @param {number} word1Index - The current index in the source string.
 * @param {number} word2Index - The current index in the target string.
 * @param {number[][]} memo - A 2-dimensional array to cache results of sub-problems.
 * @returns {number} The minimum number of operations required.
 */
function computeEditDistance(
  word1: string,
  word2: string,
  word1Index: number,
  word2Index: number,
  memo: number[][]
): number {
  // Base Case 1: If word1 is empty, return the number of characters left in word2
  if (word1Index === 0) {
    return word2Index;
  }

  // Base Case 2: If word2 is empty, return the number of characters left in word1
  if (word2Index === 0) {
    return word1Index;
  }

  // Check if result is already cached
  if (memo[word1Index][word2Index] !== -1) {
    return memo[word1Index][word2Index];
  }

  // If characters at the current position match, move to the next position
  if (word1[word1Index - 1] === word2[word2Index - 1]) {
    memo[word1Index][word2Index] = computeEditDistance(word1, word2, word1Index - 1, word2Index - 1, memo);
  } else {
    // If characters do not match, consider all three operations
    const insertOperation = computeEditDistance(word1, word2, word1Index, word2Index - 1, memo) + 1;
    const deleteOperation = computeEditDistance(word1, word2, word1Index - 1, word2Index, memo) + 1;
    const replaceOperation = computeEditDistance(word1, word2, word1Index - 1, word2Index - 1, memo) + 1;

    // Return the minimum of the three operations
    memo[word1Index][word2Index] = Math.min(insertOperation, Math.min(deleteOperation, replaceOperation));
  }

  return memo[word1Index][word2Index];
}
