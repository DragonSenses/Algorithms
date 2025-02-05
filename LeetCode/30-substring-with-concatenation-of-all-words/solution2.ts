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

  for (let i = 0; i < wordLength; i++) {
      let left = i;
      let right = i;
      const currentCount: { [key: string]: number } = {};
      let wordsUsed = 0;

      while (right + wordLength <= n) {
          const sub = s.substr(right, wordLength);
          right += wordLength;

          if (sub in wordCount) {
              currentCount[sub] = (currentCount[sub] || 0) + 1;
              wordsUsed++;

              while (currentCount[sub] > wordCount[sub]) {
                  const leftWord = s.substr(left, wordLength);
                  currentCount[leftWord]--;
                  wordsUsed--;
                  left += wordLength;
              }

              if (wordsUsed === k) {
                  result.push(left);
              }

          } else {
              currentCount = {};
              wordsUsed = 0;
              left = right;
          }
      }
  }

  return result;
}