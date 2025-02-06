import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Solution class to find starting indices of all concatenated substrings in a given string.
 */
class Solution2 {
  private int wordLength;
  private int k;

  /**
   * Finds all starting indices of concatenated substrings in the given string s.
   *
   * @param s the given string
   * @param words the array of words
   * @return the list of starting indices of concatenated substrings
   */
  public List<Integer> findSubstring(String s, String[] words) {
    List<Integer> indices = new ArrayList<>();
    if (words.length == 0 || words[0].length() == 0 || s.length() == 0) {
      return indices;
    }

    // Initialize wordLength and k
    wordLength = words[0].length();
    k = words.length;

    // Populate the wordCount map with the frequency of each word
    Map<String, Integer> wordCount = new HashMap<>();
    for (String word : words) {
      wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
    }

    // Iterate over each possible starting point in the string `s`
    for (int i = 0; i < wordLength; i++) {
      slidingWindow(i, s, wordCount, indices);
    }

    return indices;
  }

  /**
   * Applies a sliding window approach to find valid starting indices.
   *
   * @param start the starting index for the sliding window
   * @param s the given string
   * @param wordCount the map containing word frequencies
   * @param indices the list of starting indices of concatenated substrings
   */
  private void slidingWindow(int start, String s, Map<String, Integer> wordCount,
      List<Integer> indices) {
    Map<String, Integer> currentCount = new HashMap<>();
    int wordsUsed = 0;
    int left = start;

    // Iterate over the string `s` in steps of wordLength
    for (int right = start; right + wordLength <= s.length(); right += wordLength) {
      String sub = s.substring(right, right + wordLength);

      // If the word is part of the words array
      if (wordCount.containsKey(sub)) {
        currentCount.put(sub, currentCount.getOrDefault(sub, 0) + 1);
        wordsUsed++;

        // If there are more occurrences of "sub" than needed, slide the window to the right
        while (currentCount.get(sub) > wordCount.get(sub)) {
          String leftWord = s.substring(left, left + wordLength);
          currentCount.put(leftWord, currentCount.get(leftWord) - 1);
          wordsUsed--;
          left += wordLength;
        }

        // If all words are used, record the starting index
        if (wordsUsed == k) {
          indices.add(left);
        }
      } else {
        // Reset the window if the word is not part of the words array
        currentCount.clear();
        wordsUsed = 0;
        left = right + wordLength;
      }
    }
  }
}
