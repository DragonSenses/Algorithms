# 75. Sort Colors

<p>Given an array <code>nums</code> with <code>n</code> objects colored red, white, or blue, sort them <strong><a href="https://en.wikipedia.org/wiki/In-place_algorithm" target="_blank">in-place</a> </strong>so that objects of the same color are adjacent, with the colors in the order red, white, and blue.</p>

<p>We will use the integers <code>0</code>, <code>1</code>, and <code>2</code> to represent the color red, white, and blue, respectively.</p>

<p>You must solve this problem without using the library's sort function.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> nums = [2,0,2,1,1,0]
<strong>Output:</strong> [0,0,1,1,2,2]
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> nums = [2,0,1]
<strong>Output:</strong> [0,1,2]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
  <li><code>n == nums.length</code></li>
  <li><code>1 &lt;= n &lt;= 300</code></li>
  <li><code>nums[i]</code> is either <code>0</code>, <code>1</code>, or <code>2</code>.</li>
</ul>

<p>&nbsp;</p>
<p><strong>Follow up:</strong>&nbsp;Could you come up with a one-pass algorithm using only&nbsp;constant extra space?</p>

<br>

---

# Solution

- [One-Pass Approach](#one-pass-approach)
  - **Time Complexity**: `O(n)`  

## Problem Overview

The problem is known as [Dutch National Flag Problem](https://en.wikipedia.org/wiki/Dutch_national_flag_problem) and first was proposed by [Edsger W. Dijkstra](https://en.wikipedia.org/wiki/Edsger_W._Dijkstra).

# One-Pass Approach

The goal is to attribute a color to each number and then to arrange them following the order of colors on the Dutch flag.

## **Intuition**

The Dutch National Flag problem requires sorting an array consisting of three distinct values (0, 1, and 2) in a single pass with constant space. This can be efficiently achieved using the Dutch National Flag algorithm, which is a variant of the three-way partitioning.

### Key Concepts

1. **Three Pointers**: We use three pointers to manage the sorting process:
    - **p0**: This pointer tracks the boundary for zeros (0).
    - **p2**: This pointer tracks the boundary for twos (2).
    - **curr**: This is the current pointer that iterates through the array.

2. **Invariants**:
    - All elements before `p0` are zeros (0).
    - All elements after `p2` are twos (2).
    - The elements between `p0` and `curr` are ones (1).

### Steps

1. **Initialization**:
    - Set `p0` to the start of the array.
    - Set `p2` to the end of the array.
    - Set `curr` to the start of the array.

2. **Traversal**:
    - Iterate through the array with `curr`, ensuring that elements are moved to their respective sections based on their value.
    - **If `nums[curr]` is 0**:
        - Swap `nums[curr]` with `nums[p0]`.
        - Increment both `p0` and `curr`.
    - **If `nums[curr]` is 2**:
        - Swap `nums[curr]` with `nums[p2]`.
        - Decrement `p2`.
    - **If `nums[curr]` is 1**:
        - Simply move the `curr` pointer to the next element.

### Visualization

Imagine you are sorting the colors in the Dutch national flag:

- **Initial State**: `nums = [2, 0, 2, 1, 1, 0]`, `p0 = 0`, `p2 = 5`, `curr = 0`
- **After processing the first element** (nums[curr] = 2): Swap with nums[p2], decrement p2, move curr to next.
- **Midway through**: `nums = [0, 0, 2, 1, 1, 2]`, `p0 = 1`, `p2 = 4`, `curr = 1`
- **Final State**: `nums = [0, 0, 1, 1, 2, 2]`, `p0 = 2`, `p2 = 3`, `curr = 5`

By maintaining these invariants and processing each element efficiently, we ensure the array is sorted in one pass with constant space.

## **Algorithm**

### Steps

1. **Initialization**:
   - Initialize `p0` to 0, representing the boundary for the red (0) section.
   - Initialize `p2` to `n - 1`, representing the boundary for the blue (2) section.
   - Initialize `curr` to 0, representing the current element being considered.

2. **Traverse and Sort**:
   - While `curr` is less than or equal to `p2`:
     - **If `nums[curr] == 0`**:
        - Swap `nums[curr]` with `nums[p0]`.
        - Increment both `p0` and `curr`.
     - **If `nums[curr] == 2`**:
        - Swap `nums[curr]` with `nums[p2]`.
        - Decrement `p2`.
     - **If `nums[curr] == 1`**:
        - Simply move `curr` to the next element.

## **Implementation**

### Java

```java
public class Solution {

  /**
   * Sorts the given array in-place so that objects of the same color are
   * adjacent, with the colors in the order red, white, and blue.
   *
   * @param nums The array of integers representing the colors.
   */
  public static void sortColors(int[] nums) {
    // Initialize pointers for boundaries
    int p0 = 0, curr = 0;
    int p2 = nums.length - 1;

    // Traverse the array
    while (curr <= p2) {
      if (nums[curr] == 0) {
        // Swap current element with the element at p0
        int temp = nums[p0];
        nums[p0] = nums[curr];
        nums[curr] = temp;
        p0++;
        curr++;
      } else if (nums[curr] == 2) {
        // Swap current element with the element at p2
        int temp = nums[p2];
        nums[p2] = nums[curr];
        nums[curr] = temp;
        p2--;
      } else {
        curr++;
      }
    }
  }
}
```

Using switch statement:

```java
public class Solution {

  /**
   * Sorts the given array in-place so that objects of the same color are
   * adjacent, with the colors in the order red, white, and blue.
   *
   * @param nums The array of integers representing the colors.
   */
  public static void sortColors(int[] nums) {
    // Initialize pointers for boundaries
    int p0 = 0, curr = 0;
    int p2 = nums.length - 1;

    // Traverse the array
    while (curr <= p2) {
      switch (nums[curr]) {
        case 0:
          // Swap current element with the element at p0
          int temp0 = nums[p0];
          nums[p0] = nums[curr];
          nums[curr] = temp0;
          p0++;
          curr++;
          break;
        case 2:
          // Swap current element with the element at p2
          int temp2 = nums[p2];
          nums[p2] = nums[curr];
          nums[curr] = temp2;
          p2--;
          break;
        default:
          curr++;
          break;
      }
    }
  }
}
```

### TypeScript

```typescript
/**
 * Sorts the given array in-place so that objects of the same color are adjacent,
 * with the colors in the order red, white, and blue.
 *
 * @param nums - The array of integers representing the colors (0, 1, 2).
 *               This function modifies the array in-place and does not return anything.
 */
function sortColors(nums: number[]): void {
  // Initialize pointers for boundaries
  let p0: number = 0;
  let curr: number = 0;
  let p2: number = nums.length - 1;

  // Traverse the array
  while (curr <= p2) {
    if (nums[curr] === 0) {
      // Swap current element with the element at p0
      [nums[curr], nums[p0]] = [nums[p0], nums[curr]];
      p0++;
      curr++;
    } else if (nums[curr] === 2) {
      // Swap current element with the element at p2
      [nums[curr], nums[p2]] = [nums[p2], nums[curr]];
      p2--;
    } else {
      curr++;
    }
  }
}
```



### **Time Complexity**: `O(n)`

- **Single-Pass**: The algorithm processes each element of the array exactly once. This linear pass is achieved using the `curr` pointer, which traverses the array from the start to the end, while the `p0` and `p2` pointers help partition the array into three sections (for 0s, 1s, and 2s). Thus, the time complexity is `O(n)`, where `n` is the number of elements in the array.

