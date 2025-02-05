import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
  // map to store count of each word in words array
  private HashMap<String, Integer> wordCount = new HashMap<>();
  private int wordLength;
  private int substringSize;
  private int k;

  private boolean check(int i, String s) {
    // copy word count for index i
    HashMap<String, Integer> remaining = new HashMap<>(wordCount);
    int wordsUsed = 0;

    // Each iteration will check for a match in words
    for (int j = i; j < i + substringSize; j += wordLength) {
      String sub = s.substring(j, j + wordLength);
      if (remaining.getOrDefault(sub, 0) != 0) {
        remaining.put(sub, remaining.get(sub) - 1);
        wordsUsed++;
      } else {
        break;
      }
    }

    return wordsUsed == k;
  }

  public List<Integer> findSubstring(String s, String[] words) {
    List<Integer> indices = new ArrayList<>();
    if (words.length == 0 || words[0].length() == 0 || s.length() == 0) {
      return indices;
    }

    // Initialize wordCount, wordLength, substringSize, and k
    wordCount = new HashMap<>();
    wordLength = words[0].length();
    k = words.length;
    substringSize = wordLength * k;

    for (String word : words) {
      wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
    }

    // Iterate over each possible starting point in the string `s`
    for (int i = 0; i < s.length() - substringSize + 1; i++) {
      if (check(i, s)) {
        indices.add(i);
      }
    }

    return indices;
  }
}