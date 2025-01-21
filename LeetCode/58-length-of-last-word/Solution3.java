public class Solution3 {
  /**
   * Finds the length of the last word in the given string.
   *
   * The method uses built-in String functions to trim spaces, locate 
   * the last word, and return its length.
   *
   * @param s The input string containing words and spaces.
   * @return The length of the last word in the string.
   */
  public static int lengthOfLastWord(String s) {
    // Step 1: Trim the string to remove leading and trailing spaces
    s = s.trim();

    // Step 2: Find the position of the last space
    int lastSpaceIndex = s.lastIndexOf(' ');

    // Step 3: Compute the length of the last word
    return (lastSpaceIndex == -1) ? s.length() : s.length() - lastSpaceIndex - 1;
  }
}
