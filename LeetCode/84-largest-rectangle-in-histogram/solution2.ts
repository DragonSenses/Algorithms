function largestRectangleArea(heights: number[]): number {
  let maxArea = 0;
  let n = heights.length;

  // Iterate over all possible starting bars
  for (let i = 0; i < n; i++) {
    let minHeight = heights[i];

    // Expand the rectangle by iterating over possible ending bars
    for (let j = i; j < n; j++) {
      // Maintain minimum height in range
      minHeight = Math.min(minHeight, heights[j]); 

      let width = j - i + 1; // Calculate width

      // Compute and track maximum area
      maxArea = Math.max(maxArea, minHeight * width); 
    }
  }
  
  return maxArea;
};
