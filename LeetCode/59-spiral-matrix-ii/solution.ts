function generateMatrix(n: number): number[][] {
  const matrix: number[][] = Array.from({ length: n }, () => Array(n).fill(0));
  
  let num = 1; 
  let top = 0, bottom = n - 1, left = 0, right = n - 1; 

  while (num <= n * n) {
    for (let col = left; col <= right; col++) {
      matrix[top][col] = num++;
    }
    top++; 

    for (let row = top; row <= bottom; row++) {
      matrix[row][right] = num++;
    }
    right--;

    for (let col = right; col >= left; col--) {
      matrix[bottom][col] = num++;
    }
    bottom--;

    for (let row = bottom; row >= top; row--) {
      matrix[row][left] = num++;
    }
    left++; 
  }

  return matrix;
}
