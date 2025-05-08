/**
 * Searches for a target value in a rotated sorted array.
 * 
 * @param nums The rotated sorted array of distinct integers.
 * @param target The target number to search for.
 * @return Index of the target if found, otherwise -1.
 */
class Solution {
  public int search(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;

    // 1. Find Pivot Index (Smallest Element)
    // The pivot index represents the transition between two sorted subarrays.
    // Using binary search, we locate the smallest element (rotation point).
    while (left < right) {
      int mid = left + (right - left) / 2; // Prevents potential overflow
      if (nums[mid] > nums[right]) {
        left = mid + 1; // Pivot is in the right half
      } else {
        right = mid; // Pivot is in the left half
      }
    }

    int pivotIndex = left; // Pivot index found

    // 2. Determine Search Bounds
    // Decide which half of the array to perform binary search on.
    // If the target is within the sorted right portion, adjust left.
    left = 0;
    right = nums.length - 1;
    if (target >= nums[pivotIndex] && target <= nums[right]) {
      left = pivotIndex; // Target is in the right sorted portion
    } else {
      right = pivotIndex - 1; // Target is in the left sorted portion
    }

    // 3. Perform Binary Search in the Selected Half
    while (left <= right) {
      int mid = left + (right - left) / 2; // Prevent overflow in large arrays
      if (nums[mid] == target) {
        return mid; // Target found
      } else if (nums[mid] < target) {
        left = mid + 1; // Move right
      } else {
        right = mid - 1; // Move left
      }
    }

    return -1; // Target not found
  }
}
