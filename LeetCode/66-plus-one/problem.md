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

# Solution

- [Traditional Addition with Carry Approach](#traditional-addition-with-carry)

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

# Traditional Addition with Carry

## **Intuition**

To increment a large integer represented as an array of digits, we need to manage the carry that results from the addition, especially when the digits include the value `9`. The key is to identify the rightmost digit that is not `9`, increment it by one, and set all following consecutive `9`s to zero. If all digits are `9`, we need to handle the overflow by adding a new leading digit `1`.

### Steps

1. **Move along the input array starting from the end**:
    - This ensures we handle the least significant digit first.

2. **Set all the nines at the end of the array to zero**:
    - If the last digits are `9`, they need to become `0` after the increment.

3. **Increment the first not-nine digit**:
    - When we encounter a digit that is not `9`, increment it by one. This stops the carry, and the job is done.

4. **Handle the case where all digits are `9`**:
    - If all digits were `9`, they will all have been set to `0`. We need to append a leading `1` to handle this overflow.

### Use Cases

1. **Simple Increment**:
    - **Input**: `digits = [1, 2, 3]`
    - **Output**: `[1, 2, 4]`
    - **Explanation**: The array represents `123`. Incrementing by one gives `123 + 1 = 124`.

2. **Handling Trailing Nines**:
    - **Input**: `digits = [4, 3, 2, 9, 9]`
    - **Output**: `[4, 3, 3, 0, 0]`
    - **Explanation**: The array represents `43299`. Incrementing by one gives `43300`.

3. **All Nines**:
    - **Input**: `digits = [9, 9, 9]`
    - **Output**: `[1, 0, 0, 0]`
    - **Explanation**: The array represents `999`. Incrementing by one gives `1000`.

## **Algorithm**

### Key Steps

1. **Initialize Variables**:
    - We don't need an explicit carry variable; instead, handle the logic directly within the loop.

2. **Traverse the Array from Right to Left**:
    - Start from the least significant digit and move towards the most significant digit.
    - If the current digit is `9`, set it to `0`.
    - If the current digit is not `9`, increment it by one and return the array.

3. **Handle Edge Case**:
    - If all digits were `9`, the loop will complete with all digits set to `0`.
    - In this case, insert `1` at the beginning of the array.

4. **Return the Resulting Array**:
    - The updated array represents the incremented integer.

### Pseudocode

```typescript
function incrementDigits(digits: number[]): number[] {
    for (let i = digits.length - 1; i >= 0; i--) {
        if (digits[i] === 9) {
            digits[i] = 0;
        } else {
            digits[i]++;
            return digits;
        }
    }
    digits.unshift(1);
    return digits;
}
```

### Key Points

- **Efficiency**: The algorithm processes the input array in a single pass (O(N) time complexity).
- **Scalability**: It handles edge cases, such as when all digits are `9`, by dynamically adjusting the array size.
- **Simplicity**: Incrementing digits directly and managing carry within the loop makes the implementation straightforward and easy to understand.

## Implementation

### Java

```java
class Solution {
  /**
   * Increment the given array of digits representing a large integer by one.
   *
   * @param digits The array of digits representing the large integer.
   * @return The array of digits after incrementing by one.
   */
  public int[] plusOne(int[] digits) {
    // Traverse the array from the end (least significant digit) to the start (most significant
    // digit)
    for (int i = digits.length - 1; i >= 0; i--) {
      // If the current digit is not 9, increment it by one and return the result
      if (digits[i] != 9) {
        digits[i]++;
        return digits;
      }
      // If the current digit is 9, set it to 0 and continue the loop
      digits[i] = 0;
    }

    // If all digits were 9, we need to add an extra 1 at the beginning of the array
    int[] result = new int[digits.length + 1];
    result[0] = 1; // The rest of the array is already initialized to 0s

    return result;
  }
}
```

### TypeScript

```typescript
/**
 * Increment the given array of digits representing a large integer by one.
 *
 * @param {number[]} digits - The array of digits representing the large integer.
 * @returns {number[]} - The array of digits after incrementing by one.
 */
function plusOne(digits: number[]): number[] {
  // Traverse the array from the end (least significant digit) to the start (most significant digit)
  for (let i = digits.length - 1; i >= 0; i--) {
    // If the current digit is not 9, increment it by one and return the result
    if (digits[i] !== 9) {
      digits[i]++;
      return digits;
    }
    // If the current digit is 9, set it to 0 and continue the loop
    digits[i] = 0;
  }

  // If all digits were 9, we need to add an extra 1 at the beginning of the array
  digits.unshift(1);

  return digits;
};
```

#### Implementation Explanation:

1. **Traverse the Array from Right to Left**:
   - We start from the least significant digit (rightmost) and move towards the most significant digit (leftmost).

2. **Check and Increment**:
   - If the current digit is not `9`, increment it by one and return the modified array.
   - If the current digit is `9`, set it to `0` and continue the loop to handle the carry over to the next more significant digit.

3. **Handle Edge Case (All Nines)**:
   - If all digits are `9`, after the loop completes, we need to add a new leading digit `1` to handle the overflow.
   - Use `digits.unshift(1);` to insert `1` at the beginning of the array.



