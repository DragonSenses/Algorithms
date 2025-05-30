import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
  public int maximalRectangle(char[][] matrix) {
    if (matrix.length == 0) {
      return 0;
    }

    int n = matrix.length, m = matrix[0].length;
    int[] heights = new int[m]; // Histogram heights
    int maxArea = 0;

    for (char[] row : matrix) {
      // Update heights array
      for (int j = 0; j < m; j++) {
        heights[j] = (row[j] == '1') ? heights[j] + 1 : 0;
      }
    }

    return maxArea;
  }

  private int largestRectangleArea(int[] heights) {
    Deque<Integer> stack = new ArrayDeque<>(); // Monotonic increasing stack to store indices
    int maxArea = 0;
    int n = heights.length;

    for (int i = 0; i <= n; i++) {
      // Assign 0 height for the imaginary right boundary during final cleanup
      int currentHeight = (i == n) ? 0 : heights[i];

      // Pop elements while the current bar is shorter than stack top
      while (!stack.isEmpty() && currentHeight < heights[stack.peek()]) {
        int h = heights[stack.pop()]; // Pop the top height

        // Compute width using the index difference
        int width = stack.isEmpty() ? i : (i - stack.peek() - 1);
        maxArea = Math.max(maxArea, h * width);
      }

      stack.push(i); // Push current index onto the stack for future area calculations
    }

    return maxArea;
  }
}
