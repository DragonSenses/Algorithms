/**
 * Updates the matrix with the distance of the nearest 0 for each cell using BFS.
 *
 * @param mat - The input binary matrix.
 * @returns The matrix with updated distances.
 */
function updateMatrix(mat: number[][]): number[][] {
  const m = mat.length;
  const n = mat[0].length;

  const distances: number[][] = Array.from({ length: m }, () =>
    Array(n).fill(Infinity)
  );
  const queue: [number, number][] = [];

  for (let i = 0; i < m; i++) {
    for (let j = 0; j < n; j++) {
      if (mat[i][j] === 0) {
        distances[i][j] = 0;
        queue.push([i, j]);
      }
    }
  }

  const directions = [
    [0, 1],
    [1, 0],
    [0, -1],
    [-1, 0],
  ];

  while (queue.length > 0) {
    const [i, j] = queue.shift()!;
    for (const [di, dj] of directions) {
      const ni = i + di;
      const nj = j + dj;
      if (ni >= 0 && ni < m && nj >= 0 && nj < n) {
        if (distances[ni][nj] > distances[i][j] + 1) {
          distances[ni][nj] = distances[i][j] + 1;
          queue.push([ni, nj]);
        }
      }
    }
  }

  return distances;
};
