/**
 * Greedy algorithm to determine the minimum number of jumps
 * needed to reach the end of the array.
 *
 * @param {number[]} nums - Array of non-negative integers where each 
 * element represents the maximum jump length from that position.
 * @returns {number} - The minimum number of jumps required to reach the end.
 */
function jump(nums: number[]): number {
  // End of the current jump range
  let curEnd = 0; 
  
  // Farthest index reachable from the current range
  let curFar = 0; 
  
  // Number of jumps
  let jumps = 0; 

  for (let i = 0; i < nums.length - 1; i++) {
    // Update the farthest reach
    curFar = Math.max(curFar, i + nums[i]); 

    if (i === curEnd) {
      // End of the current jump range
      jumps++; 
      
      // Move to the next jump range
      curEnd = curFar; 

      // If we can reach or exceed the last index, break
      if (curEnd >= nums.length - 1) {
        break;
      }
    }
  }

  return jumps;
}
