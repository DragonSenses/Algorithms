# 200. Number of Islands

<p>Given an <code>m x n</code> 2D binary grid <code>grid</code> which represents a map of <code>'1'</code>s (land) and <code>'0'</code>s (water), return <em>the number of islands</em>.</p>

<p>An <strong>island</strong> is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
<strong>Output:</strong> 1
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
<strong>Output:</strong> 3
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>m == grid.length</code></li>
	<li><code>n == grid[i].length</code></li>
	<li><code>1 &lt;= m, n &lt;= 300</code></li>
	<li><code>grid[i][j]</code> is <code>'0'</code> or <code>'1'</code>.</li>
</ul>

---

# Solution

- [**Depth-First Search (DFS)** Approach](#depth-first-search-dfs-approach)
  - **Time Complexity**: `O(m * n)`
  - **Space Complexity**: `O(m * n)`
- [**Breadth-First Search (BFS)** Approach](#breadth-first-search-bfs-approach)

## **Problem Overview: Number of Islands**

The **Number of Islands** problem involves identifying distinct landmasses in a 2D binary grid map. Each element in the grid is either `'1'` (representing land) or `'0'` (representing water).

### Objective
Count the number of **connected groups of land** (`'1'`s) in the grid. A group is considered an **island** if:
- It's connected **horizontally or vertically** (no diagonal connections).
- It is **completely surrounded by water** or edges of the grid.

### Problem Details
- The grid dimensions are **m x n**, where `1 <= m, n <= 300`.
- Each cell contains either `'0'` or `'1'`.
- You're guaranteed the grid is surrounded by water on all edges.

### Examples

**Example 1:**
```
Input:
grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1
```
> A single large island spans the upper left portion of the grid.

**Example 2:**
```
Input:
grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3
```
> Three disconnected islands exist—top-left, center, and bottom-right.

### Approaches
You can solve this using **Depth-First Search (DFS)**, **Breadth-First Search (BFS)**, or **Union Find (Disjoint Set)** to explore and mark visited land tiles.

---

# Depth-First Search (DFS) Approach

## **Intuition**

Visualize the 2D grid as an undirected graph where each cell with value `'1'` represents a land node, and edges exist between horizontally or vertically adjacent land nodes.

To identify islands:
1. Traverse each cell in the grid using a linear scan.
2. Upon encountering a `'1'`, initiate a **DFS traversal** from that cell. This cell serves as the **starting point (root)** of a new island.
3. During DFS, mark each visited `'1'` as `'0'` to denote it's been explored and avoid revisiting.
4. Increment a counter for every DFS initiation, as each start represents a new island.

Each DFS visit explores all the land connected to the root node, effectively mapping out an entire island. By the end of the scan, the counter reflects the total number of distinct islands.

## **Algorithm**

### Recursive Algorithm

1. **Initialize Counter**  
   Create a variable `islandCount` to keep track of the number of distinct islands found.

2. **Define DFS Function**  
   Write a recursive `dfs(row, col)` function to traverse connected land.  
   - Base case: Return if the current cell is out of bounds or equals `'0'`.  
   - Mark the current cell as visited by setting it to `'0'`.  
   - Recursively call `dfs` on all four adjacent cells: up, down, left, and right.

3. **Iterate Over Grid**  
   Perform a nested loop over every cell in the grid:  
   - If a cell contains `'1'`, call the `dfs` function on that cell.  
   - Increment `islandCount` after the DFS finishes, since this means a full island has been explored.

4. **Return Result**  
   After scanning the entire grid, return `islandCount` as the total number of islands.

### Iterative Algorithm (DFS Using Stack)

1. **Initialize Counter**  
   Create a variable `islandCount` to keep track of the number of distinct islands found.

2. **Prepare Stack and Direction Vectors**  
   Define a stack to hold cell coordinates during traversal.  
   Create a direction array to represent four adjacent moves: up, down, left, and right.

3. **Iterate Over Grid**  
   Perform a nested loop over every cell in the grid:  
   - If the current cell contains `'1'`, increment `islandCount`.  
   - Push the cell’s coordinates into the stack to begin DFS.

4. **Perform DFS Iteratively**  
   While the stack is not empty:  
   - Pop a cell from the stack and mark it as visited by setting it to `'0'`.  
   - For each direction (up, down, left, right), compute the neighboring cell’s coordinates.  
   - If the neighbor is within bounds and equals `'1'`, push it to the stack.

5. **Return Result**  
   After scanning the entire grid and completing iterative DFS for each island, return `islandCount` as the total number of islands.

### **Pseudocode**

```plaintext
function countIslands(grid):
  if grid is empty:
    return 0

  rows = number of rows in grid
  cols = number of columns in grid
  islandCount = 0

  for r from 0 to rows - 1:
    for c from 0 to cols - 1:
      if grid[r][c] == '1':
        dfs(grid, r, c)
        islandCount += 1

  return islandCount

function dfs(grid, r, c):
  if r < 0 or r >= number of rows in grid:
    return
  if c < 0 or c >= number of columns in grid:
    return
  if grid[r][c] != '1':
    return

  grid[r][c] = '0'  // mark as visited

  dfs(grid, r - 1, c)  // up
  dfs(grid, r + 1, c)  // down
  dfs(grid, r, c - 1)  // left
  dfs(grid, r, c + 1)  // right
```

## **Implementation**

### Java

#### Recursive DFS

```java
class Solution {
  public int numIslands(char[][] grid) {
    // Edge Case: Return 0 if grid is null or has no content
    if (grid == null || grid.length == 0 || grid[0].length == 0) {
      return 0;
    }

    int rows = grid.length;
    int cols = grid[0].length;
    int islandCount = 0;

    // Iterate through each cell in the grid
    for (int r = 0; r < rows; r++) {
      for (int c = 0; c < cols; c++) {
        // If current cell is land ('1'), it's a new island
        if (grid[r][c] == '1') {
          // Explore and mark all connected land cells
          dfs(grid, r, c);
          // Increment island counter after DFS finishes
          islandCount += 1;
        }
      }
    }

    // Return total number of distinct islands found
    return islandCount;
  }

  private void dfs(char[][] grid, int r, int c) {
    // Boundary check: row index out of bounds
    if (r < 0 || r >= grid.length) {
      return;
    }

    // Boundary check: column index out of bounds
    if (c < 0 || c >= grid[0].length) {
      return;
    }

    // Return if cell is water ('0') or already visited
    if (grid[r][c] != '1') {
      return;
    }

    // Mark current cell as visited by converting '1' to '0'
    grid[r][c] = '0';

    // Recursively explore all 4 adjacent directions
    dfs(grid, r - 1, c);  // up
    dfs(grid, r + 1, c);  // down
    dfs(grid, r, c - 1);  // left
    dfs(grid, r, c + 1);  // right
  }
}
```

#### Iterative DFS

```java
import java.util.ArrayDeque;

/**
 * Iterative DFS solution to the "Number of Islands" problem. Replaces recursive DFS with a
 * controlled stack using ArrayDeque.
 */
class Solution {
  public int numIslands(char[][] grid) {
    // Edge case check
    if (grid == null || grid.length == 0 || grid[0].length == 0) {
      return 0;
    }

    int rows = grid.length;
    int cols = grid[0].length;
    int islandCount = 0;

    // Direction vectors: up, down, left, right
    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    for (int r = 0; r < rows; r++) {
      for (int c = 0; c < cols; c++) {
        if (grid[r][c] == '1') {
          islandCount++;

          // Use stack for iterative DFS
          ArrayDeque<int[]> stack = new ArrayDeque<>();
          stack.push(new int[] {r, c});

          // Explore all connected land iteratively
          while (!stack.isEmpty()) {
            int[] cell = stack.pop();
            int row = cell[0];
            int col = cell[1];

            // Mark visited
            grid[row][col] = '0';

            // Traverse neighbors
            for (int[] dir : directions) {
              int newRow = row + dir[0];
              int newCol = col + dir[1];

              // If in bounds and unvisited land, add to stack
              if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols
                  && grid[newRow][newCol] == '1') {
                stack.push(new int[] {newRow, newCol});
              }
            }
          }
        }
      }
    }

    return islandCount;
  }
}
```

### TypeScript

```typescript
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
}
```

## **Complexity Analysis**

### **Assumptions**

- Let `m` be the number of rows  
- Let `n` be the number of columns  
- The input grid has `m * n` total cells

### **Time Complexity**: `O(m * n)`

- **Full Grid Traversal**: Every cell is visited once during the initial scan, and each land cell (`'1'`) may trigger a DFS traversal that marks all connected land.
- **No Redundant Visits**: Since visited cells are marked as `'0'`, each cell is processed at most once across both the outer iteration and DFS calls.

### **Space Complexity**: `O(m * n)`

- **Recursive Call Stack**: In the worst case (e.g., one large island occupying the entire grid), the DFS may recurse into every land cell, resulting in a call stack depth of up to `m * n`.
- **No Auxiliary Structures**: The algorithm modifies the input grid in-place and avoids using additional data structures like visited arrays or queues.
- **Linear-Space Usage**: DFS uses the call stack to explore connected regions, which grows proportionally with the number of land cells in the worst case.

# Breadth-First Search (BFS) Approach

For BFS approach we do a linear scan on the 2d grid and if a node contains a 1, the nit is a root node.

A root node starts a Breadth First Search where we put it into a queue data structure and set its value as 0 to mark a visited node.

Iteratively search the neighbors of enqueued nodes until the queue becomes empty.
