/**
 * Fully justifies a given set of words within a specified maxWidth.
 * @param words - Array of words to justify.
 * @param maxWidth - Maximum width of each justified line.
 * @returns Array of fully justified lines.
 */
function fullJustify(words: string[], maxWidth: number): string[] {
  const result: string[] = [];
  let i = 0;

  while (i < words.length) {
    // Collect words that fit within maxWidth for the current line
    const currentLine = getWords(i, words, maxWidth);
    i += currentLine.length;

    // Format and justify the selected words
    result.push(createLine(currentLine, i, words, maxWidth));
  }

  return result;
}

/**
 * Selects words that fit within maxWidth for the current line.
 * @param i - Starting index in the words array.
 * @param words - Array of words to justify.
 * @param maxWidth - Maximum width of the line.
 * @returns Array of words forming a single justified line.
 */
function getWords(i: number, words: string[], maxWidth: number): string[] {
  const currentLine: string[] = [];
  let currLength = 0;

  while (i < words.length && currLength + words[i].length <= maxWidth) {
    currentLine.push(words[i]);
    // Include a space after each word
    currLength += words[i].length + 1;
    i++;
  }

  return currentLine;
}

/**
 * Formats a line of words into a justified string.
 * @param line - Array of words forming the current line.
 * @param i - Current index in the words array.
 * @param words - Array of words to justify.
 * @param maxWidth - Maximum width of the line.
 * @returns Fully justified line as a string.
 */
function createLine(
  line: string[],
  i: number,
  words: string[],
  maxWidth: number
): string {
  // Determine if this is the last line or a single-word line
  const isLastLine = i === words.length;
  const isSingleWord = line.length === 1;

  if (isLastLine || isSingleWord) {
    let justifiedString = line.join(" ");

    // Pad spaces to reach maxWidth for left justification
    while (justifiedString.length < maxWidth) {
      justifiedString += " ";
    }

    return justifiedString;
  }

  // Compute base length excluding trailing space
  // Start at -1 to offset initial space handling
  let baseLength = -1;
  for (const word of line) {
    baseLength += word.length + 1;
  }

  // Calculate the number of extra spaces to distribute
  const extraSpaces = maxWidth - baseLength;
  // Determine gaps between words
  const wordCount = line.length - 1;
  // Compute evenly distributed spaces between words
  const spacesPerWord = Math.floor(extraSpaces / wordCount);
  // Find remaining spaces for leftmost words
  const needsExtraSpaces = extraSpaces % wordCount;

  // Construct fully justified line
  let justifiedString = "";

  for (let j = 0; j < line.length; j++) {
    justifiedString += line[j];

    // Add spaces between words, except after the last one
    if (j < wordCount) {
      let totalSpaces = spacesPerWord + (j < needsExtraSpaces ? 1 : 0);
      
      justifiedString += (" ".repeat(totalSpaces));

      // Explicitly separate words to avoid merging issues
      if (j + 1 < line.length) {
        justifiedString += " ";
      }
    }
  }

  return justifiedString;
}