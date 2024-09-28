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

#### Additional Test Cases

1. **Common Prefix Exists**: Checks for a common prefix among strings with different lengths.
   - Input: `["flower", "flow", "flight"]`
   - Expected Output: `"fl"`

2. **No Common Prefix**: Ensures the function returns an empty string when there is no common prefix.
   - Input: `["dog", "racecar", "car"]`
   - Expected Output: `""`

3. **All Strings Are Identical**: Verifies the function handles identical strings correctly.
   - Input: `["test", "test", "test"]`
   - Expected Output: `"test"`

4. **Single String**: Tests the function with a single string.
   - Input: `["single"]`
   - Expected Output: `"single"`

5. **Empty Array**: Checks the function's behavior with an empty array.
   - Input: `[]`
   - Expected Output: `""`

<br>

---

# Solution

- [Binary Search Approach](#binary-search-approach)
  - **Time Complexity**: `O(n * minLen * log minLen)`
- [Divide and Conquer Approach](#divide-and-conquer-approach)
  - **Time Complexity**: `O(m * log n)`
- [Vertical Scanning Approach](#vertical-scanning)
  - **Time Complexity**: `O(n * m)`

# Binary Search Approach

## **Intuition**

The goal is to use a binary search method to find the maximum length `L` of the longest common prefix among all strings in the array. The search space for `L` is the interval `[0, minLen]`, where `minLen` is the length of the shortest string in the array. This ensures that the longest possible common prefix cannot exceed the length of the shortest string.

Each time search space is divided in two equal parts, one of them is discarded, because it is sure that it doesn't contain the solution. There are two possible cases:

  1. `S[1...mid]` is not a common string. This means that for each `j > i, S[1...j]` is not a common string and we discard the second half of the search space.

  2. `S[1...mid]` is common string. This means that for each `i < j, S[1..i]` is a common string and we discard the first half of the search space, because we try to find longer common prefix.

### **Key Steps**

1. **Search Space Definition**:
   - Define the search space for the length `L` of the longest common prefix as `[0, minLen]`.

2. **Binary Search**:
   - Perform binary search within this interval. In each iteration, calculate the midpoint `mid` of the current search space.
   - Check if the prefix of length `mid` is common to all strings.

3. **Prefix Check**:
   - If the prefix of length `mid` is common to all strings, it means longer prefixes might also be common. Thus, move to the right half of the search space by setting `low = mid + 1`.
   - If the prefix of length `mid` is not common to all strings, it means longer prefixes cannot be common. Thus, move to the left half of the search space by setting `high = mid - 1`.

4. **Termination**:
   - The binary search continues until the search space is exhausted. The longest common prefix length is determined by the final value of `high`.

### **Detailed Steps**

1. **Initialize**:
   - Set `low = 0` and `high = minLen`.

2. **Binary Search Loop**:
   - While `low <= high`:
     - Calculate `mid = (low + high) / 2`.
     - Check if the prefix of length `mid` is common to all strings.
     - If common, set `low = mid + 1`.
     - If not common, set `high = mid - 1`.

3. **Result**:
   - The longest common prefix is the substring of the first string from index 0 to `high`.

## **Algorithm**

1. **Initialization**:
   - Determine the length of the shortest string in the array, `minLen`.
   - Set two pointers, `low` and `high`, to 0 and `minLen`, respectively.

2. **Binary Search Loop**:
   - While `low` is less than or equal to `high`:
     1. Calculate the middle index `mid` as `mid = low + (high - low) / 2`.
     2. Check if the prefix of length `mid` is common to all strings:
        - If the prefix is common, move to the right half by setting `low = mid + 1`.
        - If the prefix is not common, move to the left half by setting `high = mid - 1`.

3. **Prefix Check**:
   - Define a helper function to check if a prefix of a given length is common to all strings.

4. **Result**:
   - The longest common prefix is the substring of the first string from index 0 to `(low + high) / 2`.

### **Pseudocode**

```plaintext
function longestCommonPrefix(strs):
    if strs is empty:
        return ""

    minLen = find the length of the shortest string in strs
    low = 0
    high = minLen

    while low <= high:
        mid = low + (high - low) / 2
        if isCommonPrefix(strs, mid):
            low = mid + 1
        else:
            high = mid - 1

    return substring of strs[0] from 0 to (low + high) / 2

function isCommonPrefix(strs, len):
    prefix = substring of strs[0] from 0 to len
    for each string in strs:
        if string does not start with prefix:
            return false
    return true
```

## **Implementation**

#### Key Steps

1. **Initialization**: Determine the minimum length of the strings to set the search space.
2. **Binary Search**: Perform binary search to find the maximum length of the common prefix.
3. **Prefix Check**: Use a helper function to check if a prefix of a given length is common to all strings.
4. **Result**: Return the longest common prefix based on the final search space.

### Java

```java
public class Solution {

  /**
   * Finds the longest common prefix string amongst an array of strings using the
   * binary search approach.
   *
   * @param strs an array of strings
   * @return the longest common prefix string, or an empty string if there is no
   *         common prefix
   */
  public String longestCommonPrefix(String[] strs) {
    if (strs == null || strs.length == 0) {
      return "";
    }

    int minLen = Integer.MAX_VALUE;
    for (String str : strs) {
      minLen = Math.min(minLen, str.length());
    }

    int low = 0;
    int high = minLen;
    while (low <= high) {
      int mid = (low + high) / 2;
      if (isCommonPrefix(strs, mid)) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }

    return strs[0].substring(0, (low + high) / 2);
  }

  /**
   * Checks if a prefix of given length is common to all strings.
   *
   * @param strs the array of strings
   * @param len  the length of the prefix
   * @return true if the prefix is common to all strings, false otherwise
   */
  private boolean isCommonPrefix(String[] strs, int len) {
    String prefix = strs[0].substring(0, len);
    for (int i = 1; i < strs.length; i++) {
      if (!strs[i].startsWith(prefix)) {
        return false;
      }
    }
    return true;
  }
}
```

#### Why is `low` set to `0` and not `1`?

In the binary search approach for finding the longest common prefix, it is correct to set `low` to 0. This is because the search space for the length of the prefix starts from 0 (an empty prefix) and goes up to the length of the shortest string (`minLen`).

Here's the reasoning:

- **`low = 0`**: This represents the smallest possible prefix length, which is an empty string.
- **`high = minLen`**: This represents the maximum possible prefix length, which is the length of the shortest string in the array.

Setting `low` to 0 ensures that the binary search considers the possibility of no common prefix at all, which is necessary for the algorithm to function correctly.

The implementation is correct with `low` set to 0. Here's the relevant part of the code for clarity:

```java
int low = 0;
int high = minLen;
while (low <= high) {
    int mid = (low + high) / 2;
    if (isCommonPrefix(strs, mid)) {
        low = mid + 1;
    } else {
        high = mid - 1;
    }
}
```

## **Complexity Analysis**

#### **Time Complexity**: `O(n * minLen * log minLen)`

- **Binary Search**:
  - The binary search operates over the range of possible prefix lengths, which is from 0 to `minLen`, where `minLen` is the length of the shortest string in the array.
  - The binary search will therefore run in `O(log minLen)` time.

- **Prefix Check**:
  - For each midpoint `mid` calculated during the binary search, we need to check if the prefix of length `mid` is common to all strings.
  - This involves comparing the prefix of length `mid` with each of the `n` strings.
  - In the worst case, this comparison takes `O(n * mid)` time.
  - Since `mid` can be at most `minLen`, the prefix check takes `O(n * minLen)` time in the worst case.

- **Total Time Complexity**:
  - Combining the binary search and prefix check, the total time complexity is `O(n * minLen * log minLen)`.

#### **Space Complexity**: `O(1)`

- **Constant Space**:
  - The algorithm uses a constant amount of extra space for variables and the binary search itself.
  - The space complexity is `O(1)` since no additional data structures that grow with the input size are used.

### Summary

- **Time Complexity**: `O(n * minLen * log minLen)`
  - `n` is the number of strings.
  - `minLen` is the length of the shortest string.
- **Space Complexity**: `O(1)`
  - The algorithm uses a constant amount of extra space.

This analysis shows that the binary search approach is efficient in terms of both time and space, making it a good choice for solving the longest common prefix problem, especially when dealing with a large number of strings.

# Divide and Conquer Approach

## **Intuition**

The Longest Common Prefix (`LCP`) problem for a set of strings `S_1, S_2, ... , S_n` can be efficiently solved using the divide and conquer technique. Here's a detailed breakdown:

### **Key Points**

1. **Problem Division**:
   - **Divide**: Split the problem into two subproblems. For the set of strings `S_1, S_2, ..., S_n`, divide it into two halves:
     -  `LCP(S_1, ..., S_mid)`
     -  `LCP(S_mid+1, ..., S_n)`
   - Here, `mid` is calculated as `i + j) / 2`, where `i` and `j` are the indices of the first and last strings in the current subset.

2. **Recursive Solution**:
   - **Conquer**: Recursively solve the subproblems to find the longest common prefix for each half:
     - `lcpLeft` = `LCP(S_1, ..., S_mid)`
     - `lcpRight` = `LCP(S_mid+1, ..., S_n)`

3. **Combine Results**:
   - **Combine**: Merge the results of the subproblems to form the solution for the original problem. Compare the characters of `lcpLeft` and `lcpRight` one by one until a mismatch is found:
     - The common prefix of `lcpLeft` and `lcpRight` is the solution for `LCP(S_1, ..., S_n)`.

### **Detailed Walkthrough**

1. **Base Case**:
   - If the subset contains only one string, the longest common prefix is the string itself.

2. **Recursive Case**:
   - Split the array of strings into two halves.
   - Recursively find the longest common prefix for each half.
   - Compare the prefixes from both halves character by character to find the common prefix.

3. **Character Comparison**:
   - Start comparing characters from the beginning of `lcpLeft` and `lcpRight`.
   - Continue until characters match or the end of either prefix is reached.
   - The matched portion is the longest common prefix for the current subset.

### **Example**

For the input array `["flower", "flow", "flight"]`:
1. **Divide**: Split into `["flower", "flow"]` and `["flight"]`.
2. **Conquer**:
   - Find LCP of `["flower", "flow"]` which is `"flow"`.
   - Find LCP of `["flight"]` which is `"flight"`.
3. **Combine**:
   - Compare `"flow"` and `"flight"` character by character.
   - The common prefix is `"fl"`.

## **Algorithm**

1. **Base Case**:
   - If the subset contains only one string, return that string as the longest common prefix.

2. **Divide**:
   - Split the array of strings into two halves:
     - Left half: `LCP(S_1, ..., S_mid)`
     - Right half: `LCP(S_mid+1, ..., S_n)`
   - Here, `mid` is calculated as `low + high / 2`.

3. **Conquer**:
   - Recursively find the longest common prefix for each half:
     - `lcpLeft` = `LCP(S_1, ..., S_mid)`
     - `lcpRight` = `LCP(S_mid+1, ..., S_n)`

4. **Combine**:
   - Compare the prefixes from both halves character by character to find the common prefix.
   - The common prefix of `lcpLeft` and `lcpRight` is the solution for `LCP(S_1, ..., S_n)`.

### **Implementation**

The divide-and-conquer approach ensures that the problem is broken down into manageable parts, solved independently, and then combined to form the final solution.

#### Key Steps:

1. **Base Case**: If the subset contains only one string, return that string.
2. **Divide**: Split the array into two halves and recursively find the LCP for each half.
3. **Conquer**: Recursively solve the subproblems.
4. **Combine**: Compare the results from the two halves to find the common prefix.

### Java

```java
public class Solution {
  /**
   * Finds the longest common prefix string amongst an array of strings using the
   * divide and conquer approach.
   *
   * @param strs an array of strings
   * @return the longest common prefix string, or an empty string if there is no
   *         common prefix
   */
  public String longestCommonPrefix(String[] strs) {
    if (strs == null || strs.length == 0) {
      return "";
    }
    return longestCommonPrefix(strs, 0, strs.length - 1);
  }

  /**
   * Recursively finds the longest common prefix in a subset of the array.
   *
   * @param strs the array of strings
   * @param low  the starting index of the subset
   * @param high the ending index of the subset
   * @return the longest common prefix in the subset
   */
  private String longestCommonPrefix(String[] strs, int low, int high) {
    if (low == high) {
      return strs[low];
    }
    int mid = (low + high) / 2;
    String lcpLeft = longestCommonPrefix(strs, low, mid);
    String lcpRight = longestCommonPrefix(strs, mid + 1, high);
    return commonPrefix(lcpLeft, lcpRight);
  }

  /**
   * Finds the common prefix between two strings.
   *
   * @param left  the first string
   * @param right the second string
   * @return the common prefix between the two strings
   */
  private String commonPrefix(String left, String right) {
    int minLength = Math.min(left.length(), right.length());
    for (int i = 0; i < minLength; i++) {
      if (left.charAt(i) != right.charAt(i)) {
        return left.substring(0, i);
      }
    }
    return left.substring(0, minLength);
  }
}
```

## **Complexity Analysis**

#### **Time Complexity**: `O(m * log n)`

- **Divide Step**: Each divide step splits the array of strings into two halves. This results in a binary tree structure with a height of `log n`, where `n` is the number of strings.
- **Conquer Step**: At each level of the binary tree, we compare the prefixes of the two halves. In the worst case, this comparison involves all characters of the shortest string in the array, which has a length of `m`.

Therefore, at each level of the binary tree, the comparison takes `O(m)` time, and there are `log n` levels.

- **Total Time Complexity**: `O(m * log n)`

#### **Space Complexity**: `O(log n)`

- **Recursive Call Stack**: The space complexity is determined by the depth of the recursion tree. Since the recursion tree has a height of `log n`, the space complexity due to the call stack is `O(log n)`.

- **Additional Space**: The algorithm uses a constant amount of extra space for variables and comparisons, which is `O(1)`.

- **Total Space Complexity**: `O(log n)`

### Summary

- **Time Complexity**: `O(m * log n)`
  - `n` is the number of strings.
  - `m` is the length of the shortest string.
- **Space Complexity**: `O(log n)`
  - Due to the depth of the recursion tree.

This analysis shows that the divide and conquer approach is efficient in terms of both time and space, making it a good choice for solving the longest common prefix problem, especially when dealing with a large number of strings.

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

## **Complexity Analysis**

Let `n` be the number of strings in the input array and `m` be the length of the shortest string in the array.

### **Time Complexity**: `O(n * m)`

- **Character Comparison**: In the worst case, we compare each character of the first string with the corresponding character in all other strings. This involves:
  - Iterating over each character of the first string, which has a maximum length of `m`.
  - For each character, we compare it with the corresponding character in the remaining `n - 1` strings.
- **Total Comparisons**: Therefore, the total number of comparisons is `O(n * m)`.

### **Space Complexity**: `O(1)`

- **Constant Space**: The algorithm uses a constant amount of extra space, regardless of the input size. We only store a few variables such as the current character and indices.
- **No Additional Data Structures**: We do not use any additional data structures that grow with the input size.

### Detailed Breakdown

1. **Initialization**: Checking if the input array is empty takes `O(1)` time.
2. **Outer Loop**: The outer loop runs up to `m` times, where `m` is the length of the shortest string.
3. **Inner Loop**: For each character in the first string, the inner loop runs `n - 1` times to compare it with the corresponding character in the other strings.
4. **Early Termination**: The algorithm can terminate early if a mismatch is found, potentially reducing the number of comparisons.

### Summary

- **Time Complexity**: `O(n * m)` - The algorithm performs at most `n * m` character comparisons.
- **Space Complexity**: `O(1)` - The algorithm uses a constant amount of extra space.
