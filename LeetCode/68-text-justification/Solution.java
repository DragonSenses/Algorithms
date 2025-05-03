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

}
