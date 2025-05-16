# 81. Search in Rotated Sorted Array II

<p>There is an integer array <code>nums</code> sorted in non-decreasing order (not necessarily with <strong>distinct</strong> values).</p>

<p>Before being passed to your function, <code>nums</code> is <strong>rotated</strong> at an unknown pivot index <code>k</code> (<code>0 &lt;= k &lt; nums.length</code>) such that the resulting array is <code>[nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]</code> (<strong>0-indexed</strong>). For example, <code>[0,1,2,4,4,4,5,6,6,7]</code> might be rotated at pivot index <code>5</code> and become <code>[4,5,6,6,7,0,1,2,4,4]</code>.</p>

<p>Given the array <code>nums</code> <strong>after</strong> the rotation and an integer <code>target</code>, return <code>true</code><em> if </em><code>target</code><em> is in </em><code>nums</code><em>, or </em><code>false</code><em> if it is not in </em><code>nums</code><em>.</em></p>

<p>You must decrease the overall operation steps as much as possible.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<pre><strong>Input:</strong> nums = [2,5,6,0,0,1,2], target = 0
<strong>Output:</strong> true
</pre><p><strong class="example">Example 2:</strong></p>
<pre><strong>Input:</strong> nums = [2,5,6,0,0,1,2], target = 3
<strong>Output:</strong> false
</pre>
<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 5000</code></li>
	<li><code>-10<sup>4</sup> &lt;= nums[i] &lt;= 10<sup>4</sup></code></li>
	<li><code>nums</code> is guaranteed to be rotated at some pivot.</li>
	<li><code>-10<sup>4</sup> &lt;= target &lt;= 10<sup>4</sup></code></li>
</ul>

<p>&nbsp;</p>
<p><strong>Follow up:</strong> This problem is similar to&nbsp;<a href="/problems/search-in-rotated-sorted-array/description/" target="_blank">Search in Rotated Sorted Array</a>, but&nbsp;<code>nums</code> may contain <strong>duplicates</strong>. Would this affect the runtime complexity? How and why?</p>

---

# Solution

