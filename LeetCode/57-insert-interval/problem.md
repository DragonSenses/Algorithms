# 57. Insert Interval

<p>You are given an array of non-overlapping intervals <code>intervals</code> where <code>intervals[i] = [start<sub>i</sub>, end<sub>i</sub>]</code> represent the start and the end of the <code>i<sup>th</sup></code> interval and <code>intervals</code> is sorted in ascending order by <code>start<sub>i</sub></code>. You are also given an interval <code>newInterval = [start, end]</code> that represents the start and end of another interval.</p>

<p>Insert <code>newInterval</code> into <code>intervals</code> such that <code>intervals</code> is still sorted in ascending order by <code>start<sub>i</sub></code> and <code>intervals</code> still does not have any overlapping intervals (merge overlapping intervals if necessary).</p>

<p>Return <code>intervals</code><em> after the insertion</em>.</p>

<p><strong>Note</strong> that you don't need to modify <code>intervals</code> in-place. You can make a new array and return it.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> intervals = [[1,3],[6,9]], newInterval = [2,5]
<strong>Output:</strong> [[1,5],[6,9]]
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
<strong>Output:</strong> [[1,2],[3,10],[12,16]]
<strong>Explanation:</strong> Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
  <li><code>0 &lt;= intervals.length &lt;= 10<sup>4</sup></code></li>
  <li><code>intervals[i].length == 2</code></li>
  <li><code>0 &lt;= start<sub>i</sub> &lt;= end<sub>i</sub> &lt;= 10<sup>5</sup></code></li>
  <li><code>intervals</code> is sorted by <code>start<sub>i</sub></code> in <strong>ascending</strong> order.</li>
  <li><code>newInterval.length == 2</code></li>
  <li><code>0 &lt;= start &lt;= end &lt;= 10<sup>5</sup></code></li>
</ul>

<br>

---

# Solution

