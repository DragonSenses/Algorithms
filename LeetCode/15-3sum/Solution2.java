import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Solution2 class to solve the 3Sum problem using a HashSet.
 */
public class Solution2 {

  /**
   * Finds all unique triplets in the array which gives the sum of zero.
   *
   * @param nums the input array of integers
   * @return a list of lists containing all unique triplets that sum up to zero
   */
  public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();

    // Return empty result if input is null or has less than 3 elements
    if (nums == null || nums.length < 3) {
      return result;
    }

    // Sort the array to facilitate the two-pointer approach and avoid duplicates
    Arrays.sort(nums);

    // Iterate through the array, treating each element as a potential pivot
    for (int i = 0; i < nums.length - 2; i++) {
      // Skip duplicate elements to avoid duplicate triplets in the result
      if (i > 0 && nums[i] == nums[i - 1]) {
        continue;
      }

      // Initialize a HashSet to store elements visited so far
      Set<Integer> visited = new HashSet<>();

      for (int j = i + 1; j < nums.length; j++) {
        int complement = -nums[i] - nums[j];

        // Check if the complement exists in the HashSet
        if (visited.contains(complement)) {
          // Found a triplet that sums to zero, add it to the result
          result.add(Arrays.asList(nums[i], nums[j], complement));

          // Skip duplicate elements to avoid duplicate triplets in the result
          while (j + 1 < nums.length && nums[j] == nums[j + 1]) {
            j++;
          }
        }

        // Add the current element to the HashSet
        visited.add(nums[j]);
      }
    }

    return result;
  }
}
