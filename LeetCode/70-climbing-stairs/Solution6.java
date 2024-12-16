public class Solution6 {

  public int climbStairs(int n) {
    int[][] q = {{1, 1}, {1, 0}};
    int[][] res = matrixPower(q, n);
    return res[0][0];
  }


  private int[][] matrixPower(int[][] a, int n) {
    int[][] result = {{1, 0}, {0, 1}}; // Identity matrix
    while (n > 0) {
      if ((n & 1) == 1) {
        result = multiplyMatrices(result, a);
      }
      n >>= 1;
      a = multiplyMatrices(a, a);
    }
    return result;
  }


  private int[][] multiplyMatrices(int[][] a, int[][] b) {
    int[][] c = new int[2][2];
    for (int i = 0; i < 2; i++) {
      for (int j = 0; j < 2; j++) {
        c[i][j] = a[i][0] * b[0][j] + a[i][1] * b[1][j];
      }
    }
    return c;
  }
}
