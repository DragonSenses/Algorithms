/**
 * Solution class to find the integer part of the square root of a number using binary search.
 */
public class Solution3 {

  /**
   * Finds the integer part of the square root of x.
   *
   * @param x The number for which to find the square root.
   * @return The integer part of the square root of x.
   */
  public int mySqrt(int x) {
    // If x is less than 2, return x itself as the square root.
    if (x < 2)
      return x;

    long num;
    int pivot, left = 2, right = x / 2;

    // Perform binary search to find the square root.
    while (left <= right) {
      pivot = left + (right - left) / 2;
      num = (long) pivot * pivot;

      // If num is greater than x, move the right pointer.
      if (num > x)
        right = pivot - 1;
      // If num is less than x, move the left pointer.
      else if (num < x)
        left = pivot + 1;
      // If num is equal to x, return pivot as the square root.
      else
        return pivot;
    }

    // Return right as the integer part of the square root.
    return right;
  }
}
