import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {

  // Main method to solve N-Queens problem
  public List<List<String>> solveNQueens(int n) {
    List<List<String>> solutions = new ArrayList<>(); // List to store all valid solutions
    Set<Integer> cols = new HashSet<>(); // Set to track columns with queens
    Set<Integer> diagonals = new HashSet<>(); // Set to track diagonals with queens
    Set<Integer> antiDiagonals = new HashSet<>(); // Set to track anti-diagonals with queens
    char[][] board = createEmptyBoard(n); // Create an empty board
    backtrack(0, n, board, solutions, cols, diagonals, antiDiagonals); // Start backtracking
    return solutions;
  }

  // Recursive method to place queens on the board
  private void backtrack(int row, int n, char[][] board, List<List<String>> solutions,
      Set<Integer> cols, Set<Integer> diagonals, Set<Integer> antiDiagonals) {
    // If we reach a row equal to n, a valid solution is found
    if (row == n) {
      solutions.add(formatBoard(board)); // Add the board to the list of solutions
      return;
    }

    // Iterate through each column in the current row
    for (int col = 0; col < n; col++) {
      int diagonal = row - col; // Calculate diagonal index
      int antiDiagonal = row + col; // Calculate anti-diagonal index

      // Check if placing a queen at (row, col) conflicts with existing queens
      if (cols.contains(col) || diagonals.contains(diagonal)
          || antiDiagonals.contains(antiDiagonal)) {
        continue; // Skip to next column if there's a conflict
      }

      // Place the queen on the board
      placeQueen(board, row, col);
      cols.add(col); // Add column to set
      diagonals.add(diagonal); // Add diagonal to set
      antiDiagonals.add(antiDiagonal); // Add anti-diagonal to set

      // Recursively call backtrack for the next row
      backtrack(row + 1, n, board, solutions, cols, diagonals, antiDiagonals);

      // Remove the queen and backtrack
      removeQueen(board, row, col);
      cols.remove(col); // Remove column from set
      diagonals.remove(diagonal); // Remove diagonal from set
      antiDiagonals.remove(antiDiagonal); // Remove anti-diagonal from set
    }
  }

  // Helper method to create an empty board
  private char[][] createEmptyBoard(int n) {
    char[][] board = new char[n][n]; // Create n x n board
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        board[i][j] = '.'; // Initialize all cells with '.'
      }
    }
    return board;
  }

  // Helper method to place a queen on the board
  private void placeQueen(char[][] board, int row, int col) {
    board[row][col] = 'Q'; // Place 'Q' to represent a queen
  }

  // Helper method to remove a queen from the board
  private void removeQueen(char[][] board, int row, int col) {
    board[row][col] = '.'; // Replace 'Q' with '.' to remove the queen
  }

  // Helper method to format the board as a list of strings
  private List<String> formatBoard(char[][] board) {
    List<String> formattedBoard = new ArrayList<>();
    for (int i = 0; i < board.length; i++) {
      formattedBoard.add(new String(board[i])); // Convert each row to a string and add to the list
    }
    return formattedBoard;
  }
}
