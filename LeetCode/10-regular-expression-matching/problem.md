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
