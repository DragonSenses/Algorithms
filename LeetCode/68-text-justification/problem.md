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

# Solution

- [Greedy Modular Line Building Approach](#greedy-modular-line-building-approach)

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

# Greedy Modular Line Building Approach

Greedy Modular Line Building has two core aspects:
1. **Greedy**: Words are packed into each line by maximizing the fit without exceeding `maxWidth`.
2. **Modular**: The task is divided into subtasks (determining words for a line and constructing the justified line), enhancing readability and maintainability. 

## **Intuition**

### Part 1: Determining Which Words Fit on a Line
To decide which words fit on a line while adhering to the `maxWidth` constraint:
1. **Helper Function**:
   - Define a method `getWords(int i)` that starts at index `i` in the `words` array and identifies which words can fit on the current line. The result is a subarray of `words` starting from `words[i]`.
   
2. **Core Idea**:
   - Add as many words as possible to maximize the line length without exceeding `maxWidth`.
   - Each word, except the last on the line, requires a space after it. For this reason, the line length calculation considers `word.length + 1` for all words except the final one.
   
3. **Implementation**:
   - Use a variable `currLength` to track the current length of the line.
   - Evaluate whether the current word `words[i]` can fit by verifying the condition: `currLength + words[i].length <= maxWidth`.
   - If the word fits, update `currLength` by adding `words[i].length + 1` to account for its length and the space after it.
   - The `+1` for spacing is valid because it ensures readiness for evaluating the next word. If there are no further words, the spacing is irrelevant since the line will end.

4. **Process**:
   - Use a while loop to repeatedly add words until no further words can fit without exceeding `maxWidth`.

### Part 2: Constructing the Justified Line
Once the words for a line are determined, transform them into a justified string:
1. **Key Requirements**:
   - The resulting line must be exactly `maxWidth` characters long.
   - Add extra spaces to evenly distribute them between words.
   - Left-justify the final line, avoiding extra spaces between words.

2. **Calculations**:
   - Compute the minimum line length (`baseLength`) by summing `word.length + 1` for all words, except for the last word, which adds only `word.length`. Initialize `baseLength = -1` to exclude the unnecessary trailing space.
   - Calculate the required extra spaces as: `extraSpaces = maxWidth - baseLength`.

3. **Space Distribution**:
   - Set `wordCount` as the number of spaces needed between words (`line.length - 1`).
   - Calculate how many spaces each word should receive as `spacesPerWord = extraSpaces / wordCount` (floor division).
   - Determine the number of words on the left needing an additional space using `needsExtraSpaces = extraSpaces % wordCount`.

4. **Formatting the Line**:
   - Iterate through the leftmost `needsExtraSpaces` words, adding one additional space to their gap.
   - Add the calculated `spacesPerWord` to all necessary gaps.
   - Join the words in the `line` list with spaces as the delimiter and pad the string to `maxWidth` as needed.

### Special Cases
1. **Final Line**:
   - Final lines should always be left-justified.
   - Words are joined with a single space as a delimiter, and remaining spaces are appended to the end of the string.

2. **Single-Word Lines**:
   - Single-word lines are treated like final lines, as no spaces are needed between words.

3. **Division by Zero**:
   - To avoid errors, ensure `wordCount` is greater than `0`. For lines with only one word, skip the extra space calculations.

## **Algorithm**

1. **Helper Methods**: Modularize the logic for determining words (`getWords`) and constructing lines (`createLine`).
2. **Initialization**: Prepare the storage and tracking variables.
3. **Loop Through Words**: Process one line at a time, adding the justified result to the answer.
4. **Output**: Return the final list of justified lines for display.

### Step 1: Define Helper Methods
1. **`getWords(i)`**:
   - Determines which words should be included on the current line starting from index `i`.
   - Returns a subarray of `words` that fits within the `maxWidth`.

2. **`createLine(line, i)`**:
   - Constructs the justified line from the given `line` of words.
   - Formats it according to the rules: full justification for normal lines and left justification for the final line.

### Step 2: Initialize Variables
1. Create an empty list `ans` to store the resulting justified lines.
2. Set an integer `i = 0` to track the current position in the `words` array.

### Step 3: Process Words Using a Loop
Use a `while` loop to iterate over the `words` array and handle each line independently:
1. **Condition**: Continue the loop while `i < words.length`.
2. **Steps in Each Iteration**:
   - Call `getWords(i)` to determine the words for the current line:
     ```plaintext
     currentLine = getWords(i)
     ```
   - Increment `i` by the number of words included in `currentLine`:
     ```plaintext
     i += currentLine.length
     ```
   - Use `createLine(currentLine, i)` to format the justified line:
     ```plaintext
     justifiedLine = createLine(currentLine, i)
     ```
   - Add the resulting `justifiedLine` to the answer list `ans`:
     ```plaintext
     ans.append(justifiedLine)
     ```

### Step 4: Return the Results
Return the completed `ans` list, which contains all the justified lines:
```plaintext
return ans
```
