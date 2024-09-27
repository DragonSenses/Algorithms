public class Solution3 {

  /**
   * Finds the longest common prefix string amongst an array of strings using the
   * binary search approach.
   *
   * @param strs an array of strings
   * @return the longest common prefix string, or an empty string if there is no
   *         common prefix
   */
  public String longestCommonPrefix(String[] strs) {
    if (strs == null || strs.length == 0) {
      return "";
    }

    int minLen = Integer.MAX_VALUE;
    for (String str : strs) {
      minLen = Math.min(minLen, str.length());
    }

    int low = 0;
    int high = minLen;
    while (low <= high) {
      int mid = (low + high) / 2;
      if (isCommonPrefix(strs, mid)) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }

    return strs[0].substring(0, (low + high) / 2);
  }

  /**
   * Checks if a prefix of given length is common to all strings.
   *
   * @param strs the array of strings
   * @param len  the length of the prefix
   * @return true if the prefix is common to all strings, false otherwise
   */
  private boolean isCommonPrefix(String[] strs, int len) {
    String prefix = strs[0].substring(0, len);
    for (int i = 1; i < strs.length; i++) {
      if (!strs[i].startsWith(prefix)) {
        return false;
      }
    }
    return true;
  }
}
