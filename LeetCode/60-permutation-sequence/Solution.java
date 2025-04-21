import java.util.ArrayList;
import java.util.List;

class Solution {
  // @input n = [1, 2, 3, ..., n]
  // @input k = kth sequence
  // label permutations in order
  public String getPermutation(int n, int k) {
    // Generate input list 1 to n
    List<Integer> nums = new ArrayList<>();
    
    for (int i = 1; i <= n; i++) {
      nums.add(i);
    }

    int[] factorials = new int[n + 1];
    factorials[0] = 1;

    for (int i = 1; i <= n; i++) {
      factorials[i] = factorials[i - 1] * i;
    }

  }
}