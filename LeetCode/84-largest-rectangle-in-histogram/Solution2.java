/**
 * Brute Force Approach to find the largest rectangle in a histogram.
 * 
 * This method iterates through all possible pairs of bars, dynamically tracking the minimum height
 * while expanding the rectangle. The approach runs in O(n²) time complexity, making it inefficient
 * for large histograms.
 *
 * @param heights An array representing the histogram's bar heights, where width of each bar is 1.
 * @return The area of the largest possible rectangle within the histogram.
 */
public class Solution2 {
  public int largestRectangleArea(int[] heights) {
    int maxArea = 0;
    int n = heights.length;

    // Iterate over all possible starting bars
    for (int i = 0; i < n; i++) {
      int minHeight = heights[i]; // Track min height dynamically

      // Expand the rectangle by iterating over possible ending bars
      for (int j = i; j < n; j++) {
        minHeight = Math.min(minHeight, heights[j]); // Maintain minimum height in range

        // Compute the rectangle's area and update maxArea
        int width = j - i + 1;
        maxArea = Math.max(maxArea, minHeight * width);
      }
    }

    return maxArea;
  }
}
