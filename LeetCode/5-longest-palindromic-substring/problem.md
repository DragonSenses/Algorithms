# Longest Palindromic Substring

Given a string `s`, return the longest **palindromic substring** in s.

  - A string is **palindromic** if it reads the same forward and backward.

Example 1:

Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.

Example 2:

Input: s = "cbbd"
Output: "bb"

Constraints:

    1 <= s.length <= 1000
    s consist of only digits and English letters.

# Solution

Notice there are two types of palindromes:

1. **Symmetric Palindromes:**
   - These palindromes exhibit symmetry around a central point.
   - Examples: "radar," "racecar," or "level."

2. **Mirror Palindromes:**
   - These are palindromes that remain the same when their characters are reflected.
   - They lack the central symmetry found in symmetric palindromes.
   - Examples: "MOM," "WOW," "NOON," or "abba."

The approach is to have two pointers start at the mid-point of the string and check for equality as we move outward.

Note that for even-numbered mirror palindromes can be checked by seeing if the characters on both sides of the mid-point are the same.

In the case for symmetric palindromes, we start at the middle character rather than the midpoint because the central character will not have a matching character.

## Expand around Center

1. **Create a Helper Method `expand(i, j)`:**
   - This method finds the length of the longest palindrome centered at indices `i` and `j`.
   - Initialize `left = i` and `right = j`.
   - While both `left` and `right` are in bounds and `s[left] == s[right]`, move the pointers away from each other.
   - The formula for the length of a substring starting at `left` and ending at `right` is `right - left + 1`.
   - However, when the while loop ends, it implies `s[left] != s[right]`. Therefore, we need to subtract 2. Return `right - left - 1`.

2. **Initialize `ans = [0, 0]`:**
   - This array will hold the inclusive bounds of the answer.

3. **Iterate over All Indices of `s`:**
   - For each index `i`:
     - Find the length of the longest odd-length palindrome centered at `i`: `oddLength = expand(i, i)`.
     - If `oddLength` is the greatest length seen so far (i.e., `oddLength > ans[1] - ans[0] + 1`), update `ans`.
     - Find the length of the longest even-length palindrome centered at `i`: `evenLength = expand(i, i + 1)`.
     - If `evenLength` is the greatest length seen so far, update `ans`.

4. **Retrieve the Answer Bounds from `ans` as `i, j`**:
   - Return the substring of `s` starting at index `i` and ending with index `j`.

### Complexity Analysis

Given `n` as the length of `s`,

  - Time complexity: `O(n^2)`

    There are `2n−1=O(n)` centers. For each center, we call `expand`, which costs up to `O(n)`.

    Although the time complexity is the same as in the DP approach, the average/practical runtime of the algorithm is much faster. This is because most centers will not produce long palindromes, so most of the `O(n)` calls to `expand` will cost far less than `n` iterations.

    The worst case scenario is when every character in the string is the same.

  - Space complexity: `O(1)`

    We don't use any extra space other than a few integers. This is a big improvement on the DP approach.

### Java

```java
class solution {
  
  /**
   * Expands from the middle of the given string using two pointers to find a palindrome.
   * This method finds the length of longest palindrome centered at left, right
   * @param s The input string.
   * @param left The left pointer.
   * @param right The right pointer.
   * @return The length of the longest palindrome centered at the given indices.
   */
  public int expandFromMiddle(String s, int left, int right) {
    // Edge case: null input or invalid indices
    if (s == null || left > right) {
      return 0;
    }

    // While both pointers are within bounds AND
    // characters at those poistions are equivalent
    while (left >= 0 && right < s.length() 
      && s.charAt(left) == s.charAt(right)) {
        // Expand the pointers from the middle
        left--;
        right++;
    }

    // Right is the higher than left, -1 for indices correction
    return right - left - 1;
  }
  
  public String longestPalindrome(String s) {
    // Check the argument
    if (s == null || s.length() < 1) {
      return "";
    }

    // Substring boundaries for the longest palindrome substring
    int start = 0;
    int end = 0;

    // Loop through the string to find the longest palindrome substring
    for (int i = 0; i < s.length(); i++) {
      // Handle two cases: symmetric palindrome "radar" and even-length mirror palindrome "abba"
      int symPalinLength = expandFromMiddle(s, i, i);
      int mirrorPalinLength =  expandFromMiddle(s, i, i+1);

      // Find max length of palindrome substring and adjust the start and end boundaries
      int len = Math.max(symPalinLength, mirrorPalinLength);
      if (len > end - start) {
        // Set the new start and end index, check boundaries
        start = i - ((len - 1) / 2);
        end = i + (len / 2);
      }
    }

    return s.substring(start, end + 1);
  }
}
```

## Naive Approach - Bruteforce

Naive approach (brute force) algorithm:

- Generate all possible substrings of the given string.
- For each substring, check if it is a palindrome.
- Keep track of the longest palindromic substring found so far.
- This approach has a time complexity of `O(N^3)` since we need three nested loops to iterate through all substrings

```java
public class solution {
  // Helper function to print a substring
  private static void printSubStr(String str, int low, int high) {
    for (int i = low; i <= high; ++i)
      System.out.print(str.charAt(i));
  }

  // Function to find the longest palindromic substring
  public static String longestPalindrome(String s) {
    int n = s.length();
    int maxLength = 1; // Initialize the maximum length
    int start = 0; // Initialize the starting index of the longest palindromic substring

    // Check all possible substrings
    for (int i = 0; i < n; i++) {
      for (int j = i; j < n; j++) {
        boolean isPalindrome = true; // Assume the substring is a palindrome
        for (int k = 0; k < (j - i + 1) / 2; k++) {
          if (s.charAt(i + k) != s.charAt(j - k)) {
            isPalindrome = false; // Not a palindrome
            break;
          }
        }
        if (isPalindrome && (j - i + 1) > maxLength) {
          start = i;
          maxLength = j - i + 1;
        }
      }
    }

    System.out.print("Longest palindrome substring is: ");
    printSubStr(s, start, start + maxLength - 1);
    return s.substring(start, start + maxLength);
  }

  public static void main(String[] args) {
      String str = "babad";
      System.out.println("\nLength is: " + longestPalindrome(str));
  }
}
```

```typescript
function longestPalindrome(s: string): string {
  const n = s.length;
  let maxLength = 1;
  let start = 0;

  // Check all possible substrings
  for (let i = 0; i < n; i++) {
    for (let j = i; j < n; j++){
      let isPalindrome = true; // Assume the substring is a palindrome
      for (let k = 0; k < (j - i + 1)/2; k++){
        if (s.charAt(i + k) != s.charAt(j - k)) {
          isPalindrome = false;
          break;
        }
      }
      if (isPalindrome && (j - i + 1) > maxLength) {
        start = i;
        maxLength = j - i + 1;
      }
    }
  }

  return s.substring(start, start + maxLength);
};

```