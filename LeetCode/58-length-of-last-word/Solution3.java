public class Solution3 {
  public static int lengthOfLastWord(String s) {
    s = s.trim();

    int lastSpaceIndex = s.lastIndexOf(' ');

    return (lastSpaceIndex == -1) ? s.length() : s.length() - lastSpaceIndex - 1;
  }
}
