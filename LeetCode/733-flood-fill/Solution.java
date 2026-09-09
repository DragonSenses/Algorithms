/**
 * Performs a flood fill on a 2D image grid using Depth‑First Search (DFS).
 *
 * <p>
 * The algorithm recolors all pixels connected 4‑directionally to the starting pixel (sr, sc) that
 * share the same original color. DFS is used to traverse the connected region recursively.
 * </p>
 *
 * @param image the 2D grid of pixel colors
 * @param sr the starting row index
 * @param sc the starting column index
 * @param color the new color to apply
 * @return the modified image after flood fill
 */
class Solution {
  public int[][] floodFill(int[][] image, int sr, int sc, int color) {
    int original = image[sr][sc];
    if (original == color) {
      return image;
    }
    dfs(image, sr, sc, original, color);
    return image;
  }

  /**
   * Recursively fills all connected pixels that match the original color.
   *
   * <p>
   * This method checks bounds, verifies color match, recolors the pixel, and then recursively
   * explores the four adjacent neighbors: bottom, top, right, and left.
   * </p>
   *
   * @param image the 2D grid of pixel colors
   * @param r current row index
   * @param c current column index
   * @param original the original color to match
   * @param color the new color to apply
   */
  private void dfs(int[][] image, int r, int c, int original, int color) {
    int m = image.length;
    int n = image[0].length;

    // Out-of-bounds check
    if (r < 0 || r >= m) {
      return;
    }
    if (c < 0 || c >= n) {
      return;
    }

    // Color mismatch check
    if (image[r][c] != original) {
      return;
    }

    // Recolor current pixel
    image[r][c] = color;

    // Explore neighbors: bottom, top, right, left
    dfs(image, r + 1, c, original, color);
    dfs(image, r - 1, c, original, color);
    dfs(image, r, c + 1, original, color);
    dfs(image, r, c - 1, original, color);
  }
}
