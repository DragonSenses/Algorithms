/**
 * Finds the longest common prefix string amongst an array of strings.
 *
 * @param strs an array of strings
 * @return the longest common prefix string, or an empty string if there is no common prefix
 */
function longestCommonPrefix(strs: string[]): string {
  // Edge case: if the input array is null or empty, return an empty string
  if (strs == null || strs.length == 0) {
    return "";
  }

  // Iterate over each character of the first string
  for (let i = 0; i < strs[0].length; i++) {
    // Get the current character from the first string
    let c = strs[0].charAt(i);

    // Compare this character with the corresponding character in all other strings
    for (let j = 1; j < strs.length; j++) {
      // If the current character does not match or we reach the end of any string,
      // return the substring of the first string up to the current index
      if (i == strs[j].length || strs[j].charAt(i) != c) {
        return strs[0].substring(0, i);
      }
    }
  }

  // If no mismatch is found, the entire first string is the common prefix
  return strs[0];
};
