# 35. Search Insert Position

<p>Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.</p>

<p>You must&nbsp;write an algorithm with&nbsp;<code>O(log n)</code> runtime complexity.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> nums = [1,3,5,6], target = 5
<strong>Output:</strong> 2
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> nums = [1,3,5,6], target = 2
<strong>Output:</strong> 1
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> nums = [1,3,5,6], target = 7
<strong>Output:</strong> 4
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10<sup>4</sup></code></li>
	<li><code>-10<sup>4</sup> &lt;= nums[i] &lt;= 10<sup>4</sup></code></li>
	<li><code>nums</code> contains <strong>distinct</strong> values sorted in <strong>ascending</strong> order.</li>
	<li><code>-10<sup>4</sup> &lt;= target &lt;= 10<sup>4</sup></code></li>
</ul>

<br>

---

# Solution
-[Binary Search Approach](#binary-search-approach)

# Binary Search Approach

## **Intuition**

Usually, within binary search, we compare the target value to the middle element of the array at each iteration:
- If the target value is equal to the middle element, the job is done.
- If the target value is less than the middle element, continue to search on the left.
- If the target value is greater than the middle element, continue to search on the right.

### Example Walkthrough

Let's take example 1, where:

- **Input**: `nums = [1,3,5,6]`, `target = 5`
- **Output**: `2`

1. **Initial Array**: `nums = [1,3,5,6]`
   - `left = 0`, `right = 3` (indices of the array)
2. **First Iteration**:
   - Calculate pivot: `pivot = (left + right) / 2 = (0 + 3) / 2 = 1`
   - Compare `nums[pivot] = nums[1] = 3` with `target = 5`
     - `3 < 5` --> Continue to search on the right
   - Move `left` pointer: `left = pivot + 1 = 2`
3. **Second Iteration**:
   - Calculate new pivot: `pivot = (left + right) / 2 = (2 + 3) / 2 = 2`
   - Compare `nums[pivot] = nums[2] = 5` with `target = 5`
     - `5 == 5` --> Target found. Return pivot `2`

Thus, the index of the target value `5` in the array `[1,3,5,6]` is `2`.

### Search Boundaries

To mark the search boundaries, one could use two pointers: `left` and `right`. Starting from `left = 0` and `right = n - 1`, we then move either of the pointers according to various situations:
- While `left < right`:
    - Pivot index is the one in the middle: `pivot = (left + right) / 2`. The pivot also divides the original array into two subarrays.
    - If the target value is equal to the pivot element: `target == nums[pivot]`, we're done.
    - If the target value is less than the pivot element `target < nums[pivot]`, continue to search on the left subarray by moving the right pointer `right = pivot - 1`.
    - If the target value is greater than the pivot element `target > nums[pivot]`, continue to search on the right subarray by moving the left pointer `left = pivot + 1`.

### What if the Target Value is Not Found?

In this case, the loop will stop when `right < left` and `nums[right] < target < nums[left]`. Hence, the proper position to insert the target is at the index `left`.

### Integer Overflow

Note that `pivot = (left + right) // 2` works fine for languages with arbitrary precision integers such as Python3, but it could cause some issues in Java and C++.

If `left + right` is greater than the maximum `int` value `2^31 - 1`, it overflows to a negative value. In Java, it would trigger an exception of `ArrayIndexOutOfBoundsException`, and in C++, it causes an illegal write, which leads to memory corruption and unpredictable results.

Ways to fix it:

- Using `pivot = left + (right - left) / 2`; prevents the addition of left and right from exceeding the maximum integer value. 
```java
pivot = left + (right - left) / 2;
```

Or using the bit shift operator
  - `pivot = (left + right) >> 1` uses a bitwise right shift operation to achieve the same result.

```java
pivot = (left + right) >> 1;
```

Both approaches ensure that the calculation stays within the safe range of integer values.
