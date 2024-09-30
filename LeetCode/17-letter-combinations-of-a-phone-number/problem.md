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

