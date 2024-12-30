class Solution2 {
  /**
   * Adds two binary strings and returns their sum as a binary string.
   *
   * @param a The first binary string.
   * @param b The second binary string.
   * @return The sum of the two binary strings as a binary string.
   */
  public String addBinary(String a, String b) {
    StringBuilder result = new StringBuilder();
    int carry = 0;
    int i = a.length() - 1;
    int j = b.length() - 1;

    // Iterate from the end of both strings towards the beginning
    while (i >= 0 || j >= 0) {
      int sum = carry;
      if (i >= 0) {
        // Convert the character to its integer value by subtracting '0'
        sum += a.charAt(i--) - '0';
      }
      if (j >= 0) {
        // Convert the character to its integer value by subtracting '0'
        sum += b.charAt(j--) - '0';
      }
      // Append the current bit to the result
      result.append(sum % 2);
      // Update the carry
      carry = sum / 2;
    }

    // If there's a remaining carry, append it
    if (carry != 0) {
      result.append(carry);
    }

    // Reverse the result to get the correct binary sum
    return result.reverse().toString();
  }
}
