import java.util.Arrays;

/**
 * Solution class for finding the number of index triplets with a sum less than
 * the target using the two-pointer technique.
 */
class Solution {

  /**
   * Finds the number of index triplets such that nums[i] + nums[j] + nums[k] <
   * target.
   * This method uses the two-pointer technique.
   *
   * @param nums   The input array of integers.
   * @param target The target sum.
   * @return The count of triplets with a sum less than the target.
   */
  public int threeSumSmaller(int[] nums, int target) {
    // Sort the array to enable the two-pointer technique
    Arrays.sort(nums);
    int count = 0;
    // Iterate through the array, treating each element as the potential first
    // element of the triplet
    for (int i = 0; i < nums.length - 2; i++) {
      // Use two-pointer technique to find pairs that sum to less than the target -
      // nums[i]
      count += twoSumSmaller(nums, i + 1, target - nums[i]);
    }
    return count;
  }

  /**
   * Helper function to find the count of pairs with a sum less than the target
   * using the two-pointer technique.
   *
   * @param nums       The input array of integers.
   * @param startIndex The starting index for the two-pointer search.
   * @param target     The target sum for the pairs.
   * @return The count of pairs with a sum less than the target.
   */
  private int twoSumSmaller(int[] nums, int startIndex, int target) {
    int count = 0;
    int left = startIndex;
    int right = nums.length - 1;
    // Use two pointers to find pairs that sum to less than the target
    while (left < right) {
      if (nums[left] + nums[right] < target) {
        // If the sum is less than the target, all pairs between left and right satisfy
        // the condition
        count += right - left;
        left++;
      } else {
        // Move the right pointer to the left to reduce the sum
        right--;
      }
    }
    return count;
  }
}
