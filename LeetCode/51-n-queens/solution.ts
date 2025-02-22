function solveNQueens(n: number): string[][] {
  const solutions: string[][] = [];
  const cols: Set<number> = new Set();
  const diagonals: Set<number> = new Set();
  const antiDiagonals: Set<number> = new Set();
  const board: string[][] = createEmptyBoard(n);
  backtrack(0, n, board, solutions, cols, diagonals, antiDiagonals);
  return solutions;
}

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

    if (
      cols.has(col) ||
      diagonals.has(diagonal) ||
      antiDiagonals.has(antiDiagonal)
    ) {
      continue;
    }

    placeQueen(board, row, col);
    cols.add(col);
    diagonals.add(diagonal);
    antiDiagonals.add(antiDiagonal);

    backtrack(row + 1, n, board, solutions, cols, diagonals, antiDiagonals);

    removeQueen(board, row, col);
    cols.delete(col);
    diagonals.delete(diagonal);
    antiDiagonals.delete(antiDiagonal);
  }
}

function createEmptyBoard(n: number): string[][] {
  const board: string[][] = new Array(n)
    .fill(".")
    .map(() => new Array(n).fill("."));
  return board;
}

function placeQueen(board: string[][], row: number, col: number): void {
  board[row][col] = "Q";
}

function removeQueen(board: string[][], row: number, col: number): void {
  board[row][col] = ".";
}

function formatBoard(board: string[][]): string[] {
  return board.map((row) => row.join(""));
}
