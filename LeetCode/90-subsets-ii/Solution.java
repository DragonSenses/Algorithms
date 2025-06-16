import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
  public List<List<Integer>> subsetsWithDup(int[] nums) {
    // Step 1: Sort nums to ensure consistent subset ordering
    Arrays.sort(nums);

    int n = nums.length;
    int maxSubsets = 1 << n; // Equivalent to 2^n
    Set<String> seen = new HashSet<>();
    List<List<Integer>> subsets = new ArrayList<>();

    // Step 2: Iterate over all possible bitmask values
    for (int mask = 0; mask < maxSubsets; mask++) {
      List<Integer> currentSubset = new ArrayList<>();
      StringBuilder hashcode = new StringBuilder(); // Unique identifier

      // Step 3: Determine elements present in the subset
      for (int j = 0; j < n; j++) {
        // Check if j-th bit is set
        if ((mask & (1 << j)) != 0) {
          // Include nums[j] in the current subset
          currentSubset.add(nums[j]);

          // Append the current number to hashcode string (identify duplicate)
          hashcode.append(nums[j]);
        }
      }
    }
  }
}
