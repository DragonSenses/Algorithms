function myAtoi(s: string): number {
  // Edge case: Check for invalid arguments
  if (s == null || s.length === 0) {
    return 0;
  }

  // 1. Trim leading white spaces from the input
  s = s.trim();

  // Edge case: Trimmed string becomes empty
  if (s.length === 0) {
    return 0;
  }

  // 2. Determine the sign
  let sign = 1;
  let index = 0;
  if (s.charAt(0) === "-") {
    sign = -1;
    index++;
  } else if (s.charAt(0) === "+") {
    index++;
  }

  let result = 0;
  const INT_MAX = 2147483647;
  const INT_MIN = -2147483648;

  // 3. Traverse next digits of input. Halt when non-digit violates conditions
  // Also end conversion when the end of string is reached
  while (index < s.length && s.charAt(index) >= "0" && s.charAt(index) <= "9") {
    const digit = s.charAt(index).charCodeAt(0) - "0".charCodeAt(0);
    result = result * 10 + digit;

    // Step 4: Handle overflow and underflow
    if (sign * result > INT_MAX) {
      return INT_MAX;
    } else if (sign * result < INT_MIN) {
      return INT_MIN;
    }

    index++;
  }

  return sign * result;
}
