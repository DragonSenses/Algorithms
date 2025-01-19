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

- [58. Length of Last Word](#58-length-of-last-word)
- [Solution](#solution)
    - [Problem Overview: Length of Last Word](#problem-overview-length-of-last-word)
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

