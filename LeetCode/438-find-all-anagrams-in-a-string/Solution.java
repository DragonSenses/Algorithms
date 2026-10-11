import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Provides a method to find all start indices of anagrams of p within s.
 *
 * <p>An anagram is defined by identical character frequencies. This method
 * uses a fixed-size sliding window and frequency arrays to detect matches
 * in linear time.
 *
 * <p>Constraints:
 * - s and p contain only lowercase English letters.
 * - Returns indices in any order.
 */
class Solution {

  /**
   * Finds all starting indices in s where the substring is an anagram of p.
   *
   * @param s the main string to search
   * @param p the pattern whose anagrams we want to locate
   * @return a list of starting indices where an anagram of p occurs in s
   */
  public List<Integer> findAnagrams(String s, String p) {

    // Result list to store all valid starting indices
    List<Integer> result = new ArrayList<>();

    // If s is shorter than p, no anagram can exist
    if (s.length() < p.length())
      return result;

    // Frequency arrays for pattern p and current sliding window
    int[] pCount = new int[26];
    int[] windowCount = new int[26];

    // Populate pCount with character frequencies of p
    for (char c : p.toCharArray()) {
      pCount[c - 'a']++;
    }

    // Fixed window size equal to length of p
    int windowSize = p.length();

    // Slide window across s
    for (int i = 0; i < s.length(); i++) {

      // Add current character to window frequency
      windowCount[s.charAt(i) - 'a']++;

      // Once window exceeds size, remove leftmost character
      if (i >= windowSize) {
        windowCount[s.charAt(i - windowSize) - 'a']--;
      }

      // Compare window frequencies with p frequencies
      if (Arrays.equals(windowCount, pCount)) {
        // Record starting index of valid anagram
        result.add(i - windowSize + 1);
      }
    }

    // Return all collected indices
    return result;
  }
}
