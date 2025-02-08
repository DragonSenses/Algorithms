function generateMatrix(n: number): number[][] {
  const matrix: number[][] = Array.from({ length: n }, () => Array(n).fill(0));
  let num = 1;
  let row = 0,
    col = 0;
  const dir = [
    [0, 1], // Right
    [1, 0], // Down
    [0, -1], // Left
    [-1, 0], // Up
  ];
  let d = 0; // Initial direction is 'right'

  while (num <= n * n) {
    matrix[row][col] = num++;
    let nextRow = row + dir[d][0];
    let nextCol = col + dir[d][1];

    if (
      nextRow < 0 ||
      nextRow >= n ||
      nextCol < 0 ||
      nextCol >= n ||
      matrix[nextRow][nextCol] !== 0
    ) {
      d = (d + 1) % 4; // Change direction
      nextRow = row + dir[d][0];
      nextCol = col + dir[d][1];
    }

    row = nextRow;
    col = nextCol;
  }

  return matrix;
}