- [Linear Search Approach](#linear-search-approach)
  - **Time Complexity**: `O(n)`
  - **Space Complexity**: `O(n)`
- [Binary Search Approach](#binary-search-approach)

### Problem Overview: Insert Interval

You are given an array of non-overlapping intervals `intervals`, where `intervals[i] = [start_i, end_i]` represents the start and end of the `i-th` interval. The intervals are sorted in ascending order by their start value. Additionally, you are given a new interval `newInterval = [start, end]` representing the start and end of another interval.

Your task is to insert `newInterval` into `intervals` such that the intervals remain sorted in ascending order by their start value and there are no overlapping intervals. If necessary, merge overlapping intervals. The function should return the modified intervals.

**Note**: You do not need to modify `intervals` in-place. You can create a new array and return it.

### Examples
#### Example 1
- **Input**: `intervals = [[1,3],[6,9]], newInterval = [2,5]`
- **Output**: `[[1,5],[6,9]]`

#### Example 2
- **Input**: `intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]`
- **Output**: `[[1,2],[3,10],[12,16]]`
- **Explanation**: The new interval [4,8] overlaps with [3,5], [6,7], and [8,10].

### Constraints
- \(0 \leq \text{intervals.length} \leq 10^4\)
- Each interval \(\text{intervals[i]}\) has a length of 2.
- \[0 \leq \text{start}_i \leq \text{end}_i \leq 10^5\]
- `intervals` is sorted in ascending order by `start_i`.
- `newInterval` has a length of 2.
- \(0 \leq \text{start} \leq \text{end} \leq 10^5\)

### Goal
The goal is to insert the new interval into the sorted array of intervals while maintaining the order and merging any overlapping intervals.

# Linear Search Approach

We have `N` non-overlapping intervals in ascending order of their `start` value; given one more interval `newInterval`, we want to insert this interval into the list while keeping the order intact and merging any overlapping intervals.

The solution to this problem will be straightforward to understand if we can find the solution to the following three sub-problems:

1. How can we tell if two given intervals overlap?
2. How to merge two overlapping intervals?
3. Given a list of N intervals in ascending order of their 'start' values, how can we merge any possible overlapping intervals in the list while keeping the ascending order intact?

## **Intuition**

To tackle the main problem, we need to understand three key sub-problems: 
1. Determining if two intervals overlap.
2. Merging two overlapping intervals.
3. Merging overlapping intervals in a list sorted by start values, while maintaining the order.

Given these insights, the original problem becomes: inserting a new interval into the existing sorted list and ensuring the list remains sorted while merging any overlapping intervals. By using a linear search, we can determine the correct position for the new interval and merge intervals as needed.

### **Approach**

This can be done using a linear search. We can iterate over the intervals in the list, and the `newInterval` should be inserted just before the interval having a greater start value. This way, we can produce the list of intervals in ascending order of their start value and solve it using the algorithm discussed.

1. **Initialization**:
   - Create a new list to hold the result.
   - Set a flag to indicate whether the `newInterval` has been inserted.

2. **Iterate through each interval**:
   - If the current interval ends before the `newInterval` starts, add the current interval to the result list.
   - If the `newInterval` ends before the current interval starts and the flag is not set, add the `newInterval` to the result list, set the flag, and add the current interval.
   - If the `newInterval` overlaps with the current interval, merge them by updating the start and end values of the `newInterval`.

3. **Add any remaining intervals**:
   - After the iteration, if the flag is not set, add the `newInterval` to the result list.

4. **Return the result**:
   - Return the result list containing the merged intervals.

### Example Process

Given the intervals: `[[1, 2], [3, 5], [6, 7], [8, 10], [12, 16]]`
And the new interval: `[4, 8]`

The step-by-step process of inserting and merging the new interval:

1. **Initialization**: 
   - Result list: `[]`
   - Flag: `False` (to indicate whether the new interval has been inserted)

2. **Iterate through each interval**:
   - Interval `[1, 2]`: 
     - Ends before `[4, 8]` starts.
     - Add `[1, 2]` to the result: `[[1, 2]]`
     
   - Interval `[3, 5]`: 
     - Overlaps with `[4, 8]`.
     - Merge to form `[3, 8]`.
     - Update `newInterval` to `[3, 8]`.

   - Interval `[6, 7]`: 
     - Overlaps with `[3, 8]`.
     - Merge to form `[3, 8]`.
     - Update `newInterval` to `[3, 8]`.

   - Interval `[8, 10]`: 
     - Overlaps with `[3, 8]`.
     - Merge to form `[3, 10]`.
     - Update `newInterval` to `[3, 10]`.

   - Interval `[12, 16]`: 
     - Starts after `[3, 10]` ends.
     - Add `[3, 10]` to the result: `[[1, 2], [3, 10]]`
     - Add `[12, 16]` to the result: `[[1, 2], [3, 10], [12, 16]]`

3. **Add remaining intervals**:
   - Since the flag is not needed (we've already added the merged interval), there are no additional actions here.

4. **Final Result**:
   - Return the result list containing the merged intervals: `[[1, 2], [3, 10], [12, 16]]`

This illustrates how the new interval `[4, 8]` is merged with the existing intervals, resulting in the final list `[[1, 2], [3, 10], [12, 16]]`.

## **Algorithm**

1. **Insert New Interval**:
   - Insert the `newInterval` into the given list of intervals using linear search.
   - Iterate over the list and find the first interval with a start value greater than the `newInterval`.
   - Insert `newInterval` just before this interval or at the end of the list if no such interval exists.

2. **Merge Overlapping Intervals**:
   - Iterate over the intervals in the list `intervals`. For each interval `currInterval`:
     - Iterate over the intervals ahead of it in the list (including itself). If two intervals overlap, update `currInterval` to the merged interval of these two intervals.
     - Move on to the next interval.

3. **Decrement Loop Counter**:
   - Decrement the loop counter variable. Since it will be incremented again in the outer loop, decrementing it here ensures that the next interval is not missed.

4. **Insert into Answer**:
   - Insert the interval `currInterval` into the list `answer`.

5. **Return Result**:
   - Return the `answer` list containing the merged intervals.

### **Pseudocode**

```pseudocode
function insertAndMergeIntervals(intervals, newInterval):
    result = empty list
    flag = false

    // Step 1: Insert the new interval in the correct position
    for i from 0 to length of intervals:
        if newInterval.start < intervals[i].start:
            insert newInterval into intervals at position i
            flag = true
            break

    // If the new interval hasn't been inserted, append it at the end
    if not flag:
        append newInterval to intervals

    // Step 2: Merge overlapping intervals
    for i from 0 to length of intervals:
        currInterval = intervals[i]
        while i + 1 < length of intervals and intervals[i + 1].start <= currInterval.end:
            // Merge current interval with the next interval
            currInterval.end = max(currInterval.end, intervals[i + 1].end)
            i = i + 1

        // Step 3: Add the merged interval to the result list
        append currInterval to result

    // Step 4: Return the result list containing merged intervals
    return result
```

## **Implementation**

### Java

```java
import java.util.ArrayList;
import java.util.List;

class Solution {
  public int[][] insert(int[][] intervals, int[] newInterval) {
    List<int[]> result = new ArrayList<>();
    int i = 0, n = intervals.length;

    // Step 1: Insert all intervals before newInterval
    while (i < n && intervals[i][1] < newInterval[0]) {
      result.add(intervals[i]);
      i++;
    }

    // Step 2: Merge newInterval with overlapping intervals
    while (i < n && intervals[i][0] <= newInterval[1]) {
      newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
      newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
      i++;
    }
    result.add(newInterval); // Add the merged interval

    // Step 3: Add remaining intervals after newInterval
    while (i < n) {
      result.add(intervals[i]);
      i++;
    }

    // Convert list to array
    return result.toArray(new int[result.size()][]);
  }
}
```

### TypeScript

```typescript
function insert(intervals: number[][], newInterval: number[]): number[][] {
  const result: number[][] = [];
  let i = 0;
  const n = intervals.length;

  // Step 1: Insert all intervals before newInterval
  while (i < n && intervals[i][1] < newInterval[0]) {
    result.push(intervals[i]);
    i++;
  }

  // Step 2: Merge newInterval with overlapping intervals
  while (i < n && intervals[i][0] <= newInterval[1]) {
    newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
    newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
    i++;
  }
  result.push(newInterval); // Add the merged interval

  // Step 3: Add remaining intervals after newInterval
  while (i < n) {
    result.push(intervals[i]);
    i++;
  }

  return result;
}
```

#### Implementation Details

1. **Insert intervals before `newInterval`**: Add intervals that end before the `newInterval` starts.
2. **Merge `newInterval` with overlapping intervals**: Update the `newInterval` start and end to merge with any overlapping intervals.
3. **Add remaining intervals**: Add the rest of the intervals that start after the `newInterval` ends.

## **Complexity Analysis**

### Assumptions

- Let `n` be the number of intervals in the list.

### **Time Complexity**: `O(n)`

- **Single Pass:** The algorithm iterates through the list of intervals once.
  - **Insertion:** Finding the correct position to insert `newInterval` involves iterating through the list, which takes O(n) time in the worst case.
  - **Merging:** In the worst case, we might need to merge the `newInterval` with all intervals, resulting in another O(n) operations.
- **Constant Time Operations:** Each comparison, insertion, and merge operation within the loop is constant time (O(1)).
- **Worst-Case:** The worst-case scenario occurs when the `newInterval` overlaps with every interval in the list, requiring O(n) operations to insert and merge.
- **Overall Time Complexity:** Combining these operations, the overall time complexity is O(n).

### **Space Complexity**: `O(n)`

- **Result List:** The result list stores the merged intervals, which could grow up to the size of the input intervals (n), plus one additional interval (newInterval). Hence, the space complexity is O(n).
- **Constant Space Usage:** Besides the result list, the algorithm uses a fixed amount of space for variables such as indices and flags.
- **No Additional Data Structures:** Other than the result list, there are no additional data structures that grow with the input size.
- **Overall Space Complexity:** While the result list grows with the input size, the space required for auxiliary variables remains constant. Thus, the overall space complexity is O(n).

# Binary Search Approach

## **Intuition**

The main difference with this approach is that instead of using a linear search to find the suitable position for the `newInterval`, we use binary search because the list of intervals is sorted by their start times. We need to find the first interval in the list `intervals` that has a start value greater than the start value of `newInterval`.

Once we find this position, we can insert the `newInterval` and then merge any overlapping intervals using the same logic as before.

### Binary Search Overview

1. **Initial Setup**:
   - You start with two pointers: one at the beginning of the list (`low`) and one at the end of the list (`high`).

2. **Middle Calculation**:
   - Calculate the middle index (`mid`) of the current search interval. This is usually done using: 
     \[
     \text{mid} = \text{low} + \frac{(\text{high} - \text{low})}{2}
     \]

3. **Comparison**:
   - Compare the target value with the value at the middle index.
   - If the target value is equal to the middle value, you've found the item.
   - If the target value is less than the middle value, it must be in the left half of the list. Therefore, update `high` to `mid - 1`.
   - If the target value is greater than the middle value, it must be in the right half of the list. Therefore, update `low` to `mid + 1`.

4. **Repeat**:
   - Repeat the above steps until `low` is greater than `high`, which means the target is not in the list, or until you find the target value.

#### Time Complexity

Binary search is very efficient with a time complexity of \(O(\log n)\), where \(n\) is the number of items in the list. This is because with each step, the search interval is halved, quickly narrowing down the possible positions of the target value.