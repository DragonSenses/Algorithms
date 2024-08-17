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
