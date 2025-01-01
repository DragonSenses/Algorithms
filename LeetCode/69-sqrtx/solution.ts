function mySqrt(x: number): number {
  // Special case: If x is 0 or 1, return x as the square root is the number itself.
  if (x < 2) {
    return x;
  }

  // Compute the approximate square root using the pocket calculator algorithm:
  // sqrt(x) ≈ e^(0.5 * log(x))
  let left: number = Math.floor(Math.exp(0.5 * Math.log(x)));

  // Adjust the result by checking the next integer to ensure proper rounding down
  let right: number = left + 1;

  // Return the correct integer square root
  return (right * right > x) ? left : right;
}
