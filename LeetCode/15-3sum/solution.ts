/**
 * Finds all unique triplets in the array which give the sum of zero.
 *
 * @param nums - The input array of integers
 * @returns A list of lists containing all unique triplets that sum up to zero
 */
function threeSum(nums: number[]): number[][] {
  // Initialize the result array
  const result: number[][] = [];

  // Return empty result if input is null or has less than 3 elements
  if (!nums || nums.length < 3) {
    return result;
  }

  // Sort the array to facilitate the two-pointer approach and avoid duplicates
  nums.sort((a, b) => a - b);

  // Iterate through the array, treating each element as a potential pivot
  for (let i = 0; i < nums.length - 2; i++) {
    // Skip duplicate elements to avoid duplicate triplets in the result
    if (i > 0 && nums[i] === nums[i - 1]) {
      continue;
    }

    // Initialize a Set to store elements visited so far
    const visited: Set<number> = new Set();

    for (let j = i + 1; j < nums.length; j++) {
      const complement = -nums[i] - nums[j];

      // Check if the complement exists in the Set
      if (visited.has(complement)) {
        // Found a triplet that sums to zero, add it to the result
        result.push([nums[i], nums[j], complement]);

        // Skip duplicate elements to avoid duplicate triplets in the result
        while (j + 1 < nums.length && nums[j] === nums[j + 1]) {
          j++;
        }
      }

      // Add the current element to the Set
      visited.add(nums[j]);
    }
  }

  return result;
};
