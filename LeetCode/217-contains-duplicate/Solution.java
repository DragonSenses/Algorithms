import java.util.HashSet;
import java.util.Set;

/**
 * This class provides a method to determine whether a given array of integers
 * contains any duplicate values. It uses a HashSet to track seen elements
 * for efficient O(1) average-time lookups and insertions.
 */
class Solution {

  /**
   * Checks if the input array contains any duplicate elements.
   *
   * @param nums the input array of integers
   * @return true if any value appears at least twice; false if all values are unique
   */
  public boolean containsDuplicate(int[] nums) {
    // Initialize a HashSet to keep track of seen integers.
    Set<Integer> set = new HashSet<>(nums.length);

    // Iterate through each number in the array.
    for (int x : nums) {
      // If the number already exists in the set, a duplicate is found.
      if (set.contains(x)) {
        return true;
      }

      // Otherwise, store the number in the set.
      set.add(x);
    }

    // No duplicates found after scanning the entire array.
    return false;
  }
}