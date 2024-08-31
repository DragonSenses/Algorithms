# String to Integer (atoi)

Implement the `myAtoi(string s)` function, which converts a string to a 32-bit signed integer.

The algorithm for `myAtoi(string s)` is as follows:

  1. **Whitespace**: Ignore any leading whitespace (`" "`).

  2. **Signedness**: Determine the sign by checking if the next character is `'-'` or `'+'`, assuming positivity is neither present.

  3. **Conversion**: Read the integer by skipping leading zeros until a non-digit character is encountered or the end of the string is reached. If no digits were read, then the result is 0.

  4. **Rounding**: If the integer is out of the 32-bit signed integer range `[-2^31, 2^31 - 1]`, then round the integer to remain in the range. Specifically, integers less than `-2^31` should be rounded to `-2^31`, and integers greater than `2^31 - 1` should be rounded to `2^31 - 1`.

Return the integer as the final result.

#### Example 1:

Input: s = "42"

Output: 42

Explanation:

<pre>
The underlined characters are what is read in and the caret is the current reader position.
Step 1: "42" (no characters read because there is no leading whitespace)
         ^
Step 2: "42" (no characters read because there is neither a '-' nor '+')
         ^
Step 3: "42" ("42" is read in)
           ^
</pre>

#### Example 2:

Input: s = " -042"

Output: -42

Explanation:

<pre>
Step 1: "   -042" (leading whitespace is read and ignored)
            ^
Step 2: "   -042" ('-' is read, so the result should be negative)
             ^
Step 3: "   -042" ("042" is read in, leading zeros ignored in the result)
               ^
</pre>

#### Example 3:

Input: s = "1337c0d3"

Output: 1337

Explanation:

<pre>
Step 1: "1337c0d3" (no characters read because there is no leading whitespace)
         ^
Step 2: "1337c0d3" (no characters read because there is neither a '-' nor '+')
         ^
Step 3: "1337c0d3" ("1337" is read in; reading stops because the next character is a non-digit)
             ^
</pre>

#### Example 4:

Input: s = "0-1"

Output: 0

Explanation:

<pre>
Step 1: "0-1" (no characters read because there is no leading whitespace)
         ^

Step 2: "0-1" (no characters read because there is neither a '-' nor '+')
         ^
Step 3: "0-1" ("0" is read in; reading stops because the next character is a non-digit)
          ^
</pre>

#### Example 5:

Input: s = "words and 987"

Output: 0

Explanation:

Reading stops at the first non-digit character 'w'.


#### Constraints:

  - `0 <= s.length <= 200`
  - `s` consists of English letters (lower-case and upper-case), digits (`0-9`), `' '`, `'+'`, `'-'`, and `'.'`.

# Solution

For this problem we will solve it with these approaches:
  - [**Parsing**](#parsing)
    - Time complexity: `O(n)`

<!-- TODO: Link the Implementation here -->

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
