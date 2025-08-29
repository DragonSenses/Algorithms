/**
 * Counts the number of distinct islands in a 2D grid using Union-Find.
 * An island is formed by connecting adjacent lands horizontally or vertically.
 *
 * @param grid - 2D array of strings ('1' for land, '0' for water)
 * @returns The total number of islands in the grid
 */
function numIslands(grid: string[][]): number {
  if (grid.length === 0 || grid[0].length === 0) {
    return 0;
  }

  const rows = grid.length;
  const cols = grid[0].length;
  const uf = new UnionFind(grid);

  const directions = [
    [1, 0], // down
    [0, 1], // right
  ];

  for (let r = 0; r < rows; r++) {
    for (let c = 0; c < cols; c++) {
      if (grid[r][c] === '1') {
        for (const [dr, dc] of directions) {
          const newRow = r + dr;
          const newCol = c + dc;

          if (
            newRow < rows &&
            newCol < cols &&
            grid[newRow][newCol] === '1'
          ) {
            uf.union(r * cols + c, newRow * cols + newCol);
          }
        }
      }
    }
  }

  return uf.getIslandCount();
}

/**
 * Union-Find (Disjoint Set) structure for tracking connected land cells.
 */
class UnionFind {
  private parent: number[];
  private count: number;

  constructor(grid: string[][]) {
    const rows = grid.length;
    const cols = grid[0].length;
    this.parent = new Array(rows * cols).fill(-1);
    this.count = 0;

    for (let r = 0; r < rows; r++) {
      for (let c = 0; c < cols; c++) {
        if (grid[r][c] === '1') {
          const index = r * cols + c;
          this.parent[index] = index;
          this.count++;
        }
      }
    }
  }

}