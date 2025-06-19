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

  }
}