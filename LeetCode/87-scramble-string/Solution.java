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

    return false;
  }
}
