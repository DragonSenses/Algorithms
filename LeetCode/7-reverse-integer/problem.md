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

#### **Constraint:** handling overflow

- If reversing `x` causes the value to go outside the signed 32-bit integer range `[-2^31, 2^31 - 1]`, then return `0`.

- **Assume the environment does not allow you to store 64-bit integers (signed or unsigned).**

To put it more directly we need to handle the case when reversing `x` causes it to go outside the range `[-2_147_483_648, 2_147_483_647]`.

##### Example: handling overflow

Now let's suppose we have an input number that we know will overflow, the reverse of 2^31 = `2_147_483_648` which is greater than the max signed 32-bit positive integer `2_147_483_647`.

Input:    8_463_847_412
Reverse:  2_147_483_648

**Detecting Overflow During Integer Reversal**

Consider the scenario where we need to reverse an input number, but we want to *actively detect* if the reversal will cause an overflow (i.e., exceed the 32-bit signed integer range).

1. **Reverse All But the Last Digit:**
   - Given an input number, reverse all its digits except the last one. For example:
     - Input: 8,463,847,412
     - Reverse (all but the last digit): 2,147,483,64

2. **Check the Value `214748364`:**
   - Take the value `214748364`, which represents the maximum 32-bit signed integer divided by 10.
   - Compare the value `214748364` if it is equal to the current reverse value (all but the last digit) `214748364`

3. **Overflow Handling:**
   - To detect overflow, compare the last digit to append to the reversed number (in our example, `8`) with the ones place of the maximum 32-bit signed int `2_147_483_647` (in this case, `7`).
   - If the reversed ones place is greater than the ones place of `2_147_483_647`, we know that reversing the entire number will cause an overflow.
   - If overflow is detected (e.g., the reversed ones place is greater than `7`), return `0` immediately.
   - Otherwise, proceed with the full reversal.

In our example, since `8` is greater than `7`, we won't take that digit and directly return `0`.

**For negative integers** the logic remains the same except for the overflow comparison. 
   - Instead of checking if the reverse is greater than, we check if reverse is less than the minimum 32-bit signed integer `-2_147_483_648`.

**What if the value is greater than `214748364`?**

Let's say that the value is greater than `2_147_483_64`, such as `3_000_000_00` and we still need to append a value during the reversal. Then we also know this will cause an overflow.