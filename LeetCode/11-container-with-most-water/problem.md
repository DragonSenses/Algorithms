# Container With Most Water

You are given an integer array `height` of length `n`. There are n vertical lines drawn such that the two endpoints of the `ith` line are `(i, 0)` and `(i, height[i])`.

Find two lines that together with the x-axis form a container, such that the container contains the most water.

*Return the maximum amount of water a container can store.*

**Notice** that you may not slant the container.

#### Example 1:

![](img/1.jpg)

<pre>
Input: height = [1,8,6,2,5,4,8,3,7]

Output: 49

Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
</pre>

#### Example 2:

<pre>
Input: height = [1,1]

Output: 1
</pre>

#### Constraints:

- `n == height.length`
- `2 <= n <= 10^5`
- `0 <= height[i] <= 10^4`

### Overview

You have an array of integers called `height`, where each element represents the height of a vertical line drawn at that index. 

**Goal**: To find two lines that, along with the x-axis, form a container that can hold the maximum amount of water.

Using the shorten line as length and the distance between the lines as the width of the rectangle forming the area, we have to maximize the area that can be formed between both vertical lines.

#### Steps:

1. **Identify Two Lines**: Choose two lines from the array.
2. **Form a Container**: The container is formed by these two lines and the x-axis.
3. **Calculate Water Capacity**: The amount of water the container can hold is determined by the shorter of the two lines and the distance between them.

#### Constraints:

- You cannot tilt the container; it must be upright.
- The array length `n` is at least 2 and at most 100,000.
- Each height value is between 0 and 10,000.

#### Example:

For `height = [1, 8, 6, 2, 5, 4, 8, 3, 7]`, the maximum water container can hold is 49 units.

The two lines chosen are: `A[1]` = `8` and `A[8]` = `7`.

The area is `7` (height) * `7` (width).
  - height: Between `8` and `7` the shorter line length is `7`
  - width: The (array index) distance is `A[8] - A[1]` = `A[7]`, so `7` width

# Solution

For this problem we will solve it with these approaches:
  - [**Two Pointer**](#two-pointer)
    - Time complexity: `O(n)`

## Two Pointer

The idea is to use two pointers to scan the array from both ends towards the center, calculating the area of water that can be contained at each step and keeping track of the maximum area found.

### **Intuition**

- **Key Insight**: The area formed between two lines is always constrained by the height of the shorter line. Additionally, the farther apart the lines are, the larger the potential area.

- **Initial Consideration**: 
  - Start by considering the area formed by the outermost lines.

- **Maximizing Area**:
  - To maximize the area, focus on the lines with greater heights.
  - Moving the pointer at the longer line inward won't increase the area, as it remains limited by the shorter line.
  - However, moving the pointer at the shorter line inward can be beneficial despite the reduction in width.

- **Why Move the Shorter Line's Pointer**:
  - A taller line found by moving the shorter line's pointer might compensate for the reduced width.
  - This could potentially increase the area, overcoming the reduction caused by the decreased width.

### Algorithm

1. **Initialize Two Pointers**: 
   - `left` pointer at the beginning of the array (`index 0`).
   - `right` pointer at the end of the array (`index n-1`).

2. **Calculate Area**:
   - The width of the container is the distance between the two pointers: `width = right - left`.
   - The height of the container is the minimum of the heights at the two pointers: `height = min(height[left], height[right])`.
   - The area is then `area = width * height`.

3. **Update Maximum Area**:
   - Keep track of the maximum area found so far.

4. **Move Pointers**:
   - Move the pointer pointing to the shorter line inward. This is because the height of the container is limited by the shorter line, and moving the pointer might help find a taller line that can potentially form a larger area.
   - If `height[left] < height[right]`, increment the `left` pointer.
   - Otherwise, decrement the `right` pointer.

5. **Repeat**:
   - Continue this process until the two pointers meet.

#### Example:

Let's go through an example with `height = [1, 8, 6, 2, 5, 4, 8, 3, 7]`:

1. **Initial Pointers**: `left = 0`, `right = 8`
   - Calculate area: `width = 8 - 0 = 8`, `height = min(1, 7) = 1`, `area = 8 * 1 = 8`
   - Move `left` pointer to 1 (since `height[0] < height[8]`).

2. **New Pointers**: `left = 1`, `right = 8`
   - Calculate area: `width = 8 - 1 = 7`, `height = min(8, 7) = 7`, `area = 7 * 7 = 49`
   - Move `right` pointer to 7 (since `height[1] > height[8]`).

3. **Continue**:
   - Repeat the process, updating the maximum area found and moving the pointers inward based on the heights.

