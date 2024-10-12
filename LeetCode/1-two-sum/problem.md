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
-[Two Pass Hash Table](#two-pass-hash-table-approach)
  -**Time Complexity**: `O(n)`

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

### Best Case Example

Let's say `nums = [2, 7, 11, 15]` and `target = 9`.

1. **Iteration**:
   - i = 0, j = 1: nums[0] + nums[1] = 2 + 7 = 9 (matches target, return [0, 1])
   - If no match, continue iteration.

2. **Result**:
   - The result is `[0, 1]` because nums[0] + nums[1] equals the target.

### Worst Case Example

Let's say `nums = [1, 2, 3, 4, 5]` and `target = 10`.

1. **Iteration**:
   - i = 0, j = 1: nums[0] + nums[1] = 1 + 2 = 3 (no match, continue)
   - i = 0, j = 2: nums[0] + nums[2] = 1 + 3 = 4 (no match, continue)
   - i = 0, j = 3: nums[0] + nums[3] = 1 + 4 = 5 (no match, continue)
   - i = 0, j = 4: nums[0] + nums[4] = 1 + 5 = 6 (no match, continue)
   - i = 1, j = 2: nums[1] + nums[2] = 2 + 3 = 5 (no match, continue)
   - i = 1, j = 3: nums[1] + nums[3] = 2 + 4 = 6 (no match, continue)
   - i = 1, j = 4: nums[1] + nums[4] = 2 + 5 = 7 (no match, continue)
   - i = 2, j = 3: nums[2] + nums[3] = 3 + 4 = 7 (no match, continue)
   - i = 2, j = 4: nums[2] + nums[4] = 3 + 5 = 8 (no match, continue)
   - i = 3, j = 4: nums[3] + nums[4] = 4 + 5 = 9 (no match, continue)

2. **Result**:
   - No pair of numbers adds up to the target. Thus, the result is an empty array `[]`.

## **Implementation**

### Java

```java
/**
 * This class provides a solution to the Two Sum problem.
 */
class Solution {

  /**
   * Given an array of integers and a target integer, returns the indices of the
   * two numbers such that they add up to the target.
   *
   * Assumes: that each input has exactly one solution, and the same element
   * cannot be used twice.
   *
   * @param nums   An array of integers
   * @param target The target sum
   * @return An array of indices of the two numbers that add up to the target
   */
  public int[] twoSum(int[] nums, int target) {
    // Iterate through each element in the array
    for (int i = 0; i < nums.length; i++) {
      // For each element, iterate through the remaining elements
      for (int j = i + 1; j < nums.length; j++) {
        // Check if the sum of the two elements equals the target
        if (nums[j] == target - nums[i]) {
          // If the target is found, return their indices
          return new int[] { i, j };
        }
      }
    }
    // If no valid pair is found, return an empty array
    return new int[0];
  }
}
```

### TypeScript

```typescript
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
  // Iterate through each element in the array
  for (let i = 0; i < nums.length; i++) {
    // For each element, iterate through the remaining elements
    for (let j = i + 1; j < nums.length; j++) {
      // Check if the sum of the two elements equals the target
      if (nums[j] === target - nums[i]) {
        // If the target is found, return their indices
        return [i, j];
      }
    }
  }
  // If no valid pair is found, return an empty array
  return [];
}
```

## **Complexity Analysis**

Let \( n \) be the length of the input array.

### **Time Complexity**: \( O(n^2) \)

- **Outer and Inner Loops**: The outer loop runs \( n \) times, and for each iteration of the outer loop, the inner loop runs up to \( n - 1 \) times. This results in a nested loop with a time complexity of \( O(n^2) \).
- **Constant Operations**: Each iteration includes a constant time operation to calculate the complement and check the map, both of which are \( O(1) \) operations.

**Overall Complexity**: Summing these operations, the overall time complexity remains \( O(n^2) \).

### **Space Complexity**: \( O(1) \)

- **Constant Storage**: The space required does not depend on the size of the input array. No additional data structures are used that grow with the input size, thus the space complexity is \( O(1) \).

# Two-pass Hash Table Approach

## **Intuition**

To improve our runtime complexity, we need a more efficient way to check if the complement exists in the array and retrieve its index if it does. The best way to achieve this is by using a hash table. A hash table allows for fast lookup times, reducing the time complexity from `O(n)` to `O(1)` by trading space for speed.

A hash table is ideal for this purpose because it supports near-constant time lookups. "Near" in this conttext because collisions can cause lookups to degrade to `O(n)` time. However, as long as the hash function is well-designed, lookups should be amortized `O(1)` time.

### Detailed Explanation

1. **First Pass - Build the Hash Table**:
   - Traverse the array and insert each element along with its index into the hash table.
   - This creates a mapping of each element to its index, which will be useful for quick lookups in the next pass.

2. **Second Pass - Find Complements**:
   - Traverse the array again and for each element, calculate the complement needed to reach the target (`complement = target - nums[i]`).
   - Check if the complement exists in the hash table and ensure it’s not the same element by comparing indices.
   - If the complement is found, return the indices of the current element and its complement.

### Additional Notes

- **Time Complexity**: Building the hash table and looking up elements are both `O(n)` operations. Thus, the overall time complexity is `O(n)`.
- **Space Complexity**: The hash table requires extra space proportional to the size of the input array, resulting in `O(n)` space complexity.
- **Advantages**: This approach significantly reduces the time complexity compared to the brute force method, making it more efficient for larger datasets.

## **Algorithm**

A simple implementation uses two iterations. In the first iteration, we add each element's value as a key and its index as a value to the hash table. Then, in the second iteration, we check if each element's complement (`target - nums[i]`) exists in the hash table. If it does exist, we return current element's index and its complement's index. Beware that the complement must not be `nums[i]` itself!

1. **First Pass - Build the Hash Table**:
   - Traverse the array and insert each element along with its index into the hash table.
   - This creates a mapping of each element to its index, which will be useful for quick lookups in the next pass.

2. **Second Pass - Find Complements**:
   - Traverse the array again and for each element, calculate the complement needed to reach the target (`complement = target - nums[i]`).
   - Check if this complement exists in the hash table.
   - Ensure the complement is not the same as the current element by comparing their indices.
   - If the complement is found, return the indices of the current element and its complement.

3. **Return Result**:
   - If no pair is found that sums to the target, return an empty array.

### Pseudocode

```plaintext
function twoSum(nums, target):
    // Step 1: Initialize a hash table
    hashTable = {}

    // Step 2: First iteration to build the hash table
    for i from 0 to length(nums) - 1:
        hashTable[nums[i]] = i

    // Step 3: Second iteration to find complements
    for i from 0 to length(nums) - 1:
        complement = target - nums[i]
        if complement in hashTable and hashTable[complement] != i:
            return [i, hashTable[complement]]

    // Step 4: Return result if no pair is found
    return []
```

## **Implementation**

### Java

```java
import java.util.HashMap;
import java.util.Map;

class Solution {
  public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      map.put(nums[i], i);
    }
    for (int i = 0; i < nums.length; i++) {
      int complement = target - nums[i];
      if (map.containsKey(complement) && map.get(complement) != i) {
        return new int[] { i, map.get(complement) };
      }
    }
    // No valid pair found
    return new int[0];
  }
}
```

