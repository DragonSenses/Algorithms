/**
 * Returns the majority element from the input array. Assumes that a majority element always
 * exists, as per problem constraints.
 *
 * @param nums the input array of integers
 * @return the majority element
 */
function majorityElement(nums: number[]): number {
  const n = nums.length;

  // Iterate through each element as a candidate for majority
  for (let i = 0; i < n; i++) {
    let count = 0;

    // Count how many times nums[i] appears in the array
    for (let j = 0; j < n; j++) {
      if (nums[j] === nums[i]) {
        count++;
      }
    }

    // If count exceeds n / 2, we've found the majority element
    if (count > Math.floor(n / 2)) {
      return nums[i];
    }
  }

  return -1; // Should never reach here due to problem constraints
}