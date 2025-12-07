/**
 * Bitwise Manipulation Approach to find the majority element.
 *
 * The majority element is defined as the element that appears more than ⌊n / 2⌋ times.
 *
 * @param nums - The input array of integers
 * @returns The majority element reconstructed bit by bit
 */
function majorityElement(nums: number[]): number {
  let majority = 0; // Result variable to hold reconstructed majority element
  const n = nums.length;

  // Iterate over all 32 bit positions (for signed 32-bit integers)
  for (let i = 0; i < 32; i++) {
    let bitCount = 0; // Counter for how many numbers have the i-th bit set

    // Count how many numbers have the i-th bit set
    for (const num of nums) {
      if (((num >> i) & 1) === 1) {
        bitCount++;
      }
    }

    // If more than half the numbers have this bit set, set it in the result
    if (bitCount > Math.floor(n / 2)) {
      majority |= 1 << i;
    }
  }

  // Return the reconstructed majority element
  return majority;
}
