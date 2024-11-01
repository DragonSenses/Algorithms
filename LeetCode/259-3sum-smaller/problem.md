# 3Sum Smaller

### Problem
Given an array of `n` integers `nums` and an integer `target`, find the number of index triplets `i, j, k` with `0 <= i < j < k < n` that satisfy the condition `nums[i] + nums[j] + nums[k] < target`.

### Example
**Example 1**:
- **Input**: nums = [-2, 0, 1, 3], target = 2
- **Output**: 2
- **Explanation**: There are two triplets which sum is less than 2:
  - [-2, 0, 1]
  - [-2, 0, 3]

**Example 2**:
- **Input**: nums = [], target = 0
- **Output**: 0

### Constraints
- `n == nums.length`
- `0 <= n <= 300`
- `-100 <= nums[i] <= 100`
- `-100 <= target <= 100`

<br>

---

## Overview

The 3Sum Smaller problem is a variation of the 3Sum problem. Unlike 3Sum, the goal here is not to find triplets that sum up to a target value but to find triplets whose sum is closest to the target. This problem bears some resemblance to the 3Sum Closest variant.

### Related Problems and Solutions

#### 3Sum

3Sum involves fixing one number and using either the two pointers pattern or a hash set to find complementary pairs. This results in a time complexity of `O(n^2)`.

#### 3Sum Smaller

3Sum Smaller, similar to 3Sum, employs the two pointers pattern to enumerate smaller pairs. However, a hash set is not used here due to the absence of a specific value to search for.

### Approach to 3Sum Smaller

For the same reason as in 3Sum Closest, we can't use a hash set in 3Sum Smaller because there is no specific value to search for. Thus, our focus will be on utilizing the two pointers pattern, targeting an `O(n^2)` time complexity as the best conceivable runtime (BCR).

