class Solution {
  public int[][] floodFill(int[][] image, int sr, int sc, int color) {
    int original = image[sr][sc];
    if (original == color) {
      return image;
    }
    dfs(image, sr, sc, original, color);
    return null;
  }

  private void dfs(int[][] image, int r, int c, int original, int color) {
    int m = image.length;
    int n = image[0].length;

    if (r < 0 || r >= m) {
      return;
    }
    if (c < 0 || c >= n) {
      return;
    }
    if (image[r][c] != original) {
      return;
    }

  }
}
