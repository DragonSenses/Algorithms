# 93. Restore IP Addresses

<p>A <strong>valid IP address</strong> consists of exactly four integers separated by single dots. Each integer is between <code>0</code> and <code>255</code> (<strong>inclusive</strong>) and cannot have leading zeros.</p>

<ul>
  <li>For example, <code>"0.1.2.201"</code> and <code>"192.168.1.1"</code> are <strong>valid</strong> IP addresses, but <code>"0.011.255.245"</code>, <code>"192.168.1.312"</code> and <code>"192.168@1.1"</code> are <strong>invalid</strong> IP addresses.</li>
</ul>

<p>Given a string <code>s</code> containing only digits, return <em>all possible valid IP addresses that can be formed by inserting dots into </em><code>s</code>. You are <strong>not</strong> allowed to reorder or remove any digits in <code>s</code>. You may return the valid IP addresses in <strong>any</strong> order.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> s = "25525511135"
<strong>Output:</strong> ["255.255.11.135","255.255.111.35"]
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> s = "0000"
<strong>Output:</strong> ["0.0.0.0"]
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> s = "101023"
<strong>Output:</strong> ["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
  <li><code>1 &lt;= s.length &lt;= 20</code></li>
  <li><code>s</code> consists of digits only.</li>
</ul>

<br>

---

# Solution

- [Backtracking Approach](#backtracking-approach)

# Backtracking Approach

## **Intuition**

### Concept
A valid IP address consists of 4 integers, meaning we need to place 3 dots. We can try placing dots at all possible different positions using backtracking. If an invalid number forms, we backtrack to try another combination.

### Backtracking
Backtracking is a general algorithmic technique that searches every possible combination to solve a computational problem. It incrementally builds candidates to the solution and abandons a candidate ("backtracks") when it determines that the candidate cannot lead to the solution.

### Approach
We will recursively enumerate all possibilities. Whenever we get a new integer because of a dot (or 2 integers for the last dot), we check whether the integer(s) is valid (i.e., the integer cannot have leading zeros, other than being 0 itself, and it's no larger than 255).

### Possibilities
There are 3 possibilities to add each dot: it can be added after 1, 2, or 3 digits from the last dot or the beginning of the string, so there are at most `3^3 = 27` possibilities to add all 3 dots.

### Optimization
An optimization is to return an empty result if the input string's length is longer than 12 since each integer can have at most 3 digits.

### Utility Function
We can create a utility function `validSegment(s, start, length)` to check whether the substring from `start` to `start + length` is a valid number in the range 0-255. The logic is to check both conditions (the caller guarantees that the length is in the range of [1, 3]):
1. If the substring's first character is 0 (i.e., `s[start]` is '0'), then the length must be 1.
2. If the length is 3, the substring should not be larger than "255" lexically. If the length is 1 or 2 and the first case was not triggered, then it will be in the acceptable range.


Create a utility function, named `backtrack`, which takes the original string `s`, the processing index `startIndex` (consider the substring starting from `startIndex` where the prefix part is already separated into valid integers), a list of integers `dots` which saves the positions for the dots added so far, and a list of strings `ans` to save the answers.

