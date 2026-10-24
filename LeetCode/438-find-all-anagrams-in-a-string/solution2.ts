function findAnagrams(s: string, p: string): number[] {
  const result: number[] = [];

  // If s is shorter than p, no anagram can exist
  if (s.length < p.length) return result;

  // Frequency map for pattern p
  const pCount: Map<string, number> = new Map();
  // Frequency map for current sliding window
  const sCount: Map<string, number> = new Map();

  // Build reference frequency map for p
  for (const c of p) {
    pCount.set(c, (pCount.get(c) ?? 0) + 1);
  }

  const windowSize = p.length;

}
