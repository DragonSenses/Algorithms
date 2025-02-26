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

    return 0;
  }
}
