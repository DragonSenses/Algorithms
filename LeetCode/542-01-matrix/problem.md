# 542. 01 Matrix

<p>Given an <code>m x n</code> binary matrix <code>mat</code>, return <em>the distance of the nearest </em><code>0</code><em> for each cell</em>.</p>

<p>The distance between two adjacent cells is <code>1</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="img/542-1.jpg" style="width: 253px; height: 253px;">
<pre><strong>Input:</strong> mat = [[0,0,0],[0,1,0],[0,0,0]]
<strong>Output:</strong> [[0,0,0],[0,1,0],[0,0,0]]
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="img/542-2.jpg" style="width: 253px; height: 253px;">
<pre><strong>Input:</strong> mat = [[0,0,0],[0,1,0],[1,1,1]]
<strong>Output:</strong> [[0,0,0],[0,1,0],[1,2,1]]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>m == mat.length</code></li>
	<li><code>n == mat[i].length</code></li>
	<li><code>1 &lt;= m, n &lt;= 10<sup>4</sup></code></li>
	<li><code>1 &lt;= m * n &lt;= 10<sup>4</sup></code></li>
	<li><code>mat[i][j]</code> is either <code>0</code> or <code>1</code>.</li>
	<li>There is at least one <code>0</code> in <code>mat</code>.</li>
</ul>

<br>

---

# Solution
- [Brute Force (Naive Approach)](#brute-force-naive-approach)

## Problem Overview

**Objective**:
Given an m x n binary matrix (with 0s and 1s), return the distance of the nearest 0 for each cell.

**Key Points**:
- Each cell in the matrix contains either a 0 or a 1.
- The distance between two adjacent cells is 1.
- For each cell in the matrix, you need to determine the distance to the nearest cell containing a 0.

**Examples**:
1. Input: `[[0,0,0],[0,1,0],[0,0,0]]`
   - Output: `[[0,0,0],[0,1,0],[0,0,0]]`
   - Explanation: Each 1 is adjacent to a 0, so the distance is 1.
2. Input: `[[0,0,0],[0,1,0],[1,1,1]]`
   - Output: `[[0,0,0],[0,1,0],[1,2,1]]`
   - Explanation: The distance for the bottom-left and bottom-right 1s are 1 and 2, respectively.

**Constraints**:
- The matrix dimensions (m and n) can be as large as 10,000.
- Each matrix cell is either 0 or 1.
- There is at least one 0 in the matrix.

# Brute Force (Naive Approach)

For the most naive approach: for each cell, we can find the distance of the closest zero.

Note: This brute force approach is simple but inefficient, with a time complexity of `O(m^2 * n^2)`, which is impractical for large matrices. There are more efficient approaches for this problem, but this lays the groundwork for understanding the basic idea.

## **Intuition**

**Approach**:
1. For each cell in the matrix, check all other cells to find the nearest 0.
2. Use nested loops to iterate over all pairs of cells and calculate their distances.

## **Algorithm**

**Steps**:
1. Initialize a new matrix with the same dimensions to store distances.
2. For each cell (i, j) in the matrix:
   - If the cell is 0, the distance is 0.
   - If the cell is 1, initialize its distance to infinity.
   - For each other cell (x, y) in the matrix:
     - If the cell (x, y) is 0, calculate the distance to (i, j) and update if it’s smaller.
3. Return the new matrix with the calculated distances.


