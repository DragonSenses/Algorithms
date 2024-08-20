class Solution {
  /**
   * Converts a given string into a zigzag pattern based on the specified number of rows.
   * The zigzag pattern is formed by reading the characters line by line.
   *
   * @param s        The input string to convert.
   * @param numRows  The number of rows in the zigzag pattern.
   * @return The converted zigzag string.
   */
  public String convert(String s, int numRows) {
    // Edge case: null input or invalid indices
    if (s == null || numRows < 1) {
      return "";
    }

    // Edge case: Single row
    if (numRows == 1) {
      return s;
    }
    
    StringBuilder output = new StringBuilder();

    // Create the zigzag increment with formula: 2 * (numRows - 1)
    int increment = 2 * (numRows - 1);

    // Iterate through each row
    for (int row = 0; row < numRows; row++) {
      // Create the string for each row
      for (int i = row; i < s.length(); i += increment) {
        // Add the character at the current index
        output.append(s.charAt(i));

        // Add intermediate characters for middle rows
        if (row > 0 && row < numRows - 1 
          && i + increment - 2*row < s.length()) {
            output.append(s.charAt(i + increment - 2*row));
        }
      }
    }

    return output.toString();
  }
}
