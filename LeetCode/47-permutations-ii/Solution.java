import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * This class provides a solution to generate all unique permutations of a list of numbers.
 */
class Solution {

  /**
   * Generates all unique permutations of the given array of numbers.
   *
   * @param nums An array of integers to permute
   * @return A list of lists containing all unique permutations of the input array
   */
  public List<List<Integer>> permuteUnique(int[] nums) {
    List<List<Integer>> results = new ArrayList<>();

    // Count the occurrence of each number
    HashMap<Integer, Integer> numsMap = new HashMap<>();
    for (int num : nums) {
      numsMap.put(num, numsMap.getOrDefault(num, 0) + 1);
    }

    LinkedList<Integer> currCombination = new LinkedList<>();
    this.backtrack(currCombination, nums.length, numsMap, results);
    return results;
  }

  /**
   * A helper method to perform backtracking to generate permutations.
   *
   * @param currCombination The current combination of numbers being built
   * @param N The length of the input array
   * @param numsMap A map storing the count of remaining numbers to use
   * @param results The list to store all unique permutations
   */
  protected void backtrack(
      LinkedList<Integer> currCombination,
      Integer N,
      HashMap<Integer, Integer> numsMap,
      List<List<Integer>> results) {

    // If the combination is done, add it to the results
    if (currCombination.size() == N) {
      results.add(new ArrayList<>(currCombination)); // Make a deep copy of the resulting permutation
      return;
    }

    // Iterate over the numsMap
    for (Integer num : numsMap.keySet()) {
      int count = numsMap.get(num);
      if (count == 0)
        continue;

      // Add this number into the current combination
      currCombination.add(num);
      numsMap.put(num, count - 1);

      // Continue the exploration
      backtrack(currCombination, N, numsMap, results);

      // Revert the choice for the next exploration
      currCombination.removeLast();
      numsMap.put(num, count);
    }
  }
}
