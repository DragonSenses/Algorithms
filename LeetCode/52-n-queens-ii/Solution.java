import java.util.HashSet;
import java.util.Set;

public class Solution {
  public int totalNQueens(int n) {
    // Set to keep track of columns, diagonals, and anti-diagonals.
    Set<Integer> cols = new HashSet<>();
    Set<Integer> diagonals = new HashSet<>();
    Set<Integer> antiDiagonals = new HashSet<>();

    return backtrack(0, n, cols, diagonals, antiDiagonals);
  }

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

    }

    return solutions;
  }
}
