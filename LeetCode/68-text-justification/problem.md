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
  - **Time Complexity**: `O(n * k)`
  - **Space Complexity**: `O(m)`

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

### **Part 2: Constructing the Justified Line**  
Once the words for a line are selected, they must be transformed into a fully justified string.

#### **1. Key Requirements**  
- The justified line must be exactly `maxWidth` characters long.  
- Spaces should be evenly distributed between words to maintain alignment.  
- The **final line** must be left-aligned, avoiding extra spaces between words.

#### **2. Calculations**  
- Compute the **base length** of the line by summing `word.length + 1` for each word, **excluding trailing spaces**:
  ```text
  baseLength = SUM(word.length + 1) - 1
  ```
- Determine the number of **extra spaces** needed:
  ```text
  extraSpaces = maxWidth - baseLength
  ```

#### **3. Space Distribution**  
- Set `wordCount` as the number of spaces between words:
  ```text
  wordCount = size(line) - 1
  ```
- Compute the evenly distributed spaces per word:
  ```text
  spacesPerWord = extraSpaces / wordCount  # Floor division
  ```
- Assign extra spaces to the **leftmost words** for balance:
  ```text
  needsExtraSpaces = extraSpaces % wordCount
  ```

#### **4. Formatting the Line**  
- **Iterate through words**, ensuring:
  - **Standard spacing** is applied between words.
  - **Extra spaces** are added first to avoid uneven distribution.

```text
FOR each index in range(0, size(line)):
  APPEND line[index] to justifiedString
  IF index < wordCount:
    APPEND " " * (spacesPerWord + (index < needsExtraSpaces ? 1 : 0)) to justifiedString
```

### Special Cases
1. **Final Line**:
   - Final lines should always be left-justified.
   - Words are joined with a single space as a delimiter, and remaining spaces are appended to the end of the string.

2. **Single-Word Lines**:
   - Single-word lines are treated like final lines, as no spaces are needed between words.

3. **Division by Zero**:
   - To avoid errors, ensure `wordCount` is greater than `0`. For lines with only one word, skip the extra space calculations.

## **Algorithm**

### **Overview**
To construct fully justified text efficiently, the solution divides the process into modular helper functions, improving readability and maintainability.

### **Step 1: Define Helper Methods**
1. **`getWords(i, words, maxWidth)`** – Determines which words fit within `maxWidth`, starting from index `i`. Returns a subarray that does not exceed the line width.
2. **`createLine(line, i, words, maxWidth)`** – Formats a justified line from the selected words:
   - **Normal lines** are fully justified.
   - **The final line** is left-aligned.
   - **Space distribution** accounts for extra spaces applied to the leftmost words.

### **Step 2: Initialize Variables**
1. **Result Storage** – Create an empty list `ans` to store the justified lines.
2. **Tracking Index** – Set integer `i = 0` to track position in `words`.

### **Step 3: Process Words Using a Loop**
Use a `while` loop to construct each justified line.

1. **Loop Condition** – Continue processing while `i < words.length`.
2. **Iteration Steps**:
   - **Extract words for the current line**:
     ```java
     currentLine = getWords(i, words, maxWidth);
     ```
   - **Advance tracking index**:
     ```java
     i += currentLine.size();
     ```
   - **Format the extracted words into a justified line**:
     ```java
     justifiedLine = createLine(currentLine, i, words, maxWidth);
     ```
   - **Store the formatted result**:
     ```java
     ans.append(justifiedLine);
     ```

### **Step 4: Space Distribution in `createLine(line, i, words, maxWidth)`**
1. **Handle left-aligned lines** (final or single-word lines).
2. **Compute base length** excluding trailing spaces:
   ```java
   baseLength = SUM(word.length + 1) - 1;
   ```
3. **Calculate extra spaces** to distribute:
   ```java
   extraSpaces = maxWidth - baseLength;
   ```
4. **Determine space distribution**:
   - **Even spaces per word**:
     ```java
     spacesPerWord = extraSpaces / (size(line) - 1); // Floor division
     ```
   - **Remaining spaces for leftmost words**:
     ```java
     needsExtraSpaces = extraSpaces % (size(line) - 1);
     ```
5. **Build fully justified line** by iterating through `line`, ensuring:
   - Proper **spacing between words** (avoiding concatenation issues).
   - **Extra spaces applied first** for balance.
   ```java
   FOR each index in range(0, size(line)):
     APPEND line[index] to justifiedString
     IF index < wordCount:
       APPEND " " * (spacesPerWord + (index < needsExtraSpaces ? 1 : 0)) to justifiedString
   ```

### **Step 5: Return Final Output**
Return the fully justified list of strings:
```java
return ans;
```

### **Pseudocode**

