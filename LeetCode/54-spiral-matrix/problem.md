# 54. Spiral Matrix

<p>Given an <code>m x n</code> <code>matrix</code>, return <em>all elements of the</em> <code>matrix</code> <em>in spiral order</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="img/54-1.jpg" style="width: 242px; height: 242px;">
<pre><strong>Input:</strong> matrix = [[1,2,3],[4,5,6],[7,8,9]]
<strong>Output:</strong> [1,2,3,6,9,8,7,4,5]
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="img/54-2.jpg" style="width: 322px; height: 242px;">
<pre><strong>Input:</strong> matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
<strong>Output:</strong> [1,2,3,4,8,12,11,10,9,5,6,7]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
  <li><code>m == matrix.length</code></li>
  <li><code>n == matrix[i].length</code></li>
  <li><code>1 &lt;= m, n &lt;= 10</code></li>
  <li><code>-100 &lt;= matrix[i][j] &lt;= 100</code></li>
</ul>

<br>

---

## Problem Overview

### Problem: Spiral Matrix

**Problem Description:**

Given an `m x n` matrix, return all elements of the matrix in spiral order.

**Example 1:**

![Example 1](img/54-1.jpg)
```markdown
Input: matrix = [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
Output: [1, 2, 3, 6, 9, 8, 7, 4, 5]
```

**Example 2:**

![Example 2](img/54-2.jpg)
```markdown
Input: matrix = [[1, 2, 3, 4], [5, 6, 7, 8], [9, 10, 11, 12]]
Output: [1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7]
```

**Constraints:**

- `m == matrix.length`
- `n == matrix[i].length`
- `1 <= m, n <= 10`
- `-100 <= matrix[i][j] <= 100`

### Spiral Order Traversal

The problem statement asks us to return all elements of the matrix in spiral order, which means we will start from the top left corner and move towards the right, then down, then left, and then up. Let's break this into further details:

1. **Direction Movements:**
    - We can achieve moving in different directions by modifying row and column indices. Specifically, given that we are at `(row, col)`, where `row` is the row index, and `col` is the column index:
        - Move right: `(row, col + 1)`
        - Move down: `(row + 1, col)`
        - Move left: `(row, col - 1)`
        - Move up: `(row - 1, col)`

2. **When to Change Direction:**
    - We need to change direction when we either reach the matrix boundaries or visit cells that we have already visited. The matrix boundaries are fixed, but how do we know if we have visited a particular cell or not?
    - We have two strategies to handle this:
        - **Approach 1:** Move the boundaries towards the center of the matrix after traversing a row or a column. When we meet a boundary, we know it's time to change direction and update the boundary.
        - **Approach 2:** Record each location that we have visited while traversing the matrix. When we meet a matrix boundary or a previously visited cell, we know it's time to change direction.

