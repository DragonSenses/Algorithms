# 51. N-Queens

<p>The <strong>n-queens</strong> puzzle is the problem of placing <code>n</code> queens on an <code>n x n</code> chessboard such that no two queens attack each other.</p>

<p>Given an integer <code>n</code>, return <em>all distinct solutions to the <strong>n-queens puzzle</strong></em>. You may return the answer in <strong>any order</strong>.</p>

<p>Each solution contains a distinct board configuration of the n-queens' placement, where <code>'Q'</code> and <code>'.'</code> both indicate a queen and an empty space, respectively.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="img/51-1.jpg" style="width: 600px; height: 268px;">
<pre><strong>Input:</strong> n = 4
<strong>Output:</strong> [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
<strong>Explanation:</strong> There exist two distinct solutions to the 4-queens puzzle as shown above
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> n = 1
<strong>Output:</strong> [["Q"]]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
  <li><code>1 &lt;= n &lt;= 9</code></li>
</ul>

<br>

---

## Problem Overview: N-Queens

**Problem:**
The N-Queens puzzle involves placing `n` queens on an `n x n` chessboard in such a way that no two queens can attack each other. 

**Objective:**
Given an integer `n`, find and return all possible distinct solutions to the N-Queens puzzle. Each solution should be a unique configuration of the chessboard, where `'Q'` represents a queen and `'.'` represents an empty space. The solutions can be returned in any order.

**Example:**
1. **Input:** n = 4
   - **Output:** 
     ```json
     [
         [".Q..","...Q","Q...","..Q."],
         ["..Q.","Q...","...Q",".Q.."]
     ]
     ```
   - **Explanation:** There are two unique solutions for a 4x4 chessboard.

2. **Input:** n = 1
   - **Output:** 
     ```json
     [["Q"]]
     ```

**Constraints:**
- \(1 \leq n \leq 9\)
