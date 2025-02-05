import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Solution class to find starting indices of all concatenated substrings in a given string.
 */
class Solution {
  // HashMap to store the count of each word in the words array
  private HashMap<String, Integer> wordCount = new HashMap<>();
  private int wordLength;
  private int substringSize;
  private int k;

  /**
   * Checks if a valid concatenated substring starts at index i in the given string s.
   *
   * @param i the starting index to check
   * @param s the given string
   * @return true if a valid concatenated substring starts at index i, otherwise false
   */
  private boolean check(int i, String s) {
    // Copy the original word count for this particular index
    HashMap<String, Integer> remaining = new HashMap<>(wordCount);
    int wordsUsed = 0;

    // Each iteration will check for a match in words
    for (int j = i; j < i + substringSize; j += wordLength) {
      // Extract the substring of wordLength starting from index j
      String sub = s.substring(j, j + wordLength);
      // Check if the substring exists in the remaining words and its count is greater than 0
      if (remaining.getOrDefault(sub, 0) != 0) {
        remaining.put(sub, remaining.get(sub) - 1);
        wordsUsed++;
      } else {
        break;
      }
    }

    // Return true if all words are used to form a valid substring, otherwise false
    return wordsUsed == k;
  }

  /**
   * Finds all starting indices of concatenated substrings in the given string s.
   *
   * @param s the given string
   * @param words the array of words
   * @return the list of starting indices of concatenated substrings
   */
  public List<Integer> findSubstring(String s, String[] words) {
    List<Integer> indices = new ArrayList<>();
    // Edge case handling
    if (words.length == 0 || words[0].length() == 0 || s.length() == 0) {
      return indices;
    }

    // Initialize wordCount, wordLength, substringSize, and k
    wordCount = new HashMap<>();
    wordLength = words[0].length();
    k = words.length;
    substringSize = wordLength * k;

    // Populate the wordCount hashmap with the frequency of each word
    for (String word : words) {
      wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
    }

    // Iterate over each possible starting point in the string `s`
    for (int i = 0; i < s.length() - substringSize + 1; i++) {
      if (check(i, s)) {
        indices.add(i);
      }
    }

    return indices;
  }
}
