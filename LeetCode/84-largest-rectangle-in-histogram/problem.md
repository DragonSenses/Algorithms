# 84. Largest Rectangle in Histogram

<p>Given an array of integers <code>heights</code> representing the histogram's bar height where the width of each bar is <code>1</code>, return <em>the area of the largest rectangle in the histogram</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" style="width: 522px; height: 242px;" src="img/84-1.jpg">
<pre><strong>Input:</strong> heights = [2,1,5,6,2,3]
<strong>Output:</strong> 10
<strong>Explanation:</strong> The above is a histogram where width of each bar is 1.
The largest rectangle is shown in the red area, which has an area = 10 units.
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" style="width: 202px; height: 362px;" src="img/84-2.jpg">
<pre><strong>Input:</strong> heights = [2,4]
<strong>Output:</strong> 4
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
  <li><code>1 &lt;= heights.length &lt;= 10<sup>5</sup></code></li>
  <li><code>0 &lt;= heights[i] &lt;= 10<sup>4</sup></code></li>
</ul>

---

# Solution

- [Brute Force (Naive) Approach](#brute-force-naive-approach)
  - **Time Complexity**: `O(n^2)`
  - **Space Complexity**: `O(1)`
- [Stack (Optimized) Approach](#stack-optimized-approach)

### **Problem Overview: Largest Rectangle in Histogram**  

#### **Description**  
Given an array of integers `heights` representing the **heights of histogram bars**, where each bar has a **fixed width of 1**, determine the **largest rectangular area** that can be formed within the histogram.  

#### **Examples**  
**Example 1:**  
- **Input:** `heights = [2,1,5,6,2,3]`  
- **Output:** `10`  
- **Explanation:** The largest rectangle is formed by bars at indices `[2,3]` (heights `5,6`), covering `width = 2` and `height = 5`, giving an **area = 10 units**.  

**Example 2:**  
- **Input:** `heights = [2,4]`  
- **Output:** `4`  
- **Explanation:** The rectangle spans **one bar** with a height of `4`, yielding an **area = 4 units**.  

#### **Constraints**  
- `1 <= heights.length <= 100,000`  
- `0 <= heights[i] <= 10,000`  

### **Goal**  
The problem requires finding the **largest rectangular area** that can be formed in a histogram where:
- Each **bar's width** is **1 unit**.
- The heights are given as an **array of integers**.

### **Key Insights:**  
1. **Brute Force Approach:**  
   - Consider every possible rectangle.
   - Compute the area for each.
   - Results in **O(n^2) time complexity** (inefficient for large inputs).  

2. **Stack-Based Optimization:**  
   - **Monotonic Stack** can help efficiently track left and right boundaries.
   - Allows **constant-time height retrieval** while maintaining **sorted order**.
   - Achieves **O(N) time complexity**, improving performance significantly.

### **Algorithm Strategy:**  
1. **Iterate over the bars** while maintaining a **monotonic stack**.  
2. **When a decreasing bar is encountered**, pop from the stack to determine the largest rectangle that can be formed with the removed bar.  
3. **Calculate areas dynamically** based on the popped height and its left-right boundaries.  
4. **Continue until all bars have been processed**, ensuring the largest possible area is captured.

# Brute Force (Naive) Approach

Starting with the **brute force approach** helps in understanding the problem thoroughly and serves as a foundation for optimized solutions. While simple, becomes inefficient for larger histograms due to its **quadratic time complexity**.

## **Intuition**

A key observation is that the **height of a rectangle**—formed between any two bars—will always be **limited by the shortest bar** lying between them.

![In a histogram, the minimum height of the rectangle is the same as the height of the shortest bar](img/84-3.jpg)

Thus, to determine the **maximum rectangular area**, we:
1. **Consider every possible pair of bars** in the histogram.
2. **Identify the shortest bar** between them (as it constrains the height).
3. **Compute the area of the rectangle** formed by using:
   - **Height** = Minimum bar height within the range.
   - **Width** = Distance between the two bars.
4. Track the **maximum area** encountered during the iterations.

### Initial Implementation: Brute Force

```java
class Solution {
  public int largestRectangleArea(int[] heights) {
    int maxArea = 0;
    int n = heights.length;

    // Iterate over all possible starting bars
    for (int i = 0; i < n; i++) {
      for (int j = i; j < n; j++) {
        int minHeight = Integer.MAX_VALUE; // Start with maximum possible value

        // Find the minimum height within the range [i, j]
        for (int k = i; k <= j; k++) {
          minHeight = Math.min(minHeight, heights[k]);
        }

        // Compute the rectangle's area and update maxArea
        int width = j - i + 1;
        maxArea = Math.max(maxArea, minHeight * width);
      }
    }

    return maxArea;
  }
}
```

However this leads to the a quadratic time complexity of `O(n^3)` as it uses **three nested for loops** to find the minimum height bar `O(n)` lying between every pair `O(n^2)`.

### **Optimizing the Brute Force Solution**  

We can improve the brute force approach by reducing redundant computations. Instead of evaluating every possible pair and recalculating the **minimum height** for each range from scratch, we can **track the minimum height dynamically** as we expand the rectangle.  

Rather than recomputing the smallest bar within each new range, we **reuse the previous minimum height** and update it using the current bar’s height: `minheight = min(minheight, heights(j))`

\[
\text{minHeight} = \min(\text{minHeight}, \text{heights}[j])
\]

where `heights[j]` represents the height of the `jth` bar in the expansion.  

This eliminates redundant calculations and makes the brute force approach more efficient while maintaining its `O(n^2)` complexity.  

## **Algorithm**

1. **Initialize `maxArea = 0`** to store the largest rectangle found.  
2. **Loop through each bar index `i`** as the potential **starting point**:  
   - Set `minHeight = heights[i]` (initial height for the range).  
   - Expand the rectangle to **each ending index `j ≥ i`**:  
     - **Update `minHeight = Math.min(minHeight, heights[j])`**.  
     - **Calculate area using:**  
       \[
       \text{Area} = \text{minHeight} \times (\text{j} - \text{i} + 1)
       \]
     - **Update `maxArea`** if this area is larger.  
3. **Return `maxArea`** after all iterations.  

## **Implementation**

### Java

```java
public class Solution {
  public int largestRectangleArea(int[] heights) {
    int maxArea = 0;
    int n = heights.length;

    // Iterate over all possible starting bars
    for (int i = 0; i < n; i++) {
      int minHeight = heights[i];

      // Expand the rectangle by iterating over possible ending bars
      for (int j = i; j < n; j++) {
        minHeight = Math.min(minHeight, heights[j]); // Maintain minimum height in range
        int width = j - i + 1; // Calculate width
        maxArea = Math.max(maxArea, minHeight * width); // Compute and track maximum area
      }
    }

    return maxArea;
  }
}
```

### TypeScript

```typescript
function largestRectangleArea(heights: number[]): number {
  let maxArea = 0;
  let n = heights.length;

  // Iterate over all possible starting bars
  for (let i = 0; i < n; i++) {
    let minHeight = heights[i];

    // Expand the rectangle by iterating over possible ending bars
    for (let j = i; j < n; j++) {
      // Maintain minimum height in range
      minHeight = Math.min(minHeight, heights[j]); 

      let width = j - i + 1; // Calculate width

      // Compute and track maximum area
      maxArea = Math.max(maxArea, minHeight * width); 
    }
  }
  
  return maxArea;
};
```

## **Complexity Analysis**

### **Assumptions**
- The brute force approach considers **every possible rectangle** in the histogram.
- The algorithm maintains a **tracking variable** for the minimum height across a given range.

### **Time Complexity: `O(n^2)`**  
The complexity **is quadratic (`O(n^2)`)**, because:
1. **Outer loop (`i` runs from `0` to `n-1`)** → `O(n)`
2. **Inner loop (`j` runs from `i` to `n-1`)** → `O(n)`
3. **Finding the minimum height** within `i → j` occurs in `O(1)`, since it updates dynamically.

Thus, the total operations roughly follow **nested loops**, leading to **O(n^2) time complexity**.

### **Space Complexity: `O(1)`**  
- **Constant-space usage**:  
  - The algorithm **only uses a few scalar variables** (`maxArea`, `minHeight`, `width`).
  - No additional data structures (arrays, lists, or stacks) are allocated.
- **No extra memory is needed** beyond the input array.

# **Stack (Optimized) Approach**  

#### **Overview**  
This approach leverages a **monotonic increasing stack** to efficiently determine the boundaries where each histogram bar **begins and ends** in forming the largest rectangle. By **tracking indices** instead of recalculating heights redundantly, we significantly improve performance.

#### **Monotonic**

In this context, **monotonic** refers to a property where a sequence maintains a consistent order—either **increasing** or **decreasing**—without reversing direction.  

For the **monotonic stack approach**:  
- We maintain a **monotonic increasing stack**, meaning that the values (bar heights) are stored in **ascending order**.  
- When a **smaller bar** appears, we **pop from the stack**, ensuring that we process previous taller bars efficiently before handling the new one.  

### **Why Use a Monotonic Stack?**  
- It helps efficiently track **left and right boundaries** of rectangles.  
- It ensures **each element is pushed and popped only once**, leading to **O(n) time complexity**.  
- Avoids unnecessary rechecking of heights, reducing redundant calculations.  

## **Intuition**

The brute force approach is inefficient because it repeatedly recalculates **minimum heights** for overlapping subarrays. The **monotonic stack** approach optimizes this by efficiently tracking the **boundaries where each bar can extend**.  

### **Key Observations**
1. **Each bar contributes to the largest rectangle where it is the shortest bar.**  
   - Instead of evaluating all pairs, we determine where a given bar **starts** and **ends** in forming the largest possible rectangle.  

2. **Using a stack helps track previous heights efficiently.**  
   - We maintain a **monotonic increasing stack** of indices representing **bars in sorted height order**.
   - When a bar **violates the order** (i.e., a shorter bar appears), we calculate the largest rectangle that the popped bar could contribute to.  

3. **Area Calculation Using Stack Logic**
   - Each popped bar represents the **height** of a rectangle.  
   - The width is determined by the **difference between the next smaller bar on the left and the current index**.  
   - This ensures **constant-time height retrieval** while reducing unnecessary recomputation.  

Thus, by **using a stack**, we efficiently determine where each bar **begins and ends**, allowing us to compute the largest rectangular area in **O(n) time complexity** instead of `O(n^2)`.  

## **Algorithm**  

#### **1. Initialize the stack**  
- Create an **empty stack** to store indices of histogram bars.  

#### **2. Process each bar in the histogram**  
- Iterate through the **array from left to right**, including an **extra iteration with a height of `0`** at the end.  
- Push indices onto the stack **as long as bars are increasing** (monotonic property).  
- If a **smaller height appears**, start **popping** to compute areas.  

#### **3. Compute rectangular areas while popping**  
- When a bar is **shorter** than the stack top:  
  - **Pop the top index** from the stack (`h = heights[stack.pop()]`).  
  - Compute **width** using:  
    - If the stack is empty: `width = i`  
    - Otherwise: `width = i - stack.peek() - 1`  
  - Compute **area = height × width** and update `maxArea`.  

#### **4. Final cleanup after full iteration**  
- Once all bars have been processed, **pop any remaining indices in the stack**, using the same width calculations.  
- Compute **width during cleanup** using:  
  - If the stack is empty: `width = heights.length`  
  - Otherwise: `width = heights.length - stack.peek() - 1`  
- **Return `maxArea`**, the largest rectangle found.  

## **Implementation**

### Java

```java
import java.util.Stack;

class Solution {
  public int largestRectangleArea(int[] heights) {
    Stack<Integer> stack = new Stack<>();
    int maxArea = 0;
    int n = heights.length;

    for (int i = 0; i < n; i++) {
      // Use 0 height for the imaginary right boundary
      int currentHeight = (i == n) ? 0 : heights[i];

      // Pop elements while the current bar is shorter than stack top
      while (!stack.isEmpty() && currentHeight < heights[stack.peek()]) {
        int h = heights[stack.pop()]; // Pop the top height
        int width = stack.isEmpty() ? i : (i - stack.peek() - 1); // Compute width
        maxArea = Math.max(maxArea, h * width);
      }

      stack.push(i); // Push current index onto the stack
    }

    return maxArea;
  }
}
```

### TypeScript

```ts
function largestRectangleArea(heights: number[]): number {
  const stack: number[] = []; // Monotonic increasing stack to store indices
  let maxArea = 0;
  const n = heights.length;

  for (let i = 0; i <= n; i++) {
    // Assign 0 height beyond the histogram for final cleanup
    const currentHeight = i === n ? 0 : heights[i];

    // Process stack while current bar is shorter than stack top
    while (
      stack.length > 0 &&
      currentHeight < heights[stack[stack.length - 1]]
    ) {
      const h = heights[stack.pop()!]; // Pop the top index and get the corresponding height
      const width = stack.length === 0 ? i : i - stack[stack.length - 1] - 1; // Compute width
      maxArea = Math.max(maxArea, h * width); // Update max area
    }

    stack.push(i); // Push current index onto the stack
  }

  return maxArea;
}
```
