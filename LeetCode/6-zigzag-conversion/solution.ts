/**
 * Converts a given string into a zigzag pattern based on the specified number of rows.
 * The zigzag pattern is formed by reading the characters line by line.
 *
 * @param s        The input string to convert.
 * @param numRows  The number of rows in the zigzag pattern.
 * @returns The converted zigzag string.
 */
function convert(s: string, numRows: number): string {
  // Edge case: null input or invalid indices
  if (s === null || numRows < 1) {
    return "";
  }

  // Edge case: Single row
  if (numRows === 1) {
    return s; // No transformation needed for a single row
  }

  const output: string[] = [];

  // Create the zigzag increment with formula: 2 * (numRows - 1)
  const increment: number = 2 * (numRows - 1);

  // Iterate through each row
  for (let row = 0; row < numRows; row++) {
    // Create the string for each row
    for (let i = row; i < s.length; i += increment) {
      // Add the character at the current index
      output.push(s[i]);

      // Add intermediate characters for middle rows
      if (row > 0 && row < numRows - 1 && i + increment - 2 * row < s.length) {
        output.push(s[i + increment - 2 * row]);
      }
    }
  }

  return output.join("");
}
