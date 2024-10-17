import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This class provides a solution to the kSum problem, specifically solving the 4Sum variant.
 */
public class Solution {

  /**
   * Finds all unique quadruplets in the array which sum up to the target.
   *
   * @param nums   - The input array of integers.
   * @param target - The target sum for the quadruplets.
   * @return A list of lists, where each list contains four integers that add up to the target.
   */
  public List<List<Integer>> fourSum(int[] nums, int target) {
    Arrays.sort(nums);
    return kSum(nums, (long) target, 4, 0);
  }

  /**
   * Finds all unique k-tuples in the array which sum up to the target.
   *
   * @param nums   - The input array of integers.
   * @param target - The target sum for the k-tuples.
   * @param k      - The number of elements in each tuple.
   * @param start  - The starting index in the array for the current kSum recursion.
   * @return A list of lists, where each list contains k integers that add up to the target.
   */
  private List<List<Integer>> kSum(int[] nums, long target, int k, int start) {
    List<List<Integer>> res = new ArrayList<>();
    if (start == nums.length || nums[start] * k > target || nums[nums.length - 1] * k < target) {
      return res;
    }

    if (k == 2) {
      return twoSum(nums, target, start);
    }

    for (int i = start; i < nums.length; i++) {
      if (i > start && nums[i] == nums[i - 1]) continue;
      for (List<Integer> subset : kSum(nums, target - nums[i], k - 1, i + 1)) {
        res.add(new ArrayList<>(Arrays.asList(nums[i])));
        res.get(res.size() - 1).addAll(subset);
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
  private List<List<Integer>> twoSum(int[] nums, long target, int start) {
    List<List<Integer>> res = new ArrayList<>();
    int lo = start, hi = nums.length - 1;

    while (lo < hi) {
      long sum = (long) nums[lo] + nums[hi];
      if (sum == target) {
        res.add(Arrays.asList(nums[lo], nums[hi]));
        while (lo < hi && nums[lo] == nums[lo + 1]) lo++;
        while (lo < hi && nums[hi] == nums[hi - 1]) hi--;
        lo++;
        hi--;
      } else if (sum < target) {
        lo++;
      } else {
        hi--;
      }
    }

    return res;
  }
}
