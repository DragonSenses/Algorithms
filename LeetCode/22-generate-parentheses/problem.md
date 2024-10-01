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

