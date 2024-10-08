# 17. Letter Combinations of a Phone Number

<p>Given a string containing digits from <code>2-9</code> inclusive, return all possible letter combinations that the number could represent. Return the answer in <strong>any order</strong>.</p>

<p>A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.</p>
<img alt="" src="img/17-1.png">
<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> digits = "23"
<strong>Output:</strong> ["ad","ae","af","bd","be","bf","cd","ce","cf"]
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> digits = ""
<strong>Output:</strong> []
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> digits = "2"
<strong>Output:</strong> ["a","b","c"]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
  <li><code>0 &lt;= digits.length &lt;= 4</code></li>
  <li><code>digits[i]</code> is a digit in the range <code>['2', '9']</code>.</li>
</ul>

<br>

---

# Solution

- [Backtracking Approach](#backtracking-approach)

## Interview Tips

### Understand the Constraints

One of the first things you should always do is look at the constraints. Quite often, you can figure out what sort of approach needs to be taken simply from looking at the input size. In an interview, asking your interviewer about the constraints will also show your attention to detail, on top of giving you valuable information.

### Example Problem

In this particular problem, the length of the input is **extremely** small: `0 <= digits.length <= 4`. With such small input sizes, we can safely assume that a brute force solution, in which we generate all combinations of letters, will be accepted.

### Backtracking Algorithmic Technique

Whenever you have a problem where you need to generate all combinations or permutations of some group of letters or numbers, the first thought you should have is backtracking. 

Backtracking is a powerful algorithmic technique used to solve problems that involve searching through all possible configurations to find a solution.

Backtracking algorithms can often keep the space complexity linear with the input size.

### What is Backtracking?

Backtracking is a method for finding solutions to problems incrementally, one piece at a time, and removing those solutions that fail to satisfy the constraints of the problem at any point in time. It's often used for problems involving permutations, combinations, and other forms of exhaustive search.

### How Does Backtracking Work?

1. **Choose**: Select a starting point or an initial decision.
2. **Explore**: Move forward by making a choice and recursively explore further decisions.
3. **Check**: If the current path leads to a solution, record it. If not, backtrack by undoing the last choice and try another path.

### Example: Generating Combinations

Imagine you need to generate all possible combinations of a set of letters. Here's how backtracking would work:

1. **Start** with an empty combination.
2. **Add** a letter to the current combination.
3. **Recursively** add more letters to the combination.
4. **Check** if the combination meets the criteria (e.g., length).
5. **Backtrack** by removing the last added letter and try the next possibility.

### Pseudocode for Backtracking

Here's a simple pseudocode example for generating combinations:

```pseudo
function backtrack(combination, next_index):
    if combination is a valid solution:
        output(combination)
        return
    for each letter in the set starting from next_index:
        add letter to combination
        backtrack(combination, next_index + 1)
        remove letter from combination
```

### Key Points

- **Efficiency**: Backtracking can be more efficient than brute force because it eliminates paths that are guaranteed not to lead to a solution.
- **Applications**: It's used in solving puzzles (like Sudoku), generating permutations and combinations, and in constraint satisfaction problems.

# Backtracking Approach

## **Intuition**

The key to solving this problem is correctly generating all possible letter combinations using a standard backtracking algorithm. 

- **Single-digit case**: Generate all letters for the given digit.
- **Two-digit case**: Fix the first letter and generate combinations for the second digit.
- **Three-digit case**: Generate combinations for the first two digits, then append letters for the third digit.
- **Four-digit case**: Generate combinations for the first three digits, then append letters for the fourth digit.

Let's break down the problem step-by-step:

### Single-Digit Case

Start with a simple case where the input is only one digit long, for example, `digits = "2"`. This is straightforward: just generate all letters that correspond to `digit = "2"`, which would be `["a", "b", "c"]`.

### Two-Digit Case

Now, consider a two-digit input, `digits = "23"`. Imagine taking each letter of `digit = "2"` as a starting point. That is, **lock in the first letter**, and solve for all possible combinations that **start with that letter**. For instance, if the first letter is `"a"`, then the problem reduces to generating all letters corresponding to `digit = "3"` and appending them to `"a"`, resulting in `["ad", "ae", "af"]`. This is easy because we treat the first letter as fixed and solve the one-digit case for the second digit. We already know how to generate the first letters: `["a", "b", "c"]`.

### Extending to Multiple Digits

As you can see, solving the one-digit case is trivial, and solving the two-digit case is just solving the one-digit case twice. This reasoning can be extended to `n` digits. For the three-digit case, solve the two-digit case to generate all combinations of the first two letters, and then solve the one-digit case for the final digit. Similarly, for the four-digit case, solve the three-digit case for all combinations of the first three letters, and then solve the one-digit case for the final digit. This approach can be extended indefinitely, but for this problem, we only need to handle up to four digits.

This structured approach ensures that we systematically generate all possible combinations using backtracking.

## **Algorithm**

### Overview

To generate all possible letter combinations for a given string of digits, we will use a backtracking approach. This involves "**locking in**" letters as we generate new combinations. 

Recursion is an effective way to manage this state.

### Steps

1. **Handle Edge Case**
   - If the input is empty, return an empty array.

2. **Initialize Data Structure**
   - Create a hash map that maps each digit to its corresponding letters (e.g., mapping "6" to "m", "n", and "o").

3. **Backtracking Function**
   - Use a recursive function to generate all possible combinations.

### Detailed Algorithm

1. **Edge Case Handling**
   - Check if the input is empty and return an empty array if it is.

2. **Initialize Hash Map**
   - Set up a mapping of each digit to its corresponding letters.

3. **Backtracking Function**
   - **Inputs**: The current combination of letters (`path`) and the current index in the `digits` string (`index`).
   - **Base Case**: If the current combination's length equals the input `digits` length, add it to the result.
   - **Recursive Case**: For the current digit, loop through its corresponding letters, add each letter to the current `path`, and call the backtracking function with the next index. Remove the letter from `path` after exploring all combinations starting with it.

4. **Initialize and Call Backtracking**
   - Start with an empty combination and the first digit, and recursively generate all possible combinations.

## **Implementation**

#### Key Points

- **Edge Case**: Return an empty array if the input is empty.
- **Data Structure**: Use a hash map to map digits to their corresponding letters.
- **Backtracking**: Use a recursive function to generate all possible combinations by exploring each letter for the current digit and moving to the next digit.

### Java

```java
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
  public List<String> letterCombinations(String digits) {
    List<String> combinations = new ArrayList<>();
    if (digits == null || digits.length() == 0) {
      return combinations;
    }

    Map<Character, String> digitToLetters = new HashMap<>();
    digitToLetters.put('2', "abc");
    digitToLetters.put('3', "def");
    digitToLetters.put('4', "ghi");
    digitToLetters.put('5', "jkl");
    digitToLetters.put('6', "mno");
    digitToLetters.put('7', "pqrs");
    digitToLetters.put('8', "tuv");
    digitToLetters.put('9', "wxyz");

    backtrack(combinations, digitToLetters, digits, 0, new StringBuilder());
    return combinations;
  }

  private void backtrack(List<String> combinations, Map<Character, String> digitToLetters, String digits, int index,
      StringBuilder path) {
    if (index == digits.length()) {
      combinations.add(path.toString());
      return;
    }

    char digit = digits.charAt(index);
    String letters = digitToLetters.get(digit);
    for (char letter : letters.toCharArray()) {
      path.append(letter);
      backtrack(combinations, digitToLetters, digits, index + 1, path);
      path.deleteCharAt(path.length() - 1);
    }
  }
}
```

### Explanation

1. **Edge Case Handling**: If the input `digits` is empty, return an empty list.
2. **Initialize Data Structure**: Create a hash map to map each digit to its corresponding letters.
3. **Backtracking Function**:
   - **Base Case**: If the current combination's length equals the input `digits` length, add it to the result list.
   - **Recursive Case**: For the current digit, loop through its corresponding letters, add each letter to the current path, and call the backtracking function with the next index. Remove the letter from the path after exploring all combinations starting with it.

### TypeScript

Typescript solution is the same as Java but with these changes:

- **TypeScript Syntax**: Converted Java-specific syntax to TypeScript.
- **Type Annotations**: Added type annotations for function parameters and return types.
- **StringBuilder Replacement**: Used string concatenation instead of `StringBuilder`.

```typescript
/**
 * Generates all possible letter combinations for the given digits.
 *
 * @param digits - A string containing digits from 2-9.
 * @returns A list of all possible letter combinations.
 */
function letterCombinations(digits: string): string[] {
  const combinations: string[] = [];

  // Edge case: Input is empty, return an empty string array
  if (!digits || digits.length === 0) {
    return combinations;
  }

  // Mapping of digits to corresponding letters.
  const digitToLetters: { [key: string]: string } = {
    '2': 'abc',
    '3': 'def',
    '4': 'ghi',
    '5': 'jkl',
    '6': 'mno',
    '7': 'pqrs',
    '8': 'tuv',
    '9': 'wxyz'
  };

  // Start the backtracking process.
  backtrack(combinations, digitToLetters, digits, 0, '');
  return combinations;
}

/**
 * Helper method to perform backtracking and generate combinations.
 *
 * @param combinations - The list to store all possible combinations.
 * @param digitToLetters - The map of digits to corresponding letters.
 * @param digits - The input string of digits.
 * @param index - The current index in the digits string.
 * @param path - The current combination of letters being formed.
 */
function backtrack(
  combinations: string[],
  digitToLetters: { [key: string]: string },
  digits: string,
  index: number,
  path: string
): void {
  // Base case: if the current combination is complete
  if (index === digits.length) {
    combinations.push(path);
    return;
  }

  // Get the letters that the current digit maps to
  const digit = digits[index];
  const letters = digitToLetters[digit];
  for (const letter of letters) {
    // Add the letter to the current path and move on to the next digit
    backtrack(combinations, digitToLetters, digits, index + 1, path + letter);
  }
}
```

## **Complexity Analysis**

Let `n` be the length of the input `digits`.

### **Time Complexity**: `O(4^n * n)`

- **Digit Length**: `n`
- **Maximum Value Length in Hash Map**: The factor `4` in the expression refers to the maximum number of letters mapped to a single digit (digits 7 and 9 map to 4 letters each), not the length of the input.
- **Worst Case**: The worst-case scenario occurs when the input consists only of digits 7 and 9. In this case, we need to explore 4 additional paths for each extra digit. For each combination, it takes up to `n` operations to build the combination. This problem can be generalized to a scenario where digits correspond to up to `M` letters, resulting in a time complexity of `O(M^n * n)`. Given the problem constraints, `M = 4` because digits 7 and 9 have 4 letters each.
- **Overall Complexity**: The combined time complexity is `O(4^n * n)`.

### **Space Complexity**: `O(n)`

- **Recursion Call Stack**: The extra space used relative to the input size is the space occupied by the recursion call stack. The depth of the recursion will be at most the number of digits in the input, as we backtrack once we reach that depth.
- **Hash Map Space**: The hash map does not grow with the input size and occupies `O(1)` space.
