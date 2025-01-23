function isMatch(s: string, p: string): boolean {
  // Base case: If pattern is empty, check if text is also empty
  if (p.length === 0) {
    return s.length === 0;
  }

  // Check if the first character matches
  const firstMatch = s.length !== 0 && (p[0] === s[0] || p[0] === ".");

  // No '*' in the pattern, recursively check the rest of the text and pattern
  return firstMatch && isMatch(s.substring(1), p.substring(1));
};