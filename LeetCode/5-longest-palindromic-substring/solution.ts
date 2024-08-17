/**
 * Finds the longest palindromic substring in the given string.
 *
 * @param s The input string.
 * @returns The longest palindromic substring.
 */
function longestPalindrome(s: string): string {
  // Check if the input string is null or empty
  if (s == null || s.length < 1) {
    return "";
  }

  /**
   * Expands from the middle of the string using two pointers to find a palindrome.
   *
   * @param i The left pointer.
   * @param j The right pointer.
   * @returns The palindrome centered at indices i, j.
   */
  function expand(i: number, j: number): string {
    let left: number = i;
    let right: number = j;

    // Expand the pointers while characters match
    while (left >= 0 && right < s.length && s[left] === s[right]) {
      left--;
      right++;
    }

    // Return the palindrome substring (exclude out of bounds indices)
    return s.slice(left + 1, right);
  }

  let ans: string = "";

  // Iterate through the string to find palindromes
  for (let i = 0; i < s.length; i++) {
    // Handle odd-length, symmetric palindromes
    let odd: string = expand(i, i);
    if (odd.length > ans.length) {
      ans = odd;
    }
    // Handle even-length, mirror palindromes
    let even: string = expand(i, i + 1);
    if (even.length > ans.length) {
      ans = even;
    }
  }

  return ans;
}