```plaintext
FUNCTION fullJustify(words, maxWidth):
 INITIALIZE ans as empty list
 SET i = 0

 WHILE i < length(words):
   # Step 1: Determine words for the current line
   SET currentLine = getWords(i, words, maxWidth)
   INCREMENT i by size(currentLine)

   # Step 2: Format the line
   SET justifiedLine = createLine(currentLine, i, words, maxWidth)

   # Step 3: Store the formatted line
   APPEND justifiedLine to ans

 RETURN ans


FUNCTION getWords(startIndex, words, maxWidth):
 INITIALIZE currentLine as empty list
 SET currLength = 0

 WHILE startIndex < length(words) AND currLength + length(words[startIndex]) <= maxWidth:
   APPEND words[startIndex] to currentLine
   UPDATE currLength = currLength + length(words[startIndex]) + 1
   INCREMENT startIndex

 RETURN currentLine


FUNCTION createLine(line, currentIndex, words, maxWidth):
  IF currentIndex == length(words) OR size(line) == 1:
    # Left-justified (final line or single-word line)
    SET justifiedString = JOIN(line, " ")
    WHILE length(justifiedString) < maxWidth:
        APPEND " " to justifiedString
    RETURN justifiedString

  # Calculate base length excluding trailing space
  SET baseLength = -1
  FOR each word in line:
      UPDATE baseLength = baseLength + length(word) + 1

  # Compute extra spaces
  SET extraSpaces = maxWidth - baseLength
  SET wordCount = size(line) - 1
  SET spacesPerWord = extraSpaces / wordCount  # Floor division
  SET needsExtraSpaces = extraSpaces % wordCount  # Remaining spaces for leftmost words

  # Build fully justified line
  INITIALIZE justifiedString as empty
  FOR each index in range(0, size(line)):
    APPEND line[index] to justifiedString
    IF index < wordCount:
        APPEND " " * (spacesPerWord + (index < needsExtraSpaces ? 1 : 0)) to justifiedString

  RETURN justifiedString
```

## **Implementation**

### Java

```java
import java.util.ArrayList;
import java.util.List;

class Solution {

  /**
   * Fully justifies a given list of words within a specified maxWidth.
   *
   * @param words Array of words to justify
   * @param maxWidth Maximum width of each justified line
   * @return List of fully justified lines
   */
  public List<String> fullJustify(String[] words, int maxWidth) {
    List<String> ans = new ArrayList<>();
    int i = 0;

    while (i < words.length) {
      // Gather words that fit within maxWidth for the current line
      List<String> currentLine = getWords(i, words, maxWidth);
      i += currentLine.size();

      // Format the selected words into a fully justified line
      ans.add(createLine(currentLine, i, words, maxWidth));
    }

    return ans;
  }

  /**
   * Selects words that fit within maxWidth for a single line.
   *
   * @param i Current word index
   * @param words Array of words to process
   * @param maxWidth Maximum width of each justified line
   * @return List of words forming the current line
   */
  private List<String> getWords(int i, String[] words, int maxWidth) {
    List<String> currentLine = new ArrayList<>();
    int currLength = 0;

    while (i < words.length && currLength + words[i].length() <= maxWidth) {
      currentLine.add(words[i]);
      // Account for space after each word except the last one
      currLength += words[i].length() + 1;
      i++;
    }

    return currentLine;
  }

  /**
   * Constructs a fully justified line from selected words.
   *
   * @param line Words forming the current line
   * @param i Index tracking processed words
   * @param words Array of all words
   * @param maxWidth Maximum width of the justified line
   * @return Fully justified line as a string
   */
  private String createLine(List<String> line, int i, String[] words, int maxWidth) {

    // Check if this is the last line or a single-word line
    boolean isLastLine = (i == words.length);
    boolean isSingleWord = (line.size() == 1);

    if (isLastLine || isSingleWord) {
      StringBuilder sb = new StringBuilder(String.join(" ", line));

      // Append spaces to reach maxWidth for left justification
      while (sb.length() < maxWidth) {
        sb.append(" ");
      }

      return sb.toString();
    }

    // Calculate base length excluding trailing space
    // Start at -1 to offset the initial space handling
    int baseLength = -1;
    for (String word : line) {
      baseLength += word.length() + 1; // Word length plus one space
    }

    // Compute the number of extra spaces to distribute
    int extraSpaces = maxWidth - baseLength;
    // Determine number of gaps between words
    int wordCount = line.size() - 1;
    // Compute evenly distributed spaces between words
    int spacesPerWord = extraSpaces / wordCount;
    // Assign remaining spaces to the leftmost words for balance
    int needsExtraSpaces = extraSpaces % wordCount;

    // Construct the fully justified line
    StringBuilder sb = new StringBuilder();

    for (int j = 0; j < line.size(); j++) {
      // Append the current word
      sb.append(line.get(j));

      // Add spaces between words, except after the last one
      if (j < wordCount) {
        int totalSpaces = spacesPerWord + (j < needsExtraSpaces ? 1 : 0);
        sb.append(" ".repeat(totalSpaces));

        // Explicitly separate words to avoid merging issues
        if (j + 1 < line.size()) {
          sb.append(" ");
        }
      }
    }

    return sb.toString();
  }
}
```

### TypeScript

