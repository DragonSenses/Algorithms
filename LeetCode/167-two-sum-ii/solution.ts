/**
 * Finds two numbers in a sorted array that add up to a specific target.
 *
 * @param numbers the sorted array of integers
 * @param target the target sum
 * @return an array containing the 1-based indices of the two numbers
 */
function twoSum(numbers: number[], target: number): number[] {
  let left = 0;
  let right = numbers.length - 1;

  while (left < right) {
    let sum = numbers[left] + numbers[right];

    if (sum == target) {
      // Return 1-base indices
      return [left + 1, right + 1];
    } else if (sum < target) {
      left++;
    } else {
      right--;
    }
  }
  
  // If problem has NO solution, return negative indices
  return [-1, -1];
}
