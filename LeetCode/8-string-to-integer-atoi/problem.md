# 8. String to Integer (atoi)

<div class="elfjS" data-track-load="description_content"><p>Implement the <code>myAtoi(string s)</code> function, which converts a string to a 32-bit signed integer.</p>

<p>The algorithm for <code>myAtoi(string s)</code> is as follows:</p>

<ol>
	<li><strong>Whitespace</strong>: Ignore any leading whitespace (<code>" "</code>).</li>
	<li><strong>Signedness</strong>: Determine the sign by checking if the next character is <code>'-'</code> or <code>'+'</code>, assuming positivity is neither present.</li>
	<li><strong>Conversion</strong>: Read the integer by skipping leading zeros&nbsp;until a non-digit character is encountered or the end of the string is reached. If no digits were read, then the result is 0.</li>
	<li><strong>Rounding</strong>: If the integer is out of the 32-bit signed integer range <code>[-2<sup>31</sup>, 2<sup>31</sup> - 1]</code>, then round the integer to remain in the range. Specifically, integers less than <code>-2<sup>31</sup></code> should be rounded to <code>-2<sup>31</sup></code>, and integers greater than <code>2<sup>31</sup> - 1</code> should be rounded to <code>2<sup>31</sup> - 1</code>.</li>
</ol>

<p>Return the integer as the final result.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = "42"</span></p>

<p><strong>Output:</strong> <span class="example-io">42</span></p>

<p><strong>Explanation:</strong></p>

<pre>The underlined characters are what is read in and the caret is the current reader position.
Step 1: "42" (no characters read because there is no leading whitespace)
         ^
Step 2: "42" (no characters read because there is neither a '-' nor '+')
         ^
Step 3: "<u>42</u>" ("42" is read in)
           ^
</pre>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = " -042"</span></p>

<p><strong>Output:</strong> <span class="example-io">-42</span></p>

<p><strong>Explanation:</strong></p>

<pre>Step 1: "<u>   </u>-042" (leading whitespace is read and ignored)
            ^
Step 2: "   <u>-</u>042" ('-' is read, so the result should be negative)
             ^
Step 3: "   -<u>042</u>" ("042" is read in, leading zeros ignored in the result)
               ^
</pre>
</div>

<p><strong class="example">Example 3:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = "1337c0d3"</span></p>

<p><strong>Output:</strong> <span class="example-io">1337</span></p>

<p><strong>Explanation:</strong></p>

<pre>Step 1: "1337c0d3" (no characters read because there is no leading whitespace)
         ^
Step 2: "1337c0d3" (no characters read because there is neither a '-' nor '+')
         ^
Step 3: "<u>1337</u>c0d3" ("1337" is read in; reading stops because the next character is a non-digit)
             ^
</pre>
</div>

<p><strong class="example">Example 4:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = "0-1"</span></p>

<p><strong>Output:</strong> <span class="example-io">0</span></p>

<p><strong>Explanation:</strong></p>

<pre>Step 1: "0-1" (no characters read because there is no leading whitespace)
         ^
Step 2: "0-1" (no characters read because there is neither a '-' nor '+')
         ^
Step 3: "<u>0</u>-1" ("0" is read in; reading stops because the next character is a non-digit)
          ^
</pre>
</div>

<p><strong class="example">Example 5:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = "words and 987"</span></p>

<p><strong>Output:</strong> <span class="example-io">0</span></p>

<p><strong>Explanation:</strong></p>

<p>Reading stops at the first non-digit character 'w'.</p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>0 &lt;= s.length &lt;= 200</code></li>
	<li><code>s</code> consists of English letters (lower-case and upper-case), digits (<code>0-9</code>), <code>' '</code>, <code>'+'</code>, <code>'-'</code>, and <code>'.'</code>.</li>
</ul>
</div>

<br>

---

# Solution

