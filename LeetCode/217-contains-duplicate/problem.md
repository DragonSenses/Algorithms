# 217. Contains Duplicate

<p>Given an integer array <code>nums</code>, return <code>true</code> if any value appears <strong>at least twice</strong> in the array, and return <code>false</code> if every element is distinct.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [1,2,3,1]</span></p>

<p><strong>Output:</strong> <span class="example-io">true</span></p>

<p><strong>Explanation:</strong></p>

<p>The element 1 occurs at the indices 0 and 3.</p>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [1,2,3,4]</span></p>

<p><strong>Output:</strong> <span class="example-io">false</span></p>

<p><strong>Explanation:</strong></p>

<p>All elements are distinct.</p>
</div>

<p><strong class="example">Example 3:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [1,1,1,3,3,4,3,2,4,2]</span></p>

<p><strong>Output:</strong> <span class="example-io">true</span></p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>-10<sup>9</sup> &lt;= nums[i] &lt;= 10<sup>9</sup></code></li>
</ul>

---

# Solution

- [Hash Table Approach](#hash-table-approach)

---

## **Problem Overview: Contains Duplicate**

## Description

Given an integer array `nums`, return `true` if **any value appears at least twice** in the array. Return `false` if every element is **distinct**.

## Examples

### Example 1
**Input:**  
`nums = [1, 2, 3, 1]`  
**Output:**  
`true`  
**Explanation:**  
The element `1` appears more than once (indices 0 and 3).

### Example 2  
**Input:**  
`nums = [1, 2, 3, 4]`  
**Output:**  
`false`  
**Explanation:**  
All elements are distinct.

### Example 3  
**Input:**  
`nums = [1, 1, 1, 3, 3, 4, 3, 2, 4, 2]`  
**Output:**  
`true`  
**Explanation:**  
Several elements (like `1`, `3`, `4`, and `2`) appear more than once.

## Constraints

- `1 <= nums.length <= 10⁵`
- `-10⁹ <= nums[i] <= 10⁹`

# Hash Table Approach

Given an array of integers, we need to determine if any element appears more than once. If any value repeats, we return `true`; otherwise, we return `false`.

