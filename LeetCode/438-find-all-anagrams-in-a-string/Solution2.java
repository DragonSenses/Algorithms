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


  }
}
