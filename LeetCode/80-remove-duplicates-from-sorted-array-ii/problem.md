# 80. Remove Duplicates from Sorted Array II

<p>Given an integer array <code>nums</code> sorted in <strong>non-decreasing order</strong>, remove some duplicates <a href="https://en.wikipedia.org/wiki/In-place_algorithm" target="_blank"><strong>in-place</strong></a> such that each unique element appears <strong>at most twice</strong>. The <strong>relative order</strong> of the elements should be kept the <strong>same</strong>.</p>

<p>Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the <strong>first part</strong> of the array <code>nums</code>. More formally, if there are <code>k</code> elements after removing the duplicates, then the first <code>k</code> elements of <code>nums</code>&nbsp;should hold the final result. It does not matter what you leave beyond the first&nbsp;<code>k</code>&nbsp;elements.</p>

<p>Return <code>k</code><em> after placing the final result in the first </em><code>k</code><em> slots of </em><code>nums</code>.</p>

<p>Do <strong>not</strong> allocate extra space for another array. You must do this by <strong>modifying the input array <a href="https://en.wikipedia.org/wiki/In-place_algorithm" target="_blank">in-place</a></strong> with O(1) extra memory.</p>

<p><strong>Custom Judge:</strong></p>

<p>The judge will test your solution with the following code:</p>

<pre>int[] nums = [...]; // Input array
int[] expectedNums = [...]; // The expected answer with correct length

int k = removeDuplicates(nums); // Calls your implementation

assert k == expectedNums.length;
for (int i = 0; i &lt; k; i++) {
    assert nums[i] == expectedNums[i];
}
</pre>

<p>If all assertions pass, then your solution will be <strong>accepted</strong>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> nums = [1,1,1,2,2,3]
<strong>Output:</strong> 5, nums = [1,1,2,2,3,_]
<strong>Explanation:</strong> Your function should return k = 5, with the first five elements of nums being 1, 1, 2, 2 and 3 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> nums = [0,0,1,1,1,1,2,3,3]
<strong>Output:</strong> 7, nums = [0,0,1,1,2,3,3,_,_]
<strong>Explanation:</strong> Your function should return k = 7, with the first seven elements of nums being 0, 0, 1, 1, 2, 3 and 3 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
  <li><code>1 &lt;= nums.length &lt;= 3 * 10<sup>4</sup></code></li>
  <li><code>-10<sup>4</sup> &lt;= nums[i] &lt;= 10<sup>4</sup></code></li>
  <li><code>nums</code> is sorted in <strong>non-decreasing</strong> order.</li>
</ul>

---

# Solution

