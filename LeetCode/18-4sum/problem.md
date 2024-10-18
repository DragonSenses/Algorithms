# 18. 4Sum

<p>Given an array <code>nums</code> of <code>n</code> integers, return <em>an array of all the <strong>unique</strong> quadruplets</em> <code>[nums[a], nums[b], nums[c], nums[d]]</code> such that:</p>

<ul>
	<li><code>0 &lt;= a, b, c, d&nbsp;&lt; n</code></li>
	<li><code>a</code>, <code>b</code>, <code>c</code>, and <code>d</code> are <strong>distinct</strong>.</li>
	<li><code>nums[a] + nums[b] + nums[c] + nums[d] == target</code></li>
</ul>

<p>You may return the answer in <strong>any order</strong>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> nums = [1,0,-1,0,-2,2], target = 0
<strong>Output:</strong> [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> nums = [2,2,2,2,2], target = 8
<strong>Output:</strong> [[2,2,2,2]]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 200</code></li>
	<li><code>-10<sup>9</sup> &lt;= nums[i] &lt;= 10<sup>9</sup></code></li>
	<li><code>-10<sup>9</sup> &lt;= target &lt;= 10<sup>9</sup></code></li>
</ul>

<br>

---

# Solution
- [Two Pointers Approach](#two-pointers)

## 4Sum Problem Overview

### Follow-Up of 3Sum

4Sum and 3Sum are very similar; the difference is that we are looking for unique quadruplets instead of triplets.

### Wrapping Two Sum

3Sum essentially wraps Two Sum in an outer loop. As it iterates through each value `v`, it finds all pairs whose sum is equal to `target - v` using one of these approaches:
1. **Two Sum**: Uses a hash set to check for a matching value.
2. **Two Sum II**: Uses the two-pointers pattern in a sorted array.

### Extending to 4Sum

Following a similar logic, we can implement 4Sum by wrapping 3Sum in another loop.

### Generalizing to kSum

If asked to solve 4Sum, the interviewer might follow up with 5Sum, 6Sum, and so on. What they really expect is a `kSum` solution. Therefore, we will focus on a generalized implementation here.

# Two Pointers

### Key Concept

The kSum problem can be generalized from the 2Sum and 3Sum problems. By understanding the pattern and extending it, we can create a solution that works for any kSum.

### Wrapping Two Sum

For the 3Sum problem, we wrap Two Sum in an outer loop. As we iterate through each value `v`, we find all pairs whose sum is equal to `target - v`. We can use:
1. **Two Sum with Hash Set**: Use a hash set to check for matching values.
2. **Two Sum II with Two Pointers**: Use the two-pointers technique in a sorted array.

