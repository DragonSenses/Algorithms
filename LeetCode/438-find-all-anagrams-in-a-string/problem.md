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

This problem is one of the standard examples used to teach the sliding‑window pattern, especially the fixed‑length variant where the window size never changes and you only update counts as you move across the string.

You slide a window across s. The window size is always len(p). At each position, check whether the substring inside that window uses the same characters with the same counts as p. If it does, record the starting index.

This is a classic pattern‑matching problem that tests your ability to:

Track character frequencies efficiently.

Use a sliding window to avoid recomputing counts from scratch.

Work within constraints where s and p can be up to 30000 characters long, so naive solutions will be too slow.