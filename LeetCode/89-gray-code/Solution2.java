import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Solution2 class implements Gray Code generation using recursive backtracking.
 */
class Solution2 {

  /**
   * Generates the n-bit Gray Code sequence using a backtracking approach.
   * 
   * @param n The number of bits in the Gray Code sequence.
   * @return A list containing the decimal representation of the Gray Code sequence.
   */
  public List<Integer> grayCode(int n) {
    int totalLength = 1 << n; // 2^n
    List<Integer> sequence = new ArrayList<>();
    Set<Integer> visited = new HashSet<>();

    // Initialize the sequence with 0
    sequence.add(0);
    visited.add(0);

    // Start recursive search to build the Gray Code sequence
    backtrack(n, totalLength, sequence, visited);

    return sequence;
  }

  /**
   * Recursive backtracking function to generate the Gray Code sequence. Iterates over n bits,
   * toggling each bit to form valid Gray Code numbers.
   * 
   * @param n The number of bits in the sequence.
   * @param totalLength The total length of the Gray Code sequence (2^n).
   * @param sequence The list storing the current sequence.
   * @param visited A set tracking visited numbers to prevent duplicates.
   * @return True if a valid Gray Code sequence is found, false otherwise.
   */
  private boolean backtrack(int n, int totalLength, List<Integer> sequence, Set<Integer> visited) {
    if (sequence.size() == totalLength) {
      return true; // Valid sequence found
    }

    // Retrieve the most recent number in the sequence to generate the next Gray Code value
    int current = sequence.get(sequence.size() - 1);
    
    for (int i = 0; i < n; i++) {
      int next = current ^ (1 << i); // Flip ith bit

      if (!visited.contains(next)) {
        sequence.add(next);
        visited.add(next);

        if (backtrack(n, totalLength, sequence, visited)) {
          return true; // Early stop if sequence is completed
        }

        // Backtrack: Remove last added number and continue search
        sequence.remove(sequence.size() - 1);
        visited.remove(next);
      }
    }
    return false; // No valid extension found
  }
}
