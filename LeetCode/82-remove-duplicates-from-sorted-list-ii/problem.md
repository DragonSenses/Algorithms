# 82. Remove Duplicates from Sorted List II

<p>Given the <code>head</code> of a sorted linked list, <em>delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list</em>. Return <em>the linked list <strong>sorted</strong> as well</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" style="width: 500px; height: 142px;" src="img/82-1.jpg">
<pre><strong>Input:</strong> head = [1,2,3,3,4,4,5]
<strong>Output:</strong> [1,2,5]
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" style="width: 500px; height: 205px;" src="img/82-2.jpg">
<pre><strong>Input:</strong> head = [1,1,1,2,3]
<strong>Output:</strong> [2,3]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The number of nodes in the list is in the range <code>[0, 300]</code>.</li>
	<li><code>-100 &lt;= Node.val &lt;= 100</code></li>
	<li>The list is guaranteed to be <strong>sorted</strong> in ascending order.</li>
</ul>

---

# Solution

- [Strict Deduplication Approach](#strict-deduplication-approach)

## **Problem Overview: Remove Duplicates from Sorted List II**

#### **Problem Statement**
Given the `head` of a sorted linked list, the goal is to remove all nodes that appear more than once in the list, leaving only distinct values. The resulting linked list should remain sorted.

#### **Key Observations**
1. The linked list is **sorted in ascending order**, which simplifies duplicate detection.
2. The objective is to **completely remove duplicated values**—meaning any number that appears more than once should be eliminated entirely.
3. The function must return the **new head of the filtered list** after removing duplicates.

#### **Example Walkthrough**
**Example 1:**
- **Input:** `[1,2,3,3,4,4,5]`
- **Process:** `3` and `4` are duplicates, so they are removed entirely.
- **Output:** `[1,2,5]`

**Example 2:**
- **Input:** `[1,1,1,2,3]`
- **Process:** `1` appears multiple times, so it is eliminated.
- **Output:** `[2,3]`

#### **Constraints**
- `0 <= Number of nodes <= 300`
- `-100 <= Node.val <= 100`
- The list is guaranteed to be **sorted**.

#### **Approach and Complexity**
- **Iterate through the list**, tracking duplicate elements using a pointer.
- **Skip over duplicate elements** entirely rather than just linking past them.
- **Time Complexity:** `O(n)`, where `n` is the number of nodes (since each node is visited once).
- **Space Complexity:** `O(1)`, as we modify the list in place without using extra data structures.

# Strict Deduplication Approach

## **Intuition**

Since the input linked list is sorted, duplicates are always adjacent, enabling easy identification.

However the key distinction between **Problem 82** and **Problem 83** is how duplicates are handled:

- **Problem 83 (Remove Duplicates from Sorted List)**: If a node has duplicates, we preserve **one copy** of the value and remove only the additional occurrences.
  - Example: `[1,1,2,3,3] → [1,2,3]`
  - Here, duplicate values remain in the list, but only one of each.

- **Problem 82 (Remove Duplicates from Sorted List II)**: If a node has duplicates, we **remove all occurrences** of that value, leaving only distinct numbers.
  - Example: `[1,1,2,3,3] → [2]`
  - The number `1` and `3` were duplicated, so they are removed entirely.

This means Problem 83 **retains unique elements**, while Problem 82 **eliminates all instances of duplicates**, leaving only numbers that appeared exactly once.

### **Strategy**

1. **Explicit Edge Case Handling**  
   - **Empty List (`head = null`)** -> Should return `null`.
   - **List with No Duplicates (`[1,2,3]`)** -> Should remain unchanged.
   - **List with Only Duplicates (`[1,1,1,1]`)** -> Should return an empty list `[]`.

2. **In-Place Modification: Using a Sentinel Node**
   - Since the list must be modified **in place**, a **sentinel node** is a useful technique for removing nodes at the beginning without special-case handling.

3. **Traversal: Two-Pointer Approach**  
   - Using a **two-pointer approach** (current node and a `prev` pointer) ensures efficient deletion.  
   - You should only unlink nodes **after confirming** they're duplicates, instead of prematurely skipping nodes.