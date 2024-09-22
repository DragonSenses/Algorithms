public class Solution {
  /**
   * Finds two numbers in a sorted array that add up to a specific target.
   *
   * @param numbers the sorted array of integers
   * @param target the target sum
   * @return an array containing the 1-based indices of the two numbers
   * @throws IllegalArgumentException if no solution is found
   */
  public int[] twoSum(int[] numbers, int target) {
    // Initialize two pointers
    int left = 0;
    int right = numbers.length - 1;
    
    // Iterate until the two pointers meet
    while (left < right) {
      // Calculate the sum of the elements at the two pointers
      int sum = numbers[left] + numbers[right];
      
      // Check if the sum matches the target
      if (sum == target) {
        // Return 1-based indices
        return new int[]{left + 1, right + 1};
      } else if (sum < target) {
        // Move the left pointer to the right to increase the sum
        left++;
      } else {
        // Move the right pointer to the left to decrease the sum
        right--;
      }
    }
    
    // Since the problem guarantees exactly one solution, we should never reach here
    throw new IllegalArgumentException("No two sum solution");
  }
}
