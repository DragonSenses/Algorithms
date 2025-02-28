/**
 * Solves the N-Queens problem and returns the total number of solutions.
 * @param n - The size of the chessboard (n x n) and the number of queens.
 * @returns The total number of distinct solutions for placing n queens.
 */
function totalNQueens(n: number): number {
  // Set to keep track of columns, diagonals, and anti-diagonals.
  const cols = new Set<number>();
  const diagonals = new Set<number>();
  const antiDiagonals = new Set<number>();

  return backtrack(0, n, cols, diagonals, antiDiagonals);

  /**
   * Backtracks to find all valid solutions for placing queens.
   * @param row - The current row to place a queen on.
   * @param n - The size of the chessboard (n x n).
   * @param cols - A set of column indices already occupied by queens.
   * @param diagonals - A set of diagonal indices already occupied by queens.
   * @param antiDiagonals - A set of anti-diagonal indices already occupied by queens.
   * @returns The number of valid solutions for this configuration.
   */
  function backtrack(
    row: number,
    n: number,
    cols: Set<number>,
    diagonals: Set<number>,
    antiDiagonals: Set<number>
  ): number {
    // 1. Base Case: If we've placed all queens, we found a solution.
    if (row === n) {
      return 1;
    }

    // 2. Initialize Solutions Count.
    let solutions = 0;

    // 3. Iterate Through Columns.
    for (let col = 0; col < n; col++) {
      const diagonal = row - col;
      const antiDiagonal = row + col;

      // 4. Check Valid Placement.
      if (
        cols.has(col) ||
        diagonals.has(diagonal) ||
        antiDiagonals.has(antiDiagonal)
      ) {
        continue; // Can't place queen here, move to next column.
      }

      // 5. Place the Queen.
      cols.add(col);
      diagonals.add(diagonal);
      antiDiagonals.add(antiDiagonal);

      // 6. Recursive Call: Move to the next row with updated state.
      solutions += backtrack(row + 1, n, cols, diagonals, antiDiagonals);

      // 7. Backtrack: Remove the queen and revert changes.
      cols.delete(col);
      diagonals.delete(diagonal);
      antiDiagonals.delete(antiDiagonal);
    }

    return solutions;
  }
}
