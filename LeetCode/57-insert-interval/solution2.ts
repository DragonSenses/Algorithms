/**
 * Inserts a new interval into a list of non-overlapping intervals, merging overlapping intervals if necessary.
 */
function insert(intervals: number[][], newInterval: number[]): number[][] {
  const result: number[][] = [];
  let i = 0;
  const n = intervals.length;

  // Step 1: Insert all intervals before newInterval
  while (i < n && intervals[i][1] < newInterval[0]) {
    result.push(intervals[i]);
    i++;
  }

  // Step 2: Merge newInterval with overlapping intervals
  while (i < n && intervals[i][0] <= newInterval[1]) {
    newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
    newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
    i++;
  }
  result.push(newInterval); // Add the merged interval

  // Step 3: Add remaining intervals after newInterval
  while (i < n) {
    result.push(intervals[i]);
    i++;
  }

  return result;
}
