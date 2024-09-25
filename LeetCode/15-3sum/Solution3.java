import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Solution3 class to solve the 3Sum problem without sorting the array.
 */
public class Solution3 {

  /**
   * Finds all unique triplets in the array which give the sum of zero.
   *
   * @param nums the input array of integers
   * @return a list of lists containing all unique triplets that sum up to zero
   */
  public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    Set<String> seenTriplets = new HashSet<>();
    Set<Integer> duplicates = new HashSet<>();

    // Iterate through the array, treating each element as a potential pivot
    for (int i = 0; i < nums.length - 2; i++) {
      // Skip duplicate pivot elements
      if (duplicates.contains(nums[i])) {
        continue;
      }
      duplicates.add(nums[i]);

      // Initialize a Set to store elements visited so far
      Set<Integer> visited = new HashSet<>();
      for (int j = i + 1; j < nums.length; j++) {
        int complement = -nums[i] - nums[j];

        // Check if the complement exists in the Set
        if (visited.contains(complement)) {
          List<Integer> triplet = List.of(nums[i], nums[j], complement);
          // Sort the triplet to avoid permutations of the same triplet
          triplet.sort(Integer::compareTo);
          String tripletString = triplet.toString();

          // Add the triplet to the result if it hasn't been seen before
          if (!seenTriplets.contains(tripletString)) {
            result.add(triplet);
            seenTriplets.add(tripletString);
          }

          // Skip duplicate elements to avoid duplicate triplets in the result
          while (j + 1 < nums.length && nums[j] == nums[j + 1]) {
            j++;
          }
        }

        // Add the current element to the Set
        visited.add(nums[j]);
      }
    }

    return result;
  }
}
