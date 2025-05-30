import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Implements the monotonic stack approach to solve the Maximal Rectangle problem.
 * 
 * This method treats each row of the matrix as a histogram and leverages the "Largest Rectangle in
 * Histogram" technique using a monotonic increasing stack.
 * 
 * Instead of checking all possible rectangles explicitly, the algorithm efficiently tracks column
 * heights and applies a stack-based method to compute the largest area.
 * 
 * Time Complexity: O(n * m), where n = rows and m = columns. Space Complexity: O(m), using a
 * heights array and a stack.
 */
class Solution {
  /**
   * Computes the maximal rectangle containing only '1's in a binary matrix. Uses a monotonic stack
   * to optimize histogram-based area calculations.
   * 
   * @param matrix A binary matrix of '0's and '1's.
   * @return The area of the largest rectangle consisting only of '1's.
   */
  public int maximalRectangle(char[][] matrix) {
    if (matrix.length == 0) {
      return 0;
    }
    
    int m = matrix[0].length;
    int[] heights = new int[m]; // Column heights for histogram representation
    int maxArea = 0;

    // Process each row as a histogram
    for (char[] row : matrix) {
      // Update histogram heights
      for (int j = 0; j < m; j++) {
        heights[j] = (row[j] == '1') ? heights[j] + 1 : 0;
      }
      // Compute largest rectangle in histogram using monotonic stack
      maxArea = Math.max(maxArea, largestRectangleArea(heights));
    }
    return maxArea;
  }

  /**
   * Computes the largest rectangle in a histogram using a monotonic stack.
   * 
   * @param heights Array representing histogram bar heights.
   * @return Maximum rectangular area found within the histogram.
   */
  private int largestRectangleArea(int[] heights) {
    Deque<Integer> stack = new ArrayDeque<>(); // Monotonic increasing stack to store indices
    int maxArea = 0;
    int n = heights.length;

    // Traverse histogram, treating heights as bars
    for (int i = 0; i <= n; i++) {
      int currentHeight = (i == n) ? 0 : heights[i];

      // Maintain increasing stack order, compute max area when smaller height encountered
      while (!stack.isEmpty() && currentHeight < heights[stack.peek()]) {
        int height = heights[stack.pop()]; // Pop the top height
        int width = stack.isEmpty() ? i : i - stack.peek() - 1; // Compute width
        maxArea = Math.max(maxArea, height * width);
      }
      stack.push(i); // Push current index onto the stack for future area calculations
    }
    return maxArea;
  }
}
