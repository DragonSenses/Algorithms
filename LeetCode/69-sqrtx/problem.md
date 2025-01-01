# 69. Sqrt(x)

<p>Given a non-negative integer <code>x</code>, return <em>the square root of </em><code>x</code><em> rounded down to the nearest integer</em>. The returned integer should be <strong>non-negative</strong> as well.</p>

<p>You <strong>must not use</strong> any built-in exponent function or operator.</p>

<ul>
	<li>For example, do not use <code>pow(x, 0.5)</code> in c++ or <code>x ** 0.5</code> in python.</li>
</ul>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> x = 4
<strong>Output:</strong> 2
<strong>Explanation:</strong> The square root of 4 is 2, so we return 2.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> x = 8
<strong>Output:</strong> 2
<strong>Explanation:</strong> The square root of 8 is 2.82842..., and since we round it down to the nearest integer, 2 is returned.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>0 &lt;= x &lt;= 2<sup>31</sup> - 1</code></li>
</ul>

<br>

---

## Problem Overview

### Given Problem
You are given a non-negative integer \( x \). Your task is to return the square root of \( x \) rounded down to the nearest integer. The returned integer should be non-negative. 

### Restrictions
- You must not use any built-in exponent function or operator. For example, do not use `pow(x, 0.5)` in C++ or `x ** 0.5` in Python.

### Examples
- **Example 1**:
    - Input: \( x = 4 \)
    - Output: \( 2 \)
    - Explanation: The square root of \( 4 \) is \( 2 \), so we return \( 2 \).

- **Example 2**:
    - Input: \( x = 8 \)
    - Output: \( 2 \)
    - Explanation: The square root of \( 8 \) is approximately \( 2.82842... \), and since we round it down to the nearest integer, \( 2 \) is returned.

### Additional Context
The value \( a \) we're supposed to compute could be defined as:
\[ a^2 \leq x < (a+1)^2 \]
This value is called the *integer square root*. 

#### Geometrical Interpretation
From a geometrical perspective, it represents the side of the largest integer-sided square with an area less than or equal to \( x \).

![When x = 10, we find the integer square root using the the candidates 4, 9, and 16](img/69-1.jpg)

Let's explore the relationship between 4, 9, and 16 when looking for the integer square root of \( x = 10 \).

The integer square root of \( x \) is the largest integer \( a \) such that \( a^2 \leq x \). For \( x = 10 \):

1. **4**: \( 2^2 = 4 \). This is less than 10, so \( 2 \) is a possible candidate.
2. **9**: \( 3^2 = 9 \). This is also less than 10, so \( 3 \) is another candidate.
3. **16**: \( 4^2 = 16 \). This is greater than 10, so \( 4 \) is not a candidate.

The largest integer whose square is less than or equal to 10 is \( 3 \). However, we are looking for the integer part of the square root, rounded down. The square root of 10 is approximately \( 3.162 \), and rounding down gives us \( 3 \).

So, the integer square root of \( x = 10 \) is \( 3 \).

Here's the relationship in summary:
- 4: \( 2^2 \)
- 9: \( 3^2 \)
- 16: \( 4^2 \)

Since 10 lies between 9 and 16, the integer square root is the one corresponding to \( 3 \). 

