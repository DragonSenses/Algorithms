function searchMatrix(matrix: number[][], target: number): boolean {
  if (matrix === null || matrix.length === 0 || matrix[0].length === 0) {
    return false;
  }

  let m = matrix.length;
  let n = matrix[0].length;
  let left = 0;
  let right = m * n - 1;

  while (left <= right) {
    let pivotIdx = Math.floor((left + right) / 2);
    let row = Math.floor(pivotIdx / n);
    let col = pivotIdx % n;
    let pivotElement = matrix[row][col];

    if (pivotElement === target) {
      return true;
    } else if (pivotElement < target) {
      left = pivotIdx + 1;
    } else {
      right = pivotIdx - 1;
    }
  }

  return false;
};
