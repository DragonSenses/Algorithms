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

3. Single digit numbers are palindromes
     - In base 10, there are ten palindromic numbers with one digit: `{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}`

## Algorithmic Approaches

Let's discuss some algorithmic approaches.

  - Reverse and Compare
  - Reverse half of the number

### Reverse and Compare

The naive approach is to create the reverse of the integer argument to compare with the original.

#### Algorithm

1. **Input Validation:**
   - The function `IsPalindrome` takes an integer `x` as input.
   - If `x` is negative, it immediately returns `false` because negative numbers are not palindromes.
   - If `x` is not zero and its last digit is zero (e.g., 120), it also returns `false` because numbers ending with zero cannot be palindromes (except for zero itself).

2. **Reversing the Number:**
   - The `while` loop continues until `x` becomes zero.
   - In each iteration:
     - The last digit of `x` (obtained using `x % 10`) is added to the `reversed` variable after shifting it left by one decimal place (i.e., multiplying by 10).
     - The last digit is removed from `x` by dividing it by 10 (`x /= 10`).
   - This process effectively reverses the digits of the original number.

3. **Comparison:**
   - After the loop, the `original` variable still holds the original number, and `reversed` contains the reversed number.
   - The function returns `true` if `original` equals `reversed`, indicating that the number is a palindrome; otherwise, it returns `false`.

```java
public class Solution {
    public bool IsPalindrome(int x) {
        if (x < 0) return false; // Negative numbers are not palindromes
        if (x != 0 && x % 10 == 0) return false; // Numbers ending with 0 are not palindromes

        int original = x; // Store the original number
        int reversed = 0; // Initialize a variable to store the reversed number

        while (x != 0) {
            reversed = reversed * 10 + x % 10; // Reverse the digits
            x /= 10; // Remove the last digit from the original number
        }

        return original == reversed; // Compare original and reversed numbers
    }
}
```

**Issue**: integer overflow may occur in the case where the reversed number is larger than the maximum integer. So we need to ensure that we operate within the constraints `-2^31 <= x <= 2^31 - 1`.

##### Reverse and Compare: signed 32-bit constraint

```java
class Solution {
  public boolean isPalindrome(int x) {
    // Edge case: Negative numbers are not palindromes
    if (x < 0) {
      return false; 
    }

    // Edge case: Single-digit numbers are always palindromes
    if (x >= 0 && x < 10) {
      return true;
    }

    // Edge case: Numbers ending with 0 are not palindromes
    if (x != 0 && ((x % 10) == 0)) {
      return false;
    }

    // final int MIN_INT32 = Integer.MIN_VALUE; //-2147483648
    // final int MAX_INT32 = Integer.MAX_VALUE; // 2147483647

    final int MIN_DIVIDED_BY_10 = Integer.MIN_VALUE / 10; // -214748364
    final int MAX_DIVIDED_BY_10 = Integer.MAX_VALUE / 10; //  214748364

    final int MIN_LAST_DIGIT = Integer.MIN_VALUE % 10; // 8
    final int MAX_LAST_DIGIT = Integer.MAX_VALUE % 10; // 7

    int original = x;
    int reversed = 0;
    int digit;

    while (x != 0) {
      digit = x % 10;

      // Constraint: reversing result is greater than maximum signed 32-bit integer
      if (reversed > MAX_DIVIDED_BY_10 || 
        (reversed == MAX_DIVIDED_BY_10 && digit >= MAX_LAST_DIGIT)) {
        return false;
      }
      
      // Constraint: reversing result is less than minimum signed 32-bit integer
      if (reversed < MIN_DIVIDED_BY_10 || 
        (reversed == MIN_DIVIDED_BY_10 && digit <= MIN_LAST_DIGIT)) {
        return false;
      }
   
      reversed = reversed * 10 + digit; // Reverse the digits
      x /= 10; // Truncate the number
    }

    return original == reversed;
  }

}
```

### Reverse half of the number

We can improve the runtime to O(log n) if we only check half the number. Similar to the reverse and compare approach where we reverse the number itself then compare with the original number. The issue is that the reversed number may be larger than `INTEGER.MAX_VALUE` which will violate the constraint of a signed 32-bit integer.

