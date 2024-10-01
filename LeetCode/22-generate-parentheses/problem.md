# 22. Generate Parentheses

<p>Given <code>n</code> pairs of parentheses, write a function to <em>generate all combinations of well-formed parentheses</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<pre><strong>Input:</strong> n = 3
<strong>Output:</strong> ["((()))","(()())","(())()","()(())","()()()"]
</pre><p><strong class="example">Example 2:</strong></p>
<pre><strong>Input:</strong> n = 1
<strong>Output:</strong> ["()"]
</pre>
<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= n &lt;= 8</code></li>
</ul>

<br>

---

# Solution

  - [Backtracking Approach](#backtracking-approach)

# Backtracking Approach

Backtracking is a powerful algorithmic technique used to solve problems that involve searching through all possible configurations to find a solution.

Backtracking algorithms can often keep the space complexity linear with the input size.

### What is Backtracking?

Backtracking is a method for finding solutions to problems incrementally, one piece at a time, and removing those solutions that fail to satisfy the constraints of the problem at any point in time. It's often used for problems involving permutations, combinations, and other forms of exhaustive search.

### How Does Backtracking Work?

1. **Choose**: Select a starting point or an initial decision.
2. **Explore**: Move forward by making a choice and recursively explore further decisions.
3. **Check**: If the current path leads to a solution, record it. If not, backtrack by undoing the last choice and try another path.

## **Intuition**

### Naive Approach

The naive approach involves generating all possible strings of length `2n` and checking each one for validity. This method is simple but highly inefficient because it produces many invalid strings that need to be checked.

### Optimized Approach: Backtracking

A more efficient approach is to use backtracking to generate only valid strings. This method involves recursively building strings of length `2n` and ensuring their validity as we go. If a string becomes invalid at any point, we stop the recursive process on that path and backtrack to the previous valid state. This way, we focus only on generating valid strings, saving time and computational resources.

### Building the Backtracking Algorithm

As shown in the picture below: `)` is an invalid string, so every string prefixed with it is also invalid, and we can just drop it.

![Generate all possible parentheses strings with a length of 2n](img/22-1.png)

### Backtracking Function

To ensure that the current string is always valid during the backtracking process, we need two variables: `open_count` and `close_count`. These variables record the number of open and close parentheses in the current string, respectively.

We define our backtracking function as `backtracking(curr_string, open_count, close_count)`. This function takes the current string, the number of open parentheses, and the number of close parentheses as arguments. It builds valid combinations of parentheses of length `2n` recursively.

### Conditions for Adding Parentheses

The function adds more parentheses to `curr_string` only when certain conditions are met:

1. **Adding an Open Parenthesis**:
   - **Condition**: If `open_count < n`
   - **Action**: Add an open parenthesis to `curr_string`, creating a new string `new_string = curr_string + "("`, and then call `backtracking(new_string, open_count + 1, close_count)`.

2. **Adding a Close Parenthesis**:
   - **Condition**: If `open_count > close_count`
   - **Action**: Add a close parenthesis to `curr_string`, creating a new string `new_string = curr_string + ")"`, and then call `backtracking(new_string, open_count, close_count + 1)`.

### Ensuring Validity

This function ensures that the generated string of length `2n` is valid and adds it directly to the answer. By only generating valid strings, we can avoid wasting time checking invalid strings.

### Key Points

1. **Recursive Building**: We build the string recursively, adding one parenthesis at a time.
2. **Validity Check**: At each step, we check if the current string is valid.
3. **Backtracking**: If the string is invalid, we backtrack to the previous state and try a different path.
4. **Termination**: The recursion continues until we generate strings of length `2n`.

### Detailed Steps

1. **Base Case**: If the current string has `n` opening and `n` closing parentheses, it is valid and added to the result list.
2. **Add Opening Parenthesis**: If the number of opening parentheses is less than `n`, add an opening parenthesis and recurse.
3. **Add Closing Parenthesis**: If the number of closing parentheses is less than the number of opening parentheses, add a closing parenthesis and recurse.

## **Algorithm**

1. Initialize an empty list `result`

2. Define `backtrack(curr_string, open_count, close_count)` to generate valid strings recursively.

  -  If `len(curr_string) = 2n` , add it to `result` and return.

  - If `open_count < n` , add `(` to `curr_string` and move on to `backtrack(new_string, open_count + 1, close_count)`

  - If `open_count > close_count` , add `)` to curr_string and move on to `backtrack(new_string, open_count, close_count + 1)` .

3. Call `backtrack` on empty string ( `backtrack("", 0, 0)` ) and return `result` once the backtracking process is complete.

### Detailed Steps

1. **Initialize Result List**:
   - Create an empty list `result` to store the valid combinations of parentheses.

2. **Define Backtracking Function**:
   - Define a function `backtrack(result, current, open, close, max)` to generate valid strings recursively.

3. **Base Case**:
   - If the length of `current` is equal to `2 * max`, add `current` to `result` and return.

4. **Add Open Parenthesis**:
   - If `open < max`, add an open parenthesis `(` to `current` and call `backtrack` with updated counts: `backtrack(result, current + "(", open + 1, close, max)`.

5. **Add Close Parenthesis**:
   - If `close < open`, add a close parenthesis `)` to `current` and call `backtrack` with updated counts: `backtrack(result, current + ")", open, close + 1, max)`.

6. **Start Backtracking**:
   - Call `backtrack` with an empty string and initial counts: `backtrack(result, "", 0, 0, n)`.

7. **Return Result**:
   - Return the `result` list containing all valid combinations of parentheses.
