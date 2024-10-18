# 18. 4Sum

<p>Given an array <code>nums</code> of <code>n</code> integers, return <em>an array of all the <strong>unique</strong> quadruplets</em> <code>[nums[a], nums[b], nums[c], nums[d]]</code> such that:</p>

<ul>
	<li><code>0 &lt;= a, b, c, d&nbsp;&lt; n</code></li>
	<li><code>a</code>, <code>b</code>, <code>c</code>, and <code>d</code> are <strong>distinct</strong>.</li>
	<li><code>nums[a] + nums[b] + nums[c] + nums[d] == target</code></li>
</ul>

<p>You may return the answer in <strong>any order</strong>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> nums = [1,0,-1,0,-2,2], target = 0
<strong>Output:</strong> [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> nums = [2,2,2,2,2], target = 8
<strong>Output:</strong> [[2,2,2,2]]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 200</code></li>
	<li><code>-10<sup>9</sup> &lt;= nums[i] &lt;= 10<sup>9</sup></code></li>
	<li><code>-10<sup>9</sup> &lt;= target &lt;= 10<sup>9</sup></code></li>
</ul>

<br>

---

# Solution
- [Two Pointers Approach](#two-pointers)
  - **Time Complexity**: `O(n^3)`. 
  - `O(n^{k-1})` for `kSum`, where `k = 4` for **4Sum**.

## 4Sum Problem Overview

### Follow-Up of 3Sum

4Sum and 3Sum are very similar; the difference is that we are looking for unique quadruplets instead of triplets.

### Wrapping Two Sum

3Sum essentially wraps Two Sum in an outer loop. As it iterates through each value `v`, it finds all pairs whose sum is equal to `target - v` using one of these approaches:
1. **Two Sum**: Uses a hash set to check for a matching value.
2. **Two Sum II**: Uses the two-pointers pattern in a sorted array.

### Extending to 4Sum

Following a similar logic, we can implement 4Sum by wrapping 3Sum in another loop.

### Generalizing to kSum

If asked to solve 4Sum, the interviewer might follow up with 5Sum, 6Sum, and so on. What they really expect is a `kSum` solution. Therefore, we will focus on a generalized implementation here.

# Two Pointers

## **Intuition**

The two pointers pattern requires the array to be sorted, so we do that first. Also, it's easier to deal with duplicates if the array is sorted: repeated values are next to each other and easy to skip.

For 3Sum, we enumerate each value in a single loop, and use the two pointers pattern for the rest of the array. For kSum, we will have `k - 2` nested loops to enumerate all combinations of `k - 2` values.

### Key Concept

The kSum problem can be generalized from the 2Sum and 3Sum problems. By understanding the pattern and extending it, we can create a solution that works for any kSum.

### Wrapping Two Sum

For the 3Sum problem, we wrap Two Sum in an outer loop. As we iterate through each value `v`, we find all pairs whose sum is equal to `target - v`. We can use:
1. **Two Sum with Hash Set**: Use a hash set to check for matching values.
2. **Two Sum II with Two Pointers**: Use the two-pointers technique in a sorted array.

### Generalizing to kSum

Following a similar logic, we can implement 4Sum by wrapping 3Sum in another loop. When asked for higher sums like 5Sum, 6Sum, etc., the interviewer expects a generalized kSum solution. Here’s how:

1. **Initialization**: Initialize the result list.
2. **Sorting**: Sort the input array `nums`.
3. **Recursive kSum Function**:
   - **Base Case**: If k equals 2, use the Two Sum approach.
   - **Recursive Case**: Iterate through the array, fixing one number and recursively finding the (k-1)Sum.
4. **Return the Results**: Collect and return the results from the recursive calls.

### Example and Walkthrough

**Input**: `nums = [1,0,-1,0,-2,2]`, `target = 0`

1. **Initialization**:
   - Result list: `[]`
2. **Sorting**:
   - Sorted `nums`: `[-2, -1, 0, 0, 1, 2]`
3. **Recursive Calls**:
   - **4Sum**: Iterate with the first number, then call 3Sum with the remaining array.
   - **3Sum**: Fix the second number, then call 2Sum.
   - **2Sum**: Use two pointers to find pairs that match the target.

## **Algorithm**

We can implement `k-2` loops using recursion. We will pass the starting point and `k` as the parameters. When `k == 2`, we will call `twoSum`, terminating the recursion.

### Main Function

1. **Sort the Input Array**:
   - Sort the input array `nums`.
2. **Call kSum**:
   - Call `kSum` with `start = 0`, `k = 4`, and `target`, and return the result.

### kSum Function

1. **Initial Checks**:
   - At the start of the `kSum` function, check three conditions:
     1. Have we run out of numbers to choose from?
     2. Is the smallest number remaining greater than `target / k`?
        - If so, then any `k` numbers we choose will be too large.
     3. Is the largest number remaining smaller than `target / k`?
        - If so, then any `k` numbers we choose will be too small.
   - If any of these conditions are true, there is no need to continue as no combination of the remaining elements can sum to `target`.

2. **Base Case**:
   - If `k` equals 2, call `twoSum` and return the result.

3. **Iterate Through the Array**:
   - Iterate `i` through the array from `start`:
     1. If the current value is the same as the one before, skip it.
     2. Recursively call `kSum` with `start = i + 1`, `k = k - 1`, and `target - nums[i]`.
     3. For each returned subset of values:
        - Include the current value `nums[i]` into the subset.
        - Add the subset to the result `res`.

4. **Return the Result**:
   - Return the result `res`.

### twoSum Function

1. **Initialize Pointers**:
   - Set the low pointer `lo` to `start`, and high pointer `hi` to the last index.

2. **While Loop**:
   - While the low pointer is smaller than high:
     1. If the sum of `nums[lo]` and `nums[hi]` is less than `target`, increment `lo`.
        - Also increment `lo` if the value is the same as for `lo - 1`.
     2. If the sum is greater than `target`, decrement `hi`.
        - Also decrement `hi` if the value is the same as for `hi + 1`.
     3. Otherwise, we found a pair:
        - Add it to the result `res`.
        - Decrement `hi` and increment `lo`.

3. **Return the Result**:
   - Return the result `res`.

## **Implementation**

**Note:** Handle the folowing edge cases:
  - Large Numbers
  - Negative Targets

### Java

- Implementation for `fourSum` with `kSum` function
  - It handles large integers and prevents overflow by using `long` data type for calculations.

fix(#18): Handle overflow in 4Sum implementation

Resolved an issue where the conditions `nums[start] * k > target` and `nums[nums.length - 1] * k < target` were incorrect for large values and negative targets. Updated to handle potential overflows more carefully.

```java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This class provides a solution to the kSum problem, specifically solving the 4Sum variant.
 */
public class Solution {

  /**
   * Finds all unique quadruplets in the array which sum up to the target.
   *
   * @param nums   - The input array of integers.
   * @param target - The target sum for the quadruplets.
   * @return A list of lists, where each list contains four integers that add up to the target.
   */
  public List<List<Integer>> fourSum(int[] nums, int target) {
    Arrays.sort(nums);
    return kSum(nums, (long) target, 4, 0);
  }

  /**
   * Finds all unique k-tuples in the array which sum up to the target.
   *
   * @param nums   - The input array of integers.
   * @param target - The target sum for the k-tuples.
   * @param k      - The number of elements in each tuple.
   * @param start  - The starting index in the array for the current kSum recursion.
   * @return A list of lists, where each list contains k integers that add up to the target.
   */
  private List<List<Integer>> kSum(int[] nums, long target, int k, int start) {
    List<List<Integer>> res = new ArrayList<>();

    // Base case: if start reaches the end of the array, return an empty list
    // Check if we have run out of numbers to choose from
    if (start == nums.length) {
      return res;
    }
    
    // Check for overflow and underflow
    if (k * (long) nums[start] > target || k * (long) nums[nums.length - 1] < target) {
      return res;
    }

    if (k == 2) {
      return twoSum(nums, target, start);
    }

    for (int i = start; i < nums.length; i++) {
      if (i > start && nums[i] == nums[i - 1]) continue;
      for (List<Integer> subset : kSum(nums, target - nums[i], k - 1, i + 1)) {
        res.add(new ArrayList<>(Arrays.asList(nums[i])));
        res.get(res.size() - 1).addAll(subset);
      }
    }

    return res;
  }

  /**
   * Finds all unique pairs in the array which sum up to the target.
   *
   * @param nums   - The input array of integers.
   * @param target - The target sum for the pairs.
   * @param start  - The starting index in the array for the current twoSum calculation.
   * @return A list of lists, where each list contains two integers that add up to the target.
   */
  private List<List<Integer>> twoSum(int[] nums, long target, int start) {
    List<List<Integer>> res = new ArrayList<>();
    int lo = start, hi = nums.length - 1;

    while (lo < hi) {
      long sum = (long) nums[lo] + nums[hi];
      if (sum == target) {
        res.add(Arrays.asList(nums[lo], nums[hi]));
        while (lo < hi && nums[lo] == nums[lo + 1]) lo++;
        while (lo < hi && nums[hi] == nums[hi - 1]) hi--;
        lo++;
        hi--;
      } else if (sum < target) {
        lo++;
      } else {
        hi--;
      }
    }

    return res;
  }
}
```

- Implementation for `fourSum` with `kSum` and `twoSum` functions

```java
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(nums, target, 0, 4);
    }

    public List<List<Integer>> kSum(int[] nums, long target, int start, int k) {
        List<List<Integer>> res = new ArrayList<>();

        // If we have run out of numbers to add, return res.
        if (start == nums.length) {
            return res;
        }

        // There are k remaining values to add to the sum. The
        // average of these values is at least target / k.
        long average_value = target / k;

        // We cannot obtain a sum of target if the smallest value
        // in nums is greater than target / k or if the largest
        // value in nums is smaller than target / k.
        if (
            nums[start] > average_value || average_value > nums[nums.length - 1]
        ) {
            return res;
        }

        if (k == 2) {
            return twoSum(nums, target, start);
        }

        for (int i = start; i < nums.length; ++i) {
            if (i == start || nums[i - 1] != nums[i]) {
                for (List<Integer> subset : kSum(
                    nums,
                    target - nums[i],
                    i + 1,
                    k - 1
                )) {
                    res.add(new ArrayList<>(Arrays.asList(nums[i])));
                    res.get(res.size() - 1).addAll(subset);
                }
            }
        }

        return res;
    }

    public List<List<Integer>> twoSum(int[] nums, long target, int start) {
        List<List<Integer>> res = new ArrayList<>();
        int lo = start, hi = nums.length - 1;

        while (lo < hi) {
            int currSum = nums[lo] + nums[hi];
            if (currSum < target || (lo > start && nums[lo] == nums[lo - 1])) {
                ++lo;
            } else if (
                currSum > target ||
                (hi < nums.length - 1 && nums[hi] == nums[hi + 1])
            ) {
                --hi;
            } else {
                res.add(Arrays.asList(nums[lo++], nums[hi--]));
            }
        }

        return res;
    }
}
```

### TypeScript

```typescript
function fourSum(nums: number[], target: number): number[][] {
  nums.sort((a, b) => a - b);
  return kSum(nums, target, 0, 4);
}

function kSum(
  nums: number[],
  target: number,
  start: number,
  k: number
): number[][] {
  let res: number[][] = [];
  // If we have run out of numbers to add, return res.
  if (start === nums.length) {
    return res;
  }
  // There are k remaining values to add to the sum. The
  // average of these values is at least target / k.
  let average_value = target / k;
  // We cannot obtain a sum of target if the smallest value
  // in nums is greater than target / k or if the largest
  // value in nums is smaller than target / k.
  if (nums[start] > average_value || average_value > nums[nums.length - 1]) {
    return res;
  }
  if (k === 2) {
    return twoSum(nums, target, start);
  }
  for (let i = start; i < nums.length; i++) {
    if (i === start || nums[i - 1] !== nums[i]) {
      for (let subset of kSum(nums, target - nums[i], i + 1, k - 1)) {
        res.push([nums[i], ...subset]);
      }
    }
  }
  return res;
}

function twoSum(nums: number[], target: number, start: number): number[][] {
  let res: number[][] = [];
  let lo: number = start,
    hi: number = nums.length - 1;
  while (lo < hi) {
    let curr_sum: number = nums[lo] + nums[hi];
    if (curr_sum < target || (lo > start && nums[lo] === nums[lo - 1])) {
      ++lo;
    } else if (
      curr_sum > target ||
      (hi < nums.length - 1 && nums[hi] === nums[hi + 1])
    ) {
      --hi;
    } else {
      res.push([nums[lo++], nums[hi--]]);
    }
  }
  return res;
}
```

## **Complexity Analysis**

### **Time Complexity**: \( O(n^3) \) for **4Sum**, \( O(n^{k-1}) \) for **kSum**

- **Outer and Inner Loops**: For 4Sum, we have `k-2` loops. The outer loop iterates through \( n \) elements, and for each iteration, the inner loops also iterate through \( n \) elements, resulting in \( O(n^{k-1}) \). Specifically for 4Sum, this translates to \( O(n^3) \). `twoSum` is `O(n)`.
- **Sorting the Array**: Sorting the array with `Arrays.sort()` has a time complexity of \( O(n \log n) \).     
  - **Note** that for `k > 2`, sorting the array does not change the overall time complexity.
- **Overall Complexity**: Combining these operations, the overall time complexity is dominated by the nested loops, giving us \( O(n^{k-1}) \). i.e., `O(n^3)` for **4Sum** since `k = 4` and we have `k - 2` nested loops to enumerate all combinations of `k - 2` values.

### **Space Complexity**: \( O(n) \)

- **Recursion Stack**: We need \( O(k) \) space for the recursion stack. For the generalized algorithm, `k` can be the same as \( n \) in the worst case.
- **Sorting Algorithm**: Depending on the implementation of the sorting algorithm, as for Java's `Arrays.sort()`, it uses a dual-pivot Quicksort for primitive types with a space complexity of \( O(\log n) \) due to the recursive nature of Quicksort, and Timsort for objects with a space complexity of \( O(n) \) due to the additional memory for temporary arrays.

In summary, the complexity analysis for the two pointer approach is:

- **Time Complexity**: \( O(n^{k-1}) \) or \( O(n^3) \) for 4Sum
- **Space Complexity**: \( O(n) \)
