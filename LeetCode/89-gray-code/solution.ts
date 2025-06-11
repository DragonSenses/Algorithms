/**
 * Generates the n-bit Gray Code sequence iteratively.
 * The sequence ensures that consecutive values differ by exactly one bit.
 *
 * @param {number} n - The number of bits in the Gray Code sequence.
 * @returns {number[]} An array containing the Gray Code sequence in decimal form.
 */
function grayCode(n: number): number[] {
  const result: number[] = [0]; // Initialize sequence with 0

  /**
   * Iteratively constructs the Gray Code sequence.
   * Each iteration mirrors the sequence and applies bitwise shifts.
   */
  for (let i = 0; i < n; i++) {
    const mask = 1 << i; // Create mask by shifting bit i

    // Reverse iterate over current sequence and apply mask
    // Ensures mirrored extension where higher-bit numbers are added
    for (let j = result.length - 1; j >= 0; j--) {
      result.push(result[j] | mask); // Prepend 1 to mirrored values
    }
  }

  return result; // Final Gray Code sequence in decimal form
}