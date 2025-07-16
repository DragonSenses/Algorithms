function numIslands(grid: string[][]): number {
  // Check if grid row or column is empty
  if (grid.length === 0 || grid[0].length === 0) {
    return 0;
  }

  const rows = grid.length;
  const cols = grid[0].length;

  function dfs(r: number, c: number): void {
    // Mark current cell as visited
    grid[r][c] = "0";

    // Explore all adjacent cells
    dfs(r - 1, c); // up
    dfs(r + 1, c); // down
    dfs(r, c - 1); // left
    dfs(r, c + 1); // right
  }

  // Scan the grid
  for (let r = 0; r < rows; r++) {
    for (let c = 0; c < cols; c++) {
      if (grid[r][c] === "1") {
        dfs(r, c);
      }
    }
  }
};
