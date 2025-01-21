/**
 * Finds the length of the last word in the given string.
 *
 * This function uses built-in string functions to trim the input string,
 * find the position of the last space, and compute the length of the last word.
 *
 * @param {string} s - The input string containing words and spaces.
 * @returns {number} - The length of the last word in the string.
 */
function lengthOfLastWord(s: string): number {
  // Step 1: Trim the string to remove leading and trailing spaces
  s = s.trim();

  // Step 2: Find the position of the last space
  const lastSpaceIndex = s.lastIndexOf(' ');

  // Step 3: Compute the length of the last word
  return (lastSpaceIndex === -1) ? s.length : s.length - lastSpaceIndex - 1;
}
