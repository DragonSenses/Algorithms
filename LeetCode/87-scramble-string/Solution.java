import java.util.HashMap;
import java.util.Map;

class Solution {
  // Memoization map to store previously computed scramble results
  private Map<String, Boolean> cache = new HashMap<>();

  public boolean isScramble(String s1, String s2) {
    // If both strings are identical, return true (trivially scrambled)
    if (s1.equals(s2)) {
      return true;
    }

    // If the lengths differ, it's impossible to be a scramble
    if (s1.length() != s2.length()) {
      return false;
    }

    // Generate a unique key for memoization using both strings
    String key = s1 + "_" + s2;
    
    // If result for this pair of strings is already computed, return the stored value
    if (cache.containsKey(key)) {
      return cache.get(key);
    }

    return false;
  }
}
