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

# Solution

- [Backtracking Approach](#backtracking-approach)

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

### Inefficient Solutions to the N-Queens Puzzle

**1. Brute Force Approach**

A brute force solution involves generating all possible board states with N queens. The steps are as follows:
- Each of the \(N^2\) squares can be a potential position for the first queen.
- For the second queen, there are \(N^2 - 1\) possible positions, and so on.
- This results in a time complexity of \(O(N^2N)\), which is far too slow.

Given that the actual number of solutions is much smaller than the number of possible board states, it is essential to minimize the consideration of invalid board states.

**2. Example with 8 Queens**

Let's consider the example of placing 8 queens on a normal chessboard:
- Suppose the first queen is placed on the top left (index (0, 0), or a8 in chess notation).
- If the second queen is placed to its right (index (0, 1), or b8), there are \(62 \times 61 \times \ldots \times 57 = 44,261,653,680\) possible ways to place the remaining 6 queens.

However, we already know that all these possibilities are invalid because the first two queens can attack each other.

![Chessboard with the first queen placed at the top left (index 0,0 or a8) and the second queen placed to its right (index 0,1 or b8).](img/51-2.jpg)

This illustrates why a brute force approach is impractical and emphasizes the need for a more efficient solution.

# Backtracking Approach

### Overview: Backtracking

**Backtracking** is a problem-solving technique that involves incrementally building candidates for solutions and abandoning those that fail to satisfy the problem's constraints. It's often implemented using recursion and is particularly useful for solving puzzles like Sudoku, N-Queens, and crosswords. The key idea is to explore all possible configurations and backtrack whenever a partial solution cannot be completed to a valid solution.

## **Intuition**

The strategy involves generating board states, but we avoid placing a queen on a square that another queen can attack. This problem is perfect for backtracking: place the queens one by one, and when all possibilities are exhausted, backtrack by removing a queen and placing it elsewhere.

Given a board state and a possible placement for a queen, we need a method to determine whether that placement puts the queen under attack. A queen is under attack if another queen is in the same row, column, diagonal, or anti-diagonal.

To implement backtracking, we create a backtrack function that makes changes to the state, calls itself, and then undoes those changes when the call returns (hence the term "backtracking").

### **Pseudocode**

```pseudocode
function solveNQueens(int n) {
  List<List<String>> solutions = new ArrayList<>();
  Set<Integer> cols = new HashSet<>();
  Set<Integer> diagonals = new HashSet<>();
  Set<Integer> antiDiagonals = new HashSet<>();
  char[][] board = createEmptyBoard(n);

  function backtrack(int row) {
    if (row == n) {
      solutions.add(formatBoard(board));
      return;
    }

    for (int col = 0; col < n; col++) {
      int diagonal = row - col;
      int antiDiagonal = row + col;

      if (cols.contains(col) || diagonals.contains(diagonal) || antiDiagonals.contains(antiDiagonal)) {
        continue;
      }

      placeQueen(board, row, col);
      cols.add(col);
      diagonals.add(diagonal);
      antiDiagonals.add(antiDiagonal);

      backtrack(row + 1);

      removeQueen(board, row, col);
      cols.remove(col);
      diagonals.remove(diagonal);
      antiDiagonals.remove(antiDiagonal);
    }
  }

  backtrack(0);
  return solutions;
}

function createEmptyBoard(int n) {
  char[][] board = new char[n][n];
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
      board[i][j] = '.';
    }
  }
  return board;
}

function placeQueen(char[][] board, int row, int col) {
  board[row][col] = 'Q';
}

function removeQueen(char[][] board, int row, int col) {
  board[row][col] = '.';
}

function formatBoard(char[][] board) {
  List<String> formattedBoard = new ArrayList<>();
  for (int i = 0; i < board.length; i++) {
    formattedBoard.add(new String(board[i]));
  }
  return formattedBoard;
}
```

1. **solveNQueens(int n):**
   - Initializes the list `solutions` to store all valid solutions.
   - Uses `HashSet` for `cols`, `diagonals`, and `antiDiagonals` to track the placement of queens.
   - Creates an empty `board`.

2. **backtrack(int row):**
   - If `row` equals `n`, a valid solution is found and added to `solutions`.
   - Iterates through each column in the current row.
   - Checks if placing a queen at `(row, col)` conflicts with existing queens.
   - If no conflict, places the queen and updates sets.
   - Recursively calls `backtrack` for the next row.
   - After exploring all possibilities, backtracks by removing the queen and updating sets.

3. **Helper Functions:**
   - `createEmptyBoard(int n)`: Creates an empty `n x n` board.
   - `placeQueen(char[][] board, int row, int col)`: Places a queen on the board.
   - `removeQueen(char[][] board, int row, int col)`: Removes a queen from the board.
   - `formatBoard(char[][] board)`: Formats the board into a list of strings for the solution.
   