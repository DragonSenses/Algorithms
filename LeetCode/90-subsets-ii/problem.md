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
  - **Time Complexity**: `O(n * 2^n)`
  - **Space Complexity**: `O(n * 2^n)`
- [Cascading (Iterative) Approach](#cascading-iterative-approach)
  - **Time Complexity**: `O(n * 2^n)`
  - **Space Complexity**: `O(log n)`

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
1. **Sort `nums` before processing** => This ensures subsets are formed in a consistent order.
2. **Use a `set` to track unique subsets** => We only add new subsets if they haven't been seen before.

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

### TypeScript

```typescript
/**
 * Generates all unique subsets of a given array using bitmasking.
 * 
 * This approach leverages a bitmask to represent subset inclusion, ensuring
 * duplicate subsets are filtered using a hashcode string.
 *
 * @param {number[]} nums - Input array that may contain duplicate values.
 * @returns {number[][]} List of unique subsets.
 */
function subsetsWithDup(nums: number[]): number[][] {
  // Step 1: Sort nums to ensure consistent subset ordering
  nums.sort((a, b) => a - b);

  const n = nums.length;
  const maxSubsets = 1 << n; // Equivalent to 2^n (total possible subsets)
  const seen = new Set<string>(); // Tracks unique subsets using hashcodes
  const subsets: number[][] = []; // Stores generated subsets

  // Step 2: Iterate over all possible bitmask values
  for (let mask = 0; mask < maxSubsets; mask++) {
    const currentSubset: number[] = []; // Stores subset elements
    let hashcode = ""; // Unique identifier for duplicate tracking

    // Step 3: Determine elements present in subset
    for (let j = 0; j < n; j++) {
      // Check if the j-th bit in 'mask' is set
      if ((mask & (1 << j)) !== 0) {  
        // Include nums[j] in the current subset
        currentSubset.push(nums[j]);  

        // Append a comma for separation if hashcode is non-empty
        if (hashcode.length > 0) {  
          hashcode += ",";
        }

        // Append the current number to the hashcode for duplicate tracking
        hashcode += nums[j];  
      }
    }

    // Step 4: Add subset to results if unique
    if (!seen.has(hashcode)) {
      seen.add(hashcode);
      subsets.push(currentSubset);
    }
  }
  
  // Return finalized list of unique subsets
  return subsets;
}
```

## **Complexity Analysis**

### **Assumptions**
- Let `n` be the size of the input array `nums`.

### **Time Complexity**: `O(n * 2^n)`
- **Generating Subsets**: The time complexity is `O(n × 2^n)`, as each subset requires up to `n` operations for construction.
- **Sorting the Array**: Sorting `nums` takes `O(n log n)`.
- **Iterating Over Subset Masks**:
  - The outer loop runs `2^n` times (as each bitmask represents a subset).
  - The inner loop runs `O(n)` times to construct each subset.
  - Generating a hash value for each subset adds `O(n)`, but this occurs within the inner loop.

- **Overall Complexity**: `O(n log n + (2n) = O(n * 2^n)`

Since `O(n log n)` is negligible compared to the exponential term, the final complexity remains `O(n * 2^n)`.

### **Space Complexity**: `O(n * 2^n)`
- **Exponential Growth**: Storing all subsets requires `O(n × 2^n)`, since each subset has up to `n` elements and there are `2^n` subsets.
- **Tracking Unique Subsets**:
- The hash set (`seen`) holds at most `2^n` subsets, contributing `O(n × 2^n)`.
- The space required for sorting depends on the sorting algorithm:
  - **Java's `Arrays.sort()`** (for primitives) uses **quicksort** (`O(log n)` space).
  - **C++ STL `sort()`** uses a hybrid sorting method (worst-case `O(log n)` space).
- Since sorting's space complexity is `O(log n)`, it is insignificant compared to `O(n × 2^n)`.
- **Ignoring Output List**: The space required for the final list of subsets is typically excluded in complexity analysis.

- **Final Space Complexity**: `O(log n + n × 2n)`

Since `O(n log n)` is negligible compared to the exponential term, the final complexity remains `O(n * 2^n)`.

# Cascading (Iterative) Approach

## **Overview**
Cascading is an approach used to iteratively build solutions by progressively expanding previous results.  
In the context of subset generation, **cascading** involves constructing new subsets by **adding elements** to existing ones **step by step**.  

Unlike backtracking, which explores all possibilities recursively, the cascading approach maintains a **flat iteration structure** where each step builds upon the last without excessive branching.  

In this algorithm, cascading enables **controlled subset expansion** while effectively managing duplicate elements. By systematically adding elements based on previously generated subsets, we ensure that every subset is **generated iteratively** rather than through recursion.

## **Intuition**

### **Handling Unique Elements**
If the given array **contains only unique elements**, there will be **2ⁿ distinct subsets**, where `n` is the length of the array.  
To generate all subsets:
1. Start with an **empty subset**.
2. Iteratively **add each element** to all existing subsets to create new ones.

This ensures that every possible subset is formed in a **structured manner**.

### **Handling Duplicate Elements**
When the array contains **duplicate elements**, using the previous approach **would lead to duplicate subsets**.  
To **prevent duplicates**, we must:
1. **Sort the input array** to group identical elements together.
2. Follow a **controlled duplication rule** for subset creation:
   - The **first occurrence** of a value is added to **all existing subsets**.
   - Subsequent **duplicate occurrences** are added **only to subsets created in the previous step**.

### **Applying the Rule**
Instead of treating each element individually, **groups of duplicates** are handled systematically.  

For example, given the array `[3, 3, 3]`, the ways to form subsets are:
1. **Exclude all occurrences of `3`**.
2. **Include one occurrence of `3` in all existing subsets**.
3. **Include two occurrences of `3` in all existing subsets**.
4. **Include all three occurrences of `3` in all existing subsets**.

This ensures that **every subset remains unique** while maintaining a systematic construction.

## **Algorithm**

### **Step 1: Sort the Input Array**
- Sort `nums` in **ascending order** to group duplicate elements together.
- This helps maintain **consistent subset ordering** and simplifies duplicate handling.

### **Step 2: Initialize Tracking Variables**
- Define `subsetSize = 0` => Tracks the **starting index** of subsets for handling duplicates.
- This ensures that **duplicates are only added to subsets from the previous iteration**, avoiding redundant entries.

### **Step 3: Iterate Over the Input Array**
- Loop through `nums`, **processing each element** one by one.

### **Step 4: Determine Where to Start Adding the Element**
- **New element (not seen before):** Add it to **all existing subsets**, so set `startingIndex = 0`.
- **Duplicate element:** Only add it to **subsets created in the previous iteration**, so set `startingIndex = subsetSize`.

### **Step 5: Update Subset Tracking**
- **Update `subsetSize`** to reflect the current size of the `subsets` list.
- This ensures the **starting index for duplicates** is correctly set for the next iteration.

### **Step 6: Expand Subsets Using the Current Element**
- **Iterate through subsets** created **before** this iteration.
- Add the **current element** to each subset starting from `startingIndex`.

### **Step 7: Return the Final List of Unique Subsets**
- After processing all elements, return the `subsets` list containing **unique subsets**.

### **Pseudocode**

```plaintext
FUNCTION subsetsWithDup(nums):
  SORT nums in ascending order
  
  INITIALIZE subsets as a list containing an empty subset []
  SET subsetSize = 0  // Tracks index to start adding duplicates

  FOR each element in nums:
    IF this element is the first occurrence:
      SET startingIndex = 0  // Add to all subsets
    ELSE:
      SET startingIndex = subsetSize  // Add to only newly created subsets
    
    UPDATE subsetSize to current size of subsets
    
    // Expand subsets using the current element
    FOR each subset from startingIndex to subsetSize:
      CREATE newSubset as a copy of current subset
      ADD current element to newSubset
      APPEND newSubset to subsets
  
  RETURN subsets
```

## **Implementation**

### Java

```java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Generates all unique subsets using the Cascading (Iterative) approach.
 */
class Solution2 {

  /**
   * Returns a list of unique subsets from the given array.
   *
   * @param nums Array of integers that may contain duplicates.
   * @return List of unique subsets.
   */
  public List<List<Integer>> subsetsWithDup(int[] nums) {
    // Step 1: Sort the input array to group duplicates together
    Arrays.sort(nums);

    List<List<Integer>> subsets = new ArrayList<>();
    subsets.add(new ArrayList<>()); // Initialize with the empty subset

    int subsetSize = 0; // Tracks the starting point for appending duplicates

    // Step 2: Iterate through elements in nums
    for (int i = 0; i < nums.length; i++) {
      int startIndex;

      // Duplicate: extend only subsets from previous round
      if (i > 0 && nums[i] == nums[i - 1]) {
        startIndex = subsetSize;
      } else {
        // First occurrence: add to all subsets
        startIndex = 0;
      }

      // Update subsetSize for the next round's starting index
      subsetSize = subsets.size();

      // Step 3: Clone and extend subsets from startIndex to subsetSize
      for (int j = startIndex; j < subsetSize; j++) {
        List<Integer> newSubset = new ArrayList<>(subsets.get(j));
        newSubset.add(nums[i]);
        subsets.add(newSubset);
      }
    }

    // Step 4: Return completed list of unique subsets
    return subsets;
  }
}
```

### TypeScript

```typescript
/**
 * Generates all unique subsets of a given array using a cascading, iterative approach.
 *
 * @param nums - Input array that may contain duplicates.
 * @returns A list of all unique subsets.
 */
function subsetsWithDup(nums: number[]): number[][] {
  // Step 1: Sort nums to ensure duplicates are grouped together
  nums.sort((a, b) => a - b);

  const subsets: number[][] = [[]]; // Start with an empty subset
  let subsetSize = 0; // Tracks the subset count before current expansion

  // Step 2: Iterate through each number in nums
  for (let i = 0; i < nums.length; i++) {
    let startIndex;

    // If current number is a duplicate, only extend subsets
    // that were created in the previous iteration
    if (i > 0 && nums[i] === nums[i - 1]) {
      startIndex = subsetSize;
    } else {
      // If it's a new number, extend all existing subsets
      startIndex = 0;
    }

    subsetSize = subsets.length; // Snapshot current size before appending new subsets

    // Step 3: Clone and extend subsets from startIndex to subsetSize
    for (let j = startIndex; j < subsetSize; j++) {
      subsets.push([...subsets[j], nums[i]]);
    }
  }

  // Step 4: Return the list of all unique subsets
  return subsets;
}
```

## **Complexity Analysis**

### **Assumptions**
- Let `n` be the size of the input array `nums`.

### **Time Complexity**: `O(n * 2^n)`
- **Sorting Step:** The array is sorted initially, which requires **O(n log n)** time.
   
- **Subset Generation:**We use two nested loops to generate subsets:
   - The **outer loop** iterates through `nums`, leading to **O(2^n)** operations in the worst case.
   - The **inner loop** deep copies previously generated subsets, requiring **O(n)** time per subset.
   
- **Final Time Complexity Calculation:** Combining sorting and subset generation:  
     `O(n log n) + O(n * 2^n) = O(n (log n + 2^n)) ≈ O(n * 2^n)`.

### **Space Complexity**: `O(log n)`
- **Logarithmic-Space Usage:**  
   - The algorithm primarily uses a few fixed variables for tracking, making space consumption minimal.

- **Sorting Overhead:**  
   - The space complexity depends on the sorting method used:
     - **Java's `Arrays.sort()`** (for primitives) implements a **variant of quicksort**, consuming **O(log n)** space.
     - **C++ STL's `sort()`** is a hybrid of Quick Sort, Heap Sort, and Insertion Sort, with a worst-case **O(log n)** space complexity.

- **Output Storage Consideration:**  
   - The required space for storing subsets is **not** considered in complexity analysis since it's part of the output.

Thus, the overall **auxiliary space complexity** is **O(log n)**.
