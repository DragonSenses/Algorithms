import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Solution class implementing the bitmasking approach to generate unique subsets.
 */
class Solution {

  /**
   * Generates all unique subsets of the given array using bitmasking.
   * 
   * @param nums Array of integers that may contain duplicates.
   * @return List of unique subsets.
   */
  public List<List<Integer>> subsetsWithDup(int[] nums) {
    // Step 1: Sort nums to ensure consistent subset ordering
    Arrays.sort(nums);

    int n = nums.length;
    int maxSubsets = 1 << n; // Equivalent to 2^n
    Set<String> seen = new HashSet<>(); // Used to eliminate duplicate subsets
    List<List<Integer>> subsets = new ArrayList<>(); // Stores unique subsets

    // Step 2: Iterate over all possible bitmask values
    for (int mask = 0; mask < maxSubsets; mask++) {
      List<Integer> currentSubset = new ArrayList<>(); // Subset generated from bitmask
      StringBuilder hashcode = new StringBuilder(); // Unique identifier for duplicate detection

      // Step 3: Determine elements present in the subset
      for (int j = 0; j < n; j++) {
        // Check if the j-th bit in 'mask' is set (1)
        if ((mask & (1 << j)) != 0) {
          // Include nums[j] in the current subset
          currentSubset.add(nums[j]);

          // Append a comma to separate elements in the hashcode (if not the first element)
          if (hashcode.length() > 0) {
            hashcode.append(",");
          }

          // Append the current number to the hashcode string (used for duplicate tracking)
          hashcode.append(nums[j]);
        }
      }

      // Step 4: Add to results if unique
      if (seen.add(hashcode.toString())) {
        subsets.add(currentSubset);
      }
    }

    // Return finalized list of unique subsets
    return subsets;
  }
}
