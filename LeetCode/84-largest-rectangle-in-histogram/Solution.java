import java.util.Stack;

class Solution {
  public int largestRectangleArea(int[] heights) {
    Stack<Integer> stack = new Stack<>();
    int maxArea = 0;
    int n = heights.length;

    for (int i = 0; i < n; i++) {
      // Use 0 height for the imaginary right boundary
      int currentHeight = (i == n) ? 0 : heights[i];

      // Pop elements while the current bar is shorter than stack top
      while (!stack.isEmpty() && currentHeight < heights[stack.peek()]) {
        int h = heights[stack.pop()]; // Pop the top height
        int width = stack.isEmpty() ? i : (i - stack.peek() - 1); // Compute width
        maxArea = Math.max(maxArea, h * width);
      }

      stack.push(i); // Push current index onto the stack
    }

    return maxArea;
  }
}
