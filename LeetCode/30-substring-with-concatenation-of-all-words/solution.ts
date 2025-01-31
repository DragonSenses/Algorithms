function findSubstring(s: string, words: string[]): number[] {
  const result: number[] = [];
  if (!s || words.length === 0) {
      return result;
  }

  const n = s.length;
  const k = words.length;
  const wordLength = words[0].length;
  const substringSize = wordLength * k;
  
  const wordCount: { [key: string]: number } = {};
  for (const word of words) {
      wordCount[word] = (wordCount[word] || 0) + 1;
  }

  const check = (start: number): boolean => {
      const remaining: { [key: string]: number } = { ...wordCount };
      let wordsUsed = 0;

      for (let j = start; j < start + k * wordLength; j += wordLength) {
          const sub = s.substr(j, wordLength);
          if (remaining[sub] && remaining[sub] > 0) {
              remaining[sub]--;
              wordsUsed++;
          } else {
              return false;
          }
      }

      return wordsUsed === k;
  };

  for (let i = 0; i <= n - substringSize; i++) {
      if (check(i)) {
          result.push(i);
      }
  }

  return result;
};