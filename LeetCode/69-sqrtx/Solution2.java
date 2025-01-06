/**
 * Class Solution2 provides a method to compute the integer square root of a given number using
 * recursion and bit shifts.
 */
class Solution2 {
  /**
   * Computes the integer square root of a given number.
   * 
   * @param x The number to compute the square root of.
   * @return The integer square root of the given number.
   */
  public int mySqrt(int x) {
    // Base case: if x is less than 2, return x
    if (x < 2) {
      return x;
    }

    // Recursively compute the square root of x / 4 (x >> 2) and multiply the result by 2 (left <<
    // 1)
    int left = mySqrt(x >> 2) << 1;

    // Calculate the next potential square root value
    int right = left + 1;

    // Check if the square of the next potential value exceeds x
    return (long) right * right > x ? left : right;
  }
}
