import java.util.ArrayList;
import java.util.List;

class Solution {

  /**
   * Fully justifies a given list of words within a specified maxWidth.
   *
   * @param words Array of words to justify
   * @param maxWidth Maximum width of each justified line
   * @return List of fully justified lines
   */
  public List<String> fullJustify(String[] words, int maxWidth) {
    List<String> ans = new ArrayList<>();
    int i = 0;

    while (i < words.length) {
      // Gather words that fit within maxWidth for the current line
      List<String> currentLine = getWords(i, words, maxWidth);
      i += currentLine.size();

      // Format the selected words into a fully justified line
      ans.add(createLine(currentLine, i, words, maxWidth));
    }

    return ans;
  }

  /**
   * Selects words that fit within maxWidth for a single line.
   *
   * @param i Current word index
   * @param words Array of words to process
   * @param maxWidth Maximum width of each justified line
   * @return List of words forming the current line
   */
  private List<String> getWords(int i, String[] words, int maxWidth) {
    List<String> currentLine = new ArrayList<>();
    int currLength = 0;

    while (i < words.length && currLength + words[i].length() <= maxWidth) {
      currentLine.add(words[i]);
      // Account for space after each word except the last one
      currLength += words[i].length() + 1;
      i++;
    }

    return currentLine;
  }

  /**
   * Constructs a fully justified line from selected words.
   *
   * @param line Words forming the current line
   * @param i Index tracking processed words
   * @param words Array of all words
   * @param maxWidth Maximum width of the justified line
   * @return Fully justified line as a string
   */
  private String createLine(List<String> line, int i, String[] words, int maxWidth) {

    // Check if this is the last line or a single-word line
    boolean isLastLine = (i == words.length);
    boolean isSingleWord = (line.size() == 1);

    if (isLastLine || isSingleWord) {
      StringBuilder sb = new StringBuilder(String.join(" ", line));

      // Append spaces to reach maxWidth for left justification
      while (sb.length() < maxWidth) {
        sb.append(" ");
      }

      return sb.toString();
    }

    // Calculate base length excluding trailing space
    // Start at -1 to offset the initial space handling
    int baseLength = -1;
    for (String word : line) {
      baseLength += word.length() + 1; // Word length plus one space
    }

    // Compute the number of extra spaces to distribute
    int extraSpaces = maxWidth - baseLength;
    // Determine number of gaps between words
    int wordCount = line.size() - 1;
    // Compute evenly distributed spaces between words
    int spacesPerWord = extraSpaces / wordCount;
    // Assign remaining spaces to the leftmost words for balance
    int needsExtraSpaces = extraSpaces % wordCount;

    // Construct the fully justified line
    StringBuilder sb = new StringBuilder();

    for (int j = 0; j < line.size(); j++) {
      // Append the current word
      sb.append(line.get(j));

      // Add spaces between words, except after the last one
      if (j < wordCount) {
        for (int k = 0; k < spacesPerWord; k++) {
          sb.append(" ");
        }
        // Assign extra spaces to the leftmost words for even distribution
        if (j < needsExtraSpaces) {
          sb.append(" ");
        }
      }
    }

    return sb.toString();
  }
}
