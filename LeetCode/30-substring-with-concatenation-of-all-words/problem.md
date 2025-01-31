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

