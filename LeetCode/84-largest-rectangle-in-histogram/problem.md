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

### **Key Insights:**  
1. **Brute Force Approach:**  
   - Consider every possible rectangle.
   - Compute the area for each.
   - Results in **O(N²) time complexity** (inefficient for large inputs).  

2. **Stack-Based Optimization:**  
   - **Monotonic Stack** can help efficiently track left and right boundaries.
   - Allows **constant-time height retrieval** while maintaining **sorted order**.
   - Achieves **O(N) time complexity**, improving performance significantly.

### **Algorithm Strategy:**  
1. **Iterate over the bars** while maintaining a **monotonic stack**.  
2. **When a decreasing bar is encountered**, pop from the stack to determine the largest rectangle that can be formed with the removed bar.  
3. **Calculate areas dynamically** based on the popped height and its left-right boundaries.  
4. **Continue until all bars have been processed**, ensuring the largest possible area is captured.
