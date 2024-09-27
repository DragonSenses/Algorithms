public class Solution2 {
  /**
   * Finds the longest common prefix string amongst an array of strings using the
   * divide and conquer approach.
   *
   * @param strs an array of strings
   * @return the longest common prefix string, or an empty string if there is no
   *         common prefix
   */
  public String longestCommonPrefix(String[] strs) {
    if (strs == null || strs.length == 0) {
      return "";
    }
    return longestCommonPrefix(strs, 0, strs.length - 1);
  }

  /**
   * Recursively finds the longest common prefix in a subset of the array.
   *
   * @param strs the array of strings
   * @param low  the starting index of the subset
   * @param high the ending index of the subset
   * @return the longest common prefix in the subset
   */
  private String longestCommonPrefix(String[] strs, int low, int high) {
    if (low == high) {
      return strs[low];
    }
    int mid = (low + high) / 2;
    String lcpLeft = longestCommonPrefix(strs, low, mid);
    String lcpRight = longestCommonPrefix(strs, mid + 1, high);
    return commonPrefix(lcpLeft, lcpRight);
  }

  /**
   * Finds the common prefix between two strings.
   *
   * @param left  the first string
   * @param right the second string
   * @return the common prefix between the two strings
   */
  private String commonPrefix(String left, String right) {
    int minLength = Math.min(left.length(), right.length());
    for (int i = 0; i < minLength; i++) {
      if (left.charAt(i) != right.charAt(i)) {
        return left.substring(0, i);
      }
    }
    return left.substring(0, minLength);
  }
}
