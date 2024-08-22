class Solution {
  public boolean isPalindrome(int x) {
    // Edge case: Negative numbers are not palindromes
    if (x < 0) {
      return false; 
    }

    // Edge case: Numbers ending with 0 are not palindromes
    if (x != 0 && (x & 1) == 0) {
      return false;
    }

    // Edge case: Single-digit numbers are always palindromes
    if (x >= 0 && x < 10) {
      return true;
    }

    // final int MIN_INT32 = Integer.MIN_VALUE; //-2147483648
    // final int MAX_INT32 = Integer.MAX_VALUE; // 2147483647

    final int MIN_DIVIDED_BY_10 = Integer.MIN_VALUE / 10; // -214748364
    final int MAX_DIVIDED_BY_10 = Integer.MAX_VALUE / 10; //  214748364

    final int MIN_LAST_DIGIT = Integer.MIN_VALUE % 10; // 8
    final int MAX_LAST_DIGIT = Integer.MAX_VALUE % 10; // 7

    int original = x;
    int reversed = 0;
    int digit;

    while (x != 0) {
      digit = x % 10;

      // Constraint: reversing result is greater than maximum signed 32-bit integer
      if (reversed > MAX_DIVIDED_BY_10 || 
        (reversed == MAX_DIVIDED_BY_10 && digit >= MAX_LAST_DIGIT)) {
        return false;
      }
      
      // Constraint: reversing result is less than minimum signed 32-bit integer
      if (reversed < MIN_DIVIDED_BY_10 || 
        (reversed == MIN_DIVIDED_BY_10 && digit <= MIN_LAST_DIGIT)) {
        return false;
      }
   
      reversed = reversed * 10 + digit; // Reverse the digits
      x /= 10; // Truncate the number
    }

    return original == reversed;
  }

}