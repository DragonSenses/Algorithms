# 90. Subsets II

<p>Given an integer array <code>nums</code> that may contain duplicates, return <em>all possible</em> <span data-keyword="subset" class=" cursor-pointer relative text-dark-blue-s text-sm"><strong>subsets</strong></span><em> (the power set)</em>.</p>

<p>The solution set <strong>must not</strong> contain duplicate subsets. Return the solution in <strong>any order</strong>.</p>

<p>A <strong>subset</strong> of an array is a selection of elements (possibly none) of the array.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<pre><strong>Input:</strong> nums = [1,2,2]
<strong>Output:</strong> [[],[1],[1,2],[1,2,2],[2],[2,2]]
</pre><p><strong class="example">Example 2:</strong></p>
<pre><strong>Input:</strong> nums = [0]
<strong>Output:</strong> [[],[0]]
</pre>
<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10</code></li>
	<li><code>-10 &lt;= nums[i] &lt;= 10</code></li>
</ul>

---

# Solution

- [Bitmasking Approach](#bitmasking-approach)

### **Problem Overview: Generating Unique Subsets (Power Set)**

Given an integer array `nums`, which may contain duplicate values, the goal is to generate **all possible subsets** (the power set) without any duplicate subsets. The solution should be returned in **any order**.

#### Key Requirements:
- Each subset should be unique, meaning duplicate subsets must be eliminated.
- Subsets can be of any length, including the empty set `[]`.
- The order of subsets in the output does not matter.

#### Understanding Subsets:
A subset of an array is a selection of elements that maintains their relative order but does not necessarily include all elements.

#### Example Walkthrough:

##### Example 1:
**Input:** `nums = [1,2,2]`  
**Output:** `[[], [1], [1,2], [1,2,2], [2], [2,2]]`  

Here, the duplicate value `2` is handled carefully to ensure that subsets are unique.

##### Example 2:
**Input:** `nums = [0]`  
**Output:** `[[], [0]]`  

With a single element, the subsets are straightforward: the empty set and the set containing `0`.

#### Constraints:
- `1 <= nums.length <= 10`
- `-10 <= nums[i] <= 10`

#### Approach:
Since duplicates need to be managed carefully, common techniques for solving this problem include:
1. **Backtracking** – Generate subsets iteratively while ensuring unique results.
2. **Sorting + Recursion** – Sorting `nums` helps in identifying and skipping duplicate elements during recursive subset generation.
3. **Bitmasking** (for small values of `nums.length`) – Using binary representation to enumerate subsets.

# Bitmasking Approach

## **Intuition**

Each element in `nums` can either be included in a subset or omitted, resulting in a total of **2ⁿ** distinct subsets for an array of length `n` (assuming no duplicates). Given that `n` has a maximum value of **10**, the number of possible subsets remains manageable (at most **1024**). This allows us to efficiently represent subsets using **bitmasking**.

### **Core Idea**
- Each subset corresponds to a **bitmask** of length `n`.
- A bitmask is a binary number where each bit's state (`1` or `0`) determines whether the corresponding element in `nums` is included in the subset.
- **Example representation:**
  - `000...0` => Empty subset `[]`
  - `111...1` => Full subset containing all elements in `nums`
  - Iterating over values from `0` to `2ⁿ - 1` generates all subsets.

### **Subset Construction via Bitmasking**
For each integer `mask` in the range `[0, 2ⁿ - 1]`, the binary representation reveals which indices should be included:
- **Set bit (`1`)** => Include corresponding element in `nums`
- **Unset bit (`0`)** => Exclude the element

Given the constraint that `n ≤ 10`, an **unsigned integer** (or `long` for extended precision) is sufficient to represent all bitmask combinations.

![Visualizing Subsets Using Bitmasking: Breakdown of `nums = [1,2,2]`](img/90-1.jpg)

## **Handling Duplicates**
Since `nums` may contain **duplicates**, some subsets may repeat. To ensure unique subsets:
1. **Sort `nums` beforehand** => Ensures identical subsets appear consistently (e.g., `[1,2]` instead of `[2,1]`).
2. **Use a set (`seen`)** => Tracks previously generated subsets to filter duplicates.

### **Example Issue Without Sorting**
Consider `nums = [2,1,2]`:
- Generated subsets: `[], [2], [1], [2], [2,1], [2,2], [1,2], [2,1,2]`
- `[1,2]` and `[2,1]` should be recognized as **duplicates**.

Sorting resolves this by ensuring subsets are generated in a consistent order, allowing efficient duplicate detection.

### **Example Walkthrough: Handling Duplicates with Bitmasking**
Consider `nums = [1,2,2]`. Since `nums` contains a duplicate (`2` appears twice), we must carefully track subsets to avoid repetition.

#### **Step 1: Generating Subsets Using Bitmasking**
We iterate over all possible bitmask values from `0` to `2³ - 1 = 7`, representing subsets:

| Bitmask  | Binary Representation | Subset Formed |
|----------|----------------------|---------------|
| `0`      | `000`                | `[]`          |
| `1`      | `001`                | `[1]`         |
| `2`      | `010`                | `[2]`         |
| `3`      | `011`                | `[1,2]`       |
| `4`      | `100`                | `[2]`         |
| `5`      | `101`                | `[1,2]`       |
| `6`      | `110`                | `[2,2]`       |
| `7`      | `111`                | `[1,2,2]`     |

#### **Step 2: Identifying Duplicate Subsets**
Looking at the generated subsets, we see `[2]` appears twice (from bitmasks `010` and `100`), and `[1,2]` appears twice (from `011` and `101`). To remove duplicates:
1. **Sort `nums` before processing** → This ensures subsets are formed in a consistent order.
2. **Use a `set` to track unique subsets** → We only add new subsets if they haven't been seen before.

#### **Final Unique Subsets After Filtering**
After sorting `nums = [1,2,2]` and removing duplicates:
- `[[], [1], [1,2], [1,2,2], [2], [2,2]]`

## **Algorithm**

### **Step 1: Sort the Input Array**
Sorting `nums` ensures that subsets are generated in a consistent order, helping to identify and eliminate duplicates.

### **Step 2: Initialize Necessary Variables**
- Set `maxNumberOfSubsets = 2ⁿ`, where `n` is the length of `nums`.
- Create an empty **set** (`seen`) to store unique subsets, ensuring duplicate subsets are filtered.
  
### **Step 3: Iterate Through Bitmask Values**
Loop through numbers from `0` to `maxNumberOfSubsets - 1`. Each number represents a bitmask:
- The set bits (`1`s) in the bitmask indicate which elements from `nums` should be included in the current subset.

### **Step 4: Construct Subsets Based on Bitmask**
- Initialize an empty list `currentSubset` to store elements corresponding to set bits.
- Maintain a **hashcode** string—storing elements as a comma-separated string—to uniquely identify subsets.

### **Step 5: Identify Set Bits**
Run an inner loop over each index `j` (from `0` to `n - 1`):
- If the `j`th bit in the bitmask is set (`1`), add `nums[j]` to `currentSubset`.
- Append `nums[j]` to the `hashcode` string for duplicate detection.

### **Step 6: Filter and Store Unique Subsets**
- If `hashcode` is **not** in `seen`, add `currentSubset` to both `seen` and `subsets`.

### **Step 7: Return the List of Unique Subsets**
After iterating over all possible bitmask values, return `subsets`.

### **Pseudocode**

```plaintext
FUNCTION GenerateUniqueSubsets(nums):
  SORT nums  // Ensure duplicate subsets are consistently ordered

  SET maxSubsets = 2 ^ LENGTH(nums)  // Total possible subsets
  SET seen = EMPTY_SET               // Tracks unique subsets
  SET subsets = EMPTY_LIST           // Stores final subset results

  FOR subsetIndex FROM 0 TO maxSubsets - 1:  // Iterate through all bitmasks
    SET currentSubset = EMPTY_LIST
    SET hashcode = EMPTY_STRING  // Unique identifier for duplicates

    FOR j FROM 0 TO LENGTH(nums) - 1:
      IF subsetIndex HAS BIT SET AT j:  // Check if jth bit is 1
        APPEND nums[j] TO currentSubset
        APPEND nums[j] TO hashcode WITH COMMA

    IF hashcode NOT IN seen:  // Ensure uniqueness
      ADD hashcode TO seen
      ADD currentSubset TO subsets

  RETURN subsets
```

## **Implementation**

### Java

```java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Solution class implementing the bitmasking approach to generate unique subsets.
 */
class Solution {

  /**
   * Generates all unique subsets of the given array using bitmasking.
   * 
   * @param nums Array of integers that may contain duplicates.
   * @return List of unique subsets.
   */
  public List<List<Integer>> subsetsWithDup(int[] nums) {
    // Step 1: Sort nums to ensure consistent subset ordering
    Arrays.sort(nums);

    int n = nums.length;
    int maxSubsets = 1 << n; // Equivalent to 2^n
    Set<String> seen = new HashSet<>(); // Used to eliminate duplicate subsets
    List<List<Integer>> subsets = new ArrayList<>(); // Stores unique subsets

    // Step 2: Iterate over all possible bitmask values
    for (int mask = 0; mask < maxSubsets; mask++) {
      List<Integer> currentSubset = new ArrayList<>(); // Subset generated from bitmask
      StringBuilder hashcode = new StringBuilder(); // Unique identifier for duplicate detection

      // Step 3: Determine elements present in the subset
      for (int j = 0; j < n; j++) {
        // Check if the j-th bit in 'mask' is set (1)
        if ((mask & (1 << j)) != 0) {
          // Include nums[j] in the current subset
          currentSubset.add(nums[j]);

          // Append a comma to separate elements in the hashcode (if not the first element)
          if (hashcode.length() > 0) {
            hashcode.append(",");
          }

          // Append the current number to the hashcode string (used for duplicate tracking)
          hashcode.append(nums[j]);
        }
      }

      // Step 4: Add to results if unique
      if (seen.add(hashcode.toString())) {
        subsets.add(currentSubset);
      }
    }

    // Return finalized list of unique subsets
    return subsets;
  }
}
```