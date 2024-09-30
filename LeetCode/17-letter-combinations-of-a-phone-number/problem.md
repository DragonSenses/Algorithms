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

## Interview Tips

### Understand the Constraints

One of the first things you should always do is look at the constraints. Quite often, you can figure out what sort of approach needs to be taken simply from looking at the input size. In an interview, asking your interviewer about the constraints will also show your attention to detail, on top of giving you valuable information.

### Example Problem

In this particular problem, the length of the input is **extremely** small: `0 <= digits.length <= 4`. With such small input sizes, we can safely assume that a brute force solution, in which we generate all combinations of letters, will be accepted.

Whenever you have a problem where you need to generate all combinations or permutations of some group of letters or numbers, the first thought you should have is backtracking. 

Backtracking is a powerful algorithmic technique used to solve problems that involve searching through all possible configurations to find a solution.

Backtracking algorithms can often keep the space complexity linear with the input size.

