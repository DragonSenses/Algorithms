/**
 * Finds the majority element in an array of integers.
 * The majority element is defined as the element that appears more than ⌊n / 2⌋ times.
 *
 * Approach:
 * - Use a Map to track the frequency of each element.
 * - As soon as an element's count exceeds the threshold (n / 2), return it.
 * - The problem guarantees that a majority element always exists.
 *
 * @param nums - The input array of integers
 * @returns The majority element
 */
function majorityElement(nums: number[]): number {
  // Map to store frequency counts of each number
  const frequencyMap = new Map<number, number>();

  // Threshold for majority element (appears more than n/2 times)
  const threshold = Math.floor(nums.length / 2);

  // Iterate through each number in the array
  for (const num of nums) {
    // Increment count for current number (default to 0 if not present)
    const count = (frequencyMap.get(num) || 0) + 1;

    // Update the map with the new count
    frequencyMap.set(num, count);

    // If count exceeds threshold, return immediately
    if (count > threshold) {
      return num;
    }
  }

  // This line should never be reached due to problem guarantees
  return -1;
}