To improve the solution we can reverse only half the digits of the number `x`. The reverse of the last half of the palindrome should be the same as the first half of the number.

Example: if the input is `1221` we can: 
  - reverse the last part of the number `1221` from `21` to `12`.
  - compare the first half of the number `12` to the reversed value `12`
  - Since `12` is the same as `12` we know that the input number is a palindrome

**Odd-lengthed palindromes:**

When the length of the number is odd, we can eliminate the middle digit by dividing the reversed number by 10. For example:
- If the input is 12321, at the end of the while loop, we have `x = 12` and `reversed = 123`.
- Since the middle digit (3 in this case) doesn't affect whether the number is a palindrome (it's equal to itself), we can safely discard it.

**Time Complexity:**  `O(log(n))`
  - Divide the input by 10 for every iteration
  - Only checks half the digits of the given input `x`
**Space Complexity:** `O(1)`

#### Algorithm

Edge cases:

  - All negative numbers are not palindromes
  - If last digit of number is 0, in order to be a palindrome the first digit of the number also needs to be 0
    - Only `0` satisfies this property

1. **Edge Cases Handling:**
   - The code starts by handling two edge cases:
     - If the input number `x` is negative, it's not a palindrome (return `false`).
     - If `x` is positive and ends with 0 (e.g., 120), it's also not a palindrome (return `false`).

2. **Reversing the Number:**
   - The code initializes a variable `reversed` to 0.
   - It enters a `while` loop as long as `x` is greater than the reversed number.
   - In each iteration:
     - Multiply the current `reversed` value by 10 (shift digits left) and add the last digit of `x` (obtained using `x % 10`).
     - Update `x` by dividing it by 10 (truncate the last digit).

3. **Checking for Palindrome:**
   - After the loop, we have reversed the first half of the original number.
   - If the original number has an odd length, the middle digit doesn't matter for palindromes (e.g., 12321).
     - In this case, we can safely remove the middle digit by dividing `reversed` by 10.
   - Finally, compare `x` with the reversed number (or the reversed number divided by 10 for odd-length numbers).
     - If they are equal, the number is a palindrome; otherwise, it's not.

```java
class Solution {
  public boolean isPalindrome(int x) {
    // Edge case: Numbers ending with 0 are not palindromes
    // Edge case: Negative numbers are not palindromes
    if (x < 0 || (x != 0 && (x % 10 == 0))) {
      return false;
    }

    int reversed = 0;
    while (x > reversed) {
      reversed = reversed * 10 + x % 10; // Reverse the digits
      x /= 10;
    }

    // When the length is an odd number, we can get ride of the middle digit by reversed/10
    // e.g., when the input is 12321, the end of the while loop we get x = 12, reverse = 123
    // since the middle digit doesn't matter in palindrome (equal to itself) we can get rid of it
    return x == reversed || x == reversed/10;
  }
}
```

## Java

### Reverse and Compare

```java
class Solution {
  public boolean isPalindrome(int x) {
    // Edge case: Negative numbers are not palindromes
    if (x < 0) {
      return false; 
    }

    // Edge case: Single-digit numbers are always palindromes
    if (x >= 0 && x < 10) {
      return true;
    }

    // Edge case: Numbers ending with 0 are not palindromes
    if (x != 0 && ((x % 10) == 0)) {
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

### Reverse half the number

```java
class Solution {
  public boolean isPalindrome(int x) {
    // Edge case: Numbers ending with 0 are not palindromes
    // Edge case: Negative numbers are not palindromes
    if (x < 0 || (x != 0 && (x % 10 == 0))) {
      return false;
    }

    int reversed = 0;
    while (x > reversed) {
      reversed = reversed * 10 + x % 10; // Reverse the digits
      x /= 10;
    }

    // Check if other half the number is equal to the reversed half.
    // For odd-lengthed palindromes, safely discard middle digit
    return x == reversed || x == reversed/10;
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

  // Edge case: Single-digit numbers are always palindromes
  if (x >= 0 && x < 10) {
    return true;
  }

  // Edge case: Numbers ending with 0 are not palindromes
  if (x != 0 && x % 10 == 0) {
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
