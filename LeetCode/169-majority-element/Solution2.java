import java.util.HashMap;

/**
 * Solution2 class provides a method to find the majority element in an array. The majority element
 * is defined as the element that appears more than n / 2 times.
 * 
 * Approach: - Use a HashMap to count the frequency of each element. - Return the element once its
 * count exceeds the threshold (n / 2).
 * 
 * Time Complexity: O(n) Space Complexity: O(n)
 */
public class Solution2 {

  /**
   * Finds and returns the majority element in the given array. Assumes that a majority element
   * always exists, as guaranteed by the problem constraints.
   *
   * @param nums the input array of integers
   * @return the majority element
   */
  public int majorityElement(int[] nums) {
    // HashMap to store frequency of each element
    HashMap<Integer, Integer> frequencyMap = new HashMap<>();

    // Threshold for majority element (appears more than n/2 times)
    int threshold = nums.length / 2;

    // Iterate through each number in the array
    for (int num : nums) {
      // Increment count for current number
      int count = frequencyMap.getOrDefault(num, 0) + 1;

      // Update the frequency map with new count
      frequencyMap.put(num, count);

      // If count exceeds threshold, return immediately
      if (count > threshold) {
        return num;
      }
    }

    // This line should never be reached due to problem guarantees
    return -1;
  }
}
