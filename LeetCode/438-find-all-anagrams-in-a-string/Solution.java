import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
  public List<Integer> findAnagrams(String s, String p) {
    List<Integer> result = new ArrayList<>();
    if (s.length() < p.length())
      return result;

    int[] pCount = new int[26];
    int[] windowCount = new int[26];

    for (char c : p.toCharArray()) {
      pCount[c - 'a']++;
    }

    int windowSize = p.length();

    for (int i = 0; i < s.length(); i++) {
      windowCount[s.charAt(i) - 'a']++;

      if (i >= windowSize) {
        windowCount[s.charAt(i - windowSize) - 'a']--;
      }

      if (Arrays.equals(windowCount, pCount)) {
        result.add(i - windowSize + 1);
      }
    }

    return result;
  }
}
