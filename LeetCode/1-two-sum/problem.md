# 1. Two Sum

<div><p>Given an array of integers <code>nums</code>&nbsp;and an integer <code>target</code>, return <em>indices of the two numbers such that they add up to <code>target</code></em>.</p>

<p>You may assume that each input would have <strong><em>exactly</em> one solution</strong>, and you may not use the <em>same</em> element twice.</p>

<p>You can return the answer in any order.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> nums = [2,7,11,15], target = 9
<strong>Output:</strong> [0,1]
<strong>Explanation:</strong> Because nums[0] + nums[1] == 9, we return [0, 1].
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> nums = [3,2,4], target = 6
<strong>Output:</strong> [1,2]
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> nums = [3,3], target = 6
<strong>Output:</strong> [0,1]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>2 &lt;= nums.length &lt;= 10<sup>4</sup></code></li>
	<li><code>-10<sup>9</sup> &lt;= nums[i] &lt;= 10<sup>9</sup></code></li>
	<li><code>-10<sup>9</sup> &lt;= target &lt;= 10<sup>9</sup></code></li>
	<li><strong>Only one valid answer exists.</strong></li>
</ul>

<p>&nbsp;</p>
<strong>Follow-up:&nbsp;</strong>Can you come up with an algorithm that is less than <code>O(n<sup>2</sup>)</code><font face="monospace">&nbsp;</font>time complexity?</div>

<br>

---

