function findSubstring(s: string, words: string[]): number[] {
  const indices: number[] = [];
  if (words.length === 0 || words[0].length === 0 || s.length === 0) {
      return indices;
  }

  const wordCount: { [key: string]: number } = {};
  const wordLength = words[0].length;
  const k = words.length;
  const substringSize = wordLength * k;

  for (const word of words) {
      wordCount[word] = (wordCount[word] || 0) + 1;
  }

  function check(i: number): boolean {
      const remaining = { ...wordCount };
      let wordsUsed = 0;

      for (let j = i; j < i + substringSize; j += wordLength) {
          const sub = s.substring(j, j + wordLength);
          if (remaining[sub] != null && remaining[sub] > 0) {
              remaining[sub] -= 1;
              wordsUsed += 1;
          } else {
              return false;
          }
      }
      return wordsUsed === k;
  }

  for (let i = 0; i <= s.length - substringSize; i++) {
      if (check(i)) {
          indices.push(i);
      }
  }

  return indices;
}
