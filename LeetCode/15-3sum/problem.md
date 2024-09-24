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