# Solution
-[Brute Force Approach](#brute-force-approach)
  - **Time Complexity**: `O(n^2)`

## Solution Overview

Let's breakdown the problem. Analyze the key points:

- Output: indices / indexes of the two numbers in `nums` that sum to target
  - Exactly one solution, no need to worry whether solution does not exist
- Same element not used twice

In short, we are looking for the two addends that sum up to target.

Next, we ask ourselves what do we need? Usually we think of a data structure or algorithm here.

In this case it needs to store two types: `number`, `number`.

Immediately we can think of entries, or a pair of values. What takes in entries? Well a `Map` abstract data type. We can narrow this down for further performance with amortized `O(1)` get runtime with a `HashMap`.

Here's the algorithm:
1. Create a `HashMap<int, int>`
2. Iterate through array
3. At that index, find the difference between the `target` number and number at index
4. Check if map has the difference
   1. If it has the difference, return an array containing the index where the difference is found and `i` the current index
   2. Otherwise, set the entry for the value of the number and its current index `[nums[i], i]` in the map

### Note about complement

In this context, the term "complement" refers to the value needed to reach a certain target sum when combined with another value. It's not about the arithmetic "difference" between two numbers, but rather about finding the missing piece that completes a specific requirement.

Here, `complement = target - nums[i]` is the number that, when added to `nums[i]`, equals the `target`. If this complement exists in the map, it means you have found two numbers that add up to the target.

So, it's called "complement" because it's the value that complements `nums[i]` to meet the target sum.

Now for the implementations and key explanations:

## **Java**

```java
import java.util.HashMap;
import java.util.Map;

class Solution {
  /**
   * Given an array of integers nums and an integer target, return indices of 
   * the two numbers such that they add up to target.
   * 
   * Assumes: that each input would have exactly one solution, and you may not
   * use the same element twice.
   * 
   * You can return the answer in any order.
   * @param nums - array of integers
   * @param target - the sum that two numbers in the array should add up to
   * @return An array of indices of the two numbers within the array that add
   * up to target
   */
  public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < nums.length; i++) {
      int complement = target - nums[i];
      if (map.containsKey(complement)) {
          return new int[]{map.get(complement), i};
      }
      map.put(nums[i], i);
    }

    // No valid pair found
    return new int[0];
  }
}
```

## TypeScript

```ts
/**
 * Finds two numbers in the given array that add up to the specified target.
 * Assumes that each input would have exactly one solution, and you may not
 * use the same element twice.
 *
 * @param nums - An array of integers.
 * @param target - The sum that two numbers in the array should add up to.
 * @returns An array of indices of the two numbers within the array that add
 * up to the target, or an empty array if no valid pair exists.
 */
function twoSum(nums: number[], target: number): number[] {
  const map = new Map<number, number>();

  for (let i = 0; i < nums.length; i++) {
    const complement = target - nums[i];

    if (map.has(complement)) {
      return [map.get(complement)!, i];
    }

    map.set(nums[i], i);
  }

  // No valid pair found
  return [];
}
```

Key points:

**Where are the HashMaps in TypeScript?**

- In **TypeScript**, the built-in `Map` is an interface that defines how key-value pairs can be used. The `Map` class serves as a hashmap by providing methods to insert, retrieve, and delete items based on keys.
- The JavaScript specification has requirements for the `Map` interface such that it could be represented internally as a **hash table** (with O(1) lookup). See [Map - MDN](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Map)


[**Non-Null Assertion Operator**](https://www.typescriptlang.org/docs/handbook/2/everyday-types.html#non-null-assertion-operator-postfix-)

The exclamation mark (`!`) in `map.get(complement)!` is called the **non-null assertion operator**. It's used to tell TypeScript that we are certain that the value returned by `map.get(complement)` will not be `null` or `undefined`.

Here's why we need it in this context:

1. **TypeScript and Nullability:**
   - TypeScript is a statically typed language that helps catch potential runtime errors during development.
   - When we call `map.get(complement)`, TypeScript infers that the return type could be either the value associated with the key or `undefined` (if the key is not found in the map).

2. **Guaranteed Non-Null Value:**
   - In our specific scenario, we know that the key `complement` exists in the map because we've already checked it using `map.has(complement)`.
   - Therefore, we can safely assert that the value returned by `map.get(complement)` will not be `null` or `undefined`.

3. **Using the Non-Null Assertion Operator:**
   - By adding `!` after `map.get(complement)`, we tell TypeScript to treat the value as non-nullable.
   - If, by any chance, the key was not found (which shouldn't happen in our case), TypeScript would throw a runtime error.

In summary, the non-null assertion operator allows us to express our confidence that the value will indeed be present, avoiding unnecessary null checks in the code.

# Brute Force Approach

## **Intuition**

The brute force approach involves iterating through each element `x` in the array and searching for another value that equals `target - x`, which we call the **complement**.

In this context, the term "complement" refers to the value needed to reach a certain target sum when combined with another value. It's not about the arithmetic "difference" between two numbers, but rather about finding the missing piece that completes a specific requirement.

Here, `complement = target - nums[i]` is the number that, when added to `nums[i]`, equals the target. If this complement exists in our data structure, it means we have found two numbers that add up to the target.

So, it's called "complement" because it's the value that complements `nums[i]` to meet the target sum.

### Additional Notes

- **Nested Loops:** The brute force method leverages two nested loops to compare each element with every other element. This ensures that every possible pair is considered.
- **Time Complexity:** The time complexity of this approach is `O(n^2)` since for each element in the array, we potentially scan through all other elements.
- **Space Complexity:** The space complexity is `O(1)` because no additional data structures are used that grow with the input size.
- **Limitations:** While this approach guarantees finding a solution (if one exists), it is inefficient for large input sizes due to its quadratic time complexity.

## **Algorithm**

1. **Initialize**:
   - Create an empty array or list to store the indices of the numbers that sum up to the target.

2. **Iterate through the array**:
   - Use a nested loop to iterate through each element in the array. The outer loop runs from the first element to the second-to-last element, and the inner loop runs from the element next to the outer loop's current element to the last element.

3. **Check for complement**:
   - Inside the inner loop, check if the sum of the current element (from the outer loop) and the current element (from the inner loop) equals the target.

4. **Store result**:
   - If the sum equals the target, store the indices of the two elements in the array or list initialized in step 1.

5. **Return result**:
   - Once the loops complete, return the array or list containing the indices of the two numbers that add up to the target.

### Pseudocode

Here's what the algorithm looks like in pseudocode:

```plaintext
function twoSum(nums, target):
    for i from 0 to length(nums) - 1:
        for j from i + 1 to length(nums):
            if nums[i] + nums[j] == target:
                return [i, j]
    return []
```

