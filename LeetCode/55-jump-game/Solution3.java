/**
 * Enum representing the status of a position in the nums array.
 */
enum Index {
  VALID, INVALID, UNKNOWN
}


/**
 * Solution class for determining if you can reach the last position starting from the first
 * position in the given nums array.
 */
public class Solution3 {

  /**
   * Determines whether you can reach the last position starting from the first position in the
   * given nums array.
   * 
   * @param nums - The array of non-negative integers where each element represents the maximum jump
   *        length at that position.
   * @return true if you can reach the last position from the first position, otherwise false.
   */
  public boolean canJump(int[] nums) {
    // Array to store the status of each position
    Index[] memo = new Index[nums.length];

    // Initialize memo array with UNKNOWN status
    for (int i = 0; i < memo.length; i++) {
      memo[i] = Index.UNKNOWN;
    }

    // The last position is always VALID
    memo[memo.length - 1] = Index.VALID;

    // Bottom-up processing to determine the status of each position
    for (int i = nums.length - 2; i >= 0; i--) {
      int furthestJump = Math.min(i + nums[i], nums.length - 1);
      for (int j = i + 1; j <= furthestJump; j++) {
        if (memo[j] == Index.VALID) {
          memo[i] = Index.VALID;
          break;
        }
      }
      // If no valid jump is found, mark the position as INVALID
      if (memo[i] != Index.VALID) {
        memo[i] = Index.INVALID;
      }
    }

    // The result is whether the first position is valid
    return memo[0] == Index.VALID;
  }
}
