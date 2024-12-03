import java.util.ArrayList;
import java.util.List;

public class Solution2 {
  public static List<String> restoreIpAddresses(String s) {
    List<String> result = new ArrayList<>();

    int len = s.length();
    for (int len1 = Math.max(1, len - 9); len1 <= Math.min(3, len - 3); len1++) {
      String part1 = s.substring(0, len1);
      if (!isValidSegment(part1))
        continue;

      for (int len2 = Math.max(1, len - len1 - 6); len2 <= Math.min(3, len - len1 - 2); len2++) {
        String part2 = s.substring(len1, len1 + len2);
        if (!isValidSegment(part2))
          continue;

        for (int len3 = Math.max(1, len - len1 - len2 - 3); len3 <= Math.min(3, len - len1 - len2 - 1); len3++) {
          String part3 = s.substring(len1 + len2, len1 + len2 + len3);
          String part4 = s.substring(len1 + len2 + len3);

          if (isValidSegment(part3) && isValidSegment(part4)) {
            result.add(part1 + "." + part2 + "." + part3 + "." + part4);
          }
        }
      }
    }

    return result;
  }

  private static boolean isValidSegment(String segment) {
    if (segment.isEmpty() || segment.length() > 3)
      return false;
    if (segment.charAt(0) == '0' && segment.length() > 1)
      return false;
    int value = Integer.parseInt(segment);
    return value >= 0 && value <= 255;
  }
}