/**
 * Increment the given array of digits representing a large integer by one.
 *
 * @param {number[]} digits - The array of digits representing the large integer.
 * @returns {number[]} - The array of digits after incrementing by one.
 */
function plusOne(digits: number[]): number[] {
  // Traverse the array from the end (least significant digit) to the start (most significant digit)
  for (let i = digits.length - 1; i >= 0; i--) {
    // If the current digit is not 9, increment it by one and return the result
    if (digits[i] !== 9) {
      digits[i]++;
      return digits;
    }
    // If the current digit is 9, set it to 0 and continue the loop
    digits[i] = 0;
  }

  // If all digits were 9, we need to add an extra 1 at the beginning of the array
  digits.unshift(1);

  return digits;
};
