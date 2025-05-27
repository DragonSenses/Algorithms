# 85. Maximal Rectangle

<p>Given a <code>rows x cols</code>&nbsp;binary <code>matrix</code> filled with <code>0</code>'s and <code>1</code>'s, find the largest rectangle containing only <code>1</code>'s and return <em>its area</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" style="width: 402px; height: 322px;" src="img/85-1.jpg">
<pre><strong>Input:</strong> matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
<strong>Output:</strong> 6
<strong>Explanation:</strong> The maximal rectangle is shown in the above picture.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> matrix = [["0"]]
<strong>Output:</strong> 0
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> matrix = [["1"]]
<strong>Output:</strong> 1
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>rows == matrix.length</code></li>
	<li><code>cols == matrix[i].length</code></li>
	<li><code>1 &lt;= row, cols &lt;= 200</code></li>
	<li><code>matrix[i][j]</code> is <code>'0'</code> or <code>'1'</code>.</li>
</ul>

---

# Solution

- [Brute Force (Naive) Approach](#brute-force-naive-approach)
  - **Time Complexity: `O(n^3 * m^3)`**
  - **Space Complexity**: `O(1)`
- [Dynamic Programming Approach](#dynamic-programming-approach)

### Problem Overview: Maximal Rectangle

The **Maximal Rectangle** problem requires finding the largest rectangular submatrix containing only `1`s in a given binary matrix (`rows x cols`) and returning its area.

#### Problem Breakdown:
- You are given a `rows x cols` binary matrix filled with `'0'`s and `'1'`s.
- The goal is to determine the largest contiguous rectangular area that consists only of `1`s.
- The output is the area of this maximal rectangle.

#### Examples:
##### Example 1:
**Input:**  
```
matrix = [
    ["1","0","1","0","0"],
    ["1","0","1","1","1"],
    ["1","1","1","1","1"],
    ["1","0","0","1","0"]
]
```
**Output:** `6`  
**Explanation:** The largest rectangle containing only `1`s has an area of `6`.

##### Example 2:
**Input:**  
```
matrix = [["0"]]
```
**Output:** `0`

##### Example 3:
**Input:**  
```
matrix = [["1"]]
```
**Output:** `1`

#### Constraints:
- `rows == matrix.length`
- `cols == matrix[i].length`
- `1 <= rows, cols <= 200`
- `matrix[i][j]` is `'0'` or `'1'`

#### Approach:
- One efficient way to solve this is by leveraging **dynamic programming** and **monotonic stack techniques** to transform the problem into a **largest rectangle in a histogram** challenge.
- You can maintain a **height array** that tracks the consecutive `1`s at each row, and apply the **largest rectangle in histogram** algorithm.

# Brute Force (Naive) Approach

We explore the brute force approach to develop foundational intuition before optimizing.

## **Intuition**
A straightforward way to solve the problem is to consider every possible rectangle within the matrix. This requires iterating over all pairs of possible top-left and bottom-right corners, verifying whether the entire enclosed area consists of `1`s, and tracking the largest valid area found.

- **Step 1:** Choose any two opposite corners `(x1, y1)` and `(x2, y2)` that define a submatrix.
- **Step 2:** Check whether all elements within this submatrix are `1`s.
- **Step 3:** Track the maximal rectangle area found.

This approach is **highly inefficient** because it redundantly evaluates overlapping areas multiple times.

## **Algorithm**
1. Iterate over all possible `(x1, y1)` positions as the top-left corner.
2. Iterate over all possible `(x2, y2)` positions as the bottom-right corner.
3. Verify that the entire rectangle from `(x1, y1)` to `(x2, y2)` consists of `1`s.
4. Compute and maintain the largest valid area found.

## **Implementation**

```java
class Solution {
  public int maximalRectangle(char[][] matrix) {
    int n = matrix.length, m = matrix[0].length;
    int maxArea = 0;

    for (int x1 = 0; x1 < n; x1++) {
      for (int y1 = 0; y1 < m; y1++) {
        for (int x2 = x1; x2 < n; x2++) {
          for (int y2 = y1; y2 < m; y2++) {
            if (isValidRectangle(matrix, x1, y1, x2, y2)) {
              int area = (x2 - x1 + 1) * (y2 - y1 + 1);
              maxArea = Math.max(maxArea, area);
            }
          }
        }
      }
    }
    return maxArea;
  }

  private boolean isValidRectangle(char[][] matrix, int x1, int y1, int x2, int y2) {
    for (int i = x1; i <= x2; i++) {
      for (int j = y1; j <= y2; j++) {
        if (matrix[i][j] == '0') {
          return false;
        }
      }
    }
    return true;
  }
}
```

## **Complexity Analysis**

### **Assumptions**
- Let `n` be the number of rows.
- Let `m` be the number of columns.

### **Time Complexity: `O(n^3 * m^3)`**
- Choosing two opposite corners: `O(n^2 * m^2)`.
- Checking whether the submatrix contains only `1`s: `O(n * m)` in the worst case.
- Thus, the overall worst-case complexity is **`O(n^3 * m^3)`**, making this approach impractical for large matrices.

### **Space Complexity: `O(1)`**
- **No extra memory used:** The approach relies only on a few integer variables for tracking indices and area.
- **Constant additional space:** The matrix itself is given as input, and no extra data structures are created.

### **Why This Is Too Slow**
- Evaluates **all possible rectangles**, leading to an explosion of computations.
- **Redundant checks** for overlapping rectangles.
- **Exponential growth**, making it infeasible for `n, m` approaching `200`.

# Dynamic Programming Approach

We optimize the brute force method by leveraging histograms to reduce redundant computations.

## **Intuition**
Instead of considering all possible rectangles, we build a **DP table** (`dp[i][j]`) that stores **the maximum width** of a rectangle ending at `(i, j)`. This allows us to compute **valid rectangle areas efficiently**. 

The idea is:
- **Track maximum width** at each position:  
  `dp[i][j] = dp[i][j-1] + 1` if `matrix[i][j] == '1'`
- **Use previous rows to determine the height**:  
  Iterate **upwards**, finding the **smallest width** encountered.
- **Compute area** using:  
  `width * height`, ensuring **the maximum** area is tracked.

This approach allows us to compute **each rectangle efficiently** rather than redundantly scanning full regions.

### Key Idea: Histogram

Instead of considering all possible rectangles explicitly, we can treat each row of the matrix as a **base** and compute maximal **histograms** from it. The key idea:
- We maintain an array **heights[]**, where `heights[j]` tracks the number of consecutive `1`s ending at the current row.
- We use the **largest rectangle in a histogram** method to find the **maximum rectangular area** at each row.
- This effectively transforms the matrix into **row-wise histograms**, solving them efficiently.

### Key Observations:
1. **Tracking Heights:** At each row, update `heights[j]` as:
   - `heights[j] = heights[j] + 1` if `matrix[i][j] == '1'`
   - `heights[j] = 0` if `matrix[i][j] == '0'`
2. **Applying Largest Rectangle in Histogram:** Once we construct the height array, we treat it as a histogram and use a **monotonic stack** (or other approaches) to find the largest rectangular area efficiently.

This approach is a direct extension of **84 - Largest Rectangle in Histogram**.

## **Algorithm**
1. Initialize a **DP table** (`dp[][]`) to store widths at each `(i, j)`.
2. **Iterate** through each matrix cell:
   - If `matrix[i][j] == '1'`, update `dp[i][j]` based on leftward values.
   - Track the **minimum width** from previous rows.
   - Compute the **area** dynamically.
3. Maintain a global **maxArea** across iterations.