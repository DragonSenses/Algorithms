/**
 * Generates the n-bit Gray Code sequence using recursive backtracking.
 * Each number in the sequence differs by exactly one bit from the previous number.
 *
 * @param {number} n - The number of bits in the Gray Code sequence.
 * @returns {number[]} The Gray Code sequence in decimal representation.
 */
function grayCode(n: number): number[] {
  // Compute total sequence length (2^n)
  const totalLength = 1 << n;

  // Initialize sequence with 0, as Gray Code always starts from zero
  const sequence: number[] = [0];

  // Maintain a set of visited numbers to ensure each step is unique
  const visited = new Set<number>();
  visited.add(0);

  /**
   * Performs recursive backtracking to construct the Gray Code sequence.
   * Iterates through n bits, toggling each bit to generate valid transitions.
   *
   * @returns {boolean} True if a complete Gray Code sequence is found, false otherwise.
   */
  function backtrack(): boolean {
    // Base case: Stop when the sequence reaches the required length
    if (sequence.length === totalLength) {
      return true; // Successfully generated the full sequence
    }

    // Get the last number in the sequence to determine the next step
    const current = sequence[sequence.length - 1];

    for (let i = 0; i < n; i++) {
      // Flip the ith bit using XOR and left shift to generate the next number
      const next = current ^ (1 << i);

      if (!visited.has(next)) {
        // Add the newly generated number to the sequence and track it
        sequence.push(next);
        visited.add(next);

        // Recursively attempt to build the sequence
        if (backtrack()) {
          return true; // Stop if a valid sequence is found
        }

        // Backtrack: Remove last added number and restore state
        sequence.pop();
        visited.delete(next);
      }
    }
    return false; // No valid sequence found
  }

  backtrack();
  return sequence;
}
