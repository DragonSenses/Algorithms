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
  - **Time Complexity**: `O(N + M)`
  - **Space Complexity**: `O(N + M)`
- [Bit-by-Bit Computation](#bit-by-bit-computation)

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

### TypeScript

```typescript
/**
 * Adds two binary strings and returns their sum as a binary string.
 *
 * @param {string} a - The first binary string.
 * @param {string} b - The second binary string.
 * @returns {string} - The sum of the two binary strings as a binary string.
 */
function addBinary(a: string, b: string): string {
  // Convert both binary string inputs into BigInt using the "0b" prefix
  const sum = BigInt("0b" + a) + BigInt("0b" + b);
  // Convert the resulting BigInt sum back to a binary string and return it
  return sum.toString(2);
}
```

## **Complexity Analysis**

### Assumptions

- Let `N` be the length of the binary string `a`.
- Let `M` be the length of the binary string `b`.

### **Time Complexity**: `O(N + M)`

1. **Conversion to Integers**:
   - `Integer.parseInt(a, 2)` converts the binary string `a` into an integer. This operation scans each character of the string, taking `O(N)` time.
   - `Integer.parseInt(b, 2)` converts the binary string `b` into an integer, taking `O(M)` time.

2. **Addition**:
   - The addition of two integers, `Integer.parseInt(a, 2) + Integer.parseInt(b, 2)`, is efficient and operates in constant time, `O(1)`, since Java handles integer addition natively.

3. **Conversion Back to Binary String**:
   - The final conversion of the result back into a binary string, `Integer.toBinaryString()`, involves scanning the resulting integer, which takes `O(N + M)` time in the worst case (where the length of the resulting binary string is approximately the sum of the lengths of the input strings).

Combining these steps, the overall time complexity is `O(N) + O(M) + O(1) + O(N + M)`, which simplifies to `O(N + M)`.

### **Space Complexity**: `O(N + M)`

1. **Storage for Integer Conversion**:
   - The conversion of binary strings `a` and `b` into integers requires space proportional to the lengths of the input strings. This is `O(N)` for `a` and `O(M)` for `b`.

2. **Result Storage**:
   - The resulting integer from the addition will be stored, and its size could be up to the sum of the lengths of the input strings. Therefore, the space required to store the result is `O(N + M)`.

3. **Final Binary String**:
   - The final binary string representation of the result, `Integer.toBinaryString()`, will require space proportional to the length of the resulting binary string, which can be `O(N + M)` in the worst case.

Therefore, the overall space complexity is `O(N + M)`.

# Bit-by-Bit Computation

The bit-by-bit computation method efficiently adds two binary strings without converting them to decimal, making it suitable for handling large inputs.

## **Intuition**

To add two binary strings without converting them to decimal and back, we can use a bit-by-bit addition approach, much like how addition is performed manually. We start from the least significant bit (rightmost bit) and move towards the most significant bit (leftmost bit), maintaining a carry that propagates through the addition process.

### Steps

1. **Initialize Carry**:
   - Start with a carry of `0`.

2. **Bit-by-Bit Addition**:
   - Iterate over each bit of the binary strings from right to left.
   - For each bit, add the corresponding bits of the two binary strings and the current carry.
   - Determine the new value of the current bit and update the carry for the next more significant bit.

3. **Handle Remaining Carry**:
   - If there is any carry left after processing all bits, append it to the result.

4. **Construct the Result**:
   - Collect the results of each bit addition in reverse order.
   - Reverse the collected result to get the correct binary sum.

## **Algorithm**

1. Initialize a carry variable to `0`.
2. Initialize an empty result string or list.
3. Iterate from the end of both binary strings towards the beginning:
   - Convert the current bits of `a` and `b` to integers.
   - Compute the sum of the current bits and the carry.
   - Append the least significant bit of the sum (current bit of the result) to the result.
   - Update the carry to the most significant bit of the sum.
4. If a carry remains after the loop, append it to the result.
5. Reverse the result string or list to get the final binary sum.

## **Implementation**

### Java 

```java
class Solution2 {
  public String addBinary(String a, String b) {
    StringBuilder result = new StringBuilder();
    int carry = 0;
    int i = a.length() - 1;
    int j = b.length() - 1;

    while (i >= 0 || j >= 0) {
      int sum = carry;
      if (i >= 0) {
        sum += a.charAt(i--) - '0';
      }
      if (j >= 0) {
        sum += b.charAt(j--) - '0';
      }

      result.append(sum % 2);

      carry = sum / 2;
    }


    if (carry != 0) {
      result.append(carry);
    }

    return result.reverse().toString();
  }
}
```

#### Implementation Details

- **Initialize Variables**: We use a `StringBuilder` to build the result, and an integer `carry` to store the carry.
  
- **Iterate from End to Beginning**: We iterate over the bits of both strings from right to left. For each bit:
  - Convert the character to its integer value by subtracting the ASCII value of `'0'`:
    - Characters `'0'` and `'1'` have ASCII values of 48 and 49, respectively.
    - Subtracting `'0'` (ASCII value 48) from a character converts it to its corresponding integer value (`'0'` to 0 and `'1'` to 1).
    - This conversion allows us to perform arithmetic operations on the binary digits.

- **Update Result and Carry**: We append the least significant bit of the sum to the result and update the carry to the most significant bit of the sum.

- **Handle Remaining Carry**: After the loop, if there's any remaining carry, we append it to the result.

- **Reverse Result**: Finally, we reverse the `StringBuilder` to get the correct binary sum.

### TypeScript

```typescript
/**
 * Adds two binary strings and returns their sum as a binary string.
 *
 * @param {string} a - The first binary string.
 * @param {string} b - The second binary string.
 * @returns {string} - The sum of the two binary strings as a binary string.
 */
function addBinary(a: string, b: string): string {
  let result: string[] = [];
  let carry = 0;
  let i = a.length - 1;
  let j = b.length - 1;

  // Iterate from the end of both strings towards the beginning
  while (i >= 0 || j >= 0) {
    let sum = carry;
    if (i >= 0) {
      // Convert the character to its integer value by subtracting '0'
      sum += parseInt(a.charAt(i--));
    }
    if (j >= 0) {
      // Convert the character to its integer value by subtracting '0'
      sum += parseInt(b.charAt(j--));
    }
    // Append the current bit to the result
    result.push((sum % 2).toString());
    // Update the carry
    carry = Math.floor(sum / 2);
  }

  // If there's a remaining carry, append it
  if (carry !== 0) {
    result.push(carry.toString());
  }

  // Reverse the result to get the correct binary sum
  return result.reverse().join("");
}
```

#### Implementation Details

- **Initialize Variables**:
  - Use a `string[]` array named `result` to build the resulting binary string.
  - Initialize an integer `carry` to store the carry during addition.
  - Use integer indices `i` and `j` to traverse the binary strings `a` and `b` from the end towards the beginning.

- **Iterate from End to Beginning**:
  - Traverse the binary strings from right to left using the indices `i` and `j`.
  - For each bit:
    - Convert the character to its integer value by using `parseInt`:
      - Characters `'0'` and `'1'` have ASCII values of 48 and 49, respectively.
      - `parseInt` converts these characters to their corresponding integer values (`'0'` to 0 and `'1'` to 1).
      - This conversion facilitates arithmetic operations on the binary digits.

- **Update Result and Carry**:
  - Compute the sum of the corresponding bits from `a`, `b`, and the current `carry`.
  - Append the least significant bit of the sum (i.e., `sum % 2`) to the `result` array.
  - Update the `carry` to the most significant bit of the sum (i.e., `carry = Math.floor(sum / 2)`).

- **Handle Remaining Carry**:
  - After the loop, if there is any remaining carry, append it to the `result` array.

- **Reverse Result**:
  - Reverse the `result` array to construct the correct binary sum.
  - Join the `result` array elements to form the final binary string.