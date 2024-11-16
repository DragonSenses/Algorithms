/**
 * Rotates the given n x n matrix by 90 degrees clockwise in place.
 * 
 * @param matrix - The n x n 2D matrix representing the image.
 */
function rotate(matrix: number[][]): void {
  const n = matrix.length;

  // Transpose the matrix
  for (let i = 0; i < n; i++) {
      for (let j = i; j < n; j++) {
          const temp = matrix[i][j];
          matrix[i][j] = matrix[j][i];
          matrix[j][i] = temp;
      }
  }

  // Reverse each row
  for (let i = 0; i < n; i++) {
      reverseRow(matrix[i]);
  }
};

/**
* Helper function to reverse a given row in the matrix.
* 
* @param row - The row to be reversed.
*/
function reverseRow(row: number[]): void {
  let start = 0;
  let end = row.length - 1;

  while (start < end) {
      const temp = row[start];
      row[start] = row[end];
      row[end] = temp;
      start++;
      end--;
  }
}
