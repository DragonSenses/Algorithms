import java.util.HashMap;
import java.util.Map;

public class Solution {

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

    // Two pointers for the sliding window
    int left = 0, right = 0;
    int required = targetFreq.size();
    int formed = 0;

    // Frequency map for the current window
    Map<Character, Integer> windowCounts = new HashMap<>();
    // Variables to keep track of the smallest window
    int[] result = { -1, 0, 0 }; // length, left, right

    while (right < s.length()) {
      // Add character from the right to the window
      char c = s.charAt(right);
      windowCounts.put(c, windowCounts.getOrDefault(c, 0) + 1);

      // Check if current window has enough occurrences of the current character
      if (targetFreq.containsKey(c) && windowCounts.get(c).intValue() == targetFreq.get(c).intValue()) {
        formed++;
      }

      // Contract the window until it is no longer valid
      while (left <= right && formed == required) {
        c = s.charAt(left);
        // Save the smallest window
        if (result[0] == -1 || right - left + 1 < result[0]) {
          result[0] = right - left + 1;
          result[1] = left;
          result[2] = right;
        }

        // Remove character from the left from the window
        windowCounts.put(c, windowCounts.get(c) - 1);
        if (targetFreq.containsKey(c) && windowCounts.get(c).intValue() < targetFreq.get(c).intValue()) {
          formed--;
        }
        left++;
      }
      right++;
    }

    return result[0] == -1 ? "" : s.substring(result[1], result[2] + 1);
  }
}