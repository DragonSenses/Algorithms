class Solution {
  public int myAtoi(String s) {
    // Edge case: Check for invalid arguments
    if (s == null || s.length() == 0) {
      return 0;
    }

    // 1. Trim leading white spaces from the input
    s = s.trim();

    // Edge case: Trimmed string becomes empty
    if (s.isEmpty()) {
      return 0;
    }

    // 2. Determine the sign
    int sign = 1;
    int index = 0;
    if (s.charAt(0) == '-') {
      sign = -1;
      index++;
    } else if (s.charAt(0) == '+') {
      index++;
    }

    // Store result in 32-bit signed integer (assumes environment disallows longs, BigInteger, etc.)
    int result = 0;

    final int MIN_INT32 = -2147483648; //-2147483648
    final int MAX_INT32 = 2147483647;  // 2147483647

    final int MIN_INT_DIV10 = Integer.MIN_VALUE / 10; // -214748364
    final int MAX_INT_DIV10 = Integer.MAX_VALUE / 10; //  214748364
    
    final int MIN_LAST_DIGIT = 8; // -2147483648 % 10
    final int MAX_LAST_DIGIT = 7; //  2147483647 % 10

    // 3. Traverse next digits of input. Halt when non-digit violates conditions
    // Also end conversion when the end of string is reached
    while (index < s.length() && s.charAt(index) >= '0' && s.charAt(index) <= '9') {
      // Convert character representing a digit into integer (e.g., '7'-'0' = 55-48 = 7)
      int digit = s.charAt(index) - '0';
      
      // Step 4: Check for overflow before updating result
      if (result > MAX_INT_DIV10) {
        return (sign == 1) ? MAX_INT32 : MIN_INT32;
      }

      if (result == MAX_INT_DIV10) {
        if (digit == 8) {
          return (sign == 1) ? MAX_INT32 : MIN_INT32;
        } else if (digit > 8) {
          return (sign == 1) ? MAX_INT32 : MIN_INT32;
        }
      }

      result = result * 10 + digit;
      index++;
    }

    return (int) (sign * result);
  }
}
