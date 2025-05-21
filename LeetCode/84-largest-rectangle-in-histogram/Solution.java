class Solution {
  public int largestRectangleArea(int[] heights) {
    int maxArea = 0;
    int n = heights.length;

    // Iterate over all possible starting bars
    for (int i = 0; i < n; i++) {
      int minHeight = heights[i];

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
