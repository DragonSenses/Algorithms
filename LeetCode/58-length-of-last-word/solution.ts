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
