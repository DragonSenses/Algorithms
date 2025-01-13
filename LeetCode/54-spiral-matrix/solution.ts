/**
 * Generates an array that represents the elements of a matrix in spiral order.
 *
 * @param {number[][]} matrix - A 2D array of numbers.
 * @returns {number[]} - An array of numbers in spiral order.
 */
function spiralOrder(matrix: number[][]): number[] {
  const result: number[] = [];
  const rows = matrix.length;
  const columns = matrix[0].length;
  let up = 0,
    down = rows - 1;
  let left = 0,
    right = columns - 1;

  while (result.length < rows * columns) {
    // Traverse from left to right along the top row.
    for (let col = left; col <= right; col++) {
      result.push(matrix[up][col]);
    }
    up++; // Move the top boundary down.

    // Traverse from top to bottom along the right column.
    for (let row = up; row <= down; row++) {
      result.push(matrix[row][right]);
    }
    right--; // Move the right boundary left.

    // Ensure we have rows remaining.
    if (up <= down) {
      // Traverse from right to left along the bottom row.
      for (let col = right; col >= left; col--) {
        result.push(matrix[down][col]);
      }
      down--; // Move the bottom boundary up.
    }

    // Ensure we have columns remaining.
    if (left <= right) {
      // Traverse from bottom to top along the left column.
      for (let row = down; row >= up; row--) {
        result.push(matrix[row][left]);
      }
      left++; // Move the left boundary right.
    }
  }

  return result;
}
