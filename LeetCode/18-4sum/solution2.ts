/**
 * Finds all unique quadruplets in the array which sum up to the target.
 *
 * @param nums - The input array of integers.
 * @param target - The target sum for the quadruplets.
 * @returns A list of lists, where each list contains four integers that add up to the target.
 */
function fourSum(nums: number[], target: number): number[][] {
  /**
   * Finds all unique pairs in the array which sum up to the target.
   *
   * @param start - The starting index in the array for the current twoSum calculation.
   * @param target - The target sum for the pairs.
   * @returns A list of pairs that add up to the target.
   */
  function twoSum(start: number, target: number): number[][] {
    let res: number[][] = [];
    let s = new Set<number>();

    // Iterate through the array
    for (let i = start; i < nums.length; i++) {
      // Avoid adding duplicates to result
      if (res.length == 0 || res[res.length - 1][1] != nums[i]) {
        if (s.has(target - nums[i])) {
          res.push([target - nums[i], nums[i]]);
        }
      }
      s.add(nums[i]);
    }

    return res;
  }

  /**
   * Finds all unique k-tuples in the array which sum up to the target.
   *
   * @param start - The starting index in the array for the current kSum recursion.
   * @param target - The target sum for the k-tuples.
   * @param k - The number of elements in each tuple.
   * @returns A list of k-tuples that add up to the target.
   */
  function kSum(start: number, target: number, k: number): number[][] {
    let res: number[][] = [];
    
    // If we have run out of numbers to add, return res.
    if (start === nums.length) {
      return res;
    }

    // There are k remaining values to add to the sum.
    // The average of these values is at least target / k.
    let averageValue = Math.floor(target / k);

    // We cannot obtain a sum of target if the smallest value in nums is greater than target / k
    // or if the largest value in nums is smaller than target / k.
    if (nums[start] > averageValue || averageValue > nums[nums.length - 1]) {
      return res;
    }

    // Base case: two sum problem
    if (k === 2) {
      return twoSum(start, target);
    }

    // Recursive case: reduce kSum to (k-1)Sum
    for (let i = start; i < nums.length; i++) {
      // Skip duplicates
      if (i === start || nums[i - 1] !== nums[i]) {
        kSum(i + 1, target - nums[i], k - 1).forEach((set) => {
          res.push([nums[i]].concat(set));
        });
      }
    }
    
    return res;
  }

  // Sort the input array to handle duplicates efficiently
  nums.sort((a, b) => a - b);
  
  // Call the kSum function with k set to 4 for the 4Sum problem
  return kSum(0, target, 4);
}
