# Median of Two Sorted Arrays

Given two sorted arrays `nums1` and `nums2` of size `m` and `n` respectively, return **the median** of the two sorted arrays.

The overall run time complexity should be `O(log (m+n))`.

#### Example 1:

Input: nums1 = [1,3], nums2 = [2]

Output: 2.00000

Explanation: merged array = [1,2,3] and median is 2.

#### Example 2:

Input: nums1 = [1,2], nums2 = [3,4]

Output: 2.50000

Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.

#### Constraints:

    nums1.length == m
    nums2.length == n
    0 <= m <= 1000
    0 <= n <= 1000
    1 <= m + n <= 2000
    -10^6 <= nums1[i], nums2[i] <= 10^6

# Solution

For this problem we will solve it with these approaches:
  - [**Merge Sort**](#merge-sort)
    - Time complexity: `O(m + n)`
  - [**Binary Search**](#binary-search-recursive)
    - Time complexity: `O(log(m * n))`

## Overview

In this problem, we are given two **sorted** arrays, `nums1` and `nums2`. We need to return the median of these two arrays.

We can glean additional information by looking at the expected run time: `O(log (m+n))`. This means our approach must be done by `log(m+n)` time, which strongly suggests that our approach should use a logarithmic algorithm.

 - Notice that merging two sorted arrays together in the worst case is `O(m+n)` which violates the constraint.

1. **What is a Logarithm?**
   - A logarithm is the power to which a base needs to be raised to reach a given number. For example, if a^c = b, then c is the logarithm of b to the base a.
   - Logarithms are commonly used in scientific formulae, such as pH measurements in chemistry and complexity analysis of algorithms.

2. **Logarithmic time complexity** is denoted as O(log n), where n represents the input size. It measures how the runtime of an algorithm scales as the input size increases.

3. **Examples of Logarithmic Algorithms:**
   - **Binary Search**: A classic example of O(log n) complexity. It efficiently finds an element in a sorted array by repeatedly dividing the search space in half.
   - **Merge Sort**: A sorting algorithm with O(n log n) complexity. It divides the array into smaller subarrays, sorts them, and then merges them back together.
   - **Heap Sort**: Another sorting algorithm with O(n log n) complexity. It uses a binary heap data structure to sort elements.

## Merge Sort

Assume we merged and sorted both arrays into array `A`, with a length of `n`, then the median is:
  - `A[n/2]`, if `n` is odd
  - The average of `A[n/2]` and `A[n/(2+1)]`, if `n` is even

However, there is no need to merge and sort the two arrays `nums1` and `nums2`.
  - Both arrays are **already sorted**
  - The smallest element is either the first element of `nums1` OR first element of `nums2`

Therefore, we can set two pointers `p1` and `p2` at the start of each array, then get the smallest element from them by comparing the values `nums[p1]` and `nums[p2]`.

### Algorithm

1. Get the total size of two arrays `m + n`
   - If `m + n` is odd, we are looking for the `(m + n) / 2`-th element.
   - If `m + n` is even, we are looking for the average of the `(m + n) / 2`-th and the `(m + n) / 2 + 1`-th elements.

2. Set two pointers `p1` and `p2` at the beginning of arrays `nums1` and `nums2`.

3. If both `p1` and `p2` are in bounds of the arrays, compare the values at `p1` and `p2`:
      - If `nums1[p1]` is smaller than `nums2[p2]`, we move `p1` one place to the right.
      - Otherwise, we move `p2` one place to the right.

    If `p1` is outside `nums1`, just move `p2` one place to the right.
    If `p2` is outside `nums2`, just move `p1` one place to the right.

4. Get the target elements and calculate the median:
      - If `m + n` is odd, repeat step 3 by `(m + n + 1) / 2` times and return the element from the last step.
      - If `m + n` is even, repeat step 3 by `(m + n) / 2 + 1` times and return the average of the elements from the last two steps.

### Complexity Analysis

Let `m` be the size of array `nums1` and `n` be the size of array `nums2`.

  - Time complexity: `O(m+n)`
    - We get the smallest element by comparing two values at `p1` and `p2`, it takes `O(1)` to compare two elements and move the corresponding pointer to the right.
    - We need to traverse half of the arrays before reaching the median element(s).
    - To sum up, the time complexity is `O(m+n)`.

  - Space complexity: `O(1)`
    - We only need to maintain two pointers `p1` and `p2`.

### Implementation

  - Note: When checking whether we have an even-lengthed array when combining the two sorted number arrays we can use the following conditionals:
    - `if (totalSize % 2 == 0)`
      - Easier to understand at a glance
    - `if (totalSize & 1) == 0)`
      - `&` bitwise AND operator checks the binary representations of `totalSize` and `1`
      - Checks if the least significant bit is `0`
        - If the result is `0`, it means `totalSize` is **even**
        - If the result is `1`, it means `totalSize` is **odd**
      - Performance-wise one of the fastest ways to check for evenness

#### Java

```java
class Solution {
  // Initialize two private pointers set to 0
  private int p1 = 0, p2 = 0;

  /**
   * Retrieves the next smallest value between two sorted number arrays and advances the pointers.
   *
   * @param nums1 First sorted number array.
   * @param nums2 Second sorted number array.
   * @return The smallest value between the two arrays.
   */
  private int getMin(int[] nums1, int[] nums2) {
    // If both arrays have elements remaining, compare and return the smaller value.
    if (p1 < nums1.length && p2 < nums2.length) {
      return nums1[p1] < nums2[p2] ? nums1[p1++] : nums2[p2++];
    } else if (p1 < nums1.length) {
      // If only nums1 has elements remaining, return the value from nums1.
      return nums1[p1++];
    } else if (p2 < nums2.length) {
      // If only nums2 has elements remaining, return the value from nums2.
      return nums2[p2++];
    }
    // If both arrays are exhausted, return -1
    return -1;
  }

  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int totalSize = nums1.length + nums2.length;

    if ((totalSize & 1) == 0) {
      // Even-length case: Calculate the average of the two middle elements
      // Using 0-based indexing, the two middle elements are at indices
      // (totalSize / 2) - 1 and totalSize / 2.
      for (int i = 0; i < (totalSize / 2) - 1; i++){
        // Advance pointers by (totalSize / 2) - 1 to reach the two middle elements.
        int tmp = getMin(nums1, nums2);
      }
      // Return the average of the two middle elements
      return (double) (getMin(nums1, nums2) + getMin(nums1, nums2)) /2;
    } else {
      // Odd-length case: Return the exact middle element.
      for (int i = 0; i < totalSize / 2; i++) {
        // Advance pointers until we reach just before the middle element
        int tmp = getMin(nums1, nums2);
      }
      return getMin(nums1, nums2);
    }
  }
}
```

#### TypeScript

```typescript
function findMedianSortedArrays(nums1: number[], nums2: number[]): number {
  // Initialize two pointers set to 0
  let p1 = 0;
  let p2 = 0;

  const m = nums1.length,
        n = nums2.length;

  const totalSize = m + n;

  /**
   * Retrieves the next smallest value between two sorted number arrays and advances the pointers.
   *
   * @param nums1 First sorted number array.
   * @param nums2 Second sorted number array.
   * @returns The smallest value between the two arrays.
   */
  function getMin(nums1: number[], nums2: number[]): number {
    // If both arrays have elements remaining, compare and return the smaller value.
    if (p1 < m && p2 < n) {
      return nums1[p1] < nums2[p2] ? nums1[p1++] : nums2[p2++];
    } else if (p1 < m) {
      // If only nums1 has elements remaining, return the value from nums1.
      return nums1[p1++];
    } else if (p2 < n) {
      // If only nums2 has elements remaining, return the value from nums2.
      return nums2[p2++];
    }
    // If both arrays are exhausted, return -1.
    return -1;
  }

  if ((totalSize & 1) === 0) {
    // Even-length case: Calculate the average of the two middle elements.
    // Using 0-based indexing, the two middle elements are at indices
    // (totalSize / 2) - 1 and totalSize / 2.
    for (let i = 0; i < totalSize / 2 - 1; i++) {
      // Advance pointers by (totalSize / 2) - 1 to reach the two middle elements.
      getMin(nums1, nums2);
    }
    // Return the average of the two middle elements.
    return (getMin(nums1, nums2) + getMin(nums1, nums2)) / 2;
  } else {
    // Odd-length case: Return the exact middle element.
    for (let i = 0; i < Math.floor(totalSize / 2); i++) {
      // Advance pointers until we reach just before the middle element.
      getMin(nums1, nums2);
    }
    return getMin(nums1, nums2);
  }
}
```

## Binary Search, Recursive

<!-- TODO: Link to algorithm and Implementation here -->

### **Intuition**

1. **Problem Context:**
   - We are given two sorted arrays as input.
   - The problem requires finding the median of the combined (merged) array formed by these two arrays.

2. **Logarithmic Time Complexity:**
   - The problem statement emphasizes achieving a logarithmic time complexity.
   - Binary search is a promising approach because it typically operates in logarithmic time.

3. **Binary Search Overview:**
   - Binary search is a divide-and-conquer algorithm.
   - It works by repeatedly dividing the search space in half and narrowing down the search range.
   - It's commonly used for searching in sorted arrays.

4. **Steps of Regular Binary Search:**
   - Initialize pointers for the left and right boundaries of the search range.
   - While the left pointer is less than or equal to the right pointer:
     - Calculate the middle index.
     - Compare the middle element with the target value.
     - Adjust the search range based on the comparison result (move left or right).
   - Repeat until the target value is found or the search range is empty.

5. **Application to Median Problem:**
   - We can adapt binary search to find the correct position for the median in the merged array.
   - The median position depends on whether the total size of the merged array is even or odd.

#### **Binary Search Walkthrough**

Let's walkthrough a regular binary search to get inspiration to solve our problem.

Here we use binary search to find `target` in a sorted array `A`:

  - Locate the middle index (element) of `A`.

  - Compare the value of the middle element with `target`.

  - Reduce the search space by cutting the current array in half and discarding the half which is guaranteed not to contain `target`.

  - Repeat the above process until we either empty the array (move to half a the length of 0) or find `target`.

![](img/1.png)

**Listing 4-1:** A binary search for `target = 26` in sorted array `A`.

- In Listing 4-1, we can see an array that contains `2` in `A[0]` and `50` in `A[15]`.
  - The first step is to look for `target`, `26`
  - Next compare the middle value of `A` with `26`
    - The middle value is `9`
  - Since `9 < 26`, we safely discard the left half of `A` 
    - because the array is sorted and the target `26` will not be found in the left half with **lesser** values.
  - Search for `26` in right half of `A`
  - Compare the middle value of `A*` (right half of A) with `26`
    - Middle value of `A*` is `18`
  - And so forth until target is found 
- `26` is located in `A[13]`

