enum Index {
  VALID, INVALID, UNKNOWN
}

public class Solution3 {

  public boolean canJump(int[] nums) {
    Index[] memo = new Index[nums.length];

    // Initialize memo array
    for (int i = 0; i < memo.length; i++) {
      memo[i] = Index.UNKNOWN;
    }

    // The last position is always VALID
    memo[memo.length - 1] = Index.VALID;

    // Bottom-up processing
    for (int i = nums.length - 2; i >= 0; i--) {
      int furthestJump = Math.min(i + nums[i], nums.length - 1);
      for (int j = i + 1; j <= furthestJump; j++) {
        if (memo[j] == Index.VALID) {
          memo[i] = Index.VALID;
          break;
        }
      }
      if (memo[i] != Index.VALID) {
        memo[i] = Index.INVALID;
      }
    }

    // The result is whether the first position is valid
    return memo[0] == Index.VALID;
  }
}
