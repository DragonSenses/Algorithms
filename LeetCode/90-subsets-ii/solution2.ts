/**
 * Generates all unique subsets of a given array using a cascading, iterative approach.
 *
 * @param nums - Input array that may contain duplicates.
 * @returns A list of all unique subsets.
 */
function subsetsWithDup(nums: number[]): number[][] {
  // Step 1: Sort nums to ensure duplicates are grouped together
  nums.sort((a, b) => a - b);

  const subsets: number[][] = [[]]; // Start with an empty subset
  let subsetSize = 0; // Tracks the subset count before current expansion

  // Step 2: Iterate through each number in nums
  for (let i = 0; i < nums.length; i++) {
    let startIndex;

    // If current number is a duplicate, only extend subsets
    // that were created in the previous iteration
    if (i > 0 && nums[i] === nums[i - 1]) {
      startIndex = subsetSize;
    } else {
      // If it's a new number, extend all existing subsets
      startIndex = 0;
    }

    subsetSize = subsets.length; // Snapshot current size before appending new subsets

    // Step 3: Clone and extend subsets from startIndex to subsetSize
    for (let j = startIndex; j < subsetSize; j++) {
      subsets.push([...subsets[j], nums[i]]);
    }
  }

  // Step 4: Return the list of all unique subsets
  return subsets;
}
