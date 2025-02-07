# 59. Spiral Matrix II

<p>Given a positive integer <code>n</code>, generate an <code>n x n</code> <code>matrix</code> filled with elements from <code>1</code> to <code>n<sup>2</sup></code> in spiral order.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="img/59-1.jpg" style="width: 242px; height: 242px;">
<pre><strong>Input:</strong> n = 3
<strong>Output:</strong> [[1,2,3],[8,9,4],[7,6,5]]
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> n = 1
<strong>Output:</strong> [[1]]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= n &lt;= 20</code></li>
</ul>

<br>

---

# Solution

- [Spiral Traversal Approach](#spiral-traversal)

## Problem Overview: Spiral Matrix II

**Task**: Given a positive integer `n`, generate an `n x n` matrix filled with elements from `1` to `n^2` in spiral order.

**Examples**:
1. **Example 1**:
    - **Input**: `n = 3`
    - **Output**: `[[1, 2, 3], [8, 9, 4], [7, 6, 5]]`

2. **Example 2**:
    - **Input**: `n = 1`
    - **Output**: `[[1]]`

**Constraints**:
- `1 <= n <= 20`

**Explanation**: 
The matrix should start with the number `1` at the top-left corner and proceed in a clockwise spiral order filling up to `n^2`. For example, with `n = 3`, the matrix is:
```
1 -> 2 -> 3
         |
8 <- 9   4
|       |
7 <- 6 <- 5
```

For `n = 1`, the matrix is simply:
```
1
```

# Spiral Traversal

The key idea is to recognize the repeating pattern of moving in a circular or spiral manner from the outermost layer towards the innermost layer.

Imagine the matrix is composed of layers or concentric rectangles. The outermost elements form the first layer, the next set of elements forms the second layer, and so on. Each layer can be traversed in four distinct steps: right, down, left, and up.
