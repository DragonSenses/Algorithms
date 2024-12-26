# 66. Plus One

<p>You are given a <strong>large integer</strong> represented as an integer array <code>digits</code>, where each <code>digits[i]</code> is the <code>i<sup>th</sup></code> digit of the integer. The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading <code>0</code>'s.</p>

<p>Increment the large integer by one and return <em>the resulting array of digits</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> digits = [1,2,3]
<strong>Output:</strong> [1,2,4]
<strong>Explanation:</strong> The array represents the integer 123.
Incrementing by one gives 123 + 1 = 124.
Thus, the result should be [1,2,4].
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> digits = [4,3,2,1]
<strong>Output:</strong> [4,3,2,2]
<strong>Explanation:</strong> The array represents the integer 4321.
Incrementing by one gives 4321 + 1 = 4322.
Thus, the result should be [4,3,2,2].
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> digits = [9]
<strong>Output:</strong> [1,0]
<strong>Explanation:</strong> The array represents the integer 9.
Incrementing by one gives 9 + 1 = 10.
Thus, the result should be [1,0].
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= digits.length &lt;= 100</code></li>
	<li><code>0 &lt;= digits[i] &lt;= 9</code></li>
	<li><code>digits</code> does not contain any leading <code>0</code>'s.</li>
</ul>

<br>

---

## Problem Overview

You are given a large integer represented as an integer array `digits`, where each `digits[i]` is the `i-th` digit of the integer. The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading zeros.

**Task**: Increment the large integer by one and return the resulting array of digits.

### Plus One Problem Examples

1. **Example 1**:
   - **Input**: `digits = [1, 2, 3]`
   - **Output**: `[1, 2, 4]`
   - **Explanation**: The array represents the integer `123`. Incrementing by one gives `123 + 1 = 124`. Thus, the result should be `[1, 2, 4]`.

2. **Example 2**:
   - **Input**: `digits = [4, 3, 2, 1]`
   - **Output**: `[4, 3, 2, 2]`
   - **Explanation**: The array represents the integer `4321`. Incrementing by one gives `4321 + 1 = 4322`. Thus, the result should be `[4, 3, 2, 2]`.

3. **Example 3**:
   - **Input**: `digits = [9]`
   - **Output**: `[1, 0]`
   - **Explanation**: The array represents the integer `9`. Incrementing by one gives `9 + 1 = 10`. Thus, the result should be `[1, 0]`.

### Constraints

- `1 <= digits.length <= 100`
- `0 <= digits[i] <= 9`
- `digits` does not contain any leading zeros.

### Key Concepts and Approaches

All these problems can be solved in linear time. The challenge is to solve it without using the addition operation or how to solve it in constant space complexity.

### **Choice of Algorithm Based on Input Format**

1. **Integers**:
   - Usually, the addition operation is not allowed in such cases.
   - **Approach**: Use Bit Manipulation.

2. **Strings**:
   - Use bit-by-bit computation.
   - Note: It might not always be feasible to come up with a solution with constant space for languages with immutable strings, such as Java and Python.

3. **Linked Lists**:
   - Use Sentinel Head + Schoolbook Addition with Carry.

4. **Arrays** (the current problem):
   - Use Traditional Addition with Carry.

