/**
 * Determines whether you can reach the last position starting from the first position in the given nums array.
 *
 * This function uses a greedy algorithm to check the feasibility.
 *
 * @param nums - The array of non-negative integers where each element represents the maximum jump length at that position.
 * @returns `true` if you can reach the last position from the first position, otherwise `false`.
 */
function canJump(nums: number[]): boolean {
  // Initialize the last position as the target
  let lastPos = nums.length - 1;

  // Iterate from the second-to-last position to the first position
  for (let i = nums.length - 1; i >= 0; i--) {
    // Check if the current position can reach the last known valid position
    if (i + nums[i] >= lastPos) {
      // Update the last known valid position
      lastPos = i;
    }
  }

  // Return true if the first position can reach the last position
  return lastPos === 0;
}
