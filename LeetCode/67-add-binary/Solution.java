class Solution {
  /**
   * Adds two binary strings and returns their sum as a binary string.
   *
   * @param a The first binary string.
   * @param b The second binary string.
   * @return The sum of the two binary strings as a binary string.
   */
  public String addBinary(String a, String b) {
    return Integer.toBinaryString(Integer.parseInt(a, 2) + Integer.parseInt(b, 2));
  }
}