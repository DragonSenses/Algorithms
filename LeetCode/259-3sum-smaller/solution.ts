function threeSumSmaller(nums: number[], target: number): number {
  // Step 1: Sort the input array nums
  nums.sort((a, b) => a - b);
  let count = 0;

  // Step 2: Iterate through the array
  for (let i = 0; i < nums.length - 2; i++) {
    let lo = i + 1;
    let hi = nums.length - 1;

    // Step 3: Use two-pointer technique to find pairs that sum to less than the target
    while (lo < hi) {
      const sum = nums[i] + nums[lo] + nums[hi];
      if (sum < target) {
        // If the sum is less than the target, count all pairs between lo and hi
        count += hi - lo;
        lo++;
      } else {
        // Move the right pointer to the left to reduce the sum
        hi--;
      }
    }
  }
  // Step 4: Return the count of valid triplets
  return count;
};
