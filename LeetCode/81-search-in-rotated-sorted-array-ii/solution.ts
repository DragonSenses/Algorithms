function search(nums: number[], target: number): boolean {
  let start = 0;
  let end = nums.length - 1;

  while (start <= end) {
    let mid = Math.floor(start + (end - start) /2);

    // Found target
    if (nums[mid] === target) {
      return true;
    }

    // Identifying sorted half
    if (nums[start] <= nums[mid]) {
      // Left segment is sorted
      if (nums[start] <= target && target < nums[mid]) {
        // Search in left half
        end = mid - 1;
      } else {
        start = mid + 1;
      }
    }
  }

  // Target not found
  return false;
};