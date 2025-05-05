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

function createLine(
  line: string[],
  i: number,
  words: string[],
  maxWidth: number
): string {
  // Check if it is the last line or a single-word line
  const isLastLine = i === words.length;
  const isSingleWord = line.length === 1;

  if (isLastLine || isSingleWord) {
    let justifiedString = line.join(" ");

    // Append spaces to reach maxWidth for left justification
    while (justifiedString.length < maxWidth) {
      justifiedString += " ";
    }

    return justifiedString;
  }

  return "";
}
