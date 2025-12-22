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

# Solution

- [Binary Search Approach](#binary-search-approach)
  - **Space Complexity**: `O(1)`

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

# Binary Search Approach

## **Intuition**

The problem of finding the first bad version can be solved efficiently using **binary search**. Since versions are sequential and once a version is bad, all subsequent versions are bad, we can halve the search space at each step.


### **Scenario #1: `isBadVersion(mid) => false`**

Versions: 1 2 3 4 5 6 7 8 9
          G G G G G G B B B

- `G = Good`, `B = Bad`
- If `isBadVersion(mid)` returns **false**, it means all versions up to and including `mid` are good.
- Therefore, the first bad version must lie in the interval `[mid + 1, right]`.
- Update boundary:  
  `left = mid + 1`

### **Scenario #2: `isBadVersion(mid) => true`**

```
Versions: 1 2 3 4 5 6 7 8 9
          G G G B B B B B B
```

- `G = Good`, `B = Bad`
- If `isBadVersion(mid)` returns **true**, then `mid` may or may not be the first bad version.
- However, we know for sure that all versions after `mid` are bad.
- Therefore, the first bad version must lie in the interval `[left, mid]`.
- Update boundary:  
  `right = mid`

### **Initialization and Termination**

- Initialize search boundaries:  
  `left = 1`, `right = n`
- Continue halving the search space until `left == right`.  
  At this point, both pointers converge on the **first bad version**.

### **Correctness Check**

- To quickly validate correctness during an interview, test with input size = 2:
  - If the algorithm reduces the search space to a single element in both scenarios, it is correct.
- Formal correctness can be proven by induction.

### **Overflow Consideration**

- Be cautious when calculating `mid = (left + right) / 2`.  
  In languages with integer overflow (e.g., Java, C++), `left + right` may exceed the maximum integer limit.
- Safer formula:  
  `mid = left + (right - left) / 2`

## Algorithm

- **Goal:** Find the first bad version using binary search while minimizing calls to `isBadVersion`.
- **Setup:** Use inclusive boundaries with `left = 1` and `right = n`.
- **Loop condition:** While `left < right`, continue narrowing the search space.
- **Midpoint:** Compute `mid = left + (right - left) / 2` to avoid integer overflow.
- **Case: mid is good (false):**  
  - **Action:** Move left boundary rightward.  
  - **Update:** `left = mid + 1`
- **Case: mid is bad (true):**  
  - **Action:** Keep mid and discard the right half.  
  - **Update:** `right = mid`
- **Termination:** When `left == right`, both pointers converge to the first bad version.
- **Return:** `left` (or `right`, they are equal).

### **Pseudocode**

```text
function firstBadVersion(n):
  left  = 1
  right = n

  while left < right:
    mid = left + (right - left) // 2  // safe midpoint to avoid overflow

    if isBadVersion(mid) == true:
      right = mid                    // first bad is in [left, mid]
    else:
      left = mid + 1                 // first bad is in [mid + 1, right]

  return left
```

## **Implementation**

### VersionControl class and isBadVersion API

This would be a rough outline what it `VersionControl` class and `isBadVersion` API would look like. For compile purposes.

```java
// Base class provided by the system
public class VersionControl {
  // Simulated "bad" version for testing
  private int badVersion;

  public VersionControl() {
    // default value, or leave uninitialized
  }

  // Constructor to set the first bad version
  public VersionControl(int badVersion) {
    this.badVersion = badVersion;
  }

  // API method: returns true if the given version is bad
  public boolean isBadVersion(int version) {
    return version >= badVersion;
  }
}
```

### Java

```java
/*
 * The isBadVersion API is defined in the parent class VersionControl. boolean isBadVersion(int
 * version);
 */

public class Solution extends VersionControl {
  public int firstBadVersion(int n) {
    int left = 1;
    int right = n;

    while (left < right) {
      // Safe midpoint calculation to avoid overflow
      int mid = left + (right - left) / 2;

      if (isBadVersion(mid)) {
        // Mid could be the first bad version, so keep it
        right = mid;
      } else {
        // Mid is good, so the first bad must be after mid
        left = mid + 1;
      }
    }

    // At termination, left == right and points to the first bad version
    return left;
  }
}
```

### TypeScript

```typescript
/**
 * The knows API is defined in the parent class Relation.
 * isBadVersion(version: number): boolean {
 *     ...
 * };
 */

var solution = function (isBadVersion: (version: number) => boolean) {
  return function (n: number): number {
    let left: number = 1;
    let right: number = n;

    while (left < right) {
      // Safe midpoint calculation to avoid overflow
      const mid: number = left + Math.floor((right - left) / 2);

      if (isBadVersion(mid)) {
        // Mid could be the first bad version, so keep it
        right = mid;
      } else {
        // Mid is good, so the first bad must be after mid
        left = mid + 1;
      }
    }

    // At termination, left == right and points to the first bad version
    return left;
  };
};
```

## **Complexity Analysis**

### **Assumptions**
- We are using the provided API `isBadVersion(version)` which runs in constant time `O(1)` per call.  
- The input size `n` can be very large (up to \(2^{31} - 1\)), so efficiency is critical.  
- The algorithm applies binary search to minimize the number of API calls.  


### **Space Complexity**: `O(1)`  
- **Constant-Space Usage**: The algorithm only uses a fixed number of variables (`left`, `right`, `mid`) to track boundaries and pivots, regardless of the input size.  
- **No Additional Structures**: The search is performed directly on the version indices without requiring extra data structures such as arrays or hash maps.  
- **Memory Efficiency**: Ensures constant memory usage independent of `n`.  
