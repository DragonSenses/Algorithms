/**
 * Solution class for finding the majority element in an integer array. The majority element is
 * defined as the element that appears more than n / 2 times. This implementation uses a brute-force
 * approach with O(n^2) time complexity.
 */
class Solution {

  /**
   * Returns the majority element from the input array. Assumes that a majority element always
   * exists, as per problem constraints.
   *
   * @param nums the input array of integers
   * @return the majority element
   */
  public int majorityElement(int[] nums) {
    int n = nums.length;

    // Iterate through each element as a candidate for majority
    for (int i = 0; i < n; i++) {
      int count = 0;

      // Count how many times nums[i] appears in the array
      for (int j = 0; j < n; j++) {
        if (nums[j] == nums[i]) {
          count++;
        }
      }

      // If count exceeds n / 2, we've found the majority element
      if (count > n / 2) {
        return nums[i];
      }
    }

    // This line is unreachable due to problem guarantees
    return -1;
  }
}
