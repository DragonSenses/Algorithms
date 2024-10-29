import java.util.ArrayList;
import java.util.List;

public class Solution3 {

  private void backtrack(int first, List<Integer> curr, int[] nums, List<List<Integer>> output, int k) {
    // If the current combination is done
    if (curr.size() == k) {
      output.add(new ArrayList<>(curr));
      return;
    }
    for (int i = first; i < nums.length; i++) {
      // Add nums[i] into the current combination
      curr.add(nums[i]);
      // Use next integers to complete the combination
      backtrack(i + 1, curr, nums, output, k);
      // Backtrack by removing nums[i]
      curr.remove(curr.size() - 1);
    }
  }

  public List<List<Integer>> findSubsets(int[] nums) {
    List<List<Integer>> output = new ArrayList<>();
    // Iterate over all possible lengths
    for (int k = 0; k <= nums.length; k++) {
      backtrack(0, new ArrayList<>(), nums, output, k);
    }
    return output;
  }
}