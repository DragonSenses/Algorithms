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
  - **Time Complexity**: `O(n log n)`
  - **Space Complexity**: `O(n)`
- [Insertion Sort Approach](#insertion-sort-approach)
  - **Time Complexity**: `O(n)`
  - **Space Complexity**: `O(n)`
- [Heap Approach](#heap-approach)

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

## **Algorithm**

1. Use an `ArrayList<Integer>` to store all incoming numbers.
2. When `addNum(int num)` is called, append the number to the list.
3. When `findMedian()` is called:
   - Sort the list in ascending order.
   - If the list size is odd, return the middle element.
   - If the list size is even, return the average of the two middle elements.

## **Pseudocode**

```plaintext
class MedianFinder: Initialize empty list

method addNum(num):
    append num to list

method findMedian():
    if list is empty:
        return 0

    sort list in ascending order
    size = length of list

    if size is odd:
        return list[size // 2]
    else:
        return (list[size // 2 - 1] + list[size // 2]) / 2.0
```

## **Implementation**

### Java

```java
import java.util.ArrayList;

class MedianFinder {
  ArrayList<Integer> list;

  // Initializes MedianFinder object
  public MedianFinder() {
    this.list = new ArrayList<>();
  }

  // Adds integer num from the data stream to data structure
  public void addNum(int num) {
    this.list.add(num);
  }

  // Returns median of all elements so far
  public double findMedian() {
    if (list.isEmpty()) { return 0; }

    this.list.sort((a, b) -> Integer.compare(a, b));

    int size = list.size();

    return (size & 1) == 1 
      ? list.get(size / 2)
      : ((list.get(size / 2 - 1) + list.get(size / 2)) / 2.0);
  }
}
```

### TypeScript

```typescript
class MedianFinder {
  private list: number[];

  constructor() {
    this.list = [];
  }

  addNum(num: number): void {
    this.list.push(num);
  }

  findMedian(): number {
    if (this.list.length === 0) return 0;

    this.list.sort((a, b) => a - b);

    const size = this.list.length;
    const mid = Math.floor(size / 2);

    return size % 2 === 1
      ? this.list[mid]
      : (this.list[mid - 1] + this.list[mid]) / 2;
  }
}
```

## **Complexity Analysis**

### **Assumptions**

- Let `n` be the amount of elements in the data stream
- **Input Size is Manageable**: This approach assumes that the number of elements (`n`) is small enough that repeated sorting is not a performance bottleneck.
- **Sorting is Stable and Deterministic**: The built-in sort function is assumed to be stable and consistent across calls.
- **Median is Always Requested After Insertions**: The algorithm does not cache or optimize median retrieval, so sorting is repeated on every call to `findMedian()`.

### **Time Complexity**: `O(n log n)`
- **Sorting Dominates**: Each call to `findMedian()` triggers a full sort of the list, which takes `O(n log n)` time where `n` is the number of elements added so far.
- **Insertion is Constant-Time**: The `addNum()` method simply appends to the list, which takes `O(1)` time per insertion.
- **Median Retrieval is Constant-Time**: After sorting, accessing one or two middle elements takes `O(1)` time.

### **Space Complexity**: `O(n)`
- **Linear-Space Storage**: The algorithm stores all incoming numbers in a resizable array (`ArrayList` or `number[]`), which grows linearly with the number of elements.
- **No Auxiliary Structures**: Aside from the main list, no additional data structures are used, keeping space usage minimal but proportional to input size.

# Insertion Sort Approach

## **Intuition**

Keeping our input container always sorted (i.e., maintaining the sorted nature of the container as *invariant* -- never changing).

Every time a new number is added, we insert it into its correct position so the list remains sorted. 

This eliminates the need to sort the list during `findMedian()` calls and makes median retrieval trivial.

Since we’re building the list from scratch and always inserting in order, we don’t need to assume it’s already sorted—it always is.

To efficiently find the correct insertion point, we use **binary search**, which takes `O(log n)` time.  

Once the position is found, we shift all subsequent elements to the right to make room for the new number, which takes `O(n)` time in the worst case.

This approach works well when:
- The number of `findMedian()` calls is high relative to `addNum()` calls.
- We want to avoid repeated sorting.
- Simplicity and correctness are more important than insertion speed.
- The amount of insertion queries is lesser or about the same as the amount of median finding queries.

## **Algorithm**

1. Initialize an empty list.
2. When `addNum(num)` is called:
   - Scan the list to find the correct position to insert `num`.
   - Insert `num` at that position to maintain sorted order.
3. When `findMedian()` is called:
   - If the list size is odd, return the middle element.
   - If the list size is even, return the average of the two middle elements.

### **Pseudocode**

```plaintext
class MedianFinder: initialize empty list

method addNum(num):
    find correct index to insert num (linear scan or binary search)
    insert num at index

method findMedian():
    size = length of list
    if size is odd:
        return list[size // 2]
    else:
        return (list[size // 2 - 1] + list[size // 2]) / 2.0
```

## **Implementation**

### Java

```java
class MedianFinder {
  private List<Integer> list;

  /** Initializes the MedianFinder object. */
  public MedianFinder() {
    this.list = new ArrayList<>();
  }

  /**
   * Adds a number to the data stream while maintaining sorted order.
   * Uses binary search to find the correct insertion index.
   */
  public void addNum(int num) {
    int index = binarySearchInsertIndex(num);
    list.add(index, num); // insert at index, shifting elements as needed
  }

  /**
   * Returns the median of all elements added so far.
   */
  public double findMedian() {
    int size = list.size();
    if (size == 0) return 0;

    if ((size & 1) == 1) {
      return list.get(size / 2);
    } else {
      return (list.get(size / 2 - 1) + list.get(size / 2)) / 2.0;
    }
  }

  /**
   * Helper method to find the correct insertion index using binary search.
   */
  private int binarySearchInsertIndex(int target) {
    int left = 0, right = list.size();
    while (left < right) {
      int mid = left + (right - left) / 2;
      if (list.get(mid) < target) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }
    return left;
  }
}
```

### TypeScript

```typescript
class MedianFinder {
  private list: number[];

  constructor() {
    this.list = [];
  }

  /**
   * Adds a number to the data stream while maintaining sorted order.
   * Uses binary search to find the correct insertion index.
   */
  addNum(num: number): void {
    const index = this.binarySearchInsertIndex(num);
    this.list.splice(index, 0, num); // Insert at index, shifting elements
  }

  /**
   * Returns the median of all elements added so far.
   */
  findMedian(): number {
    const size = this.list.length;
    if (size === 0) return 0;

    const mid = Math.floor(size / 2);

    return size % 2 === 1
      ? this.list[mid]
      : (this.list[mid - 1] + this.list[mid]) / 2;
  }

  /**
   * Helper method to find the correct insertion index using binary search.
   */
  private binarySearchInsertIndex(target: number): number {
    let left = 0;
    let right = this.list.length;

    while (left < right) {
      const mid = Math.floor((left + right) / 2);
      if (this.list[mid] < target) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }

    return left;
  }
}
```

## **Complexity Analysis**

### **Assumptions**

- Let `n` be the number of elements in the data stream.
- Each element is inserted using binary search to find its correct position.
- The list is maintained in sorted order at all times.

### **Time Complexity**: `O(n)`
- **Insertion Cost per Element**: Each call to `addNum(num)` performs a binary search in `O(log n)` time to find the correct index, followed by an array insertion which may require shifting up to `O(n)` elements. Thus, each insertion is `O(n)` in the worst case.
- **Median Retrieval**: `findMedian()` accesses one or two middle elements in constant time, `O(1)`.
- **Overall Cost**: If `n` elements are inserted, the total cost is `O(n^2)` across all insertions, but each individual operation is `O(n)` worst-case.

### **Space Complexity**: `O(n)`
- **Linear Storage**: All elements are stored in a single array (`number[]` or `ArrayList<Integer>`), which grows linearly with the number of insertions.
- **No Auxiliary Structures**: Aside from the main list, no additional data structures are used, keeping space usage minimal and proportional to input size.

# Heap Approach

## **Intuition**

Previous approaches taught us that:
1. Constant-time median retrieval is possible if we maintain direct access to the middle elements.
2. Efficient insertion is key to keeping the system performant under frequent updates.

But here's the deeper insight:  
**We don’t need to keep the entire input sorted—just enough structure to consistently access the median.**

This leads us to heaps (priority queues), which offer:
- **Logarithmic-time insertion**
- **Constant-time access to min or max elements**

By maintaining two heaps:
- A **max-heap** (`lo`) for the smaller half of the numbers
- A **min-heap** (`hi`) for the larger half

We can ensure that:
- The top of `lo` is the largest of the smaller half
- The top of `hi` is the smallest of the larger half

If both heaps are balanced (or nearly balanced), the median is either:
- The top of `lo` (if odd number of elements)
- The average of tops of `lo` and `hi` (if even number of elements)

### Why this works:
- All elements in `lo` are ≤ all elements in `hi`
- The heaps partition the input into two halves
- The tops of the heaps represent the middle values

### Balancing Strategy:
- Always insert into `lo` first
- Move the largest element from `lo` to `hi`
- If `hi` ends up larger, move its smallest element back to `lo`

This ensures:
- `lo.size() >= hi.size()`
- Size difference never exceeds 1

### **Example Walkthrough**

Input stream: `[41, 35, 62, 5, 97, 108]`

| Step       | Action     | MaxHeap `lo`       | MinHeap `hi`        | Median         |
|------------|------------|--------------------|----------------------|----------------|
| Add 41     | -> insert   | [41]               | []                   | 41             |
| Add 35     | -> rebalance| [35]               | [41]                 | (35 + 41)/2 = 38 |
| Add 62     | -> rebalance| [41, 35]           | [62]                 | 41             |
| Add 5      | -> rebalance| [35, 5]            | [41, 62]             | (35 + 41)/2 = 38 |
| Add 97     | -> rebalance| [41, 35, 5]        | [62, 97]             | 41             |
| Add 108    | -> rebalance| [41, 35, 5]        | [62, 97, 108]        | (41 + 62)/2 = 51.5 |

**Notes**:
- `lo` is a max-heap: largest value at the top.
- `hi` is a min-heap: smallest value at the top.
- Heaps are rebalanced after each insertion to maintain size constraints.

## **Algorithm**

1. Initialize two heaps:
   - `lo`: max-heap for lower half
   - `hi`: min-heap for upper half

2. For each `addNum(num)`:
   - Insert `num` into `lo`
   - Move the largest element from `lo` to `hi`
   - If `hi.size() > lo.size()`, move the smallest element from `hi` back to `lo`

3. For `findMedian()`:
   - If `lo.size() > hi.size()`, return `lo.peek()`
   - Else, return average of `lo.peek()` and `hi.peek()`

### **Pseudocode**

```
initialize maxHeap lo
initialize minHeap hi

method addNum(num):
    lo.add(num)
    hi.add(lo.poll())
    if hi.size() > lo.size():
        lo.add(hi.poll())

method findMedian():
    if lo.size() > hi.size():
        return lo.peek()
    else:
        return (lo.peek() + hi.peek()) / 2.0
```
