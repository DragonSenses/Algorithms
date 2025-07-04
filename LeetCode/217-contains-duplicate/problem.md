# 217. Contains Duplicate

<p>Given an integer array <code>nums</code>, return <code>true</code> if any value appears <strong>at least twice</strong> in the array, and return <code>false</code> if every element is distinct.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [1,2,3,1]</span></p>

<p><strong>Output:</strong> <span class="example-io">true</span></p>

<p><strong>Explanation:</strong></p>

<p>The element 1 occurs at the indices 0 and 3.</p>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [1,2,3,4]</span></p>

<p><strong>Output:</strong> <span class="example-io">false</span></p>

<p><strong>Explanation:</strong></p>

<p>All elements are distinct.</p>
</div>

<p><strong class="example">Example 3:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [1,1,1,3,3,4,3,2,4,2]</span></p>

<p><strong>Output:</strong> <span class="example-io">true</span></p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
  <li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
  <li><code>-10<sup>9</sup> &lt;= nums[i] &lt;= 10<sup>9</sup></code></li>
</ul>

---

# Solution

- [Hash Table Approach](#hash-table-approach)
  - **Time Complexity**: `O(n)`
  - **Space Complexity**: `O(n)`
- [Sorting and Linear Scan Approach](#sorting-and-linear-scan-approach)

---

## **Problem Overview: Contains Duplicate**

## Description

Given an integer array `nums`, return `true` if **any value appears at least twice** in the array. Return `false` if every element is **distinct**.

## Examples

### Example 1
**Input:**  
`nums = [1, 2, 3, 1]`  
**Output:**  
`true`  
**Explanation:**  
The element `1` appears more than once (indices 0 and 3).

### Example 2  
**Input:**  
`nums = [1, 2, 3, 4]`  
**Output:**  
`false`  
**Explanation:**  
All elements are distinct.

### Example 3  
**Input:**  
`nums = [1, 1, 1, 3, 3, 4, 3, 2, 4, 2]`  
**Output:**  
`true`  
**Explanation:**  
Several elements (like `1`, `3`, `4`, and `2`) appear more than once.

## Constraints

- `1 <= nums.length <= 10⁵`
- `-10⁹ <= nums[i] <= 10⁹`

# Hash Table Approach

Given an array of integers, we need to determine if any element appears more than once. If any value repeats, we return `true`; otherwise, we return `false`.

## Intuition

Searching for duplicates in an unsorted array with brute force would typically require comparing each element with every other element—an O(n²) operation. Instead, we can greatly reduce time complexity by utilizing a **hash table** (or a set), which allows:

- **Constant-time average lookup (O(1))**
- **Constant-time average insert (O(1))**

This makes hash tables particularly suitable for problems that involve fast membership checks.

As we iterate over the array:
- If the current element is **already present** in the hash table, we have found a duplicate → return `true`
- Otherwise, we **store** the element in the hash table and continue

This technique ensures we only traverse the list once while performing constant-time operations, achieving **linear time complexity O(n)** with **space complexity O(n)** in the worst case.

## Algorithm

1. Initialize an empty set to store seen elements.
2. Traverse the input array.
3. For each number:
   - If it's already in the set, return `true`.
   - Otherwise, add it to the set.
4. If the loop completes without finding duplicates, return `false`.

### **Pseudocode**

```plaintext
function containsDuplicate(nums):
    seen = empty set

    for num in nums:
        if num in seen:
            return true
        seen.add(num)

    return false
```

## **Implementation**

### Java

```java
import java.util.HashSet;
import java.util.Set;

class Solution {
  public boolean containsDuplicate(int[] nums) {
    Set<Integer> set = new HashSet<>(nums.length);

    for (int x : nums) {
      if (set.contains(x)) {
        return true;
      }
      set.add(x);
    }
    return false;
  }
}
```

### TypeScript

```typescript
function containsDuplicate(nums: number[]): boolean {
  const seen = new Set<number>();

  for (const num of nums) {
    if (seen.has(num)) {
      return true;
    }
    seen.add(num);
  }

  return false;
};
```

## **Complexity Analysis**

### **Assumptions**

- Let `n` be the number of elements in the input array `nums`.
- We're using a hash table (e.g. `Set` in TypeScript) that provides average-case O(1) time complexity for both `.has()` and `.add()` operations.
- Input values are within the allowed range: `-10⁹ <= nums[i] <= 10⁹`, but this does not affect the asymptotic complexity due to constant-time hashing.

### **Time Complexity**: `O(n)`

- We iterate through the entire array once → **O(n)** iterations.
- Each lookup (`seen.has(num)`) and insertion (`seen.add(num)`) is O(1) on average.
- Therefore, the total time complexity is **O(n)** in the average case.

> Worst-case time complexity could be higher (e.g. O(n²)) if there are significant hash collisions, but this is rare with good hash function implementations. For typical inputs, the performance remains linear.

### **Space Complexity**: `O(n)`

- In the worst case (no duplicates), we store all `n` elements in the hash table.
- Thus, auxiliary space grows linearly with the number of distinct elements → **O(n)**.

> If a duplicate is found early, actual memory usage may be much less than O(n), but big-O reflects the upper bound.

# Sorting and Linear Scan Approach

## **Intuition**

When an array is sorted, duplicate elements will appear consecutively. This observation allows us to efficiently detect duplicates by checking adjacent values after sorting. Although sorting requires `O(n log n)` time, this approach avoids the use of extra space beyond what's needed for sorting.

This method is useful in situations where modifying the input array is acceptable or when minimizing additional space usage is important.

