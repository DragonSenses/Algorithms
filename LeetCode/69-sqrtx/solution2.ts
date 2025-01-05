/**
 * Computes the integer square root of a given number using recursion and bit shifts.
 *
 * @param x - The number to compute the square root of.
 * @returns The integer square root of the given number.
 */
function mySqrt(x: number): number {
  // Base case: if x is less than 2, return x
  if (x < 2) return x;

  // Recursively compute the square root of x / 4 (x >> 2) and multiply the result by 2 (left << 1)
  const left = mySqrt(x >> 2) << 1;

  // Calculate the next potential square root value
  const right = left + 1;

  // Check if the square of the next potential value exceeds x
  return right * right > x ? left : right;
}
