
function search(nums: number[], target: number): number {
  let left = 0;
  let right = nums.length - 1;

  // 1. Find Pivot Index (Smallest Element)
  while (left <= right) {
    const mid = Math.floor(left + (right - left) / 2);

    // Found target
    if (nums[mid] === target) {
      return mid;
    }

  }

  return -1; // Target not found
}
