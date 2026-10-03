function findAnagrams(s: string, p: string): number[] {
  const result: number[] = [];
  if (s.length < p.length) return result;

  const pCount = new Array(26).fill(0);
  const windowCount = new Array(26).fill(0);

  for (const c of p) {
    pCount[c.charCodeAt(0) - 97]++;
  }

};