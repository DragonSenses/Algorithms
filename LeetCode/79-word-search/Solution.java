/**
 * Solution class that implements the word search problem using backtracking.
 */
class Solution {
  private char[][] board;
  private int ROWS;
  private int COLS;

  /**
   * Determines if the word exists in the given board.
   * 
   * @param board the 2D grid of characters
   * @param word the word to be searched in the grid
   * @return true if the word exists in the grid, false otherwise
   */
  public boolean exist(char[][] board, String word) {
    this.board = board;
    this.ROWS = board.length;
    this.COLS = board[0].length;

    // Iterate through each cell in the grid
    for (int row = 0; row < this.ROWS; ++row) {
      for (int col = 0; col < this.COLS; ++col) {
        // Invoke backtracking function to check if the word can be found starting from this cell
        if (this.backtrack(row, col, word, 0)) {
          return true;
        }
      }
    }
    return false;
  }

  /**
   * Recursive backtracking function to search for the word in the grid.
   * 
   * @param row the current row index
   * @param col the current column index
   * @param word the word to be searched
   * @param index the current index of the character in the word
   * @return true if the word can be found starting from the current cell, false otherwise
   */
  protected boolean backtrack(int row, int col, String word, int index) {
    // Step 1: Check the bottom case. If we have found the match for each prefix of the word
    if (index >= word.length()) {
      return true;
    }

    // Step 2: Check the boundaries and character match
    if (row < 0 || row == this.ROWS || col < 0 || col == this.COLS
        || this.board[row][col] != word.charAt(index)) {
      return false;
    }

    // Step 3: Explore the backtracking with the DFS strategy
    // Mark the current cell as visited
    char temp = this.board[row][col];
    this.board[row][col] = '#';

    // Explore the four possible directions: up, down, left, right
    int[] rowOffsets = {1, -1, 0, 0};
    int[] colOffsets = {0, 0, 1, -1};
    boolean result = false;
    for (int d = 0; d < 4; ++d) {
      result = this.backtrack(row + rowOffsets[d], col + colOffsets[d], word, index + 1);
      if (result) {
        break;
      }
    }

    // Step 4: Revert the cell back to its original state
    this.board[row][col] = temp;

    return result;
  }
}
