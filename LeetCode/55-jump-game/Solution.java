/**
 * This class provides a solution to the "Jump Game" problem.
 */
public class Solution {

  /**
   * Determines if you can jump from a given position to the last index in the array.
   *
   * @param position The current position in the array.
   * @param nums The array representing maximum jump lengths.
   * @return True if you can reach the last index from the given position, otherwise false.
   */
  public boolean canJumpFromPosition(int position, int[] nums) {
    // Base case: If the current position is the last index, return true.
    if (position == nums.length - 1) {
      return true;
    }

    // Calculate the furthest position we can jump to from the current position.
    int furthestJump = Math.min(position + nums[position], nums.length - 1);

    // Try to jump to each position from the furthest jump position down to the next position.
    for (int nextPosition = furthestJump; nextPosition > position; nextPosition--) {
      // Recursively check if we can jump from the next position to the last index.
      if (canJumpFromPosition(nextPosition, nums)) {
        return true;
      }
    }

    // If none of the jumps work, return false.
    return false;
  }

  /**
   * Determines if you can jump from the first index to the last index in the array.
   *
   * @param nums The array representing maximum jump lengths.
   * @return True if you can reach the last index, otherwise false.
   */
  public boolean canJump(int[] nums) {
    // Start the jump check from the first position in the array.
    return canJumpFromPosition(0, nums);
  }
}
