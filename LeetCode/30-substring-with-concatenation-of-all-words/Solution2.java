import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution2 {
  private int wordLength;
  private int substringSize;
  private int k;

  public List<Integer> findSubstring(String s, String[] words) {
    List<Integer> indices = new ArrayList<>();
    if (words.length == 0 || words[0].length() == 0 || s.length() == 0) {
      return indices;
    }

    wordLength = words[0].length();
    k = words.length;
    substringSize = wordLength * k;

    HashMap<String, Integer> wordCount = new HashMap<>();
    for (String word : words) {
      wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
    }

    for (int i = 0; i < wordLength; i++) {
      slidingWindow(i, s, wordCount, indices);
    }

    return indices;
  }

  private void slidingWindow(int start, String s, HashMap<String, Integer> wordCount,
      List<Integer> indices) {
    HashMap<String, Integer> currentCount = new HashMap<>();
    int wordsUsed = 0;
    int left = start;

    // Iterate over the string `s` in steps of wordLength
    for (int right = start; right + wordLength <= s.length(); right += wordLength) {
      String sub = s.substring(right, right + wordLength);

      if (wordCount.containsKey(sub)) {
        currentCount.put(sub, currentCount.getOrDefault(sub, 0) + 1);
        wordsUsed++;

        while (currentCount.get(sub) > wordCount.get(sub)) {
          String leftWord = s.substring(left, left + wordLength);
          currentCount.put(leftWord, currentCount.get(leftWord) - 1);
          wordsUsed--;
          left += wordLength;
        }

        // If all words are used, record the starting index
        if (wordsUsed == k) {
          indices.add(left);
        }
      } else {
        currentCount.clear();
        wordsUsed = 0;
        left = right + wordLength;
      }
    }
  }
}
