
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

    // Determine which half is sorted
    if (nums[left] <= nums[mid]) {
      // Left half is sorted
      if (nums[left] <= target && target < nums[mid]) {
        // Search in left sorted half
        right = mid - 1;
      } else {
        // Search in right half
        left = mid + 1; 
      }
    }
    
  }

  return -1; // Target not found
}
