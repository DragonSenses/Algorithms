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
  - **Time Complexity**: `O()`
  - **Space Complexity**: `O()`

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
