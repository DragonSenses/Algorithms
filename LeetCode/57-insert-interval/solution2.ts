/**
 * Inserts a new interval into a list of non-overlapping intervals, merging overlapping intervals if necessary.
 */
function insert(intervals: number[][], newInterval: number[]): number[][] {
  const result: number[][] = [];
  
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
  
  result.push(...intervals.slice(0, index), newInterval, ...intervals.slice(index));
  
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