# 16. 3Sum Closest

<p>Given an integer array <code>nums</code> of length <code>n</code> and an integer <code>target</code>, find three integers in <code>nums</code> such that the sum is closest to <code>target</code>.</p>

<p>Return <em>the sum of the three integers</em>.</p>

<p>You may assume that each input would have exactly one solution.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> nums = [-1,2,1,-4], target = 1
<strong>Output:</strong> 2
<strong>Explanation:</strong> The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> nums = [0,0,0], target = 1
<strong>Output:</strong> 0
<strong>Explanation:</strong> The sum that is closest to the target is 0. (0 + 0 + 0 = 0).
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>3 &lt;= nums.length &lt;= 500</code></li>
	<li><code>-1000 &lt;= nums[i] &lt;= 1000</code></li>
	<li><code>-10<sup>4</sup> &lt;= target &lt;= 10<sup>4</sup></code></li>
</ul>

<br>

---

# Solution
- [Two Pointers](#two-pointers)
  - **Time Complexity**: `O(n^2)`

## Overview

The 3Sum Closest problem is a variation of the 3Sum problem. Unlike 3Sum, the goal here is not to find triplets that sum up to a target value but to find triplets whose sum is closest to the target. This problem bears some resemblance to the 3Sum Smaller variant.

### Related Problems and Solutions

#### 3Sum

3Sum involves fixing one number and using either the two pointers pattern or a hash set to find complementary pairs. This results in a time complexity of `O(n^2)`.

#### 3Sum Smaller

3Sum Smaller, similar to 3Sum, employs the two pointers pattern to enumerate smaller pairs. However, a hash set is not used here due to the absence of a specific value to search for.

### Approach to 3Sum Closest

For the same reason as in 3Sum Smaller, we can't use a hash set in 3Sum Closest because there is no specific value to search for. Thus, our focus will be on utilizing the two pointers pattern, targeting an `O(n^2)` time complexity as the best conceivable runtime (BCR).

# Two Pointers

Let's solve 3Sum Cloest using the two pointers pattern.

## **Intuition**

The two pointers pattern requires the array to be sorted, so we do that first. As our BCR is `O(n^2)`, the sort operation would not change the overall time complexity.

In the sorted array, we process each value from left to right. For value `v`, we need to find a pair which sum, ideally, is equal to `target - v` . We will follow the same two pointers approach as for 3Sum, however, since this 'ideal' pair may not exist, we will track the smallest absolute difference between the sum and the target. The two pointers approach naturally enumerates pairs so that the sum moves toward the target.

### Step-by-Step Strategy

1. **Sorting the Array**:
   - We will follow the two-pointer pattern as in Two Sum II, which requires the array to be sorted.
   - Sorting the array first ensures that our overall time complexity remains O(n²), as sorting is O(n log n).

2. **Handling Duplicates**:
   - To ensure the result contains unique triplets, we need to skip duplicate values.
   - This is straightforward because duplicate values are adjacent in a sorted array.

### Detailed Explanation

1. **Pivot Element and Pair Finding**:
   - After sorting the array, we move our pivot element `nums[i]` and analyze elements to its right.
   - We find all pairs whose sum equals `-nums[i]` using the two-pointer pattern, ensuring the sum of the pivot element (`nums[i]`) and the pair (`-nums[i]`) equals zero.

2. **Two-Pointer Technique Refresher**:
   - Initially, set the pointers to the first and last elements respectively.
   - Compare the sum of these two elements to the target:
     - If the sum is smaller, increment the lower pointer `lo`.
     - If the sum is larger, decrement the higher pointer `hi`.
   - This ensures the sum always moves toward the target, pruning pairs that would move it further away.
   - This technique works effectively only if the array is sorted. For a detailed explanation, refer to the Two Sum II solution.

By following these steps, you can efficiently solve the 3Sum problem while ensuring unique triplets and maintaining optimal time complexity.

## **Algorithm**

### Step 1: Initialize
1. **Initialize the minimum difference `diff` with a large value**:
   - This will help keep track of the smallest difference found.

### Step 2: Sort the Input Array
2. **Sort the input array `nums`**:
   - Sorting the array will facilitate the two-pointer approach.

### Step 3: Iterate Through the Array
3. **Iterate through the array**:
   - For the current position `i`, set `lo` to `i + 1` and `hi` to the last index.
   - While the `lo` pointer is smaller than `hi`:
     1. Calculate `sum` as `nums[i] + nums[lo] + nums[hi]`.
     2. If the absolute difference between `sum` and `target` is smaller than the absolute value of `diff`:
        - Update `diff` to `target - sum`.
     3. If `sum` is less than `target`, increment `lo`.
     4. Else, decrement `hi`.
     5. If `diff` is zero, break from the loop as we have found the closest possible sum.

### Step 4: Return the Result
4. **Return the value of the closest triplet**:
   - The closest triplet sum is `target - diff`.

