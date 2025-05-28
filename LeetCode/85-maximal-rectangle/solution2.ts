
function maximalRectangle(matrix: string[][]): number {
  if (matrix.length === 0) return 0;
  const n = matrix.length, m = matrix[0].length;
  let maxArea = 0;
  const dp: number[][] = Array.from({ length: n }, () => Array(m).fill(0));

  // Populate the DP table
  for (let i = 0; i < n; i++) {
    for (let j = 0; j < m; j++) {
      if (matrix[i][j] === '1') {
        // Compute max width ending at (i, j)
        dp[i][j] = j === 0 ? 1 : dp[i][j - 1] + 1;

        let width = dp[i][j];

        // Iterate upwards to compute max area with (i, j) as bottom-right corner
        for (let k = i; k >= 0; k--) {
          width = Math.min(width, dp[k][j]); // Maintain the smallest width encountered
          const area = width * (i - k + 1); // Compute rectangle area
          maxArea = Math.max(maxArea, area);
        }
      }
    }
  }
  return maxArea;
}