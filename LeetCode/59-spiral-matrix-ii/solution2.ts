function generateMatrix(n: number): number[][] {
  // Initialize a n x n matrix filled with 0s
  const matrix: number[][] = Array.from({ length: n }, () => Array(n).fill(0));
  
  let num = 1; // Starting number to fill the matrix
  let top = 0, bottom = n - 1, left = 0, right = n - 1; // Boundaries of the current layer

  // Fill the matrix layer by layer
  while (num <= n * n) {
    // Traverse from left to right
    for (let col = left; col <= right; col++) {
      matrix[top][col] = num++;
    }
    top++; // Move the top boundary down

    // Traverse from top to bottom
    for (let row = top; row <= bottom; row++) {
      matrix[row][right] = num++;
    }
    right--; // Move the right boundary left

    // Traverse from right to left
    for (let col = right; col >= left; col--) {
      matrix[bottom][col] = num++;
    }
    bottom--; // Move the bottom boundary up

    // Traverse from bottom to top
    for (let row = bottom; row >= top; row--) {
      matrix[row][left] = num++;
    }
    left++; // Move the left boundary right
  }

  return matrix;
}
