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
