class Solution {
  public int reverse(int x) {
    final int MIN = Integer.MIN_VALUE; //-2147483648
    final int MAX = Integer.MAX_VALUE; // 2147483647

    final int MIN_DIVIDED_BY_10 = Integer.MIN_VALUE / 10;
    final int MAX_DIVIDED_BY_10 = Integer.MAX_VALUE / 10;

    final int MIN_LAST_DIGIT = MIN % 10; // 8
    final int MAX_LAST_DIGIT = MAX % 10; // 7

    int digit;
    int result = 0;

    // While x is not 0, extract last digit and truncate x by 1 digit
    while (x != 0) {
      digit = x % 10;
      x /= 10;

      // Constraint: reversing result is greater than maximum signed 32-bit integer
      if (result > MAX_DIVIDED_BY_10 || 
         (result == MAX_DIVIDED_BY_10 && digit >= MAX_LAST_DIGIT)) {
        return 0;
      }
      
      // Constraint: reversing result is less than  minimum signed 32-bit integer
      if (result < MIN_DIVIDED_BY_10 || 
         (result == MIN_DIVIDED_BY_10 && digit <= MIN_LAST_DIGIT)) {
        return 0;
      }

      // Add the digit to the reverse result
      result = (result * 10) + digit;
    }

    return result;
  }
}
