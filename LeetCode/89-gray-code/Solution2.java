import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution2 {
  public List<Integer> grayCode(int n) {
    List<Integer> sequence = new ArrayList<>();
    Set<Integer> visited = new HashSet<>();

    // Initialize the sequence with 0
    sequence.add(0);
    visited.add(0);

    return sequence;
  }

  private boolean backtrack(int n, List<Integer> sequence, Set<Integer> visited) {

    int current = sequence.get(sequence.size() - 1);
    for (int i = 0; i < n; i++) {
      int next = current ^ (1 << i); // Flip ith bit

      if (!visited.contains(next)) {
        sequence.add(next);
        visited.add(next);

        if (backtrack(n, sequence, visited)) {
          return true; // Early stop if sequence is completed
        }

        // Backtrack
        sequence.remove(sequence.size() - 1);
        visited.remove(next);
      }
    }
  }
}