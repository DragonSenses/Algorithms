function findAnagrams(s: string, p: string): number[] {
  const result: number[] = [];
  if (s.length < p.length) return result;

  const pCount = new Array(26).fill(0);
  const windowCount = new Array(26).fill(0);

  for (const c of p) {
    pCount[c.charCodeAt(0) - 97]++;
  }

  const windowSize = p.length;

  for (let i = 0; i < s.length; i++) {
    windowCount[s.charCodeAt(i) - 97]++;

    if (i >= windowSize) {
      windowCount[s.charCodeAt(i - windowSize) - 97]--;
    }

  }

};