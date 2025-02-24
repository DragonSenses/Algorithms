# 52. N-Queens II

<p>The <strong>n-queens</strong> puzzle is the problem of placing <code>n</code> queens on an <code>n x n</code> chessboard such that no two queens attack each other.</p>

<p>Given an integer <code>n</code>, return <em>the number of distinct solutions to the&nbsp;<strong>n-queens puzzle</strong></em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="img/52-1.jpg" style="width: 600px; height: 268px;">
<pre><strong>Input:</strong> n = 4
<strong>Output:</strong> 2
<strong>Explanation:</strong> There are two distinct solutions to the 4-queens puzzle as shown.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> n = 1
<strong>Output:</strong> 1
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= n &lt;= 9</code></li>
</ul>

---

## Problem Overview: N-Queens II

The **N-Queens** puzzle is a classic problem where you need to place `n` queens on an `n x n` chessboard such that no two queens can attack each other. This means:
- No two queens share the same row.
- No two queens share the same column.
- No two queens share the same diagonal.

The task is to find and return the number of distinct solutions for a given integer `n`.

### Examples

**Example 1:**
- **Input:** `n = 4`
- **Output:** `2`
- **Explanation:** There are two distinct solutions to the 4-queens puzzle.

**Example 2:**
- **Input:** `n = 1`
- **Output:** `1`
- **Explanation:** There is only one way to place one queen on a 1x1 board.

### Constraints
- `1 <= n <= 9`