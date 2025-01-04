function exist(board: string[][], word: string): boolean {
  const ROWS = board.length;
  const COLS = board[0].length;

  function backtrack(row: number, col: number, index: number): boolean {
    // Step 1: Check the bottom case
    if (index >= word.length) {
      return true;
    }

    // Step 2: Check the boundaries
    if (
      row < 0 ||
      row >= ROWS ||
      col < 0 ||
      col >= COLS ||
      board[row][col] !== word[index]
    ) {
      return false;
    }

    // Step 3: Mark the current cell as visited
    const temp = board[row][col];
    board[row][col] = "#";

    // Explore the four possible directions: up, down, left, right
    const rowOffsets = [0, 1, 0, -1];
    const colOffsets = [1, 0, -1, 0];
    for (let d = 0; d < 4; ++d) {
      if (backtrack(row + rowOffsets[d], col + colOffsets[d], index + 1)) {
        return true;
      }
    }

    // Step 4: Revert the current cell to its original state
    board[row][col] = temp;

    return false;
  }

  // Iterate through each cell in the board
  for (let row = 0; row < ROWS; ++row) {
    for (let col = 0; col < COLS; ++col) {
      if (backtrack(row, col, 0)) {
        return true;
      }
    }
  }

  return false;
};
