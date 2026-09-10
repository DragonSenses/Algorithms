/**
 * Performs a flood fill on a 2D image grid using Depth‑First Search (DFS).
 *
 * Recolors all pixels connected 4‑directionally to the starting pixel (sr, sc)
 * that share the same original color. DFS is used to recursively traverse the
 * connected region until no more matching pixels remain.
 *
 * @param image The 2D grid of pixel colors.
 * @param sr Starting row index.
 * @param sc Starting column index.
 * @param color The new color to apply to the connected region.
 * @returns The modified image after flood fill.
 */
function floodFill(
  image: number[][],
  sr: number,
  sc: number,
  color: number
): number[][] {
  const original = image[sr][sc];
  if (original === color) {
    return image;
  }

  /**
   * Recursively fills all connected pixels that match the original color.
   *
   * Checks bounds, verifies color match, recolors the pixel, and then explores
   * the four adjacent neighbors: bottom, top, right, and left.
   *
   * @param r Current row index.
   * @param c Current column index.
   */
  function dfs(r: number, c: number): void {
    const m = image.length;
    const n = image[0].length;

    // Out-of-bounds checks
    if (r < 0 || r >= m) {
      return;
    }
    if (c < 0 || c >= n) {
      return;
    }

    // Color mismatch check
    if (image[r][c] !== original) {
      return;
    }

    // Recolor current pixel
    image[r][c] = color;

    // Explore neighbors: bottom, top, right, left
    dfs(r + 1, c);
    dfs(r - 1, c);
    dfs(r, c + 1);
    dfs(r, c - 1);
  }

  dfs(sr, sc);
  return image;
};