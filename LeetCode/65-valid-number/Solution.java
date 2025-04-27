class Solution {
  public boolean isNumber(String s) {
    boolean seenDigit = false;
    boolean seenExponent = false;
    boolean seenDot = false;

    for (int i = 0; i < s.length(); i++) {
      char curr = s.charAt(i);

      if (Character.isDigit(curr)) {
        seenDigit = true;
      }
    }
  }
}