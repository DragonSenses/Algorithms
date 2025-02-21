import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Solution class to solve the N-Queens problem using backtracking.
 */
class Solution {

  /**
   * Solves the N-Queens problem and returns all possible solutions.
   *
   * @param n the size of the board (n x n)
   * @return a list of all possible solutions, where each solution is represented as a list of
   *         strings
   */
  public List<List<String>> solveNQueens(int n) {
    List<List<String>> solutions = new ArrayList<>();
    Set<Integer> cols = new HashSet<>();
    Set<Integer> diagonals = new HashSet<>();
    Set<Integer> antiDiagonals = new HashSet<>();
    char[][] board = createEmptyBoard(n);
    backtrack(0, n, board, solutions, cols, diagonals, antiDiagonals);
    return solutions;
  }

  /**
   * Backtracking helper function to find all solutions.
   *
   * @param row the current row being processed
   * @param n the size of the board (n x n)
   * @param board the current state of the board
   * @param solutions the list of solutions found so far
   * @param cols the set of columns that are occupied
   * @param diagonals the set of diagonals that are occupied
   * @param antiDiagonals the set of anti-diagonals that are occupied
   */
  private void backtrack(int row, int n, char[][] board, List<List<String>> solutions,
      Set<Integer> cols, Set<Integer> diagonals, Set<Integer> antiDiagonals) {
    // If all rows are processed, add the current board configuration to solutions
    if (row == n) {
      solutions.add(formatBoard(board));
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
      placeQueen(board, row, col);
      cols.add(col);
      diagonals.add(diagonal);
      antiDiagonals.add(antiDiagonal);

      // Recur to the next row
      backtrack(row + 1, n, board, solutions, cols, diagonals, antiDiagonals);

      // Remove the queen and unmark the column and diagonals
      removeQueen(board, row, col);
      cols.remove(col);
      diagonals.remove(diagonal);
      antiDiagonals.remove(antiDiagonal);
    }
  }

  /**
   * Creates an empty n x n board.
   *
   * @param n the size of the board
   * @return a 2D array representing the empty board
   */
  private char[][] createEmptyBoard(int n) {
    char[][] board = new char[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        board[i][j] = '.';
      }
    }
    return board;
  }

  /**
   * Places a queen on the board at the specified position.
   *
   * @param board the current state of the board
   * @param row the row index
   * @param col the column index
   */
  private void placeQueen(char[][] board, int row, int col) {
    board[row][col] = 'Q';
  }

  /**
   * Removes a queen from the board at the specified position.
   *
   * @param board the current state of the board
   * @param row the row index
   * @param col the column index
   */
  private void removeQueen(char[][] board, int row, int col) {
    board[row][col] = '.';
  }

  /**
   * Converts the board into a list of strings for the final solution format.
   *
   * @param board the current state of the board
   * @return a list of strings representing the board configuration
   */
  private List<String> formatBoard(char[][] board) {
    List<String> formattedBoard = new ArrayList<>();
    for (int i = 0; i < board.length; i++) {
      formattedBoard.add(new String(board[i]));
    }
    return formattedBoard;
  }
}
