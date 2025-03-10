/**
 * Sets matrix zeroes in an R x C matrix.
 * If an element is 0, sets its entire row and column to 0's.
 *
 * This optimized mark-and-sweep approach improves upon the two-pass matrix zeroing approach.
 * It has a time complexity of O(R * C) and space complexity of O(1).
 *
 * @param {number[][]} matrix - The matrix to modify.
 */
function setZeroes(matrix: number[][]): void {
  let isCol = false;
  const R = matrix.length;
  const C = matrix[0].length;

  // First pass to mark zeros
  for (let i = 0; i < R; i++) {
    // Check if the first column should be zeroed
    if (matrix[i][0] === 0) {
      isCol = true;
    }
    // Check the rest of the matrix
    for (let j = 1; j < C; j++) {
      if (matrix[i][j] === 0) {
        matrix[0][j] = 0;
        matrix[i][0] = 0;
      }
    }
  }

  // Second pass to set matrix cells to zero using markers
  for (let i = 1; i < R; i++) {
    for (let j = 1; j < C; j++) {
      if (matrix[i][0] === 0 || matrix[0][j] === 0) {
        matrix[i][j] = 0;
      }
    }
  }

  // Set the first row to zero if needed
  if (matrix[0][0] === 0) {
    for (let j = 0; j < C; j++) {
      matrix[0][j] = 0;
    }
  }

  // Set the first column to zero if needed
  if (isCol) {
    for (let i = 0; i < R; i++) {
      matrix[i][0] = 0;
    }
  }
}
