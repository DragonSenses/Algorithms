/**
 * Class to find the minimum number of operations required to convert word1 to word2.
 * The operations allowed are insertion, deletion, and replacement.
 */
class Solution {
  
  /**
   * Finds the minimum number of operations required to convert word1 to word2.
   * 
   * @param word1 the source string to be transformed.
   * @param word2 the target string to transform into.
   * @return the minimum number of operations required.
   */
  public int minDistance(String word1, String word2) {
    return computeEditDistance(word1, word2, word1.length(), word2.length());
  }

  /**
   * Recursive auxiliary function to compute the edit distance.
   * 
   * @param word1 the source string to be transformed.
   * @param word2 the target string to transform into.
   * @param word1Index the current index in the source string.
   * @param word2Index the current index in the target string.
   * @return the minimum number of operations required.
   */
  private int computeEditDistance(String word1, String word2, int word1Index, int word2Index) {
    // Base Case 1: If word1 is empty, return the number of characters left in word2
    if (word1Index == 0) {
      return word2Index;
    }

    // Base Case 2: If word2 is empty, return the number of characters left in word1
    if (word2Index == 0) {
      return word1Index;
    }

    // If characters at the current position match, move to the next position
    if (word1.charAt(word1Index - 1) == word2.charAt(word2Index - 1)) {
      return computeEditDistance(word1, word2, word1Index - 1, word2Index - 1);
    } else {
      // If characters do not match, consider all three operations
      int insertOperation = computeEditDistance(word1, word2, word1Index, word2Index - 1) + 1;
      int deleteOperation = computeEditDistance(word1, word2, word1Index - 1, word2Index) + 1;
      int replaceOperation = computeEditDistance(word1, word2, word1Index - 1, word2Index - 1) + 1;

      // Return the minimum of the three operations
      return Math.min(insertOperation, Math.min(deleteOperation, replaceOperation));
    }
  }
}
