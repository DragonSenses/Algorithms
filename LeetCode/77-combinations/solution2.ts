/**
 * Generates all combinations of k numbers out of the range [1, n] in lexicographic order.
 *
 * @param n - The upper limit of the range.
 * @param k - The number of elements in each combination.
 * @returns A list of all possible combinations.
 */
function combine(n: number, k: number): number[][] {
  const output: number[][] = []; // List to store all combinations
  const nums: number[] = new Array(k + 1); // Array to store the current combination and sentinel

  // Initialize the nums array with the first k elements and a sentinel value
  for (let i = 0; i < k; i++) {
    nums[i] = i + 1;
  }
  nums[k] = n + 1; // Sentinel value to mark the end

  let j = 0; // Pointer to traverse the nums array

  // Generate combinations in lexicographic order
  while (j < k) {
    // Collect the first k elements (excluding the sentinel) into a combination
    const combination: number[] = [];
    for (let i = 0; i < k; i++) {
      combination.push(nums[i]);
    }
    output.push(combination); // Add the combination to the output list

    // Find the first number in nums that can be incremented
    j = 0;
    while (j < k && nums[j] + 1 === nums[j + 1]) {
      nums[j] = j + 1; // Reset the current number to its smallest possible value
      j++;
    }
    nums[j]++; // Increment the number to move to the next combination
  }

  return output;
};
