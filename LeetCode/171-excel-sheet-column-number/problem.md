# 171. Excel Sheet Column Number

<p>Given a string <code>columnTitle</code> that represents the column title as appears in an Excel sheet, return <em>its corresponding column number</em>.</p>

<p>For example:</p>

<pre>A -&gt; 1
B -&gt; 2
C -&gt; 3
...
Z -&gt; 26
AA -&gt; 27
AB -&gt; 28 
...
</pre>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> columnTitle = "A"
<strong>Output:</strong> 1
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> columnTitle = "AB"
<strong>Output:</strong> 28
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> columnTitle = "ZY"
<strong>Output:</strong> 701
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= columnTitle.length &lt;= 7</code></li>
	<li><code>columnTitle</code> consists only of uppercase English letters.</li>
	<li><code>columnTitle</code> is in the range <code>["A", "FXSHRXW"]</code>.</li>
</ul>

# Solution

- [Base-26 Conversion Apprch Approach](#base-26-conversion-approach)

## **Problem Overview: Excel Sheet Column Number**

This problem is essentially a **base-26 conversion** problem.

Excel column titles behave similarly to digits in a number system:

| Letter | Value |
|----------|----------|
| A | 1 |
| B | 2 |
| ... | ... |
| Z | 26 |

Unlike normal base-26, Excel does **not** use a `0` digit. Instead:

```text
A  = 1
Z  = 26
AA = 27
AB = 28
```

The goal is to convert an Excel column title into its corresponding decimal number.

### Key Insight

Process the string from **left to right**.

For each character:

1. Multiply the current result by `26`.
2. Add the character's value (`A = 1`, `B = 2`, ..., `Z = 26`).

This is identical to how we evaluate numbers in other bases.

### Pattern

When you see:

Letters mapped to numeric digits
Repeated multiplication by a base
String-to-number conversion

Think:

Positional number system conversion
(Base-N conversion)

This is the core pattern behind this problem.

#### Example

```text
AB

A = 1
B = 2

result = 0

result = 0 * 26 + 1 = 1
result = 1 * 26 + 2 = 28
```

**Answer:** `28`

## Example Walkthrough

### Example 1

```text
columnTitle = "A"

result = 0

result = 0 * 26 + 1
       = 1
```

**Answer:**

```text
1
```

### Example 2

```text
columnTitle = "AB"

result = 0

A:
result = 0 * 26 + 1
       = 1

B:
result = 1 * 26 + 2
       = 28
```

**Answer:**

```text
28
```

### Example 3

```text
columnTitle = "ZY"

Z = 26
Y = 25

result = 0

Z:
result = 0 * 26 + 26
       = 26

Y:
result = 26 * 26 + 25
       = 701
```

**Answer:**

```text
701
```

## Formula

For each character:

```text
value = character - 'A' + 1

result = result * 26 + value
```

# Base-26 Conversion Approach

## **Intuition**

Excel column titles follow a positional numbering system similar to base-26.

Each character represents a value from `1` to `26`:

```text
A = 1
B = 2
...
Z = 26
```

Just like digits in base-10, the position of each character determines its contribution to the final number.

For example:

```text
AB

A contributes: 1 * 26^1
B contributes: 2 * 26^0

= 26 + 2
= 28
```

Rather than explicitly calculating powers of `26`, we can build the result incrementally from left to right.

At each character:

1. Shift the current result one position to the left by multiplying by `26`.
2. Add the value of the current character.

This is the same process used when converting a number from any positional number system into decimal.

## **Algorithm**

1. Initialize a variable `result` to `0`.
2. Traverse each character in `columnTitle` from left to right.
3. Convert the current character into its corresponding value:
   - `A = 1`
   - `B = 2`
   - ...
   - `Z = 26`
4. Multiply the current `result` by `26` to make room for the new digit.
5. Add the current character's value to `result`.
6. Continue until all characters have been processed.
7. Return `result`.

For example, for `"AB"`:

```text
result = 0

Process 'A':
result = 0 * 26 + 1
       = 1

Process 'B':
result = 1 * 26 + 2
       = 28
```

Return:

```text
28
```