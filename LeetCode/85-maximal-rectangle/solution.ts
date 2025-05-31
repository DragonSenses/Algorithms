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

function largestRectangleArea(heights: number[]): number {
  const stack: number[] = []; // Monotonic increasing stack
  let maxArea = 0;
  const n = heights.length;

  for (let i = 0; i <= n; i++) {
    // Assign 0 height to ensure final stack cleanup
    const h = i === n ? 0 : heights[i];

    // Pop elements while the current height is smaller, ensuring all rectangles in the histogram are processed
    while (stack.length > 0 && h < heights[stack[stack.length - 1]]) {
      const height = heights[stack.pop()!];

      // Compute width based on remaining stack indices
      const width = stack.length === 0 ? i : i - stack[stack.length - 1] - 1;

      // Update maxArea with the largest found so far
      maxArea = Math.max(maxArea, height * width);
    }
  }
  // Return the maximum rectangular area found
  return maxArea;
}
