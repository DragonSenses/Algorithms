function subsets(nums: number[]): number[][] {
  let n = nums.length;
  let output: number[][] = [];
  for (let i = Math.pow(2, n); i < Math.pow(2, n + 1); ++i) {
    // generate bitmask, from 0..00 to 1..11
    let bitmask = (i >>> 0).toString(2).substring(1);
    // append subset corresponding to that bitmask
    let curr: number[] = [];
    for (let j = 0; j < n; ++j) {
      if (bitmask.charAt(j) == "1") curr.push(nums[j]);
    }
    output.push(curr);
  }
  return output;
}
