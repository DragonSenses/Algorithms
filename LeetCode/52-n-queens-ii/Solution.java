import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
  public int totalNQueens(int n) {
    // Set to keep track of columns, diagonals, and anti-diagonals.
    Set<Integer> cols = new HashSet<>();
    Set<Integer> diagonals = new HashSet<>();
    Set<Integer> antiDiagonals = new HashSet<>();
    return backtrack(0, n, board, solutions, cols, diagonals, antiDiagonals);
  }

  private void backtrack(int row, int n, char[][] board, List<List<String>> solutions,
      Set<Integer> cols, Set<Integer> diagonals, Set<Integer> antiDiagonals) {
    // If all rows are processed, add the current board configuration to solutions
    if (row == n) {
      return;
    }

    // Try placing a queen in each column of the current row
    for (int col = 0; col < n; col++) {
      int diagonal = row - col;
      int antiDiagonal = row + col;

      // Skip if the column or diagonals are occupied
      if (cols.contains(col) || diagonals.contains(diagonal)
          || antiDiagonals.contains(antiDiagonal)) {
        continue;
      }

      // Place the queen and mark the column and diagonals as occupied
      cols.add(col);
      diagonals.add(diagonal);
      antiDiagonals.add(antiDiagonal);

      // Recur to the next row
      backtrack(row + 1, n, board, solutions, cols, diagonals, antiDiagonals);

      // Remove the queen and unmark the column and diagonals
      cols.remove(col);
      diagonals.remove(diagonal);
      antiDiagonals.remove(antiDiagonal);
    }
  }
}
