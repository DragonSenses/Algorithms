/**
 * Counts the number of distinct islands in a 2D grid.
 * An island is a group of horizontally or vertically connected '1's (land).
 * Uses Breadth-First Search (BFS) with a queue to traverse each island.
 *
 * @param grid - 2D array of strings representing the map ('1' for land, '0' for water)
 * @returns The number of islands in the grid
 */
function numIslands(grid: string[][]): number {
  // Edge Case: Return 0 if grid has no content
  if (grid.length === 0 || grid[0].length === 0) {
    return 0;
  }

  const rows = grid.length;
  const cols = grid[0].length;
  let islandCount = 0;

  const directions = [
    [-1, 0], [1, 0], [0, -1], [0, 1] // up, down, left, right
  ];


  return islandCount;
}