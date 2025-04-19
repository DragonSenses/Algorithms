# 60. Permutation Sequence

<p>The set <code>[1, 2, 3, ...,&nbsp;n]</code> contains a total of <code>n!</code> unique permutations.</p>

<p>By listing and labeling all of the permutations in order, we get the following sequence for <code>n = 3</code>:</p>

<ol>
	<li><code>"123"</code></li>
	<li><code>"132"</code></li>
	<li><code>"213"</code></li>
	<li><code>"231"</code></li>
	<li><code>"312"</code></li>
	<li><code>"321"</code></li>
</ol>

<p>Given <code>n</code> and <code>k</code>, return the <code>k<sup>th</sup></code> permutation sequence.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<pre><strong>Input:</strong> n = 3, k = 3
<strong>Output:</strong> "213"
</pre><p><strong class="example">Example 2:</strong></p>
<pre><strong>Input:</strong> n = 4, k = 9
<strong>Output:</strong> "2314"
</pre><p><strong class="example">Example 3:</strong></p>
<pre><strong>Input:</strong> n = 3, k = 1
<strong>Output:</strong> "123"
</pre>
<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= n &lt;= 9</code></li>
	<li><code>1 &lt;= k &lt;= n!</code></li>
</ul>

---

### Problem Overview: Permutation Sequence

**Objective:**  
You are tasked with determining the `k`th lexicographically ordered permutation of the sequence `{1, 2, ..., n}` without generating all permutations explicitly.

#### **Key Details:**
1. **Input:**  
   Two integers, `n` and `k`.  
   - `n = 3, k = 3` (Example 1)  
   - `n = 4, k = 9` (Example 2)  

2. **Output:**  
   A string representing the `k`th permutation of `{1, 2, ..., n}` in lexicographical order.  
   - Example 1 Output: `"213"`  
   - Example 2 Output: `"2314"`  

3. **Constraints:**  
   - `1 ≤ n ≤ 9`  
   - `1 ≤ k ≤ n!`  

#### **Examples:**
- **Example 1:**
  ```  
  Input: n = 3, k = 3  
  Output: "213"  
  ```  
  The third permutation of `{1, 2, 3}` in lexicographical order is `"213"`.

- **Example 2:**
  ```  
  Input: n = 4, k = 9  
  Output: "2314"  
  ```  
  The ninth permutation of `{1, 2, 3, 4}` in lexicographical order is `"2314"`.

---

By listing and labeling all of the permutations in order, we get the following sequence for n = 3:

    "123"
    "132"
    "213"
    "231"
    "312"
    "321"

Given n and k, return the kth permutation sequence.

Example 1:

Input: n = 3, k = 3
Output: "213"

Example 2:

Input: n = 4, k = 9
Output: "2314"

Example 3:

Input: n = 3, k = 1
Output: "123"

Usually standard decimal or binary positional system could meet our needs.
For example, each subset could be described a number in binary representation.

Formula: 
k = N-1 E m=0 km2^m, 0 <= km <= 1
Example: 

The problem with permutations is that there is much more permutations than subsets N! grows up much faster than 2^N. Therefore, the solution space provided by the positional system with constant base cannot match with the number of permutations.

[1 2 3]   [0 0 0]   [     ]     [1 2 3]   [0 0 1]   [    3]  
[1 2 3]   [0 1 0]   [  2  ]     [1 2 3]   [0 1 1]   [  2 3]  
[1 2 3]   [1 0 0]   [1    ]     [1 2 3]   [1 0 1]   [1  3 ]  
[1 2 3]   [1 1 0]   [1 2  ]     [1 2 3]   [1 1 1]   [1 2 3]  


Here is where the factorial number system enters the scene.

The factorial number system's positional system with non-constant base `m!`.

k = N-1 E m=0 kmm!, 0 <= km <= m

Note that the magnitude of weights is not constant as well and depends on base: 

0 ≤ km ≤ m for the base m!, i.e. ko = 0, 0 ≤ k1 ≤ 1,
0 < k2 ≤2, etc.

