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

    return solutions;
  }
}
