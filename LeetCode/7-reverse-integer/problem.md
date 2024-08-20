# Reverse Integer

Given a signed 32-bit integer `x`, return `x` *with its digits reversed*. If reversing `x` causes the value to go outside the signed 32-bit integer range `[-2^31, 2^31 - 1]`, then return `0`.

**Assume the environment does not allow you to store 64-bit integers (signed or unsigned).**
 
#### Example 1:

Input: x = 123
Output: 321

#### Example 2:

Input: x = -123
Output: -321

#### Example 3:

Input: x = 120
Output: 21

#### Constraints:

    -2^31 <= x <= 2^31 - 1

# Solution

### **Key Points**

These three operations are fundamental for reversing an integer:

1. **Extracting the Least Digit:**
   - To find the least significant digit of an integer, use the modulo operator `%` with 10. For example:
     - If `n` is an integer, `n % 10` gives you the last digit of `n`.
     - For instance, `123 % 10` equals `3`.

2. **Truncating a Number:**
   - To remove the least significant digit from an integer, divide it by 10 using the division operator `/`. For example:
     - If `n` is an integer, `n / 10` truncates the last digit of `n`.
     - For instance, `123 / 10` results in `12`.

3. **Building the Reversed Integer:**
   - To reverse the integer and construct the output result, follow these steps:
     - Initialize a variable `result` to store the reversed number (initially set to 0).
     - While `n` is not zero:
       - Multiply `result` by 10 (shift left by 1).
       - Add the least significant digit of `n` (obtained using `n % 10`) to `result`.
       - Truncate `n` by dividing it by 10 (i.e., `n = n / 10`).
     - The final value of `result` will be the reversed integer.

**Note:** This procedure also works with negative numbers.
