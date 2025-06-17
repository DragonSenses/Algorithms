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
  }
}
