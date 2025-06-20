function subsetsWithDup(nums: number[]): number[][] {
  // Step 1: Sort nums to ensure duplicates are grouped together
  nums.sort((a, b) => a - b);

  const subsets: number[][] = [[]]; // Start with an empty subset
  let subsetSize = 0; // Tracks the index where duplicates should start being added

}
