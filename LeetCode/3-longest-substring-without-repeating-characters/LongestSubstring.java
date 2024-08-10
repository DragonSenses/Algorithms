import java.util.HashSet;
import java.util.Set;

public class LongestSubstring {
  public int lengthOfLongestSubstring(String s) {
    Set<Character> set = new HashSet<>();
    int left = 0;
    int max = 0;

    for (int right = 0; right < s.length(); right++) {
      if (!set.contains(s.charAt(right))) {
        set.add(s.charAt(right));
        right++;
        max = Math.max(max, right - left);
      } else {
        set.remove(s.charAt(left));
        left++;
      }
  }

    return max;
  }
}
