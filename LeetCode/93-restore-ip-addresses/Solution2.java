import java.util.ArrayList;
import java.util.List;

/**
 * Solution2 class to restore IP addresses from a given string using an
 * iterative approach.
 */
public class Solution2 {

  /**
   * Restores possible valid IP addresses from the given input string.
   *
   * @param s The input string containing only digits.
   * @return A list of all possible valid IP addresses.
   */
  public static List<String> restoreIpAddresses(String s) {
    List<String> result = new ArrayList<>();
    int len = s.length();

    // Iterate over the possible lengths for the first segment (len1).
    for (int len1 = Math.max(1, len - 9); len1 <= Math.min(3, len - 3); len1++) {
      String part1 = s.substring(0, len1);
      if (!isValidSegment(part1))
        continue;

      // Iterate over the possible lengths for the second segment (len2).
      for (int len2 = Math.max(1, len - len1 - 6); len2 <= Math.min(3, len - len1 - 2); len2++) {
        String part2 = s.substring(len1, len1 + len2);
        if (!isValidSegment(part2))
          continue;

        // Iterate over the possible lengths for the third segment (len3).
        for (int len3 = Math.max(1, len - len1 - len2 - 3); len3 <= Math.min(3, len - len1 - len2 - 1); len3++) {
          String part3 = s.substring(len1 + len2, len1 + len2 + len3);
          String part4 = s.substring(len1 + len2 + len3);

          // Check if both the third and fourth segments are valid.
          if (isValidSegment(part3) && isValidSegment(part4)) {
            result.add(part1 + "." + part2 + "." + part3 + "." + part4);
          }
        }
      }
    }

    return result;
  }

  /**
   * Validates whether the given segment is a valid IP address segment.
   *
   * @param segment The segment to validate.
   * @return True if the segment is valid, false otherwise.
   */
  private static boolean isValidSegment(String segment) {
    if (segment.isEmpty() || segment.length() > 3)
      return false;
    if (segment.charAt(0) == '0' && segment.length() > 1)
      return false;
    int value = Integer.parseInt(segment);
    return value >= 0 && value <= 255;
  }
}
