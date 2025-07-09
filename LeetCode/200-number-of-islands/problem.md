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

- [**Depth-First Search (DFS)** Approach](#)


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
