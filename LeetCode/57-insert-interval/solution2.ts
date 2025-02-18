/**
 * Inserts a new interval into a sorted list of non-overlapping intervals,
 * merging any overlapping intervals if necessary.
 *
 * @param {number[][]} intervals - A list of non-overlapping intervals sorted by start time.
 * @param {number[]} newInterval - The interval to be added to the list.
 * @returns {number[][]} - The resulting list of non-overlapping intervals after the insertion and merging.
 */
function insert(intervals: number[][], newInterval: number[]): number[][] {
  const result: number[][] = [];

  /**
   * Finds the insertion position for the new interval using binary search.
   * @param {number[][]} intervals - The list of intervals.
   * @param {number[]} newInterval - The interval to insert.
   * @returns {number} - The index at which to insert the new interval.
   */
  function findInsertPosition(intervals: number[][], newInterval: number[]): number {
    let low = 0;
    let high = intervals.length - 1;

    while (low <= high) {
      const mid = Math.floor(low + (high - low) / 2);
      if (intervals[mid][0] < newInterval[0]) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }

    return low;
  }

  const index = findInsertPosition(intervals, newInterval);

  // Step 1: Insert the new interval into the intervals list at the correct position
  result.push(...intervals.slice(0, index), newInterval, ...intervals.slice(index));

  // Step 2: Merge overlapping intervals
  const merged: number[][] = [];
  for (const interval of result) {
    if (merged.length === 0 || merged[merged.length - 1][1] < interval[0]) {
      merged.push(interval);
    } else {
      merged[merged.length - 1][1] = Math.max(merged[merged.length - 1][1], interval[1]);
    }
  }

  return merged;
}
