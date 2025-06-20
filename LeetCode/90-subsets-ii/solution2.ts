function subsetsWithDup(nums: number[]): number[][] {
  // Step 1: Sort nums to ensure duplicates are grouped together
  nums.sort((a, b) => a - b);

  const subsets: number[][] = [[]]; // Start with an empty subset
  let subsetSize = 0; // Tracks the index where duplicates should start being added

  // Step 2: Iterate through the elements in nums
  for (let i = 0; i < nums.length; i++) {
    let startIndex = i > 0 && nums[i] === nums[i - 1] ? subsetSize : 0;
    subsetSize = subsets.length; // Update subsetSize to current subset count

    // Step 3: Add nums[i] to appropriate subsets
    for (let j = startIndex; j < subsetSize; j++) {
      subsets.push([...subsets[j], nums[i]]);
    }
  }

}
