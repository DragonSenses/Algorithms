function search(nums: number[], target: number): boolean {
  let start = 0;
  let end = nums.length - 1;

  while (start <= end) {
    let mid = Math.floor(start + (end - start) /2);

    // Found target
    if (nums[mid] === target) {
      return true;
    }
  }

  // Target not found
  return false;
};