/**
 * Generates all unique subsets of a given array using bitmasking.
 *
 * This approach leverages a bitmask to represent subset inclusion, ensuring
 * duplicate subsets are filtered using a hashcode string.
 *
 * @param {number[]} nums - Input array that may contain duplicate values.
 * @returns {number[][]} List of unique subsets.
 */
function subsetsWithDup(nums: number[]): number[][] {
  // Step 1: Sort nums to ensure consistent subset ordering
  nums.sort((a, b) => a - b);

  const n = nums.length;
  const maxSubsets = 1 << n; // Equivalent to 2^n (total possible subsets)
  const seen = new Set<string>(); // Tracks unique subsets using hashcodes
  const subsets: number[][] = []; // Stores generated subsets

  // Step 2: Iterate over all possible bitmask values
  for (let mask = 0; mask < maxSubsets; mask++) {
    const currentSubset: number[] = []; // Stores subset elements
    let hashcode = ""; // Unique identifier for duplicate tracking

    // Step 3: Determine elements present in subset
    for (let j = 0; j < n; j++) {
      // Check if the j-th bit in 'mask' is set
      if ((mask & (1 << j)) !== 0) {
        // Include nums[j] in the current subset
        currentSubset.push(nums[j]);

        // Append a comma for separation if hashcode is non-empty
        if (hashcode.length > 0) {
          hashcode += ",";
        }

        // Append the current number to the hashcode for duplicate tracking
        hashcode += nums[j];
      }
    }

    // Step 4: Add subset to results if unique
    if (!seen.has(hashcode)) {
      seen.add(hashcode);
      subsets.push(currentSubset);
    }
  }

  // Return finalized list of unique subsets
  return subsets;
}
