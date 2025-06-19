import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Generates all unique subsets using the Cascading (Iterative) approach.
 */
class Solution2 {

  /**
   * Returns a list of unique subsets from the given array.
   *
   * @param nums Array of integers that may contain duplicates.
   * @return List of unique subsets.
   */
  public List<List<Integer>> subsetsWithDup(int[] nums) {
    // Step 1: Sort the input array to group duplicates together
    Arrays.sort(nums);

    List<List<Integer>> subsets = new ArrayList<>();
    subsets.add(new ArrayList<>()); // Initialize with the empty subset

    int subsetSize = 0; // Tracks the starting point for appending duplicates

    // Step 2: Iterate through elements in nums
    for (int i = 0; i < nums.length; i++) {
      int startIndex;

      // Duplicate: extend only subsets from previous round
      if (i > 0 && nums[i] == nums[i - 1]) {
        startIndex = subsetSize;
      } else {
        // First occurrence: add to all subsets
        startIndex = 0;
      }

      // Update subsetSize for the next round's starting index
      subsetSize = subsets.size();

      // Step 3: Clone and extend subsets from startIndex to subsetSize
      for (int j = startIndex; j < subsetSize; j++) {
        List<Integer> newSubset = new ArrayList<>(subsets.get(j));
        newSubset.add(nums[i]);
        subsets.add(newSubset);
      }
    }

    // Step 4: Return completed list of unique subsets
    return subsets;
  }
}
