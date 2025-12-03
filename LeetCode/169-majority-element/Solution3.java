/**
 * Solution class provides a method to find the majority element in an array.
 * The majority element is defined as the element that appears more than n / 2 times.
 *
 * Approach:
 * - For each of the 32 bit positions in a signed integer, count how many numbers
 *   in the array have that bit set.
 * - If more than half of the numbers have the bit set, then the majority element
 *   must also have that bit set.
 * - Reconstruct the majority element bit by bit using this logic.
 *
 * Time Complexity: O(32 * n) = O(n), since 32 is constant.
 * Space Complexity: O(1), as only counters and bit masks are used.
 */
class Solution3 {

  /**
   * Finds and returns the majority element in the given array using bitwise manipulation. Assumes
   * that a majority element always exists, as guaranteed by the problem constraints.
   *
   * @param nums the input array of integers
   * @return the majority element reconstructed bit by bit
   */
  public int majorityElement(int[] nums) {
    int majority = 0; // Result variable to hold reconstructed majority element
    int n = nums.length;

    // Iterate over all 32 bit positions (for signed 32-bit integers)
    for (int i = 0; i < 32; i++) {
      int bitCount = 0; // Counter for how many numbers have the i-th bit set

      // Count how many numbers have the i-th bit set
      for (int num : nums) {
        if (((num >> i) & 1) == 1) {
          bitCount++;
        }
      }

      // If more than half the numbers have this bit set, set it in the result
      if (bitCount > n / 2) {
        majority |= (1 << i);
      }
    }

    // Return the reconstructed majority element
    return majority;
  }
}
