public class Solution {
  public int removeDuplicates(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }

    // Initialize pointers i and j
    int i = 1, j = 1;

    // Initialize variable count to track of the number of occurrences of each element
    int count = 1;

    // Iterate through the array
    while (i < nums.length) {
      if (nums[i] == nums[i - 1]) {
        // Increment count if the current element is the same as the previous element
        count++;
      } else {
        // Reset count to 1 if the current element is different
        count = 1;
      }

      // Move to the next element
      i++;
    }

    return 0;
  }
}
