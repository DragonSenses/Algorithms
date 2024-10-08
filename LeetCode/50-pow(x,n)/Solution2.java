/**
 * This class contains methods for calculating the power of a number
 * using iterative binary exponentiation.
 */
public class Solution2 {

  /**
   * Computes x raised to the power n using iterative binary exponentiation.
   *
   * @param x the base
   * @param n the exponent
   * @return the result of x raised to the power n
   */
  public double binaryExp(double x, long n) {
      if (n == 0) {
          return 1;
      }

      // Handle case where n < 0.
      if (n < 0) {
          n = -n;
          x = 1.0 / x;
      }

      // Perform Binary Exponentiation.
      double result = 1;
      while (n > 0) {
          // If 'n' is odd we multiply result with 'x' and reduce 'n' by '1'.
          if (n % 2 == 1) {
              result = result * x;
              n -= 1;
          }
          // We square 'x' and reduce 'n' by half, x^n => (x^2)^(n/2).
          x = x * x;
          n = n / 2;
      }

      return result;
  }

  /**
   * Computes x raised to the power n.
   *
   * @param x the base
   * @param n the exponent
   * @return the result of x raised to the power n
   */
  public double myPow(double x, int n) {
      return binaryExp(x, (long) n);
  }
}
