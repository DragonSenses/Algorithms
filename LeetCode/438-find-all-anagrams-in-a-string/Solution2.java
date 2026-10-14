import java.util.ArrayList;
import java.util.List;

public class Solution2 {
  public List<Integer> findAnagrams(String s, String p) {
    List<Integer> result = new ArrayList<>();

    // If s is shorter than p, no anagram can exist
    if (s.length() < p.length()) {
      return result;
    }

  }
}
