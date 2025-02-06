function findSubstring(s: string, words: string[]): number[] {
  const result: number[] = [];
  if (!s || words.length === 0) {
    return result;
  }

  const n = s.length;
  const k = words.length;
  const wordLength = words[0].length;

  // Build a map to count occurrences of each word in words array
  const wordCount: { [key: string]: number } = {};
  for (const word of words) {
    wordCount[word] = (wordCount[word] || 0) + 1;
  }

  // Iterate over each possible starting index in the string
  for (let i = 0; i < wordLength; i++) {
    let left = i;
    let right = i;
    let currentCount: { [key: string]: number } = {};
    let wordsUsed = 0;

    // Slide the window over the string
    while (right + wordLength <= n) {
      const sub = s.substring(right, right + wordLength); // Extract the current word
      right += wordLength;

      if (sub in wordCount) {
        currentCount[sub] = (currentCount[sub] || 0) + 1;
        wordsUsed++;

        // Adjust the window to fit within the allowed counts
        while (currentCount[sub] > wordCount[sub]) {
          const leftWord = s.substring(left, left + wordLength);
          currentCount[leftWord]--;
          wordsUsed--;
          left += wordLength;
        }

        // If all words are used exactly once, record the starting index
        if (wordsUsed === k) {
          result.push(left);
        }
      } else {
        // Reset the window if the current word is not part of the word count
        currentCount = {};
        wordsUsed = 0;
        left = right;
      }
    }
  }

  return result;
}