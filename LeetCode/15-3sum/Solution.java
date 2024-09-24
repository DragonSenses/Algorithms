import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

  /**
   * Finds all unique triplets in the array which gives the sum of zero.
   *
   * @param nums the input array of integers
   * @return a list of lists containing all unique triplets that sum to zero
   */
  public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    
    // Sort the array
    Arrays.sort(nums);
    
    // Iterate through the array
    for (int i = 0; i < nums.length - 2; i++) {
      // If the current value is greater than zero, break from the loop
      if (nums[i] > 0) {
        break;
      }
      
      // Skip the same element to avoid duplicates
      if (i > 0 && nums[i] == nums[i - 1]) {
        continue;
      }
      
      // Call twoSumII for the current position i
      twoSumII(nums, i, res);
    }
    
    return res;
  }

  /**
   * Helper function to find pairs that sum to the target using two pointers.
   *
   * @param nums the input array of integers
   * @param i the current index in the array
   * @param res the result list to store triplets
   */
  private void twoSumII(int[] nums, int i, List<List<Integer>> res) {
    int lo = i + 1, hi = nums.length - 1;
    int target = -nums[i];
    
    while (lo < hi) {
      int sum = nums[lo] + nums[hi];
      
      if (sum < target) {
        lo++;
      } else if (sum > target) {
        hi--;
      } else {
        res.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
        lo++;
        hi--;
        
        // Skip the same element to avoid duplicates in the result
        while (lo < hi && nums[lo] == nums[lo - 1]) {
          lo++;
        }
      }
    }
  }
}
