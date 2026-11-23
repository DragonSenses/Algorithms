class Solution {

  /**
   * Converts an Excel column title (e.g., "A", "AB", "ZY")
   * into its corresponding column number.
   *
   * Excel columns follow a base-26 positional numbering system:
   * A = 1, B = 2, ..., Z = 26
   *
   * Examples:
   * A  -> 1
   * AB -> 28
   * ZY -> 701
   *
   * @param columnTitle the Excel column title consisting of uppercase letters
   * @return the corresponding column number
   */
  public int titleToNumber(String columnTitle) {

    // Stores the running decimal value of the column title.
    int result = 0;

    // Process each character from left to right.
    for (char c : columnTitle.toCharArray()) {

      // Convert the current letter to its Excel value:
      // A = 1, B = 2, ..., Z = 26
      int value = c - 'A' + 1;

      // Shift existing digits left by one base-26 position
      // and append the current digit.
      result = result * 26 + value;
    }

    // Return the final column number.
    return result;
  }
}