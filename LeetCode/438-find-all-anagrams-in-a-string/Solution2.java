import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Finds all starting indices of p's anagrams in s using a
 * fixed-size sliding window and frequency maps.
 *
 * <p>The algorithm maintains:
 * <ul>
 *   <li>A frequency map for the pattern string p.</li>
 *   <li>A frequency map for the current window in s.</li>
 * </ul>
 *
 * <p>As the window moves, character frequencies are updated
 * incrementally. Whenever the two frequency maps match, the
 * current window is an anagram of p.
 */
public class Solution2 {

  /**
   * Returns all starting indices where an anagram of p appears in s.
   *
   * @param s the string to search
   * @param p the pattern whose anagrams should be located
   * @return a list of starting indices of all anagrams of p in s
   */
  public List<Integer> findAnagrams(String s, String p) {
    List<Integer> result = new ArrayList<>();

    // An anagram cannot exist if the pattern is longer than the input.
    if (s.length() < p.length()) {
      return result;
    }

    // Reference frequencies for p.
    Map<Character, Integer> pCount = new HashMap<>();

    // Frequencies for the current sliding window in s.
    Map<Character, Integer> sCount = new HashMap<>();

    // Build the reference frequency map.
    for (char c : p.toCharArray()) {
      pCount.put(c, pCount.getOrDefault(c, 0) + 1);
    }

    int windowSize = p.length();

    // Slide a fixed-length window across s.
    for (int i = 0; i < s.length(); i++) {

      // Add the newest character entering the window.
      char rightChar = s.charAt(i);
      sCount.put(rightChar, sCount.getOrDefault(rightChar, 0) + 1);

      // Remove the oldest character once the window exceeds its size.
      if (i >= windowSize) {
        char leftChar = s.charAt(i - windowSize);
        int newCount = sCount.get(leftChar) - 1;

        if (newCount == 0) {
          sCount.remove(leftChar);
        } else {
          sCount.put(leftChar, newCount);
        }
      }

      // Matching frequency maps indicate an anagram.
      if (sCount.equals(pCount)) {
        result.add(i - windowSize + 1);
      }
    }

    return result;
  }
}
