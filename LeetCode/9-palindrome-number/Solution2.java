class Solution2 {
  public boolean isPalindrome(int x) {
    // Edge case: Numbers ending with 0 are not palindromes
    // Edge case: Negative numbers are not palindromes
    if (x < 0 || (x != 0 && (x % 10 == 0))) {
      return false;
    }

    int reversed = 0;
    while (x > reversed) {
      reversed = reversed * 10 + x % 10; // Reverse the digits
      x /= 10;
    }

    // Check if other half the number is equal to the reversed half.
    // For odd-lengthed palindromes, safely discard middle digit
    return x == reversed || x == reversed/10;
  }
}