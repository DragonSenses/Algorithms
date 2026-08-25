import java.util.ArrayDeque;
import java.util.Queue;

class Solution2 {
  public int[][] floodFill(int[][] image, int sr, int sc, int color) {
    int original = image[sr][sc];
    if (original == color) {
      return image;
    }

    int m = image.length;
    int n = image[0].length;

    Queue<int[]> queue = new ArrayDeque<>();
    queue.add(new int[] {sr, sc});
    image[sr][sc] = color;

    while (!queue.isEmpty()) {
      int[] cell = queue.remove();
      int r = cell[0];
      int c = cell[1];

      int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

      for (int[] d : dirs) {
        int nr = r + d[0];
        int nc = c + d[1];

        if (nr < 0 || nr >= m) {
          continue;
        }

      }
    }

  }
}
