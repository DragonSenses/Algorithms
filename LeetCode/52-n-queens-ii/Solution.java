import java.util.HashSet;
import java.util.Set;

public class Solution {

  /**
   * Solves the N-Queens problem and returns the total number of solutions.
   *
   * @param n The size of the chessboard (n x n) and the number of queens.
   * @return The total number of distinct solutions for placing n queens.
   */
  public int totalNQueens(int n) {
    // Set to keep track of columns, diagonals, and anti-diagonals.
    Set<Integer> cols = new HashSet<>();
    Set<Integer> diagonals = new HashSet<>();
    Set<Integer> antiDiagonals = new HashSet<>();

    return backtrack(0, n, cols, diagonals, antiDiagonals);
  }

  /**
   * Backtracks to find all valid solutions for placing queens.
   *
   * @param row The current row to place a queen on.
   * @param n The size of the chessboard (n x n).
   * @param cols A set of column indices already occupied by queens.
   * @param diagonals A set of diagonal indices already occupied by queens.
   * @param antiDiagonals A set of anti-diagonal indices already occupied by queens.
   * @return The number of valid solutions for this configuration.
   */
  private int backtrack(int row, int n, Set<Integer> cols, Set<Integer> diagonals,
      Set<Integer> antiDiagonals) {
    // 1. Base Case: If we've placed all queens, we found a solution.
    if (row == n) {
      return 1;
    }

    // 2. Initialize Solutions Count.
    int solutions = 0;

    // 3. Iterate Through Columns.
    for (int col = 0; col < n; col++) {
      int diagonal = row - col;
      int antiDiagonal = row + col;

      // 4. Check Valid Placement.
      if (cols.contains(col) || diagonals.contains(diagonal)
          || antiDiagonals.contains(antiDiagonal)) {
        continue; // Can't place queen here, move to next column.
      }

      // 5. Place the Queen.
      cols.add(col);
      diagonals.add(diagonal);
      antiDiagonals.add(antiDiagonal);

      // 6. Recursive Call: Move to the next row with updated state.
      solutions += backtrack(row + 1, n, cols, diagonals, antiDiagonals);

      // 7. Backtrack: Remove the queen and revert changes.
      cols.remove(col);
      diagonals.remove(diagonal);
      antiDiagonals.remove(antiDiagonal);
    }

    return solutions;
  }
}
