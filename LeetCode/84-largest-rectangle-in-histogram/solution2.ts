/**
 * Brute Force Approach to find the largest rectangle in a histogram.
 *
 * This method iterates through all possible pairs of bars,
 * dynamically tracking the minimum height while expanding the rectangle.
 * The approach runs in `O(n²)` time complexity, making it inefficient for large histograms.
 *
 * @param {number[]} heights - An array representing the histogram's bar heights, where each bar has a width of 1.
 * @returns {number} The area of the largest possible rectangle within the histogram.
 */
function largestRectangleArea(heights: number[]): number {
  let maxArea = 0;
  let n = heights.length;

  // Iterate over all possible starting bars
  for (let i = 0; i < n; i++) {
    let minHeight = heights[i]; // Track minHeight dynamically

    // Expand the rectangle by iterating over possible ending bars
    for (let j = i; j < n; j++) {
      minHeight = Math.min(minHeight, heights[j]); // Maintain minimum height in range

      let width = j - i + 1; // Compute width
      maxArea = Math.max(maxArea, minHeight * width); // Track max area
    }
  }

  return maxArea;
};
