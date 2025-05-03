import java.util.ArrayList;
import java.util.List;

class Solution {
  public List<String> fullJustify(String[] words, int maxWidth) {
    List<String> ans = new ArrayList<>();
    int i = 0;

    while (i < words.length) {
      // 1. Select words for current line
      List<String> currentLine = getWords(i, words, maxWidth);
      i += currentLine.size();

      // 2. Format selected words into justified line
      ans.add(createLine(currentLine, i, words, maxWidth));
    }

    return ans;
  }

  private List<String> getWords(int i, String[] words, int maxWidth) {
    List<String> currentLine = new ArrayList<>();
    int currLength = 0;

    while (i < words.length && currLength + words[i].length() <= maxWidth) {
      currentLine.add(words[i]);
      currLength += words[i].length() + 1;
      i++;
    }

    return currentLine;
  }

  private String createLine(List<String> line, int i, String[] words, int maxWidth) {

    boolean isLastLine = (i == words.length);
    boolean isSingleWord = (line.size() == 1);

    if (isLastLine || isSingleWord) {
      StringBuilder sb = new StringBuilder(String.join(" ", line));

      while (sb.length() < maxWidth) {
        sb.append(" ");
      }

      return sb.toString();
    }

    int baseLength = -1;
    for (String word : line) {
      baseLength += word.length() + 1;
    }

    // Compute extra spaces
    int extraSpaces = maxWidth - baseLength;
    // Compute number of spaces between words
    int wordCount = line.size() - 1;
    // Evenly distribute the spaces
    int spacesPerWord = extraSpaces / wordCount;
    // Distribute remaining spaces among leftmost words
    int needsExtraSpaces = extraSpaces % wordCount;

    StringBuilder sb = new StringBuilder();

    for (int j = 0; j < line.size(); j++) {
      sb.append(line.get(j));
      // Add spaces after every word but the last
      if (j < wordCount) {
        for (int k = 0; k < spacesPerWord; k++) {
          sb.append(" ");
        }
        // Assign extra spaces to leftmost words for balance
        if (j < needsExtraSpaces) {
          sb.append(" ");
        }
      }
    }

    return sb.toString();
  }
}
