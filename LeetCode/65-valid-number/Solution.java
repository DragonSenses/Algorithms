/**
 * This class provides a method to determine if a given string is a valid number.
 */
class Solution {

  /**
   * Determines if the input string is a valid number. A valid number may contain: - Digits - At
   * most one exponent ('e' or 'E'), followed by an integer - At most one dot ('.') for
   * floating-point numbers - Optional '+' or '-' signs in valid positions
   * 
   * @param s the input string to validate
   * @return true if the input string is a valid number, false otherwise
   */
  public boolean isNumber(String s) {
    // Tracks if at least one digit has been encountered
    boolean seenDigit = false;
    // Tracks if an exponent ('e' or 'E') has been encountered
    boolean seenExponent = false;
    // Tracks if a dot ('.') has been encountered
    boolean seenDot = false;

    // Iterate through the input string character by character
    for (int i = 0; i < s.length(); i++) {
      char curr = s.charAt(i);

      // If the current character is a digit, mark it as seen
      if (Character.isDigit(curr)) {
        seenDigit = true;
      }
      // If the current character is a sign ('+' or '-')
      else if (curr == '+' || curr == '-') {
        // A sign is valid only at the start or immediately after an exponent
        if (i > 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') {
          return false;
        }
      }
      // If the current character is an exponent ('e' or 'E')
      else if (curr == 'e' || curr == 'E') {
        // An exponent is valid only if it hasn't been seen before and follows a digit
        if (seenExponent || !seenDigit) {
          return false;
        }
        // Mark the exponent as seen and reset digit tracking for the number after the exponent
        seenExponent = true;
        seenDigit = false;
      }
      // If the current character is a dot ('.')
      else if (curr == '.') {
        // A dot is valid only if no other dot or exponent has been encountered
        if (seenDot || seenExponent) {
          return false;
        }
        seenDot = true;
      }
      // If the current character is invalid (not a digit, sign, exponent, or dot)
      else {
        return false;
      }
    }

    // At the end, ensure that at least one digit was seen
    return seenDigit;
  }
}
