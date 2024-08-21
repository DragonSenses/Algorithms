/**
 * Reverses the given integer.
 *
 * Handles the overflow constraints when the reversed integer goes outside
 * the signed 32-bit integer range [-2^31, 2^31 - 1].
 *
 * @param x The input integer to be reversed.
 * @returns The reversed integer if it doesn't cause overflow, otherwise 0.
 */
function reverse(x: number): number {
  // Edge case: Check if x is a valid number
  if (typeof x !== 'number' || isNaN(x)) {
    return 0; // Invalid input
  }

  // Signed 32-bit range
  const MIN_INT32: number = -2147483648;  // -(2^{31})
  const MAX_INT32: number = 2147483647;   // (2^{31}) - 1

  const MIN_DIVIDED_BY_10 = MIN_INT32 / 10; // -214748364
  const MAX_DIVIDED_BY_10 = MAX_INT32 / 10; //  214748364

  const MIN_LAST_DIGIT = MIN_INT32 % 10; // 8
  const MAX_LAST_DIGIT = MAX_INT32 % 10; // 7

  let digit: number;
  let result = 0;

  // While x is not 0, extract last digit and truncate x by 1 digit
  while (x !== 0) {
    digit = x % 10;
    x = Math.trunc(x / 10);

    // Constraint: reversing result is greater than maximum signed 32-bit integer
    if (
      result > MAX_DIVIDED_BY_10 ||
      (result === MAX_DIVIDED_BY_10 && digit >= MAX_LAST_DIGIT)
    ) {
      return 0;
    }

    // Constraint: reversing result is less than minimum signed 32-bit integer
    if (
      result < MIN_DIVIDED_BY_10 ||
      (result === MIN_DIVIDED_BY_10 && digit <= MIN_LAST_DIGIT)
    ) {
      return 0;
    }

    // Add the digit to the reverse result
    result = result * 10 + digit;
  }

  return result;
}
