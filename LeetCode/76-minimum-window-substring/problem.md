# 76. Minimum Window Substring

<p>Given two strings <code>s</code> and <code>t</code> of lengths <code>m</code> and <code>n</code> respectively, return <em>the <strong>minimum window</strong></em> <strong><em>substring</em></strong> of </em><code>s</code><em> such that every character in </em><code>t</code><em> (<strong>including duplicates</strong>) is included in the window</em>. If there is no such substring, return <em>the empty string </em><code>""</code>.</p>

- A **substring** is a contiguous **non-empty sequence** of characters within a string.

<p>The testcases will be generated such that the answer is <strong>unique</strong>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> s = "ADOBECODEBANC", t = "ABC"
<strong>Output:</strong> "BANC"
<strong>Explanation:</strong> The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> s = "a", t = "a"
<strong>Output:</strong> "a"
<strong>Explanation:</strong> The entire string s is the minimum window.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> s = "a", t = "aa"
<strong>Output:</strong> ""
<strong>Explanation:</strong> Both 'a's from t must be included in the window.
Since the largest window of s only has one 'a', return empty string.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
  <li><code>m == s.length</code></li>
  <li><code>n == t.length</code></li>
  <li><code>1 &lt;= m, n &lt;= 10<sup>5</sup></code></li>
  <li><code>s</code> and <code>t</code> consist of uppercase and lowercase English letters.</li>
</ul>

<p>&nbsp;</p>
<p><strong>Follow up:</strong> Could you find an algorithm that runs in <code>O(m + n)</code> time?</p>

<br>

---

# Solution

- [**Sliding Window Approach**](#sliding-window-approach)

# Sliding Window Approach

## **Intuition**

The problem asks us to return the minimum window from the string `S` that contains all the characters of the string `T`. Let's call a window **valid** if it contains all the characters from `T`.

We can use a sliding window approach to solve this problem. This approach involves maintaining a window with two pointers: a right pointer that expands the current window and a left pointer that contracts it. At any given time, only one of these pointers moves while the other remains fixed.

The solution is intuitive. We keep expanding the window by moving the right pointer. When the window becomes valid (contains all desired characters), we try to contract it (if possible) to save the smallest window seen so far.

The answer is the smallest valid window.

For example, given `S = "ABAACBAB"` and `T = "ABC"`, our answer window is "ACB". Below is one of the possible valid windows.

## **Algorithm**

1. We start with two pointers, `left` and `right`, both initially pointing to the first element of the string `S`.

2. We use the right pointer to expand the window until we get a valid window, i.e., a window that contains all the characters of `T`.

3. Once we have a valid window, we move the left pointer ahead one step at a time. If the window remains valid, we keep updating the minimum window size.

4. If the window is no longer valid, we repeat step 2 onward.

### Steps

#### **Initialization**

  - Create a frequency map for all characters in `T`.
  - Initialize two pointers, `left` and `right`, both set to the beginning of `S`.
  - Maintain a count of required characters from `T` and initialize a variable to track the number of characters matched so far.
  - Keep a minimum length for the valid window and store the start index of that window.

#### **Expanding and Contracting the Window**

  - Expand the window by moving the right pointer.
  - Include the character at the right pointer in the window and update the matched character count.
  - Check if the current window is valid.
  - If valid, attempt to contract the window by moving the left pointer.
  - Keep updating the minimum valid window length and start index.

