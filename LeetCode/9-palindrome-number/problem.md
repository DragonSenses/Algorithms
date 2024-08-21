# Palindrome Number

Given an integer `x`, return `true` if `x` is a palindrome, and `false` otherwise.

**Palindrome:** An integer is a palindrome when it reads the same forward and backward.

- For example, `121` is a palindrome while `123` is not.

#### Example 1:

Input: x = 121

Output: true

Explanation: 121 reads as 121 from left to right and from right to left.

#### Example 2:

Input: x = -121

Output: false

Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.

#### Example 3:

Input: x = 10

Output: false

Explanation: Reads 01 from right to left. Therefore it is not a palindrome.

#### Constraints:

    -2^31 <= x <= 2^31 - 1

##### Follow up: Could you solve it without converting the integer to a string?

# Solution

## **Key points**

A **palindrome** is a number (or string) that reads the same forward and backward. When we reverse the digits of a palindrome, we should get the same number.

1. Negative numbers are not palindromes as we see in Example 2

```sh
Input: x = -121

Output: false

Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
```

2. Numbers ending with 0 are not palindromes

  - The issue with leading zeros is that they are not significant in the decimal system. In other words:
     - `021` is equivalent to `21`.
     - `03` is equivalent to `3`.
     - `0001` is equivalent to `1`.

  - However, there's an exception: the number `0` itself. It has only one digit, and its reverse is still `0`, so it is indeed a palindrome.

In summary, numbers ending with 0 (except for 0 itself) are not palindromes because their reversed form includes leading zeros, which are not significant.

## Algorithmic Approaches

Let's discuss some algorithmic approaches.

  - Reverse and Compare



## Java

### Reverse and Compare

```java
class Solution {
  public boolean isPalindrome(int x) {
    // Edge case: Negative numbers are not palindromes
    if (x < 0) {
      return false; 
    }

    // Edge case: Numbers ending with 0 are not palindromes
    if (x != 0 && (x & 1) == 0) {
      return false;
    }

    int original = x;
    int reversed = 0;

    while (x != 0) {
      reversed = reversed * 10 + x % 10; // Reverse the digits
      x /= 10; // Truncate the number
    }

    return original == reversed;
  }

}
```

## TypeScript

### Reverse and Compare

Here's the equivalent TypeScript code for the given Java solution with some changes:

- In TypeScript, we use `number` as the type for numeric values.
- The bitwise AND operation `(x & 1)` checks if the last bit of `x` is 0 (i.e., `x` is even).
- The `Math.trunc(x / 10)` operation truncates the number by removing the last digit.

```typescript
function isPalindrome(x: number): boolean {
  // Edge case: Negative numbers are not palindromes
  if (x < 0) {
    return false;
  }

  // Edge case: Numbers ending with 0 are not palindromes
  if (x !== 0 && (x & 1) === 0) {
    return false;
  }

  let original = x;
  let reversed = 0;

  while (x !== 0) {
    reversed = reversed * 10 + (x % 10); // Reverse the digits
    x = Math.trunc(x / 10); // Truncate the number
  }

  return original === reversed;
}
```
