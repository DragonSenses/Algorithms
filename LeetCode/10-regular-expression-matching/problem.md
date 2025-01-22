# 10. Regular Expression Matching

Given an input string `s` and a pattern `p`, implement regular expression matching with support for `'.'` and `'*'` where:

  - `'.'` Matches any single character.​​​​
  - `'*'` Matches zero or more of the preceding element.

The matching should cover the **entire** input string (not partial).

#### Example 1:

Input: s = "aa", p = "a"

Output: false

Explanation: "a" does not match the entire string "aa".

#### Example 2:

Input: s = "aa", p = "a*"

Output: true

Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".

#### Example 3:

Input: s = "ab", p = ".*"
Output: true
Explanation: ".*" means "zero or more (*) of any character (.)".

#### Constraints:

  - `1 <= s.length <= 20`
  - `1 <= p.length <= 20`
  - `s` contains only lowercase English letters.
  - `p` contains only lowercase English letters, `'.'`, and `'*'`.
  - It is guaranteed for each appearance of the character `'*'`, there will be a previous valid character to match.

<br>

---

## Overview: Regular Expressions

Regular expression matching is a technique used to search for specific patterns within strings. It allows for complex search criteria using various special characters, often called wildcards.

In this problem, you need to implement a function that performs regular expression matching.

This problem requires a thorough understanding of how regular expressions work and how to implement the matching logic to cover all possible cases.

### Problem Overview: Regular Expression Matching

In this problem, you need to implement a function that performs regular expression matching. The function will take an input string `s` and a pattern `p`, and it should determine whether the pattern matches the entire input string. The pattern supports the following special characters:

- `.` Matches any single character.
- `*` Matches zero or more of the preceding element.

The matching must cover the **entire** input string (not just a part of it).

#### Key Points:
1. **Pattern Matching Rules**:
   - `.` can match any single character.
   - `*` can match zero or more occurrences of the preceding character.

2. **Constraints**:
   - `1 <= s.length <= 20`
   - `1 <= p.length <= 20`
   - `s` contains only lowercase English letters.
   - `p` contains only lowercase English letters, `'.'`, and `'*'`.
   - It is guaranteed that for each appearance of the character `'*'`, there will be a preceding valid character to match.

#### Examples:
- **Example 1**:
  - **Input**: s = "aa", p = "a"
  - **Output**: false
  - **Explanation**: The pattern "a" does not match the entire string "aa".

- **Example 2**:
  - **Input**: s = "aa", p = "a*"
  - **Output**: true
  - **Explanation**: The '*' means zero or more of the preceding element 'a'. Therefore, by repeating 'a' once, it becomes "aa".

- **Example 3**:
  - **Input**: s = "ab", p = ".*"
  - **Output**: true
  - **Explanation**: The pattern ".*" means "zero or more (*) of any character (.)".

