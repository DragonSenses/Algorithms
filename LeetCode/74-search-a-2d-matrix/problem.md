# 74. Search a 2D Matrix

<p>You are given an <code>m x n</code> integer matrix <code>matrix</code> with the following two properties:</p>

<ul>
	<li>Each row is sorted in non-decreasing order.</li>
	<li>The first integer of each row is greater than the last integer of the previous row.</li>
</ul>

<p>Given an integer <code>target</code>, return <code>true</code> <em>if</em> <code>target</code> <em>is in</em> <code>matrix</code> <em>or</em> <code>false</code> <em>otherwise</em>.</p>

<p>You must write a solution in <code>O(log(m * n))</code> time complexity.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="img/74-1.jpg" style="width: 322px; height: 242px;">
<pre><strong>Input:</strong> matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
<strong>Output:</strong> true
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="img/74-1.jpg" style="width: 322px; height: 242px;">
<pre><strong>Input:</strong> matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
<strong>Output:</strong> false
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>m == matrix.length</code></li>
	<li><code>n == matrix[i].length</code></li>
	<li><code>1 &lt;= m, n &lt;= 100</code></li>
	<li><code>-10<sup>4</sup> &lt;= matrix[i][j], target &lt;= 10<sup>4</sup></code></li>
</ul>

<br>

---

# Solution

- [Binary Search Approach](#binary-search-approach)
  - (**Time Complexity**: `O(log(mn))`)

# Binary Search Approach

## **Intuition**

When dealing with a sorted 2D matrix, it can be conceptually flattened into a sorted 1D array of length `m * n` where `m` is the number of rows and `n` is the number of columns. This flattened array retains the sorted order and allows us to perform binary search, an efficient search algorithm.

The crucial insight is that the index in this virtual 1D array can be easily mapped to the corresponding row and column in the original 2D matrix using simple arithmetic operations:

- **Row**: `row = index // n`
- **Column**: `col = index % n`

This transformation allows us to leverage binary search to efficiently find the target value within the 2D matrix.

