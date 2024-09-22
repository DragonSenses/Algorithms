# 167. Two Sum II - Input Array Is Sorted

<div><p>Given a <strong>1-indexed</strong> array of integers <code>numbers</code> that is already <strong><em>sorted in non-decreasing order</em></strong>, find two numbers such that they add up to a specific <code>target</code> number. Let these two numbers be <code>numbers[index<sub>1</sub>]</code> and <code>numbers[index<sub>2</sub>]</code> where <code>1 &lt;= index<sub>1</sub> &lt; index<sub>2</sub> &lt;= numbers.length</code>.</p>

<p>Return<em> the indices of the two numbers, </em><code>index<sub>1</sub></code><em> and </em><code>index<sub>2</sub></code><em>, <strong>added by one</strong> as an integer array </em><code>[index<sub>1</sub>, index<sub>2</sub>]</code><em> of length 2.</em></p>

<p>The tests are generated such that there is <strong>exactly one solution</strong>. You <strong>may not</strong> use the same element twice.</p>

<p>Your solution must use only constant extra space.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> numbers = [<u>2</u>,<u>7</u>,11,15], target = 9
<strong>Output:</strong> [1,2]
<strong>Explanation:</strong> The sum of 2 and 7 is 9. Therefore, index<sub>1</sub> = 1, index<sub>2</sub> = 2. We return [1, 2].
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> numbers = [<u>2</u>,3,<u>4</u>], target = 6
<strong>Output:</strong> [1,3]
<strong>Explanation:</strong> The sum of 2 and 4 is 6. Therefore index<sub>1</sub> = 1, index<sub>2</sub> = 3. We return [1, 3].
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> numbers = [<u>-1</u>,<u>0</u>], target = -1
<strong>Output:</strong> [1,2]
<strong>Explanation:</strong> The sum of -1 and 0 is -1. Therefore index<sub>1</sub> = 1, index<sub>2</sub> = 2. We return [1, 2].
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>2 &lt;= numbers.length &lt;= 3 * 10<sup>4</sup></code></li>
	<li><code>-1000 &lt;= numbers[i] &lt;= 1000</code></li>
	<li><code>numbers</code> is sorted in <strong>non-decreasing order</strong>.</li>
	<li><code>-1000 &lt;= target &lt;= 1000</code></li>
	<li>The tests are generated such that there is <strong>exactly one solution</strong>.</li>
</ul>
</div>

<br>

---

# Solution

- [Two-Pointers Approach](#two-pointers)

## Overview

In **Two Sum**, we are given an array of integers `nums` and an integer `target`, return *indices of the two numbers such that they add up to* `target`.

Our approach to this problem was a two-pass hash table, for an eefficient way to check if the complement exists in the array. If the complement exists, we need to get its index. The best way to maintain a mapping of each element in thte array to its index is to use a hash table.

If we try this in **Two Sum II - Input Array is Sorted**, we get `O(n)` time and `O(n)` space. But this solution does not make use of the property that the input array is sorted.

Instead of a hash table, let's use two pointers.

# Two Pointers

We use two indices, initially pointing to the first and the last element, respectively. 

- Compare the sum of these two elements with `target` . 
  - If the sum is equal to `target`, we found the only exact solution. 
  - If it is less than `target`, we increase the smaller index by one. 
  - If it is greater than `target`, we decrease the larger index by one. 
- Move the indices and repeat the comparison until the solution is found.

## **Intuition**

Let `[ ..., a, b, c, ..., d, e, f, ... ]` be the input array that is sorted in ascending order and let the elements `b` and `e` be only exact solution. 

Because we are moving the smaller index from left to right, and the larger index from right to left, at some point, one of the indices must reach either `b` or `e`. 

Without loss of generality, suppose the smaller index reaches `b` first. At this time, the sum of these two elements must be greater than `target`.

Based on our algorithm, we will keep moving the larger index to the left until we reach the solution.

#### Initial Setup

- **Indices**: Use two indices, initially pointing to the first and the last element of the array.
- **Array**: Let the input array be sorted in ascending order.

## **Algorithm**

1. **Compare Sum with Target**:
   - Calculate the sum of the elements at the two indices.
   - If the sum is equal to the `target`, we have found the solution.
   - If the sum is less than the `target`, increase the smaller index by one.
   - If the sum is greater than the `target`, decrease the larger index by one.

2. **Move Indices and Repeat**:
   - Continue moving the indices and comparing the sum until the solution is found.

#### Example Walkthrough

- **Array**: `[ ..., a, b, c, ..., d, e, f, ... ]`
- **Solution Elements**: Let `b` and `e` be the elements that sum to the `target`.

#### Detailed Explanation

- **Movement of Indices**:
  - The smaller index moves from left to right.
  - The larger index moves from right to left.
  - At some point, one of the indices must reach either `b` or `e`.

- **Case Analysis**:
  - Suppose the smaller index reaches `b` first.
  - At this time, the sum of the two elements must be greater than the `target`.
  - Based on the algorithm, we will keep moving the larger index to the left until we reach the solution.

### Summary

- The two-pointer technique efficiently finds the two elements that sum to the `target` by leveraging the sorted nature of the array.
- By adjusting the indices based on the comparison of the sum with the `target`, we ensure that we find the solution using only constant extra space.

