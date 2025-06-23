# 88. Merge Sorted Array

<p>You are given two integer arrays <code>nums1</code> and <code>nums2</code>, sorted in <strong>non-decreasing order</strong>, and two integers <code>m</code> and <code>n</code>, representing the number of elements in <code>nums1</code> and <code>nums2</code> respectively.</p>

<p><strong>Merge</strong> <code>nums1</code> and <code>nums2</code> into a single array sorted in <strong>non-decreasing order</strong>.</p>

<p>The final sorted array should not be returned by the function, but instead be <em>stored inside the array </em><code>nums1</code>. To accommodate this, <code>nums1</code> has a length of <code>m + n</code>, where the first <code>m</code> elements denote the elements that should be merged, and the last <code>n</code> elements are set to <code>0</code> and should be ignored. <code>nums2</code> has a length of <code>n</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
<strong>Output:</strong> [1,2,2,3,5,6]
<strong>Explanation:</strong> The arrays we are merging are [1,2,3] and [2,5,6].
The result of the merge is [<u>1</u>,<u>2</u>,2,<u>3</u>,5,6] with the underlined elements coming from nums1.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> nums1 = [1], m = 1, nums2 = [], n = 0
<strong>Output:</strong> [1]
<strong>Explanation:</strong> The arrays we are merging are [1] and [].
The result of the merge is [1].
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> nums1 = [0], m = 0, nums2 = [1], n = 1
<strong>Output:</strong> [1]
<strong>Explanation:</strong> The arrays we are merging are [] and [1].
The result of the merge is [1].
Note that because m = 0, there are no elements in nums1. The 0 is only there to ensure the merge result can fit in nums1.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>nums1.length == m + n</code></li>
	<li><code>nums2.length == n</code></li>
	<li><code>0 &lt;= m, n &lt;= 200</code></li>
	<li><code>1 &lt;= m + n &lt;= 200</code></li>
	<li><code>-10<sup>9</sup> &lt;= nums1[i], nums2[j] &lt;= 10<sup>9</sup></code></li>
</ul>

<p>&nbsp;</p>
<p><strong>Follow up: </strong>Can you come up with an algorithm that runs in <code>O(m + n)</code> time?</p>

---

# Solution

