import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Solution class for finding starting indices of substrings that are concatenations of all words in
 * the given array.
 */
public class Solution {

  /**
   * Finds the starting indices of all substrings in the string 's' that are concatenations of all
   * words in the given array 'words'.
   *
   * @param s The input string.
   * @param words The array of words.
   * @return A list of starting indices of all concatenated substrings in 's'.
   */
  public List<Integer> findSubstring(String s, String[] words) {
    List<Integer> result = new ArrayList<>();
    if (s == null || words == null || words.length == 0) {
      return result;
    }

    int n = s.length();
    int k = words.length;
    int wordLength = words[0].length();
    int substringSize = wordLength * k;

    // Step 1: Initialize the word count hash table
    Map<String, Integer> wordCount = new HashMap<>();
    for (String word : words) {
      wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
    }

    // Step 3: Check all possible starting indices
    for (int i = 0; i <= n - substringSize; i++) {
      if (check(s, i, wordLength, k, wordCount)) {
        result.add(i);
      }
    }

    return result;
  }

  /**
   * Checks if a valid concatenated substring starts at the given index.
   *
   * @param s The input string.
   * @param start The starting index to check.
   * @param wordLength The length of each word.
   * @param k The number of words.
   * @param wordCount The hash table of word counts.
   * @return True if a valid substring starts at the given index, false otherwise.
   */
  private boolean check(String s, int start, int wordLength, int k,
      Map<String, Integer> wordCount) {
    // Create a copy of wordCount for the current index
    Map<String, Integer> remaining = new HashMap<>(wordCount);
    int wordsUsed = 0;

    // Step 2: Iterate through the substring in groups of wordLength
    for (int j = start; j < start + k * wordLength; j += wordLength) {
      String sub = s.substring(j, j + wordLength);
      if (remaining.containsKey(sub) && remaining.get(sub) > 0) {
        remaining.put(sub, remaining.get(sub) - 1);
        wordsUsed++;
      } else {
        return false;
      }
    }

    return wordsUsed == k;
  }
}
