/**
 * Enum representing the state of each position in the array.
 */
enum Index {
  VALID,
  INVALID,
  UNKNOWN,
}

/**
 * Determines if you can reach the last index in the array.
 * @param nums - An array of non-negative integers representing the maximum jump length at each position.
 * @returns True if you can reach the last index, otherwise false.
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
