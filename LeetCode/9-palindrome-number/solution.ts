function isPalindrome(x: number): boolean {
  // Edge case: Negative numbers are not palindromes
  if (x < 0) {
    return false;
  }

  // Edge case: Numbers ending with 0 are not palindromes
  if (x !== 0 && (x & 1) === 0) {
    return false;
  }

  // Edge case: Single-digit numbers are always palindromes
  if (x >= 0 && x < 10) {
    return true;
  }

  let original = x;
  let reversed = 0;

  while (x !== 0) {
    reversed = reversed * 10 + (x % 10); // Reverse the digits
    x = Math.trunc(x / 10); // Truncate the number
  }

  return original === reversed;
}
