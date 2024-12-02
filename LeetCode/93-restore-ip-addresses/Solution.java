import java.util.ArrayList;
import java.util.List;

public class Solution {
  public static List<String> restoreIpAddresses(String s) {
    List<String> ans = new ArrayList<>();
    backtrack(s, 0, new ArrayList<>(), ans);
    return ans;
  }

  private static void backtrack(String s, int startIndex, List<Integer> dots, List<String> ans) {
    int remainingLength = s.length() - startIndex;
    int remainingNumberOfIntegers = 4 - dots.size();

    if (remainingLength > remainingNumberOfIntegers * 3 || remainingLength < remainingNumberOfIntegers) {
      return;
    }

    if (remainingNumberOfIntegers == 1) {
      if (validSegment(s, startIndex, remainingLength)) {
        StringBuilder ipAddress = new StringBuilder();
        int last = 0;
        for (int dot : dots) {
          ipAddress.append(s, last, last + dot).append('.');
          last += dot;
        }
        ipAddress.append(s, startIndex, s.length());
        ans.add(ipAddress.toString());
      }
      return;
    }

    for (int curPos = 1; curPos <= Math.min(3, remainingLength); curPos++) {
      if (validSegment(s, startIndex, curPos)) {
        dots.add(curPos);
        backtrack(s, startIndex + curPos, dots, ans);
        dots.remove(dots.size() - 1);
      }
    }
  }

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
