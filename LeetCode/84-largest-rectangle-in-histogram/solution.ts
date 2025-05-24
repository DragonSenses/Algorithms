/**
 * Computes the largest rectangle area in a histogram using a monotonic stack.
 *
 * This approach efficiently tracks histogram bar boundaries by maintaining
 * a monotonic increasing stack. It processes each bar in O(n) time,
 * ensuring optimal performance compared to brute force solutions.
 *
 * @param {number[]} heights - An array representing the histogram's bar heights, where each bar has a width of 1.
 * @returns {number} The area of the largest possible rectangle within the histogram.
 */
function largestRectangleArea(heights: number[]): number {
  const stack: number[] = []; // Monotonic increasing stack to store indices
  let maxArea = 0;
  const n = heights.length;

  for (let i = 0; i <= n; i++) {
    // Assign 0 height beyond the histogram for final cleanup
    const currentHeight = i === n ? 0 : heights[i];

    // Process stack while current bar is shorter than stack top
    while (
      stack.length > 0 &&
      currentHeight < heights[stack[stack.length - 1]]
    ) {
      const h = heights[stack.pop()!]; // Pop the top index and get the corresponding height
      const width = stack.length === 0 ? i : i - stack[stack.length - 1] - 1; // Compute width
      maxArea = Math.max(maxArea, h * width); // Update max area
    }

    stack.push(i); // Push current index onto the stack
  }

  return maxArea;
}
