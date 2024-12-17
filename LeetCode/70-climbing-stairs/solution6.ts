/**
 * Function to calculate the number of ways to climb stairs using matrix exponentiation.
 *
 * @param n - The total number of steps to reach the top.
 * @returns The number of distinct ways to reach the top.
 */
function climbStairs(n: number): number {
  const q = [[1, 1], [1, 0]];
  const res = matrixPower(q, n);
  return res[0][0];
}

/**
 * Function to raise a 2x2 matrix to the power n using exponentiation by squaring.
 *
 * @param a - The matrix to be raised to the power.
 * @param n - The exponent.
 * @returns The resultant matrix after exponentiation.
 */
function matrixPower(a: number[][], n: number): number[][] {
  let result = [[1, 0], [0, 1]]; // Identity matrix
  while (n > 0) {
    if (n & 1) {
      result = multiplyMatrices(result, a);
    }
    n >>= 1;
    a = multiplyMatrices(a, a);
  }
  return result;
}

/**
 * Function to multiply two 2x2 matrices.
 *
 * @param a - The first matrix.
 * @param b - The second matrix.
 * @returns The resultant matrix after multiplication.
 */
function multiplyMatrices(a: number[][], b: number[][]): number[][] {
  const c = [[0, 0], [0, 0]];
  for (let i = 0; i < 2; i++) {
    for (let j = 0; j < 2; j++) {
      c[i][j] = a[i][0] * b[0][j] + a[i][1] * b[1][j];
    }
  }
  return c;
}