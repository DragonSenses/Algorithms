import java.util.Stack;

/**
 * Computes the largest rectangle area in a histogram using a monotonic stack.
 *
 * This approach efficiently tracks histogram bar boundaries by maintaining 
 * a monotonic increasing stack. It processes each bar in O(n) time, 
 * ensuring optimal performance compared to brute force solutions.
 *
 * @param heights An array representing the histogram's bar heights, where each bar has a width of 1.
 * @return The area of the largest possible rectangle within the histogram.
 */
class Solution {
  public int largestRectangleArea(int[] heights) {
    Stack<Integer> stack = new Stack<>(); // Monotonic increasing stack to store indices
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
