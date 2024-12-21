function minDistance(word1: string, word2: string): number {
  return computeEditDistance(word1, word2, word1.length, word2.length);
};

function computeEditDistance(
  word1: string,
  word2: string,
  word1Index: number,
  word2Index: number
): number {
  // Base Case 1: If word1 is empty, return the number of characters left in word2
  if (word1Index === 0) {
    return word2Index;
  }

  // Base Case 2: If word2 is empty, return the number of characters left in word1
  if (word2Index === 0) {
    return word1Index;
  }

  // If characters at the current position match, move to the next position
  if (word1[word1Index - 1] === word2[word2Index - 1]) {
    return computeEditDistance(word1, word2, word1Index - 1, word2Index - 1);
  } else {
    // If characters do not match, consider all three operations
    const insertOperation =
      computeEditDistance(word1, word2, word1Index, word2Index - 1) + 1;
    const deleteOperation =
      computeEditDistance(word1, word2, word1Index - 1, word2Index) + 1;
    const replaceOperation =
      computeEditDistance(word1, word2, word1Index - 1, word2Index - 1) + 1;

    // Return the minimum of the three operations
    return Math.min(
      insertOperation,
      Math.min(deleteOperation, replaceOperation)
    );
  }
};
