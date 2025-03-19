function minPathSum(grid: number[][]): number {
  // Recursive helper function
  const computePathSum = (i: number, j: number): number => {
      // Base case: Out of bounds
      if (i >= grid.length || j >= grid[0].length) {
          return Infinity; // Treat as invalid path
      }
      // Base case: Reached bottom-right corner
      if (i === grid.length - 1 && j === grid[0].length - 1) {
          return grid[i][j];
      }

  };

  return 0;
};