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

Dynamic programming is a technique used to solve complex problems by breaking them down into simpler subproblems. It stores the results of subproblems to avoid redundant computations, making the overall solution more efficient. DP is particularly effective for optimization problems and problems with overlapping subproblems and optimal substructure.

Top-down memoization is a technique in dynamic programming where the problem is solved recursively, but intermediate results are stored (memoized) to avoid redundant calculations. This approach is also known as "memoization." It combines the benefits of recursion and dynamic programming.

Bottom-up tabulation is another dynamic programming technique where the problem is solved iteratively, starting from the base cases and building up to the final solution. This approach uses a table to store the results of subproblems.

### Relationship Between Recursion, DP, Memoization, and Tabulation
1. **Recursion**: A fundamental technique where a function calls itself to solve smaller instances of the problem.
2. **Dynamic Programming**: An optimization technique to solve problems by breaking them into subproblems, storing results to avoid redundant calculations.
3. **Top-Down Memoization**: Combines recursion and dynamic programming by solving subproblems recursively and storing intermediate results to avoid redundant computations.
4. **Bottom-Up Tabulation**: Solves the problem iteratively by starting from the base cases and building up to the final solution using a table to store results.

Top-down memoization and bottom-up tabulation are both dynamic programming techniques that aim to optimize the solution by storing intermediate results, but they differ in their approach. Memoization leverages recursion, while tabulation uses an iterative approach.

By understanding these concepts, you can choose the most appropriate technique based on the problem's characteristics and constraints.

