public class Solution {

  /**
   * Finds the length of the last word in the given string.
   * 
   * The method iterates through the string from the end to the start, skipping 
   * any trailing spaces, and then counts the characters of the last word.
   * 
   * @param s The input string containing words and spaces.
   * @return The length of the last word in the string.
   */
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
