import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class provides a solution to group anagrams from a given array of strings.
 * 
 * This implementation categorizes anagrams by character count.
 */
class Solution {

  /**
   * Groups anagrams together from the given array of strings.
   *
   * @param strs An array of strings.
   * @return A list of lists, where each inner list contains strings that are anagrams of each other.
   */
  public List<List<String>> groupAnagrams(String[] strs) {
    // If the input array is empty, return an empty list
    if (strs.length == 0) {
      return new ArrayList<>();
    }

    // Initialize a HashMap to store the character count as key and the list of anagrams as value
    Map<String, List<String>> map = new HashMap<>();

    // Iterate through each string in the input array
    for (String str : strs) {
      // Initialize an array to count character occurrences
      int[] count = new int[26];
      
      // Count the occurrences of each character in the string
      for (char c : str.toCharArray()) {
        count[c - 'a']++;
      }

      // Convert the character count array to a string representation
      StringBuilder sb = new StringBuilder();
      for (int num : count) {
        sb.append('#').append(num);
      }
      String key = sb.toString();

      // If the key is not in the map, add it with a new list
      map.computeIfAbsent(key, k -> new ArrayList<>());

      // Add the original string to the list corresponding to the key
      map.get(key).add(str);
    }

    // Return the list of anagram groups
    return new ArrayList<>(map.values());
  }
}