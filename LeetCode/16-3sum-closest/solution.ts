/**
 * Finds the sum of three integers in nums such that the sum is closest to the target.
 * Assumes there is exactly one solution.
 *
 * @param nums - An array of integers.
 * @param target - The target sum.
 * @returns The sum of the three integers closest to the target.
 */
function threeSumClosest(nums: number[], target: number): number {
  // Step 1: Initialize the minimum difference diff with a large value
  let diff = Number.MAX_SAFE_INTEGER;

  // Step 2: Sort the input array nums
  nums.sort((a, b) => a - b);

  // Step 3: Iterate through the array
  for (let i = 0; i < nums.length - 2; i++) {
    let lo = i + 1;
    let hi = nums.length - 1;

    while (lo < hi) {
      const sum = nums[i] + nums[lo] + nums[hi];

      // If the absolute difference is smaller, update diff
      if (Math.abs(target - sum) < Math.abs(diff)) {
        diff = target - sum;
      }

      // Move pointers based on sum comparison to target
      if (sum < target) {
        lo++;
      } else {
        hi--;
      }

      // If diff is zero, closest sum found, break
      if (diff === 0) {
        break;
      }
    }
  }

  // Step 4: Return the value of the closest triplet sum
  return target - diff;
};
