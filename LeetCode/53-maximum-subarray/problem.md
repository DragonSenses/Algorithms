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
- [**Divide and Conquer**](#divide-and-conquer)
  - Time complexity: `O(n*log(n))`

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

# Divide and Conquer

## **Intuition**

This approach is slower than the second approach and uses more space, but it's still a nice and different way to approach the problem. In an interview, sometimes you may be asked for alternative ways to solve a problem, and divide and conquer is an extremely common type of algorithm. This solution will make use of recursion.

### Key Points

1. **Divide and Conquer**:
   - Split the input into smaller chunks until they're small enough to be easily solved.
   - Combine the solutions to get the final overall solution.

2. **Optimal Subarray**:
   - If we split the input in half, the optimal subarray either:
     - Uses elements only from the left side.
     - Uses elements only from the right side.
     - Uses a combination of elements from both the left and right sides.

3. **Solution**:
   - The answer is the largest of:
     - The maximum subarray contained only in the left side.
     - The maximum subarray contained only in the right side.
     - The maximum subarray that can use elements from both sides.

4. **Finding the Maximum Subarray**:
   - Finding the maximum subarray from the left and right halves is straightforward: recurse using the respective half of the array.
   - The hard part is finding the best subarray that uses elements from both sides.

### Example

Consider the array `nums = [5, -2, 1, -3, 4, -2, 1]`. Since we want to use elements from both sides, we must use the middle element `-3`. We can also take elements from the left and the right, but every element must be connected to the middle (since we're still forming a subarray).

### Simplification

The fact that every element must be connected to the middle makes our task easier. Every subarray we consider **must** contain the element immediately beside the center, which means there are only as many subarrays as there are elements. In our example, the right side is `[4, -2, 1]`. There are only 3 subarrays to consider: `[4]`, `[4, -2]`, and `[4, -2, 1]`. To find the best chain of elements we can take from a half, iterate from the middle to the end (or start of the array for the left half) and continuously update a counter `curr`.

## **Algorithm**

Now that we know how to find the best subarray containing elements from both sides of any given array, the algorithm is as follows:

1. **Define an Auxiliary Function (for recursion)**:
   - This function will take inputs `left` and `right`, which define the bounds of the array.
   - The return value of this function will be the best possible subarray for the array that fits between `left` and `right`.

2. **Base Case**:
   - If `left > right`, we have an empty array. Return negative infinity.

3. **Find the Midpoint**:
   - Calculate the midpoint of the array: `(left + right) / 2`, rounded down.
   - Using this midpoint, find the best possible subarray that uses elements from both sides of the array.

4. **Recursive Calls**:
   - The best subarray using elements from both sides is only one of three possibilities. We still need to find the best subarray using only the left or right halves.
   - Call the auxiliary function recursively for the left half and the right half.

5. **Combine Results**:
   - Return the largest of the three values: the best left half sum, the best right half sum, and the best combined sum.

6. **Final Call**:
   - Call the auxiliary function with the entire input array (`left = 0`, `right = length - 1`).
   - This is our final answer, so return it.

## **Implementation**

Given the algorithm, our implementation should follow these steps:

1. **Midpoint Element**: Start with the element at the midpoint, `nums[mid]`.
2. **Left Sum**: Calculate the maximum sum of the subarray that ends at the midpoint by iterating from the midpoint to the left.
3. **Right Sum**: Calculate the maximum sum of the subarray that starts at the midpoint by iterating from the midpoint to the right.
4. **Combine**: The `maxCrossingSum` is the sum of the midpoint element, the maximum left sum, and the maximum right sum.

#### Note: maxCrossingSum

The name `maxCrossingSum` comes from the concept of finding the maximum sum of a subarray that crosses the midpoint in the divide and conquer approach. Here's a bit more detail:

- **Divide and Conquer**: This algorithm splits the array into two halves, recursively finds the maximum subarray sum in each half, and then combines the results.
- **Crossing Sum**: When combining the results, we need to consider subarrays that span both halves. The `maxCrossingSum` specifically refers to the maximum sum of such a subarray that crosses the midpoint.

The term "crossing" is used because this sum includes elements from both the left and right halves of the array, crossing over the midpoint. This is essential to ensure that we don't miss any potential maximum subarray that spans the midpoint.

### Java

```java
/**
 * This class provides a solution to the Maximum Subarray problem using the divide and conquer approach.
 */
public class Solution {
  /**
   * Finds the maximum subarray sum.
   *
   * @param nums the input array
   * @return the maximum subarray sum
   */
  public int maxSubArray(int[] nums) {
    // Call the helper function with the entire array
    return maxSubArrayHelper(nums, 0, nums.length - 1);
  }

  /**
   * Helper function to find the maximum subarray sum using divide and conquer.
   *
   * @param nums  the input array
   * @param left  the left boundary of the current subarray
   * @param right the right boundary of the current subarray
   * @return the maximum subarray sum within the boundaries
   */
  private int maxSubArrayHelper(int[] nums, int left, int right) {
    // Base case: if the subarray is invalid, return the smallest possible integer value
    if (left > right) {
      return Integer.MIN_VALUE;
    }

    // Find the midpoint of the current subarray
    int mid = left + (right - left) / 2;

    // Recursively find the maximum subarray sum in the left half
    int leftMax = maxSubArrayHelper(nums, left, mid - 1);

    // Recursively find the maximum subarray sum in the right half
    int rightMax = maxSubArrayHelper(nums, mid + 1, right);

    // Calculate the maximum sum of the subarray that crosses the midpoint
    int leftSum = 0, rightSum = 0;
    int maxLeftSum = 0, maxRightSum = 0;

    // Calculate the maximum sum of the subarray ending at the midpoint
    for (int i = mid - 1; i >= left; i--) {
      leftSum += nums[i];
      maxLeftSum = Math.max(maxLeftSum, leftSum);
    }

    // Calculate the maximum sum of the subarray starting at the midpoint
    for (int i = mid + 1; i <= right; i++) {
      rightSum += nums[i];
      maxRightSum = Math.max(maxRightSum, rightSum);
    }

    // Combine the sums to get the maximum crossing sum
    int maxCrossingSum = nums[mid] + maxLeftSum + maxRightSum;

    // Return the maximum of the three possible sums
    return Math.max(maxCrossingSum, Math.max(leftMax, rightMax));
  }
}
```

