class Solution {
  /**
   * Increment the given array of digits representing a large integer by one.
   *
   * @param digits The array of digits representing the large integer.
   * @return The array of digits after incrementing by one.
   */
  public int[] plusOne(int[] digits) {
    // Traverse the array from the end (least significant digit) to the start (most significant
    // digit)
    for (int i = digits.length - 1; i >= 0; i--) {
      // If the current digit is not 9, increment it by one and return the result
      if (digits[i] != 9) {
        digits[i]++;
        return digits;
      }
      // If the current digit is 9, set it to 0 and continue the loop
      digits[i] = 0;
    }

    // If all digits were 9, we need to add an extra 1 at the beginning of the array
    int[] result = new int[digits.length + 1];
    result[0] = 1; // The rest of the array is already initialized to 0s

    return result;
  }
}
