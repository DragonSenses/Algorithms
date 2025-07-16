function numIslands(grid: string[][]): number {
  // Check if grid row or column is empty
  if (grid.length === 0 || grid[0].length === 0) {
    return 0;
  }
};