# 68. Text Justification

<p>Given an array of strings <code>words</code> and a width <code>maxWidth</code>, format the text such that each line has exactly <code>maxWidth</code> characters and is fully (left and right) justified.</p>

<p>You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces <code>' '</code> when necessary so that each line has exactly <code>maxWidth</code> characters.</p>

<p>Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line does not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.</p>

<p>For the last line of text, it should be left-justified, and no extra space is inserted between words.</p>

<p><strong>Note:</strong></p>

<ul>
	<li>A word is defined as a character sequence consisting of non-space characters only.</li>
	<li>Each word's length is guaranteed to be greater than <code>0</code> and not exceed <code>maxWidth</code>.</li>
	<li>The input array <code>words</code> contains at least one word.</li>
</ul>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> words = ["This", "is", "an", "example", "of", "text", "justification."], maxWidth = 16
<strong>Output:</strong>
[
&nbsp; &nbsp;"This &nbsp; &nbsp;is &nbsp; &nbsp;an",
&nbsp; &nbsp;"example &nbsp;of text",
&nbsp; &nbsp;"justification. &nbsp;"
]</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> words = ["What","must","be","acknowledgment","shall","be"], maxWidth = 16
<strong>Output:</strong>
[
&nbsp; "What &nbsp; must &nbsp; be",
&nbsp; "acknowledgment &nbsp;",
&nbsp; "shall be &nbsp; &nbsp; &nbsp; &nbsp;"
]
<strong>Explanation:</strong> Note that the last line is "shall be    " instead of "shall     be", because the last line must be left-justified instead of fully-justified.
Note that the second line is also left-justified because it contains only one word.</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> words = ["Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"], maxWidth = 20
<strong>Output:</strong>
[
&nbsp; "Science &nbsp;is &nbsp;what we",
  "understand &nbsp; &nbsp; &nbsp;well",
&nbsp; "enough to explain to",
&nbsp; "a &nbsp;computer. &nbsp;Art is",
&nbsp; "everything &nbsp;else &nbsp;we",
&nbsp; "do &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;"
]</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= words.length &lt;= 300</code></li>
	<li><code>1 &lt;= words[i].length &lt;= 20</code></li>
	<li><code>words[i]</code> consists of only English letters and symbols.</li>
	<li><code>1 &lt;= maxWidth &lt;= 100</code></li>
	<li><code>words[i].length &lt;= maxWidth</code></li>
</ul>

---

## **Problem Overview: Text Justification**

The task requires formatting a given array of strings (`words`) into lines that fit a specified width (`maxWidth`). Each line must follow strict justification rules to ensure aesthetic and readable text alignment.

### Problem Details
1. **Line Formatting**:
   - Each line must have **exactly `maxWidth` characters**.
   - Extra spaces (`' '`) should be added between words to ensure full justification (both left and right edges aligned).

2. **Space Distribution**:
   - Spaces should be distributed **as evenly as possible** between words.
   - If the number of spaces does not divide evenly, **more spaces are assigned to slots on the left**.

3. **Last Line**:
   - The last line must be **left-justified** without inserting extra spaces between words.

### Notes
- A **word** is defined as a sequence of non-space characters.
- Each word length is guaranteed to be greater than `0` and not exceed `maxWidth`.
- The array `words` contains at least one word.

### Constraints
- `1 <= words.length <= 300`
- `1 <= words[i].length <= 20`
- `1 <= maxWidth <= 100`
- Words consist of English letters and symbols.

### Approach
The problem suggests using a **greedy algorithm**:
1. **Pack words into lines**: Add as many words as possible into a single line without exceeding `maxWidth`.
2. **Distribute spaces**: Adjust spaces to achieve full justification.
3. **Handle the last line**: Ensure proper left justification.

### Example Inputs and Outputs
#### Example 1:
**Input**:
`words = ["This", "is", "an", "example", "of", "text", "justification."]`,  
`maxWidth = 16`

**Output**:
```plaintext
["This    is    an",
 "example of text",
 "justification.   "]
```

#### Example 2:
**Input**:
`words = ["What","must","be","acknowledgment","shall","be"]`,  
`maxWidth = 16`

**Output**:
```plaintext
["What  must  be",
 "acknowledgment  ",
 "shall be        "]
```

#### Example 3:
**Input**:
`words = ["Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"]`,  
`maxWidth = 20`

**Output**:
```plaintext
["Science  is  what we",
 "understand       well",
 "enough to explain to",
 "a computer. Art is",
 "everything else we",
 "do                 "]
```

## Problem-Solving Approach: Text Justification

This problem combines **string manipulation** with **space management** and challenges us to design efficient text alignment logic for clear, readable output.

### Overview
Text Justification is a problem on LeetCode that doesn't require complex algorithms or data structures. Instead, it focuses on adhering closely to the problem statement and delivering clean, well-organized code while tackling edge cases effectively.

### Characteristics of the Problem
1. **Practical Nature**:
   - This problem is more representative of a real-life task than a typical algorithmic challenge.
   - It emphasizes structured thinking and edge case management over advanced computational techniques.
   - Similar problems include *Valid Number*, which also tests implementation accuracy for practical tasks.

2. **Focus on Clean Implementation**:
   - The challenge lies in breaking the task into manageable subtasks and solving them methodically.
   - Writing clean, modular code is essential to handle the intricacies and moving parts.

### Challenges and Insights
1. **Annoyance vs. Difficulty**:
   - The problem can be frustrating due to its multiple moving parts that are sometimes unrelated.
   - Managing these dependencies without introducing errors can be tricky but rewarding.

2. **Modularity**:
   - Splitting the task into subtasks improves code readability and reduces complexity.
   - Helper functions can isolate and address each part of the problem independently.

### Suggested Approach
To solve the problem efficiently:
1. **Split the Task into Two Subtasks**:
   - **Subtask 1**: Determine which words should fit on each line.
   - **Subtask 2**: Use the words from Subtask 1 to generate the justified line of text.

2. **Iterative Refinement**:
   - Handle lines one at a time, adhering to the constraints of `maxWidth`.
   - Ensure proper spacing distribution and manage edge cases like the last line separately.
