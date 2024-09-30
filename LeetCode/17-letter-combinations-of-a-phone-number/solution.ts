/**
 * Generates all possible letter combinations for the given digits.
 *
 * @param digits - A string containing digits from 2-9.
 * @returns A list of all possible letter combinations.
 */
function letterCombinations(digits: string): string[] {
  const combinations: string[] = [];

  // Edge case: Input is empty, return an empty string array
  if (!digits || digits.length === 0) {
    return combinations;
  }

  // Mapping of digits to corresponding letters.
  const digitToLetters: { [key: string]: string } = {
    '2': 'abc',
    '3': 'def',
    '4': 'ghi',
    '5': 'jkl',
    '6': 'mno',
    '7': 'pqrs',
    '8': 'tuv',
    '9': 'wxyz'
  };

  // Start the backtracking process.
  backtrack(combinations, digitToLetters, digits, 0, '');
  return combinations;
}

/**
 * Helper method to perform backtracking and generate combinations.
 *
 * @param combinations - The list to store all possible combinations.
 * @param digitToLetters - The map of digits to corresponding letters.
 * @param digits - The input string of digits.
 * @param index - The current index in the digits string.
 * @param path - The current combination of letters being formed.
 */
function backtrack(
  combinations: string[],
  digitToLetters: { [key: string]: string },
  digits: string,
  index: number,
  path: string
): void {
  // Base case: if the current combination is complete
  if (index === digits.length) {
    combinations.push(path);
    return;
  }

  // Get the letters that the current digit maps to
  const digit = digits[index];
  const letters = digitToLetters[digit];
  for (const letter of letters) {
    // Add the letter to the current path and move on to the next digit
    backtrack(combinations, digitToLetters, digits, index + 1, path + letter);
  }
}
