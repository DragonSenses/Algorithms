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

## **Algorithm**

1. Compute the frequency count of characters in p.
2. Use a sliding window of size len(p) over s.
3. Maintain a running frequency count for the current window.
4. When the window size matches len(p), compare the window count with p's count.
5. If they match, record the starting index.
6. Slide the window forward by removing the leftmost character and adding the next character.
7. Continue until the end of s.

### **Pseudocode**

```
function findAnagrams(s, p):
  result = empty list
  if length(s) < length(p):
    return result

  pCount = array[26] initialized to 0
  windowCount = array[26] initialized to 0

  for each char c in p:
    pCount[c - 'a']++

  windowSize = length(p)

  for i from 0 to length(s) - 1:
    windowCount[s[i] - 'a']++

    if i >= windowSize:
      windowCount[s[i - windowSize] - 'a']--

    if windowCount equals pCount:
      result.add(i - windowSize + 1)

  return result
```

## **Implementation**

### Java

```java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
  public List<Integer> findAnagrams(String s, String p) {
    List<Integer> result = new ArrayList<>();
    if (s.length() < p.length())
      return result;

    int[] pCount = new int[26];
    int[] windowCount = new int[26];

    for (char c : p.toCharArray()) {
      pCount[c - 'a']++;
    }

    int windowSize = p.length();

    for (int i = 0; i < s.length(); i++) {
      windowCount[s.charAt(i) - 'a']++;

      if (i >= windowSize) {
        windowCount[s.charAt(i - windowSize) - 'a']--;
      }

      if (Arrays.equals(windowCount, pCount)) {
        result.add(i - windowSize + 1);
      }
    }

    return result;
  }
}
```

### TypeScript

```TypeScript
function findAnagrams(s: string, p: string): number[] {
  const result: number[] = [];
  if (s.length < p.length) return result;

  const pCount = new Array(26).fill(0);
  const windowCount = new Array(26).fill(0);

  for (const c of p) {
    pCount[c.charCodeAt(0) - 97]++;
  }

  const windowSize = p.length;

  for (let i = 0; i < s.length; i++) {
    windowCount[s.charCodeAt(i) - 97]++;

    if (i >= windowSize) {
      windowCount[s.charCodeAt(i - windowSize) - 97]--;
    }

    let match = true;
    for (let j = 0; j < 26; j++) {
      if (windowCount[j] !== pCount[j]) {
        match = false;
        break;
      }
    }

    if (match) {
      result.push(i - windowSize + 1);
    }
  }

  return result;
}
```

## **Complexity Analysis**

### **Assumptions**
- Let n be the length of s.
- The alphabet size is fixed at 26 lowercase letters.
- Comparing two frequency arrays is O(1) because the size is constant.
