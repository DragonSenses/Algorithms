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

