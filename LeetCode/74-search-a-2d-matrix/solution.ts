/**
 * Searches for a target value in a sorted 2D matrix using binary search.
 *
 * @param matrix The 2D matrix of integers.
 * @param target The target value to search for.
 * @returns true if the target is found, otherwise false.
 */
function searchMatrix(matrix: number[][], target: number): boolean {
  // Check if the matrix is empty or null
  if (matrix === null || matrix.length === 0 || matrix[0].length === 0) {
    return false;
  }

  let m = matrix.length; // Number of rows
  let n = matrix[0].length; // Number of columns
  let left = 0; // Start of the search range
  let right = m * n - 1; // End of the search range

  // Perform binary search
  while (left <= right) {
    let pivotIdx = Math.floor((left + right) / 2); // Middle index of the search range
    let row = Math.floor(pivotIdx / n); // Row index in the matrix
    let col = pivotIdx % n; // Column index in the matrix
    let pivotElement = matrix[row][col]; // Element at the middle index

    // Check if the pivot element is equal to the target
    if (pivotElement === target) {
      return true;
      // If pivot element is less than the target, adjust the left boundary
    } else if (pivotElement < target) {
      left = pivotIdx + 1;
      // If pivot element is greater than the target, adjust the right boundary
    } else {
      right = pivotIdx - 1;
    }
  }

  // Target was not found in the matrix
  return false;
}
