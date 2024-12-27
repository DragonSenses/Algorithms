# 67. Add Binary

<p>Given two binary strings <code>a</code> and <code>b</code>, return <em>their sum as a binary string</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<pre><strong>Input:</strong> a = "11", b = "1"
<strong>Output:</strong> "100"
</pre><p><strong class="example">Example 2:</strong></p>
<pre><strong>Input:</strong> a = "1010", b = "1011"
<strong>Output:</strong> "10101"
</pre>
<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= a.length, b.length &lt;= 10<sup>4</sup></code></li>
	<li><code>a</code> and <code>b</code> consist&nbsp;only of <code>'0'</code> or <code>'1'</code> characters.</li>
	<li>Each string does not contain leading zeros except for the zero itself.</li>
</ul>

<br>

---

# Solution

- [Using Built-In Functions (Naive Approach)](#using-built-in-functions-naive-approach)

## Problem Overview

Given two binary strings `a` and `b`, return their sum as a binary string.

### Examples

**Example 1**:

- **Input**: `a = "11"`, `b = "1"`
- **Output**: `"100"`

**Example 2**:

- **Input**: `a = "1010"`, `b = "1011"`
- **Output**: `"10101"`

### Constraints

- `1 <= a.length, b.length <= 10^4`
- `a` and `b` consist only of '0' or '1' characters.
- Each string does not contain leading zeros except for the zero itself.

### Drawbacks of Using Built-In Functions

Using built-in functions to solve this problem can have some drawbacks, particularly in a technical interview setting. The overall algorithm has `O(N + M)` time complexity and two significant drawbacks:

1. **Limitation by Input Length**:
   - In languages like Java, this approach is limited by the length of the input strings `a` and `b`. As the length increases, converting these strings into integers might exceed the limits of data types like `Integer`, `Long`, or even `BigInteger`.
     - For example:
       - 33 1-bits: doesn't fit into `Integer`.
       - 65 1-bits: doesn't fit into `Long`.
       - 500,000,001 1-bits: doesn't fit into `BigInteger`.
   - To fix this issue, you could use the standard Bit-by-Bit Computation approach, suitable for longer input strings.

2. **Performance Issues**:
   - This method can have relatively low performance for large input numbers, as the conversion and computation may become expensive.

# Using Built-In Functions (Naive Approach)

Using built-in functions is a quick and straightforward approach but comes with limitations, especially for large input sizes. To handle larger inputs efficiently, a bit-by-bit computation method is recommended.

## **Intuition**

We can compute the sum of two binary strings using built-in functions to handle the conversion between binary strings and integers.

- In Java, we can use the `Integer` class's `toBinaryString()` method.
- In TypeScript, we can use `BigInt` for the conversion and computation.

## **Algorithm**

1. **Convert**: Convert the binary strings `a` and `b` into integers.
2. **Sum**: Compute the sum of these integers.
3. **Convert Back**: Convert the resulting sum back into a binary string and return the result.

## **Implementation**

### Java

```java
class Solution {
  /**
   * Adds two binary strings and returns their sum as a binary string.
   *
   * @param a The first binary string.
   * @param b The second binary string.
   * @return The sum of the two binary strings as a binary string.
   */
  public String addBinary(String a, String b) {
    return Integer.toBinaryString(Integer.parseInt(a, 2) + Integer.parseInt(b, 2));
  }
}
```

