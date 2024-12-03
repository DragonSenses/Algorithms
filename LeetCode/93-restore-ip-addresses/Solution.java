import java.util.ArrayList;
import java.util.List;

/**
 * This class provides a method to restore valid IP addresses from a given
 * string.
 */
public class Solution {

  /**
   * Restores valid IP addresses from the given string.
   *
   * @param s the input string containing only digits
   * @return a list of all possible valid IP address combinations
   */
  public static List<String> restoreIpAddresses(String s) {
    List<String> ans = new ArrayList<>();
    backtrack(s, 0, new ArrayList<>(), ans);
    return ans;
  }

  /**
   * Utility method to backtrack and find all valid IP address combinations.
   *
   * @param s          the input string containing only digits
   * @param startIndex the current index to start processing
   * @param dots       a list of integers representing the positions of the dots
   *                   added so far
   * @param ans        a list of strings to store the valid IP address
   *                   combinations
   */
  private static void backtrack(String s, int startIndex, List<Integer> dots, List<String> ans) {
    int remainingLength = s.length() - startIndex;
    int remainingNumberOfIntegers = 4 - dots.size();

    // Check if the remaining length is too long or too short to form a valid IP
    // address
    if (remainingLength > remainingNumberOfIntegers * 3 || remainingLength < remainingNumberOfIntegers) {
      return;
    }

    // If we are adding the last segment
    if (remainingNumberOfIntegers == 1) {
      if (validSegment(s, startIndex, remainingLength)) {
        StringBuilder ipAddress = new StringBuilder();
        int last = 0;
        // Build the IP address with dots
        for (int dot : dots) {
          ipAddress.append(s, last, last + dot).append('.');
          last += dot;
        }
        ipAddress.append(s, startIndex, s.length());
        ans.add(ipAddress.toString());
      }
      return;
    }

    // Try to place a dot after every 1 to 3 digits
    for (int curPos = 1; curPos <= Math.min(3, remainingLength); curPos++) {
      if (validSegment(s, startIndex, curPos)) {
        dots.add(curPos);
        backtrack(s, startIndex + curPos, dots, ans);
        dots.remove(dots.size() - 1);
      }
    }
  }

  /**
   * Checks if the segment of the string is a valid IP address segment.
   *
   * @param s      the input string
   * @param start  the starting index of the segment
   * @param length the length of the segment
   * @return true if the segment is valid, false otherwise
   */
  private static boolean validSegment(String s, int start, int length) {
    if (length == 1) {
      return true;
    }
    if (s.charAt(start) == '0') {
      return false;
    }
    if (length == 2) {
      return 10 <= Integer.parseInt(s.substring(start, start + 2))
          && Integer.parseInt(s.substring(start, start + 2)) <= 99;
    }
    if (length == 3) {
      return 100 <= Integer.parseInt(s.substring(start, start + 3))
          && Integer.parseInt(s.substring(start, start + 3)) <= 255;
    }
    return false;
  }
}
