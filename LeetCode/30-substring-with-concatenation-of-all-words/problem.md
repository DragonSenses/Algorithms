# 30. Substring with Concatenation of All Words

<p>You are given a string <code>s</code> and an array of strings <code>words</code>. All the strings of <code>words</code> are of <strong>the same length</strong>.</p>

<p>A <strong>concatenated string</strong> is a string that exactly contains all the strings of any permutation of <code>words</code> concatenated.</p>

<ul>
  <li>For example, if <code>words = ["ab","cd","ef"]</code>, then <code>"abcdef"</code>, <code>"abefcd"</code>, <code>"cdabef"</code>, <code>"cdefab"</code>, <code>"efabcd"</code>, and <code>"efcdab"</code> are all concatenated strings. <code>"acdbef"</code> is not a concatenated string because it is not the concatenation of any permutation of <code>words</code>.</li>
</ul>

<p>Return an array of <em>the starting indices</em> of all the concatenated substrings in <code>s</code>. You can return the answer in <strong>any order</strong>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = "barfoothefoobarman", words = ["foo","bar"]</span></p>

<p><strong>Output:</strong> <span class="example-io">[0,9]</span></p>

<p><strong>Explanation:</strong></p>

<p>The substring starting at 0 is <code>"barfoo"</code>. It is the concatenation of <code>["bar","foo"]</code> which is a permutation of <code>words</code>.<br>
The substring starting at 9 is <code>"foobar"</code>. It is the concatenation of <code>["foo","bar"]</code> which is a permutation of <code>words</code>.</p>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]</span></p>

<p><strong>Output:</strong> <span class="example-io">[]</span></p>

<p><strong>Explanation:</strong></p>

<p>There is no concatenated substring.</p>
</div>

<p><strong class="example">Example 3:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]</span></p>

<p><strong>Output:</strong> <span class="example-io">[6,9,12]</span></p>

<p><strong>Explanation:</strong></p>

<p>The substring starting at 6 is <code>"foobarthe"</code>. It is the concatenation of <code>["foo","bar","the"]</code>.<br>
The substring starting at 9 is <code>"barthefoo"</code>. It is the concatenation of <code>["bar","the","foo"]</code>.<br>
The substring starting at 12 is <code>"thefoobar"</code>. It is the concatenation of <code>["the","foo","bar"]</code>.</p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
  <li><code>1 &lt;= s.length &lt;= 10<sup>4</sup></code></li>
  <li><code>1 &lt;= words.length &lt;= 5000</code></li>
  <li><code>1 &lt;= words[i].length &lt;= 30</code></li>
  <li><code>s</code> and <code>words[i]</code> consist of lowercase English letters.</li>
</ul>

<br>

---

# Solution

