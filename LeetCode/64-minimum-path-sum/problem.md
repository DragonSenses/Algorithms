# 64. Minimum Path Sum

<p>Given a <code>m x n</code> <code>grid</code> filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.</p>

<p><strong>Note:</strong> You can only move either down or right at any point in time.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" style="width: 242px; height: 242px;" src="img/64-1.jpg">
<pre><strong>Input:</strong> grid = [[1,3,1],[1,5,1],[4,2,1]]
<strong>Output:</strong> 7
<strong>Explanation:</strong> Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> grid = [[1,2,3],[4,5,6]]
<strong>Output:</strong> 12
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
  <li><code>m == grid.length</code></li>
  <li><code>n == grid[i].length</code></li>
  <li><code>1 &lt;= m, n &lt;= 200</code></li>
  <li><code>0 &lt;= grid[i][j] &lt;= 200</code></li>
</ul>

---

# Solution

- [Recursive (Brute Force) Approach](#recursive-brute-force-approach)
  - **Time Complexity**: `O(2^(m+n))`
  - **Space Complexity**: `O(m+n)`
- [Dynamic Programming Approach](#dynamic-programming-approach)
  - **Time Complexity**: `O(m*n)`
  - **Space Complexity**: `O(m*n)`
- [Dynamic Programming: In-Place Grid Modification Approach](#dynamic-programming-in-place-grid-modification-approach)
  - **Time Complexity**: `O(m*n)`
  - **Space Complexity**: `O(1)`

### Problem Overview: Minimum Path Sum
The task is to find the **minimum sum of numbers** along a path from the **top-left corner** to the **bottom-right corner** of a grid. The grid contains **non-negative numbers** in each cell. You can only move either **right** or **down** at any point in time.

### Key Features
1. **Grid Dimensions**:
   - The grid is `m x n`, where `m` is the number of rows and `n` is the number of columns.
   - Each cell contains a non-negative number (0 or greater).

2. **Allowed Moves**:
   - You can only move:
     - **Down** (to the cell directly below).
     - **Right** (to the cell directly to the right).

3. **Goal**:
   - Compute the **path** from the top-left corner `(0, 0)` to the bottom-right corner `(m-1, n-1)` that has the **minimum sum** of all cell values along the way.

### Examples
#### Example 1:
- **Input**: `grid = [[1,3,1], [1,5,1], [4,2,1]]`
- **Explanation**: 
  - The best path is `1 → 3 → 1 → 1 → 1`, with a total sum of `7`.
  - This is achieved by minimizing the numbers along the path while adhering to the movement restrictions (right/down).
- **Output**: `7`

#### Example 2:
- **Input**: `grid = [[1,2,3], [4,5,6]]`
- **Explanation**: 
  - The best path is `1 → 2 → 3 → 6`, with a total sum of `12`.
- **Output**: `12`

### Constraints
- **Grid Dimensions**:
  - `1 ≤ m, n ≤ 200`
- **Cell Values**:
  - Each cell value is in the range `0 ≤ grid[i][j] ≤ 200`.

### Approach to Solve
1. **Dynamic Programming**:
   - Create a table (`dp`) where each cell stores the minimum path sum to reach that cell.
   - Transition:
     - `dp[i][j] = grid[i][j] + min(dp[i-1][j], dp[i][j-1])` (choose the minimum of coming from the top or left).
   - Base cases:
     - Start at `(0, 0)` with `dp[0][0] = grid[0][0]`.
   - Traverse the grid row by row or column by column to fill the table.

2. **Space Optimization**:
   - You can reduce space usage by modifying the input grid directly or using a single-dimensional array instead of a full table.

# Recursive (Brute Force) Approach

The brute force approach, though simple and naive, serves as a starting point rather than a viable solution.

## **Intuition**

The recursive brute force approach relies on exploring all possible paths from the top-left corner to the bottom-right corner of the grid. For each grid cell `(i, j)`, there are two possible moves: 
1. **Move Right**: Proceed to cell `(i, j+1)`.
2. **Move Down**: Proceed to cell `(i+1, j)`.

The idea is to calculate the total path sum for every valid path and return the **minimum path sum** among them. The recursive approach inherently breaks the problem into smaller subproblems by choosing one step at a time (right or down). 

However, brute force recursion is **inefficient**, as it repeatedly recalculates the minimum path sums for overlapping subproblems. This leads to exponential time complexity, making it impractical for larger grids.

## **Algorithm**

1. **Base Case**: 
   - If the current cell is the bottom-right corner `(m-1, n-1)`, return its value as the remaining path sum is simply the cell value.
   - If the current cell lies **out of bounds** (beyond the grid's rows or columns), return a very large value (treated as infinity) to signify an invalid path.

2. **Recursive Relation**:
   - From the current cell `(i, j)`, recursively calculate the minimum path sum for both possible moves:
     - Moving **right**: Call the function for cell `(i, j+1)`.
     - Moving **down**: Call the function for cell `(i+1, j)`.
   - Add the current cell's value `grid[i][j]` to the minimum of the two computed values to get the minimum path sum for the current cell.

3. **Final Result**:
   - Start the recursion from the top-left corner `(0, 0)`. The result will represent the minimum path sum for the entire grid.

### **Pseudo-code**

```plaintext
function minPathSum(grid, i, j):
    if i == m-1 and j == n-1: 
        return grid[i][j]  // Base case: Reached bottom-right corner
    if i >= m or j >= n: 
        return infinity    // Out of bounds
    
    // Calculate minimum sum from right and down moves
    rightPath = minPathSum(grid, i, j+1)
    downPath = minPathSum(grid, i+1, j)

    // Return the current cell value + minimum of the two paths
    return grid[i][j] + min(rightPath, downPath)
```

### **Key Observations**
- **Exponential Complexity**: The approach repeatedly computes results for overlapping subproblems, resulting in a time complexity of \(O(2^{m+n})\). This is due to the two recursive calls at each step.
- **Optimization Opportunity**: To address inefficiency, we can store the results of subproblems (using memoization or dynamic programming) to avoid redundant computations, transforming it into a more efficient solution.

## **Implementation**

### Java

```java
public class Solution {
  // Recursive helper method
  public int computePathSum(int[][] grid, int i, int j) {
    // Base case: Out of bounds
    if (i == grid.length || j == grid[0].length) {
      return Integer.MAX_VALUE;
    }
    // Base case: Reached bottom-right corner
    if (i == grid.length - 1 && j == grid[0].length - 1) {
      return grid[i][j];
    }
    // Recursive case: Compute the minimum path sum
    return grid[i][j] + Math.min(computePathSum(grid, i + 1, j), computePathSum(grid, i, j + 1));
  }

  // Main method to compute the minimum path sum
  public int minPathSum(int[][] grid) {
    return computePathSum(grid, 0, 0);
  }
}
```

### TypeScript

```typescript
function minPathSum(grid: number[][]): number {
  // Recursive helper function
  const computePathSum = (i: number, j: number): number => {
      // Base case: Out of bounds
      if (i >= grid.length || j >= grid[0].length) {
          return Infinity; // Treat as invalid path
      }
      // Base case: Reached bottom-right corner
      if (i === grid.length - 1 && j === grid[0].length - 1) {
          return grid[i][j];
      }
      // Recursive case: Compute the minimum path sum
      return grid[i][j] + Math.min(computePathSum(i + 1, j), computePathSum(i, j + 1));
  };

  // Start the recursion from the top-left corner
  return computePathSum(0, 0);
};
```

## **Complexity Analysis**

### **Assumptions**
- **Grid Dimensions (m x n)**: The grid has `m` rows and `n` columns.
- **Path Restrictions**: Movement is restricted to either right (to cell `(i, j+1)`) or down (to cell `(i+1, j)`).
- **Recursive Approach**: The recursive function explores all possible paths from the top-left to the bottom-right of the grid.

### **Time Complexity**: `O(2^(m+n))`
- **Recursive Calls**: 
  - At each cell `(i, j)`, the function makes two recursive calls: one for moving **right** and another for moving **down**.
  - The recursive process forms a binary tree of calls. The depth of this tree is approximately `m + n` because it takes `m-1` steps down and `n-1` steps right to reach the destination.
  - This results in a total of \(O(2^{m+n})\) recursive calls.
- **Subproblem Overlap**:
  - Many overlapping subproblems are recalculated in different branches of recursion due to lack of memoization, contributing to the exponential growth.

### **Space Complexity**: `O(m+n)`
- **Maximum Depth**:
  - At any point, the recursion stack stores calls for one path from the top-left to the bottom-right corner of the grid.
  - The maximum depth of this stack is \(O(m+n)\), as it takes at most `m-1` steps down and `n-1` steps right to complete the path.
- **Additional Space**:
  - No additional data structures are used in the brute force approach, so the space usage is limited to the recursion stack.

# Dynamic Programming Approach

Dynamic programming ensures we calculate the result for each cell exactly once, and reuse those results to build solutions for subsequent cells. This eliminates the exponential time complexity of the recursive approach by reducing it to a manageable `O(m*n)`, where `m` and `n` are the grid's dimensions.

## **Intuition**

The dynamic programming approach efficiently solves the problem by recognizing and leveraging the fact that the **minimum path sum** at any cell in the grid depends solely on the minimum path sums of its adjacent cells from which we can reach it (either from above or from the left).

Instead of recalculating overlapping subproblems multiple times (as in the recursive approach), we store the results of subproblems in a table (or modify the input grid directly) to avoid redundant computations. This is a classic **"overlapping subproblems"** scenario that dynamic programming is designed to optimize.

### **Key Idea**
1. **Breaking Down the Problem**:
   - For any cell `(i, j)`, the **minimum path sum** is the value of the current cell (`grid[i][j]`) plus the smaller of the minimum path sums of the two possible previous cells:
     - The cell directly above `(i-1, j)`.
     - The cell directly to the left `(i, j-1)`.

2. **Base Case**:
   - At the top-left corner `(0, 0)`, the minimum path sum is simply the value of that cell, as there is no other path to reach it.

3. **Building the Solution**:
   - Starting from the top-left corner, iteratively compute the minimum path sum for every cell in the grid using the above relation.
   - By the time we reach the bottom-right corner, we will have the minimum path sum for the entire grid stored there.

### **Approach**

We use an extra matrix `dp` of the same size as the original matrix. In this matrix, `dp(i, j)` represents the minimum sum of the path from the index `(i, j)` to the bottom-rightmost element of the grid. 

1. **Initialization**:
   - The bottom-rightmost element of `dp` is initialized as the last element of the given matrix (`grid`), as this is the final destination with no further cells to traverse.

2. **Backward Traversal**:
   - Starting from the bottom-right corner of the grid, we traverse backwards through the grid to compute the minimum sums for each cell. At every cell, we consider the two possible moves:
     - **Rightwards**: Move to cell `(i, j+1)`.
     - **Downwards**: Move to cell `(i+1, j)`.

3. **Transition Relation**:
   - The equation for calculating the minimum sum for a cell is:
     \[
     dp(i, j) = grid(i, j) + \min(dp(i+1, j), dp(i, j+1))
     \]
   - This ensures that the value of each cell in the `dp` matrix represents the minimum sum of all possible paths from that cell to the destination.

4. **Boundary Conditions**:
   - Special care is taken for boundary conditions (e.g., when `i+1` or `j+1` exceeds the grid dimensions) to avoid out-of-bounds errors.

## **Algorithm**

1. **Initialize a DP Table**:
   - Create a 2D matrix `dp` of the same dimensions as the input grid.
   - Set `dp[m-1][n-1]` (the bottom-right cell) equal to `grid[m-1][n-1]`, as it represents the starting point of the traversal (the destination itself).

2. **Populate the Last Row and Column**:
   - Fill in the last row (`dp[m-1][j]`) by summing the current grid cell value and the cell to its right:  
     \[
     dp[m-1][j] = grid[m-1][j] + dp[m-1][j+1]
     \]
   - Similarly, fill in the last column (`dp[i][n-1]`) by summing the current grid cell value and the cell below:  
     \[
     dp[i][n-1] = grid[i][n-1] + dp[i+1][n-1]
     \]

3. **Traverse the Grid Backwards**:
   - For each cell `(i, j)` from the second-last row to the top row, and from the second-last column to the first column:
     - Compute the minimum sum for that cell using the formula:  
       \[
       dp[i][j] = grid[i][j] + \min(dp[i+1][j], dp[i][j+1])
       \]

4. **Final Result**:
   - The value at `dp[0][0]` (top-left corner) will contain the minimum path sum from the top-left to the bottom-right of the grid.

### **Optimization**: In-Place Grid
 - To save space, use the input grid itself as the `dp` matrix or optimize to a single-dimensional array for better efficiency when only the last computed row or column is needed. See [Dynamic Programming: In-Place Grid Modification Approach](#dynamic-programming-in-place-grid-modification-approach).

## **Implementation**

### Java

```java
public class Solution {
  public int minPathSum(int[][] grid) {
    // Get the dimensions of the grid
    int rows = grid.length;
    int cols = grid[0].length;

    // Step 1: Initialize a DP table
    int[][] dp = new int[rows][cols];

    // Step 2: Set the bottom-right cell of dp
    dp[rows - 1][cols - 1] = grid[rows - 1][cols - 1];

    // Step 3: Populate the last row
    for (int j = cols - 2; j >= 0; j--) {
      dp[rows - 1][j] = grid[rows - 1][j] + dp[rows - 1][j + 1];
    }

    // Step 4: Populate the last column
    for (int i = rows - 2; i >= 0; i--) {
      dp[i][cols - 1] = grid[i][cols - 1] + dp[i + 1][cols - 1];
    }

    // Step 5: Traverse the grid backwards to fill the dp table
    for (int i = rows - 2; i >= 0; i--) {
      for (int j = cols - 2; j >= 0; j--) {
        dp[i][j] = grid[i][j] + Math.min(dp[i + 1][j], dp[i][j + 1]);
      }
    }

    // Step 6: Return the value at the top-left corner of the dp table
    return dp[0][0];
  }
}
```

### TypeScript

```typescript
function minPathSum(grid: number[][]): number {
  const rows = grid.length;
  const cols = grid[0].length;

  // Step 1: Initialize a DP table
  const dp: number[][] = Array.from({ length: rows }, () => Array(cols).fill(0));

  // Step 2: Set the bottom-right cell of dp
  dp[rows - 1][cols - 1] = grid[rows - 1][cols - 1];

  // Step 3: Populate the last row
  for (let j = cols - 2; j >= 0; j--) {
    dp[rows - 1][j] = grid[rows - 1][j] + dp[rows - 1][j + 1];
  }

  // Step 4: Populate the last column
  for (let i = rows - 2; i >= 0; i--) {
    dp[i][cols - 1] = grid[i][cols - 1] + dp[i + 1][cols - 1];
  }

  // Step 5: Traverse the grid backwards to fill the dp table
  for (let i = rows - 2; i >= 0; i--) {
    for (let j = cols - 2; j >= 0; j--) {
      dp[i][j] = grid[i][j] + Math.min(dp[i + 1][j], dp[i][j + 1]);
    }
  }

  // Step 6: Return the value at the top-left corner of the dp table
  return dp[0][0];
}
```

## **Complexity Analysis**

### **Assumptions**
- **Grid Dimensions (m x n)**: The grid consists of `m` rows and `n` columns.
- **Path Restrictions**: At any cell `(i, j)`, movement is restricted to:
  - **Right**: Proceed to cell `(i, j+1)`.
  - **Down**: Proceed to cell `(i+1, j)`.
- **Dynamic Programming Approach**: A `dp` matrix is used (or the grid is modified in-place) to store the minimum path sums for each cell.

### **Time Complexity**: `O(m * n)`
- **Cell-by-Cell Traversal**:
  - The algorithm iterates over each cell of the grid exactly once in a row-major order (row by row, left to right).
  - This traversal involves \(O(m)\) iterations for the rows and \(O(n)\) iterations for the columns, leading to `O(m*n)` total iterations.
- **Per-Cell Computation**:
  - For each cell `(i, j)`, the minimum path sum is computed in constant time `O(1)` using the values of the adjacent cells (`dp[i-1][j]` and `dp[i][j-1]` or their equivalents in the grid).
- **No Redundant Computation**:
  - Each cell's value is computed only once, ensuring there are no repeated calculations (unlike the recursive approach).
  
**Result**: The time complexity of the dynamic programming approach is `O(m*n)`.

### **Space Complexity**: `O(m*n)`  
#### **Using a Separate DP Matrix**  
- **DP Matrix:** A 2D `dp` matrix of size \(m \times n\) is utilized to store the minimum path sums for each cell, requiring **`O(m*n)`** additional space.  
- **Auxiliary Structures:** Only a few variables, such as indices `i` and `j`, are used, consuming **`O(1)`** space.  

**Result:** The total space complexity is **`O(m*n)`**.  

### **Comparison with Recursive Approach**
- **Time Complexity**: While the recursive approach is \(O(2^{m+n})\), the dynamic programming approach avoids redundant calculations, reducing this to `O(m*n)`.
- **Space Complexity**:
  - The recursive approach uses \(O(m + n)\) space for the recursion stack.
  - The DP approach, with in-place modification, is much more efficient at `O(1)` space.

# Dynamic Programming: In-Place Grid Modification Approach

## **Intuition**

The in-place grid modification approach is a refinement of the standard dynamic programming method. Instead of using an additional `dp` matrix to store the minimum path sums, we update the input grid itself. This eliminates the need for extra space, as the grid can act as the `dp` table.

### Key Idea:
- Each cell in the grid, `grid(i, j)`, is updated to store the **minimum path sum** required to reach the bottom-right corner starting from that cell.
- This is achieved by using the values of the adjacent cells below and to the right, which are updated progressively during the traversal.
- Traversing the grid **backwards** from the bottom-right ensures adjacent cells (down and right) are updated before processing each cell.  
- The top-left corner (`grid(0, 0)`) ultimately holds the minimum path sum.
- By traversing the grid in reverse (bottom-right to top-left), the values in the grid itself can be safely overwritten without losing any necessary information for future calculations.
- This eliminates the need for an extra `dp` matrix, reducing space complexity from `O(m*n)` to `O(1)`.

### Governing Equation:
For each cell `(i, j)`, the updated value is calculated as:
\[
grid(i, j) = grid(i, j) + \min(grid(i+1, j), grid(i, j+1))
\]

## **Algorithm**

1. **Modify the Grid to Act as the DP Table**:
   - Use the input `grid` directly as the `dp` table to save space.
   - The value at each cell will represent the minimum path sum to reach that cell from the top-left.

2. **Traverse the Grid Forward**:
   - For each cell `(i, j)` in the grid:
     - **Top-Left Corner**: Skip updating `grid[0][0]` since it is the starting point.
     - **First Row**: Update the cell value based on the sum of its value and the cell to its left:
       \[
       grid[0][j] = grid[0][j] + grid[0][j-1]
       \]
     - **First Column**: Update the cell value based on the sum of its value and the cell above:
       \[
       grid[i][0] = grid[i][0] + grid[i-1][0]
       \]
     - **Other Cells**: Update the cell value based on the sum of its value and the minimum of the adjacent cells (above and left):
       \[
       grid[i][j] = grid[i][j] + \min(grid[i-1][j], grid[i][j-1])
       \]

3. **Final Result**:
   - After traversing the entire grid, the value at `grid[m-1][n-1]` (bottom-right corner) contains the minimum path sum from the top-left to the bottom-right of the grid.

### **Pseudocode**

```plaintext
function minPathSum(grid):
  rows = number of rows in grid
  cols = number of columns in grid

  # Step 1: Traverse the grid forward
  for i from 0 to rows - 1:
    for j from 0 to cols - 1:
        # Step 2: Skip the top-left corner
        if i == 0 and j == 0:
            continue
        
        # Step 3: Update the grid for the first row
        if i == 0:
            grid[i][j] += grid[i][j - 1]
        
        # Step 4: Update the grid for the first column
        else if j == 0:
            grid[i][j] += grid[i - 1][j]
        
        # Step 5: Update the grid for other cells
        else:
          grid[i][j] += min(grid[i - 1][j], grid[i][j - 1])

  # Step 6: Return the result at the bottom-right corner
  return grid[rows - 1][cols - 1]
```

## **Implementation**

#### Implementation Details

1. **Initialize**:
   - Let `grid` be the input matrix with dimensions `m x n`.

2. **Traverse the Grid Forward**:
   - **For cell `grid[0][0]`**:  
     Skip updating since it is the starting point.
   - **For the top row** (`i == 0`):  
     - For each column `j` from `1` to `n-1`, update:
       ```
       grid[0][j] = grid[0][j] + grid[0][j-1]
       ```
   - **For the first column** (`j == 0`):  
     - For each row `i` from `1` to `m-1`, update:
       ```
       grid[i][0] = grid[i][0] + grid[i-1][0]
       ```
   - **For all other cells** (`i > 0` and `j > 0`):  
     - For each row `i` from `1` to `m-1` and each column `j` from `1` to `n-1`, update:
       ```
       grid[i][j] = grid[i][j] + min(grid[i-1][j], grid[i][j-1])
       ```

3. **Final Result**:
   - After the traversal, the bottom-right cell `grid[m-1][n-1]` contains the minimum path sum.  
     Return `grid[m-1][n-1]`.

### Java

```java
public class Solution {
  public int minPathSum(int[][] grid) {
    // Step 1: Get the dimensions of the grid
    int rows = grid.length;
    int cols = grid[0].length;

    // Step 2: Traverse the grid and update it in-place
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        // Step 3: Skip the top-left corner as it doesn't have any prior paths
        if (i == 0 && j == 0) {
          continue;
        }

        if (i == 0) {
          // Step 4: If in the first row, update the cell based on the value from the left
          grid[i][j] += grid[i][j - 1];
        } else if (j == 0) {
          // Step 5: If in the first column, update the cell based on the value from above
          grid[i][j] += grid[i - 1][j];
        } else {
          // Step 6: Otherwise, update the cell based on the minimum value of the left or above cell
          grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
        }
      }
    }

    // Step 7: The bottom-right cell now contains the minimum path sum
    return grid[rows - 1][cols - 1];
  }
}
```

### TypeScript

```typescript
function minPathSum(grid: number[][]): number {
  const rows = grid.length;
  const cols = grid[0].length;

  // Step 1: Update the last row in-place
  for (let j = cols - 2; j >= 0; j--) {
    grid[rows - 1][j] += grid[rows - 1][j + 1];
  }

  // Step 2: Update the last column in-place
  for (let i = rows - 2; i >= 0; i--) {
    grid[i][cols - 1] += grid[i + 1][cols - 1];
  }

  // Step 3: Traverse the grid backwards and update cells in-place
  for (let i = rows - 2; i >= 0; i--) {
    for (let j = cols - 2; j >= 0; j--) {
      grid[i][j] += Math.min(grid[i + 1][j], grid[i][j + 1]);
    }
  }

  // Step 4: Return the value at the top-left corner
  return grid[0][0];
}
```

## **Complexity Analysis**

### **Assumptions**
- **Grid Dimensions (m x n)**: The grid consists of `m` rows and `n` columns.
- **Path Restrictions**: At any cell `(i, j)`, movement is restricted to:
  - **Right**: Proceed to cell `(i, j+1)`.
  - **Down**: Proceed to cell `(i+1, j)`.
- **Dynamic Programming Approach**: The input grid itself is used as the `dp` matrix, storing the minimum path sums for each cell as the algorithm progresses.

### **Time Complexity**: `O(m*n)`
- **Grid Traversal**:
  - The algorithm traverses each cell in the grid exactly once.
  - There are `m` rows and `n` columns, so the total number of cells processed is `m * n`.
- **Per-Cell Computation**:
  - For each cell `(i, j)`, the minimum path sum is computed in constant time `O(1)`, using the values of its adjacent cells (down or right).
- **No Redundant Computations**:
  - Each cell is visited and computed only once, eliminating redundancy.

**Result**: The time complexity is `O(m*n)`.

### **Space Complexity**: `O(1)`
- **In-Place Grid Modification**:
  - The input grid itself is used to store the intermediate and final results, eliminating the need for an additional `dp` matrix.
- **Auxiliary Space**:
  - The algorithm uses a constant amount of auxiliary variables (e.g., loop counters), which do not scale with the grid size.

**Result**: The space complexity is `O(1)`.
