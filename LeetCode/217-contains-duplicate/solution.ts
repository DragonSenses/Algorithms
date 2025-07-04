/**
 * Determines whether the input array contains any duplicate numbers.
 *
 * Uses a `Set` to keep track of values seen so far while iterating.
 * Returns `true` if a duplicate is found, otherwise `false`.
 *
 * @param nums - An array of integers to check for duplicates.
 * @returns `true` if any number appears more than once, `false` otherwise.
 *
 * @example
 * containsDuplicate([1, 2, 3, 1]); // returns true
 * containsDuplicate([1, 2, 3, 4]); // returns false
 */
function containsDuplicate(nums: number[]): boolean {
  const seen = new Set<number>();

  for (const num of nums) {
    if (seen.has(num)) {
      return true;
    }
    seen.add(num);
  }

  return false;
};