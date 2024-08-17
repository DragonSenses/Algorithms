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