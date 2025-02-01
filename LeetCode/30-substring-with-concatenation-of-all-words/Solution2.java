import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Solution to find all starting indices of substring(s) in a given string `s` that is a
 * concatenation of each word in given list `words` exactly once and without any intervening
 * characters.
 */
public class Solution2 {

  /**
   * Finds all starting indices of substring(s) in `s` that is a concatenation of each word in
   * `words` exactly once and without any intervening characters.
   *
   * @param s the string to search in.
   * @param words the list of words to concatenate.
   * @return a list of starting indices of concatenated substrings.
   */
  public List<Integer> findSubstring(String s, String[] words) {
    List<Integer> answer = new ArrayList<>();
    if (s == null || words == null || words.length == 0) {
      return answer;
    }

    int n = s.length();
    int k = words.length;
    int wordLength = words[0].length();
    int substringSize = wordLength * k;

    // Early exit if the remaining string length is less than the substring size
    if (n < substringSize) {
      return answer;
    }

    // Initialize the word count hash table
    Map<String, Integer> wordCount = new HashMap<>();
    for (String word : words) {
      wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
    }

    // Iterate over each possible starting index in the string
    for (int i = 0; i < wordLength; i++) {
      slidingWindow(i, n, wordLength, k, substringSize, s, wordCount, answer);
    }

    return answer;
  }

  /**
   * Uses a sliding window approach to find all valid substrings starting from a given index.
   *
   * @param left the starting index of the window.
   * @param n the length of the string `s`.
   * @param wordLength the length of each word.
   * @param k the number of words.
   * @param substringSize the size of the concatenated substring.
   * @param s the string to search in.
   * @param wordCount a map with the count of each word in `words`.
   * @param answer a list to store starting indices of valid substrings.
   */
  private void slidingWindow(int left, int n, int wordLength, int k, int substringSize, String s,
      Map<String, Integer> wordCount, List<Integer> answer) {

    // HashMap to track words found in the current window
    Map<String, Integer> wordsFound = new HashMap<>();
    int wordsUsed = 0;
    boolean excessWord = false;

    // Slide the window over the string
    for (int right = left; right <= n - wordLength; right += wordLength) {
      // Extract the current word
      String sub = s.substring(right, right + wordLength);

      // If the word is not in the word count, reset the window
      if (!wordCount.containsKey(sub)) {
        wordsFound.clear();
        wordsUsed = 0;
        excessWord = false;
        left = right + wordLength;
      } else {
        // Adjust the window to fit within the substring size
        while (right - left == substringSize || excessWord) {
          String leftmostWord = s.substring(left, left + wordLength);
          left += wordLength;
          int count = wordsFound.get(leftmostWord);
          if (count == wordCount.get(leftmostWord)) {
            wordsUsed--;
          }
          wordsFound.put(leftmostWord, count - 1);
          if (count - 1 < wordCount.get(leftmostWord)) {
            excessWord = false;
          }
        }
        // Add the current word to the words found
        wordsFound.put(sub, wordsFound.getOrDefault(sub, 0) + 1);
        if (wordsFound.get(sub) <= wordCount.get(sub)) {
          wordsUsed++;
        } else {
          excessWord = true;
        }

        // Check if all words are used and there is no excess word
        if (wordsUsed == k && !excessWord) {
          answer.add(left);
        }
      }
    }
  }
}
