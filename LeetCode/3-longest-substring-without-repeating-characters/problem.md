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

