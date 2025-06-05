# 87. Scramble String

<p>We can scramble a string s to get a string t using the following algorithm:</p>

<ol>
  <li>If the length of the string is 1, stop.</li>
  <li>If the length of the string is &gt; 1, do the following:
  <ul>
    <li>Split the string into two non-empty substrings at a random index, i.e., if the string is <code>s</code>, divide it to <code>x</code> and <code>y</code> where <code>s = x + y</code>.</li>
    <li><strong>Randomly</strong>&nbsp;decide to swap the two substrings or to keep them in the same order. i.e., after this step, <code>s</code> may become <code>s = x + y</code> or <code>s = y + x</code>.</li>
    <li>Apply step 1 recursively on each of the two substrings <code>x</code> and <code>y</code>.</li>
  </ul>
  </li>
</ol>

<p>Given two strings <code>s1</code> and <code>s2</code> of <strong>the same length</strong>, return <code>true</code> if <code>s2</code> is a scrambled string of <code>s1</code>, otherwise, return <code>false</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> s1 = "great", s2 = "rgeat"
<strong>Output:</strong> true
<strong>Explanation:</strong> One possible scenario applied on s1 is:
"great" --&gt; "gr/eat" // divide at random index.
"gr/eat" --&gt; "gr/eat" // random decision is not to swap the two substrings and keep them in order.
"gr/eat" --&gt; "g/r / e/at" // apply the same algorithm recursively on both substrings. divide at random index each of them.
"g/r / e/at" --&gt; "r/g / e/at" // random decision was to swap the first substring and to keep the second substring in the same order.
"r/g / e/at" --&gt; "r/g / e/ a/t" // again apply the algorithm recursively, divide "at" to "a/t".
"r/g / e/ a/t" --&gt; "r/g / e/ a/t" // random decision is to keep both substrings in the same order.
The algorithm stops now, and the result string is "rgeat" which is s2.
As one possible scenario led s1 to be scrambled to s2, we return true.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> s1 = "abcde", s2 = "caebd"
<strong>Output:</strong> false
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> s1 = "a", s2 = "a"
<strong>Output:</strong> true
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
  <li><code>s1.length == s2.length</code></li>
  <li><code>1 &lt;= s1.length &lt;= 30</code></li>
  <li><code>s1</code> and <code>s2</code> consist of lowercase English letters.</li>
</ul>

---

# Solution

