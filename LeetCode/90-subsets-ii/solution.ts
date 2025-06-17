function subsetsWithDup(nums: number[]): number[][] {
  // 1: Sort input array
  nums.sort((a, b) => a - b);

  const n = nums.length;
  const maxSubsets = 1 << n; // Equivalent to 2^n
  const seen = new Set<string>();
  const subsets: number[][] = [];

  // 2: Iterate over all possible bitmask values
  for (let mask = 0; mask < maxSubsets; mask++) {
    const currentSubset: number[] = [];
    let hashcode = "";

    // 3: Determine elements present in subset
    for (let j = 0; j < n; j++) {
      // Check if j-th bit is set
      if ((mask & (1 << j)) != 0) {
        // Include nums[j] in the current subset
        currentSubset.push(nums[j]);

        // Append a comma to separate elements in the hashcode (if not the first element)
        if (hashcode.length > 0) {
          hashcode += ",";
        }

        // Append the current number to the hashcode string (used for duplicate tracking)
        hashcode += (nums[j]);
      }
    }
  }
}
