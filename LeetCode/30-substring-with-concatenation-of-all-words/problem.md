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
import java.util.Map;

public class Solution {

  public List<Integer> findSubstring(String s, String[] words) {
    List<Integer> result = new ArrayList<>();
    if (s == null || words == null || words.length == 0) {
      return result;
    }

    int n = s.length();
    int k = words.length;
    int wordLength = words[0].length();
    int substringSize = wordLength * k;

    // Step 1: Initialize the word count hash table
    Map<String, Integer> wordCount = new HashMap<>();
    for (String word : words) {
      wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
    }

    // Step 3: Check all possible starting indices
    for (int i = 0; i <= n - substringSize; i++) {
      if (check(s, i, wordLength, k, wordCount)) {
        result.add(i);
      }
    }

    return result;
  }

  private boolean check(String s, int start, int wordLength, int k,
      Map<String, Integer> wordCount) {
    // Create a copy of wordCount for the current index
    Map<String, Integer> remaining = new HashMap<>(wordCount);
    int wordsUsed = 0;

    // Step 2: Iterate through the substring in groups of wordLength
    for (int j = start; j < start + k * wordLength; j += wordLength) {
      String sub = s.substring(j, j + wordLength);
      if (remaining.containsKey(sub) && remaining.get(sub) > 0) {
        remaining.put(sub, remaining.get(sub) - 1);
        wordsUsed++;
      } else {
        return false;
      }
    }

    return wordsUsed == k;
  }
}
```

### TypeScript

```typescript
function findSubstring(s: string, words: string[]): number[] {
    const result: number[] = [];
    if (!s || words.length === 0) {
        return result;
    }

    const n = s.length;
    const k = words.length;
    const wordLength = words[0].length;
    const substringSize = wordLength * k;
    
    const wordCount: { [key: string]: number } = {};
    for (const word of words) {
        wordCount[word] = (wordCount[word] || 0) + 1;
    }

    const check = (start: number): boolean => {
        const remaining: { [key: string]: number } = { ...wordCount };
        let wordsUsed = 0;

        for (let j = start; j < start + k * wordLength; j += wordLength) {
            const sub = s.substr(j, wordLength);
            if (remaining[sub] && remaining[sub] > 0) {
                remaining[sub]--;
                wordsUsed++;
            } else {
                return false;
            }
        }

        return wordsUsed === k;
    };

    for (let i = 0; i <= n - substringSize; i++) {
        if (check(i)) {
            result.push(i);
        }
    }

    return result;
}
```

### Explanation:
1. **Initialization**: Variables are initialized to keep track of the length of the string, the length of the words array, and other necessary values.
2. **Word Count**: A hash table (`wordCount`) is created to count the frequency of each word in the `words` array.
3. **Sliding Window**: Iterate over possible starting indices and use an auxiliary function (`check`) to verify if a valid substring starts at each index.
4. **Auxiliary Function**: This function checks if the substring starting from a given index contains all words with the required frequency.

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

