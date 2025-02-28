function totalNQueens(n: number): number {
  // Set to keep track of columns, diagonals, and anti-diagonals.
  const cols = new Set<number>();
  const diagonals = new Set<number>();
  const antiDiagonals = new Set<number>();

  return backtrack(0, n, cols, diagonals, antiDiagonals);

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

    }

    return solutions;
  }
}
