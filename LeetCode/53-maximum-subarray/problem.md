# 53. Maximum Subarray

Given an integer array `nums`, find the subarray with the largest sum, and return *its sum*.

A subarray is a contiguous non-empty sequence of elements within an array.

#### Example 1:

Input: nums = [-2,1,-3,4,-1,2,1,-5,4]

Output: 6

Explanation: The subarray [4,-1,2,1] has the largest sum 6.

#### Example 2:

Input: nums = [1]

Output: 1

Explanation: The subarray [1] has the largest sum 1.

#### Example 3:

Input: nums = [5,4,-1,7,8]

Output: 23

Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.

#### Constraints:

    1 <= nums.length <= 105
    -104 <= nums[i] <= 104

**Follow up**: If you have figured out the `O(n)` solution, try coding another solution using the **divide and conquer** approach, which is more subtle.

# Solution

- [**Kadane's Algorithm**](#kadanes-algorithm)
  - Time complexity: `O(n)`

# Kadane's Algorithm

## **Overview**

1. **Dynamic Programming Consideration**:
   - When asked to find the maximum or minimum of something, consider using Dynamic Programming.

2. **Challenge in the Problem**:
   - The main difficulty is determining when a negative number should be included in a subarray.

3. **Kadane's Algorithm**:
   - This problem can be effectively solved using [Kadane's Algorithm](https://en.wikipedia.org/wiki/Maximum_subarray_problem#Kadane's_algorithm).
   - Kadane's Algorithm has a greedy-like intuition and is popular for solving maximum subarray problems.

4. **Problem-Solving Insight**:
   - If you are good at problem-solving, you might be able to derive the algorithm on your own.

## **Intuition**

Let's focus on one important part: where the optimal subarray **begins**. We'll use the following example.

`nums = [-2, 1, -3, 4, -1, 2, 1, -5, 4]`

We can see that the optimal subarray couldn't possibly involve the first 3 values - the overall sum of those numbers would always *subtract* from the total. Therefore, the subarray either starts at the first `4`, or somewhere further to the
right.

What if we had this example though?

`nums = [-2,1000000000,-3,4,-1,2,1,-5, 4]`

We need a general way to figure out when a part of the array is **worth** keeping.

As expected, any subarray whose sum is *positive* is worth keeping. Let's start with an empty array, and iterate through the input, adding numbers to our array as we go along. Whenever the sum of the array is negative, we know the entire array is not worth keeping, so we'll reset it back to an empty array.

However, we don't actually need to build the subarray, we can just keep an integer variable `current_subarray` and add the values of each element there. When it becomes negative, we reset it to 0 (an empty array).

### Recap

To determine where the optimal subarray begins, analyze the array to exclude initial elements that reduce the total sum. 

For example, in `nums = [-2, 1, -3, 4, -1, 2, 1, -5, 4]`, the optimal subarray starts at the first `4` or later. 

A general approach is to keep any subarray with a positive sum. Iterate through the array, adding elements to a running sum (`current_subarray`).

If the sum becomes negative, reset it to 0. This method avoids the need to build the subarray explicitly, simplifying the implementation.

### Key Points

1. **Optimal Subarray Start**:
   - Identify where the optimal subarray begins by examining the array elements.

2. **Example Analysis**:
   - For `nums = [-2, 1, -3, 4, -1, 2, 1, -5, 4]`, the optimal subarray cannot include the first three values as they reduce the total sum. Thus, the subarray starts at the first `4` or later.

3. **General Approach**:
   - Determine when a part of the array is worth keeping by checking if its sum is positive.

4. **Iterative Process**:
   - Start with an empty array and iterate through the input, adding numbers to the subarray.
   - If the subarray sum becomes negative, reset it to an empty array.

5. **Simplified Implementation**:
   - Instead of building the subarray, use an integer variable `current_subarray` to keep track of the sum.
   - Reset `current_subarray` to 0 whenever it becomes negative.

## **Algorithm**

1. **Initialization**:
   - Initialize two integer variables, both set to the first value in the array:
     - `currentSubarray`: Keeps the running sum of the current subarray.
     - `maxSubarray`: Stores the maximum sum found so far and will be the final return value.

2. **Iteration**:
   - Start iterating through the array from the second element (since the first element is used for initialization).
   - For each number:
     - Add it to `currentSubarray`.
     - If `currentSubarray` becomes negative, reset it to 0 (discard the current subarray).
     - Update `maxSubarray` if `currentSubarray` exceeds the current `maxSubarray`.

## **Complexity Analysis**

Let `n` be the size of array `nums`.

**Time complexity**: `O(n)`
  - *Single Pass:* We iterate through every element of `nums` exactly once.

**Space complexity**: `O(1)`
  - No matter how long the input is, we are only ever using 2 variables: `currentSubarray` and `maxSubarray`

## **Implementation**

A clever way to update `currentSubarray` is using `currentSubarray = max(num, currentSubarray + num)`. 

If `currentSubarray` is negative, then `num > currentSubarray + num`.

**Edge Case**: When the array contains only a single element, special handling is required. Starting the loop at the first element would result in adding the element to itself, which is incorrect. Instead, we should initialize our variables with the first element and begin the loop from the second element to avoid this issue.

This approach ensures that the algorithm correctly handles arrays with a single element without producing an incorrect maximum sum.

### Java

```java
class Solution {
  public int maxSubArray(int[] nums) {
    // Initialize variables using the first element
    int currentSubarray = nums[0];
    int maxSubarray = nums[0];

    // Iterate through the array starting from the second element
    for (int i = 1; i < nums.length; i++) {
      // If current subarray is negative, discard it (set it to 0)
      // Otherwise, keep adding to current subarray
      currentSubarray = Math.max(nums[i], currentSubarray + nums[i]);
      maxSubarray = Math.max(currentSubarray, maxSubarray);
    }

    return maxSubarray;
  }
}
```

### TypeScript

```typescript
/**
 * Finds the maximum sum of a contiguous subarray in the given array.
 *
 * @param nums the input array of integers
 * @return the maximum sum of a contiguous subarray
 */
function maxSubArray(nums: number[]): number {
  // Initialize variables using the first element
  let currentSubarray = nums[0];
  let maxSubarray = nums[0];

  // Iterate through the array starting from the second element
  for (let i = 1; i < nums.length; i++) {
    // If current subarray is negative, discard it (set it to 0)
    // Otherwise, keep adding to current subarray
    currentSubarray = Math.max(nums[i], currentSubarray + nums[i]);
    maxSubarray = Math.max(currentSubarray, maxSubarray);
  }

  return maxSubarray;
}
```