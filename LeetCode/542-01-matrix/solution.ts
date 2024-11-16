/**
 * Updates the matrix with the distance of the nearest 0 for each cell.
 * Uses the brute force approach.
 *
 * @param mat - The input binary matrix.
 * @returns The matrix with updated distances.
 */
function updateMatrix(mat: number[][]): number[][] {
  const m = mat.length;
  const n = mat[0].length;

  // Initialize the distances matrix with a large value
  const distances: number[][] = Array.from({ length: m }, () =>
    Array(n).fill(Infinity)
  );

  // Iterate through each cell in the matrix
  for (let i = 0; i < m; i++) {
    for (let j = 0; j < n; j++) {
      // If the cell is 0, set distance to 0
      if (mat[i][j] === 0) {
        distances[i][j] = 0;
      } else {
        // Check all cells in the matrix to find the nearest 0
        for (let x = 0; x < m; x++) {
          for (let y = 0; y < n; y++) {
            if (mat[x][y] === 0) {
              const distance = Math.abs(x - i) + Math.abs(y - j);
              distances[i][j] = Math.min(distances[i][j], distance);
            }
          }
        }
      }
    }
  }

  return distances;
};