- [Binary Search Approach](#binary-search-approach)
  - **Time Complexity**: Worst Case: `O(n)`, Best Case: `O(log n)`
  - **Space Complexity**: `O(1)`

## **Problem Overview: Search in Rotated Sorted Array II**

### **Description**  
You are given an integer array `nums` that is sorted in non-decreasing order but **rotated** at an unknown pivot index `k` (`0 ≤ k < nums.length`). The rotation results in the following structure:

> `[nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]` (0-indexed)

For example, the sorted array `[0,1,2,4,4,4,5,6,6,7]` rotated at pivot index `5` becomes:  
> `[4,5,6,6,7,0,1,2,4,4]`

Your task is to determine whether a given integer `target` exists in the rotated array `nums`.  
**Return `true` if `target` is found, otherwise return `false`.**  
You must aim to **minimize the overall number of operations**.

### **Examples**

#### **Example 1**
**Input:**  
```plaintext
nums = [2,5,6,0,0,1,2]
target = 0
```
**Output:**  
```plaintext
true
```

#### **Example 2**
**Input:**  
```plaintext
nums = [2,5,6,0,0,1,2]
target = 3
```
**Output:**  
```plaintext
false
```

### **Constraints**
- `1 ≤ nums.length ≤ 5000`
- `-10⁴ ≤ nums[i] ≤ 10⁴`
- `nums` is guaranteed to be rotated at some pivot.
- `-10⁴ ≤ target ≤ 10⁴`

### **Follow-up Question**
This problem is similar to **Search in Rotated Sorted Array**, but here, `nums` may contain **duplicate values**.  
Would the presence of duplicates **affect the runtime complexity**?  
**How and why?**

#### **Effect of Duplicates on Complexity**
In **Search in Rotated Sorted Array I**, a **single-pass binary search** could be achieved by consistently comparing `mid` with `left` or `right` to determine which half is sorted. However, when duplicates exist in **Search in Rotated Sorted Array II**, this process becomes trickier:
- If `nums[mid] == nums[left] == nums[right]`, you **lose the ability to definitively determine which half is sorted**, forcing a fallback to a **linear scan** in the worst case.
- This means that binary search **degrades from O(log n) to O(n)** in scenarios where many duplicates obscure the sorted structure.

#### **Key Observations**
1. **Best Case (O(log n))**: If there are minimal duplicates, standard binary search logic holds. You can discard one half of the array efficiently.
2. **Worst Case (O(n))**: If `nums[mid] == nums[left] == nums[right]`, binary search **fails to eliminate** half of the array in one step. Instead, you must increment `left` or decrement `right` (which resembles linear search).

#### **Final Complexity Analysis**
Due to the presence of duplicates, the worst-case scenario is **O(n)**, although in many practical cases you might still achieve **O(log n)**.

# Binary Search Approach

This problem is an extension of **33. Search in Rotated Sorted Array**, with the primary difference being that **duplicates are allowed**, which can affect binary search behavior.

## **Intuition**  

After rotating a sorted array, we effectively get **two sorted subarrays concatenated** into one. Let's define:  
- `A`: The first sorted segment before rotation.  
- `B`: The second sorted segment after rotation.  

An important observation:  
- **All elements in `B` are smaller or equal to the first element of `A`.**  
- Thus, the first element of the array (`A_start`) can help determine whether the target lies in `A` or `B`.

### **Target Positioning Based on `A_start`**  
Given an array `arr` and target `target`, we categorize its location:

1. **If `target > arr[start]`** → `target` exists in `A`.  
2. **If `target < arr[start]`** → `target` exists in `B`.  
3. **If `target == arr[start]`** → `target` exists in `A`, but it might also be in `B`.  

However, when duplicates are present, determining which half is sorted becomes ambiguous.  
- If `arr[mid] == arr[start] == arr[end]`, we **cannot confidently discard** half the array.  
- Instead, we must **increment `start` or decrement `end`**, potentially degrading binary search to **O(n)** in the worst case.

## **Refined Strategy**  
To mitigate worst-case scenarios caused by duplicates:
1. **Use binary search logic when possible**—compare `mid` with `start` and `target` to determine search direction.
2. **Handle duplicate ambiguity**—if `arr[mid] == arr[start]`, increment `start` to skip duplicates instead of blindly discarding halves.

This ensures we optimize the approach while accounting for worst-case degradation.

## **Algorithm**

This algorithm builds upon **standard binary search**, but is adapted to handle a **rotated sorted array with duplicates**.  

### **Step 1: Binary Search Fundamentals**
We maintain two pointers:  
- `start`: Tracks the beginning of the search space.  
- `end`: Tracks the end of the search space.  

At each step, we calculate the midpoint:  
> `mid = (start + end) / 2`

The search space is divided into three parts:
1. **[start, mid)** = Left half
2. **[mid, mid]** = Midpoint itself
3. **(mid, end]** = Right half

Based on `arr[mid]` and `target`, we decide which region to discard.

### **Step 2: Determining Search Space Based on Rotation**  
By identifying the positions of `arr[mid]` and `target` in the rotated structure, we reduce the search space efficiently.

#### **Case 1: `arr[mid]` lies in `A`, `target` lies in `B`**  
Since `B` starts after `A` ends, the target must be in `(mid, end]`.  

#### **Case 2: `arr[mid]` lies in `B`, `target` lies in `A`**  
Since `A` starts before `B`, the target must be in `[start, mid)`.  

#### **Case 3: Both `arr[mid]` and `target` lie in `A`**  
Since both are in the same sorted segment, we compare `arr[mid]` with `target` to determine the search space reduction.

#### **Case 4: Both `arr[mid]` and `target` lie in `B`**  
Again, since both belong to the same sorted segment, we compare `arr[mid]` and `target` to eliminate half of the search space.

### **Step 3: Handling Duplicates**  
There's a key **edge case** when `arr[mid] == arr[start]`:  
- `arr[mid]` might belong **to both `A` and `B`**, so we **cannot determine the target's relative position** confidently.  
- In this scenario, we **increment `start`** or **decrement `end`**, effectively switching to a **linear search** in the worst case.  

Some regions **allow binary search**, while others force **sequential iteration due to ambiguity**.

### **Example Walkthrough**

#### **Case 1: `arr[mid]` lies in `A`, `target` lies in `B`**  
Since `B` starts after `A` ends, the target must be in `(mid, end]`.  

Given array a = [10, 12, 12, 15, 19, 5, 8, 8, 9, 9]
start = a[0] = 10
mid = a[4] = 19
target = a[7] = 8
end = a[10] = 9

#### **Case 2: `arr[mid]` lies in `B`, `target` lies in `A`**  
Since `A` starts before `B`, the target must be in `[start, mid)`.  

Given array a = [10, 12, 12, 15, 19, 5, 8, 8, 9, 9]
start = a[0] = 10
mid = a[5] = 5
target = a[3] = 15
end = a[10] = 9



### **Final Considerations**
- **Best-case complexity:** `O(log n)` when duplicates don't obscure order.  
- **Worst-case complexity:** `O(n)` when duplicates prevent confident space reduction.  

### **Pseudocode**

```plaintext
FUNCTION searchRotatedArray(nums, target):
  start = 0
  end = length(nums) - 1

  WHILE start ≤ end:
    mid = (start + end) / 2  // Calculate the middle index

    // Check if target is found
    IF nums[mid] == target:
      RETURN true

    // Handle duplicate ambiguity
    IF nums[start] == nums[mid] AND nums[mid] == nums[end]:
      start = start + 1  // Increment start to skip duplicate
      end = end - 1  // Decrement end to narrow search space
      CONTINUE

    // Identifying the sorted half
    IF nums[start] ≤ nums[mid]:  // Left segment is sorted
      // Case 3: Both arr[mid] and target lie in F
      IF nums[start] ≤ target < nums[mid]:
        end = mid - 1  // Search in the left half
      ELSE:
        start = mid + 1  // Search in the right half
    ELSE:  // Right segment is sorted
      // Case 4: Both arr[mid] and target lie in S
      IF nums[mid] < target ≤ nums[end]:
        start = mid + 1  // Search in the right half
      ELSE:
        end = mid - 1  // Search in the left half

  RETURN false  // Target not found
```

## **Implementation**

### Java

```java
class Solution {
  public boolean search(int[] nums, int target) {
    int start = 0, end = nums.length - 1;

    while (start <= end) {
      int mid = start + (end - start) / 2;

      // Found target
      if (nums[mid] == target) {
        return true;
      }

      // Handle duplicate ambiguity
      if (nums[start] == nums[mid] && nums[mid] == nums[end]) {
        start++;
        end--;
        continue;
      }

      // Identifying the sorted half
      if (nums[start] <= nums[mid]) { // Left segment is sorted
        if (nums[start] <= target && target < nums[mid]) {
          // Search in left half
          end = mid - 1;
        } else {
          // Search in right half
          start = mid + 1;
        }
      } else { // Right segment is sorted
        if (nums[mid] < target && target <= nums[end]) {
          // Search in right half
          start = mid + 1;
        } else {
          // Search in left half
          end = mid - 1;
        }
      }

    }

    // Target not found
    return false;
  }
}
```

### TypeScript

```typescript
function search(nums: number[], target: number): boolean {
  let start = 0;
  let end = nums.length - 1;

  while (start <= end) {
    let mid = Math.floor(start + (end - start) /2);

    // Found target
    if (nums[mid] === target) {
      return true;
    }

    // Handle duplicate ambiguity
    if (nums[start] === nums[mid] && nums[mid] === nums[end]) {
      start++;
      end--;
      continue;
    }

    // Identifying sorted half
    if (nums[start] <= nums[mid]) {
      // Left segment is sorted
      if (nums[start] <= target && target < nums[mid]) {
        // Search in left half
        end = mid - 1;
      } else {
        // Search in right half
        start = mid + 1;
      }
    } else {
      // Right segment is sorted
      if (nums[mid] < target && target <= nums[end]) {
        // Search in right half
        start = mid + 1;
      } else {
        // Search in left half
        end = mid - 1;
      }
    }
  }

  // Target not found
  return false;
};
```

## **Complexity Analysis**

### **Assumptions**
- `nums` is a **rotated sorted array**, but it **may contain duplicate values**, which differentiates it from its distinct-element counterpart.
- The rotation occurs at an **unknown pivot index** (`0 ≤ k < nums.length`).
- We aim to **minimize operations** while searching for `target`.

### **Time Complexity**: Worst Case: `O(n)`, Best Case: `O(log n)`

The **binary search** approach generally has `O(log n)` complexity, but the presence of **duplicates** can cause ambiguity, leading to a **worst-case linear scan**.

#### **Best Case: O(log n)**
- If there are few or no duplicates, **standard binary search logic** applies.
- The algorithm consistently eliminates half the search space, maintaining logarithmic complexity.

#### **Worst Case: O(n)**
- If **nums[start] == nums[mid] == nums[end]**, the sorted half cannot be determined.
- In such cases, the algorithm **shrinks the search space linearly** (`start++` and `end--`), mimicking a **sequential scan**.

Thus, the overall **time complexity is O(log n) in the best case, but O(n) in the worst case due to duplicates affecting partitioning.**

### **Space Complexity**: `O(1)`
- **Constant-Space Usage**: The algorithm only uses a fixed number of variables (`start`, `end`, `mid`) to track pivots, regardless of the input size.
- Memory usage **remains constant**, independent of `nums.length`.
- **No Additional Structures**: The input string is processed directly without requiring extra data structures, ensuring constant memory usage. No additional structures (arrays, hash maps) are allocated.
You're on the right track! Let's refine and verify your complexity analysis, especially considering the presence of **duplicate elements** in the array.