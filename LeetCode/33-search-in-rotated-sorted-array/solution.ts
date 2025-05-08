function search(nums: number[], target: number): number {
  let left = 0;
  let right = nums.length - 1;

  while(left < right) {
    let mid = Math.floor(left + (right - left) / 2);
    if (nums[mid] > nums[right]) {
      left = mid + 1;
    } else {
      right = mid;
    }
  }

  const pivotIndex = left;
};