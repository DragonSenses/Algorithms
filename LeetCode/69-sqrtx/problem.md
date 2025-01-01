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