- [Merge with Three Pointers (Forward Approach)](#merge-with-three-pointers-forward-approach)
  - **Time Complexity**: `O(m + n)`
  - **Space Complexity**: `O(m)`
- [Merge with Three Pointers (Reverse Approach)](#merge-with-three-pointers-reverse-approach)

## **Problem Overview: Merge Sorted Array**

You are given two non-decreasing integer arrays:

- `nums1` of size `m + n`, where the first `m` elements are meaningful and the remaining `n` elements are placeholders (initialized to 0).
- `nums2` of size `n`, fully populated.

The goal is to **merge `nums2` into `nums1`** in-place so that `nums1` becomes a single sorted array in non-decreasing order.

### Requirements

- Modify `nums1` directly to contain the merged sorted result.
- `nums1` has sufficient space to accommodate all elements.

### Example

**Input:**
```plaintext
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3
```

**Output:**
```plaintext
[1,2,2,3,5,6]
```

### Constraints

- `nums1.length == m + n`
- `nums2.length == n`
- `0 ≤ m, n ≤ 200`
- `1 ≤ m + n ≤ 200`
- Each element of `nums1` and `nums2` is in the range [−10⁹, 10⁹]

### Follow-Up

Can you implement an algorithm that runs in **O(m + n)** time?

# Merge with Three Pointers (Forward Approach)

This method is called the **forward approach** because all pointers—two for reading (`nums1Copy` and `nums2`) and one for writing into `nums1`—start at index 0 and move from **left to right**. It processes elements in increasing index order, as opposed to the reverse approach, which merges from the end to avoid overwriting.

## **Intuition**

Since both `nums1` and `nums2` are already sorted in non-decreasing order, we can perform a classic merge using the two-pointer technique—similar to the merge step in merge sort. To do this without corrupting existing data in `nums1`, we first create a shallow copy of its first `m` elements. Then we use **two read pointers**—one for the copied portion of `nums1`, and one for `nums2`—along with a **write pointer** for the actual `nums1` array.

## **Algorithm**

1. Create a copy of the first `m` elements of `nums1` and store it in `nums1Copy`.

2. Initialize three pointers:
   - `p1 = 0` — to iterate over `nums1Copy`
   - `p2 = 0` — to iterate over `nums2`
   - `p = 0` — to write into `nums1`

3. While both `p1 < m` and `p2 < n`:
   - If `nums1Copy[p1] <= nums2[p2]`, assign `nums1[p] = nums1Copy[p1]` and increment `p1`
   - Else, assign `nums1[p] = nums2[p2]` and increment `p2`
   - Increment `p` after each assignment

4. Copy any remaining elements from `nums1Copy` (if any):
   - While `p1 < m`, set `nums1[p] = nums1Copy[p1]`, then increment both `p1` and `p`

5. Copy any remaining elements from `nums2`:
   - While `p2 < n`, set `nums1[p] = nums2[p2]`, then increment both `p2` and `p`

This results in a fully merged and sorted array stored in-place in `nums1`, with a clear flow from left to right.

## **Implementation**

### Java

```java
class Solution {
  public void merge(int[] nums1, int m, int[] nums2, int n) {
    // Step 1: Make a copy of the first m elements of nums1
    int[] nums1Copy = new int[m];
    System.arraycopy(nums1, 0, nums1Copy, 0, m);

    // Step 2: Initialize pointers for nums1Copy (p1), nums2 (p2), and nums1 (p)
    int p1 = 0, p2 = 0, p = 0;

    // Step 3: Merge nums1Copy and nums2 into nums1
    while (p1 < m && p2 < n) {
      if (nums1Copy[p1] <= nums2[p2]) {
        nums1[p++] = nums1Copy[p1++];
      } else {
        nums1[p++] = nums2[p2++];
      }
    }

    // Step 4: Copy any remaining elements from nums1Copy
    while (p1 < m) {
      nums1[p++] = nums1Copy[p1++];
    }

    // Step 5: Copy any remaining elements from nums2
    while (p2 < n) {
      nums1[p++] = nums2[p2++];
    }
  }
}
```

### TypeScript

```typescript
function merge(nums1: number[], m: number, nums2: number[], n: number): void {
  // Step 1: Copy the first m elements of nums1
  const nums1Copy = nums1.slice(0, m);

  // Step 2: Initialize pointers
  let p1 = 0; // Pointer for nums1Copy
  let p2 = 0; // Pointer for nums2
  let p = 0;  // Write pointer for nums1

  // Step 3: Merge nums1Copy and nums2 into nums1
  while (p1 < m && p2 < n) {
    if (nums1Copy[p1] <= nums2[p2]) {
      nums1[p++] = nums1Copy[p1++];
    } else {
      nums1[p++] = nums2[p2++];
    }
  }

  // Step 4: Copy remaining elements from nums1Copy (if any)
  while (p1 < m) {
    nums1[p++] = nums1Copy[p1++];
  }

  // Step 5: Copy remaining elements from nums2 (if any)
  while (p2 < n) {
    nums1[p++] = nums2[p2++];
  }
}
```

## **Complexity Analysis**

### **Assumptions**

- Let `m` be the number of elements in `nums1`
- Let `n` be the number of elements in `nums2`

### **Time Complexity**: `O(m + n)`

- **Single Traversal**: We traverse each element of `nums1Copy` and `nums2` exactly once while merging.
- **Constant-Time Operations**:Each comparison and assignment takes constant time, and we perform at most `m + n` such operations.

### **Space Complexity**: `O(m)`

- **Temporary Buffer**: We allocate an auxiliary array `nums1Copy` of size `m` to store a snapshot of the meaningful elements of `nums1`.
- **Fixed Pointers**: Aside from the array copy, we use only a constant number of variables (`p1`, `p2`, `p`) to manage traversal and writing.
- **No Heap Allocation for nums2**: The algorithm reads from `nums2` but does not duplicate or modify it, preserving space efficiency.

# Merge with Three Pointers (Reverse Approach)

### **Insights**

#### **Interview Tips:**  
- This is a medium-level solution to an easy-level problem. Many of "easy" problems actually harbor deeper layers of optimization, and strong candidates are expected to uncover those layers. Don't stop at the brute-force approach—look for hidden efficiency.

- Whenever you're asked to modify arrays **in-place**, consider iterating **backwards**. This change in direction often makes overwriting challenges disappear and reveals a more elegant solution.

#### **Observation Insight: Space Complexity Considerations**

The forward approach (copying `nums1` and merging) achieves optimal time complexity `O(m + n)` but requires `O(m)` extra space. The challenge stems from needing to preserve `nums1`'s original data during merging.

#### **Optimization Insight: Rethinking Overwrite Strategy**

Instead of writing into `nums1` from the beginning and worrying about overwriting, we can reverse the direction. By writing from the **end**—where there's empty buffer space—we safely avoid overwriting any meaningful data.

Set pointers:
- `p1 = m - 1` (end of valid `nums1` data)
- `p2 = n - 1` (end of `nums2`)
- `p  = m + n - 1` (end of `nums1` total capacity)

This guarantees that each value lands in its final position before any overwriting can occur.

## **Intuition**

Given that both arrays are sorted in non-decreasing order, we can efficiently merge them using a reverse two-pointer strategy. Instead of copying values and allocating extra space, we take advantage of the extra buffer space in `nums1` by filling it from the end. This allows us to compare the largest unplaced elements from `nums1` and `nums2`, placing the greater of the two at the back of `nums1`.

This in-place approach avoids unnecessary memory usage and maintains an optimal time complexity of `O(m + n)`. Working backwards eliminates the risk of overwriting meaningful elements in `nums1`.