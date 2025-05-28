
function maximalRectangle(matrix: string[][]): number {
  if (matrix.length === 0) return 0;
  const n = matrix.length, m = matrix[0].length;
  let maxArea = 0;
  const dp: number[][] = Array.from({ length: n }, () => Array(m).fill(0));

  // Populate the DP table
  for (let i = 0; i < n; i++) {
    for (let j = 0; j < m; j++) {

    }
  }
  return maxArea;
}