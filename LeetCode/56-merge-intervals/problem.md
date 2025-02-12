# 56. Merge Intervals

<p>Given an array&nbsp;of <code>intervals</code>&nbsp;where <code>intervals[i] = [start<sub>i</sub>, end<sub>i</sub>]</code>, merge all overlapping intervals, and return <em>an array of the non-overlapping intervals that cover all the intervals in the input</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> intervals = [[1,3],[2,6],[8,10],[15,18]]
<strong>Output:</strong> [[1,6],[8,10],[15,18]]
<strong>Explanation:</strong> Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> intervals = [[1,4],[4,5]]
<strong>Output:</strong> [[1,5]]
<strong>Explanation:</strong> Intervals [1,4] and [4,5] are considered overlapping.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
  <li><code>1 &lt;= intervals.length &lt;= 10<sup>4</sup></code></li>
  <li><code>intervals[i].length == 2</code></li>
  <li><code>0 &lt;= start<sub>i</sub> &lt;= end<sub>i</sub> &lt;= 10<sup>4</sup></code></li>
</ul>

<br>

---

# Solution

- [Sorting Approach](#sorting-approach)
  - **Time Complexity**: `O(n log n)`
  - **Space Complexity**: `O(log n) to O(n)`

### Problem Overview: Merge Intervals

The problem you're looking into is "Merge Intervals." Here’s an overview of it:

### Problem Description:
Given an array of intervals where each interval is represented as `[start_i, end_i]`, your task is to merge all overlapping intervals and return an array of non-overlapping intervals that cover all the intervals in the input.

### Examples:
**Example 1:**
- **Input:** `intervals = [[1,3],[2,6],[8,10],[15,18]]`
- **Output:** `[[1,6],[8,10],[15,18]]`
- **Explanation:** Intervals `[1,3]` and `[2,6]` overlap, so they are merged into `[1,6]`.

**Example 2:**
- **Input:** `intervals = [[1,4],[4,5]]`
- **Output:** `[[1,5]]`
- **Explanation:** Intervals `[1,4]` and `[4,5]` are considered overlapping and are merged into `[1,5]`.

### Constraints:
- `1 <= intervals.length <= 10^4`
- Each interval has exactly two elements.
- `0 <= start_i <= end_i <= 10^4`

### Approach:
To solve this problem, you can follow these steps:
1. **Sort the intervals** based on their start values.
2. **Initialize an empty list** to hold the merged intervals.
3. **Iterate through the sorted intervals**:
    - If the list of merged intervals is empty, or the current interval does not overlap with the previous one, simply append it.
    - If the current interval does overlap with the previous one, merge them by updating the end value of the previous interval.
4. Return the merged intervals.

# Sorting Approach

## **Intuition**

If we sort the intervals by their start value, then each set of intervals that can be merged will appear as a contiguous "run" in the sorted list.

First, we sort the list as described. Then, we insert the first interval into our merged list and continue considering each interval in turn as follows:
- If the current interval begins after the previous interval ends, then they do not overlap, and we can append the current interval to the merged list.
- Otherwise, they do overlap, and we merge them by updating the end of the previous interval if it is less than the end of the current interval.

A simple proof by contradiction shows that this algorithm always produces the correct answer. First, suppose that the algorithm at some point fails to merge two intervals that should be merged. This would imply that there exists some triple of indices \(i\), \(j\), and \(k\) in a list of intervals \(\text{ints}\) such that \(i < j < k\) and \((\text{ints}[i], \text{ints}[k])\) can be merged, but neither \((\text{ints}[i], \text{ints}[j])\) nor \((\text{ints}[j], \text{ints}[k])\) can be merged. From this scenario follow several inequalities:

\[
\text{ints}[i].\text{end} < \text{ints}[j].\text{start}
\]
\[
\text{ints}[j].\text{end} < \text{ints}[k].\text{start}
\]
\[
\text{ints}[i].\text{end} \geq \text{ints}[k].\text{start}
\]

We can chain these inequalities (along with the following inequality, implied by the well-formedness of the intervals: \(\text{ints}[j].\text{start} \leq \text{ints}[j].\text{end}\)) to demonstrate a contradiction:

\[
\text{ints}[i].\text{end} < \text{ints}[j].\text{start} \leq \text{ints}[j].\text{end} < \text{ints}[k].\text{start}
\]
\[
\text{ints}[i].\text{end} \geq \text{ints}[k].\text{start}
\]

Therefore, all mergeable intervals must occur in a contiguous run of the sorted list.

Consider the example below, where the intervals are sorted, and then all mergeable intervals form contiguous blocks:
\[
\{(1, 9), (2, 5), (19, 20), (10, 11), (12, 20), (0, 3), (0, 1), (0, 2)\}
\]
Sorted:
\[
\{(0, 3), (0, 1), (0, 2), (1, 9), (2, 5), (10, 11), (12, 20), (19, 20)\}
\]

## **Algorithm**

1. **Sort** the intervals based on their start values.
2. **Initialize** an empty list to hold the merged intervals.
3. **Iterate** through the sorted intervals:
    - If the list of merged intervals is empty, or the current interval does not overlap with the previous one, append it.
    - If the current interval does overlap with the previous one, merge them by updating the end value of the previous interval.
4. **Return** the merged intervals.

### **Pseudocode**

```pseudo
function mergeIntervals(intervals):
    if intervals.length == 0:
        return []

    // Step 1: Sort intervals based on the start value
    sort intervals by intervals[i][0]

    // Step 2: Initialize the merged list with the first interval
    merged = [intervals[0]]

    // Step 3: Iterate through the sorted intervals
    for i = 1 to intervals.length - 1:
        // Get the last interval in the merged list
        lastMerged = merged[-1]

        // If the current interval does not overlap with the last merged interval
        if intervals[i][0] > lastMerged[1]:
            // Append the current interval to the merged list
            merged.append(intervals[i])
        else:
            // Merge the current interval with the last merged interval
            lastMerged[1] = max(lastMerged[1], intervals[i][1])

    return merged
```

## **Implementation**

#### Implementation Details

1. We sort the intervals based on their start values.
2. We use a `LinkedList` to store the merged intervals.
3. We iterate through the sorted intervals and either merge them or append them to the merged list.
4. Finally, we convert the merged list to an array and return it.

### Java

```java
import java.util.Arrays;
import java.util.LinkedList;

public class Solution {
  public static int[][] merge(int[][] intervals) {
    // Step 1: Sort the intervals based on the start value
    Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

    // Step 2: Initialize a linked list to hold the merged intervals
    LinkedList<int[]> merged = new LinkedList<>();

    // Step 3: Iterate through the sorted intervals
    for (int[] interval : intervals) {
      // If the list of merged intervals is empty or the current interval does not overlap with the
      // previous one
      if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
        // Append the current interval to the merged list
        merged.add(interval);
      } else {
        // Merge the current interval with the last merged interval
        merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
      }
    }

    // Convert the list to an array before returning
    return merged.toArray(new int[merged.size()][]);
  }
}
```

Without using `.toArray()` to manually conver the linked list to an array:

```java
import java.util.Arrays;
import java.util.LinkedList;

public class Solution {
  public static int[][] merge(int[][] intervals) {
    // Step 1: Sort the intervals based on the start value
    Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

    // Step 2: Initialize a linked list to hold the merged intervals
    LinkedList<int[]> merged = new LinkedList<>();

    // Step 3: Iterate through the sorted intervals
    for (int[] interval : intervals) {
      // If the list of merged intervals is empty or the current interval does not overlap with the
      // previous one
      if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
        // Append the current interval to the merged list
        merged.add(interval);
      } else {
        // Merge the current interval with the last merged interval
        merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
      }
    }

    // Convert the list to an array using the list's size directly
    int[][] result = new int[merged.size()][2];
    for (int i = 0; i < merged.size(); i++) {
      result[i] = merged.get(i);
    }

    return result;
  }
}
```

### TypeScript

```typescript
function merge(intervals: number[][]): number[][] {
  if (intervals.length === 0) return [];

  // Step 1: Sort the intervals based on their start value
  intervals.sort((a, b) => a[0] - b[0]);

  // Step 2: Initialize a list to hold the merged intervals
  const merged: number[][] = [];

  // Step 3: Iterate through the sorted intervals
  for (const interval of intervals) {
    // If the list of merged intervals is empty or the current interval does not overlap with the previous one
    if (merged.length === 0 || merged[merged.length - 1][1] < interval[0]) {
      // Append the current interval to the merged list
      merged.push(interval);
    } else {
      // Merge the current interval with the last merged interval
      merged[merged.length - 1][1] = Math.max(
        merged[merged.length - 1][1],
        interval[1]
      );
    }
  }

  return merged;
}
```

## **Complexity Analysis**

- Let `n` be the number of intervals in the input array.

### **Time Complexity**: `O(n log n)`

- **Single Pass:** The algorithm iterates through the intervals once, which is `O(n)`.
- **Sort:** Sorting the intervals based on their start value takes `O(n log n)` time.
- **Worst-Case:** In the worst-case scenario, all intervals overlap with each other. Even then, we iterate through the intervals only once.
- **Overall Time Complexity:** Since the sorting step dominates the overall time complexity, the algorithm's overall time complexity is `O(n log n)`.

### **Space Complexity**: `O(log n) to O(n)`

- **Logarithmic Space Usage:** If we consider the additional space used by the sorting algorithm (which can be `O(log n)` for in-place sorting algorithms like quicksort), the space complexity would be `O(log n)`.
- **Linear Space Usage:** In the worst case, the algorithm could use `O(n)` space to store the merged intervals. This is because in the worst case, none of the intervals overlap, and the merged list will contain all the intervals.

Therefore, the overall space complexity of the algorithm can range from `O(log n)` to `O(n)` depending on the sorting algorithm used and the number of merged intervals.
