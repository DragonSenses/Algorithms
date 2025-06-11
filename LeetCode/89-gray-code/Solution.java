import java.util.ArrayList;
import java.util.List;

class Solution {
  public List<Integer> grayCode(int n) {
    List<Integer> result = new ArrayList<>();
    result.add(0); // Initialize sequence with 0

    for (int i = 1; i <= n; i++) {
      int mask = 1 << (i - 1); // Set the (i-1)th bit using bit shift

    }

  }
}
