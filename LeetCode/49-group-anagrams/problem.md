# 49. Group Anagrams

<p>Given an array of strings <code>strs</code>, group the <strong>anagrams</strong> together. You can return the answer in <strong>any order</strong>.</p>

- An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, using all the original letters exactly once.

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">strs = ["eat","tea","tan","ate","nat","bat"]</span></p>

<p><strong>Output:</strong> <span class="example-io">[["bat"],["nat","tan"],["ate","eat","tea"]]</span></p>

<p><strong>Explanation:</strong></p>

<ul>
	<li>There is no string in strs that can be rearranged to form <code>"bat"</code>.</li>
	<li>The strings <code>"nat"</code> and <code>"tan"</code> are anagrams as they can be rearranged to form each other.</li>
	<li>The strings <code>"ate"</code>, <code>"eat"</code>, and <code>"tea"</code> are anagrams as they can be rearranged to form each other.</li>
</ul>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">strs = [""]</span></p>

<p><strong>Output:</strong> <span class="example-io">[[""]]</span></p>
</div>

<p><strong class="example">Example 3:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">strs = ["a"]</span></p>

<p><strong>Output:</strong> <span class="example-io">[["a"]]</span></p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= strs.length &lt;= 10<sup>4</sup></code></li>
	<li><code>0 &lt;= strs[i].length &lt;= 100</code></li>
	<li><code>strs[i]</code> consists of lowercase English letters.</li>
</ul>

<br>

---

