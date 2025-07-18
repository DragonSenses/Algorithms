/**
 * Counts the number of distinct islands in a 2D grid.
 * An island is defined as a group of adjacent '1's (land) connected
 * horizontally or vertically (not diagonally). Uses Depth-First Search (DFS).
 *
 * @param grid - 2D array of strings representing the map ('1' for land, '0' for water)
 * @returns The total number of islands in the grid
 */
function numIslands(grid: string[][]): number {
  // Edge Case: Return 0 if grid has no content
  if (grid.length === 0 || grid[0].length === 0) {
    return 0;
  }

  const rows = grid.length;
  const cols = grid[0].length;
  let islandCount = 0;

  // Helper DFS function to explore connected land
  function dfs(r: number, c: number): void {
    // Boundary and base case checks
    if (r < 0 || r >= rows || c < 0 || c >= cols || grid[r][c] !== '1') {
      return;
    }

    // Mark current cell as visited
    grid[r][c] = '0';

    // Explore all adjacent cells
    dfs(r - 1, c); // up
    dfs(r + 1, c); // down
    dfs(r, c - 1); // left
    dfs(r, c + 1); // right
  }

  // Scan the grid
  for (let r = 0; r < rows; r++) {
    for (let c = 0; c < cols; c++) {
      if (grid[r][c] === '1') {
        dfs(r, c);
        islandCount++;
      }
    }
  }

  return islandCount;
};
