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
  - **Time Complexity**: `O(m + n)`
- [**Optimized Sliding Window Approach**](#optimized-sliding-window)

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

## Implementation

#### Implementation Details

1. **Initialization**: We create frequency maps for characters in `T` and initialize the two pointers, `left` and `right`, for the sliding window. We also initialize variables to keep track of the number of required characters and the count of matched characters.

2. **Expanding the Window**: We expand the window by moving the `right` pointer, including the character at the `right` pointer in the window.

3. **Valid Window Check**: We check if the current window contains all characters of `T` by comparing the current window's character frequency with the target frequency.

4. **Contracting the Window**: If the current window is valid, we try to contract it by moving the `left` pointer and update the result if we find a smaller valid window.

5. **Result**: Finally, we return the smallest valid window found.

### Java

```java
import java.util.HashMap;
import java.util.Map;

public class Solution {

  public static String minWindow(String s, String t) {
    // Edge Case: Return empty string if either argument is empty
    if (s.length() == 0 || t.length() == 0) {
      return "";
    }

    // Frequency map for characters in T
    Map<Character, Integer> targetFreq = new HashMap<>();
    for (char c : t.toCharArray()) {
      targetFreq.put(c, targetFreq.getOrDefault(c, 0) + 1);
    }

    // Two pointers for the sliding window
    int left = 0, right = 0;
    int required = targetFreq.size();
    int formed = 0;

    // Frequency map for the current window
    Map<Character, Integer> windowCounts = new HashMap<>();
    // Variables to keep track of the smallest window
    int[] result = { -1, 0, 0 }; // length, left, right

    while (right < s.length()) {
      // Add character from the right to the window
      char c = s.charAt(right);
      windowCounts.put(c, windowCounts.getOrDefault(c, 0) + 1);

      // Check if current window has enough occurrences of the current character
      if (targetFreq.containsKey(c) && windowCounts.get(c).intValue() == targetFreq.get(c).intValue()) {
        formed++;
      }

      // Contract the window until it is no longer valid
      while (left <= right && formed == required) {
        c = s.charAt(left);
        // Save the smallest window
        if (result[0] == -1 || right - left + 1 < result[0]) {
          result[0] = right - left + 1;
          result[1] = left;
          result[2] = right;
        }

        // Remove character from the left from the window
        windowCounts.put(c, windowCounts.get(c) - 1);
        if (targetFreq.containsKey(c) && windowCounts.get(c) < targetFreq.get(c)) {
            formed--;
        }
        left++;
      }
      right++;
    }

    return result[0] == -1 ? "" : s.substring(result[1], result[2] + 1);
  }
}
```

### TypeScript

```typescript
function minWindow(s: string, t: string): string {
  if (s.length === 0 || t.length === 0) {
    return "";
  }

  // Frequency map for characters in T
  const targetFreq: Map<string, number> = new Map();
  for (const char of t) {
    targetFreq.set(char, (targetFreq.get(char) || 0) + 1);
  }

  let left = 0,
    right = 0;
  let required = targetFreq.size;
  let formed = 0;

  // Frequency map for the current window
  const windowCounts: Map<string, number> = new Map();
  let result: [number, number, number] = [-1, 0, 0]; // [length, left, right]

  while (right < s.length) {
    const char = s[right];
    windowCounts.set(char, (windowCounts.get(char) || 0) + 1);

    if (
      targetFreq.has(char) &&
      windowCounts.get(char) === targetFreq.get(char)
    ) {
      formed++;
    }

    while (left <= right && formed === required) {
      const startChar = s[left];

      // Save the smallest window
      if (result[0] === -1 || right - left + 1 < result[0]) {
        result = [right - left + 1, left, right];
      }

      windowCounts.set(startChar, windowCounts.get(startChar)! - 1);
      if (
        targetFreq.has(startChar) &&
        windowCounts.get(startChar)! < targetFreq.get(startChar)!
      ) {
        formed--;
      }

      left++;
    }

    right++;
  }

  return result[0] === -1 ? "" : s.substring(result[1], result[2] + 1);
}
```

## **Complexity Analysis**

Given two strings `s` and `t` of lengths `m` and `n` respectively.

### **Time Complexity**: `O(m + n)`

- **Worst case**: We visit each character in the string `S` at most twice: once by the right pointer and once by the left pointer.
  - Initializing the frequency map for `T` takes `O(n)` time.
  - The sliding window process involves the right pointer moving over `S` and potentially expanding until the end, making `O(m)` operations.
  - The left pointer may also move across `S` in the worst case, resulting in another `O(m)` operations.
  - Therefore, the total time complexity is `O(m + n)`.

### **Space Complexity**: `O(m + n)`

- **Worst case**: 
  - The space complexity depends on the characters in `S` and `T`.
  - We store the frequency of characters from `T` in a map, which takes `O(n)` space.
  - We maintain a window of characters from `S`, which at most can be equal to the length of `S` in the worst case, taking `O(m)` space.
  - Thus, the total space complexity is `O(m + n)`.

# Optimized Sliding Window Approach

## **Intuition**

Given two strings `s` and `t` of lengths `m` and `n` respectively, we can optimize the sliding window approach to reduce its time complexity. The key improvement is to focus only on the relevant characters from `s` that are present in `t`.

This optimization can be particularly beneficial when the length of `t` is much smaller than the length of `s`, and `s` contains many characters not present in `t`. By filtering out irrelevant characters, we can significantly reduce the number of operations required.

### Key Insight

- We create a new list `filtered_S` that contains only the characters from `s` that are present in `t`, along with their indices in `s`.
- The sliding window approach is then applied to this smaller, more relevant string.

## **Algorithm**

1. **Filter `S`**: Create a list `filtered_S` which includes all characters from `s` that are in `t` and their indices.
   
   Example:
   ```markdown
   S = "ABCDDDDDDEEAFFBC"
   T = "ABC"
   filtered_S = [(0, 'A'), (1, 'B'), (2, 'C'), (11, 'A'), (14, 'B'), (15, 'C')]
   ```
   Here, `(0, 'A')` means in string `s`, character `A` is at index 0.

2. **Initialize Pointers**: Use two pointers for the sliding window on `filtered_S`.
   
   - Start with both pointers at the beginning of `filtered_S`.

3. **Expand and Contract the Window**:
   
   - Expand the window by moving the right pointer to include characters.
   - Once the window contains all characters from `t`, contract it by moving the left pointer to minimize the window size.

4. **Track the Smallest Window**: Keep track of the smallest valid window seen so far.

5. **Return Result**: The smallest window in the original string `s` that contains all characters from `t`.

## Implementation

### Java

```java
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class Solution2 {
  public static String minWindow(String s, String t) {
    // Edge Case: Return empty string if either argument is empty
    if (s.length() == 0 || t.length() == 0) {
      return "";
    }

    // Frequency map for characters in T
    Map<Character, Integer> targetFreq = new HashMap<>();
    for (char c : t.toCharArray()) {
      targetFreq.put(c, targetFreq.getOrDefault(c, 0) + 1);
    }

    // List to filter S
    List<int[]> filteredS = new ArrayList<>();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (targetFreq.containsKey(c)) {
        filteredS.add(new int[] { i, c });
      }
    }

    // Two pointers for the sliding window
    int left = 0, right = 0;
    int required = targetFreq.size();
    int formed = 0;

    // Frequency map for the current window
    Map<Character, Integer> windowCounts = new HashMap<>();
    // Variables to keep track of the smallest window
    int[] result = { -1, 0, 0 }; // length, left, right

    // Sliding window on filtered list
    while (right < filteredS.size()) {
      char c = (char) filteredS.get(right)[1];
      windowCounts.put(c, windowCounts.getOrDefault(c, 0) + 1);

      // Check if current window has enough occurrences of the current character
      if (targetFreq.containsKey(c) && windowCounts.get(c).intValue() == targetFreq.get(c).intValue()) {
        formed++;
      }

      // Contract the window until it is no longer valid
      while (left <= right && formed == required) {
        c = (char) filteredS.get(left)[1];
        int start = filteredS.get(left)[0];
        int end = filteredS.get(right)[0];
        // Save the smallest window
        if (result[0] == -1 || end - start + 1 < result[0]) {
          result[0] = end - start + 1;
          result[1] = start;
          result[2] = end;
        }

        // Remove character from the left from the window
        windowCounts.put(c, windowCounts.get(c) - 1);
        if (targetFreq.containsKey(c) && windowCounts.get(c) < targetFreq.get(c)) {
          formed--;
        }
        left++;
      }
      right++;
    }

    return result[0] == -1 ? "" : s.substring(result[1], result[2] + 1);
  }
}
```

### TypeScript

```typescript
function minWindow(s: string, t: string): string {
  if (s.length === 0 || t.length === 0) {
    return "";
  }

  // Frequency map for characters in T
  const targetFreq: Map<string, number> = new Map();
  for (const char of t) {
    targetFreq.set(char, (targetFreq.get(char) || 0) + 1);
  }

  // Filter S to include only characters in T
  const filteredS: Array<[number, string]> = [];
  for (let i = 0; i < s.length; i++) {
    const char = s[i];
    if (targetFreq.has(char)) {
      filteredS.push([i, char]);
    }
  }

  let left = 0,
    right = 0;
  const required = targetFreq.size;
  let formed = 0;

  // Frequency map for the current window
  const windowCounts: Map<string, number> = new Map();
  let result: [number, number, number] = [-1, 0, 0]; // [length, left, right]

  // Sliding window on filtered list
  while (right < filteredS.length) {
    const char = filteredS[right][1];
    windowCounts.set(char, (windowCounts.get(char) || 0) + 1);

    if (
      targetFreq.has(char) &&
      windowCounts.get(char) === targetFreq.get(char)
    ) {
      formed++;
    }

    // Contract the window until it is no longer valid
    while (left <= right && formed === required) {
      const startChar = filteredS[left][1];
      const start = filteredS[left][0];
      const end = filteredS[right][0];

      // Save the smallest window
      if (result[0] === -1 || end - start + 1 < result[0]) {
        result = [end - start + 1, start, end];
      }

      windowCounts.set(startChar, windowCounts.get(startChar)! - 1);
      if (
        targetFreq.has(startChar) &&
        windowCounts.get(startChar)! < targetFreq.get(startChar)!
      ) {
        formed--;
      }

      left++;
    }

    right++;
  }

  return result[0] === -1 ? "" : s.substring(result[1], result[2] + 1);
}
```
