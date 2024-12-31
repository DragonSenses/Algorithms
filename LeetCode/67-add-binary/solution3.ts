/**
 * Adds two binary strings and returns their sum as a binary string.
 *
 * @param {string} a - The first binary string.
 * @param {string} b - The second binary string.
 * @returns {string} - The sum of the two binary strings as a binary string.
 */
function addBinary(a: string, b: string): string {
  // Convert binary strings to BigInt
  let x = BigInt(`0b${a}`);
  let y = BigInt(`0b${b}`);

  // Loop until there is no carry
  while (y !== 0n) {
    // Current answer without carry is XOR of x and y
    const answer = x ^ y;
    // Current carry is left-shifted AND of x and y
    const carry = (x & y) << 1n;
    // Prepare for the next loop
    x = answer;
    y = carry;
  }

  // Convert the final result back to a binary string
  return x.toString(2);
};