For this problem we will solve it with these approaches:
  - [**Parsing**](#parsing)
    - Time complexity: `O(n)`

- First parsing implementation that closely follows the given constraints in [java](#first-parsing-implementation-in-java) or in [typescript](#first-parsing-implementation-in-typescript)

## Problem Statement

Implement the `myAtoi(string s)` function, which converts a string to a 32-bit signed integer.

**Rules:**

1. **Trim Leading Whitespace**: Use a method to remove leading whitespace.
2. **Check for Sign**: Check if the next character is `'-'` or `'+'` to determine the sign.
3. **Read Digits**: Iterate through the characters, converting them to digits until a non-digit character is encountered.
4. **Handle Overflow**: Ensure the result stays within the 32-bit signed integer range.

> **Interview Tip:** In this problem, the rules are very thorough because there is no interviewer to communicate with. However, in an interview, each of these rules is a potential question to ask the interviewer if the rule is not already stated. Be sure to communicate thoroughly with your interviewer to make sure you're covering all cases. Clarify the edge cases regarding: whitespace, signedness, conversion, and rounding.

## Overview

The `myAtoi(string s)` function converts a string to a 32-bit signed integer. Here's a structured approach to implementing this function:

1. **Character-by-Character Mapping**:
   - Process the input string one character at a time to build the output integer.

2. **Adherence to Rules**:
   - **Stop on Invalid Character**: Halt the conversion when a non-digit character is encountered.
   - **Handle Overflow**: Stop building the output if the number exceeds the 32-bit signed integer range. Clamp the result to fit within the range.

3. **Consider Edge Cases**:
   - **Whitespace**: Ignore leading whitespace characters.
   - **Signedness**: Determine if the number is positive or negative based on the presence of `'-'` or `'+'`.
   - **Conversion**: Convert the string to an integer by reading digit characters.
   - **Rounding**: Ensure the final result is within the valid range for a 32-bit signed integer.

### **Key Points**

Here are the fundamental operations for converting a string to an integer:

1. **Take the first character of the input string**: This helps determine if there's a sign (`+` or `-`) or if it's a digit.
   
2. **Convert the character to a number**: This involves checking if the character is a digit and then converting it to its numerical value.
   
3. **Build the output**: This is done by iterating through the string, converting each character to a digit, and updating the result using the formula `result = result * 10 + digit`.

### **Key Steps**

1. **Ignoring Leading Whitespace**:
   - Skip any leading whitespace characters to find the start of the actual number.

2. **Determining the Sign**:
   - Check if the next character is a `'-'` or `'+'` to determine if the number is negative or positive. If neither is present, assume the number is positive.

3. **Reading Digits**:
   - Iterate through the characters, converting each digit character to its numerical value until a non-digit character is encountered or the end of the string is reached.

4. **Handling Overflow and Underflow**:
   - Ensure the resulting integer stays within the bounds of a 32-bit signed integer (`-2^31` to `2^31 - 1`). If the number exceeds these bounds, clamp it to the nearest limit.

5. **Combining Digits**:
   - Construct the integer by combining the digits read from the string. This is typically done using the formula:
     - `result = result * 10 + current_digit`

## Parsing

This approach to solving the problem is often referred to as **"parsing"** or **"string parsing"**. More specifically, in the context of converting a string to an integer, it can be described as **"manual parsing"** or **"custom parsing"**.

1. **Parsing**: The process of analyzing a string of symbols, either in natural language or computer languages, to extract meaningful information. In this case, you're parsing the string to extract and convert numerical information.

2. **Manual Parsing**: Unlike using built-in functions like `Integer.parseInt()`, this approach involves manually handling each step of the conversion process, including whitespace trimming, sign determination, digit extraction, and overflow/underflow handling.

This method gives you fine-grained control over the conversion process, allowing you to handle edge cases and specific requirements that built-in functions might not cover.

Let's build the intuition for our custom/manual parsing.

### **Intuition**

We can iterate over the input string and use the given rules to validate it.

Read the problem statement **very carefully**. We can form a list of possible characters in the input string:

- Whitespaces (`' '`)
- Digits (`'0'`, `'1'`, `'2'`, `'3'`, `'4'`, `'5'`, `'6'`, `'7'`, `'8'`, `'9'`,)
- A sign (`'+'` or `'-'`)
- Anything else (alphabetic characters, symbols, special characters, etc.)

Then write down all the rules for building the integer for each one of these characters. This will help us create the conditions while building the algorithm.

**Rules**:

#### Whitespaces Handling

- **Leading Whitespaces**: If any whitespaces occur at the beginning of the input string, we discard them.
- **Internal Whitespaces**: If whitespace occurs anywhere else in the input, we stop and discard the rest of the input.

##### Note:
The terms **"leading"** and **"trailing"** refer to the position of characters, typically white spaces, in a string:
1. **Leading**: Characters that appear at the beginning of a string. For example, in the string `"   Hello World!"`, the spaces before "Hello" are leading white spaces.
2. **Trailing**: Characters that appear at the end of a string. For example, in the string `"Hello World!   "`, the spaces after "World!" are trailing white spaces.

##### Examples:

```sh
'  1234' => 1234  # Leading whitespaces removed
'     4' => 4     # Leading whitespaces removed
'12   4' => 12    # Only the leading whitespaces are removed
```

#### Digits Handling

- **Discard Leading Zeros**: Remove any leading zeros from the input string.
- **Read Digits**: Read all digit characters until the first non-digit character or the end of the input is reached, and append those to the output number.
- **No Digits Found**: If no digits are found, return 0.

##### Examples:

```sh
'12345 567 v' => 12345  # Digits are appended until a non-digit character occurs
'001234'      => 1234   # Leading zeros are discarded
```

#### Sign Handling

- **Single Sign Character**: There can be at most one sign character (`'+'` or `'-'`) at the beginning of the input string, or after skipping leading whitespaces.
  - A sign character anywhere else in the input string is invalid and is considered a non-digit character, causing the parsing to stop.
- **Positive and Negative Numbers**:
  - If a `'+'` sign or no sign is present, the final number will be positive.
  - If a `'-'` sign is the first non-whitespace character, the final number will be negative.

##### Examples:

```sh
'123'   => 123    # A number with no sign is a positive number
'+123'  => 123    # A number with '+' sign is a positive number
'-12'   => -12    # A number with '-' sign is a negative number
'-+12'  => 0      # Another sign after one sign is considered a non-digit character
```

#### Handling Other Characters

- **Stop on Invalid Characters**: If any character not covered by the previously defined rules is encountered, stop building the output number.

##### Examples:

```sh
'-23a45 567 v' => -23   # Stopped when 'a' character occurred
'123 45 567 v' => 123   # Stopped when ' ' space character occurred
'a+123 bcd 45' => 0     # Stopped when 'a' character occurred at the beginning
```

#### 32-bit Integer Range

- **Overflow**: If the integer exceeds \(2^{31} - 1\), it will be clamped to \(2^{31} - 1\).
- **Underflow**: If the integer becomes less than \(-2^{31}\), it will be clamped to \(-2^{31}\).

##### Examples:

```sh
'12345'       =>  12345        # Integer is within signed 32-bit range
'2147483647'  =>  2147483647   # Integer is within signed 32-bit range
'9999999999'  =>  2147483647   # Integer overflow, greater than 2^31 - 1
'-9999999999' => -2147483648   # Integer underflow, less than -2^31
'-2147483648' => -2147483648   # Integer is within signed 32-bit range
```

These cases ensure that any integer exceeding the 32-bit signed integer range is clamped to the maximum or minimum value, preventing overflow or underflow.

*Note:* At this stage we can implement the first parsing implementation without imposing additional constraints. See [Implementation section](#implementation).

#### Constraint: Disallow `longs`, `BigInteger`, etc.

While checking for overflow and underflow, our initial parsing implementation uses numeric data types that can store more data than a signed 32-bit integer, such as `long` or `BigInteger`. Using larger data types facilitates the process of checking if an integer exceeds the 32-bit range. If it does, we can stop building the output number and return the clamped value.

However, if the constraint involves limiting our output to a 32-bit signed integer, it is safe to assume that our environment doesn't allow us to use larger data types. This constraint could be imposed by the interviewer. Therefore, we can't directly use a 32-bit integer to store the final result.

For example, assume the current `result` is `1_000_000_000` and the `digit` is `1`. The value `10_000_000_001` is larger than `2_147_483_647` (or `2^31 - 1`). Performing the operation `result = result * 10 + digit` will result in a **runtime error**.

Instead, we need to check if appending the digit to the result is safe. If it is safe to append, then we update the result. Otherwise, we handle the overflow or underflow.

To do this, we take the value of the 32-bit integer minimum and maximum and remove the least significant digit. Respectively, this will be `214748364` for the maximum and `-214748364` for the minimum. We use these values to check if the `result` we have built so far is equal to them. If so, we must check if the digit we will append is either less than the last digit for the minimum value (i.e., `8`) or greater than the last digit for the maximum value (i.e., `7`).

- We will denote the maximum 32-bit signed integer value `(2^31) - 1` = `2147483647` with `MAX_INT32`.
  - We will denote `MAX_INT32 / 10` = `214748364` the maximum 32-bit signed integer value `(2^31) - 1` with the least significant digit removed.
- We will denote the minimum 32-bit signed integer value `-(2^31)` = `-2147483648` with `MIN_INT32`.
  - We will denote `MIN_INT32 / 10` = `-214748364` the minimum 32-bit signed integer value `-(2^31)` with the least significant digit removed.

##### Checking for overflow

We will denote the maximum 32-bit signed integer value `(2^31) - 1` = `2147483647` with `MAX_INT32`. We will append the digits one by one to the final number. At the 9th digit of the output number (i.e., `214748364`), we can check for overflow. There will be 3 cases:

###### Case 1: Current number is less than `MAX_INT32 / 10`

**Case 1**: If the current number is **less than** `MAX_INT32 / 10` = `214748364`, then we can append any digit (`0-9`) and the new number will always be **less than** `MAX_INT32`.

```sh
'214748363' (less than MAX_INT32 / 10) + '0' = '2147483630' (less than MAX_INT32)
'214748363' (less than MAX_INT32 / 10) + '9' = '2147483639' (less than MAX_INT32)
'1'         (less than MAX_INT32 / 10) + '9' = '19'         (less than MAX_INT32)
```

###### Case 2: Current number is greater than `MAX_INT32 / 10`

**Case 2**: If the current number is **greater than** `MAX_INT32 / 10` = `214748364`, then appending **any** digit will result in a number **greater than** `MAX_INT32`.

```sh
'214748365'   (greater than MAX_INT32 / 10) + '0' = '2147483650'  (greater than MAX_INT32)
'214748365'   (greater than MAX_INT32 / 10) + '9' = '2147483659'  (greater than MAX_INT32)
'2147483646'  (greater than MAX_INT32 / 10) + '8' = '21474836468' (greater than MAX_INT32)
```

###### Case 3: Current number is equal to `MAX_INT32 / 10`

**Case 3**: If the current number is **equal to** `MAX_INT32 / 10` = `214748364`, then we can **only** append digits from (`0-7`) such that the new number will always be **less than or equal to** `MAX_INT32`.

```sh
'214748364' + '0' = '2147483640'  (less than MAX_INT32)
'214748364' + '7' = '2147483647'  (equal to MAX_INT32)
'214748364' + '8' = '2147483648'  (greater than MAX_INT32)
```

##### Checking for underflow

We will denote the minimum 32-bit signed integer value `-(2^31)` = `-2147483648` with `MIN_INT32`. 

There will be 3 cases:

###### Case 1: Current number is greater than `MIN_INT32 / 10`

**Case 1**: If the current number is **greater than** `MIN_INT32 / 10` = `-214748364`, then we can append any digit (`0-9`) and the new number will always be **greater than** `MIN_INT32`.

```sh
'-214748363' (greater than MIN_INT32 / 10) + '0' = '-2147483630' (greater than MIN_INT32)
'-214748363' (greater than MIN_INT32 / 10) + '9' = '-2147483639' (greater than MIN_INT32)
'1'          (greater than MIN_INT32 / 10) + '9' = '19'          (greater than MIN_INT32)
```

###### Case 2: Current number is less than `MIN_INT32 / 10`

**Case 2**: If the current number is **less than** `MIN_INT32 / 10` = `-214748364`, then appending **any** digit will result in a number **less than** `MIN_INT32`.

```sh
'-214748365'   (less than MIN_INT32 / 10) + '0' = '-2147483650'  (less than MIN_INT32)
'-214748365'   (less than MIN_INT32 / 10) + '9' = '-2147483659'  (less than MIN_INT32)
'-999999999'  (less than MIN_INT32 / 10)  + '8' = '-9999999998'  (less than MIN_INT32)
```

###### Case 3: Current number is equal to `MIN_INT32 / 10`

**Case 3**: If the current number is **equal to** `MIN_INT32 / 10` = `-214748364`, then we can **only** append digits from (`0-8`) such that the new number will always be **greater than or equal to** `MIN_INT32`.

```sh
'-214748364' + '0' = '-2147483640'  (less than MIN_INT32)
'-214748364' + '8' = '-2147483648'  (equal to MIN_INT32)
'-214748364' + '9' = '-2147483649'  (greater than MIN_INT32)
```

##### Overflow/Underflow Checks

Notice that for both **overflow** and **underflow**, **cases 1 and 2** are similar. Only **case 3** differs in that we have to check the digit to append. For overflow, the digit to add must be between **0 and 7**. For underflow, the digit to add must be between **0 and 8**.

Another similarity is that the digits for `MIN_INT32 / 10` and `MAX_INT32 / 10`, not including the sign, are the same: `214748364`.

We can combine the checks as follows:

- Initially, store the sign for the final result and consider only the absolute values to build the integer. Return the final result with the correct sign at the end.
- If the current number is less than `214748364` (i.e., `MAX_INT32 / 10`), we can append the next digit.
- If the current number is greater than `214748364`:
  - If the sign for the result is `+`, then the result will **overflow**, so return `MAX_INT32`.
  - If the sign for the result is `-`, then the result will **underflow**, so return `MIN_INT32`.
- If the current number is equal to `214748364`:
  - If the next digit is between `0-7`, the result will always be in range.
  - If the next digit is `8`:
    - If the sign is `+`, the result will **overflow**, so return `MAX_INT32`.
    - If the sign is `-`, the result will not **underflow** but will still be equal to `MIN_INT32`, so return `MIN_INT32`.
  - If the next digit is greater than `8`:
    - If the sign is `+`, the result will **overflow**, so return `MAX_INT32`.
    - If the sign is `-`, the result will **underflow**, so return `MIN_INT32`.

Note: We do not need to handle `0-7` for positive and `0-8` for negative integers separately. If the sign is **negative** and the current number is `214748364`, then appending the digit `8`, which is more than `7`, will also lead to the same result, i.e., `MIN_INT32`.

### **Algorithm**

1. **Initialize Variables**
   - Set `sign` to `1` (to store the sign of the final result).
   - Set `result` to `0` (to store the 32-bit integer result).

2. **Trim Leading Whitespaces**
   - Remove all leading whitespaces from the input string.

3. **Determine the Sign**
   - Check if the current character is a `+` or `-` sign:
     - If the current character is `+` or there is no symbol, keep `sign` as `1`.
     - If the current character is `-`, set `sign` to `-1`.

4. **Convert Characters to Integer**
   - Iterate over the characters in the string as long as the current character is a digit or until the end of the string is reached:
     - Before appending the current digit, check if adding it would violate the 32-bit signed integer range:
       - If it would cause overflow, return `MAX_INT32`.
       - If it would cause underflow, return `MIN_INT32`.
     - If appending the digit does not cause overflow or underflow, append the current digit to `result`.

5. **Return the Final Result**
   - Return the final `result` multiplied by its respective `sign`.

### **Complexity Analysis**

Let `N` be the number of characters in the input string.

**Time complexity**: `O(N)`
  - We visit each character in the input at most once and for each character we spend a constant amount of time.

**Space complexity**: `O(1)`
  - We use a constant amount of space to store the `sign` and `result`.

### **Implementation**

#### Java

##### First parsing implementation in Java

A quick parsing implementation that follows the rules closely (runs in 1ms):

```java
class Solution {
  public int myAtoi(String s) {
    // Edge case: Check for invalid arguments
    if (s == null || s.length() == 0) {
      return 0;
    }

    // 1. Trim leading white spaces from the input
    s = s.trim();

    // Edge case: Trimmed string becomes empty
    if (s.isEmpty()) {
      return 0;
    }

    // 2. Determine the sign
    int sign = 1;
    int index = 0;
    if (s.charAt(0) == '-') {
        sign = -1;
        index++;
    } else if (s.charAt(0) == '+') {
        index++;
    }

    long result = 0;
    
    // 3. Traverse next digits of input. Halt when non-digit violates conditions
    // Also end conversion when the end of string is reached
    while (index < s.length() && Character.isDigit(s.charAt(index))) {
      int digit = s.charAt(index) - '0';
      result = result * 10 + digit;
      
      // Step 4: Handle overflow and underflow
      if (sign * result > Integer.MAX_VALUE) {
        return Integer.MAX_VALUE;
      } else if (sign * result < Integer.MIN_VALUE) {
        return Integer.MIN_VALUE;
      }

      index++;
    }

    return (int) (sign * result);
  }
}
```

##### Second parsing implementation in Java

This improved solution adds the constraint that the environment disallows `long` or `BigInteger` to contain the `result` to easily check for overflow/underflow. (Runs in 2ms).

```java
class Solution {
  public int myAtoi(String s) {
    // Edge case: Check for invalid arguments
    if (s == null || s.length() == 0) {
      return 0;
    }

    // 1. Trim leading white spaces from the input
    s = s.trim();

    // Edge case: Trimmed string becomes empty
    if (s.isEmpty()) {
      return 0;
    }

    // 2. Determine the sign
    int sign = 1;
    int index = 0;
    if (s.charAt(0) == '-') {
      sign = -1;
      index++;
    } else if (s.charAt(0) == '+') {
      index++;
    }

    // Store result in 32-bit signed integer (assumes environment disallows longs, BigInteger, etc.)
    int result = 0;

    final int MIN_INT32 = -2147483648; //-2147483648
    final int MAX_INT32 = 2147483647;  // 2147483647

    final int MIN_INT_DIV10 = Integer.MIN_VALUE / 10; // -214748364
    final int MAX_INT_DIV10 = Integer.MAX_VALUE / 10; //  214748364
    
    final int MIN_LAST_DIGIT = 8; // -2147483648 % 10
    final int MAX_LAST_DIGIT = 7; //  2147483647 % 10

    // 3. Traverse next digits of input. Halt when non-digit violates conditions
    // Also end conversion when the end of string is reached
    while (index < s.length() && s.charAt(index) >= '0' && s.charAt(index) <= '9') {
      // Convert character representing a digit into integer (e.g., '7'-'0' = 55-48 = 7)
      int digit = s.charAt(index) - '0';
      
      // Step 4: Check for overflow before updating result
      if (result > MAX_INT_DIV10) {
        return (sign == 1) ? MAX_INT32 : MIN_INT32;
      }

      if (result == MAX_INT_DIV10) {
        if (digit == 8) {
          return (sign == 1) ? MAX_INT32 : MIN_INT32;
        } else if (digit > 8) {
          return (sign == 1) ? MAX_INT32 : MIN_INT32;
        }
      }

      result = result * 10 + digit;
      index++;
    }

    return (int) (sign * result);
  }
}
```

#### TypeScript

##### First parsing implementation in TypeScript

```typescript
function myAtoi(s: string): number {
  // Edge case: Check for invalid arguments
  if (s == null || s.length === 0) {
    return 0;
  }

  // 1. Trim leading white spaces from the input
  s = s.trim();

  // Edge case: Trimmed string becomes empty
  if (s.length === 0) {
    return 0;
  }

  // 2. Determine the sign
  let sign = 1;
  let index = 0;
  if (s.charAt(0) === "-") {
    sign = -1;
    index++;
  } else if (s.charAt(0) === "+") {
    index++;
  }

  let result = 0;
  const INT_MAX = 2147483647;
  const INT_MIN = -2147483648;

  // 3. Traverse next digits of input. Halt when non-digit violates conditions
  // Also end conversion when the end of string is reached
  while (index < s.length && s.charAt(index) >= "0" && s.charAt(index) <= "9") {
    const digit = s.charAt(index).charCodeAt(0) - "0".charCodeAt(0);
    result = result * 10 + digit;

    // Step 4: Handle overflow and underflow
    if (sign * result > INT_MAX) {
      return INT_MAX;
    } else if (sign * result < INT_MIN) {
      return INT_MIN;
    }

    index++;
  }

  return sign * result;
}
```