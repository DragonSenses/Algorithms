import java.util.Stack;

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
    Stack<Integer> stack = new Stack<>();
    int maxArea = 0;
    int n = heights.length;

    for (int i = 0; i <= n; i++) {
      int h = (i == n) ? 0 : heights[i];
      while (!stack.isEmpty() && h < heights[stack.peek()]) {
        int height = heights[stack.pop()];
        int width = stack.isEmpty() ? i : i - stack.peek() - 1;
        maxArea = Math.max(maxArea, height * width);
      }
      stack.push(i);
    }
    return maxArea;
  }
}
