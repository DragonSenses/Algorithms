# 79. Word Search

<p>Given an <code>m x n</code> grid of characters <code>board</code> and a string <code>word</code>, return <code>true</code> <em>if</em> <code>word</code> <em>exists in the grid</em>.</p>

<p>The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="img/79-1.jpg" style="width: 322px; height: 242px;">
<pre><strong>Input:</strong> board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
<strong>Output:</strong> true
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="img/79-2.jpg" style="width: 322px; height: 242px;">
<pre><strong>Input:</strong> board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
<strong>Output:</strong> true
</pre>

<p><strong class="example">Example 3:</strong></p>
<img alt="" src="img/79-3.jpg" style="width: 322px; height: 242px;">
<pre><strong>Input:</strong> board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
<strong>Output:</strong> false
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
  <li><code>m == board.length</code></li>
  <li><code>n = board[i].length</code></li>
  <li><code>1 &lt;= m, n &lt;= 6</code></li>
  <li><code>1 &lt;= word.length &lt;= 15</code></li>
  <li><code>board</code> and <code>word</code> consists of only lowercase and uppercase English letters.</li>
</ul>

<p>&nbsp;</p>
<p><strong>Follow up:</strong> Could you use search pruning to make your solution faster with a larger <code>board</code>?</p>

<br>

---

# Solution

- [79. Word Search](#79-word-search)
- [Solution](#solution)
- [Backtracking Approach](#backtracking-approach)
  - [**Intuition**](#intuition)

# Backtracking Approach

## **Intuition**

This problem is a 2D grid traversal problem.

While it is true that we explore the 2D grid with a Depth-First Search (DFS) strategy, this alone does not capture the entire nature of the solution.

A more accurate term to summarize the solution is backtracking. Backtracking is a methodology where we mark the current path of exploration. If the path does not lead to a solution, we then revert the change (i.e., backtrack) and try another path.

In the general approach to the solution, we traverse the 2D grid. At each step, we mark our choice before moving to the next step. At the end of each step, we revert our mark so that we have a clean slate to try another direction. The exploration is done using the DFS strategy, where we go as far as possible before trying the next direction.

