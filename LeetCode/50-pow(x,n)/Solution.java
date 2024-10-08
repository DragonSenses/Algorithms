/**
 * This class contains methods for calculating the power of a number using
 * binary exponentiation.
 */
public class Solution {

  /**
   * Computes x raised to the power n using binary exponentiation.
   *
   * @param x the base
   * @param n the exponent
   * @return the result of x raised to the power n
   */
  public double binaryExp(double x, long n) {
    // Base case to stop recursive calls.
    if (n == 0) {
      return 1;
    }

    // Handle case where n < 0.
    if (n < 0) {
      return 1.0 / binaryExp(x, -n);
    }

    // Perform Binary Exponentiation.
    // If 'n' is odd, perform Binary Exponentiation on 'n - 1' and multiply result
    // with 'x'.
    if (n % 2 == 1) {
      return x * binaryExp(x * x, (n - 1) / 2);
    } else {
      // Otherwise calculate result by performing Binary Exponentiation on 'n'.
      return binaryExp(x * x, n / 2);
    }
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
