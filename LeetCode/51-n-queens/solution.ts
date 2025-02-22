/**
 * Solves the N-Queens problem for a given board size.
 * @param {number} n - The size of the board (n x n).
 * @returns {string[][]} - A list of all possible solutions.
 */
function solveNQueens(n: number): string[][] {
  const solutions: string[][] = [];
  const cols: Set<number> = new Set();
  const diagonals: Set<number> = new Set();
  const antiDiagonals: Set<number> = new Set();
  const board: string[][] = createEmptyBoard(n);
  backtrack(0, n, board, solutions, cols, diagonals, antiDiagonals);
  return solutions;
}

/**
 * Backtracks to find all possible solutions for the N-Queens problem.
 * @param {number} row - The current row being explored.
 * @param {number} n - The size of the board.
 * @param {string[][]} board - The current state of the board.
 * @param {string[][]} solutions - The list of found solutions.
 * @param {Set<number>} cols - The set of used columns.
 * @param {Set<number>} diagonals - The set of used diagonals.
 * @param {Set<number>} antiDiagonals - The set of used anti-diagonals.
 */
function backtrack(
  row: number,
  n: number,
  board: string[][],
  solutions: string[][],
  cols: Set<number>,
  diagonals: Set<number>,
  antiDiagonals: Set<number>
): void {
  if (row === n) {
    solutions.push(formatBoard(board));
    return;
  }

  for (let col = 0; col < n; col++) {
    const diagonal = row - col;
    const antiDiagonal = row + col;

    // Check if the current position is under attack
    if (
      cols.has(col) ||
      diagonals.has(diagonal) ||
      antiDiagonals.has(antiDiagonal)
    ) {
      continue;
    }

    // Place the queen and mark the positions
    placeQueen(board, row, col);
    cols.add(col);
    diagonals.add(diagonal);
    antiDiagonals.add(antiDiagonal);

    // Recursively move to the next row
    backtrack(row + 1, n, board, solutions, cols, diagonals, antiDiagonals);

    // Remove the queen and unmark the positions
    removeQueen(board, row, col);
    cols.delete(col);
    diagonals.delete(diagonal);
    antiDiagonals.delete(antiDiagonal);
  }
}

/**
 * Creates an empty n x n chessboard.
 * @param {number} n - The size of the board.
 * @returns {string[][]} - An empty n x n board.
 */
function createEmptyBoard(n: number): string[][] {
  const board: string[][] = new Array(n)
    .fill(".")
    .map(() => new Array(n).fill("."));
  return board;
}

/**
 * Places a queen on the board at the specified position.
 * @param {string[][]} board - The current state of the board.
 * @param {number} row - The row position.
 * @param {number} col - The column position.
 */
function placeQueen(board: string[][], row: number, col: number): void {
  board[row][col] = "Q";
}

/**
 * Removes a queen from the board at the specified position.
 * @param {string[][]} board - The current state of the board.
 * @param {number} row - The row position.
 * @param {number} col - The column position.
 */
function removeQueen(board: string[][], row: number, col: number): void {
  board[row][col] = ".";
}

/**
 * Formats the board state into a list of strings.
 * @param {string[][]} board - The current state of the board.
 * @returns {string[]} - The formatted board state.
 */
function formatBoard(board: string[][]): string[] {
  return board.map((row) => row.join(""));
}
