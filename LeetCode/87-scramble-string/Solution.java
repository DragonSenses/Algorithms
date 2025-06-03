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

    int n = s1.length();
    int[] count = new int[26]; // Frequency array to compare character counts in s1 and s2

    // Count frequency of characters in both strings
    for (int i = 0; i < n; i++) {
      count[s1.charAt(i) - 'a']++; // Increment count for s1's characters
      count[s2.charAt(i) - 'a']--; // Decrement count for s2's characters
    }

    // If character counts mismatch, s2 cannot be a scrambled version of s1
    for (int c : count) {
      if (c != 0) {
        cache.put(key, false);
        return false;
      }
    }

    // Iterate over possible split points of the string
    for (int len = 1; len < n; len++) {
      // Check two possible scramble conditions:
      // 1. No swap: First half of s1 matches first half of s2, second half matches second half
      // 2. Swap: First half of s1 matches second half of s2, and vice versa
      if (isScrambleNoSwap(s1, s2, len) || isScrambleWithSwap(s1, s2, len)) {
        // Store result in memoization and return true
        cache.put(key, true);
        return true;
      }
    }

    // If no valid scrambling was found, store and return false
    cache.put(key, false);
    return false;
  }

  private boolean isScrambleNoSwap(String s1, String s2, int len) {
    return isScramble(s1.substring(0, len), s2.substring(0, len))
        && isScramble(s1.substring(len), s2.substring(len));
  }

  private boolean isScrambleWithSwap(String s1, String s2, int len) {
    int n = s1.length();
    return isScramble(s1.substring(0, len), s2.substring(n - len))
        && isScramble(s1.substring(len), s2.substring(0, n - len));
  }
}
