function minWindow(s: string, t: string): string {
  if (s.length === 0 || t.length === 0) {
    return "";
  }

  const targetFreq: Map<string, number> = new Map();
  for (const char of t) {
    targetFreq.set(char, (targetFreq.get(char) || 0) + 1);
  }

  const filteredS: Array<[number, string]> = [];
  for (let i = 0; i < s.length; i++) {
    const char = s[i];
    if (targetFreq.has(char)) {
      filteredS.push([i, char]);
    }
  }

  let left = 0,
    right = 0;
  const required = targetFreq.size;
  let formed = 0;

  const windowCounts: Map<string, number> = new Map();
  let result: [number, number, number] = [-1, 0, 0]; // [length, left, right]

  while (right < filteredS.length) {
    const char = filteredS[right][1];
    windowCounts.set(char, (windowCounts.get(char) || 0) + 1);

    if (
      targetFreq.has(char) &&
      windowCounts.get(char) === targetFreq.get(char)
    ) {
      formed++;
    }

    while (left <= right && formed === required) {
      const startChar = filteredS[left][1];
      const start = filteredS[left][0];
      const end = filteredS[right][0];

      if (result[0] === -1 || end - start + 1 < result[0]) {
        result = [end - start + 1, start, end];
      }

      windowCounts.set(startChar, windowCounts.get(startChar)! - 1);
      if (
        targetFreq.has(startChar) &&
        windowCounts.get(startChar)! < targetFreq.get(startChar)!
      ) {
        formed--;
      }

      left++;
    }

    right++;
  }

  return result[0] === -1 ? "" : s.substring(result[1], result[2] + 1);
}
