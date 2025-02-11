function merge(intervals: number[][]): number[][] {
  if (intervals.length === 0) return [];

  // Step 1: Sort the intervals based on their start value
  intervals.sort((a, b) => a[0] - b[0]);

  // Step 2: Initialize a list to hold the merged intervals
  const merged: number[][] = [];

  // Step 3: Iterate through the sorted intervals
  for (const interval of intervals) {
    // If the list of merged intervals is empty or the current interval does not overlap with the previous one
    if (merged.length === 0 || merged[merged.length - 1][1] < interval[0]) {
      // Append the current interval to the merged list
      merged.push(interval);
    } else {
      // Merge the current interval with the last merged interval
      merged[merged.length - 1][1] = Math.max(
        merged[merged.length - 1][1],
        interval[1]
      );
    }
  }

  return merged;
};
