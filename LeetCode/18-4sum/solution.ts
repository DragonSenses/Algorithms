function fourSum(nums: number[], target: number): number[][] {
  nums.sort((a, b) => a - b);
  return kSum(nums, target, 0, 4);
}

function kSum(
  nums: number[],
  target: number,
  start: number,
  k: number
): number[][] {
  let res: number[][] = [];
  // If we have run out of numbers to add, return res.
  if (start === nums.length) {
    return res;
  }
  // There are k remaining values to add to the sum. The
  // average of these values is at least target / k.
  let average_value = target / k;
  // We cannot obtain a sum of target if the smallest value
  // in nums is greater than target / k or if the largest
  // value in nums is smaller than target / k.
  if (nums[start] > average_value || average_value > nums[nums.length - 1]) {
    return res;
  }
  if (k === 2) {
    return twoSum(nums, target, start);
  }
  for (let i = start; i < nums.length; i++) {
    if (i === start || nums[i - 1] !== nums[i]) {
      for (let subset of kSum(nums, target - nums[i], i + 1, k - 1)) {
        res.push([nums[i], ...subset]);
      }
    }
  }
  return res;
}

function twoSum(nums: number[], target: number, start: number): number[][] {
  let res: number[][] = [];
  let lo: number = start,
    hi: number = nums.length - 1;
  while (lo < hi) {
    let curr_sum: number = nums[lo] + nums[hi];
    if (curr_sum < target || (lo > start && nums[lo] === nums[lo - 1])) {
      ++lo;
    } else if (
      curr_sum > target ||
      (hi < nums.length - 1 && nums[hi] === nums[hi + 1])
    ) {
      --hi;
    } else {
      res.push([nums[lo++], nums[hi--]]);
    }
  }
  return res;
}
