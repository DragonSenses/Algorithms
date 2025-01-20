public class Solution {

  public static int lengthOfLastWord(String s) {
    // Initialize the pointer to the end of the string
    int i = s.length() - 1;

    // Skip trailing spaces
    while (i >= 0 && s.charAt(i) == ' ') {
      i--;
    }

    // Initialize the length counter
    int length = 0;

    // Count the length of the last word
    while (i >= 0 && s.charAt(i) != ' ') {
      length++;
      i--;
    }

    return length;
  }
}
