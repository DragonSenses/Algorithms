# 58. Length of Last Word

<p>Given a string <code>s</code> consisting of words and spaces, return <em>the length of the <strong>last</strong> word in the string.</em></p>

<p>A <strong>word</strong> is a maximal <strong>substring</strong> consisting of non-space characters only.</p>

A <strong>substring</strong> is a contiguous <strong>non-empty</strong> sequence of characters within a string.

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> s = "Hello World"
<strong>Output:</strong> 5
<strong>Explanation:</strong> The last word is "World" with length 5.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> s = "   fly me   to   the moon  "
<strong>Output:</strong> 4
<strong>Explanation:</strong> The last word is "moon" with length 4.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> s = "luffy is still joyboy"
<strong>Output:</strong> 6
<strong>Explanation:</strong> The last word is "joyboy" with length 6.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
  <li><code>1 &lt;= s.length &lt;= 10<sup>4</sup></code></li>
  <li><code>s</code> consists of only English letters and spaces <code>' '</code>.</li>
  <li>There will be at least one word in <code>s</code>.</li>
</ul>

<br>

---

# Solution

- [String Index Manipulation Approach](#string-index-manipulation-approach)

### Problem Overview: Length of Last Word

**Problem Description:**
Given a string `s` consisting of words and spaces, the task is to return the length of the last word in the string. A **word** is defined as a maximal **substring** consisting of non-space characters only.

**Key Points:**
1. **Input:** A string `s` that contains words and spaces.
2. **Output:** An integer representing the length of the last word in the string.
3. **Word Definition:** A word is a contiguous, non-empty sequence of non-space characters within the string.

**Examples:**

- **Example 1:**
  - **Input:** `s = "Hello World"`
  - **Output:** `5`
  - **Explanation:** The last word is "World" with length 5.
  
- **Example 2:**
  - **Input:** `s = "   fly me   to   the moon  "`
  - **Output:** `4`
  - **Explanation:** The last word is "moon" with length 4.
  
- **Example 3:**
  - **Input:** `s = "luffy is still joyboy"`
  - **Output:** `6`
  - **Explanation:** The last word is "joyboy" with length 6.

**Constraints:**
1. `1 <= s.length <= 10^4`
2. The string `s` consists of only English letters and spaces `' '`.
3. There will be at least one word in `s`.

# String Index Manipulation Approach

String index manipulation is a powerful and fundamental technique in programming, enabling you to efficiently process and manipulate strings. By understanding how to work with string indices, you can perform a wide range of text-processing tasks effectively.

### String Index Manipulation Overview

String index manipulation is a technique used to access, modify, and analyze specific parts of a string by utilizing their positions, or indices, within the string. In many programming languages, strings are treated as arrays of characters, where each character has a specific index. Here are some common operations and techniques involving string index manipulation:

1. **Accessing Characters:**
   - You can access individual characters in a string using their indices.
   - Example: In the string `"Hello"`, the character at index `0` is `'H'`, at index `1` is `'e'`, and so on.

2. **Slicing and Substrings:**
   - You can extract a portion of a string, known as a substring, by specifying a range of indices.
   - Example: In the string `"Hello World"`, the substring from index `6` to `10` is `"World"`.

3. **Iterating Through a String:**
   - You can loop through each character in a string by iterating over its indices.
   - Example: Printing each character in the string `"Hello"` one by one.

4. **Modifying Strings:**
   - Strings are often immutable, meaning you can't change them directly. Instead, you can create a new string by manipulating indices.
   - Example: Reversing a string by iterating from the last index to the first index and constructing a new string.

5. **Finding Substrings:**
   - You can search for specific substrings within a string by iterating through the indices and checking for matches.
   - Example: Finding the word `"World"` in the string `"Hello World"` by checking indices where it starts.

6. **Trimming and Removing Characters:**
   - You can remove unwanted characters, such as leading or trailing spaces, by adjusting the indices to exclude them.
   - Example: Removing leading and trailing spaces from the string `"  Hello World  "` to get `"Hello World"`.

7. **Counting Characters:**
   - You can count occurrences of specific characters or substrings by iterating through the string using indices.
   - Example: Counting the number of `'l'` characters in the string `"Hello"`.