```typescript
/**
 * Fully justifies a given set of words within a specified maxWidth.
 * @param words - Array of words to justify.
 * @param maxWidth - Maximum width of each justified line.
 * @returns Array of fully justified lines.
 */
function fullJustify(words: string[], maxWidth: number): string[] {
  const result: string[] = [];
  let i = 0;

  while (i < words.length) {
    // Collect words that fit within maxWidth for the current line
    const currentLine = getWords(i, words, maxWidth);
    i += currentLine.length;

    // Format and justify the selected words
    result.push(createLine(currentLine, i, words, maxWidth));
  }

  return result;
}

/**
 * Selects words that fit within maxWidth for the current line.
 * @param i - Starting index in the words array.
 * @param words - Array of words to justify.
 * @param maxWidth - Maximum width of the line.
 * @returns Array of words forming a single justified line.
 */
function getWords(i: number, words: string[], maxWidth: number): string[] {
  const currentLine: string[] = [];
  let currLength = 0;

  while (i < words.length && currLength + words[i].length <= maxWidth) {
    currentLine.push(words[i]);
    // Include a space after each word
    currLength += words[i].length + 1;
    i++;
  }

  return currentLine;
}

/**
 * Formats a line of words into a justified string.
 * @param line - Array of words forming the current line.
 * @param i - Current index in the words array.
 * @param words - Array of words to justify.
 * @param maxWidth - Maximum width of the line.
 * @returns Fully justified line as a string.
 */
function createLine(
  line: string[],
  i: number,
  words: string[],
  maxWidth: number
): string {
  // Determine if this is the last line or a single-word line
  const isLastLine = i === words.length;
  const isSingleWord = line.length === 1;

  if (isLastLine || isSingleWord) {
    let justifiedString = line.join(" ");

    // Pad spaces to reach maxWidth for left justification
    while (justifiedString.length < maxWidth) {
      justifiedString += " ";
    }

    return justifiedString;
  }

  // Compute base length excluding trailing space
  // Start at -1 to offset initial space handling
  let baseLength = -1;
  for (const word of line) {
    baseLength += word.length + 1;
  }

  // Calculate the number of extra spaces to distribute
  const extraSpaces = maxWidth - baseLength;
  // Determine gaps between words
  const wordCount = line.length - 1;
  // Compute evenly distributed spaces between words
  const spacesPerWord = Math.floor(extraSpaces / wordCount);
  // Find remaining spaces for leftmost words
  const needsExtraSpaces = extraSpaces % wordCount;

  // Construct fully justified line
  let justifiedString = "";

  for (let j = 0; j < line.length; j++) {
    justifiedString += line[j];

    // Add spaces between words, except after the last one
    if (j < wordCount) {
      let totalSpaces = spacesPerWord + (j < needsExtraSpaces ? 1 : 0);
      
      justifiedString += (" ".repeat(totalSpaces));

      // Explicitly separate words to avoid merging issues
      if (j + 1 < line.length) {
        justifiedString += " ";
      }
    }
  }

  return justifiedString;
}
```

## **Complexity Analysis**

### **Assumptions**
- `n` is the number of words in the `words` array (`words.length`).
- `k` is the average length of a word in the `words` array.
- `m` is the maximum width of a line (`maxWidth`).
- Words are guaranteed to fit within `maxWidth`, as per the problem constraints.
- All operations within helper methods (`getWords` and `createLine`) and string manipulations, such as appending and joining, are treated as proportional to the length of the processed words.

### **Time Complexity**: **`O(n * k)`**
1. **Processing Words into Lines**:
   - The algorithm iterates through all `n` words using the `getWords` method.
   - For each word, the algorithm performs operations like calculating cumulative line length, which involves checking the word's size (`O(k)` per word).
   - Thus, the grouping step takes **`O(n * k)`**.

2. **Formatting Lines**:
   - The `createLine` method formats each line. In the worst case, a line could contain all `n` words, and each word has an average length of `k`.
   - For every line, appending words and spaces involves proportional work based on the combined length of the words in the line, leading to **`O(n * k)`** for formatting all lines.
   
3. **Overall Complexity**:
   - Both grouping (`getWords`) and formatting (`createLine`) contribute **`O(n * k)`**. Hence, the overall time complexity is **`O(n * k)`**.

### **Space Complexity**: **`O(m)`**
1. **Temporary Line Storage**:
   - The `getWords` method stores the words for the current line in a temporary list. The number of words in this list is limited by the `maxWidth`, but the size of the list depends on the word lengths. This requires **`O(m)`** space in the worst case.

2. **Result Storage**:
   - The `ans` list stores all formatted lines. While the memory used for this depends on the total number of lines, no individual line exceeds `m` in size. This storage is independent of the intermediate working memory.

3. **No Additional Data Structures**:
   - Aside from the temporary list in `getWords` and the `StringBuilder` used in `createLine`, the algorithm does not require extra dynamic storage proportional to `n` or `k`.
   
4. **Overall Space Complexity**:
   - The temporary and result storage is bounded by the `maxWidth`, making the overall space complexity **`O(m)`**.
