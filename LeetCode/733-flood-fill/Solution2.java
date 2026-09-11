import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Performs a flood fill on a 2D image grid using Breadth‑First Search (BFS).
 *
 * <p>
 * The algorithm recolors all pixels connected 4‑directionally to the starting pixel (sr, sc) that
 * share the same original color. BFS is used to traverse the connected region iteratively,
 * expanding outward in level‑order until no more matching pixels remain.
 * </p>
 *
 * @param image the 2D grid of pixel colors
 * @param sr the starting row index
 * @param sc the starting column index
 * @param color the new color to apply
 * @return the modified image after flood fill
 */
class Solution2 {
  public int[][] floodFill(int[][] image, int sr, int sc, int color) {
    int original = image[sr][sc];
    if (original == color) {
      return image;
    }

    int m = image.length;
    int n = image[0].length;

    // Initialize BFS queue with starting pixel
    Queue<int[]> queue = new ArrayDeque<>();
    queue.add(new int[] {sr, sc});
    image[sr][sc] = color;

    // BFS expansion loop
    while (!queue.isEmpty()) {
      int[] cell = queue.remove();
      int r = cell[0];
      int c = cell[1];

      // Four-directional neighbors: bottom, top, right, left
      int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

      for (int[] d : dirs) {
        int nr = r + d[0];
        int nc = c + d[1];

        // Bounds checks
        if (nr < 0 || nr >= m) {
          continue;
        }
        if (nc < 0 || nc >= n) {
          continue;
        }

        // Color mismatch check
        if (image[nr][nc] != original) {
          continue;
        }

        // Recolor and enqueue neighbor
        image[nr][nc] = color;
        queue.add(new int[] {nr, nc});
      }
    }

    return image;
  }
}
