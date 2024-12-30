import java.math.BigInteger;

class Solution3 {
  /**
   * Adds two binary strings using bit manipulation and returns their sum as a binary string.
   *
   * @param a The first binary string.
   * @param b The second binary string.
   * @return The sum of the two binary strings as a binary string.
   */
  public String addBinary(String a, String b) {
    // Convert binary strings to BigInteger objects
    BigInteger x = new BigInteger(a, 2);
    BigInteger y = new BigInteger(b, 2);

    // Define a BigInteger object representing zero
    BigInteger zero = new BigInteger("0", 2);

    BigInteger carry, answer;

    // Loop until there is no carry left
    while (y.compareTo(zero) != 0) {
      // XOR the two numbers to get the sum without carry
      answer = x.xor(y);

      // AND the two numbers and shift left to get the carry
      carry = x.and(y).shiftLeft(1);

      // Update x to the current answer
      x = answer;

      // Update y to the current carry
      y = carry;
    }

    // Convert the result back to a binary string and return it
    return x.toString(2);
  }
}
