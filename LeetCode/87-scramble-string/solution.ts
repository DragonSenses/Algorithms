function isScramble(s1: string, s2: string): boolean {
  // Base case: identical strings are trivially scrambled
  if (s1 === s2) return true;

  // If lengths differ, it's impossible for s2 to be a scrambled version of s1
  if (s1.length !== s2.length) return false;
};