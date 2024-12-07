import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Solution class to find the minimum window substring containing all characters
 * of another string.
 */
public class Solution2 {

  /**
   * Finds the minimum window substring in the given string 's' that contains all
   * characters of the string 't'.
   *
   * @param s the source string
   * @param t the target string containing characters to be found in the window
   * @return the minimum window substring containing all characters of 't', or an
   *         empty string if no such window exists
   */
  public static String minWindow(String s, String t) {
    // Edge Case: Return empty string if either argument is empty
    if (s.length() == 0 || t.length() == 0) {
      return "";
    }

    // Frequency map for characters in T
    Map<Character, Integer> targetFreq = new HashMap<>();
    for (char c : t.toCharArray()) {
      targetFreq.put(c, targetFreq.getOrDefault(c, 0) + 1);
    }

    // List to filter S
    List<int[]> filteredS = new ArrayList<>();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (targetFreq.containsKey(c)) {
        filteredS.add(new int[] { i, c });
      }
    }

    // Two pointers for the sliding window
    int left = 0, right = 0;
    int required = targetFreq.size();
    int formed = 0;

    // Frequency map for the current window
    Map<Character, Integer> windowCounts = new HashMap<>();
    // Variables to keep track of the smallest window
    int[] result = { -1, 0, 0 }; // length, left, right

    // Sliding window on filtered list
    while (right < filteredS.size()) {
      char c = (char) filteredS.get(right)[1];
      windowCounts.put(c, windowCounts.getOrDefault(c, 0) + 1);

      // Check if current window has enough occurrences of the current character
      if (targetFreq.containsKey(c) && windowCounts.get(c).intValue() == targetFreq.get(c).intValue()) {
        formed++;
      }

      // Contract the window until it is no longer valid
      while (left <= right && formed == required) {
        c = (char) filteredS.get(left)[1];
        int start = filteredS.get(left)[0];
        int end = filteredS.get(right)[0];
        // Save the smallest window
        if (result[0] == -1 || end - start + 1 < result[0]) {
          result[0] = end - start + 1;
          result[1] = start;
          result[2] = end;
        }

        // Remove character from the left from the window
        windowCounts.put(c, windowCounts.get(c) - 1);
        if (targetFreq.containsKey(c) && windowCounts.get(c) < targetFreq.get(c)) {
          formed--;
        }
        left++;
      }
      right++;
    }

    return result[0] == -1 ? "" : s.substring(result[1], result[2] + 1);
  }
}
