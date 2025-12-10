# 278. First Bad Version

<p>You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.</p>

<p>Suppose you have <code>n</code> versions <code>[1, 2, ..., n]</code> and you want to find out the first bad one, which causes all the following ones to be bad.</p>

<p>You are given an API <code>bool isBadVersion(version)</code> which returns whether <code>version</code> is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> n = 5, bad = 4
<strong>Output:</strong> 4
<strong>Explanation:</strong>
call isBadVersion(3) -&gt; false
call isBadVersion(5)&nbsp;-&gt; true
call isBadVersion(4)&nbsp;-&gt; true
Then 4 is the first bad version.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> n = 1, bad = 1
<strong>Output:</strong> 1
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
  <li><code>1 &lt;= bad &lt;= n &lt;= 2<sup>31</sup> - 1</code></li>
</ul>

---

## **Problem Overview: First Bad Version**

You are a product manager leading a team to develop a new product. Unfortunately, one of the versions fails the quality check. Since each version is built upon the previous one, all subsequent versions after a bad version are also bad.

The task is to determine the **first bad version** among `n` versions labeled from `1` to `n`. Identifying this version is crucial because it marks the point where the product starts failing, and all later versions inherit the defect.

You are provided with an API:

```cpp
bool isBadVersion(version)
```

This API returns whether a given version is bad. The challenge is to implement a function that finds the first bad version while **minimizing the number of API calls**.

### **Examples**

**Example 1:**
```
Input: n = 5, bad = 4
Output: 4
Explanation:
isBadVersion(3) -> false
isBadVersion(5) -> true
isBadVersion(4) -> true
Thus, version 4 is the first bad version.
```

**Example 2:**
```
Input: n = 1, bad = 1
Output: 1
```

### **Constraints**
- \(1 \leq \text{bad} \leq n \leq 2^{31} - 1\)

### **Key Insight**
- Since versions are sequential and once a version is bad, all following versions are bad, the problem can be solved efficiently using **binary search**.
- Binary search reduces the number of API calls from \(O(n)\) to \(O(\log n)\), ensuring scalability even for very large values of `n`.
es constant memory usage independent of `n`.  
