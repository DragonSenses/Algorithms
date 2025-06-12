import java.util.ArrayList;
import java.util.List;

/**
 * Generates the n-bit Gray Code sequence iteratively in a single loop.
 * The sequence ensures that consecutive values differ by exactly one bit.
 *
 * @param n The number of bits in the Gray Code sequence.
 * @return A list containing the Gray Code sequence in decimal form.
 */
class Solution3 {
  public List<Integer> grayCode(int n) {
    int sequenceLength = 1 << n; // Compute 2^n for the total sequence length
    List<Integer> result = new ArrayList<>(); // Initialize result list

    // Generate Gray Code sequence iteratively
    for (int i = 0; i < sequenceLength; i++) {
      result.add(i ^ (i >> 1)); // Compute Gray Code using XOR pattern
    }

    return result; // Return final sequence
  }
}