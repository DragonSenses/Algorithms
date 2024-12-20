# 72. Edit Distance

<p>Given two strings <code>word1</code> and <code>word2</code>, return <em>the minimum number of operations required to convert <code>word1</code> to <code>word2</code></em>.</p>

<p>You have the following three operations permitted on a word:</p>

<ul>
  <li>Insert a character</li>
  <li>Delete a character</li>
  <li>Replace a character</li>
</ul>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> word1 = "horse", word2 = "ros"
<strong>Output:</strong> 3
<strong>Explanation:</strong> 
horse -&gt; rorse (replace 'h' with 'r')
rorse -&gt; rose (remove 'r')
rose -&gt; ros (remove 'e')
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> word1 = "intention", word2 = "execution"
<strong>Output:</strong> 5
<strong>Explanation:</strong> 
intention -&gt; inention (remove 't')
inention -&gt; enention (replace 'i' with 'e')
enention -&gt; exention (replace 'n' with 'x')
exention -&gt; exection (replace 'n' with 'c')
exection -&gt; execution (insert 'u')
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
  <li><code>0 &lt;= word1.length, word2.length &lt;= 500</code></li>
  <li><code>word1</code> and <code>word2</code> consist of lowercase English letters.</li>
</ul>

<br>

---

# Solution

- [Recursive Approach](#recursive-approach)

## Problem Overview

### Introduction to Edit Distance
[Edit distance](https://en.wikipedia.org/wiki/Edit_distance) is a string metric used in computer science to quantify how dissimilar two strings are. It measures the minimum number of operations required to transform one string into another. 

### Types of Edit Distance
There are various types of "edit distance," each allowing different operations to transform one string into another. In this problem, we refer specifically to **Levenshtein distance**.

### Levenshtein Distance
The Levenshtein distance allows three types of operations:
- **Insertion**: Adding a character
- **Deletion**: Removing a character
- **Replacement**: Replacing a character

### Real-World Applications
Solving this problem has several real-world applications. For example, it can help find the similarity score between two strings. A lower edit distance indicates higher similarity.

One prominent application is the auto-correct feature in text editors. When a spelling mistake is made, advanced text editors like Microsoft Word suggest the nearest matching words. These suggestions are based on words with the least edit distance from the dictionary.

Additionally, edit distance has applications in fields such as computational biology and natural language processing.

### Goal
The goal is to find the edit distance between two given strings, `word1` and `word2`.

Levenshtein distance finds edit distances by allowing three types of transformation operations: **addition**, **deletions**, and **replacements**

![Example of word 1: "Wenesfays" and word 2: "Wednesday" shows the use of add, replace, and delete operations.](img/72-1.jpg)

Let us now discuss the approaches to solving this problem.

# Recursive Approach

## **Intuition**

Let's start by identifying the key principles of this approach:

1. **Identical Strings**: If the two strings are the same, the edit distance is zero.
   ```plaintext
   Example: word1 = "abcd", word2 = "abcd"
   Edit Distance = 0
   ```
   Since `word1` is equal to `word2`, there is no need to add, remove, or replace any characters.

2. **Different Characters**: Operations (add, delete, replace) are performed only if a character at a certain position in `word1` is different from the corresponding character in `word2`.
   ```plaintext
   Example: word1 = "abc", word2 = "abe"
   ```
   The character at the 3rd position in `word1` ('c') is different from the character in `word2` ('e'). In this case, we have three options to transform `word1` into `word2`:
   - **Option 1**: Delete 'c' from `word1`.
   - **Option 2**: Insert 'e' into `word1`.
   - **Option 3**: Replace 'c' with 'e' in `word1`.

### Choosing the Optimal Operation
To find the minimum number of operations to transform `word1` into `word2`, we must evaluate each operation:

1. **Delete 'c' from `word1`**:
   - Transforms "abc" to "ab" (Edit Distance = 2)
2. **Insert 'e' into `word1`**:
   - Transforms "abc" to "abec" (Edit Distance = 2)
3. **Replace 'c' with 'e' in `word1`**:
   - Transforms "abc" to "abe" (Edit Distance = 1)

From this example, we see that Option 3 is the optimal choice, resulting in an edit distance of 1.

![Illustration of the three operations (delete 'c' from word1, insert 'e' into word1, or replace 'c' with 'e' in word 1) to transform word1: "abc" to word2: "abe"](img/72-2.jpg)

### Conclusion
The edit distance to transform `word1` to `word2` can be calculated as:
```plaintext
Edit distance = Minimum (
    Number of operations after deleting character from "word1",
    Number of operations after inserting character in "word1",
    Number of operations after replacing character in "word1"
) + 1
```
The `+1` accounts for the current operation.

### Recursive Implementation
When it comes to trying all possible solutions and finding the most optimal one, recursion is a natural approach.

Whenever there is a mismatch between two characters in the strings, we need to try all possible operations and choose the best among them.

