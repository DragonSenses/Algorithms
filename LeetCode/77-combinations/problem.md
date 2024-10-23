# 77. Combinations

<p>Given two integers <code>n</code> and <code>k</code>, return <em>all possible combinations of</em> <code>k</code> <em>numbers chosen from the range</em> <code>[1, n]</code>.</p>

<p>You may return the answer in <strong>any order</strong>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> n = 4, k = 2
<strong>Output:</strong> [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
<strong>Explanation:</strong> There are 4 choose 2 = 6 total combinations.
Note that combinations are unordered, i.e., [1,2] and [2,1] are considered to be the same combination.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> n = 1, k = 1
<strong>Output:</strong> [[1]]
<strong>Explanation:</strong> There is 1 choose 1 = 1 total combination.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= n &lt;= 20</code></li>
	<li><code>1 &lt;= k &lt;= n</code></li>
</ul>

<br>

---

# Solution
- [Backtracking Approach](#backtracking-approach)

## Overview of Combinations

Combinations refer to the selection of items from a larger set where the order of selection does not matter. The formula to calculate the number of combinations is given by the binomial coefficient:
\[ C(k, n) = \frac{n!}{k!(n - k)!} \]
where `n` is the total number of items, and `k` is the number of items to choose. For example, choosing 2 items from a set of 4 (like {1, 2, 3, 4}) results in combinations such as {1, 2}, {1, 3}, {1, 4}, {2, 3}, {2, 4}, and {3, 4}.

## Overview of Backtracking

Backtracking is a problem-solving algorithm that incrementally builds candidates to the solutions and abandons candidates ("backtracks") as soon as it determines that they cannot possibly lead to a valid solution. It’s particularly useful for problems involving permutations, combinations, and other constraint-satisfaction problems.

The process involves:
1. **Building Solutions**: Starting with an empty solution and adding elements one by one.
2. **Exploration**: If the current partial solution is valid, recursively continue to add elements.
3. **Backtrack**: If adding the next element leads to an invalid solution, remove the last added element (backtrack) and try the next possibility.

Backtracking helps in exploring all possible solutions in a systematic way by pruning invalid paths, making it efficient for combinatorial problems.

# Backtracking Approach

## **Intuition**

Backtracking is an algorithm for finding all solutions by exploring all potential candidates. If a candidate turns out to be not a solution (or at least not the final one), the backtracking algorithm discards it by backtracking to the previous step and then trying again.

## **Algorithm**

1. **Backtrack Function**: 
   - Define a backtrack function that takes an integer `first` to start adding numbers from and the current combination `curr` as arguments: `backtrack(first, curr)`.
2. **Check Completion**: 
   - If the current combination `curr` is done (i.e., it has `k` numbers), add it to the output.
3. **Iterate and Add**:
   - Iterate over the integers from `first` to `n`.
   - Add integer `i` to the current combination `curr`.
   - Proceed to add more integers into the combination by recursively calling `backtrack(i + 1, curr)`.
4. **Backtrack**:
   - Remove integer `i` from `curr` to backtrack.

### Pseudocode

```plaintext
function backtrack(first, curr):
    if curr is complete:
        add curr to output
        return

    for i in range(first, n + 1):
        curr.add(i)
        backtrack(i + 1, curr)
        curr.remove(i)
```

### Implementation Details

1. **Define the Backtrack Function**: Define a function that will take the starting number and the current combination as parameters.

2. **Base Case**: Check if the current combination is complete, and if so, add it to the result.

3. **Iterate and Recurse**: Iterate over the possible numbers, add them to the current combination, and recurse with the next number.

4. **Backtrack**: Remove the number from the current combination to backtrack.

### Combine Function

**Combine Function**: The main function combine initializes the result array and starts the backtracking process.

### Backtrack Function

**Backtrack Function**: The inner function backtrack takes the current start number and the current combination array. It checks if the current combination is complete and adds it to the result if so. Otherwise, it iterates over the possible numbers, adds each to the current combination, recurses with the next number, and then backtracks by removing the last number.

