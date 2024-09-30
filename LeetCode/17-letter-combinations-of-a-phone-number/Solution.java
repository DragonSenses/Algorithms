import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Solution class to generate all possible letter combinations of a phone
 * number.
 */
public class Solution {

  /**
   * Generates all possible letter combinations for the given digits.
   *
   * @param digits A string containing digits from 2-9.
   * @return A list of all possible letter combinations.
   */
  public List<String> letterCombinations(String digits) {
    List<String> combinations = new ArrayList<>();
    if (digits == null || digits.length() == 0) {
      return combinations;
    }

    // Mapping of digits to corresponding letters.
    Map<Character, String> digitToLetters = new HashMap<>();
    digitToLetters.put('2', "abc");
    digitToLetters.put('3', "def");
    digitToLetters.put('4', "ghi");
    digitToLetters.put('5', "jkl");
    digitToLetters.put('6', "mno");
    digitToLetters.put('7', "pqrs");
    digitToLetters.put('8', "tuv");
    digitToLetters.put('9', "wxyz");

    // Start the backtracking process.
    backtrack(combinations, digitToLetters, digits, 0, new StringBuilder());
    return combinations;
  }

  /**
   * Helper method to perform backtracking and generate combinations.
   *
   * @param combinations   The list to store all possible combinations.
   * @param digitToLetters The map of digits to corresponding letters.
   * @param digits         The input string of digits.
   * @param index          The current index in the digits string.
   * @param path           The current combination of letters being formed.
   */
  private void backtrack(List<String> combinations, Map<Character, String> digitToLetters, String digits, int index,
      StringBuilder path) {
    // Base case: if the current combination is complete
    if (index == digits.length()) {
      combinations.add(path.toString());
      return;
    }

    // Get the letters that the current digit maps to
    char digit = digits.charAt(index);
    String letters = digitToLetters.get(digit);
    for (char letter : letters.toCharArray()) {
      // Add the letter to the current path
      path.append(letter);
      // Move on to the next digit
      backtrack(combinations, digitToLetters, digits, index + 1, path);
      // Remove the letter from the path (backtrack)
      path.deleteCharAt(path.length() - 1);
    }
  }
}
