function canJump(nums: number[]): boolean {
  return backtrack(0, nums);
}

function backtrack(position: number, nums: number[]): boolean {
  if (position === nums.length - 1) {
    return true;
  }

  const furthestJump = Math.min(position + nums[position], nums.length - 1);
  for (
    let nextPosition = position + 1;
    nextPosition <= furthestJump;
    nextPosition++
  ) {
    if (backtrack(nextPosition, nums)) {
      return true;
    }
  }

  return false;
};
