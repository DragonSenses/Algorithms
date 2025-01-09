/**
 * Determines if you are able to reach the last index.
 * @param nums - An array of non-negative integers representing the maximum jump length at that position.
 * @returns True if you can reach the last index, otherwise false.
 */
function canJump(nums: number[]): boolean {
  return backtrack(0, nums);
}

/**
 * Helper function to perform backtracking to check if the end can be reached.
 * @param position - Current position in the array.
 * @param nums - Array of non-negative integers representing the maximum jump length at that position.
 * @returns True if the end can be reached from the current position, otherwise false.
 */
function backtrack(position: number, nums: number[]): boolean {
  // If we've reached the last index, return true.
  if (position === nums.length - 1) {
    return true;
  }

  // Calculate the furthest we can jump from the current position.
  const furthestJump = Math.min(position + nums[position], nums.length - 1);

  // Try jumping to each position from the current position up to the furthest jump.
  for (
    let nextPosition = position + 1;
    nextPosition <= furthestJump;
    nextPosition++
  ) {
    // If jumping to this position allows us to reach the end, return true.
    if (backtrack(nextPosition, nums)) {
      return true;
    }
  }

  // If no jump allows us to reach the end, return false.
  return false;
}
