# 47. Permutations II

<p>Given a collection of numbers, <code>nums</code>,&nbsp;that might contain duplicates, return <em>all possible unique permutations <strong>in any order</strong>.</em></p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> nums = [1,1,2]
<strong>Output:</strong>
[[1,1,2],
 [1,2,1],
 [2,1,1]]
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> nums = [1,2,3]
<strong>Output:</strong> [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 8</code></li>
	<li><code>-10 &lt;= nums[i] &lt;= 10</code></li>
</ul>

<br>

---

# Solution
- [Backtracking Approach](#backtracking-approach)
  - **Time Complexity**: `O(P(N, k))`

# Backtracking Approach

## **Overview**

Backtracking explores all potential candidates for solutions. If a candidate is not a solution, the algorithm discards it and tries another path by backtracking.

**Note**: This problem extends the permutation challenge by allowing the input array to contain ***duplicates***. Therefore, we must adapt our backtracking algorithm to ensure the *generated* solutions are unique and free from duplicates.

### **What is Backtracking?**

Backtracking incrementally finds solutions, adding one piece at a time and removing those that fail to satisfy constraints. It's often used for permutations, combinations, and other exhaustive search problems.

