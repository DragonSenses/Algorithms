/**
 * Finds the integer part of the square root of a given number using Newton's method.
 *
 * @param x - The number for which to find the square root.
 * @return The integer part of the square root of x.
 */
function mySqrt(x: number): number {
  // Base case: If x is less than 2, return x itself as the square root.
  if (x < 2) return x;

  // Initialize x0 with x.
  let x0 = x;
  // Compute the next estimate x1 using the formula.
  let x1 = 0.5 * (x0 + x / x0);

  // Iterate until the difference between x0 and x1 is less than 1.
  while (Math.abs(x0 - x1) >= 1) {
    x0 = x1;
    x1 = 0.5 * (x0 + x / x0);
  }

  // Return the integer part of x1.
  return Math.floor(x1);
}
