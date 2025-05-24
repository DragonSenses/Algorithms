function largestRectangleArea(heights: number[]): number {
  const stack: number[] = []; // Monotonic increasing stack to store indices
  let maxArea = 0;
  const n = heights.length;

  for (let i = 0; i <= n; i++) {
    // Assign 0 height beyond the histogram for final cleanup
    const currentHeight = i === n ? 0 : heights[i];

    // Push indices onto the stack as long as bars are increasing in height
    while (
      stack.length > 0 &&
      currentHeight < heights[stack[stack.length - 1]]
    ) {}
  }

  return maxArea;
}
