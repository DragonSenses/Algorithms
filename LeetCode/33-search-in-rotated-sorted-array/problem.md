# 33. Search in Rotated Sorted Array

<p>There is an integer array <code>nums</code> sorted in ascending order (with <strong>distinct</strong> values).</p>

<p>Prior to being passed to your function, <code>nums</code> is <strong>possibly rotated</strong> at an unknown pivot index <code>k</code> (<code>1 &lt;= k &lt; nums.length</code>) such that the resulting array is <code>[nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]</code> (<strong>0-indexed</strong>). For example, <code>[0,1,2,4,5,6,7]</code> might be rotated at pivot index <code>3</code> and become <code>[4,5,6,7,0,1,2]</code>.</p>

<p>Given the array <code>nums</code> <strong>after</strong> the possible rotation and an integer <code>target</code>, return <em>the index of </em><code>target</code><em> if it is in </em><code>nums</code><em>, or </em><code>-1</code><em> if it is not in </em><code>nums</code>.</p>

<p>You must write an algorithm with <code>O(log n)</code> runtime complexity.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<pre><strong>Input:</strong> nums = [4,5,6,7,0,1,2], target = 0
<strong>Output:</strong> 4
</pre><p><strong class="example">Example 2:</strong></p>
<pre><strong>Input:</strong> nums = [4,5,6,7,0,1,2], target = 3
<strong>Output:</strong> -1
</pre><p><strong class="example">Example 3:</strong></p>
<pre><strong>Input:</strong> nums = [1], target = 0
<strong>Output:</strong> -1
</pre>
<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 5000</code></li>
	<li><code>-10<sup>4</sup> &lt;= nums[i] &lt;= 10<sup>4</sup></code></li>
	<li>All values of <code>nums</code> are <strong>unique</strong>.</li>
	<li><code>nums</code> is an ascending array that is possibly rotated.</li>
	<li><code>-10<sup>4</sup> &lt;= target &lt;= 10<sup>4</sup></code></li>
</ul>

---

# Solution

