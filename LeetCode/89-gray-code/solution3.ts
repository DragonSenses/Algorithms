/**
 * Generates the n-bit Gray Code sequence iteratively in a single loop.
 * The sequence ensures that consecutive values differ by exactly one bit.
 *
 * @param {number} n - The number of bits in the Gray Code sequence.
 * @returns {number[]} An array containing the Gray Code sequence in decimal form.
 */
function grayCode(n: number): number[] {
  const sequenceLength = 1 << n; // Compute 2^n for the total length
  const result: number[] = []; // Initialize result array

  for (let i = 0; i < sequenceLength; i++) {
    result.push(i ^ (i >> 1)); // Generate Gray Code and store it
  }

  return result; // Return final sequence
}