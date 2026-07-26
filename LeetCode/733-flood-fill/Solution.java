class Solution {
  public int[][] floodFill(int[][] image, int sr, int sc, int color) {
    int original = image[sr][sc];
    if (original == color) {
      return image;
    }
    return null;
  }

  private void dfs(int[][] image, int r, int c, int original, int color) {

  }
}
