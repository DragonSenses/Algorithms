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
- [Binary Search Approach](#binary-search-approach)

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

## **Implementation**

### Java

```java
import java.util.Arrays;

class Solution {
  public int threeSumClosest(int[] nums, int target) {
    // Step 1: Initialize the minimum difference diff with a large value
    int diff = Integer.MAX_VALUE;

    // Step 2: Sort the input array nums
    Arrays.sort(nums);

    // Step 3: Iterate through the array
    for (int i = 0; i < nums.length - 2; i++) {
      int lo = i + 1;
      int hi = nums.length - 1;

      while (lo < hi) {
        int sum = nums[i] + nums[lo] + nums[hi];

        // If the absolute difference is smaller, update diff
        if (Math.abs(target - sum) < Math.abs(diff)) {
          diff = target - sum;
        }

        // Move pointers based on sum comparison to target
        if (sum < target) {
          lo++;
        } else {
          hi--;
        }

        // If diff is zero, closest sum found, break
        if (diff == 0) {
          break;
        }
      }
    }

    // Step 4: Return the value of the closest triplet sum
    return target - diff;
  }
}
```

### TypeScript

```typescript
function threeSumClosest(nums: number[], target: number): number {
  // Step 1: Initialize the minimum difference diff with a large value
  let diff = Number.MAX_SAFE_INTEGER;

  // Step 2: Sort the input array nums
  nums.sort((a, b) => a - b);

  // Step 3: Iterate through the array
  for (let i = 0; i < nums.length - 2; i++) {
    let lo = i + 1;
    let hi = nums.length - 1;

    while (lo < hi) {
      const sum = nums[i] + nums[lo] + nums[hi];

      // If the absolute difference is smaller, update diff
      if (Math.abs(target - sum) < Math.abs(diff)) {
        diff = target - sum;
      }

      // Move pointers based on sum comparison to target
      if (sum < target) {
        lo++;
      } else {
        hi--;
      }

      // If diff is zero, closest sum found, break
      if (diff === 0) {
        break;
      }
    }
  }

  // Step 4: Return the value of the closest triplet sum
  return target - diff;
}
```

## **Complexity Analysis**

Let \( n \) be the length of the input array.

### **Time Complexity**: \( O(n^2) \)

- **Outer and Inner Loops**: The outer loop iterates through `n` elements, and for each iteration, the inner loop also goes through `n` elements, resulting in a time complexity of \( O(n^2) \).
- **Sorting the Array**: Sorting the array with `Arrays.sort()` has a time complexity of \( O(n \log n) \).
- **Overall Complexity**: Combining these operations, the overall time complexity is dominated by the nested loops, giving us \( O(n \log n + n^2) \). As \( n^2 \) grows faster than \( n \log n \), the time complexity simplifies to \( O(n^2) \).

### **Space Complexity**: \( O(\log n) \) to \( O(n) \)

- **Sorting Algorithm**: The space complexity depends on the implementation of the sorting algorithm. As for the case with Java's `Arrays.sort()`, it depends on the type of elements being sorted:
  - **Primitive Types**: For sorting primitive types like `int`, `char`, `float`, etc., `Arrays.sort()` uses a dual-pivot Quicksort algorithm with a space complexity of \( O(\log n) \) due to the recursive nature of Quicksort.
  - **Object Types**: For sorting objects, `Arrays.sort()` uses a modified Timsort algorithm with a space complexity of \( O(n) \) because of the additional memory required for temporary arrays used in the merge process.

# Binary Search Approach

### Intuition

1. **Comparison to Two-Pointer Approach**:
   - In the two-pointer approach, we fix one number and use two pointers to enumerate pairs. In this binary search approach, we fix two numbers and use binary search to find the third complement number.

2. **Efficiency**:
   - This method is less efficient than the two-pointer approach but can be more intuitive to develop.

3. **Handling Complement**:
   - We may not find the exact complement number. Instead, we check the differences between the complement and the next higher and previous lower numbers.

4. **Example**:
   - For instance, if the complement is 42 and our array is `[-10, -4, 15, 30, 60]`, the next higher number is 60 (with a difference of -18), and the previous lower number is 30 (with a difference of 12).
