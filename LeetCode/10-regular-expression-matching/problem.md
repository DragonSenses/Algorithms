# 10. Regular Expression Matching

Given an input string `s` and a pattern `p`, implement regular expression matching with support for `'.'` and `'*'` where:

  - `'.'` Matches any single character.​​​​
  - `'*'` Matches zero or more of the preceding element.

The matching should cover the **entire** input string (not partial).

#### Example 1:

Input: s = "aa", p = "a"

Output: false

Explanation: "a" does not match the entire string "aa".

#### Example 2:

Input: s = "aa", p = "a*"

Output: true

Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".

#### Example 3:

Input: s = "ab", p = ".*"
Output: true
Explanation: ".*" means "zero or more (*) of any character (.)".

#### Constraints:

  - `1 <= s.length <= 20`
  - `1 <= p.length <= 20`
  - `s` contains only lowercase English letters.
  - `p` contains only lowercase English letters, `'.'`, and `'*'`.
  - It is guaranteed for each appearance of the character `'*'`, there will be a previous valid character to match.

<br>

---

# Solution

- [Recursive Approach](#recursive-approach)
  - **Time Complexity**: `O(2^(n+m))`
  - **Space Complexity**: `O(n+m)`
- [Top-Down (Dynamic Programming) Approach](#top-down-memoization-dynamic-programming-approach)
  - **Time Complexity**: `O(n * m)`
  - **Space Complexity**: `O(n * m)`
- [Bottom-Up (Dynamic Programming) Approach](#bottom-up-tabulation-dynamic-programming-approach)

## Overview: Regular Expressions

Regular expression matching is a technique used to search for specific patterns within strings. It allows for complex search criteria using various special characters, often called wildcards.

In this problem, you need to implement a function that performs regular expression matching.

This problem requires a thorough understanding of how regular expressions work and how to implement the matching logic to cover all possible cases.

### Problem Overview: Regular Expression Matching

In this problem, you need to implement a function that performs regular expression matching. The function will take an input string `s` and a pattern `p`, and it should determine whether the pattern matches the entire input string. The pattern supports the following special characters:

- `.` Matches any single character.
- `*` Matches zero or more of the preceding element.

The matching must cover the **entire** input string (not just a part of it).

#### Key Points:
1. **Pattern Matching Rules**:
   - `.` can match any single character.
   - `*` can match zero or more occurrences of the preceding character.

2. **Constraints**:
   - `1 <= s.length <= 20`
   - `1 <= p.length <= 20`
   - `s` contains only lowercase English letters.
   - `p` contains only lowercase English letters, `'.'`, and `'*'`.
   - It is guaranteed that for each appearance of the character `'*'`, there will be a preceding valid character to match.

#### Examples:
- **Example 1**:
  - **Input**: s = "aa", p = "a"
  - **Output**: false
  - **Explanation**: The pattern "a" does not match the entire string "aa".

- **Example 2**:
  - **Input**: s = "aa", p = "a*"
  - **Output**: true
  - **Explanation**: The '*' means zero or more of the preceding element 'a'. Therefore, by repeating 'a' once, it becomes "aa".

- **Example 3**:
  - **Input**: s = "ab", p = ".*"
  - **Output**: true
  - **Explanation**: The pattern ".*" means "zero or more (*) of any character (.)".

## Overview: Recursion, Dynamic Programming, Top-Down (Memoization), Bottom-Up (Tabulation)

### Recursion
Recursion is a programming technique where a function calls itself to solve a smaller instance of the same problem. This process continues until the function reaches a base case, which is a condition that stops the recursion. Recursion is particularly useful for problems that can be broken down into smaller, similar subproblems.

**Example**: Calculating the factorial of a number `n`:
```java
public class RecursionExample {
    public int factorial(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    public static void main(String[] args) {
        RecursionExample example = new RecursionExample();
        System.out.println(example.factorial(5)); // Output: 120
    }
}
```

In this example, the method `factorial` calls itself with `n - 1` until it reaches the base case (`n == 1`).

### Dynamic Programming (DP)
Dynamic programming is a technique used to solve complex problems by breaking them down into simpler subproblems. It stores the results of subproblems to avoid redundant computations, making the overall solution more efficient. DP is particularly effective for optimization problems and problems with overlapping subproblems and optimal substructure.

**Example**: Fibonacci sequence
- **Recursive approach**: 
```java
public class FibonacciRecursive {
    public int fib(int n) {
        if (n <= 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }

    public static void main(String[] args) {
        FibonacciRecursive example = new FibonacciRecursive();
        System.out.println(example.fib(10)); // Output: 55
    }
}
```

- **Dynamic programming approach**:
```java
public class FibonacciDP {
    public int fib(int n) {
        if (n <= 1) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        FibonacciDP example = new FibonacciDP();
        System.out.println(example.fib(10)); // Output: 55
    }
}
```

In the DP approach, the results of previous calculations are stored in an array `dp`, avoiding redundant calculations.

### Top-Down Memoization
Top-down memoization is a technique in dynamic programming where the problem is solved recursively, but intermediate results are stored (memoized) to avoid redundant calculations. This approach is also known as "memoization." It combines the benefits of recursion and dynamic programming.

**Example**: Fibonacci sequence with memoization
```java
import java.util.HashMap;
import java.util.Map;

public class FibonacciMemoization {
    private Map<Integer, Integer> memo = new HashMap<>();

    public int fib(int n) {
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        if (n <= 1) {
            return n;
        }
        int result = fib(n - 1) + fib(n - 2);
        memo.put(n, result);
        return result;
    }

    public static void main(String[] args) {
        FibonacciMemoization example = new FibonacciMemoization();
        System.out.println(example.fib(10)); // Output: 55
    }
}
```

In this example, the results of previous Fibonacci calculations are stored in the `memo` map, preventing redundant recursive calls.

### Bottom-Up Tabulation
Bottom-up tabulation is another dynamic programming technique where the problem is solved iteratively, starting from the base cases and building up to the final solution. This approach uses a table to store the results of subproblems.

**Example**: Fibonacci sequence with bottom-up tabulation
```java
public class FibonacciBottomUp {
    public int fib(int n) {
        if (n <= 1) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        FibonacciBottomUp example = new FibonacciBottomUp();
        System.out.println(example.fib(10)); // Output: 55
    }
}
```

In this example, the `dp` array is filled iteratively, starting from the base cases (`dp[0]` and `dp[1]`), and building up to `dp[n]`.

### Relationship Between Recursion, DP, Memoization, and Tabulation
1. **Recursion**: A fundamental technique where a function calls itself to solve smaller instances of the problem.
2. **Dynamic Programming**: An optimization technique to solve problems by breaking them into subproblems, storing results to avoid redundant calculations.
3. **Top-Down Memoization**: Combines recursion and dynamic programming by solving subproblems recursively and storing intermediate results to avoid redundant computations.
4. **Bottom-Up Tabulation**: Solves the problem iteratively by starting from the base cases and building up to the final solution using a table to store results.

Top-down memoization and bottom-up tabulation are both dynamic programming techniques that aim to optimize the solution by storing intermediate results, but they differ in their approach. Memoization leverages recursion, while tabulation uses an iterative approach.

By understanding these concepts, you can choose the most appropriate technique based on the problem's characteristics and constraints.

# Recursive Approach

## **Intuition**

Without the Kleene stars (the `*` wildcard character in regular expressions), the problem is straightforward—we check from left to right if each character in the input string matches the pattern. The presence of a star complicates things because we must evaluate various suffixes of the input string to see if they match the remaining pattern. A recursive approach elegantly represents this relationship and handles the complexity introduced by the `*`.

When a star appears in the pattern (specifically at the second position, `pattern[1]`), we have two options:
1. **Ignore the star and its preceding character**: This treats the star as if it matches zero occurrences of the preceding character.
2. **Use the star to match one or more occurrences of the preceding character**: This allows us to delete a matching character in the text and continue checking.

If any of these operations result in a successful match for the remaining strings, then the entire pattern matches the input string.

## **Algorithm**

1. **Base Case**:
   - If the pattern is empty, the text must also be empty for a match.

2. **First Character Match**:
   - Determine if the first character of the text matches the first character of the pattern. The match is true if either the characters are identical, or the pattern contains a `.`.

3. **Star Handling**:
   - If the second character of the pattern is `*`, there are two possibilities:
     - Ignore the `*` and its preceding character (`pattern[0]`): Recursively check the remainder of the pattern with the text.
     - Use the `*` to match one or more occurrences of `pattern[0]`: Recursively check the text (with the first character removed) against the entire pattern.

4. **No Star**:
   - If the second character is not `*`, recursively check the remainder of the text and pattern.

### **Pseudocode**

```pseudo
function isMatch(text, pattern):
    if pattern is empty:
        return text is empty

    first_match = (not text is empty) and (pattern[0] == text[0] or pattern[0] == '.')

    if len(pattern) >= 2 and pattern[1] == '*':
        return (isMatch(text, pattern[2:]) or
                (first_match and isMatch(text[1:], pattern)))
    else:
        return first_match and isMatch(text[1:], pattern[1:])
```

## **Implementation**

### **Java**

The implementation provides two versions of the `isMatch` function—one without handling the `*` character and one that includes handling it.

### Java Implementation Without `*`

```java
public class Solution {
  public boolean isMatch(String text, String pattern) {
    // Base case: If pattern is empty, check if text is also empty
    if (pattern.isEmpty()) {
      return text.isEmpty();
    }

    // Check if the first character matches
    boolean firstMatch =
        (!text.isEmpty() && (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));

    // Recursively check the rest of the text and pattern
    return firstMatch && isMatch(text.substring(1), pattern.substring(1));
  }
}
```

### Java Implementation With `*`

```java
public class Solution {
  public boolean isMatch(String text, String pattern) {
    // Base case: If pattern is empty, check if text is also empty
    if (pattern.isEmpty()) {
      return text.isEmpty();
    }

    // Check if the first character matches
    boolean firstMatch =
        (!text.isEmpty() && (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));

    // Check if the second character of the pattern is '*'
    if (pattern.length() >= 2 && pattern.charAt(1) == '*') {
      // Ignore the '*' and its preceding character or use the '*' to match one or more occurrences
      return (isMatch(text, pattern.substring(2))
          || (firstMatch && isMatch(text.substring(1), pattern)));
    } else {
      // No '*', recursively check the rest of the text and pattern
      return firstMatch && isMatch(text.substring(1), pattern.substring(1));
    }
  }
}
```

### **TypeScript**

### TypeScript Implementation Without `*`

```typescript
function isMatch(s: string, p: string): boolean {
  // Base case: If pattern is empty, check if text is also empty
  if (p.length === 0) {
    return s.length === 0;
  }

  // Check if the first character matches
  const firstMatch = s.length !== 0 && (p[0] === s[0] || p[0] === ".");

  // No '*' in the pattern, recursively check the rest of the text and pattern
  return firstMatch && isMatch(s.substring(1), p.substring(1));
}
```

In this version, the logic is simplified because there's no need to handle the `*` character. We simply check if each character in the string matches the corresponding character in the pattern, considering that `.` can match any character.

### TypeScript Implementation With `*`

```typescript
function isMatch(s: string, p: string): boolean {
  // Base case: If pattern is empty, check if text is also empty
  if (p.length === 0) {
    return s.length === 0;
  }

  // Check if the first character matches
  const firstMatch = s.length !== 0 && (p[0] === s[0] || p[0] === ".");

  // Check if the second character of the pattern is '*'
  if (p.length >= 2 && p[1] === "*") {
    // Ignore the '*' and its preceding character or use the '*' to match one or more occurrences
    return (
      isMatch(s, p.substring(2)) || (firstMatch && isMatch(s.substring(1), p))
    );
  } else {
    // No '*', recursively check the rest of the text and pattern
    return firstMatch && isMatch(s.substring(1), p.substring(1));
  }
}
```

In this TypeScript implementation, the logic is essentially the same as in the Java version, but adapted to TypeScript syntax and conventions. The key differences are the type annotations (`s: string, p: string`), and the use of TypeScript's string methods (`substring`) to handle string manipulations.

## **Complexity Analysis**

To analyze the complexity of the recursive approach to regular expression matching, let's break down the time and space complexity for both versions: without the `*` wildcard and with the `*` wildcard.

- [Without the `*` Wildcard](#without-the--wildcard)
  - **Time Complexity**: `O(n)`
  - **Space Complexity**: `O(n)`

- [With the `*` Wildcard](#with-the--wildcard)
  - **Time Complexity**: `O(2^(n+m))`
  - **Space Complexity**: `O(n+m)`

### Assumptions

To clarify and set the context for the problem, here are some key assumptions:

1. **Input Constraints**:
   - The length of the input string `s` is between 1 and 20 characters: `1 <= s.length <= 20`.
   - The length of the pattern `p` is between 1 and 20 characters: `1 <= p.length <= 20`.

2. **Character Constraints**:
   - The input string `s` contains only lowercase English letters (a-z).
   - The pattern `p` contains only lowercase English letters (a-z), the special character `.` (which matches any single character), and the special character `*` (which matches zero or more of the preceding element).

3. **Pattern Validity**:
   - Each appearance of the character `*` in the pattern `p` has a preceding valid character to match. This means patterns like `*a` or `***` are not considered valid.

4. **Matching Requirement**:
   - The matching should cover the **entire** input string. Partial matches are not considered valid.

5. **Case Sensitivity**:
   - Both the input string `s` and the pattern `p` are case-sensitive. For example, 'a' matches 'a' but does not match 'A'.

#### Without the `*` Wildcard:

### **Time Complexity**: `O(n)`
- **Single Pass**: For each character in the input string `s` of length `n`, we perform a single comparison with the corresponding character in the pattern `p` of length `m`. Therefore, in the worst case, we make `n` comparisons.
- **Recursive Call**: Each recursive call processes the next character in the string and pattern, leading to a maximum depth of `n` recursive calls.

### **Space Complexity**: `O(n)`
- **Call Stack**: The recursive calls add to the call stack, leading to a maximum depth of `n` recursive calls in the worst case, requiring `O(n)` space for the call stack.

#### With the `*` Wildcard:

### **Time Complexity**: `O(2^(n+m))`
- **Branching Factor**: When the pattern contains the `*` wildcard, each `*` can either be used to match zero characters or one or more characters. This introduces a branching factor in the recursion, leading to an exponential number of potential matches to check. In the worst case, we might need to consider all combinations of `s` and `p`, leading to a time complexity of `O(2^(n+m))`.

### **Space Complexity**: `O(n+m)`
- **Call Stack**: Similar to the without `*` case, each recursive call adds to the call stack. However, the presence of the `*` wildcard can potentially increase the depth of the recursion to a maximum of `n+m` recursive calls, leading to `O(n+m)` space for the call stack.

### Summary

| Approach       | Time Complexity | Space Complexity |
|----------------|-----------------|------------------|
| Without `*`    | `O(n)`          | `O(n)`           |
| With `*`       | `O(2^(n+m))`    | `O(n+m)`         |

The presence of the `*` wildcard significantly increases the complexity of the problem due to the branching factor introduced by the multiple ways `*` can be applied. The recursive calls add to the call stack, leading to space complexity proportional to the depth of the recursion.

# Top-Down (Memoization) Dynamic Programming Approach

The top-down memoization approach optimizes the recursive approach by using a memoization table to cache intermediate results. This prevents redundant calculations, thereby improving the efficiency of the solution. By storing previously computed results, we avoid recalculating the same subproblems, which significantly reduces the time complexity.

## **Intuition**

The problem exhibits an **optimal substructure**, which makes it suitable for dynamic programming. The key question here is: For `dp(i, j)`, does `text[i:]` match `pattern[j:]`?

We can describe the answer in terms of smaller subproblems. Instead of making expensive recursive calls to check each substring, we use a memoization table `dp(i, j)` to store intermediate results. This allows us to avoid redundant computations and speeds up the process.

By using dynamic programming, we can efficiently determine if `text[i:]` matches `pattern[j:]` by breaking the problem down into smaller, manageable subproblems.

## **Algorithm**

1. **Define a Memoization Table**: Create a memoization table `dp` to store results of subproblems.
2. **Use Recursion**: Define a recursive function `dp(i, j)` to check if `text[i:]` matches `pattern[j:]`.
3. **Check Memoization Table**: If the result for `dp(i, j)` is already in the memoization table, return it.
4. **First Character Match**: Check if the first character of `text[i:]` matches the first character of `pattern[j:]`.
5. **Handle `*` Wildcard**:
   - If the next character in the pattern is `*`, consider two cases: ignoring the `*` or using the `*` to match multiple characters.
6. **Store and Return Result**: Store the result in the memoization table `dp(i, j)` and return it.

#### Steps

1. Define a memoization table `dp` to store results of subproblems.
2. Use recursion to check if `text[i:]` matches `pattern[j:]`.
3. If the result is already in `dp`, return it.
4. Check if the first character of `text[i:]` matches the first character of `pattern[j:]`.
5. Handle the `*` wildcard by either skipping it or using it to match multiple characters.
6. Store and return the result in `dp`.

### **Pseudocode**
```pseudo
function isMatch(text, pattern):
    memo = {}

    function dp(i, j):
        if (i, j) in memo:
            return memo[(i, j)]
        if j == len(pattern):
            return i == len(text)
        
        firstMatch = (i < len(text) and (pattern[j] == text[i] or pattern[j] == '.'))
        
        if j + 1 < len(pattern) and pattern[j + 1] == '*':
            memo[(i, j)] = (dp(i, j + 2) or (firstMatch and dp(i + 1, j)))
            return memo[(i, j)]
        else:
            memo[(i, j)] = firstMatch and dp(i + 1, j + 1)
            return memo[(i, j)]

    return dp(0, 0)
```

This top-down approach uses recursion and memoization to efficiently solve the regular expression matching problem. By storing intermediate results, we avoid redundant computations and ensure that each subproblem is solved only once.

## **Implementation**

#### Implementation Details

1. **Define a Memoization Table**: A `HashMap<String, Boolean>` named `memo` is used to store the results of subproblems. The key is a string representation of the indices `i` and `j`.
2. **Use Recursion**: The `dp` method is defined to check if `text[i:]` matches `pattern[j:]`. It calls itself recursively.
3. **Check Memoization Table**: If the result for `dp(i, j)` is already in the memoization table, return it.
4. **First Character Match**: Check if the first character of `text[i:]` matches the first character of `pattern[j:]`.
5. **Handle `*` Wildcard**:
   - If the next character in the pattern is `*`, consider two cases: ignoring the `*` or using the `*` to match multiple characters.
6. **Store and Return Result**: Store the result in the memoization table and return it.

### Java

```java
import java.util.HashMap;
import java.util.Map;

public class Solution {
  // Memoization table to store results of subproblems
  private final Map<String, Boolean> memo = new HashMap<>();

  // Main method to initiate the matching process
  public boolean isMatch(String text, String pattern) {
    return dp(0, 0, text, pattern);
  }

  // Recursive function to check if text[i:] matches pattern[j:]
  private boolean dp(int i, int j, String text, String pattern) {
    // Create a unique key for the current state
    String key = i + "," + j;

    // Check if the result for this state is already in the memoization table
    if (memo.containsKey(key)) {
      return memo.get(key);
    }

    // Base case: if pattern is exhausted, check if text is also exhausted
    if (j == pattern.length()) {
      return i == text.length();
    }

    // Check if the first character matches
    boolean firstMatch = (i < text.length() && (pattern.charAt(j) == text.charAt(i) || pattern.charAt(j) == '.'));

    boolean result;
    // Handle the '*' wildcard
    if (j + 1 < pattern.length() && pattern.charAt(j + 1) == '*') {
      // Consider two cases: ignoring '*' or using '*' to match one or more characters
      result = (dp(i, j + 2, text, pattern) || (firstMatch && dp(i + 1, j, text, pattern)));
    } else {
      // No '*', proceed to the next characters
      result = firstMatch && dp(i + 1, j + 1, text, pattern);
    }

    // Store the result in the memoization table
    memo.put(key, result);
    return result;
  }
}
```

### TypeScript

```typescript
function isMatch(s: string, p: string): boolean {
  // Memoization table to store results of subproblems
  const memo: { [key: string]: boolean } = {};

  // Recursive function to check if text[i:] matches pattern[j:]
  function dp(i: number, j: number): boolean {
    // Create a unique key for the current state
    const key = `${i},${j}`;

    // Check if the result for this state is already in the memoization table
    if (key in memo) {
      return memo[key];
    }

    // Base case: if pattern is exhausted, check if text is also exhausted
    if (j === p.length) {
      return i === s.length;
    }

    // Check if the first character matches
    const firstMatch = i < s.length && (p[j] === s[i] || p[j] === ".");

    let result: boolean;
    // Handle the '*' wildcard
    if (j + 1 < p.length && p[j + 1] === "*") {
      // Consider two cases: ignoring '*' or using '*' to match one or more characters
      result = dp(i, j + 2) || (firstMatch && dp(i + 1, j));
    } else {
      // No '*', proceed to the next characters
      result = firstMatch && dp(i + 1, j + 1);
    }

    // Store the result in the memoization table
    memo[key] = result;
    return result;
  }

  // Start the recursion from the beginning of the text and pattern
  return dp(0, 0);
}
```

#### Explanation:

1. **Define a Memoization Table**: A memoization table `memo` is created using an object to store results of subproblems. The key is a string representation of the indices `i` and `j`.
2. **Use Recursion**: The recursive function `dp(i, j)` checks if `text[i:]` matches `pattern[j:]`. It calls itself recursively.
3. **Check Memoization Table**: If the result for `dp(i, j)` is already in the memoization table, return it.
4. **First Character Match**: Check if the first character of `text[i:]` matches the first character of `pattern[j:]`.
5. **Handle `*` Wildcard**:
   - If the next character in the pattern is `*`, consider two cases: ignoring the `*` or using the `*` to match multiple characters.
6. **Store and Return Result**: Store the result in the memoization table `memo[key]` and return it.

## **Complexity Analysis**

### Assumptions

1. Let `n` be the length of the input string `s`.
2. Let `m` be the length of the pattern `p`.

### **Time Complexity**: `O(n * m)`
- **Problem Breakdown**: The top-down memoization approach solves the problem by breaking it into subproblems and storing intermediate results.
- **Subproblem Identification**: Each subproblem is identified by a pair of indices `(i, j)`, where `i` is the position in `text` and `j` is the position in `pattern`.
- **Number of Positions**: There are `n` possible positions in the text and `m` possible positions in the pattern.
- **Unique Subproblems**: Therefore, the number of unique subproblems is `n * m`.
- **Constant Time Solution**: Each subproblem is solved in constant time `O(1)` due to memoization.
- **Overall Complexity**: Hence, the overall time complexity is `O(n * m)`.

### **Space Complexity**: `O(n * m)`
- **Memoization Table Size**: The memoization table (implemented as a map or 2D array) stores the results of subproblems.
- **Entries in Table**: The table needs to store the result for each pair `(i, j)`, leading to `n * m` entries.
- **Space per Entry**: Each entry in the table is `O(1)`, so the total space required for memoization is `O(n * m)`.
- **Recursion Stack Depth**: Additionally, the recursion stack depth is `O(n + m)` due to the nature of the recursive calls.
- **Dominating Factor**: However, the space complexity is dominated by the memoization table, resulting in an overall space complexity of `O(n * m)`.

# Bottom-Up (Tabulation) Dynamic Programming Approach

The bottom-up tabulation approach optimizes the problem-solving process by using a 2D table to iteratively fill in the solutions to subproblems. Instead of relying on recursion, this approach starts from the simplest subproblems (base cases) and builds up to the solution of the original problem through an iterative process. This method ensures that all subproblems are solved in a systematic and efficient manner, leveraging the stored results of previously computed subproblems to construct the final solution.

## **Intuition**

The problem exhibits an optimal substructure, which makes it suitable for dynamic programming. The key question here is: For `dp(i, j)`, does `text[i:]` match `pattern[j:]`?

We can describe the answer in terms of smaller subproblems. Instead of making expensive recursive calls to check each substring, we use a dynamic programming table `dp(i, j)` to store intermediate results. This allows us to avoid redundant computations and speeds up the process.

By using dynamic programming, we can efficiently determine if `text[i:]` matches `pattern[j:]` by breaking the problem down into smaller, manageable subproblems.

## **Algorithm**

1. **Define the Table**: Create a 2D table `dp` where `dp[i][j]` represents if `text[i:]` matches `pattern[j:]`.
2. **Initialize Base Cases**: Set the base case `dp[len(text)][len(pattern)] = True` since an empty pattern matches an empty text.
3. **Fill the Table**: Iterate backward through the text and the pattern, filling in the table based on the matching rules:
   - If the current characters match, or the pattern has a `.`, the result depends on the subsequent characters.
   - If the next character in the pattern is `*`, consider two cases: ignoring the `*` or using the `*` to match one or more characters.
4. **Return Result**: The final answer will be in `dp[0][0]`, indicating whether the entire text matches the entire pattern.

#### Steps

1. Define a 2D table `dp` where `dp[i][j]` represents if `text[i:]` matches `pattern[j:]`.
2. Initialize the base cases.
3. Fill the table iteratively using the rules of regular expression matching.
4. The final answer will be in `dp[0][0]`.

### **Pseudocode**

```pseudo
function isMatch(text, pattern):
    dp = [[False for _ in range(len(pattern) + 1)] for _ in range(len(text) + 1)]
    dp[len(text)][len(pattern)] = True
    
    for i in range(len(text), -1, -1):
        for j in range(len(pattern) - 1, -1, -1):
            firstMatch = (i < len(text) and (pattern[j] == text[i] or pattern[j] == '.'))
            
            if j + 1 < len(pattern) and pattern[j + 1] == '*':
                dp[i][j] = dp[i][j + 2] or (firstMatch and dp[i + 1][j])
            else:
                dp[i][j] = firstMatch and dp[i + 1][j + 1]

    return dp[0][0]
```

## **Implementation**

##### Iterative Approach:
- The algorithm uses nested loops to iterate over the `text` and `pattern` strings from end to beginning. This iteration is done explicitly with `for` loops, rather than using recursion.
- Each iteration updates the `dp` table based on the current indices `i` and `j`.

##### Bottom-Up Tabulation:
- **Tabulation**: The `dp` table is a two-dimensional array that stores boolean values representing whether substrings of `text` and `pattern` match. This table is filled iteratively.
- **Bottom-Up**: The table is filled starting from the "base case" at `dp[n][m]` (where both the `text` and `pattern` are empty) and working backwards to the beginning of the strings. This ensures that by the time the algorithm needs the value of `dp[i+1][j]` or `dp[i][j+2]`, it has already been computed.

By employing these strategies, the algorithm avoids the overhead of recursion and provides an efficient way to solve the problem with dynamic programming.

#### Implementation Details

1. **Define the Table**: Create a 2D table `dp` where `dp[i][j]` represents if `text[i:]` matches `pattern[j:]`.
2. **Initialize Base Cases**: Set the base case `dp[n][m] = true` since an empty pattern matches an empty text.
3. **Fill the Table**: Iterate backward through the text and the pattern, filling in the table based on the matching rules:
   - **First Match**: Determine if the current characters in `text` and `pattern` match or if the pattern has a `.`.
   - **Handling `*`**: If the next character in the pattern is `*`, consider two cases: ignoring the `*` (i.e., `dp[i][j + 2]`) or using the `*` to match one or more characters (i.e., `firstMatch && dp[i + 1][j]`).
4. **Return Result**: The final answer will be in `dp[0][0]`, indicating whether the entire text matches the entire pattern.

### Java

```java
public class Solution {
  public boolean isMatch(String text, String pattern) {
    int n = text.length();
    int m = pattern.length();

    // Define the Table
    boolean[][] dp = new boolean[n + 1][m + 1];

    // Initialize Base Cases
    dp[n][m] = true; // An empty pattern matches an empty text

    // Fill the Table
    for (int i = n; i >= 0; i--) {
      for (int j = m - 1; j >= 0; j--) {
        boolean firstMatch =
            (i < n && (pattern.charAt(j) == text.charAt(i) || pattern.charAt(j) == '.'));

        if (j + 1 < m && pattern.charAt(j + 1) == '*') {
          dp[i][j] = dp[i][j + 2] || (firstMatch && dp[i + 1][j]);
        } else {
          dp[i][j] = firstMatch && dp[i + 1][j + 1];
        }
      }
    }

    // Return Result
    return dp[0][0];
  }
}
```

### TypeScript

```typescript
function isMatch(s: string, p: string): boolean {
  const n = s.length;
  const m = p.length;

  // Define the Table
  const dp: boolean[][] = Array.from({ length: n + 1 }, () =>
    Array(m + 1).fill(false)
  );

  // Initialize Base Cases
  dp[n][m] = true; // An empty pattern matches an empty text

  // Fill the Table
  for (let i = n; i >= 0; i--) {
    for (let j = m - 1; j >= 0; j--) {
      const firstMatch = i < n && (p[j] === s[i] || p[j] === ".");

      if (j + 1 < m && p[j + 1] === "*") {
        dp[i][j] = dp[i][j + 2] || (firstMatch && dp[i + 1][j]);
      } else {
        dp[i][j] = firstMatch && dp[i + 1][j + 1];
      }
    }
  }

  // Return Result
  return dp[0][0];
}
```

#### Explanation:

1. **Define the Table**: Create a 2D table `dp` where `dp[i][j]` represents if `text[i:]` matches `pattern[j:]`.
2. **Initialize Base Cases**: Set the base case `dp[n][m] = true` since an empty pattern matches an empty text.
3. **Fill the Table**: Iterate backward through the text and the pattern, filling in the table based on the matching rules:
   - **First Match**: Determine if the current characters in `text` and `pattern` match or if the pattern has a `.`.
   - **Handling `*`**: If the next character in the pattern is `*`, consider two cases: ignoring the `*` (i.e., `dp[i][j + 2]`) or using the `*` to match one or more characters (i.e., `firstMatch && dp[i + 1][j]`).
4. **Return Result**: The final answer will be in `dp[0][0]`, indicating whether the entire text matches the entire pattern.
