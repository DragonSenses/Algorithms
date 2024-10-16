/**
 * Groups anagrams together from the given array of strings.
 *
 * @param strs - An array of strings.
 * @returns A list of lists, where each inner list contains strings that are anagrams of each other.
 */
function groupAnagrams(strs: string[]): string[][] {
  const map: { [key: string]: string[] } = {};

  for (const str of strs) {
    // Convert the string to a character array and sort it
    const sortedStr = str.split('').sort().join('');

    // If the sorted string is not in the map, add it with a new list
    if (!map[sortedStr]) {
      map[sortedStr] = [];
    }

    // Add the original string to the list corresponding to the sorted string key
    map[sortedStr].push(str);
  }

  // Return the list of anagram groups
  return Object.values(map);
};
