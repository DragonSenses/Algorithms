/**
 * Sets matrix zeroes in an R x C matrix.
 * If an element is 0, sets its entire row and column to 0's.
 *
 * This function uses a two-pass matrix zeroing approach,
 * but it requires additional memory of O(R + C).
 *
 * @param {number[][]} matrix - The matrix to modify.
 */
function setZeroes(matrix: number[][]): void {
  const rows = new Set<number>();
  const cols = new Set<number>();
  const R = matrix.length;
  const C = matrix[0].length;

  // First pass to find zeros and mark rows and columns
  for (let i = 0; i < R; i++) {
    for (let j = 0; j < C; j++) {
      if (matrix[i][j] === 0) {
        rows.add(i);
        cols.add(j);
      }
    }
  }

  // Second pass to set matrix cells to zero
  for (let i = 0; i < R; i++) {
    for (let j = 0; j < C; j++) {
      if (rows.has(i) || cols.has(j)) {
        matrix[i][j] = 0;
      }
    }
  }
}
