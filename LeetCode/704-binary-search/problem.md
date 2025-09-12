# 704. Binary Search

<p>Given an array of integers <code>nums</code> which is sorted in ascending order, and an integer <code>target</code>, write a function to search <code>target</code> in <code>nums</code>. If <code>target</code> exists, then return its index. Otherwise, return <code>-1</code>.</p>

<p>You must write an algorithm with <code>O(log n)</code> runtime complexity.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> nums = [-1,0,3,5,9,12], target = 9
<strong>Output:</strong> 4
<strong>Explanation:</strong> 9 exists in nums and its index is 4
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> nums = [-1,0,3,5,9,12], target = 2
<strong>Output:</strong> -1
<strong>Explanation:</strong> 2 does not exist in nums so return -1
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10<sup>4</sup></code></li>
	<li><code>-10<sup>4</sup> &lt; nums[i], target &lt; 10<sup>4</sup></code></li>
	<li>All the integers in <code>nums</code> are <strong>unique</strong>.</li>
	<li><code>nums</code> is sorted in ascending order.</li>
</ul>

---

# Solution

- [Two Pointers Approach](#two-pointers-approach)

---

## Problem Overview : Binary Search

## Problem Statement
Given a sorted array of integers `nums` in ascending order and an integer `target`, implement a function to search for `target` in `nums`.  
If `target` exists, return its index. Otherwise, return `-1`.

You must implement an algorithm with **O(log n)** runtime complexity.

## Examples

### Example 1
**Input:**  
`nums = [-1, 0, 3, 5, 9, 12]`  
`target = 9`  
**Output:**  
`4`  
**Explanation:**  
`9` exists in `nums` and its index is `4`.

### Example 2
**Input:**  
`nums = [-1, 0, 3, 5, 9, 12]`  
`target = 2`  
**Output:**  
`-1`  
**Explanation:**  
`2` does not exist in `nums`, so return `-1`.

## Constraints
- `1 <= nums.length <= 10⁴`
- `-10⁴ < nums[i], target < 10⁴`
- All integers in `nums` are **unique**
- `nums` is sorted in **ascending order**

## Approach
Use the classic binary search approach:  
- Initialize two pointers `left` and `right`  
- While `left <= right`, calculate `mid`  
- Compare `nums[mid]` with `target` and adjust pointers accordingly  
- Return index if found, else `-1`

---

# Two Pointers Approach

## Intuition

Binary search leverages the fact that the input array is **sorted**. Instead of scanning every element, we can **eliminate half the search space** with each step. The two pointers—`left` and `right`—represent the current bounds of the search. By comparing the middle element to the target, we decide which half to discard. This results in **O(log n)** time complexity, making it ideal for large datasets.

This approach is especially useful when:
- You need to **find a specific value** in a sorted array.
- You're optimizing for **search speed** over brute-force iteration.
- You want a **deterministic and auditable** search path for debugging or logging.

## Algorithm

1. Initialize two pointers:
   - `left = 0` (start of array)
   - `right = nums.length - 1` (end of array)

2. While `left <= right`:
   a. Compute `mid = Math.floor((left + right) / 2)`
   b. If `nums[mid] === target`, return `mid` (target found)
   c. If `nums[mid] < target`, move `left = mid + 1` (search right half)
   d. If `nums[mid] > target`, move `right = mid - 1` (search left half)

3. If loop exits, return `-1` (target not found)

### **Pseudocode**

```txt
function binarySearch(nums, target):
    left = 0
    right = length(nums) - 1

    while left <= right:
        mid = floor((left + right) / 2)

        if nums[mid] == target:
            return mid

        else if nums[mid] < target:
            left = mid + 1

        else:
            right = mid - 1

    return -1  // target not found
```

## Implementation

### Java

```java
class Solution {
  public int search(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;

    while (left <= right) {
      int mid = (left + right) >>> 1;

      if (nums[mid] == target) {
        return mid;
      } else if (nums[mid] < target) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }

    return -1; // target not found
  }
}
```
