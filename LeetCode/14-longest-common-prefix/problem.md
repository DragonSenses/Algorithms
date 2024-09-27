# 14. Longest Common Prefix

<p>Write a function to find the longest common prefix string amongst an array of strings.</p>

<p>If there is no common prefix, return an empty string <code>""</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> strs = ["flower","flow","flight"]
<strong>Output:</strong> "fl"
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> strs = ["dog","racecar","car"]
<strong>Output:</strong> ""
<strong>Explanation:</strong> There is no common prefix among the input strings.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= strs.length &lt;= 200</code></li>
	<li><code>0 &lt;= strs[i].length &lt;= 200</code></li>
	<li><code>strs[i]</code> consists of only lowercase English letters.</li>
</ul>

<br>

---

# Solution

- [Vertical Scanning Approach](#vertical-scanning)

# Vertical Scanning

## **Intuition**

We can compare characters of each string in the same position. We can imagine it as if we stacked each string on top of each other and compare characters from top to bottom on the same column (i.e., same character index of the strings) before moving on to the next column.

### Key steps

1. **Stacking Strings Vertically**: Imagine stacking all the strings vertically, one on top of the other.
2. **Column-wise Comparison**: Start comparing characters column by column (i.e., character by character at the same index across all strings).
3. **Early Termination**: If a mismatch is found or the end of any string is reached, stop the comparison for that column.
4. **Prefix Formation**: The characters compared successfully up to the point of mismatch form the longest common prefix.

