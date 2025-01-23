/**
 * Recursively matches text with a given pattern using regex.
 *
 * `.` Matches any single character.
 * `*` Matches zero or more of the preceding element.
 *
 * @param {string} s - The text to be matched.
 * @param {string} p - The pattern to match against.
 * @returns {boolean} - Returns true if the text matches the pattern, false otherwise.
 */
function isMatch(s: string, p: string): boolean {
  // Base case: If pattern is empty, check if text is also empty
  if (p.length === 0) {
    return s.length === 0;
  }

  // Check if the first character matches
  const firstMatch = s.length !== 0 && (p[0] === s[0] || p[0] === ".");

  // Check if the second character of the pattern is '*'
  if (p.length >= 2 && p[1] === "*") {
    // Ignore the '*' and its preceding character or use the '*' to match one or more occurrences
    return (
      isMatch(s, p.substring(2)) || (firstMatch && isMatch(s.substring(1), p))
    );
  } else {
    // No '*', recursively check the rest of the text and pattern
    return firstMatch && isMatch(s.substring(1), p.substring(1));
  }
}
