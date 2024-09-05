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

