import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * This class provides a solution to the kSum problem, specifically solving the 4Sum variant.
 */
class Solution2 {

  /**
   * Finds all unique quadruplets in the array which sum up to the target.
   *
   * @param nums   - The input array of integers.
   * @param target - The target sum for the quadruplets.
   * @return A list of lists, where each list contains four integers that add up to the target.
   */
  public List<List<Integer>> fourSum(int[] nums, int target) {
    // Sort the input array to handle duplicates efficiently
    Arrays.sort(nums);
    // Call the kSum function with k set to 4 for the 4Sum problem
    return kSum(nums, (long) target, 0, 4);
  }

  /**
   * Finds all unique k-tuples in the array which sum up to the target.
   *
   * @param nums   - The input array of integers.
   * @param target - The target sum for the k-tuples.
   * @param start  - The starting index in the array for the current kSum recursion.
   * @param k      - The number of elements in each tuple.
   * @return A list of lists, where each list contains k integers that add up to the target.
   */
  public List<List<Integer>> kSum(int[] nums, long target, int start, int k) {
    List<List<Integer>> res = new ArrayList<>();
    
    // Base case: if we have run out of numbers to add, return res.
    if (start == nums.length) {
      return res;
    }

    // There are k remaining values to add to the sum.
    // The average of these values is at least target / k.
    long average_value = target / k;

    // We cannot obtain a sum of target if the smallest value in nums is greater than target / k
    // or if the largest value in nums is smaller than target / k.
    if (nums[start] > average_value || average_value > nums[nums.length - 1]) {
      return res;
    }

    // Base case: two sum problem
    if (k == 2) {
      return twoSum(nums, target, start);
    }

    // Recursive case: reduce kSum to (k-1)Sum
    for (int i = start; i < nums.length; ++i) {
      // Skip duplicates
      if (i == start || nums[i - 1] != nums[i]) {
        for (List<Integer> subset : kSum(nums, target - nums[i], i + 1, k - 1)) {
          res.add(new ArrayList<>(Arrays.asList(nums[i])));
          res.get(res.size() - 1).addAll(subset);
        }
      }
    }
    return res;
  }

  /**
   * Finds all unique pairs in the array which sum up to the target.
   *
   * @param nums   - The input array of integers.
   * @param target - The target sum for the pairs.
   * @param start  - The starting index in the array for the current twoSum calculation.
   * @return A list of lists, where each list contains two integers that add up to the target.
   */
  public List<List<Integer>> twoSum(int[] nums, long target, int start) {
    List<List<Integer>> res = new ArrayList<>();
    Set<Long> s = new HashSet<>();

    // Iterate through the array
    for (int i = start; i < nums.length; ++i) {
      // Avoid adding duplicates to result
      if (res.isEmpty() || res.get(res.size() - 1).get(1) != nums[i]) {
        if (s.contains(target - nums[i])) {
          res.add(Arrays.asList((int) target - nums[i], nums[i]));
        }
      }
      s.add((long) nums[i]);
    }
    return res;
  }
}
