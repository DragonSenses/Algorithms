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
 * @param columnTitle - The Excel column title consisting of uppercase letters.
 * @returns The corresponding column number.
 */
function titleToNumber(columnTitle: string): number {

  // Stores the running decimal value of the column title.
  let result = 0;

  // Process each character from left to right.
  for (const c of columnTitle) {

    // Convert the current letter to its Excel value:
    // A = 1, B = 2, ..., Z = 26
    const value = c.charCodeAt(0) - 'A'.charCodeAt(0) + 1;

    // Shift existing digits left by one base-26 position
    // and append the current digit.
    result = result * 26 + value;
  }

  // Return the final column number.
  return result;
};