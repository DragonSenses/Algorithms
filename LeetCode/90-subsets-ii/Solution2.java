import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution2 {

  public List<List<Integer>> subsetsWithDup(int[] nums) {
    // Step 1: Sort the input array to ensure duplicates are grouped together
    Arrays.sort(nums);
    
    List<List<Integer>> subsets = new ArrayList<>();
    subsets.add(new ArrayList<>()); // Start with an empty subset
    
    int subsetSize = 0; // Tracks the index where duplicates should start being added

    // Step 2: Iterate through the elements in nums
    for (int i = 0; i < nums.length; i++) {
      int startIndex;
      // If the element is not the first occurence
      if (i > 0 && nums[i] == nums[i-1]) {
        // Add to only newly created subsets
        startIndex = subsetSize;
      } else {
        // If element is first occurrence, add to all subsets
        startIndex = 0;
      }

      // Update size to reflect current number of subsets
      subsetSize = subsets.size();
    }
  }
}