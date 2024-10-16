import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class provides a solution to group anagrams from a given array of
 * strings.
 */
class Solution {

  /**
   * Groups anagrams together from the given array of strings.
   * This implementation categorizes anagrams by character count.
   *
   * @param strs An array of strings.
   * @return A list of lists, where each inner list contains strings that are
   *         anagrams of each other.
   */
  public List<List<String>> groupAnagrams(String[] strs) {
    // If the input array is empty, return an empty list
    if (strs.length == 0) {
      return new ArrayList<>();
    }

    // Initialize a HashMap to store the character count as key and the list of
    // anagrams as value
    Map<String, List<String>> map = new HashMap<>();

    // Initialize an array to count character occurrences
    int[] count = new int[26];

    // Iterate through each string in the input array
    for (String str : strs) {
      // Reset the count array for each string
      Arrays.fill(count, 0);

      // Count the occurrences of each character in the string
      for (char c : str.toCharArray()) {
        count[c - 'a']++;
      }

      // Convert the character count array to a string representation
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < 26; i++) {
        sb.append('#').append(count[i]);
      }
      String key = sb.toString();

      // If the key is not in the map, add it with a new list
      if (!map.containsKey(key)) {
        map.put(key, new ArrayList<>());
      }

      // Add the original string to the list corresponding to the key
      map.get(key).add(str);
    }

    // Return the list of anagram groups
    return new ArrayList<>(map.values());
  }
}
