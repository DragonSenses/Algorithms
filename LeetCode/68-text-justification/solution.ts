function fullJustify(words: string[], maxWidth: number): string[] {
  const result: string[] = [];
  return result;
}

function getWords(i: number, words: string[], maxWidth: number): string[] {
  const currentLine: string[] = [];
  let currLength = 0;

  while (i < words.length && currLength + words[i].length <= maxWidth) {
    currentLine.push(words[i]);
    // Account for a space after each word
    currLength += words[i].length + 1;
    i++;
  }

  return currentLine;
}