- [In-Place Overwrite Approach](#in-place-overwrite-approach)

### Problem Overview
**Problem Name:** Remove Duplicates from Sorted Array II

**Goal:**
- Given an integer array `nums` sorted in non-decreasing order, modify the array in-place such that each unique element appears at most twice. 
- The relative order of the elements should be kept the same.
- The result should be placed in the first part of the array `nums`.

**Requirements:**
- You cannot allocate extra space for another array.
- Modify the input array in-place with O(1) extra memory.

**Output:**
- Return `k` after placing the final result in the first `k` slots of `nums`.

**Explanation:**
- If there are `k` elements after removing the duplicates, then the first `k` elements of `nums` should hold the final result.
- It does not matter what is left beyond the first `k` elements.

**Constraints:**
- `1 <= nums.length <= 30,000`
- `-10,000 <= nums[i] <= 10,000`
- `nums` is sorted in non-decreasing order.

### Examples

**Example 1:**
- **Input:** `nums = [1,1,1,2,2,3]`
- **Output:** `5, nums = [1,1,2,2,3,_]`
- **Explanation:** The function should return `k = 5`, with the first five elements of `nums` being `1, 1, 2, 2, 3` respectively. The underscores represent the elements beyond `k` which do not matter.

**Example 2:**
- **Input:** `nums = [0,0,1,1,1,1,2,3,3]`
- **Output:** `7, nums = [0,0,1,1,2,3,3,_,_]`
- **Explanation:** The function should return `k = 7`, with the first seven elements of `nums` being `0, 0, 1, 1, 2, 3, 3` respectively. The underscores represent the elements beyond `k` which do not matter.

The solution requires ensuring that no element appears more than twice while maintaining the order of elements in the array.

# In-Place Overwrite Approach

## **Intuition**

The need to return the new length of the array as indicated by the problem statement hints at an interesting perspective: rather than focusing on removing elements, we can achieve our goal by overwriting unwanted duplicates directly within the array.

This means that, for each element that appears more than twice, we'll replace the extra occurrences with elements that come afterward while preserving the order of unique elements.

To efficiently achieve this, we will use a two-pointer technique:
- One pointer will traverse through each element in the original array.
- The other pointer will track the next available slot for an element, ensuring that no more than two duplicates remain.

This ensures that we keep the desired elements up to the required length while efficiently managing space within the array.

## **Approach:**

1. **Initialize Two Pointers:**
   - The first pointer iterates over the array to examine each element.
   - The second pointer points to the next position in the array that can be overwritten or replaced.

2. **Iterate Through the Array:**
   - Move the first pointer through each element in the array.
   - Track the count of each element.

3. **Overwrite Unwanted Duplicates:**
   - If an element has already appeared twice, skip adding it to the result.
   - If an element appears fewer than or equal to twice, overwrite the position indicated by the second pointer and increment the pointer.

4. **Return the Updated Length:**
   - The second pointer will give us the final length of the array after in-place modification.

### **Example**:

**Input:** `nums = [0,0,1,1,1,1,2,3,3]`
**Expected Output:** `k = 7, nums = [0,0,1,1,2,3,3,_,_]`

#### Steps:

1. **Initialization:**
   - Initialize pointers: `i = 1`, `j = 1`
   - Initialize `count = 1` (since the first element `nums[0]` is always counted once)

2. **First Iteration (i = 1):**
   - Current element: `nums[1] = 0`
   - Since `nums[1] == nums[0]`, increment `count` to `2`.
   - Since `count <= 2`, copy `nums[1]` to `nums[j]` (which is the same value at this step).
   - Increment `j` to `2`.

3. **Second Iteration (i = 2):**
   - Current element: `nums[2] = 1`
   - Since `nums[2] != nums[1]`, reset `count` to `1`.
   - Copy `nums[2]` to `nums[j]` (overwrite).
   - Increment `j` to `3`.

4. **Third Iteration (i = 3):**
   - Current element: `nums[3] = 1`
   - Since `nums[3] == nums[2]`, increment `count` to `2`.
   - Since `count <= 2`, copy `nums[3]` to `nums[j]` (which is the same value at this step).
   - Increment `j` to `4`.

5. **Fourth Iteration (i = 4):**
   - Current element: `nums[4] = 1`
   - Since `nums[4] == nums[3]`, increment `count` to `3`.
   - Since `count > 2`, move to the next element without incrementing `j`.

6. **Fifth Iteration (i = 5):**
   - Current element: `nums[5] = 1`
   - Since `nums[5] == nums[4]`, `count` remains `3`.
   - Since `count > 2`, move to the next element without incrementing `j`.

7. **Sixth Iteration (i = 6):**
   - Current element: `nums[6] = 2`
   - Since `nums[6] != nums[5]`, reset `count` to `1`.
   - Copy `nums[6]` to `nums[j]` (overwrite).
   - Increment `j` to `5`.

8. **Seventh Iteration (i = 7):**
   - Current element: `nums[7] = 3`
   - Since `nums[7] != nums[6]`, reset `count` to `1`.
   - Copy `nums[7]` to `nums[j]` (overwrite).
   - Increment `j` to `6`.

9. **Eighth Iteration (i = 8):**
   - Current element: `nums[8] = 3`
   - Since `nums[8] == nums[7]`, increment `count` to `2`.
   - Since `count <= 2`, copy `nums[8]` to `nums[j]`.
   - Increment `j` to `7`.

10. **End of Iteration:**
    - After processing all elements, `j = 7`, indicating the length of the modified array.

**Output:** `k = 7`, `nums = [0,0,1,1,2,3,3,_,_]`
- The underscores (`_`) represent the elements beyond the modified array length `k`, which can be ignored.

## **Algorithm**

### 1. **Initialize Pointers:**
   - Define two pointers, `i` and `j`. 
     - Pointer `i` iterates over the array to process each element one by one.
     - Pointer `j` keeps track of the next location in the array where an element can be overwritten.

### 2. **Track Element Count:**
   - Use a variable `count` to keep track of the number of occurrences of each element in the array.
     - The minimum count is always 1.

### 3. **Iterate Through the Array:**
   - Start with index `1` and process each element in the array one by one.

### 4. **Check for Duplicates:**
   - If the current element is the same as the previous element (`nums[i] == nums[i - 1]`), increment the count.
   - If the count exceeds `2` (i.e., `count > 2`), it indicates an unwanted duplicate.
     - In this case, simply move forward by incrementing `i` without modifying `j`.

### 5. **Overwrite Unwanted Duplicates:**
   - If the count is `<= 2`, move the element from index `i` to index `j`.
     - Increment `j` to indicate the next available slot for overwriting.

### 6. **Handle New Elements:**
   - If the current element is not the same as the previous element (`nums[i] != nums[i - 1]`):
     - Update `count = 1`.
     - Move the new element from index `i` to index `j`.

### 7. **Update Pointer `j`:**
   - Whenever a new element is copied to `nums[j]`, update the value of `j`.
     - `j` always points to the location where the next element can be copied to in the array.

### 8. **Return the Length:**
   - After processing all elements, the value of `j` will be the length of the new array with duplicates removed.
     - Return the value of `j` as the length of the modified array.

### **Pseudocode**

```pseudocode
initialize pointers i = 1, j = 1
initialize variable count = 1

while i < length of array
    if nums[i] == nums[i - 1]
        increment count by 1
    else
        set count to 1
    
    if count <= 2
        set nums[j] to nums[i]
        increment j by 1
    
    increment i by 1

return j
```

## **Implementation**

### Java

```java
public class Solution {
  public int removeDuplicates(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }
    return 0;
  }
}
```