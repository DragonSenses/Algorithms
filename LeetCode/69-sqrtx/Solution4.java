/**
 * Class Solution provides a method to compute the integer square root of a given number using
 * Newton's Method.
 */
class Solution4 {
  /**
   * Computes the integer square root of a given number.
   * 
   * @param x The number to compute the square root of.
   * @return The integer square root of the given number.
   */
  public int mySqrt(int x) {
    // Base case: if x is less than 2, return x
    if (x < 2)
      return x;

    // Initialize x0 with x
    double x0 = x;
    // Compute the next estimate x1 using the formula
    double x1 = (x0 + x / x0) / 2.0;
    // Iterate until the difference between x0 and x1 is less than 1
    while (Math.abs(x0 - x1) >= 1) {
      x0 = x1;
      x1 = (x0 + x / x0) / 2.0;
    }
    // Return the integer part of x1
    return (int) x1;
  }
}
