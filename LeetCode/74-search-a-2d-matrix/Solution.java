public class Solution {

  /**
   * Searches for a target value in a sorted 2D matrix using binary search.
   *
   * @param matrix The 2D matrix of integers.
   * @param target The target value to search for.
   * @return true if the target is found, otherwise false.
   */
  public boolean searchMatrix(int[][] matrix, int target) {
    // Check if the matrix is null or empty
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return false;
    }

    int m = matrix.length; // Number of rows
    int n = matrix[0].length; // Number of columns
    int left = 0; // Start of the search range
    int right = m * n - 1; // End of the search range

    // Perform binary search
    while (left <= right) {
      int pivot_idx = (left + right) / 2; // Middle index of the search range
      int row = pivot_idx / n; // Row index in the matrix
      int col = pivot_idx % n; // Column index in the matrix
      int pivot_element = matrix[row][col]; // Element at the middle index

      // Check if the pivot element is equal to the target
      if (pivot_element == target) {
        return true;
      }
      // If pivot element is less than the target, adjust the left boundary
      else if (pivot_element < target) {
        left = pivot_idx + 1;
      }
      // If pivot element is greater than the target, adjust the right boundary
      else {
        right = pivot_idx - 1;
      }
    }

    // Target was not found in the matrix
    return false;
  }
}
