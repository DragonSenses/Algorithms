# 169. Majority Element

<p>Given an array <code>nums</code> of size <code>n</code>, return <em>the majority element</em>.</p>

<p>The majority element is the element that appears more than <code>⌊n / 2⌋</code> times. You may assume that the majority element always exists in the array.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<pre><strong>Input:</strong> nums = [3,2,3]
<strong>Output:</strong> 3
</pre><p><strong class="example">Example 2:</strong></p>
<pre><strong>Input:</strong> nums = [2,2,1,1,1,2,2]
<strong>Output:</strong> 2
</pre>
<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
  <li><code>n == nums.length</code></li>
  <li><code>1 &lt;= n &lt;= 5 * 10<sup>4</sup></code></li>
  <li><code>-10<sup>9</sup> &lt;= nums[i] &lt;= 10<sup>9</sup></code></li>
  <li>The input is generated such that a majority element will exist in the array.</li>
</ul>

<p>&nbsp;</p>
<strong>Follow-up:</strong> Could you solve the problem in linear time and in <code>O(1)</code> space?

---

# Solution

- [Brute Force Approach](#brute-force-approach)
  - **Time Complexity**: `O(n^2)`
  - **Space Complexity**: `O(1)`
- [Hash Map Approach](#hash-map-approach)
  - **Time Complexity**: `O(n)`
  - **Space Complexity**: `O(n)`
- [Bitwise Manipulation Approach](#bitwise-manipulation-approach)

## **Problem Overview: Majority Element**

## Description

Given an array `nums` of size `n`, return the majority element.

The majority element is the element that appears more than `floor(n / 2)` times. You may assume that the majority element always exists in the array.

## Examples

**Example 1**  
Input: `nums = [3, 2, 3]`  
Output: `3`

**Example 2**  
Input: `nums = [2, 2, 1, 1, 1, 2, 2]`  
Output: `2`

## Constraints

- `n == nums.length`
- `1 <= n <= 5 * 10^4`
- `-10^9 <= nums[i] <= 10^9`
- The input is generated such that a majority element always exists.

## Follow-up

Can you solve the problem in linear time and in `O(1)` space?

# Brute Force Approach

## **Intuition**

To find the majority element, we can count the frequency of each element in the array. The element that appears more than `floor(n / 2)` times is guaranteed to exist, so we can return it once we find it.

## **Algorithm**

1. Iterate through each element in the array.
2. For each element, count how many times it appears in the entire array.
3. If its count exceeds `floor(n / 2)`, return that element.

This approach checks each element's frequency individually, resulting in a nested loop structure.

### **Pseudocode**

```plaintext
for each num in nums:
    count = 0
    for each elem in nums:
        if elem == num:
            count += 1
    if count > floor(n / 2):
        return num
```

## **Implementation**

### Java

```java
class Solution {
  public int majorityElement(int[] nums) {
    int n = nums.length;
    for (int i = 0; i < n; i++) {
      int count = 0;
      for (int j = 0; j < n; j++) {
        if (nums[j] == nums[i]) {
          count++;
        }
      }
      if (count > n / 2) {
        return nums[i];
      }
    }
    return -1; // Should never reach here due to problem constraints
  }
}
```

### TypeScript

```typescript
function majorityElement(nums: number[]): number {
  const n = nums.length;
  for (let i = 0; i < n; i++) {
    let count = 0;
    for (let j = 0; j < n; j++) {
      if (nums[j] === nums[i]) {
        count++;
      }
    }
    if (count > Math.floor(n / 2)) {
      return nums[i];
    }
  }
  return -1; // Should never reach here due to problem constraints
}
```

## **Complexity Analysis**

### **Assumptions**

- The input array `nums` contains at least one element.
- A majority element is guaranteed to exist.

### **Time Complexity**: `O(n^2)`
- **Nested Iteration**: For each element, we iterate through the entire array to count occurrences.
- **Worst-Case Scenario**: All elements are distinct until the majority element is found last.

### **Space Complexity**: `O(1)`
- **Constant-Space Usage**: The algorithm only uses a fixed number of variables (`count`, loop indices) regardless of input size.
- **No Additional Structures**: The input array is processed directly without requiring extra data structures, ensuring constant memory usage.

# Hash Map Approach

## **Intuition**

To identify the majority element, we can count the frequency of each number using a hash map. Since the majority element appears more than `floor(n / 2)` times, we can return the first number whose count exceeds this threshold during traversal.

## **Algorithm**

1. Initialize an empty hash map to store element frequencies.
2. Iterate through the array:
   - For each number, increment its count in the map.
   - If its count exceeds `floor(n / 2)`, return it immediately.
3. The problem guarantees that a majority element exists, so we will always find one.

### **Pseudocode**

```plaintext
### **Pseudocode**

initialize empty map: frequency_map

for each num in nums:
    if num not in frequency_map:
        frequency_map[num] = 1
    else:
        frequency_map[num] += 1

    if frequency_map[num] > floor(n / 2):
        return num
```


## **Implementation**

### Java

```java
import java.util.HashMap;

public class Solution {
  public int majorityElement(int[] nums) {
    HashMap<Integer, Integer> frequencyMap = new HashMap<>();
    int threshold = nums.length / 2;

    for (int num : nums) {
      int count = frequencyMap.getOrDefault(num, 0) + 1;
      frequencyMap.put(num, count);

      if (count > threshold) {
        return num;
      }
    }

    return -1; // Should never reach here due to problem constraints
  }
}
```

### TypeScript

```typescript
function majorityElement(nums: number[]): number {
  const frequencyMap = new Map<number, number>();
  const threshold = Math.floor(nums.length / 2);

  for (const num of nums) {
    const count = (frequencyMap.get(num) || 0) + 1;
    frequencyMap.set(num, count);

    if (count > threshold) {
      return num;
    }
  }

  return -1; // Should never reach here due to problem constraints
}
```

## **Complexity Analysis**

### **Assumptions**

- The input array `nums` contains at least one element.
- A majority element is guaranteed to exist.

### **Time Complexity**: `O(n)`
- **Single Pass**: We iterate through the array once, performing constant-time operations per element.
- **Hash Map Access**: Insertions and lookups in the hash map are amortized `O(1)`.

### **Space Complexity**: `O(n)`
- **Map Storage**: In the worst case, all elements are distinct until the majority element is found, requiring up to `n` entries in the map.
- **No In-Place Optimization**: Unlike Boyer-Moore, this approach uses additional memory proportional to input size.

# Bitwise Manipulation Approach

## **Intuition**

If a number appears more than `floor(n / 2)` times in an array of size `n`, then for each bit position (from 0 to 31), that bit must also be the majority at that position across all numbers. In other words, if we count how many numbers have a `1` at each bit position, and that count exceeds `n / 2`, then the majority element must also have a `1` at that bit.

By iterating through all 32 bit positions (since integers are 32-bit signed in Java), we can reconstruct the majority element bit by bit. For each bit position, we count how many numbers have that bit set. If the count exceeds `n / 2`, we set that bit in our result.

This approach leverages the fact that the majority element dominates the bitwise landscape of the array, allowing us to rebuild it without using extra space for frequency maps.

## **Example of Intuition**

Consider the array: `[5, 5, 5, 2, 2]`  
Binary representations:  
- `5` → `00000000 00000000 00000000 00000101`  
- `2` → `00000000 00000000 00000000 00000010`

Now count the number of `1`s at each bit position across all elements:

- Bit 0 (LSB): `5` has `1`, `2` has `0` → total `3` ones  
- Bit 1: `5` has `0`, `2` has `1` → total `2` ones  
- Bit 2: `5` has `1`, `2` has `0` → total `3` ones  
- All other bits: all zeros

Since `5` appears 3 times (more than `floor(5 / 2) = 2`), its bits dominate.  
At each bit position, the majority value (0 or 1) reflects the bit pattern of `5`.  
By reconstructing the majority bit at each position, we recover `5` as the majority element.

## **Algorithm**

1. Initialize `majority` to 0.
2. For each bit position `i` from 0 to 31:
   - Initialize `bitCount` to 0.
   - For each number in the array:
     - If the `i`-th bit of the number is set (`(num >> i) & 1 == 1`), increment `bitCount`.
   - If `bitCount > n / 2`, set the `i`-th bit in `majority` using `majority |= (1 << i)`.
3. Return `majority` as the reconstructed majority element.

### **Pseudocode**

```plaintext
initialize majority = 0
n = length of nums

for i from 0 to 31:
 bitCount = 0

 for each num in nums:
  if (num >> i) & 1 == 1:
   bitCount += 1

 if bitCount > n / 2:
  set i-th bit in majority: majority |= (1 << i)

return majority
```
