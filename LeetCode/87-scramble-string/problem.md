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

#### **Step 1: Base Case Initialization**
- Iterate `i` from `0` to `n-1`.
  - Iterate `j` from `0` to `n-1`.
    - Set `dp[1][i][j]` to `true` if `s1[i] == s2[j]`, otherwise `false`.  
      _(This establishes the base case for substrings of length 1.)_

#### **Step 2: Transition Logic**
- Iterate `length` from `2` to `n`. _(Expanding substring sizes)_
  - Iterate `i` from `0` to `n + 1 - length`. _(Starting index in `s1`)_
  - Iterate `j` from `0` to `n + 1 - length`. _(Starting index in `s2`)_
  - Iterate `newLength` from `1` to `length - 1`. _(Possible split points)_

#### **Step 3: Checking Scramble Possibilities**
- If either condition holds:
  1. **Without Swap:**  
     ```
     dp[newLength][i][j] && dp[length - newLength][i + newLength][j + newLength]
     ```
  2. **With Swap:**  
     ```
     dp[newLength][i][j + length - newLength] && dp[length - newLength][i + newLength][j]
     ```
  - Set `dp[length][i][j] = true`.

#### **Step 4: Return Final Result**
- The solution is stored in:
  ```
  dp[n][0][0]
  ```
  _(Determining if `s2` is a scrambled version of `s1`.)_

### **Pseudocode**

```plaintext
FUNCTION isScramble(s1, s2):
  IF s1 == s2: RETURN True  // Base case: identical strings are trivially scrambled
  IF length of s1 ≠ length of s2: RETURN False  // Different length strings cannot be scrambled versions

  key = s1 + "_" + s2
  IF key exists in memo: RETURN memo[key]  // Retrieve stored result if available

```