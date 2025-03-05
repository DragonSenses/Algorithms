# 80. Remove Duplicates from Sorted Array II

<p>Given an integer array <code>nums</code> sorted in <strong>non-decreasing order</strong>, remove some duplicates <a href="https://en.wikipedia.org/wiki/In-place_algorithm" target="_blank"><strong>in-place</strong></a> such that each unique element appears <strong>at most twice</strong>. The <strong>relative order</strong> of the elements should be kept the <strong>same</strong>.</p>

<p>Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the <strong>first part</strong> of the array <code>nums</code>. More formally, if there are <code>k</code> elements after removing the duplicates, then the first <code>k</code> elements of <code>nums</code>&nbsp;should hold the final result. It does not matter what you leave beyond the first&nbsp;<code>k</code>&nbsp;elements.</p>

<p>Return <code>k</code><em> after placing the final result in the first </em><code>k</code><em> slots of </em><code>nums</code>.</p>

<p>Do <strong>not</strong> allocate extra space for another array. You must do this by <strong>modifying the input array <a href="https://en.wikipedia.org/wiki/In-place_algorithm" target="_blank">in-place</a></strong> with O(1) extra memory.</p>

<p><strong>Custom Judge:</strong></p>

<p>The judge will test your solution with the following code:</p>

<pre>int[] nums = [...]; // Input array
int[] expectedNums = [...]; // The expected answer with correct length

int k = removeDuplicates(nums); // Calls your implementation

assert k == expectedNums.length;
for (int i = 0; i &lt; k; i++) {
    assert nums[i] == expectedNums[i];
}
</pre>

<p>If all assertions pass, then your solution will be <strong>accepted</strong>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> nums = [1,1,1,2,2,3]
<strong>Output:</strong> 5, nums = [1,1,2,2,3,_]
<strong>Explanation:</strong> Your function should return k = 5, with the first five elements of nums being 1, 1, 2, 2 and 3 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> nums = [0,0,1,1,1,1,2,3,3]
<strong>Output:</strong> 7, nums = [0,0,1,1,2,3,3,_,_]
<strong>Explanation:</strong> Your function should return k = 7, with the first seven elements of nums being 0, 0, 1, 1, 2, 3 and 3 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
  <li><code>1 &lt;= nums.length &lt;= 3 * 10<sup>4</sup></code></li>
  <li><code>-10<sup>4</sup> &lt;= nums[i] &lt;= 10<sup>4</sup></code></li>
  <li><code>nums</code> is sorted in <strong>non-decreasing</strong> order.</li>
</ul>

---

### Problem Overview
**Problem Name:** Remove Duplicates from Sorted Array II

**Goal:**
- Given an integer array `nums` sorted in non-decreasing order, modify the array in-place such that each unique element appears at most twice. 
- The relative order of the elements should be kept the same.
- The result should be placed in the first part of the array `nums`.

**Requirements:**
- You cannot allocate extra space for another array.
- Modify the input array in-place with O(1) extra memory.

**Output:**
- Return `k` after placing the final result in the first `k` slots of `nums`.

**Explanation:**
- If there are `k` elements after removing the duplicates, then the first `k` elements of `nums` should hold the final result.
- It does not matter what is left beyond the first `k` elements.

**Constraints:**
- `1 <= nums.length <= 30,000`
- `-10,000 <= nums[i] <= 10,000`
- `nums` is sorted in non-decreasing order.

### Examples

**Example 1:**
- **Input:** `nums = [1,1,1,2,2,3]`
- **Output:** `5, nums = [1,1,2,2,3,_]`
- **Explanation:** The function should return `k = 5`, with the first five elements of `nums` being `1, 1, 2, 2, 3` respectively. The underscores represent the elements beyond `k` which do not matter.

**Example 2:**
- **Input:** `nums = [0,0,1,1,1,1,2,3,3]`
- **Output:** `7, nums = [0,0,1,1,2,3,3,_,_]`
- **Explanation:** The function should return `k = 7`, with the first seven elements of `nums` being `0, 0, 1, 1, 2, 3, 3` respectively. The underscores represent the elements beyond `k` which do not matter.

The solution requires ensuring that no element appears more than twice while maintaining the order of elements in the array.

