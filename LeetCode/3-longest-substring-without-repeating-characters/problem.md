# Longest Substring Without Repeating Characters

Given a string `s`, find the length of the **longest** substring without repeating characters.

  - A *substring* is a contiguous non-empty sequence of characters within a string.

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

Constraints:

  - 0 <= s.length <= 5 * 10^4
  - `s` consists of English letters, digits, symbols and spaces.

# Solution

To solve this problem, we employ the *sliding window approach* along with a `HashSet`. We choose to use a `HashSet` not primarily for maintaining unique elements (since we ensure uniqueness using `contains()`), but because the `contains()` method has an average time complexity of **O(1)** for a `HashSet`. In contrast, if we were to use a `List`, the `contains()` operation would run in **O(n)** time.

## **Sliding Window**

**Sliding Window Technique** is a method used to efficiently solve problems that involve defining a window or range in the input data (arrays or strings) and then moving that window across the data to perform some operation within the window. 
 - This technique is commonly used in algorithms like:
   -  finding subarrays with a specific sum, 
   -  finding the longest substring with unique characters, 
   -  or solving problems that require a fixed-size window to process elements efficiently.

There are two main types of sliding windows:

1. Fixed Size Sliding Window: The window size remains constant as it slides through the data.
2. Variable Size Sliding Window: The window size can change based on certain conditions.

### Sliding Window algorithm

1. **What is the sliding window?**
   - Imagine a "window" (a subarray or substring) that slides over the input data (e.g., an array or string).
   - The window's size can change dynamically as it moves through the data.
   - The goal is to find an optimal window that satisfies certain conditions (e.g., maximum sum, longest substring, etc.).

2. **How does it work?**
   - Initialize two pointers: `start` and `end`.
   - Initially, both pointers point to the beginning of the data.
   - Move the `end` pointer to the right, expanding the window.
   - Adjust the `start` pointer if needed (e.g., when a condition is violated).
   - Keep track of the optimal result within the window.

3. **Common use cases:**
   - **Maximum/Minimum Sum Subarray:** Find the subarray with the largest/smallest sum.
   - **Longest Substring Without Repeating Characters:** Find the longest substring without duplicate characters.
   - **Fixed-Length Window Problems:** Compute results for fixed-size windows (e.g., moving averages).

4. **Advantages:**
   - Reduces the time complexity by avoiding unnecessary recalculations.
   - Efficiently handles problems involving contiguous subarrays or substrings.

## Algorithm

**Sliding Window Technique**:
   - Use a sliding window approach to maintain a substring without repeating characters.
   - Initialize two pointers, `left` and `right`, both pointing to the start of the string.
   - Move the `right` pointer to the right until we encounter a repeating character.
   - When a repeating character is found, update the `left` pointer to the next position after the first occurrence of that character.
   - Keep track of the maximum length of the substring encountered so far.
   - Repeat this process until the `right` pointer reaches the end of the string.
   - The maximum length of the substring without repeating characters is the answer.
   - **Time complexity: O(n)**, where n is the length of the input string.

**Optimized Sliding Window with Hash Set**:
   - Instead of using a dictionary to store character indices, we can use a hash set to keep track of characters in the current window.
   - When a repeating character is encountered, remove the leftmost character from the set and move the `left` pointer.
   - This approach reduces the **space complexity**.

## Java

```java
import java.util.HashSet;
import java.util.Set;

public class LongestSubstring {
  public int lengthOfLongestSubstring(String s) {
    Set<Character> set = new HashSet<>();
    int left = 0;
    int right = 0;
    int max = 0;

    while (right < s.length()) {
      if (!set.contains(s.charAt(right))) {
        // If the character is not in the set, add it and move the right pointer
        set.add(s.charAt(right));
        right++;
        // Update the maximum length of the substring
        max = Math.max(set.size(), max);
      } else {
        // If the character is already in the set, remove the leftmost character
        set.remove(s.charAt(left));
        left++;
      }
    }

    return max;
  }
}
```

A few improvements to the solution:

- Current window length is `right - left + 1`, we can use this to calculate the current `max` length substring.
- Initialize `right` within the for loop

```java
public int lengthOfLongestSubstring(String s) {
  Set<Character> set = new HashSet<>();
  int left = 0;
  int max = 0;

  // Iterate through the characters of the input string
  for (int right = 0; right < s.length(); right++) {
    // If the character is not already in the set (not a repeating character)
    if (!set.contains(s.charAt(right))) {
      // Add it to the set
      set.add(s.charAt(right));
      // Move the right pointer to the right
      right++;
      // Update max with the current length of the substring: right - left + 1
      max = Math.max(max, right - left);
    } else {
      // If the character is already in the set
      // Remove the leftmost character from the set
      set.remove(s.charAt(left));
      // Move the left pointer to the right
      left++;
    }
}

  return max;
}
```

## TypeScript

```ts
function lengthOfLongestSubstring(s: string): number {
  const charSet = new Set<string>();
  let maxLength = 0;
  let left = 0;

  for (let right = 0; right < s.length; right++) {
    while (charSet.has(s[right])) {
      charSet.delete(s[left]);
      left++;
    }
    charSet.add(s[right]);
    maxLength = Math.max(maxLength, right - left + 1);
  }

  return maxLength;
}
```

## Bruteforce

The bruteforce is less efficient due to its time complexity of O(n^3) but straightforward.

- Generate all possible substrings of the given string.
- Among all substrings with unique characters, return the maximum length.

TypeScript:

```ts
function lengthOfLongestSubstringBruteforce(s: string): number {
    const n = s.length;
    let maxLength = 0;

    for (let i = 0; i < n; i++) {
        for (let j = i; j < n; j++) {
            const substring = s.substring(i, j + 1);
            if (new Set(substring).size === substring.length) {
                maxLength = Math.max(maxLength, substring.length);
            }
        }
    }

    return maxLength;
}
```

Java:

```java
public class LongestSubstringBruteforce {
    public static int lengthOfLongestSubstringBruteforce(String s) {
        int n = s.length();
        int maxLength = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                String substring = s.substring(i, j + 1);
                if (new HashSet<>(Arrays.asList(substring.split(""))).size() == substring.length()) {
                    maxLength = Math.max(maxLength, substring.length());
                }
            }
        }

        return maxLength;
    }
}
```

