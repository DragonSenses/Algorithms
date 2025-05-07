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

```