- [Dynamic Programming Approach](#dynamic-programming-approach)

### Problem Overview: Scramble String

#### Definition
A string `s` can be scrambled into another string `t` using a recursive algorithm:

1. If the length of `s` is `1`, stop.
2. If the length of `s` is greater than `1`, perform the following steps:
   - Split `s` into two non-empty substrings at a random index, `s = x + y`.
   - Randomly decide whether to swap the two substrings or keep them in order (`s = x + y` or `s = y + x`).
   - Recursively apply the process to both `x` and `y`.

Given two strings `s1` and `s2` of the same length, determine whether `s2` is a scrambled version of `s1`.

#### Examples

##### Example 1:
- **Input:** `s1 = "great"`, `s2 = "rgeat"`
- **Output:** `true`
- **Explanation:**  
  One possible transformation of `"great"`:
  ```
  "great" → "gr/eat" (split at random index)  
  "gr/eat" → "gr/eat" (no swap)  
  "gr/eat" → "g/r / e/at" (recursive split)  
  "g/r / e/at" → "r/g / e/at" (swap `g` and `r`)  
  "r/g / e/at" → "r/g / e/ a/t" (split `at`)  
  "r/g / e/ a/t" → "r/g / e/ a/t" (no swaps)  
  ```
  Since `s1` can be transformed into `s2`, return `true`.

##### Example 2:
- **Input:** `s1 = "abcde"`, `s2 = "caebd"`
- **Output:** `false`

##### Example 3:
- **Input:** `s1 = "a"`, `s2 = "a"`
- **Output:** `true`

#### Constraints
- `s1.length == s2.length`
- `1 <= s1.length <= 30`
- `s1` and `s2` consist of lowercase English letters.

# Dynamic Programming Approach

### Memoization

**Memoization** is an optimization technique used in dynamic programming to store previously computed results and avoid redundant calculations. Instead of solving the same subproblem multiple times, we save its solution in a **lookup table** (like a 3D array `dp[length][i][j]`).  

Whenever we need the result of a subproblem, we **first check the table** — if it's already computed, we retrieve it instantly rather than recomputing. This significantly **reduces the time complexity** and improves efficiency, especially for recursive solutions with overlapping subproblems.  

## **Intuition**

We define scrambling recursively. Given a string `s`, we:
1. Split `s` into two non-empty substrings `x` and `y` (`s = x + y`).
2. Either keep `x` and `y` in order (`x + y`) or swap them (`y + x`).
3. Recursively scramble `x` and `y`, producing `x'` and `y'`.
4. The final scrambled string becomes `x' + y'` or `y' + x'`.

To determine if `t` is a scrambled version of `s`, we:
- Choose a split index, dividing `s` into `x` and `y`.
- Check if `t` can be divided into `x'` and `y'` (with or without swapping).
- Solve the smaller subproblems recursively using dynamic programming.

#### **Defining DP State**
We have two strings `s1` and `s2`.

Each DP state is defined by three variables:
- **length**: The size of the substring being considered.
- **i**: The starting index in `s1`.
- **j**: The starting index in `s2`.

Let `dp[length][i][j]` be a boolean indicating whether the substring of `s2` (starting at index `j` with length `length`) is a scrambled version of the substring of `s1` (starting at index `i` with length `length`).

#### **Base Case**
If `length == 1`, we simply compare the characters:
- `dp[1][i][j] = (s1[i] == s2[j])`

#### **Transition Formula**
For `length > 1`, we must split `s1` at all possible indices `newLength`, where `0 < newLength < length`, creating:
- A **left** substring (`s1[i : i + newLength]`)
- A **right** substring (`s1[i + newLength : i + length]`)

For each split, there are **two cases**:
1. **No Swap:** The corresponding substrings in `s2` must match the split order:
   ```
   dp[newLength][i][j] && dp[length - newLength][i + newLength][j + newLength]
   ```
2. **Swap:** The substrings of `s1` and `s2` are swapped:
   ```
   dp[newLength][i][j + length - newLength] && dp[length - newLength][i + newLength][j]
   ```

Thus, our **final transition formula** is:
```
dp[length][i][j] = True if for at least one valid `newLength`:
(dp[newLength][i][j] && dp[length - newLength][i + newLength][j + newLength]) 
   OR 
(dp[newLength][i][j + length - newLength] && dp[length - newLength][i + newLength][j])
```

#### **Final Answer**
The problem solution is found at:
```
dp[n][0][0]
```
where `n` is the length of the input strings.

## **Algorithm**

### **1. Problem Statement**
Given two strings `s1` and `s2`, determine whether `s2` is a **scrambled version** of `s1`. A string `s1` can be scrambled into `s2` by recursively dividing it into two non-empty **substrings** and swapping or keeping them in place.

### **2. Approach Overview**
We use **recursion** with **memoization** to avoid recomputation. The algorithm:
- **Breaks `s1` into substrings** at all possible split points.
- **Recursively checks** whether `s2` can be obtained via either a direct match **(no swap)** or a swapped match **(swap)**.
- **Caches results** using a hashmap or dictionary to optimize repeated calculations.

### **3. Algorithm Steps**
1. **Base Case Handling**  
   - If `s1 == s2`, return `True` (trivially scrambled).
   - If `s1.length ≠ s2.length`, return `False` (not a valid scramble).

2. **Memoization Lookup**  
   - Generate a unique key using `s1` and `s2`.
   - If this result is already **computed**, retrieve it from the cache.

3. **Character Frequency Matching**  
   - Compute frequency counts of letters in both strings.
   - If **frequency mismatch exists**, return `False` (strings cannot be a scramble of each other).

4. **Recursive Substring Validation**  
   - Try **every possible split** (`len = 1` to `n-1`).
   - Check two scenarios at each split:
     - **No Swap Condition**  
       - `s1[0:len]` matches `s2[0:len]`  
       - `s1[len:n]` matches `s2[len:n]`
     - **Swap Condition**  
       - `s1[0:len]` matches `s2[n-len:n]`  
       - `s1[len:n]` matches `s2[0:n-len]`

5. **Store Computed Result**  
   - If either condition evaluates to `True`, **cache and return `True`**.
   - Otherwise, **cache and return `False`**.

### **Pseudocode**

```plaintext
FUNCTION isScramble(s1, s2):
    IF s1 == s2:
        RETURN True
    
    IF length(s1) ≠ length(s2):
        RETURN False

    key = s1 + "_" + s2
    IF key in memo:
        RETURN memo[key]

    # Step 1: Compare character frequencies
    frequency = ARRAY[26] filled with 0
    FOR i FROM 0 TO length(s1) - 1:
        frequency[s1[i] - 'a']++
        frequency[s2[i] - 'a']--
    
    IF frequency contains nonzero values:
        memo[key] = False
        RETURN False

    # Step 2: Try all split points
    n = length(s1)
    FOR len FROM 1 TO n - 1:
        IF (isScramble(s1[0:len], s2[0:len]) AND isScramble(s1[len:n], s2[len:n])) OR
           (isScramble(s1[0:len], s2[n-len:n]) AND isScramble(s1[len:n], s2[0:n-len])) :
            memo[key] = True
            RETURN True

    memo[key] = False
    RETURN False
```

## **Implementation**

#### Implementation Details

In Java, the `charAt()` function returns the character at a specified index in a string. In TypeScript (and JavaScript), `charCodeAt(i)` returns the **ASCII value** of a character.  

Since `'a'` has an ASCII value of **97**, subtracting 97 from any lowercase letter (`'a'` to `'z'`) gives its **zero-based index** in the alphabet.  

For example:  
- `'a'.charCodeAt(0) - 97 → 0` (index for `'a'`)  
- `'b'.charCodeAt(0) - 97 → 1` (index for `'b'`)  
- `'z'.charCodeAt(0) - 97 → 25` (index for `'z'`)  

This lets you efficiently map characters to array indices for counting frequencies.

### Java

```java
import java.util.HashMap;
import java.util.Map;

/**
 * This class implements the scramble string algorithm using dynamic programming with memoization.
 */
class Solution {
  // Memoization map to store previously computed scramble results
  private Map<String, Boolean> cache = new HashMap<>();

  /**
   * Checks if s2 is a scrambled version of s1.
   *
   * @param s1 The original string.
   * @param s2 The scrambled string to validate.
   * @return True if s2 is a scrambled version of s1, otherwise false.
   */
  public boolean isScramble(String s1, String s2) {
    // If both strings are identical, return true (trivially scrambled)
    if (s1.equals(s2)) {
      return true;
    }

    // If the lengths differ, it's impossible to be a scramble
    if (s1.length() != s2.length()) {
      return false;
    }

    // Generate a unique key for memoization using both strings
    String key = s1 + "_" + s2;

    // If result for this pair of strings is already computed, return the stored value
    if (cache.containsKey(key)) {
      return cache.get(key);
    }

    int n = s1.length();
    int[] count = new int[26]; // Frequency array to compare character counts in s1 and s2

    // Count frequency of characters in both strings
    for (int i = 0; i < n; i++) {
      count[s1.charAt(i) - 'a']++; // Increment count for s1's characters
      count[s2.charAt(i) - 'a']--; // Decrement count for s2's characters
    }

    // If character counts mismatch, s2 cannot be a scrambled version of s1
    for (int c : count) {
      if (c != 0) {
        cache.put(key, false);
        return false;
      }
    }

    // Iterate over possible split points of the string
    for (int len = 1; len < n; len++) {
      // Check two possible scramble conditions:
      // 1. No swap: First half of s1 matches first half of s2, second half matches second half
      // 2. Swap: First half of s1 matches second half of s2, and vice versa
      if (isScrambleNoSwap(s1, s2, len) || isScrambleWithSwap(s1, s2, len)) {
        // Store result in memoization and return true
        cache.put(key, true);
        return true;
      }
    }

    // If no valid scrambling was found, store and return false
    cache.put(key, false);
    return false;
  }

  /**
   * Checks if s2 is a scrambled version of s1 without swapping substrings.
   *
   * @param s1 The original string.
   * @param s2 The scrambled string.
   * @param len The split length.
   * @return True if the scramble is valid without swapping, otherwise false.
   */
  private boolean isScrambleNoSwap(String s1, String s2, int len) {
    return isScramble(s1.substring(0, len), s2.substring(0, len))
        && isScramble(s1.substring(len), s2.substring(len));
  }

  /**
   * Checks if s2 is a scrambled version of s1 with swapped substrings.
   *
   * @param s1 The original string.
   * @param s2 The scrambled string.
   * @param len The split length.
   * @return True if the scramble is valid with swapping, otherwise false.
   */
  private boolean isScrambleWithSwap(String s1, String s2, int len) {
    int n = s1.length();
    return isScramble(s1.substring(0, len), s2.substring(n - len))
        && isScramble(s1.substring(len), s2.substring(0, n - len));
  }
}
```

### TypeScript

```typescript
const memo = new Map<string, boolean>();

/**
 * Determines if one string is a scrambled version of another.
 *
 * @param {string} s1 - The original string.
 * @param {string} s2 - The string to verify as a scrambled version of s1.
 * @returns {boolean} `true` if s2 is a valid scramble of s1, otherwise `false`.
 */
function isScramble(s1: string, s2: string): boolean {
  // Base case: identical strings are trivially scrambled
  if (s1 === s2) return true;

  // If lengths differ, it's impossible for s2 to be a scrambled version of s1
  if (s1.length !== s2.length) return false;

  // Generate a unique memoization key based on both strings
  const key = `${s1}_${s2}`;

  // Return precomputed result if available
  if (memo.has(key)) return memo.get(key)!;

  // If character frequencies mismatch, s2 cannot be a scrambled version of s1
  if (!hasMatchingCharacterCounts(s1, s2)) {
    memo.set(key, false);
    return false;
  }

  const n = s1.length;

  for (let len = 1; len < n; len++) {
    if (isScrambleNoSwap(s1, s2, len) || isScrambleWithSwap(s1, s2, len)) {
      memo.set(key, true);
      return true;
    }
  }

  memo.set(key, false);
  return false;
}

/**
 * Checks if s2 has the same character frequencies as s1.
 *
 * @param {string} s1 - The original string.
 * @param {string} s2 - The scrambled string.
 * @returns {boolean} `true` if character frequencies match, otherwise `false`.
 */
function hasMatchingCharacterCounts(s1: string, s2: string): boolean {
  const count = new Array(26).fill(0); // Frequency array to compare character counts

  // Count frequency of characters in both strings
  for (let i = 0; i < s1.length; i++) {
    count[s1.charCodeAt(i) - 97]++; // Increment frequency for s1
    count[s2.charCodeAt(i) - 97]--; // Decrement frequency for s2
  }

  // If character frequencies mismatch, s2 cannot be a scrambled version of s1
  return !count.some((c) => c !== 0);
}

/**
 * Checks if s2 is a scrambled version of s1 without swapping substrings.
 *
 * @param {string} s1 - The original string.
 * @param {string} s2 - The scrambled string.
 * @param {number} len - The split length.
 * @returns {boolean} `true` if the scramble is valid without swapping, otherwise `false`.
 */
function isScrambleNoSwap(s1: string, s2: string, len: number): boolean {
  return (
    isScramble(s1.substring(0, len), s2.substring(0, len)) &&
    isScramble(s1.substring(len), s2.substring(len))
  );
}

/**
 * Checks if s2 is a scrambled version of s1 with swapped substrings.
 *
 * @param {string} s1 - The original string.
 * @param {string} s2 - The scrambled string.
 * @param {number} len - The split length.
 * @returns {boolean} `true` if the scramble is valid with swapping, otherwise `false`.
 */
function isScrambleWithSwap(s1: string, s2: string, len: number): boolean {
  const n = s1.length;
  return (
    isScramble(s1.substring(0, len), s2.substring(n - len)) &&
    isScramble(s1.substring(len), s2.substring(0, n - len))
  );
}
```
