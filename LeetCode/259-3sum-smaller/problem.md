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

# Solution
- [Two Pointers Approach](#two-pointers)

## Overview

The 3Sum Smaller problem is a variation of the 3Sum problem. Unlike 3Sum, the goal here is not to find triplets that sum up to a target value but to find triplets whose sum is closest to the target. This problem bears some resemblance to the 3Sum Closest variant.

### Related Problems and Solutions

#### 3Sum

3Sum involves fixing one number and using either the two pointers pattern or a hash set to find complementary pairs. This results in a time complexity of `O(n^2)`.

#### 3Sum Smaller

3Sum Smaller, similar to 3Sum, employs the two pointers pattern to enumerate smaller pairs. However, a hash set is not used here due to the absence of a specific value to search for.

### Approach to 3Sum Smaller

For the same reason as in 3Sum Closest, we can't use a hash set in 3Sum Smaller because there is no specific value to search for. Thus, our focus will be on utilizing the two pointers pattern, targeting an `O(n^2)` time complexity as the best conceivable runtime (BCR).

# Two Pointers

## **Intuition**

First, sort the array. For example, `nums = [3, 5, 2, 8, 1]` becomes `[1, 2, 3, 5, 8]`.

Let’s say we have `nums = [1, 2, 3, 5, 8]` and `target = 7`.

1. Initialize two indices, `left` and `right`, pointing to the first and last element respectively.

```plaintext
[1, 2, 3, 5, 8]
left = 1
right = 8
```

2. Check the sum of the first and last element: `1 + 8 = 9`, which is `>= target`. No index pair will include `right`, so move the `right` pointer one step to the left.

```plaintext
[1, 2, 3, 5, 8]
left = 1
right = 5
```

3. Now the sum is `1 + 5 = 6`, which is `< target`. 
  - Count all pairs with left that satisfy the condition. 
  - The difference between `right` and `left` is 3, so the pairs are `(1, 2)`, `(1, 3)`, and `(1, 5)`.
  - Move `left` one step to the right.

## **Algorithm**

1. **Sort the array**: Begin by sorting the input array to enable efficient use of the two-pointer technique.
2. **Initialize a counter**: Create a variable to count the valid triplets.
3. **Iterate through the array**: Loop through the array, treating each element as the potential first element of the triplet.
4. **Use a two-pointer technique**: For each first element, use two pointers to find pairs that sum to less than the target.
    - **Left Pointer**: Start at the element immediately after the current first element.
    - **Right Pointer**: Start at the last element of the array.
5. **Count valid pairs**: If the sum of elements at the left and right pointers is less than the target, count all pairs from the left pointer to the right pointer and move the left pointer one step to the right.
    - **Update Counter**: Add the count of valid pairs to the counter.
6. **Move pointers accordingly**: If the sum is greater than or equal to the target, move the right pointer one step to the left.
7. **Repeat for all elements**: Continue until all possible triplets are checked.
8. **Return the counter**: After the loop, return the total count of valid triplets.

