/**
 * Bitwise Manipulation Approach to find the majority element.
 * Reconstructs the majority element bit by bit by counting 1s at each bit position.
 */
function majorityElement(nums: number[]): number {
  let majority = 0;
  const n = nums.length;

  // Iterate over all 32 bit positions
  for (let i = 0; i < 32; i++) {
    let bitCount = 0;

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

}