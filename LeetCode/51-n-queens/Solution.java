import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
  public List<List<String>> solveNQueens(int n) {
    List<List<String>> solutions = new ArrayList<>();
    Set<Integer> cols = new HashSet<>();
    Set<Integer> diagonals = new HashSet<>();
    Set<Integer> antiDiagonals = new HashSet<>();
    char[][] board = createEmptyBoard(n);
    backtrack(0, n, board, solutions, cols, diagonals, antiDiagonals);
    return solutions;
  }

  private void backtrack(int row, int n, char[][] board, List<List<String>> solutions, Set<Integer> cols, Set<Integer> diagonals, Set<Integer> antiDiagonals) {
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

      backtrack(row + 1, n, board, solutions, cols, diagonals, antiDiagonals);

      removeQueen(board, row, col);
      cols.remove(col);
      diagonals.remove(diagonal);
      antiDiagonals.remove(antiDiagonal);
    }
  }

  private char[][] createEmptyBoard(int n) {
    char[][] board = new char[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        board[i][j] = '.';
      }
    }
    return board;
  }

  private void placeQueen(char[][] board, int row, int col) {
    board[row][col] = 'Q';
  }

  private void removeQueen(char[][] board, int row, int col) {
    board[row][col] = '.';
  }

  private List<String> formatBoard(char[][] board) {
    List<String> formattedBoard = new ArrayList<>();
    for (int i = 0; i < board.length; i++) {
      formattedBoard.add(new String(board[i]));
    }
    return formattedBoard;
  }
}