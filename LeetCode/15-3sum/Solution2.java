import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Solution2 {

  public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();

    if (nums == null || nums.length < 3) {
      return result;
    }

    Arrays.sort(nums);

    for (int i = 0; i < nums.length - 2; i++) {
      // Skip duplicate elements
      if (i > 0 && nums[i] == nums[i - 1]) {
        continue;
      }

      Set<Integer> visited = new HashSet<>();

      for (int j = i + 1; j < nums.length; j++) {
        int complement = -nums[i] - nums[j];

        if (visited.contains(complement)) {
          // Found a triplet that sums to zero, add it to the result
          result.add(Arrays.asList(nums[i], nums[j], complement));

          // Skip duplicate elements
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