# Solution
-[Categorize by Sorted String Approach](#categorize-by-sorted-string)
  - **Time Complexity**: `O(n*k*logk)`
- [Categorize by Character Count Approach](#categorize-by-character-count)
  - **Time Complexity**: `O(n * k)`

# Categorize by Sorted String

## **Intuition**

Two strings are anagrams if and only if their sorted strings are equal. This insight allows us to group anagrams by sorting each string and using the sorted string as a key.

### Additional Details

- An anagram is a word or phrase formed by rearranging the letters of a different word or phrase, using all the original letters exactly once.
- By sorting each string, all anagrams will have the same sorted representation.

## **Algorithm**

1. **Initialize a HashMap**:
   - Create a hash map where each key is a sorted string and each value is a list of strings that, when sorted, are equal to the key.

2. **Iterate Through the Array**:
   - For each string in the input array:
     1. Sort the string.
     2. Use the sorted string as a key in the hash map.
     3. Append the original string to the list of anagrams for that key.

3. **Return the Values of the HashMap**:
   - The values of the hash map represent the grouped anagrams.

### Example

**Input**: `strs = ["eat", "tea", "tan", "ate", "nat", "bat"]`

**Output**: `[["bat"], ["nat", "tan"], ["ate", "eat", "tea"]]`

**Explanation**:
- `map = {"aet": ["eat", "tea", "ate"], "ant": ["tan", "nat"], "abt": ["bat"]}`

## **Implementation**

### Java

```java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    
    // Initialize a HashMap to store the sorted string as key and the list of anagrams as value
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
```

### TypeScript

```typescript
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
```

## **Complexity Analysis**

Let \( n \) be the length of the input array, and \( k \) be the maximum length of a string in `strs`.

### **Time Complexity**: \( O(n \cdot k \log k) \)

- **Outer Loop**: We iterate through each string in the input array, so this part takes \( O(n) \).
- **Sorting Each String**: Sorting each string takes \( O(k \log k) \).
- **Overall Complexity**: Combining these operations, the overall time complexity is \( O(n \cdot k \log k) \), as we are sorting each string and then performing the operations.

### Space Complexity: \( O(n \cdot k) \)

- **Map Storage**: The hash map used to store each sorted string as the key and the list of anagrams as the value requires space proportional to the number of strings and the maximum length of the strings, which is \( O(n \cdot k) \).

In summary, the refined complexity analysis for this approach is:

- **Time Complexity**: \( O(n \cdot k \log k) \)
- **Space Complexity**: \( O(n \cdot k) \)

# Categorize by Character Count

## **Intuition**

Two strings are anagrams if and only if their character counts (i.e., the respective number of occurrences of each character) are the same. By converting each string into a character count representation, we can effectively group anagrams together.

### Detailed Explanation

- An anagram is a word or phrase formed by rearranging the letters of another, using all original letters exactly once.
- By counting the occurrences of each character, anagrams will have identical character count representations.

## **Algorithm**

1. **Initialize a HashMap**:
   - Create a hash map where each key is a string representing the character count, and each value is a list of strings that share this character count.

2. **Transform Each String**:
   - For each string `s` in the input array `strs`:
     1. Initialize an array `count` of size 26 to represent the character counts for `a` to `z`.
     2. Increment the appropriate index in the `count` array for each character in `s`.
     3. Convert the `count` array into a string representation, with counts separated by a delimiter (e.g., `#`).

3. **Build the HashMap**:
   - Use the string representation of the `count` array as the key in the hash map.
   - Append the original string to the list of anagrams for that key.

4. **Return the Values of the HashMap**:
   - The values of the hash map represent the grouped anagrams.

### Example

**Input**: `strs = ["eat", "tea", "tan", "ate", "nat", "bat"]`

**Output**: `[["eat", "tea", "ate"], ["tan", "nat"], ["bat"]]`

**Explanation**:
- `map = {"#1#0#0#0#1#0#0#0#0#0#0#0#0#0#0#0#0#0#0#0#0#0#0#0#0#0": ["bat"], "#1#0#0#0#1#0#1#0#0#0#0#0#0#0#0#0#0#0#0#0#0#0#0#0#0#0": ["tan", "nat"], "#1#0#1#0#1#0#0#0#0#0#0#0#0#0#0#0#0#0#0#0#0#0#0#0#0": ["eat", "tea", "ate"]}`

## **Implementation**

### Implementation Details

1. **Initialize the Result List**:
   - If the input array is empty, return an empty list.

2. **Initialize a HashMap**:
   - Create a hash map where each key is the character count string, and each value is a list of anagrams.

3. **Iterate Through Each String**:
   - For each string in the input array:
     1. **Reset the Count Array**:
        - Initialize an array to count character occurrences and reset it for each string.
     2. **Count Character Occurrences**:
        - Iterate through the characters in the string and count the occurrences of each character.
     3. **Convert the Count Array to a String**:
        - Convert the character count array into a string representation, where counts are separated by `#`.
     4. **Update the HashMap**:
        - If the key is not in the map, add it with a new list.
        - Add the original string to the list corresponding to the key.

4. **Return the List of Anagram Groups**:
   - Return the values of the hash map as the result list.

### Java

```java
import java.util.ArrayList;
import java.util.Arrays;
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
    // Step 1: Initialize the result list
    if (strs.length == 0) {
      return new ArrayList<>();
    }

    // Step 2: Initialize a HashMap
    Map<String, List<String>> map = new HashMap<>();

    // Step 3: Iterate through each string
    int[] count = new int[26];
    for (String str : strs) {
      // Step 3.1: Reset the count array
      Arrays.fill(count, 0);

      // Step 3.2: Count character occurrences
      for (char c : str.toCharArray()) {
        count[c - 'a']++;
      }

      // Step 3.3: Convert the count array to a string
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < 26; i++) {
        sb.append('#').append(count[i]);
      }
      String key = sb.toString();

      // Step 3.4: Update the HashMap
      if (!map.containsKey(key)) {
        map.put(key, new ArrayList<>());
      }
      map.get(key).add(str);
    }

    // Step 4: Return the list of anagram groups
    return new ArrayList<>(map.values());
  }
}
```

## **Complexity Analysis**

Let \( n \) be the length of the input array, and \( k \) be the maximum length of a string in `strs`.

### **Time Complexity**: \( O(n \cdot k) \)

- **Outer Loop**: We iterate through each string in the input array, so this part takes \( O(n) \).
- **Character Counting**: Counting each string is linear in the size of the string, i.e., \( O(k) \), and we count every string.
- **Overall Complexity**: Combining these operations, the overall time complexity is \( O(n \cdot k) \).

### **Space Complexity**: \( O(n \cdot k) \)

- **Map Storage**: The hash map used to store each character count string as the key and the list of anagrams as the value requires space proportional to the number of strings and the maximum length of the strings, which is \( O(n \cdot k) \).

In summary, the refined complexity analysis for this approach is:

- **Time Complexity**: \( O(n \cdot k) \)
- **Space Complexity**: \( O(n \cdot k) \)
