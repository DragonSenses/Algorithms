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

## Java

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