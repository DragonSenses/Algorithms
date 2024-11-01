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
