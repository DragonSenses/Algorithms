import java.util.ArrayList;
import java.util.List;

/**
 * This class provides a solution to generate all possible subsets (power set)
 * from an array of unique integers.
 */
public class Solution2 {

  /**
   * Finds all possible subsets of the given integer array.
   * This function uses the cascading approach to generate new subsets
   * by adding each element to existing subsets iteratively.
   * 
   * @param nums an array of unique integers
   * @return a list of all possible subsets
   */
  public static List<List<Integer>> findSubsets(int[] nums) {
    List<List<Integer>> output = new ArrayList<>();
    // Start with the empty subset
    output.add(new ArrayList<>());

    // Iterate over each element in the input array
    for (int num : nums) {
      int currentSize = output.size();
      // Generate new subsets from the existing ones
      for (int i = 0; i < currentSize; i++) {
        // Create a new subset from an existing subset
        List<Integer> newSubset = new ArrayList<>(output.get(i));
        // Add the current element to the new subset
        newSubset.add(num);
        // Add the new subset to the output list
        output.add(newSubset);
      }
    }

    return output;
  }
}
