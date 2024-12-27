/**
 * Adds two binary strings and returns their sum as a binary string.
 *
 * @param {string} a - The first binary string.
 * @param {string} b - The second binary string.
 * @returns {string} - The sum of the two binary strings as a binary string.
 */
function addBinary(a: string, b: string): string {
  // Convert both binary string inputs into BigInt using the "0b" prefix
  const sum = BigInt("0b" + a) + BigInt("0b" + b);
  // Convert the resulting BigInt sum back to a binary string and return it
  return sum.toString(2);
};
