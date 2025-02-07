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
  - **Time Complexity**: `O(max(N, M))`
  - **Space Complexity**: `O(max(N, M))`
-  [Bit Manipulation Approach](#bit-manipulation-approach)
  - **Time Complexity**: `O(N + M)`
  - **Space Complexity**: `O(max(N, M))`

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
  /**
   * Adds two binary strings and returns their sum as a binary string.
   *
   * @param a The first binary string.
   * @param b The second binary string.
   * @return The sum of the two binary strings as a binary string.
   */
  public String addBinary(String a, String b) {
    StringBuilder result = new StringBuilder();
    int carry = 0;
    int i = a.length() - 1;
    int j = b.length() - 1;

    // Iterate from the end of both strings towards the beginning
    while (i >= 0 || j >= 0) {
      int sum = carry;
      if (i >= 0) {
        // Convert the character to its integer value by subtracting '0'
        sum += a.charAt(i--) - '0';
      }
      if (j >= 0) {
        // Convert the character to its integer value by subtracting '0'
        sum += b.charAt(j--) - '0';
      }
      // Append the current bit to the result
      result.append(sum % 2);
      // Update the carry
      carry = sum / 2;
    }

    // If there's a remaining carry, append it
    if (carry != 0) {
      result.append(carry);
    }

    // Reverse the result to get the correct binary sum
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

## **Complexity Analysis**

### Assumptions

- Let `N` be the length of the binary string `a`.
- Let `M` be the length of the binary string `b`.

### **Time Complexity**: `O(max(N, M))`

The time complexity of this algorithm is `O(max(N, M))`. Here's why:

1. **Bit-by-Bit Iteration**:
   - We iterate over each bit of the binary strings `a` and `b` from right to left.
   - The loop runs for the maximum length of the two strings, which is `max(N, M)`.
   - Inside the loop, all operations (bit addition, carry update, and appending to the result) are constant-time operations `O(1)`.

2. **Final Carry Handling**:
   - After the loop, we check and append the carry if it exists, which is also a constant-time operation `O(1)`.

3. **Reversing the Result**:
   - The final step involves reversing the result string, which takes linear time `O(max(N, M))`.

Combining these steps, the overall time complexity is `O(max(N, M))`.

### **Space Complexity**: `O(max(N, M))`

The space complexity of this algorithm is `O(max(N, M))`. Here's why:

1. **Result Storage**:
   - The `StringBuilder` used to store the result will contain at most `max(N, M) + 1` characters (in case there is an additional carry).
   - Therefore, the space required for the result is `O(max(N, M))`.

2. **Carry Handling**:
   - The carry is a single integer variable, which requires constant space `O(1)`.

3. **Final Result**:
   - The final string constructed from the `StringBuilder` will also have a length of at most `max(N, M) + 1`, requiring `O(max(N, M))` space.

Therefore, the overall space complexity is `O(max(N, M))`.

### Key Points

- **Efficiency**: The algorithm processes each bit of the input strings once, making it efficient with linear time complexity relative to the lengths of the input strings.
- **Scalability**: It handles large binary strings effectively, ensuring that the space used is proportional to the length of the longer input string.
- **Simplicity**: The algorithm's bit-by-bit addition approach provides a straightforward and clear method for summing binary strings without converting to and from decimal.

# Bit Manipulation Approach

Using bit manipulation efficiently handles the addition of binary strings without using conventional addition operations, making it well-suited for handling large inputs.

### **Challenge**

A variation of the add binary strings problem is to sum them ***without using the addition operation***.

## **Intuition**

When addition is restricted, bit manipulation becomes the key. An effective strategy for bit manipulation problems is to start by computing the XOR of the input data. This technique is applicable to numerous problems, such as Single Number II, Single Number III, Maximum XOR of Two Numbers in an Array, Repeated DNA Sequences, Maximum Product of Word Lengths, and more.

In this context, XOR is crucial because it performs binary addition without accounting for the carry. 

![Finds the sum of two binary strings "1111" and "0010" without accounting for the carry](img/67-1.jpg)

The current carry can be obtained by computing the AND of the two input numbers and then shifting it one bit to the left.

![Finds the carry of two binary strings "1111" and "0010"](img/67-2.jpg)

This reduces the problem to a simpler one: finding the sum of the result without the carry and the carry itself. This can be iteratively solved in a loop with the condition "while carry is not zero".

### Introduction to Bit Manipulation

When addition operations are not allowed, bit manipulation becomes a key technique. A useful tip for bit manipulation problems is to start by computing the XOR of the input data. This technique helps in a wide range of problems, including finding single numbers, maximum XOR values, and more.

### Understanding XOR and Carry

In binary addition, XOR plays a crucial role because it adds two binary numbers without considering the carry. To handle the carry, we compute the AND of the two input numbers and then shift it one bit to the left. This approach effectively breaks down the problem into manageable steps.

### Iterative Summation

With the understanding of XOR and carry:
1. **Start with a Carry of Zero**:
    - Initialize the carry to zero.
2. **Bit-by-Bit Processing**:
    - Process each bit of the two binary strings using XOR and AND operations.
    - XOR provides the current bit of the result without carry.
    - AND, followed by a left shift, gives the carry for the next bit.
3. **Repeat Until Carry is Zero**:
    - Continue the process until there is no carry left.
4. **Construct the Result**:
    - Reverse the accumulated bits to form the final binary sum.

### Key Points

- XOR computes the sum of the bits without carry.
- AND followed by a left shift computes the carry.
- The process is iterated until there are no more carries left.
- The final binary result is constructed by reversing the accumulated bits.

## **Algorithm**

1. **Convert**: Convert `a` and `b` into integers `x` and `y`.
   - `x` will hold the result of the addition.
   - `y` will hold the carry.

2. **Iterate**: While the carry `y` is nonzero (`y != 0`):
   - Calculate the current result without the carry as the XOR of `x` and `y`: `x = x ^ y`.
   - Calculate the current carry as the left-shifted AND of `x` and `y`: `y = (x & y) << 1`.

3. **Update**: Assign the newly calculated result to `x` and the carry to `y`.

4. **Return**: Once the loop exits, return `x` converted back to a binary string.

## **Implementation**

### Java

```java
import java.math.BigInteger;

class Solution3 {
  /**
   * Adds two binary strings using bit manipulation and returns their sum as a binary string.
   *
   * @param a The first binary string.
   * @param b The second binary string.
   * @return The sum of the two binary strings as a binary string.
   */
  public String addBinary(String a, String b) {
    // Convert binary strings to BigInteger objects
    BigInteger x = new BigInteger(a, 2);
    BigInteger y = new BigInteger(b, 2);

    // Define a BigInteger object representing zero
    BigInteger zero = new BigInteger("0", 2);

    BigInteger carry, answer;

    // Loop until there is no carry left
    while (y.compareTo(zero) != 0) {
      // XOR the two numbers to get the sum without carry
      answer = x.xor(y);

      // AND the two numbers and shift left to get the carry
      carry = x.and(y).shiftLeft(1);

      // Update x to the current answer
      x = answer;

      // Update y to the current carry
      y = carry;
    }

    // Convert the result back to a binary string and return it
    return x.toString(2);
  }
}
```

### Explanation

- **Convert**: Binary strings `a` and `b` are converted into `BigInteger` objects `x` and `y`.
- **Iteration**: As long as `y` (the carry) is not zero, compute the XOR of `x` and `y` for the current result and the left-shifted AND of `x` and `y` for the carry.
- **Update**: Update `x` to be the current result without the carry and `y` to be the new carry.
- **Return**: Once there is no carry left, convert `x` back to a binary string and return it.

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
  // Convert binary strings to BigInt
  let x = BigInt(`0b${a}`);
  let y = BigInt(`0b${b}`);

  // Loop until there is no carry
  while (y !== 0n) {
    // Current answer without carry is XOR of x and y
    const answer = x ^ y;
    // Current carry is left-shifted AND of x and y
    const carry = (x & y) << 1n;
    // Prepare for the next loop
    x = answer;
    y = carry;
  }

  // Convert the final result back to a binary string
  return x.toString(2);
};
```

### Explanation

1. **Function Signature**: The function `addBinary` takes two binary string inputs `a` and `b`, and returns their sum as a binary string.

2. **Convert Binary Strings to BigInt**: 
   - `BigInt("0b" + a)` converts the binary string `a` to a BigInt.
   - `BigInt("0b" + b)` converts the binary string `b` to a BigInt.

3. **Bit-by-Bit Processing**:
   - The loop continues until `y` (carry) is zero.
   - Within the loop:
     - `answer = x ^ y` computes the sum of the bits without the carry.
     - `carry = (x & y) << 1n` computes the carry for the next bit position.
     - `x` is updated to `answer`.
     - `y` is updated to `carry`.

4. **Return Result**:
   - After the loop, the final result `x` is converted back to a binary string using `x.toString(2)`.

### Python

```python
class Solution:
    def addBinary(self, a: str, b: str) -> str:
        x, y = int(a, 2), int(b, 2)
        while y:
            x, y = x ^ y, (x & y) << 1
        return bin(x)[2:]
```

## Performance Discussion

When dealing with very large input numbers, such as those exceeding `2^100`, the choice of language and data type becomes crucial.

### Java
- **BigInteger**: In Java, `BigInteger` is used to handle very large numbers, but it comes with a performance cost due to its complexity and overhead.
- **Integers and Longs**: The Java solution could be optimized by using primitive data types like `int` or `long` for smaller numbers. However, for very large numbers, `BigInteger` remains necessary, albeit slower.

### Python
- **Dynamic Typing**: Python's `int` type inherently supports arbitrary-precision arithmetic, making it more efficient for handling large numbers without additional overhead.
- **Simplicity and Performance**: The Python solution benefits from Python's dynamic typing, providing a performance advantage for large inputs compared to Java's `BigInteger`.

### TypeScript
- **BigInt**: TypeScript provides the `BigInt` type for handling very large integers, which supports arbitrary-precision arithmetic similar to Python's `int`.
- **Simplicity and Performance**: The use of `BigInt` in TypeScript allows for efficient handling of large binary strings without the overhead associated with Java's `BigInteger`. This makes the TypeScript solution both simple and performant for large inputs.

In summary, both Python and TypeScript offer efficient solutions for handling large binary numbers due to their support for arbitrary-precision arithmetic, while Java's `BigInteger` provides a necessary but slower solution for very large inputs.

## **Complexity Analysis**

### Assumptions

- Let `N` be the length of the binary string `a`.
- Let `M` be the length of the binary string `b`.

### **Time Complexity**: `O(N + M)`

The time complexity of this algorithm is `O(N + M)`.

1. **Bit Conversion**:
   - Converting the binary strings `a` and `b` to integers `x` and `y` takes `O(N)` and `O(M)` time, respectively.
2. **Bit-by-Bit Processing**:
   - The loop iterates until the carry is zero. In each iteration, it processes all bits, making the total time complexity dependent on the length of the input strings.
   - Since the number of iterations is bounded by the length of the binary strings, the loop runs for `O(N + M)` iterations in the worst case.
3. **Binary Conversion**:
   - Converting the integer result back to a binary string takes linear time in the number of bits, which is `O(N + M)`.

Combining these steps, the overall time complexity is `O(N + M)`.

### **Space Complexity**: `O(max(N, M))`

The space complexity of this algorithm is `O(max(N, M))`.

1. **Storage for Integers**:
   - The space required to store the integers `x` and `y` is proportional to the number of bits in the binary strings, which is `O(N)` for `a` and `O(M)` for `b`.
2. **Intermediate Results**:
   - During each iteration of the loop, intermediate results are stored in `x` and `y`, but this does not require additional space beyond what is needed for `x` and `y`.
3. **Final Binary String**:
   - The final result is a binary string whose length is at most the sum of the lengths of the input strings, requiring `O(N + M)` space.

Therefore, the overall space complexity is `O(max(N, M))`.

### Key Points

- **Efficiency**: The algorithm effectively processes each bit of the input strings, ensuring linear time complexity relative to the lengths of the input strings.
- **Scalability**: It handles very large binary strings efficiently, with space usage proportional to the length of the longer input string.
- **Simplicity**: The bit manipulation approach simplifies the addition process, eliminating the need for conventional addition operations.
