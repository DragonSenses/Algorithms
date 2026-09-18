# 438. Find All Anagrams in a String

<p>Given two strings <code>s</code> and <code>p</code>, return an array of all the start indices of <code>p</code>'s <span data-keyword="anagram" class=" cursor-pointer relative text-dark-blue-s text-sm"><button type="button" aria-haspopup="dialog" aria-expanded="false" aria-controls="radix-_r_t_" data-state="closed" class="">anagrams</button></span> in <code>s</code>. You may return the answer in <strong>any order</strong>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> s = "cbaebabacd", p = "abc"
<strong>Output:</strong> [0,6]
<strong>Explanation:</strong>
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> s = "abab", p = "ab"
<strong>Output:</strong> [0,1,2]
<strong>Explanation:</strong>
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length, p.length &lt;= 3 * 10<sup>4</sup></code></li>
	<li><code>s</code> and <code>p</code> consist of lowercase English letters.</li>
</ul>

# Solution

- [Sliding Window Approach](#sliding-window-approach)

## **Problem Overview: Find All Anagrams in a String**

You are given two lowercase strings, **s** (the main text) and **p** (the pattern). Your task is to find every position in **s** where a substring is an anagram of **p**. An anagram means the characters match exactly in frequency, just arranged differently.

The output should be a list of starting indices in **s** where these anagram‑substrings occur.

### Examples
**Example 1**  
s = "cbaebabacd"  
p = "abc"  
Valid anagrams of "abc" include "cba" and "bac".  
These appear starting at indices **0** and **6**, so the output is `[0, 6]`.

**Example 2**  
s = "abab"  
p = "ab"  
Valid anagrams of "ab" include "ab" and "ba".  
These appear at indices **0**, **1**, and **2**, so the output is `[0, 1, 2]`.

### Constraint
- Lengths of **s** and **p** are between 1 and 30000.
- Both strings contain only lowercase English letters.
- Output order does not matter.

# Sliding Window Approach

## **Intuition**

We want to find every position in the string s where a substring is an anagram of p. An anagram is defined by matching character frequencies, not order. Since p has a fixed length, we can slide a window of that length across s and maintain character counts dynamically. This avoids recomputing counts from scratch and keeps the solution linear.
