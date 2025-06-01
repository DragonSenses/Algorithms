/**
 * Implements the monotonic stack optimized approach for the Maximal Rectangle problem.
 *
 * Uses an increasing stack to compute the largest rectangle area efficiently.
 * Processes the matrix row-wise, treating each row as a histogram.
 */
function maximalRectangle(matrix: string[][]): number {
  if (matrix.length === 0) {
    return 0;
  }

  const m = matrix[0].length;
  let maxArea = 0;
  const heights: number[] = new Array(m).fill(0); // Column heights

  // Iterate over each row, treating it as a histogram
  for (const row of matrix) {
    // Update histogram heights
    for (let j = 0; j < m; j++) {
      heights[j] = row[j] === "1" ? heights[j] + 1 : 0;
    }
    // Compute largest rectangle in histogram using monotonic stack
    maxArea = Math.max(maxArea, largestRectangleArea(heights));
  }
  return maxArea;
}

/**
 * Computes the largest rectangle in histogram using a monotonic stack.
 *
 * @param heights Array representing histogram bar heights.
 * @return Maximum rectangular area found within the histogram.
 */
function largestRectangleArea(heights: number[]): number {
  const stack: number[] = []; // Monotonic increasing stack
  let maxArea = 0;
  const n = heights.length;

  for (let i = 0; i <= n; i++) {
    // Assign 0 height to ensure final stack cleanup
    const h = i === n ? 0 : heights[i];

    // Process stored heights while the current bar is shorter
    while (stack.length > 0 && h < heights[stack[stack.length - 1]]) {
      const height = heights[stack.pop()!]; // Height of the popped bar

      // Compute width based on remaining stack indices
      const width = stack.length === 0 ? i : i - stack[stack.length - 1] - 1;

      // Update maxArea with the largest found so far
      maxArea = Math.max(maxArea, height * width);
    }

    // Store current index for future width calculations
    stack.push(i);
  }

  // Return the maximum rectangular area found
  return maxArea;
}
