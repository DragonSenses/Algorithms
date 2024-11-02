import java.util.Arrays;

/**
 * Solution class for finding the number of index triplets with a sum less than
 * the target using the binary search technique.
 */
class Solution2 {
  /**
   * Finds the number of index triplets such that nums[i] + nums[j] + nums[k] <
   * target. This method uses the binary search technique.
   *
   * @param nums   The input array of integers.
   * @param target The target sum.
   * @return The count of triplets with a sum less than the target.
   */
  public int threeSumSmaller(int[] nums, int target) {
    // Step 1: Sort the array to enable the binary search
    Arrays.sort(nums);

    // Step 2: Initialize the counter to keep track of valid triplets
    int count = 0;

    // Step 3: Iterate through the array to fix the first element of the triplet
    for (int i = 0; i < nums.length - 2; i++) {
      // Step 4: Use binary search to find pairs that sum to less than target -
      // nums[i]
      count += twoSumSmaller(nums, i + 1, target - nums[i]);
    }
    // Step 6: Return the count of valid triplets
    return count;
  }

  /**
   * Helper function to find the count of pairs with a sum less than the target
   * using the binary search technique.
   *
   * @param nums       The input array of integers.
   * @param startIndex The starting index for the binary search.
   * @param target     The target sum for the pairs.
   * @return The count of pairs with a sum less than the target.
   */
  private int twoSumSmaller(int[] nums, int startIndex, int target) {
    int count = 0;

    // Iterate through the array to find pairs
    for (int i = startIndex; i < nums.length - 1; i++) {
      // Step 4: Use binary search to find the largest index where nums[i] + nums[j] <
      // target
      int j = binarySearch(nums, i, target - nums[i]);
      // Step 5: Count the pairs between i and j
      count += j - i;
    }
    return count;
  }

  /**
   * Helper function to perform binary search.
   *
   * @param nums       The input array of integers.
   * @param startIndex The starting index for the binary search.
   * @param target     The target sum for the pairs.
   * @return The largest index where nums[startIndex] + nums[j] < target.
   */
  private int binarySearch(int[] nums, int startIndex, int target) {
    int left = startIndex;
    int right = nums.length - 1;
    while (left < right) {
      int mid = (left + right + 1) / 2;
      if (nums[mid] < target) {
        // If nums[mid] is less than the target, move left to mid
        left = mid;
      } else {
        // Otherwise, move right to mid - 1
        right = mid - 1;
      }
    }
    return left;
  }
}
