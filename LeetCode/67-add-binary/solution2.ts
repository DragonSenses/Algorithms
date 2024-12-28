/**
 * Adds two binary strings and returns their sum as a binary string.
 *
 * @param {string} a - The first binary string.
 * @param {string} b - The second binary string.
 * @returns {string} - The sum of the two binary strings as a binary string.
 */
function addBinary(a: string, b: string): string {
  let result: string[] = [];
  let carry = 0;
  let i = a.length - 1;
  let j = b.length - 1;

  // Iterate from the end of both strings towards the beginning
  while (i >= 0 || j >= 0) {
    let sum = carry;
    if (i >= 0) {
      // Convert the character to its integer value by subtracting '0'
      sum += parseInt(a.charAt(i--));
    }
    if (j >= 0) {
      // Convert the character to its integer value by subtracting '0'
      sum += parseInt(b.charAt(j--));
    }
    // Append the current bit to the result
    result.push((sum % 2).toString());
    // Update the carry
    carry = Math.floor(sum / 2);
  }

  // If there's a remaining carry, append it
  if (carry !== 0) {
    result.push(carry.toString());
  }

  // Reverse the result to get the correct binary sum
  return result.reverse().join("");
}
