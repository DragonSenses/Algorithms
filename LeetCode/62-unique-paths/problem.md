# 62. Unique Paths

<p>There is a robot on an <code>m x n</code> grid. The robot is initially located at the <strong>top-left corner</strong> (i.e., <code>grid[0][0]</code>). The robot tries to move to the <strong>bottom-right corner</strong> (i.e., <code>grid[m - 1][n - 1]</code>). The robot can only move either down or right at any point in time.</p>

<p>Given the two integers <code>m</code> and <code>n</code>, return <em>the number of possible unique paths that the robot can take to reach the bottom-right corner</em>.</p>

<p>The test cases are generated so that the answer will be less than or equal to <code>2 * 10<sup>9</sup></code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img style="width: 400px; height: 183px;" src="img/62-1.jpg">
<pre><strong>Input:</strong> m = 3, n = 7
<strong>Output:</strong> 28
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> m = 3, n = 2
<strong>Output:</strong> 3
<strong>Explanation:</strong> From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -&gt; Down -&gt; Down
2. Down -&gt; Down -&gt; Right
3. Down -&gt; Right -&gt; Down
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
  <li><code>1 &lt;= m, n &lt;= 100</code></li>
</ul>

---

# Solution

- [Dynamic Programming Approach](#dynamic-programming-approach)

### Problem Overview: Unique Paths

**Problem Statement**:
There is a robot on an \( m \times n \) grid. The robot is initially located at the **top-left corner** (i.e., `grid[0][0]`). The robot tries to move to the **bottom-right corner** (i.e., `grid[m - 1][n - 1]`). The robot can only move either down or right at any point in time.

Given the two integers \( m \) and \( n \), return the number of possible unique paths that the robot can take to reach the bottom-right corner.

The test cases are generated so that the answer will be less than or equal to \( 2 \times 10^9 \).

### Examples

**Example 1**:
```plaintext
Input: m = 3, n = 7
Output: 28
```

**Example 2**:
```plaintext
Input: m = 3, n = 2
Output: 3
Explanation: From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Down -> Down
2. Down -> Down -> Right
3. Down -> Right -> Down
```

### Constraints

- \( 1 \leq m, n \leq 100 \)

### Approach

1. **Dynamic Programming**:
   - Use a 2D array `dp` where `dp[i][j]` represents the number of unique paths to reach the cell `(i, j)`.
   - Initialize `dp[0][0]` to 1 since there's only one way to be at the starting point.
   - For each cell `(i, j)`, the robot can arrive from the top `(i-1, j)` or from the left `(i, j-1)`. Therefore, `dp[i][j] = dp[i-1][j] + dp[i][j-1]`.
   - Iterate through the grid, updating `dp` values based on the above formula.
   - The final answer is stored in `dp[m-1][n-1]`.

2. **Combinatorial**:
   - The problem can also be solved using combinatorial mathematics. The total number of movements required is \( (m-1) \) down movements and \( (n-1) \) right movements.
   - The number of unique paths is the number of ways to arrange these movements, which can be calculated using binomial coefficients: \( \binom{(m-1) + (n-1)}{m-1} \) or \( \binom{(m-1) + (n-1)}{n-1} \).

# Dynamic Programming Approach

## **Intuition**

Let's start by building up a recursive solution.

1. **First Row**:
   - Since the robot can move either down or right, there is only one path to reach the cells in the first row: right → right → ... → right.

   **For the cells in the first row**:
   ```plaintext
   right → right → ... → right
   ```

2. **First Column**:
   - There is only one path to reach the cells in the first column: down → down → ... → down.

   **For the cells in the first column**:
   ```plaintext
   down → down → ... → down
   ```

3. **Inner Cells**:
   - What about the "inner" cells `(m, n)`? The robot can move either from the cell on the left `(m, n-1)`, or from the cell above `(m-1, n)`. This means that the total number of paths to move into the `(m, n)` cell is:
   ```plaintext
   uniquePaths(m-1, n) + uniquePaths(m, n-1)
   ```

   **Example**:
   ```plaintext
   uniquePaths(1, 1) = uniquePaths(0, 1) + uniquePaths(1, 0)
   ```
