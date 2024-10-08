/**
 * Computes x raised to the power n using iterative binary exponentiation.
 *
 * @param {number} x - The base number.
 * @param {number} n - The exponent.
 * @returns {number} - The result of x raised to the power n.
 */
function myPow(x: number, n: number): number {
  /**
   * Helper function for binary exponentiation.
   *
   * @param {number} x - The base number.
   * @param {number} n - The exponent.
   * @returns {number} - The result of x raised to the power n.
   */
  function binaryExp(x: number, n: number): number {
    // Base case: If n is 0, return 1
    if (n === 0) {
      return 1;
    }

    // Handle case where n < 0: Invert x and make n positive
    if (n < 0) {
      n = -n;
      x = 1.0 / x;
    }

    let result = 1; // Initialize result to 1
    while (n > 0) {
      // If n is odd, multiply the current result by x and reduce n by 1
      if (n % 2 === 1) {
        result *= x;
        n -= 1;
      }
      // Square x and reduce n by half
      x *= x;
      n = Math.floor(n / 2);
    }

    return result; // Return the final result
  }

  return binaryExp(x, n); // Call the helper function and return its result
};
