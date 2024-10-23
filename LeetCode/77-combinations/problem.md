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

