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

For this problem we will solve it with these approaches:
  - **Merge Sort**
  - **Binary Search**

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

