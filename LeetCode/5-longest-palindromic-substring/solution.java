class solution {
  
  /**
   * Expands from the middle of the given string using two pointers to find a palindrome.
   * This method finds the length of longest palindrome centered at left, right
   * @param s The input string.
   * @param left The left pointer.
   * @param right The right pointer.
   * @return The length of the longest palindrome centered at the given indices.
   */
  public int expandFromMiddle(String s, int left, int right) {
    // Edge case: null input or invalid indices
    if (s == null || left > right) {
      return 0;
    }

    // While both pointers are within bounds AND
    // characters at those poistions are equivalent
    while (left >= 0 && right < s.length() 
      && s.charAt(left) == s.charAt(right)) {
        // Expand the pointers from the middle
        left--;
        right++;
    }

    // Right is the higher than left, -1 for indices correction
    return right - left - 1;
  }
  
  public String longestPalindrome(String s) {
    // Check the argument
    if (s == null || s.length() < 1) {
      return "";
    }

    // Substring boundaries for the longest palindrome substring
    int start = 0;
    int end = 0;

    // Loop through the string to find the longest palindrome substring
    for (int i = 0; i < s.length(); i++) {
      // Handle two cases: symmetric palindrome "radar" and even-length mirror palindrome "abba"
      int symPalinLength = expandFromMiddle(s, i, i);
      int mirrorPalinLength =  expandFromMiddle(s, i, i+1);

      // Find max length of palindrome substring and adjust the start and end boundaries
      int len = Math.max(symPalinLength, mirrorPalinLength);
      if (len > end - start) {
        // Set the new start and end index, check boundaries
        start = i - ((len - 1) / 2);
        end = i + (len / 2);
      }
    }

    return s.substring(start, end + 1);
  }
}
