/**
 * Brute force approach to finding the number of index triplets with a sum less
 * than the target.
 */
class Solution3 {
  /**
   * Finds the number of index triplets such that nums[i] + nums[j] + nums[k] <
   * target.
   * This method uses the brute force approach.
   *
   * @param nums   The input array of integers.
   * @param target The target sum.
   * @return The count of triplets with a sum less than the target.
   */
  public int threeSumSmaller(int[] nums, int target) {
    int count = 0;

    // Triple nested loop to generate all possible triplets
    for (int i = 0; i < nums.length - 2; i++) {
      for (int j = i + 1; j < nums.length - 1; j++) {
        for (int k = j + 1; k < nums.length; k++) {
          // Check if the sum of the triplet is less than the target
          if (nums[i] + nums[j] + nums[k] < target) {
            // Increment the counter if the condition is met
            count++;
          }
        }
      }
    }

    // Return the count of valid triplets
    return count;
  }
}
