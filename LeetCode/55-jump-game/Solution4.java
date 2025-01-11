/**
 * Solution4 class that contains a method to determine if you can jump 
 * to the last index using a greedy algorithm.
 */
public class Solution4 {

  /**
   * Determines if you can jump to the last index.
   * 
   * @param nums an array of non-negative integers representing the maximum 
   *             jump length at each position
   * @return true if you can reach the last index, otherwise false
   */
  public boolean canJump(int[] nums) {
    int lastPos = nums.length - 1;
    for (int i = nums.length - 1; i >= 0; i--) {
      if (i + nums[i] >= lastPos) {
        lastPos = i;
      }
    }
    return lastPos == 0;
  }
}
