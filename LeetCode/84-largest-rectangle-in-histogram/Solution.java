class Solution {
  public int largestRectangleArea(int[] heights) {
    int maxArea = 0;
    int n = heights.length;

    // Iterate over all possible starting bars
    for (int i = 0; i < n; i++) {
      for (int j = i; j < n; j++) {
        int minHeight = Integer.MAX_VALUE; // Start with maximum possible value

        // Find the minimum height within the range [i, j]
        for (int k = i; k <= j; k++) {
          minHeight = Math.min(minHeight, heights[k]);
        }

        // Compute the rectangle's area and update maxArea
        int width = j - i + 1;
        maxArea = Math.max(maxArea, minHeight * width);
      }
    }

    return maxArea;
  }
}
