function spiralOrder(matrix: number[][]): number[] {
  const result: number[] = [];
  const rows = matrix.length;
  const columns = matrix[0].length;
  let up = 0, down = rows - 1;
  let left = 0, right = columns - 1;

  while (result.length < rows * columns) {
      // Traverse from left to right.
      for (let col = left; col <= right; col++) {
          result.push(matrix[up][col]);
      }
      
      up++;

      // Traverse from top to bottom.
      for (let row = up; row <= down; row++) {
          result.push(matrix[row][right]);
      }

      right--;

      // Different row.
      if (up <= down) {
          // Traverse from right to left.
          for (let col = right; col >= left; col--) {
              result.push(matrix[down][col]);
          }
          down--; // Move the bottom boundary up
      }

      // Different column
      if (left <= right) {
          // Traverse from bottom to top.
          for (let row = down; row >= up; row--) {
              result.push(matrix[row][left]);
          }

          left++;
      }
  }

  return result;
};
