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
   *
   * @param strs An array of strings.
   * @return A list of lists, where each inner list contains strings that are
   *         anagrams of each other.
   */
  public List<List<String>> groupAnagrams(String[] strs) {
    // If the input array is empty, return an empty list
    if (strs.length == 0)
      return new ArrayList<>();

    // Initialize a HashMap to store the sorted string as key and the list of
    // anagrams as value
    Map<String, List<String>> map = new HashMap<>();

    // Iterate through each string in the input array
    for (String str : strs) {
      // Convert the string to a character array and sort it
      char[] charArray = str.toCharArray();
      Arrays.sort(charArray);

      // Convert the sorted character array back to a string
      String sortedStr = new String(charArray);

      // If the sorted string is not in the map, add it with a new list
      if (!map.containsKey(sortedStr)) {
        map.put(sortedStr, new ArrayList<>());
      }

      // Add the original string to the list corresponding to the sorted string key
      map.get(sortedStr).add(str);
    }

    // Return the list of anagram groups
    return new ArrayList<>(map.values());
  }
}
