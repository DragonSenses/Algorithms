import java.util.ArrayList;
import java.util.List;

class Solution {
  public List<String> fullJustify(String[] words, int maxWidth) {
    List<String> ans = new ArrayList<>();
    int i = 0;
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
    

    return "";
  }
}