Permutation | Permutation number | Factorial Number System Representation
123 | 0 = 0 x 2! + 0 x !! + 0 x 0! | 0 0 0
132 | 1 =
213 | 
231 |
312
321


### Constructing the Permutation from its Factorial Representation

Now that we can **encode permutations** using factorial representation, the next step is to **use this encoded representation to construct the actual permutation** efficiently.

Let us pick up N = 3, which corresponds to the input array nums = [1, 2, 3] , and
construct its permutation number k = 3.
Since we number the permutations from 0 to N! - 1
(and not from 1 to N! as in the problem description), for us that
will be the permutation number k = 2.

Let us first construct the factorial representation of k = 2:

k=2= 1 × 2! + 0 x 1! + 0 x 0! = (1,0,0)

The coefficients in factorial representation
are indexes of elements in the input array.
These are not direct indexes, but the indexes after the removal of already used elements.
That's a consequence of the fact that each element
should be used in permutation only once.

| Permutation | Permutation Number | Factorial Number System Representation |
|------------|--------------------|----------------------------------------|
| **1**23        | 0 = (**0** × 2!) + (0 × 1!) + (0 × 0!) | [**0** 0 0] |
| **1**32        | 1 = (**0** × 2!) + (1 × 1!) + (0 × 0!) | [**0** 1 0] |
| **2**13        | 2 = (**1** × 2!) + (0 × 1!) + (0 × 0!) | [**1** 0 0] |
| **2**31        | 3 = (**1** × 2!) + (1 × 1!) + (0 × 0!) | [**1** 1 0] |
| **3**12        | 4 = (**2** × 2!) + (0 × 1!) + (0 × 0!) | [**2** 0 0] |
| **3**21        | 5 = (**2** × 2!) + (1 × 1!) + (0 × 0!) | [**2** 1 0] |

Here the first number is 1 , i.e. the first element in the permutation
İS nums [1] = 2 . Let us use nums [1] = 2 in the permutation and then delete it
from nums , since each element should be used only once.

| nums | Permutation Number | Factorial Number System Representation |
|------------|--------------------|----------------------------------------|
| 1**2**3        | 2 = (**1** × 2!) + (0 × 1!) + (0 × 0!) | [**1** 0 0] |

1. Pick Up element at index 1: nums[1] = 2, use it in permutation and delete it from the list

[`2` _ _]

| nums | Permutation Number | Factorial Number System Representation |
|------------|--------------------|----------------------------------------|
| 1 3        | 2 = (1 × 2!) + (**0** × 1!) + (0 × 0!) | [1 **0** 0] |

Next coefficient in factorial representation is `0`.

Let's use `nums[0] = 1` in the permutation and then delete it from `nums`.

| nums | Permutation Number | Factorial Number System Representation |
|------------|--------------------|----------------------------------------|
| 1 3        | 2 = (1 × 2!) + (**0** × 1!) + (0 × 0!) | [1 **0** 0] |

1. Pick Up element at index 0: nums[0] = 1, use it in permutation and delete it from the list

[2 `1` _]

| nums | Permutation Number | Factorial Number System Representation |
|------------|--------------------|----------------------------------------|
| 3        | 2 = (1 × 2!) + (0 × 1!) + (**0** × 0!) | [1 0 **0**] |

Next coefficient in factorial representation is `0`.

Let's use `nums[0] = 3` in the permutation and then delete it from `nums`.

| nums | Permutation Number | Factorial Number System Representation |
|------------|--------------------|----------------------------------------|
| `3`        | 2 = (1 × 2!) + (0 × 1!) + (**0** × 0!) | [1 0 **0**] |

1. Pick Up element at index 0: nums[0] = 3, use it in permutation and delete it from the list

[2 1 `3`]


| nums | Permutation Number | Factorial Number System Representation |
|------------|--------------------|----------------------------------------|
| 123        | 0 = (0 × 2!) + (0 × 1!) + (0 × 0!) | [0 0 0] |