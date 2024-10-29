/**
 * Finds all possible subsets of the given integer array using a cascading 
 * iterative approach.
 *
 * @param {number[]} nums - An array of unique integers.
 * @returns {number[][]} A list of all possible subsets.
 */
function subsets(nums: number[]): number[][] {
  const output: number[][] = [];
  output.push([]); // Start with the empty subset

  for (const num of nums) {
    const currentSize = output.length;
    for (let i = 0; i < currentSize; i++) {
      const newSubset = output[i].slice(); // Create a new subset from an existing subset
      newSubset.push(num); // Add the current number to the new subset
      output.push(newSubset); // Add the new subset to the output list
    }
  }

  return output;
};
