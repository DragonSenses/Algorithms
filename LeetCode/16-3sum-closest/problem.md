# 16. 3Sum Closest

<p>Given an integer array <code>nums</code> of length <code>n</code> and an integer <code>target</code>, find three integers in <code>nums</code> such that the sum is closest to <code>target</code>.</p>

<p>Return <em>the sum of the three integers</em>.</p>

<p>You may assume that each input would have exactly one solution.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> nums = [-1,2,1,-4], target = 1
<strong>Output:</strong> 2
<strong>Explanation:</strong> The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> nums = [0,0,0], target = 1
<strong>Output:</strong> 0
<strong>Explanation:</strong> The sum that is closest to the target is 0. (0 + 0 + 0 = 0).
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>3 &lt;= nums.length &lt;= 500</code></li>
	<li><code>-1000 &lt;= nums[i] &lt;= 1000</code></li>
	<li><code>-10<sup>4</sup> &lt;= target &lt;= 10<sup>4</sup></code></li>
</ul>

<br>

---

# Solution

## Overview

The 3Sum Closest problem is a variation of the 3Sum problem. Unlike 3Sum, the goal here is not to find triplets that sum up to a target value but to find triplets whose sum is closest to the target. This problem bears some resemblance to the 3Sum Smaller variant.

### Related Problems and Solutions

#### 3Sum

3Sum involves fixing one number and using either the two pointers pattern or a hash set to find complementary pairs. This results in a time complexity of `O(n^2)`.

#### 3Sum Smaller

3Sum Smaller, similar to 3Sum, employs the two pointers pattern to enumerate smaller pairs. However, a hash set is not used here due to the absence of a specific value to search for.

### Approach to 3Sum Closest

For the same reason as in 3Sum Smaller, we can't use a hash set in 3Sum Closest because there is no specific value to search for. Thus, our focus will be on utilizing the two pointers pattern, targeting an `O(n^2)` time complexity as the best conceivable runtime (BCR).

