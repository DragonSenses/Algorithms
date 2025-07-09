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