- [**Binary Search (Naive Two-Pass) Approach**](#binary-search-naive-two-pass-approach)
  - **Time Complexity**: `O(log n)`
  - **Space Complexity**: `O(1)`
- [**Binary Search (Optimized One-Pass) Approach**](#binary-search-optimized-one-pass-approach)

# **Problem Overview: Search in Rotated Sorted Array**  

## **Description**  
You are given an integer array `nums` that is sorted in ascending order with distinct values. However, `nums` may have been rotated at an unknown pivot index `k` `(1 <= k < nums.length)`, resulting in a modified order:  

**Original:** `[0,1,2,4,5,6,7]`  
**Rotated at index 3:** `[4,5,6,7,0,1,2]`  

Given the array `nums` (after possible rotation) and an integer `target`, return the **index** of `target` if it is present. If `target` is not found, return `-1`.  

Your solution must run in **O(log n)** time complexity.  

## **Understanding Rotation**  
A **rotated sorted array** is still sorted, but the starting point has shifted to the right due to rotation. Essentially, a portion of the array has been moved to the front while maintaining the original relative ordering within each section. In the example above:  

- `[4,5,6,7]` was initially at the end but moved to the front.  
- `[0,1,2]` originally started the array but shifted to the back.  
- Despite this rotation, both sections remain sorted individually, but the transition point disrupts the continuity of the global sorted order.  

## **Examples**  

### **Example 1**  
**Input:**  
```plaintext
nums = [4,5,6,7,0,1,2]
target = 0
```
**Output:** `4`  

### **Example 2**  
**Input:**  
```plaintext
nums = [4,5,6,7,0,1,2]
target = 3
```
**Output:** `-1`  

### **Example 3**  
**Input:**  
```plaintext
nums = [1]
target = 0
```
**Output:** `-1`  

## **Constraints**  
- `1 <= nums.length <= 5000`  
- `-10⁴ <= nums[i] <= 10⁴`  
- All values in `nums` are unique.  
- `nums` is an ascending array that is possibly rotated.  
- `-10⁴ <= target <= 10⁴`

# **Binary Search (Naive Two-Pass) Approach**

The naive two-pass binary search approach will set up the **intuition and framework** for later **one-pass optimizations** where pivot detection and search happen simultaneously.

- **Two-pass binary search approach** (pivot first, then target).
- **Pivot detection ensures proper subarray selection** before binary search.
- **O(log N) runtime complexity** achieved.

## **Intuition**  
A search in `O(log N)` time usually implies binary search. Since the array is rotated at some **pivot index**, standard binary search cannot be directly applied.

Instead, we first locate the pivot and then determine which **subarray** contains the target before performing binary search.

## **Algorithm**  

1. **Find the Pivot Index** (smallest element in the array)  
   - This index marks the transition point between two **sorted** subarrays.  
   - It separates the **left** sorted portion from the **right** sorted portion.  
   - Can be found using **binary search** (instead of scanning `O(N)`).  

2. **Determine Which Side to Search**  
   - Compare `nums[0]` with `target`:  
     - If `target ≥ nums[0]`, search in the **left sorted portion** (before pivot).  
     - Otherwise, search in the **right sorted portion** (after pivot).  

3. **Perform Binary Search in the Chosen Subarray**  
   - Now apply standard binary search to find the target efficiently in `O(log N)`.  

### **Pseudocode**  
```plaintext
function search(nums, target):
    # Step 1: Find pivot index (smallest element)
    left = 0
    right = nums.length - 1

    while left < right:
        mid = (left + right) / 2
        if nums[mid] > nums[right]:
            left = mid + 1  # Pivot is in right half
        else:
            right = mid  # Pivot is in left half

    pivotIndex = left  # Found smallest element

    # Step 2: Determine search bounds
    left = 0
    right = nums.length - 1
    if target >= nums[pivotIndex] and target <= nums[right]:
        left = pivotIndex  # Search in right sorted half
    else:
        right = pivotIndex - 1  # Search in left sorted half

    # Step 3: Perform standard binary search
    while left <= right:
        mid = (left + right) / 2
        if nums[mid] == target:
            return mid  # Found target
        elif nums[mid] < target:
            left = mid + 1
        else:
            right = mid - 1

    return -1  # Target not found
```

## **Implementation**

### Java

```java
class Solution {
  public int search(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;

    // 1. Find Pivot Index (Smallest Element)
    while (left < right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] > nums[right]) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }

    int pivotIndex = left;

    // 2. Determine search bounds
    left = 0;
    right = nums.length - 1;
    if (target >= nums[pivotIndex] && target <= nums[right]) {
      left = pivotIndex;
    } else {
      right = pivotIndex - 1;
    }

    // 3. Perform Binary Search in Chosen Half
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] == target) {
        return mid; // Target found
      } else if (nums[mid] < target) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }

    return -1; // Target not found
  }
}
```

### TypeScript

```typescript
/**
 * Searches for a target value in a rotated sorted array using a two-pass binary search.
 *
 * @param {number[]} nums - The rotated sorted array of distinct integers.
 * @param {number} target - The target number to search for.
 * @returns {number} - Index of the target if found, otherwise -1.
 *
 * @example
 * search([4,5,6,7,0,1,2], 0) -> 4
 * search([4,5,6,7,0,1,2], 3) -> -1
 * search([1], 0) -> -1
 */
function search(nums: number[], target: number): number {
  let left = 0;
  let right = nums.length - 1;

  // 1. Find Pivot Index (Smallest Element)
  while (left < right) {
    const mid = Math.floor(left + (right - left) / 2);
    if (nums[mid] > nums[right]) {
      left = mid + 1;
    } else {
      right = mid;
    }
  }

  const pivotIndex = left;

  // 2. Determine search bounds
  left = 0;
  right = nums.length - 1;
  if (target >= nums[pivotIndex] && target <= nums[right]) {
    left = pivotIndex;
  } else {
    right = pivotIndex - 1;
  }

  // 3. Perform Binary Search in Chosen Half
  while (left <= right) {
    const mid = Math.floor(left + (right - left) / 2);
    if (nums[mid] === target) {
      return mid; // Target found
    } else if (nums[mid] < target) {
      left = mid + 1;
    } else {
      right = mid - 1;
    }
  }

  return -1; // Target not found
}
```

## **Complexity Analysis**  

### **Assumptions**  
- `nums` is a rotated sorted array of distinct integers.  
- The rotation is at an unknown pivot index.  
- The binary search algorithm is applied twice—once to find the pivot and once to locate `target`.  

### **Time Complexity**: `O(log n)`  
- **Finding the Pivot (`O(log n)`)**  
  - The first binary search identifies the smallest element (pivot), reducing the search space by half in each step.  
- **Searching for Target (`O(log n)`)**  
  - A second binary search is applied within the identified sorted half.  
- **Overall Complexity (`O(log n) + O(log n) = O(log n)`)**  
  - Since logarithmic operations are additive and dominated by the leading term, time complexity remains `O(log n)`.  

### **Space Complexity**: `O(1)`  
- **Constant-Space Usage**  
  - The algorithm only uses a fixed number of variables (`left`, `right`, `mid`, `pivotIndex`), irrespective of input size.  
- **No Additional Structures**  
  - No auxiliary data structures (arrays, lists, hashmaps) are used for storage.  
  - The input array is processed in place without requiring extra memory allocation.  

# **Binary Search (Optimized One-Pass) Approach**

The binary search one-pass optimized approach eliminates the need for a separate pivot detection step.

This implementation efficiently finds the target while **simultaneously detecting the rotation boundaries**, allowing for an elegant and optimized approach.

- **Single-pass approach** eliminates separate pivot search.  
- **Sorting check (`nums[left] ≤ nums[mid]`) ensures correct range selection**.  
- **O(log N) runtime complexity** achieved using binary search principles.  

## **Intuition**  
Instead of performing two separate binary searches (one for finding the pivot and another for searching the target), we can **merge these into one efficient pass**.  

- The array consists of two **sorted subarrays**—one before the pivot and one after it.  
- By integrating additional **condition checks**, we can simultaneously determine whether we need to shift left or right based on the relationship between `target`, `mid`, and the first element of the array.  
- This allows us to search directly within the relevant section without explicitly determining the pivot first.  

## **Algorithm**  
We maintain two pointers (`left` and `right`) to track the search scope. At each iteration, we **reduce the scope by half**, deciding which side of the array to explore based on **both pivot detection and target comparison**.

1. **Initialize pointers:**  
   - `left = 0`, `right = n - 1`  

2. **Perform binary search with integrated pivot logic:**  
   - Compute `mid = left + (right - left) / 2`  
   - Compare `nums[mid]` with `target`  
     - If `nums[mid] == target`, **return index mid**  
   - If the **left half** is sorted (`nums[left] ≤ nums[mid]`):  
     - Check if `target` falls within this sorted range (`nums[left] ≤ target < nums[mid]`)  
       - If yes, **reduce right** → `right = mid - 1`  
       - Else, **move left** → `left = mid + 1`  
   - Else, the **right half** is sorted (`nums[mid] ≤ nums[right]`):  
     - Check if `target` falls within this sorted range (`nums[mid] < target ≤ nums[right]`)  
       - If yes, **move left** → `left = mid + 1`  
       - Else, **reduce right** → `right = mid - 1`  

3. **Return -1 if `target` is not found.**  

### Integrate Pivot Detection and Target Search

Setting up the two pointers and iterating through the search process is straightforward.

However, combining pivot identification and target search into a single efficient pass requires a refined approach

**Key Idea:**  
- First, determine **which half** to search based on `pivotIndex` and `target`.  
- Then, perform **standard binary search** in the chosen half.  

#### **1. Pivot Detection: Finding the Rotation Point**  
   - Identifies the smallest element in the rotated sorted array.  
   - Determines where the rotation occurs to separate two sorted subarrays.

#### **2. Search Range Determination: Identifying Which Half to Search**  
   - Based on the pivot position, decides whether to search in the left or right sorted half.

#### **3. Target Search: Performing Binary Search Within the Correct Half**  
   - Executes binary search within the chosen subarray.  
   - Uses standard binary search comparisons to locate the target efficiently.

### **Step 1: Pivot Detection (Finding the Rotation Point)**  
This step identifies the **smallest element**, which represents the **pivot index**—the transition between two sorted subarrays in the rotated array.

#### **Logic**
- If `nums[mid] > nums[right]`, the smallest element is **in the right half**, so move `left = mid + 1`.
- Otherwise, the smallest element **must be in the left half**, so move `right = mid`.

```java
while (left < right) {  // Use < instead of <= since right adjusts directly
    int mid = left + (right - left) / 2;  // Prevent integer overflow

    if (nums[mid] > nums[right]) {  
        left = mid + 1;  // Pivot is in right half  
    } else {  
        right = mid;  // Pivot is in left half  
    }
}

int pivotIndex = left;  // Smallest element found
```

### **Step 2: Determine Search Range**
Before performing binary search, we must **identify the correct half** of the rotated array where the target might exist.  

- Since the array is rotated, **either the left half or the right half is sorted**.
- We use `pivotIndex` to check whether the target lies in the sorted right portion or the left portion.

#### **Logic**
- If `target` lies between `nums[pivotIndex]` and `nums[right]`, set `left = pivotIndex` to search in the **right half**.
- Otherwise, set `right = pivotIndex - 1` to search in the **left half**.

```java
left = 0;
right = nums.length - 1;

if (target >= nums[pivotIndex] && target <= nums[right]) {
    left = pivotIndex;  // Search in right sorted half
} else {
    right = pivotIndex - 1;  // Search in left sorted half
}
```

### **Step 3: Perform Target Search Using Binary Search**
Once the correct search bounds are defined, we execute **standard binary search** within the chosen half.

#### **Logic**
- Compare `nums[mid]` with `target` to determine whether to move **left** or **right**.
- Adjust boundaries accordingly to **narrow down** the search range.

```java
while (left <= right) {
    int mid = left + (right - left) / 2;

    if (nums[mid] == target) {
        return mid;  // Target found
    } else if (nums[mid] < target) {
        left = mid + 1;  // Move right
    } else {
        right = mid - 1;  // Move left
    }
}
```

### **Pseudocode**  
```plaintext
function searchRotatedArray(nums, target):
    left = 0
    right = nums.length - 1

    while left <= right:
        mid = left + (right - left) / 2

        # Found target
        if nums[mid] == target:
            return mid
        
        # Check if left half is sorted
        if nums[left] <= nums[mid]:
            if nums[left] <= target and target < nums[mid]:
                right = mid - 1  # Search in left sorted half
            else:
                left = mid + 1   # Search in right half
        else:
            # Right half is sorted
            if nums[mid] < target and target <= nums[right]:
                left = mid + 1  # Search in right sorted half
            else:
                right = mid - 1 # Search in left half

    return -1  # Target not found
```

## **Implementation**

### Java

```java
class Solution2 {
  public int search(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;

    while (left <= right) {
      int mid = left + (right - left) / 2; // Prevents potential overflow

      // Found target
      if (nums[mid] == target) {
        return mid; // Target found
      }

      // Check if left half is sorted
      if (nums[left] <= nums[mid]) {
        if (nums[left] <= target && target < nums[mid]) {
          right = mid - 1; // Search in left sorted half
        } else {
          left = mid + 1; // Search in right half
        }
      } else {
        // Right half is sorted
        if (nums[mid] < target && target <= nums[right]) {
          left = mid + 1; // Search in right sorted half
        } else {
          right = mid - 1; // Search in left half
        }
      }
    }

    return -1; // Target not found
  }
}
```

### TypeScript

```typescript
function search(nums: number[], target: number): number {
  let left = 0;
  let right = nums.length - 1;

  // Perform binary search while handling rotation dynamically
  while (left <= right) {
    let mid = Math.floor(left + (right - left) / 2); // Prevents potential overflow

    // Found target
    if (nums[mid] === target) {
      return mid;
    }

    // Determine which half is sorted
    if (nums[left] <= nums[mid]) {
      // Left half is sorted
      if (nums[left] <= target && target < nums[mid]) {
        right = mid - 1; // Search in left sorted half
      } else {
        left = mid + 1; // Search in right half
      }
    } else {
      // Right half is sorted
      if (nums[mid] < target && target <= nums[right]) {
        left = mid + 1; // Search in right sorted half
      } else {
        right = mid - 1; // Search in left half
      }
    }
  }

  return -1; // Target not found
}
```

## **Complexity Analysis**  

### **Assumptions**  
- `nums` is a rotated sorted array of distinct integers.  
- The rotation is at an unknown pivot index.  
- The **binary search algorithm runs in a single pass**, integrating pivot detection within the search for `target`.  

### **Key Improvement Over Naive Two-Pass Approach**  
- **Single-pass approach removes explicit pivot search**, making the process more efficient.  
- **Reduces redundant steps without increasing computational overhead.**  
- **Still maintains logarithmic performance and constant space usage.**  
