class Solution {
  // Returns the integer square root of x, rounded down to the nearest integer.
  public int mySqrt(int x) {
    // Special case: If x is 0 or 1, return x as the square root is the number itself.
    if (x < 2) {
      return x;
    }

    // Compute the approximate square root using the pocket calculator algorithm:
    // sqrt(x) ≈ e^(0.5 * log(x))
    int left = (int) Math.pow(Math.E, 0.5 * Math.log(x));

    // Adjust the result by checking the next integer to ensure proper rounding down
    int right = left + 1;

    // Return the correct integer square root
    return (long) right * right > x ? left : right;
  }
}
