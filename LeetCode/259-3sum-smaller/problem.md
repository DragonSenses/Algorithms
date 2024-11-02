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
  - **Time Complexity**: `O(n^2)`
- [Binary Search Approach](#binary-search)
  - **Time Complexity**: `O(n^2 log n)`
- [Brute Force Approach](#brute-force)

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

### Pseudocode

```plaintext
function threeSumSmaller(nums, target):
    sort(nums)
    count = 0
    for i from 0 to length(nums) - 2:
        count += twoSumSmaller(nums, i + 1, target - nums[i])
    return count

function twoSumSmaller(nums, startIndex, target):
    count = 0
    left = startIndex
    right = length(nums) - 1
    while left < right:
        if nums[left] + nums[right] < target:
            count += right - left
            left += 1
        else:
            right -= 1
    return count
```

## **Implementation**

### Java

```java
import java.util.Arrays;

class Solution {
public int threeSumSmaller(int[] nums, int target) {
    // Sort the array to enable the two-pointer technique
    Arrays.sort(nums);
    int count = 0;
    // Iterate through the array, treating each element as the potential first
    // element of the triplet
    for (int i = 0; i < nums.length - 2; i++) {
      // Use two-pointer technique to find pairs that sum to less than the target -
      // nums[i]
      count += twoSumSmaller(nums, i + 1, target - nums[i]);
    }
    return count;
  }

  private int twoSumSmaller(int[] nums, int startIndex, int target) {
    int count = 0;
    int left = startIndex;
    int right = nums.length - 1;
    // Use two pointers to find pairs that sum to less than the target
    while (left < right) {
      if (nums[left] + nums[right] < target) {
        // If the sum is less than the target, all pairs between left and right satisfy
        // the condition
        count += right - left;
        left++;
      } else {
        // Move the right pointer to the left to reduce the sum
        right--;
      }
    }
    return count;
  }
}
```

### TypeScript

```typescript
function threeSumSmaller(nums: number[], target: number): number {
  // Step 1: Sort the input array nums
  nums.sort((a, b) => a - b);
  let count = 0;

  // Step 2: Iterate through the array
  for (let i = 0; i < nums.length - 2; i++) {
    let lo = i + 1;
    let hi = nums.length - 1;

    // Step 3: Use two-pointer technique to find pairs that sum to less than the target
    while (lo < hi) {
      const sum = nums[i] + nums[lo] + nums[hi];
      if (sum < target) {
        // If the sum is less than the target, count all pairs between lo and hi
        count += hi - lo;
        lo++;
      } else {
        // Move the right pointer to the left to reduce the sum
        hi--;
      }
    }
  }
  // Step 4: Return the count of valid triplets
  return count;
}
```

## **Complexity Analysis**

### **Time Complexity**: `O(n^2)`
- **Sorting the Array**: `O(n log n)` time complexity for sorting the array.
- **Outer Loop**: The `threeSumSmaller` function sorts the array and then iterates over `(n - 2)` elements, invoking `twoSumSmaller` at each iteration.
- **Inner Loop**: The `twoSumSmaller` function performs a single-pass traversal with `O(n)` time complexity.
- **Overall Complexity**: Combining these operations, the overall time complexity is dominated by the nested loops, so the time complexity is `O(n log n + n^2)`. As `n^2` grows faster than `n log n`, it simplifies to `O(n^2)`.

### **Space Complexity**: `O(1)` or `O(log n)` to `O(n)` including sort
- **Sorting Algorithm**: The space complexity depends on the implementation of the sorting algorithm. As for the case with Java's `Arrays.sort()`, it depends on the type of elements being sorted:
  - **Primitive Types**: For sorting primitive types like `int`, `char`, `float`, etc., `Arrays.sort()` uses a dual-pivot Quicksort algorithm with a space complexity of `O(log n)` due to the recursive nature of Quicksort.
  - **Object Types**: For sorting objects, `Arrays.sort()` uses a modified Timsort algorithm with a space complexity of `O(n)` because of the additional memory required for temporary arrays used in the merge process.
- **No Additional Data Structures**: The algorithm uses constant space, `O(1)`, aside from the sort.

# Binary Search

## **Intuition**

To solve the **threeSumSmaller** problem, let's first tackle the simpler **twoSumSmaller** problem:

Given a `nums` array, find the number of index pairs `i` and `j` with `0 < i < j < n` that satisfy `nums[i] + nums[j] < target`.

**1. Sort the Array**:
Sort the array first to allow for binary search, making it easier to find pairs that meet the condition.

**2. Binary Search for Pairs**:
For each element `i` in the array, use binary search to find the largest index `j` such that `nums[i] + nums[j] < target`. This approach ensures that all elements between `i` and `j` form valid pairs.

**3. Count Valid Pairs**:
Once the largest index `j` is found, the number of valid pairs for a fixed `i` is `j - i`. Count these pairs for each `i`.

**4. Extend to ThreeSum**:
To extend this logic to the **threeSumSmaller** problem, wrap an outer loop around the **twoSumSmaller** solution. For each element, use the two-pointer technique on the remaining elements to find valid pairs.

With this intuitive approach, we can efficiently count the number of triplets with a sum smaller than the target.

### **Algorithm**

1. **Sort the Array**: Sort the input array.
2. **Initialize Counter**: Create a counter to keep track of the valid triplets.
3. **Outer Loop**: Iterate through the array to fix the first element of the triplet.
4. **Binary Search for Pairs**: For each fixed element, use binary search to find the largest index where the pair sum is less than the target.
5. **Count Valid Triplets**: Add the count of valid pairs to the counter.
6. **Return Result**: After the loop, return the counter.

## **Implementation**

#### Implementation Details

**Note**: In the binary search implementation, we choose the upper middle element (`(left + right + 1) / 2`) instead of the lower middle element (`(left + right) / 2`). This approach ensures that the loop terminates correctly, even when there are only two elements left. If the lower middle element were chosen and `nums[mid] < target` evaluated to `true`, the loop could become infinite. Choosing the upper middle element guarantees termination.

### Java

```java
import java.util.Arrays;

class Solution2 {

  public int threeSumSmaller(int[] nums, int target) {
    // Step 1: Sort the array to enable the binary search
    Arrays.sort(nums);

    // Step 2: Initialize the counter to keep track of valid triplets
    int count = 0;

    // Step 3: Iterate through the array to fix the first element of the triplet
    for (int i = 0; i < nums.length - 2; i++) {
      // Step 4: Use binary search to find pairs that sum to less than target -
      // nums[i]
      count += twoSumSmaller(nums, i + 1, target - nums[i]);
    }
    // Step 6: Return the count of valid triplets
    return count;
  }

  private int twoSumSmaller(int[] nums, int startIndex, int target) {
    int count = 0;

    // Iterate through the array to find pairs
    for (int i = startIndex; i < nums.length - 1; i++) {
      // Step 4: Use binary search to find the largest index where nums[i] + nums[j] <
      // target
      int j = binarySearch(nums, i, target - nums[i]);
      // Step 5: Count the pairs between i and j
      count += j - i;
    }
    return count;
  }

  private int binarySearch(int[] nums, int startIndex, int target) {
    int left = startIndex;
    int right = nums.length - 1;
    while (left < right) {
      int mid = (left + right + 1) / 2;
      if (nums[mid] < target) {
        // If nums[mid] is less than the target, move left to mid
        left = mid;
      } else {
        // Otherwise, move right to mid - 1
        right = mid - 1;
      }
    }
    return left;
  }
}
```

### TypeScript

```typescript
function threeSumSmaller(nums: number[], target: number): number {
    // Step 1: Sort the input array nums
    nums.sort((a, b) => a - b);
    let count = 0;

    // Step 2: Iterate through the array to fix the first element of the triplet
    for (let i = 0; i < nums.length - 2; i++) {
        // Step 3: Use binary search to find pairs that sum to less than target - nums[i]
        count += twoSumSmaller(nums, i + 1, target - nums[i]);
    }

    // Step 4: Return the count of valid triplets
    return count;
}

function twoSumSmaller(nums: number[], startIndex: number, target: number): number {
    let count = 0;

    // Iterate through the array to find pairs
    for (let i = startIndex; i < nums.length - 1; i++) {
        // Use binary search to find the largest index where nums[i] + nums[j] < target
        let j = binarySearch(nums, i, target - nums[i]);
        // Count the pairs between i and j
        count += j - i;
    }
    return count;
}

function binarySearch(nums: number[], startIndex: number, target: number): number {
    let left = startIndex;
    let right = nums.length - 1;
    while (left < right) {
        let mid = Math.floor((left + right + 1) / 2);
        if (nums[mid] < target) {
            left = mid;
        } else {
            right = mid - 1;
        }
    }
    return left;
}
```

## **Complexity Analysis**

### **Time Complexity**: `O(n^2 log n)`
- **Sorting the Array**: `O(n log n)` time complexity for sorting the array.
- **Outer Loop**: The `threeSumSmaller` function sorts the array and then iterates over `(n - 2)` elements, invoking `twoSumSmaller` at each iteration.
- **Inner Loop**: The `twoSumSmaller` function includes a binary search that takes `O(log n)` time, making its overall time complexity `O(n log n)`.
- **Overall Complexity**: Combining these operations, the overall time complexity is `O(n log n + n^2 log n)`. As `n^2 log n` grows faster than `n log n`, it simplifies to `O(n^2 log n)`.

### **Space Complexity**: `O(1)` or `O(log n)` to `O(n)` including sort
- **Sorting Algorithm**: The space complexity depends on the implementation of the sorting algorithm. For Java's `Arrays.sort()`:
  - **Primitive Types**: Uses dual-pivot Quicksort with `O(log n)` space complexity.
  - **Object Types**: Uses modified Timsort with `O(n)` space complexity due to temporary arrays used in the merge process.
- **Constant Space Usage**: The algorithm uses a constant amount of extra space for variables, thus `O(1)` space is used.
- **No Additional Data Structures**: The algorithm uses constant space, `O(1)`, aside from the sort.

# Brute Force

## **Intuition**

Find every possible set of triplets (`i, j, k`) such that `i < j < k` and test for the condition `nums[i] + nums[j] + nums[k] < target`. This straightforward approach ensures that all combinations are checked, albeit at the expense of efficiency.

## **Algorithm**

1. **Initialize Counter**: Create a counter to keep track of the valid triplets.
2. **Triple Nested Loop**: Use three nested loops to generate all possible triplets.
    - Outer loop for the first element `i`.
    - Middle loop for the second element `j`.
    - Inner loop for the third element `k`.
3. **Check Condition**: For each triplet, check if the sum of the elements is less than the target.
4. **Count Valid Triplets**: If the condition is met, increment the counter.
5. **Return Result**: After all triplets are checked, return the counter.

## **Implementation**

### Java

```java
class Solution3 {
  /**
   * Finds the number of index triplets such that nums[i] + nums[j] + nums[k] <
   * target.
   * This method uses the brute force approach.
   *
   * @param nums   The input array of integers.
   * @param target The target sum.
   * @return The count of triplets with a sum less than the target.
   */
  public int threeSumSmaller(int[] nums, int target) {
    int count = 0;

    // Triple nested loop to generate all possible triplets
    for (int i = 0; i < nums.length - 2; i++) {
      for (int j = i + 1; j < nums.length - 1; j++) {
        for (int k = j + 1; k < nums.length; k++) {
          // Check if the sum of the triplet is less than the target
          if (nums[i] + nums[j] + nums[k] < target) {
            // Increment the counter if the condition is met
            count++;
          }
        }
      }
    }

    // Return the count of valid triplets
    return count;
  }
}
```

### TypeScript

```typescript
function threeSumSmaller(nums: number[], target: number): number {
  let count = 0;

  // Triple nested loop to generate all possible triplets
  for (let i = 0; i < nums.length - 2; i++) {
    for (let j = i + 1; j < nums.length - 1; j++) {
      for (let k = j + 1; k < nums.length; k++) {
        // Check if the sum of the triplet is less than the target
        if (nums[i] + nums[j] + nums[k] < target) {
          // Increment the counter if the condition is met
          count++;
        }
      }
    }
  }

  // Return the count of valid triplets
  return count;
};
```

