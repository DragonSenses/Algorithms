
function maximalRectangle(matrix: string[][]): number {
  if (matrix.length === 0) return 0;
  const n = matrix.length, m = matrix[0].length;
  let maxArea = 0;
  const dp: number[][] = Array.from({ length: n }, () => Array(m).fill(0));

  return maxArea;
}