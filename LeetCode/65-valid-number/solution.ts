/**
 * Determines whether a given string represents a valid number.
 * A valid number may contain:
 * - Digits (0-9).
 * - At most one dot ('.') for floating-point representation.
 * - At most one exponent ('e' or 'E'), followed by an integer.
 * - Optional '+' or '-' signs, appropriately positioned.
 *
 * @param s - The input string to validate.
 * @returns `true` if the string represents a valid number, otherwise `false`.
 */
function isNumber(s: string): boolean {
  // Early return for empty string
  if (s.length === 0) {
    return false;
  }

  // Flags to track occurrences of digits, exponent, and dot
  let seenDigit = false; // True if at least one digit is seen
  let seenExponent = false; // True if 'e' or 'E' is encountered
  let seenDot = false; // True if '.' is encountered

  // Iterate through each character of the string
  for (let i = 0; i < s.length; i++) {
    const curr = s[i];

    // Check if the current character is a digit
    if (curr >= "0" && curr <= "9") {
      seenDigit = true; // Mark digit as seen
    }
    // Check if the current character is '+' or '-'
    else if (curr === "+" || curr === "-") {
      // A sign is valid only at the start or immediately after an exponent
      if (i > 0 && s[i - 1] !== "e" && s[i - 1] !== "E") {
        return false; // Invalid sign placement
      }
    }
    // Check if the current character is an exponent ('e' or 'E')
    else if (curr === "e" || curr === "E") {
      // Exponent is valid only if it hasn't been seen and follows a digit
      if (seenExponent || !seenDigit) {
        return false; // Invalid exponent usage
      }
      seenExponent = true; // Mark exponent as seen
      seenDigit = false; // Reset digit flag for post-exponent validation
    }
    // Check if the current character is a dot ('.')
    else if (curr === ".") {
      // Dot is valid only if no other dot or exponent is seen
      if (seenDot || seenExponent) {
        return false; // Invalid dot placement
      }
      seenDot = true; // Mark dot as seen
    }
    // Handle invalid characters
    else {
      // Any character outside valid ones makes the string invalid
      return false;
    }
  }

  // Ensure at least one digit is present in the input string
  return seenDigit;
};