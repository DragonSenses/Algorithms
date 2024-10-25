# 78. Subsets

<p>Given an integer array <code>nums</code> of <strong>unique</strong> elements, return <em>all possible</em> <strong>subsets</strong> <em>(the power set)</em>.</p>

- A **subset** of an array is a selection of elements (possibly none) of the array.

<p>The solution set <strong>must not</strong> contain duplicate subsets. Return the solution in <strong>any order</strong>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> nums = [1,2,3]
<strong>Output:</strong> [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> nums = [0]
<strong>Output:</strong> [[],[0]]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10</code></li>
	<li><code>-10 &lt;= nums[i] &lt;= 10</code></li>
	<li>All the numbers of&nbsp;<code>nums</code> are <strong>unique</strong>.</li>
</ul>

<br>

---


## **Problem Overview**

### Introduction
Given an integer array `nums` of **unique** elements, the task is to return all possible **subsets** (the power set). A subset of an array is a selection of elements (possibly none) of the array. The solution set **must not** contain duplicate subsets and can be returned in **any order**.

### Example
- **Example 1**:
  - **Input**: nums = [1,2,3]
  - **Output**: [[], [1], [2], [1,2], [3], [1,3], [2,3], [1,2,3]]

- **Example 2**:
  - **Input**: nums = [0]
  - **Output**: [[], [0]]

### Constraints
- `1 <= nums.length <= 10`
- `-10 <= nums[i] <= 10`
- All elements in `nums` are **unique**.

## Problem Comparison: Permutations, Combinations, Subsets
Let's review the problems of Permutations, Combinations, and Subsets as they are quite similar and share common strategies:

### Solution Space
- **Permutations**: \( N! \)
- **Combinations**: \( C(k, n) = \frac{n!}{k!(n - k)!} \)
- **Subsets**: \( 2^N \) (each element could be absent or present)

Given their exponential solution space, ensuring that generated solutions are complete and non-redundant is challenging. A clear and easy-to-reason strategy is essential.

### Common Strategies
1. **Iterative**
2. **Recursion/Backtracking**
3. **Lexicographic Generation**: Based on mapping binary bitmasks to the corresponding permutations/combinations/subsets.

### Preferred Method
- The **Lexicographic Generation** method can be a good candidate, especially for interviews. It simplifies the problem to the generation of binary numbers, making implementation and verification easier.
- Additionally, it generates lexicographically sorted output for sorted inputs.

### Summary
Understanding these strategies and their implications helps tackle problems related to Permutations, Combinations, and Subsets effectively. The Lexicographic Generation method stands out due to its simplicity and efficiency.

