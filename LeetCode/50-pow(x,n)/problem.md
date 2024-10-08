# 50. Pow(x, n)

<p>Implement <a href="http://www.cplusplus.com/reference/valarray/pow/" target="_blank">pow(x, n)</a>, which calculates <code>x</code> raised to the power <code>n</code> (i.e., <code>x<sup>n</sup></code>).</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> x = 2.00000, n = 10
<strong>Output:</strong> 1024.00000
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> x = 2.10000, n = 3
<strong>Output:</strong> 9.26100
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> x = 2.00000, n = -2
<strong>Output:</strong> 0.25000
<strong>Explanation:</strong> 2<sup>-2</sup> = 1/2<sup>2</sup> = 1/4 = 0.25
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>-100.0 &lt; x &lt; 100.0</code></li>
	<li><code>-2<sup>31</sup> &lt;= n &lt;= 2<sup>31</sup>-1</code></li>
	<li><code>n</code> is an integer.</li>
	<li>Either <code>x</code> is not zero or <code>n &gt; 0</code>.</li>
	<li><code>-10<sup>4</sup> &lt;= x<sup>n</sup> &lt;= 10<sup>4</sup></code></li>
</ul>

<br>

---

# Solution

# Recursive Binary Exponentiation

## **Intuition**

We know `x^n` means we multiply a with itself n-times. The most naïve way to solve this problem is to simply multiply a
`n`-times. This method of multiplying will lead to a linear time complexity and is not efficient, but we will discuss a bit
about it as it will be a stepping stone to our optimized approach.

### Brute-force approach

The current problem can be broken into smaller similar subproblems, `x^n = x * x^n-1`. Thus, this gives us our recurrence
relation.

We can write a recursive function here that calculates the result of the smaller similar sub-problem and using that
calculates the result for the current problem, `pow(x, n) = x * pow(x, n - 1)` . And we know if `n = 0` then `x^n` will always
be `1`, this will be our base case to stop the recursive calls.

Also, we need to handle the case if `n` is negative. In that case, the answer will be the reciprocal of the result if `n` were positive: \[ x^n = \frac{1}{x^{-n}}, \text{ where } n < 0 \]

Now that we have an idea of all cases, lets create the pseudocode:

### Pseudo Code for Recursive Function

```Pseudo
func pow(x, n):
  if n == 0: return 1
  if n < 0; return 1 / pow(x, -n)
  return x * pow(x, n-1)
```

### Optimized Approach

Binary exponentiation, also known as exponentiation by squaring, is a technique for efficiently computing the power of a number. By repeatedly squaring `x` and halving `n`, we can quickly compute `x^n` using a logarithmic number of multiplications.

The basic idea here is to use the fact that `x^n` can be expressed as:

 - `(x^2)^(n/2)` if `n` is **even**
 - `x*(x^2)^((n/2)/2)` if `n` is **odd** (we separate out one `x`, then `n-1` will become even)

This method might not seem intuitive, so let's try to understand it with the help of some examples.

