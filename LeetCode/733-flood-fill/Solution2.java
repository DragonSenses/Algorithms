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
  }
}
