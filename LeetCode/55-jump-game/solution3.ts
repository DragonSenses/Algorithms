/**
 * Enum representing the status of a position in the `nums` array.
 */
enum Index {
  VALID,
  INVALID,
  UNKNOWN
}

/**
 * Determines whether you can reach the last position starting from the first position in the given `nums` array.
 * 
 * This function uses dynamic programming with bottom-up processing to check the feasibility.
 * 
 * @param nums - The array of non-negative integers where each element represents the maximum jump length at that position.
 * @returns `true` if you can reach the last position from the first position, otherwise `false`.
 */
function canJump(nums: number[]): boolean {
  const n = nums.length;
  const memo: Index[] = new Array(n).fill(Index.UNKNOWN);

  // The last position is always VALID
  memo[n - 1] = Index.VALID;

  // Bottom-up processing
  for (let i = n - 2; i >= 0; i--) {
    const furthestJump = Math.min(i + nums[i], n - 1);
    for (let j = i + 1; j <= furthestJump; j++) {
      if (memo[j] === Index.VALID) {
        memo[i] = Index.VALID;
        break;
      }
    }
    if (memo[i] !== Index.VALID) {
      memo[i] = Index.INVALID;
    }
  }

  // The result is whether the first position is valid
  return memo[0] === Index.VALID;
}
