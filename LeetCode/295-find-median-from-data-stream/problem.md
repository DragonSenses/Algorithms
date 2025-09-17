# 295. Find Median from Data Stream

<p>The <strong>median</strong> is the middle value in an ordered integer list. If the size of the list is even, there is no middle value, and the median is the mean of the two middle values.</p>

<ul>
  <li>For example, for <code>arr = [2,3,4]</code>, the median is <code>3</code>.</li>
  <li>For example, for <code>arr = [2,3]</code>, the median is <code>(2 + 3) / 2 = 2.5</code>.</li>
</ul>

<p>Implement the MedianFinder class:</p>

<ul>
  <li><code>MedianFinder()</code> initializes the <code>MedianFinder</code> object.</li>
  <li><code>void addNum(int num)</code> adds the integer <code>num</code> from the data stream to the data structure.</li>
  <li><code>double findMedian()</code> returns the median of all elements so far. Answers within <code>10<sup>-5</sup></code> of the actual answer will be accepted.</li>
</ul>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input</strong>
["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"]
[[], [1], [2], [], [3], []]
<strong>Output</strong>
[null, null, null, 1.5, null, 2.0]

<strong>Explanation</strong>
MedianFinder medianFinder = new MedianFinder();
medianFinder.addNum(1);    // arr = [1]
medianFinder.addNum(2);    // arr = [1, 2]
medianFinder.findMedian(); // return 1.5 (i.e., (1 + 2) / 2)
medianFinder.addNum(3);    // arr[1, 2, 3]
medianFinder.findMedian(); // return 2.0
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
  <li><code>-10<sup>5</sup> &lt;= num &lt;= 10<sup>5</sup></code></li>
  <li>There will be at least one element in the data structure before calling <code>findMedian</code>.</li>
  <li>At most <code>5 * 10<sup>4</sup></code> calls will be made to <code>addNum</code> and <code>findMedian</code>.</li>
</ul>

<p>&nbsp;</p>
<p><strong>Follow up:</strong></p>

<ul>
  <li>If all integer numbers from the stream are in the range <code>[0, 100]</code>, how would you optimize your solution?</li>
  <li>If <code>99%</code> of all integer numbers from the stream are in the range <code>[0, 100]</code>, how would you optimize your solution?</li>
</ul>

---

# Solution

- [Naive Approach](#naive-approach)

# Problem Overview: Find Median from Data Stream

## Problem Description

The **median** is the middle value in an ordered integer list.  
If the size of the list is even, the median is the mean of the two middle values.

### Examples:
- For `arr = [2,3,4]`, the median is `3`.
- For `arr = [2,3]`, the median is `(2 + 3) / 2 = 2.5`.

## Implement the `MedianFinder` class

### Methods:
- `MedianFinder()`  
  Initializes the `MedianFinder` object.

- `void addNum(int num)`  
  Adds the integer `num` from the data stream to the data structure.

- `double findMedian()`  
  Returns the median of all elements so far.  
  Answers within `10^-5` of the actual answer will be accepted.

## Example

```plaintext
Input:
["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"]
[[], [1], [2], [], [3], []]

Output:
[null, null, null, 1.5, null, 2.0]
```

### Explanation:
```plaintext
MedianFinder medianFinder = new MedianFinder();
medianFinder.addNum(1);    // arr = [1]
medianFinder.addNum(2);    // arr = [1, 2]
medianFinder.findMedian(); // return 1.5
medianFinder.addNum(3);    // arr = [1, 2, 3]
medianFinder.findMedian(); // return 2.0
```

## Constraints

- -10⁵ ≤ num ≤ 10⁵  
- There will be at least one element in the data structure before calling `findMedian`.  
- At most 5 × 10⁴ calls will be made to `addNum` and `findMedian`.

## Follow-Up

- If all integer numbers from the stream are in the range `[0, 100]`, how would you optimize your solution?
- If 99% of all integer numbers from the stream are in the range `[0, 100]`, how would you optimize your solution?

---

# Naive Approach

## **Intuition**

The simplest way to compute the median from a stream of numbers is to store all incoming values in a resizable container (like an ArrayList). Since the median depends on the sorted order of elements, we sort the list every time `findMedian()` is called. This guarantees correctness but is inefficient for large data streams due to repeated sorting.

This approach is acceptable for small input sizes or when performance is not critical. It prioritizes simplicity over efficiency.

