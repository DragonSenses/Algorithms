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

    long result = 0;
    
    // 3. Traverse next digits of input. Halt when non-digit violates conditions
    // Also end conversion when the end of string is reached
    while (index < s.length() && Character.isDigit(s.charAt(index))) {
      int digit = s.charAt(index) - '0';
      result = result * 10 + digit;
      
      // Step 4: Handle overflow and underflow
      if (sign * result > Integer.MAX_VALUE) {
        return Integer.MAX_VALUE;
      } else if (sign * result < Integer.MIN_VALUE) {
        return Integer.MIN_VALUE;
      }

      index++;
    }

    return (int) (sign * result);
  }
}
