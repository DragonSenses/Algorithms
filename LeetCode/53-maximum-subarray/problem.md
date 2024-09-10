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

