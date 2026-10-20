import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution2 {
  public List<Integer> findAnagrams(String s, String p) {
    List<Integer> result = new ArrayList<>();

    // If s is shorter than p, no anagram can exist
    if (s.length() < p.length()) {
      return result;
    }

    // Frequency map for pattern p
    Map<Character, Integer> pCount = new HashMap<>();
    // Frequency map for current sliding window
    Map<Character, Integer> sCount = new HashMap<>();

    // Build reference frequency map for p
    for (char c : p.toCharArray()) {
      pCount.put(c, pCount.getOrDefault(c, 0) + 1);
    }

    int windowSize = p.length();

    // Slide window across s
    for (int i = 0; i < s.length(); i++) {
      char rightChar = s.charAt(i);
      sCount.put(rightChar, sCount.getOrDefault(rightChar, 0) + 1);

      // Remove leftmost char once window exceeds size
      if (i >= windowSize) {
        char leftChar = s.charAt(i - windowSize);
        int newCount = sCount.get(leftChar) - 1;
        if (newCount == 0) {
          sCount.remove(leftChar);
        } else {
          sCount.put(leftChar, newCount);
        }
      }

      // Compare maps for equality
      if (sCount.equals(pCount)) {
        result.add(i - windowSize + 1);
      }
    }
  }
}
