# 15. 3Sum

Given an integer array nums, return all the triplets `[nums[i], nums[j], nums[k]]` such that `i != j`, `i != k`, and `j != k`, and `nums[i] + nums[j] + nums[k] == 0`.

Notice that the solution set must not contain duplicate triplets.

#### Example 1:

<pre><strong>Input:</strong> nums = [-1,0,1,2,-1,-4]
<strong>Output:</strong> [[-1,-1,2],[-1,0,1]]
<strong>Explanation:</strong> 
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.
</pre>

#### Example 2:

<pre><strong>Input:</strong> nums = [0,1,1]
<strong>Output:</strong> []
<strong>Explanation:</strong> The only possible triplet does not sum up to 0.
</pre>

#### Example 3:

<pre><strong>Input:</strong> nums = [0,0,0]
<strong>Output:</strong> [[0,0,0]]
<strong>Explanation:</strong> The only possible triplet sums up to 0.
</pre>

#### Constraints:

<ul>
	<li><code>3 &lt;= nums.length &lt;= 3000</code></li>
	<li><code>-10<sup>5</sup> &lt;= nums[i] &lt;= 10<sup>5</sup></code></li>
</ul>

<br>

---


# Solution

- [Two-Pointers Approach](#two-pointers)
  - Time complexity: `O(n^2)`
- [Hash Set Approach](#hashset-approach-for-3sum)
  - Time complexity: `O(n^2)`

## Interview Tips

### Understanding the Problem Sequence

This problem builds on the concepts from Two Sum and Two Sum II. It's beneficial to review these problems first. Interviewers often start with Two Sum and then progress to more complex variations like 3Sum. Pay close attention to the nuances in each problem's description and try to leverage your existing solutions.

### Key Similarities and Differences

- **Common Goal**: In Two Sum, Two Sum II, and 3Sum, the objective is to find elements that sum to a specific target.
- **Unique Challenge in 3Sum**: Unlike Two Sum and Two Sum II, where you find exactly one solution, 3Sum requires finding all unique triplets that sum to zero.

### Strategy and Best Conceivable Runtime (BCR)

Before diving into 3Sum, let's review the strategies and their time complexities for Two Sum and Two Sum II:

1. **Two Sum**:
   - Uses a hashmap to find complement values.
   - Achieves a time complexity of O(N).

2. **Two Sum II**:
   - Utilizes the two-pointer technique.
   - Has a time complexity of O(N) for a sorted array.
   - For an unsorted array, sorting it first results in a time complexity of O(N log N).

Given that 3Sum involves an additional dimension, aiming for a time complexity of O(N²) is a reasonable target for our BCR.

By understanding these foundational problems and their solutions, you'll be better prepared to tackle 3Sum and similar challenges in interviews.

# Two Pointers

Let's solve 3Sum using the two pointers pattern.

## **Intuition**

### Step-by-Step Strategy

1. **Sorting the Array**:
   - We will follow the two-pointer pattern as in Two Sum II, which requires the array to be sorted.
   - Sorting the array first ensures that our overall time complexity remains O(n²), as sorting is O(n log n).

2. **Handling Duplicates**:
   - To ensure the result contains unique triplets, we need to skip duplicate values.
   - This is straightforward because duplicate values are adjacent in a sorted array.

3. **No-Sort Approach**:
   - If you're curious about solving this problem without sorting, refer to the "No-Sort" approach below.
   - There are scenarios where this approach is preferable, and interviewers might test your knowledge on it.

### Detailed Explanation

1. **Pivot Element and Pair Finding**:
   - After sorting the array, we move our pivot element `nums[i]` and analyze elements to its right.
   - We find all pairs whose sum equals `-nums[i]` using the two-pointer pattern, ensuring the sum of the pivot element (`nums[i]`) and the pair (`-nums[i]`) equals zero.

2. **Two-Pointer Technique Refresher**:
   - Initially, set the pointers to the first and last elements respectively.
   - Compare the sum of these two elements to the target:
     - If the sum is smaller, increment the lower pointer `lo`.
     - If the sum is larger, decrement the higher pointer `hi`.
   - This ensures the sum always moves toward the target, pruning pairs that would move it further away.
   - This technique works effectively only if the array is sorted. For a detailed explanation, refer to the Two Sum II solution.

By following these steps, you can efficiently solve the 3Sum problem while ensuring unique triplets and maintaining optimal time complexity.

## **Algorithm**

The implementation is straightforward; we just need to modify `twoSumII` to produce triplets and skip repeating values.

### Main Function

1. **Sort the Input Array**:
   - Sort the array `nums`.

2. **Iterate Through the Array**:
   - For each element in the array:
     - If the current value is greater than zero, break the loop since remaining values cannot sum to zero.
     - If the current value is the same as the previous one, skip it to avoid duplicates.
     - Otherwise, call `twoSumII` for the current index `i`.

### `twoSumII` Function

1. **Initialize Pointers**:
   - Set the low pointer `lo` to `i + 1` and the high pointer `hi` to the last index.

2. **Find Pairs**:
   - While `lo` is less than `hi`:
     - Calculate the sum of `nums[i] + nums[lo] + nums[hi]`.
     - If the sum is less than zero, increment `lo`.
     - If the sum is greater than zero, decrement `hi`.
     - If the sum equals zero:
       - Add the triplet to the result `res`.
       - Increment `lo` and decrement `hi`.
       - Continue incrementing `lo` while the next value is the same to avoid duplicates.

### Return the Result

- Return the result array `res` containing all unique triplets.

This approach ensures that we efficiently find all unique triplets that sum to zero while maintaining optimal time complexity.

## **Complexity Analysis**

Let \( n \) be the length of the input array.

### **Time Complexity**: \( O(n^2) \)
- **Sorting the Array**: Sorting takes \( O(n \log n) \) time.
- **Two-Pointer Technique**: Finding pairs using the two-pointer technique takes \( O(n) \) time for each element.
- **Overall Complexity**: The combined time complexity is \( O(n \log n + n^2) \), which simplifies to \( O(n^2) \) as \( n^2 \) dominates \( n \log n \).

### **Space Complexity**: \( O(\log n) \) to \( O(n) \)
- **Sorting Space**: The space complexity depends on the sorting algorithm used:
  - **In-Place Sorting**: Algorithms like heapsort use \( O(\log n) \) space.
  - **Non In-Place Sorting**: Algorithms like mergesort use \( O(n) \) space.
- **Output Space**: The memory required for the output is not considered in the complexity analysis.

## **Implementation**

### Java

**Note:** This implementation achieved a runtime of 9 ms, placing it in the top 0.33% of all solutions. In comparison, 66.59% of solutions had a runtime of 29 ms.

```java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

  /**
   * Finds all unique triplets in the array which gives the sum of zero.
   *
   * @param nums the input array of integers
   * @return a list of lists containing all unique triplets that sum to zero
   */
  public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    
    // Sort the array
    Arrays.sort(nums);
    
    // Iterate through the array
    for (int i = 0; i < nums.length - 2; i++) {
      // If the current value is greater than zero, break from the loop
      if (nums[i] > 0) {
        break;
      }
      
      // Skip the same element to avoid duplicates
      if (i > 0 && nums[i] == nums[i - 1]) {
        continue;
      }
      
      // Call twoSumII for the current position i
      twoSumII(nums, i, res);
    }
    
    return res;
  }

  /**
   * Helper function to find pairs that sum to the target using two pointers.
   *
   * @param nums the input array of integers
   * @param i the current index in the array
   * @param res the result list to store triplets
   */
  private void twoSumII(int[] nums, int i, List<List<Integer>> res) {
    int lo = i + 1, hi = nums.length - 1;
    int target = -nums[i];
    
    while (lo < hi) {
      int sum = nums[lo] + nums[hi];
      
      if (sum < target) {
        lo++;
      } else if (sum > target) {
        hi--;
      } else {
        res.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
        lo++;
        hi--;
        
        // Skip the same element to avoid duplicates in the result
        while (lo < hi && nums[lo] == nums[lo - 1]) {
          lo++;
        }
      }
    }
  }
}
```

#### Overview

The goal of this solution is to find all unique triplets in the array that sum to zero. The solution uses sorting and a two-pointer technique to achieve this efficiently.

#### Detailed Breakdown

1. **Imports and Class Definition**
   ```java
   import java.util.ArrayList;
   import java.util.Arrays;
   import java.util.List;

   public class Solution {
   ```

2. **Method Definition**
   ```java
   public List<List<Integer>> threeSum(int[] nums) {
       List<List<Integer>> res = new ArrayList<>();
   ```

3. **Sorting the Array**
   ```java
   Arrays.sort(nums);
   ```
   - Sorting helps in efficiently finding pairs that sum to a specific value using the two-pointer technique.

4. **Iterating Through the Array**
   ```java
   for (int i = 0; i < nums.length - 2; i++) {
       if (nums[i] > 0) {
           break;
       }
       if (i > 0 && nums[i] == nums[i - 1]) {
           continue;
       }
       twoSumII(nums, i, res);
   }
   ```
   - The loop runs until `nums.length - 2` to leave space for two more elements.
   - If the current element is greater than zero, break the loop because no three positive numbers can sum to zero.
   - Skip duplicate elements to avoid duplicate triplets.

5. **Helper Method: `twoSumII`**
   ```java
   private void twoSumII(int[] nums, int i, List<List<Integer>> res) {
       int lo = i + 1, hi = nums.length - 1;
       int target = -nums[i];
   ```
   - This method finds pairs in the sorted array that sum to the negative of the current element (`-nums[i]`).

6. **Two-Pointer Technique**
   ```java
   while (lo < hi) {
       int sum = nums[lo] + nums[hi];
       if (sum < target) {
           lo++;
       } else if (sum > target) {
           hi--;
       } else {
           res.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
           lo++;
           hi--;
           while (lo < hi && nums[lo] == nums[lo - 1]) {
               lo++;
           }
       }
   }
   ```
   - Initialize two pointers: `lo` starting just after `i` and `hi` at the end of the array.
   - Calculate the sum of the elements at `lo` and `hi`.
   - If the sum is less than the target, move the `lo` pointer to the right.
   - If the sum is greater than the target, move the `hi` pointer to the left.
   - If the sum equals the target, add the triplet to the result list and move both pointers inward, skipping duplicates.

7. **Returning the Result**
   ```java
   return res;
   }
   ```

#### Summary

- **Sorting** the array helps in using the two-pointer technique.
- **Skipping duplicates** ensures unique triplets.
- **Two-pointer technique** efficiently finds pairs that sum to a specific value.

This approach ensures that the solution is both time-efficient and avoids duplicate triplets.

# HashSet Approach for 3Sum

## **Intuition**

To find triplets that sum up to zero, we can adapt the hash table approach from the Two Sum solution. However, this approach won't work for problems like 3Sum Smaller or 3Sum Closest, where the sum isn't necessarily zero.

### Pivot Element

We use `nums[i]` as our pivot element and analyze the elements to its right. By finding pairs whose sum equals `-nums[i]` using the Two Sum: One-pass Hash Table approach, we ensure that the sum of the pivot element (`nums[i]`) and the pair (`-nums[i]`) equals zero.

### Finding Complements

To achieve this, we process each element `nums[j]` to the right of the pivot and check if the complement `-nums[i] - nums[j]` is already in the hash set. If it is, we have found a triplet. We then add `nums[j]` to the hash set so it can be used as a complement in subsequent checks.

### Steps:

1. **Sort the Array**: Sorting helps in skipping duplicate values and simplifies the two-pointer approach.
2. **Pivot Element**: Iterate through the array, treating each element `nums[i]` as a pivot.
3. **Two Sum with HashSet**: For each pivot, find pairs to its right whose sum equals `-nums[i]` using a hash set.

### Detailed Approach:

1. **Sort the Array**: This helps in avoiding duplicates and makes it easier to use two pointers.
2. **Iterate through the Array**: For each element `nums[i]`, use two pointers to find pairs that sum up to `-nums[i]`.
3. **Use a HashSet**: This helps in avoiding duplicate triplets.

