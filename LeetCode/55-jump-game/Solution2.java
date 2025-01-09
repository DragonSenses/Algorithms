enum Index {
  VALID, INVALID, UNKNOWN
}

public class Solution2 {
  private Index[] memo;

  public boolean canJumpFromPosition(int position, int[] nums) {
    // Check if this position has already been evaluated
    if (memo[position] != Index.UNKNOWN) {
      return memo[position] == Index.VALID;
    }

    // Calculate the furthest position we can jump to from the current position
    int furthestJump = Math.min(position + nums[position], nums.length - 1);

    // Try to jump to each position from the next position up to the furthest jump position
    for (int nextPosition = position + 1; nextPosition <= furthestJump; nextPosition++) {
      // Recursively check if we can jump from the next position to the last index
      if (canJumpFromPosition(nextPosition, nums)) {
        memo[position] = Index.VALID;
        return true;
      }
    }

    // If none of the jumps work, mark this position as invalid
    memo[position] = Index.INVALID;
    return false;
  }

  public boolean canJump(int[] nums) {
    memo = new Index[nums.length];
    // Initialize all positions as UNKNOWN except the last one, which is VALID
    for (int i = 0; i < nums.length; i++) {
      memo[i] = Index.UNKNOWN;
    }
    memo[nums.length - 1] = Index.VALID;

    // Start the jump check from the first position in the array
    return canJumpFromPosition(0, nums);
  }
}
