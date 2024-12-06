function minWindow(s: string, t: string): string {
  if (s.length === 0 || t.length === 0) {
    return "";
  }

  // Frequency map for characters in T
  const targetFreq: Map<string, number> = new Map();
  for (const char of t) {
    targetFreq.set(char, (targetFreq.get(char) || 0) + 1);
  }

  let left = 0,
    right = 0;
  let required = targetFreq.size;
  let formed = 0;

  // Frequency map for the current window
  const windowCounts: Map<string, number> = new Map();
  let result: [number, number, number] = [-1, 0, 0]; // [length, left, right]

  while (right < s.length) {
    const char = s[right];
    windowCounts.set(char, (windowCounts.get(char) || 0) + 1);

    if (
      targetFreq.has(char) &&
      windowCounts.get(char) === targetFreq.get(char)
    ) {
      formed++;
    }

    while (left <= right && formed === required) {
      const startChar = s[left];

      // Save the smallest window
      if (result[0] === -1 || right - left + 1 < result[0]) {
        result = [right - left + 1, left, right];
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
