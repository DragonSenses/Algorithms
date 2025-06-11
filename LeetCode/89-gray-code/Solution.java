import java.util.ArrayList;
import java.util.List;

/**
 * Generates the n-bit Gray Code sequence iteratively.
 * The sequence ensures that consecutive values differ by exactly one bit.
 *
 * @param n The number of bits in the Gray Code sequence.
 * @return A list containing the Gray Code sequence in decimal form.
 */
class Solution {
  public List<Integer> grayCode(int n) {
    List<Integer> result = new ArrayList<>();
    result.add(0); // Initialize sequence with 0

    /**
     * Iteratively constructs the Gray Code sequence.
     * Each iteration mirrors and prepends a bit to extend the sequence.
     */
    for (int i = 1; i <= n; i++) {
      int mask = 1 << (i - 1); // Define mask by shifting (i-1)th bit

      // Reverse iterate over current sequence and apply mask to mirror values
      for (int j = result.size() - 1; j >= 0; j--) {
        result.add(result.get(j) | mask); // Prepend 1 to mirrored numbers
      }
    }

    return result; // Return final Gray Code sequence in decimal form
  }
}