- [Sliding Window with Hash Table Counting Approach](#sliding-window-with-hash-table-counting-approach)
  - **Time Complexity**: `O(n * k * b - (k * b)^2)`
  - **Space Complexity**: `O(k)`
- [Optimized Sliding Window Approach](#optimized-sliding-window-approach)

### Problem Overview

#### **Description**
You are given a string `s` and an array of strings `words`. All the strings in `words` have the **same length**.

A **concatenated string** is a string that exactly contains all the strings of any permutation of `words` concatenated together. For example, if `words = ["ab","cd","ef"]`, then `"abcdef"`, `"abefcd"`, `"cdabef"`, `"cdefab"`, `"efabcd"`, and `"efcdab"` are all concatenated strings. However, `"acdbef"` is not a concatenated string because it does not follow any permutation of `words`.

The task is to return an array of the **starting indices** of all the concatenated substrings in `s`. You can return the answer in **any order**.

#### **Examples**
1. **Input:**
   - `s = "barfoothefoobarman"`
   - `words = ["foo","bar"]`
   - **Output:** `[0, 9]`
   - **Explanation:** The substring starting at index 0 is `"barfoo"`, which is a concatenation of `["bar", "foo"]`. The substring starting at index 9 is `"foobar"`, which is a concatenation of `["foo", "bar"]`.

2. **Input:**
   - `s = "wordgoodgoodgoodbestword"`
   - `words = ["word","good","best","word"]`
   - **Output:** `[]`
   - **Explanation:** There is no concatenated substring in the given string.

3. **Input:**
   - `s = "barfoofoobarthefoobarman"`
   - `words = ["bar","foo","the"]`
   - **Output:** `[6, 9, 12]`
   - **Explanation:** The substring starting at index 6 is `"foobarthe"`, starting at index 9 is `"barthefoo"`, and starting at index 12 is `"thefoobar"`, all of which are valid concatenations.

#### **Constraints**
- `1 <= s.length <= 10^4`
- `1 <= words.length <= 5000`
- `1 <= words[i].length <= 30`
- The string `s` and all `words[i]` consist of lowercase English letters.

This problem involves identifying the starting indices of substrings within a given string that are composed of concatenations of all words in a given array. Each word in the array is of equal length, and the task requires identifying all permutations of these words concatenated together within the string `s`.

# Sliding Window with Hash Table Counting Approach

This approach could is named the **"Sliding Window with Hash Table Counting"** emphasizing the main techniques used:
- **Sliding Window**: We iterate through the string `s` using a window of fixed size (`substringSize`) to check for valid substrings.
- **Hash Table Counting**: We use a hash table to keep track of the count of each word and efficiently verify the presence and frequency of words in the substring.

This method captures both the sliding window mechanism for traversing the string and the use of hash table data structures for quick lookups and counting.

## **Intuition**

### **Key Observation**
One critical detail is that all elements in `words` have the same length. This gives us valuable information about the length of all valid substrings. Each valid substring is a concatenation of all `words` elements, so the length of a valid substring will be `words.length * words[0].length`.

### **Approach**
This makes it straightforward to check if a valid substring starts at a given index. For example, if the elements of `words` have a length of 3, we can look at the string in groups of 3 characters from any starting index and verify if those characters form a word in `words`.

### **Hash Table Usage**
Since `words` can contain duplicate words, we should use a hash table to maintain a count for each word. Additionally, a hash table allows for quick searches for word matches.

### **Auxiliary Function**
We can write an auxiliary function to determine if a valid substring starts at a specific index. This function will:
1. Iterate over the substring starting at the given index and spanning the length of a valid concatenated substring.
2. Examine `words[0].length` characters at a time. For each iteration, check a substring matching the length of elements in `words`.
3. If the substring doesn't exist in `words`, or if it does exist but we've already reached the required count of it, return `false`.
4. Use a hash table to keep an updated count of the words between the starting index and the current index.

### **Building the Answer**
By running this auxiliary function for all candidate indices in the string `s`, we can build our answer by collecting the starting indices of valid concatenated substrings.

## **Algorithm**

### **Initialization**
1. Initialize some variables:
   - `n` as the length of `s`.
   - `k` as the length of `words`.
   - `wordLength` as the length of each word in `words`.
   - `substringSize` as `wordLength * k`, which represents the size of each valid substring.
   - `wordCount` as a hash table that tracks how many times a word occurs in `words`.

### **Auxiliary Function**
2. Create an auxiliary function `check` that takes a starting index `i` and returns whether a valid substring starts at index `i`:
   - Create a copy of `wordCount` called `remaining` for this particular index. Initialize an integer `wordsUsed` to track how many matches have been found so far.
   - Iterate starting from `i` up to `i + substringSize` (exclusive). Since each valid substring will have this size, there's no need to go further.
     - At each iteration, check for a word `sub = s.substring(j, j + wordLength)`, where `j` is the variable in the iteration.
     - If `sub` exists in `remaining` and its count is greater than 0, decrease its count by 1 and increase `wordsUsed` by 1. Otherwise, break out of the loop.
   - At the end, if `wordsUsed == k`, it means all words in `words` have been used, forming a valid substring. Return `true` if so, otherwise return `false`.

### **Building the Answer**
3. Iterate over all possible starting indices:
   - Since a valid substring has a length of `substringSize`, iterate up to `n - substringSize`.
   - Use the auxiliary function `check` to determine if a valid substring starts at each index.
   - Collect the starting indices that pass the `check` function and return them as the answer.

### **Pseudocode**
```pseudo
function findSubstring(s, words):
    n = length(s)
    k = length(words)
    wordLength = length(words[0])
    substringSize = wordLength * k
    wordCount = hashTable()

    for word in words:
        wordCount[word] += 1

    function check(i):
        remaining = copy(wordCount)
        wordsUsed = 0

        for j from i to i + substringSize step wordLength:
            sub = s.substring(j, j + wordLength)
            if sub in remaining and remaining[sub] > 0:
                remaining[sub] -= 1
                wordsUsed += 1
            else:
                return false

        return wordsUsed == k

    result = []
    for i from 0 to n - substringSize:
        if check(i):
            result.append(i)

    return result
```

## **Implementation**

### Java

```java
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
  // HashMap to store the count of each word in the words array
  private HashMap<String, Integer> wordCount = new HashMap<>();
  private int wordLength;
  private int substringSize;
  private int k;

  /**
   * Checks if a valid concatenated substring starts at index i in the given string s.
   */
  private boolean check(int i, String s) {
    // Copy the original word count for this particular index
    HashMap<String, Integer> remaining = new HashMap<>(wordCount);
    int wordsUsed = 0;

    // Each iteration will check for a match in words
    for (int j = i; j < i + substringSize; j += wordLength) {
      // Extract the substring of wordLength starting from index j
      String sub = s.substring(j, j + wordLength);
      // Check if the substring exists in the remaining words and its count is greater than 0
      if (remaining.getOrDefault(sub, 0) != 0) {
        remaining.put(sub, remaining.get(sub) - 1);
        wordsUsed++;
      } else {
        break;
      }
    }

    // Return true if all words are used to form a valid substring, otherwise false
    return wordsUsed == k;
  }

  /**
   * Finds all starting indices of concatenated substrings in the given string s.
   */
  public List<Integer> findSubstring(String s, String[] words) {
    List<Integer> indices = new ArrayList<>();
    // Edge case handling
    if (words.length == 0 || words[0].length() == 0 || s.length() == 0) {
      return indices;
    }

    // Initialize wordCount, wordLength, substringSize, and k
    wordCount = new HashMap<>();
    wordLength = words[0].length();
    k = words.length;
    substringSize = wordLength * k;

    // Populate the wordCount hashmap with the frequency of each word
    for (String word : words) {
      wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
    }

    // Iterate over each possible starting point in the string `s`
    for (int i = 0; i < s.length() - substringSize + 1; i++) {
      if (check(i, s)) {
        indices.add(i);
      }
    }

    return indices;
  }
}
```

### TypeScript

```typescript
/**
 * Finds all starting indices of concatenated substrings in the given string `s`
 * that match any permutation of the words in `words`.
 */
function findSubstring(s: string, words: string[]): number[] {
  const indices: number[] = [];

  // Edge case handling: return empty array if any input condition is invalid
  if (words.length === 0 || words[0].length === 0 || s.length === 0) {
    return indices;
  }

  // Initialize variables
  const wordCount: { [key: string]: number } = {};
  const wordLength = words[0].length;
  const k = words.length;
  const substringSize = wordLength * k;

  // Populate the wordCount hashmap with the frequency of each word
  for (const word of words) {
    wordCount[word] = (wordCount[word] || 0) + 1;
  }

  /**
   * Checks if a valid concatenated substring starts at index `i` in the given string `s`.
   */
  function check(i: number): boolean {
    const remaining = { ...wordCount }; // Copy the original word count for this index
    let wordsUsed = 0;

    // Iterate through the substring and check for matching words
    for (let j = i; j < i + substringSize; j += wordLength) {
      const sub = s.substring(j, j + wordLength);
      if (remaining[sub] != null && remaining[sub] > 0) {
        remaining[sub] -= 1;
        wordsUsed += 1;
      } else {
        return false; // Break the loop if the word is not found or count is zero
      }
    }

    return wordsUsed === k; // Return true if all words are used
  }

  // Iterate over each possible starting point in the string `s`
  for (let i = 0; i <= s.length - substringSize; i++) {
    if (check(i)) {
      indices.push(i); // Add the starting index to the result if valid
    }
  }

  return indices;
}
```

### Explanation
1. **Initialization**:
   - Create an array `indices` to store the starting indices of valid substrings.
   - Check for edge cases where `words` is empty, `words[0]` is empty, or `s` is empty.

2. **Counting Words**:
   - Create a hash table `wordCount` to track the frequency of each word in `words`.

3. **Check Function**:
   - Define the `check` function to verify if a valid substring starts at a given index `i`.
   - Use a copy of `wordCount` to keep track of remaining words needed for the current substring.
   - Iterate through the substring and update the remaining word counts.

4. **Finding Substrings**:
   - Iterate over all possible starting indices in `s`.
   - For each starting index, call the `check` function and collect indices that pass the check.

## **Complexity Analysis**

### Assumptions

1. Let `n` be the length of the input string `s`.
2. Let `k` be the number of words in the `words` array.
3. Let `b` be the length of each word in `words`.
4. Let `a` refer to `k` (the number of words).

### **Time Complexity**: `O(n * k * b - (k * b)^2)`
- **Problem Breakdown**: 
  - First, let's analyze the time complexity of `check`. We start by creating a copy of our hash table, which in the worst-case scenario (all words are unique) will take `O(k)` time.
  - Then, we iterate `k` times (from `i` to `i + substringSize`, `wordLength` at a time): `substringSize / wordLength = k`. At each iteration, we create a substring, which takes `b` time, and perform a hash table check.
  
- **Each Call to `check`**: 
  - Each call to the `check` function uses `O(k + k * (b + 1))` time, simplified to `O(k * b)`.
  
- **Total Number of Calls to `check`**:
  - We call the `check` function `n - k * b` times, where `substringSize` is `k * b`.

- **Overall Complexity**: 
  - Combining the above, the total time complexity is: 
    \[ O((n - k * b) * k * b) \]
  - Which can be expanded to: 
    \[ O(n * k * b - (k * b)^2) \]

### **Space Complexity**: `O(k)`
- **Hash Table Memory Usage**: 
  - Most of the extra memory usage is the hash table (`wordCount`) to store word counts. In the worst-case scenario (all unique words), we store up to `k` keys.
  
- **Substring Storage**: 
  - We also store substrings in a variable `sub`, which requires `O(b)` space.
  
- **Overall Space Complexity**: 
  - Combining the above, the total space complexity is: 
    \[ O(k + b) \]
  - However, because the upper bound for `b` is small (30), we can consider the space complexity to be: 
    \[ O(k) \]

# Optimized Sliding Window Approach

The previous sliding window implementation does involve some repeated computations for overlapping parts of the string `s`. For example, when processing substrings starting at different indices, it repeatedly computes the presence of the same words for overlapping parts. In the case of `s = "barfoobarfoo"` and `words = ["bar", "foo"]`, it would indeed recheck overlapping segments multiple times.

To optimize and avoid redundant computations, we can use a sliding window technique that adjusts the window dynamically and reuses previously computed results.

This optimized approach ensures that each character in `s` is processed only once, reducing redundant computations and improving overall efficiency.

## **Intuition**

In the previous approach, we iterated over each character in the string `s` multiple times, which led to repeated computations. For instance, consider:

```plaintext
s = "barfoobarfoo"
words = ["bar", "foo"]
```

Valid substrings start at indices 0, 3, and 6. Notice that substrings starting at indices 0 and 3 both include the same "foo". By iterating over the same characters more than once, we unnecessarily increase computational overhead. 

To avoid this, let's consider a sliding window approach that processes characters in `s` only once. Imagine you have:

```plaintext
s = "aaaa...aaa" (length = 10,000)
words = ["a", "a", ..., "a", "a"] (length = 5,000)
```

Iterating over the same characters millions of times becomes inefficient. By using a sliding window, we can efficiently identify all valid substrings in one pass.

### Sliding Window Mechanics

1. **Window Bounds**:
    - **Left Bound (`left`)**: Start at index 0.
    - **Right Bound (`right`)**: Moves by `wordLength` at each iteration.

2. **Window Size**:
    - When the window size reaches `substringSize` (i.e., the total length of concatenated words), we check for valid substrings.

### Iteration Process

1. **Initialization**:
    - Use a hash map (`wordCount`) to store the frequency of words from the list `words`.

2. **Sliding Window**:
    - Iterate `right` through `s` by `wordLength` increments. At each step:
      - Extract the word `sub = s.substring(right, right + wordLength)`.
      - If `sub` is not in `words`, reset the window and start over with the next iteration.
      - If `sub` is in `words`, track it using a hash map (`currentCount`) for the current window.

3. **Validation**:
    - When the window size reaches `substringSize`, check if it forms a valid substring:
      - Use `wordsUsed` to verify if all elements of `words` are used.
      - If valid, add `left` to the result list.

4. **Excess Words**:
    - If the count of `sub` in `currentCount` exceeds its count in `wordCount`, adjust the `left` bound to remove excess words until the window is valid.

5. **Avoid Redundant Starts**:
    - Instead of starting from every index, only start from indices that are `wordLength` apart. For example, with `words = ["foo", "bar"]`, starting from index 3 is redundant since it’s covered by index 0. However, we still need to start from indices 1 and 2 to handle cases like `s = "xfoobar"` or `s = "xyfoobar"`.

## **Algorithm**

### **1. Initialization**

- **n**: Length of the string `s`.
- **k**: Length of the list `words`.
- **wordLength**: Length of each word in `words`.
- **substringSize**: Total length of concatenated words (`wordLength * k`).
- **wordCount**: Hash table tracking the frequency of each word in `words`.
- **answer**: Array to store starting indices of valid substrings.

### **2. Sliding Window Function**

Create a function `slidingWindow` that takes an index `left` and starts a sliding window from `left`:

#### **2.1. Initialization Inside Function**
- **wordsFound**: Hash table to track the frequency of words in the current window.
- **wordsUsed**: Integer to keep track of the number of valid words in the window.
- **excessWord**: Boolean indicating if there is an excess word in the window (e.g., a third "foo" when `words = ["foo", "foo"]`).

#### **2.2. Iteration Process**

Using the right bound of our window, `right`:
- Start at `left` and iterate until `n`, moving `wordLength` at a time.
- At each iteration:
  1. **Extract Word**: `sub = s.substring(right, right + wordLength)`.
  2. **Check Word in wordCount**:
     - If `sub` is not in `wordCount`, reset the window:
       - Clear `wordsFound`.
       - Reset `wordsUsed` and `excessWord`.
       - Move `left` to `right + wordLength`.
     - If `sub` is in `wordCount`, proceed:
       - **Adjust Window for Excess Words**: 
         - While the window is beyond the max size or has an excess word, move `left` and update hash table and variables.
       - **Update wordsFound**: 
         - Increment the count of `sub` in `wordsFound`.
         - Compare the count in `wordsFound` with `wordCount`:
           - If the count is ≤ the count in `wordCount`, increment `wordsUsed`.
           - If it is greater, set `excessWord = true`.
       - **Check for Valid Substring**:
         - If `wordsUsed == k` and no excess words, add `left` to `answer`.

### **3. Apply Sliding Window**

- Call `slidingWindow` for each index from 0 to `wordLength`.
- Return `answer` once finished.

### **Pseudocode**

```pseudo
function findSubstring(s, words):
    n = length(s)
    k = length(words)
    wordLength = length(words[0])
    substringSize = wordLength * k
    wordCount = hashTable()

    for word in words:
        wordCount[word] += 1

    result = []

    for i from 0 to wordLength - 1:
        left = i
        right = i
        currentCount = hashTable()
        wordsUsed = 0

        while right + wordLength <= n:
            sub = s.substring(right, right + wordLength)
            right += wordLength

            if sub in wordCount:
                currentCount[sub] = currentCount.getOrDefault(sub, 0) + 1
                wordsUsed += 1

                while currentCount[sub] > wordCount[sub]:
                    leftWord = s.substring(left, left + wordLength)
                    currentCount[leftWord] -= 1
                    wordsUsed -= 1
                    left += wordLength

                if wordsUsed == k:
                    result.append(left)

            else:
                currentCount.clear()
                wordsUsed = 0
                left = right

    return result
```

## **Implementation**

### Java

```java
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Solution class to find starting indices of all concatenated substrings in a given string.
 */
class Solution2 {
  private int wordLength;
  private int k;

  /**
   * Finds all starting indices of concatenated substrings in the given string s.
   *
   * @param s the given string
   * @param words the array of words
   * @return the list of starting indices of concatenated substrings
   */
  public List<Integer> findSubstring(String s, String[] words) {
    List<Integer> indices = new ArrayList<>();
    if (words.length == 0 || words[0].length() == 0 || s.length() == 0) {
      return indices;
    }

    // Initialize wordLength and k
    wordLength = words[0].length();
    k = words.length;

    // Populate the wordCount map with the frequency of each word
    Map<String, Integer> wordCount = new HashMap<>();
    for (String word : words) {
      wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
    }

    // Iterate over each possible starting point in the string `s`
    for (int i = 0; i < wordLength; i++) {
      slidingWindow(i, s, wordCount, indices);
    }

    return indices;
  }

  /**
   * Applies a sliding window approach to find valid starting indices.
   *
   * @param start the starting index for the sliding window
   * @param s the given string
   * @param wordCount the map containing word frequencies
   * @param indices the list of starting indices of concatenated substrings
   */
  private void slidingWindow(int start, String s, Map<String, Integer> wordCount,
      List<Integer> indices) {
    Map<String, Integer> currentCount = new HashMap<>();
    int wordsUsed = 0;
    int left = start;

    // Iterate over the string `s` in steps of wordLength
    for (int right = start; right + wordLength <= s.length(); right += wordLength) {
      String sub = s.substring(right, right + wordLength);

      // If the word is part of the words array
      if (wordCount.containsKey(sub)) {
        currentCount.put(sub, currentCount.getOrDefault(sub, 0) + 1);
        wordsUsed++;

        // If there are more occurrences of "sub" than needed, slide the window to the right
        while (currentCount.get(sub) > wordCount.get(sub)) {
          String leftWord = s.substring(left, left + wordLength);
          currentCount.put(leftWord, currentCount.get(leftWord) - 1);
          wordsUsed--;
          left += wordLength;
        }

        // If all words are used, record the starting index
        if (wordsUsed == k) {
          indices.add(left);
        }
      } else {
        // Reset the window if the word is not part of the words array
        currentCount.clear();
        wordsUsed = 0;
        left = right + wordLength;
      }
    }
  }
}
```

### TypeScript

```typescript
/**
 * Finds all starting indices of concatenated substrings in the given string.
 * 
 * @param s - The input string to search in.
 * @param words - The array of words to form concatenated substrings.
 * @returns An array of starting indices of the concatenated substrings.
 */
function findSubstring(s: string, words: string[]): number[] {
  const indices: number[] = [];
  if (words.length === 0 || words[0].length === 0 || s.length === 0) {
    return indices;
  }

  const wordLength = words[0].length;  // Length of each word
  const k = words.length;  // Total number of words
  const wordCount: Map<string, number> = new Map();

  // Populate the wordCount map with the frequency of each word
  for (const word of words) {
    wordCount.set(word, (wordCount.get(word) || 0) + 1);
  }

  // Iterate over each possible starting point in the string `s`
  for (let i = 0; i < wordLength; i++) {
    slidingWindow(i, s, wordCount, indices, wordLength, k);
  }

  return indices;
}

/**
 * Applies a sliding window approach to find valid starting indices.
 * 
 * @param start - The starting index for the sliding window.
 * @param s - The input string to search in.
 * @param wordCount - The map containing word frequencies.
 * @param indices - The list of starting indices of concatenated substrings.
 * @param wordLength - The length of each word.
 * @param k - The total number of words.
 */
function slidingWindow(
  start: number,
  s: string,
  wordCount: Map<string, number>,
  indices: number[],
  wordLength: number,
  k: number
): void {
  const currentCount: Map<string, number> = new Map();
  let wordsUsed = 0;  // Count of words used in the current window
  let left = start;  // Left pointer for the sliding window

  // Iterate over the string `s` in steps of wordLength
  for (let right = start; right + wordLength <= s.length; right += wordLength) {
    const sub = s.substring(right, right + wordLength);

    // If the word is part of the words array
    if (wordCount.has(sub)) {
      currentCount.set(sub, (currentCount.get(sub) || 0) + 1);
      wordsUsed++;

      // If there are more occurrences of "sub" than needed, slide the window to the right
      while ((currentCount.get(sub) || 0) > (wordCount.get(sub) || 0)) {
        const leftWord = s.substring(left, left + wordLength);
        currentCount.set(leftWord, (currentCount.get(leftWord) || 0) - 1);
        wordsUsed--;
        left += wordLength;
      }

      // If all words are used, record the starting index
      if (wordsUsed === k) {
        indices.push(left);
      }
    } else {
      // Reset the window if the word is not part of the words array
      currentCount.clear();
      wordsUsed = 0;
      left = right + wordLength;
    }
  }
}
```

#### Explanation

1. **Initialization**: Check for edge cases where the input string or words array might be empty and initialize essential variables (`wordLength`, `k`, `wordCount`).
2. **Multiple Sliding Windows**: Start multiple sliding windows from indices within the first `wordLength` characters to ensure we check all possible concatenated substrings.
3. **Adjustable Window**: Dynamically adjust the window by moving the `left` and `right` pointers, maintaining a window of words of the correct length.
4. **Reuse Computations**: Maintain the count of words in the current window (`currentCount`) to reuse previously computed results and avoid redundant calculations.
5. **Early Termination**: Clear `currentCount` and reset `wordsUsed` whenever encountering a word not in the provided `words` array to avoid unnecessary checks.
6. **Add Valid Indices**: Whenever a valid concatenated substring is found (when `wordsUsed` equals `k`), add the starting index of that substring to the `indices` list.

These steps ensure an efficient search for all starting indices of concatenated substrings formed by the `words` array in the given string `s`.