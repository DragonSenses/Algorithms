/**
 * Function to find the length of the last word in a given string.
 *
 * @param {string} s - The input string containing words and spaces.
 * @returns {number} - The length of the last word in the string.
 *
 * The function iterates through the string from the end to the start,
 * skipping any trailing spaces, and then counts the characters of the last word.
 */
function lengthOfLastWord(s: string): number {
  // Initialize the pointer to the end of the string
  let i = s.length - 1;

  // Skip trailing spaces
  while (i >= 0 && s.charAt(i) === " ") {
    i--;
  }

  // Initialize the length counter
  let length = 0;

  // Count the length of the last word
  while (i >= 0 && s.charAt(i) !== " ") {
    length++;
    i--;
  }

  return length;
}
