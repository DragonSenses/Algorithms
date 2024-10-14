import java.util.Arrays;

class Solution {

  /**
   * Finds the sum of three integers in nums such that the sum is closest to the target.
   * Assumes there is exactly one solution.
   *
   * @param nums - array of integers
   * @param target - the target sum
   * @return The sum of the three integers closest to the target
   */
  public int threeSumClosest(int[] nums, int target) {
    // Step 1: Initialize the minimum difference diff with a large value
    int diff = Integer.MAX_VALUE;

    // Step 2: Sort the input array nums
    Arrays.sort(nums);

    // Step 3: Iterate through the array
    for (int i = 0; i < nums.length - 2; i++) {
      int lo = i + 1;
      int hi = nums.length - 1;

      while (lo < hi) {
        int sum = nums[i] + nums[lo] + nums[hi];

        // If the absolute difference is smaller, update diff
        if (Math.abs(target - sum) < Math.abs(diff)) {
          diff = target - sum;
        }

        // Move pointers based on sum comparison to target
        if (sum < target) {
          lo++;
        } else {
          hi--;
        }

        // If diff is zero, closest sum found, break
        if (diff == 0) {
          break;
        }
      }
    }

    // Step 4: Return the value of the closest triplet sum
    return target - diff;
  }
}
