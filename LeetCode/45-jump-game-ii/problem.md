# 45. Jump Game II

<p>You are given a <strong>0-indexed</strong> array of integers <code>nums</code> of length <code>n</code>. You are initially positioned at <code>nums[0]</code>.</p>

<p>Each element <code>nums[i]</code> represents the maximum length of a forward jump from index <code>i</code>. In other words, if you are at <code>nums[i]</code>, you can jump to any <code>nums[i + j]</code> where:</p>

<ul>
  <li><code>0 &lt;= j &lt;= nums[i]</code> and</li>
  <li><code>i + j &lt; n</code></li>
</ul>

<p>Return <em>the minimum number of jumps to reach </em><code>nums[n - 1]</code>. The test cases are generated such that you can reach <code>nums[n - 1]</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> nums = [2,3,1,1,4]
<strong>Output:</strong> 2
<strong>Explanation:</strong> The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> nums = [2,3,0,1,4]
<strong>Output:</strong> 2
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
  <li><code>1 &lt;= nums.length &lt;= 10<sup>4</sup></code></li>
  <li><code>0 &lt;= nums[i] &lt;= 1000</code></li>
  <li>It's guaranteed that you can reach <code>nums[n - 1]</code>.</li>
</ul>

<br>

---

# Solution

- [Greedy Shrinking Approach](#greedy-approach)

### Problem Overview

You are given a 0-indexed array of integers `nums` of length `n`. You start at the first element `nums[0]`.

Each element `nums[i]` represents the maximum length of a forward jump from that index `i`. In other words, if you are at `nums[i]`, you can jump to any `nums[i + j]` where:
- \(0 \leq j \leq nums[i]\)
- \(i + j < n\)

Your goal is to return the minimum number of jumps required to reach the last element `nums[n - 1]`. The test cases are generated to ensure that it is possible to reach the last element.

#### Examples

**Example 1:**
- **Input:** `nums = [2, 3, 1, 1, 4]`
- **Output:** `2`
- **Explanation:** The minimum number of jumps to reach the last index is `2`. Jump `1` step from index `0` to `1`, then `3` steps to the last index.

**Example 2:**
- **Input:** `nums = [2, 3, 0, 1, 4]`
- **Output:** `2`
- **Explanation:** The minimum number of jumps to reach the last index is `2`.

#### Constraints
- \(1 \leq nums.length \leq 10^4\)
- \(0 \leq nums[i] \leq 1000\)
- It's guaranteed that you can reach `nums[n - 1]`.

### Solution Approach

To solve this problem, you can use a greedy algorithm that keeps track of the furthest point you can reach with a given number of jumps. Here's a step-by-step explanation:

1. Initialize variables to track the current end of the jump, the furthest point you can reach, and the number of jumps.
2. Traverse the array, updating the furthest point you can reach.
3. When you reach the end of the current jump, increment the number of jumps and update the current end to the furthest point.
4. Continue this process until you reach the last element.

# Greedy Approach

