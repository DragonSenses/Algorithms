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

With this observation we can easily tell which of the 2 arrays `A` or `B` does a `target` element lie in by just comparing it with the first element of the array.

Let's say we are looking for element `target` in array `arr`

Case 1: If `target > arr[start]`: `target` existsi n the first array `A`
Case 2: If `target < arr[start]` : `target` exists in the second array `B`
Case 3: If `target == arr[start]` : `target` exists in the first array `A`, but it might also be present in the second array `B`.