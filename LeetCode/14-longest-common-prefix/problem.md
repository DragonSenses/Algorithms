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

## **Algorithm**

1. **Edge Case Handling**: If the input array is empty, return an empty string.
2. **Iterate Over Columns**: Use a loop to iterate over the characters of the first string (as a reference).
3. **Compare Characters**: For each character in the reference string, compare it with the corresponding character in all other strings.
4. **Check for Mismatch**: If a mismatch is found or the end of any string is reached, return the prefix formed up to that point.
5. **Return Result**: If no mismatch is found, the entire first string is the common prefix.

## **Implementation**

### Java

```java
public class Solution {

  /**
   * Finds the longest common prefix string amongst an array of strings.
   *
   * @param strs an array of strings
   * @return the longest common prefix string, or an empty string if there is no common prefix
   */
  public String longestCommonPrefix(String[] strs) {
      // Edge case: if the input array is null or empty, return an empty string
      if (strs == null || strs.length == 0) {
          return "";
      }

      // Iterate over each character of the first string
      for (int i = 0; i < strs[0].length(); i++) {
          // Get the current character from the first string
          char c = strs[0].charAt(i);

          // Compare this character with the corresponding character in all other strings
          for (int j = 1; j < strs.length; j++) {
              // If the current character does not match or we reach the end of any string,
              // return the substring of the first string up to the current index
              if (i == strs[j].length() || strs[j].charAt(i) != c) {
                  return strs[0].substring(0, i);
              }
          }
      }

      // If no mismatch is found, the entire first string is the common prefix
      return strs[0];
  }
}
```

1. **Edge Case Handling**: The function first checks if the input array is empty and returns an empty string if true.
2. **Outer Loop**: The outer loop iterates over each character of the first string.
3. **Character Comparison**: The inner loop compares the current character of the first string with the corresponding character in all other strings.
4. **Mismatch Check**: If a mismatch is found or the end of any string is reached, the function returns the substring of the first string up to the current index.
5. **Return Full String**: If no mismatch is found, the entire first string is returned as the longest common prefix.

