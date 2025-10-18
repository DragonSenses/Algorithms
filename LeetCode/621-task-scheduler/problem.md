# 621. Task Scheduler

<p>You are given an array of CPU <code>tasks</code>, each labeled with a letter from A to Z, and a number <code>n</code>. Each CPU interval can be idle or allow the completion of one task. Tasks can be completed in any order, but there's a constraint: there has to be a gap of <strong>at least</strong> <code>n</code> intervals between two tasks with the same label.</p>

<p>Return the <strong>minimum</strong> number of CPU intervals required to complete all tasks.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block" style="border-color: var(--border-tertiary); border-left-width: 2px; color: var(--text-secondary); font-size: 0.875rem; margin-bottom: 1rem; margin-top: 1rem; overflow: visible; padding-left: 1rem;">
<p><strong>Input:</strong> <span class="example-io" style="font-family: Menlo, sans-serif; font-size: 0.85rem;">tasks = ["A","A","A","B","B","B"], n = 2</span></p>

<p><strong>Output:</strong> <span class="example-io" style="font-family: Menlo, sans-serif; font-size: 0.85rem;">8</span></p>

<p><strong>Explanation:</strong> A possible sequence is: A -&gt; B -&gt; idle -&gt; A -&gt; B -&gt; idle -&gt; A -&gt; B.</p>

<p>After completing task A, you must wait two intervals before doing A again. The same applies to task B. In the 3<sup>rd</sup> interval, neither A nor B can be done, so you idle. By the 4<sup>th</sup> interval, you can do A again as 2 intervals have passed.</p>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block" style="border-color: var(--border-tertiary); border-left-width: 2px; color: var(--text-secondary); font-size: 0.875rem; margin-bottom: 1rem; margin-top: 1rem; overflow: visible; padding-left: 1rem;">
<p><strong>Input:</strong> <span class="example-io" style="font-family: Menlo, sans-serif; font-size: 0.85rem;">tasks = ["A","C","A","B","D","B"], n = 1</span></p>

<p><strong>Output:</strong> <span class="example-io" style="font-family: Menlo, sans-serif; font-size: 0.85rem;">6</span></p>

<p><strong>Explanation:</strong> A possible sequence is: A -&gt; B -&gt; C -&gt; D -&gt; A -&gt; B.</p>

<p>With a cooling interval of 1, you can repeat a task after just one other task.</p>
</div>

<p><strong class="example">Example 3:</strong></p>

<div class="example-block" style="border-color: var(--border-tertiary); border-left-width: 2px; color: var(--text-secondary); font-size: 0.875rem; margin-bottom: 1rem; margin-top: 1rem; overflow: visible; padding-left: 1rem;">
<p><strong>Input:</strong> <span class="example-io" style="font-family: Menlo, sans-serif; font-size: 0.85rem;">tasks = ["A","A","A", "B","B","B"], n = 3</span></p>

<p><strong>Output:</strong> <span class="example-io" style="font-family: Menlo, sans-serif; font-size: 0.85rem;">10</span></p>

<p><strong>Explanation:</strong> A possible sequence is: A -&gt; B -&gt; idle -&gt; idle -&gt; A -&gt; B -&gt; idle -&gt; idle -&gt; A -&gt; B.</p>

<p>There are only two types of tasks, A and B, which need to be separated by 3 intervals. This leads to idling twice between repetitions of these tasks.</p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= tasks.length &lt;= 10<sup>4</sup></code></li>
	<li><code>tasks[i]</code> is an uppercase English letter.</li>
	<li><code>0 &lt;= n &lt;= 100</code></li>
</ul>

---

# Solution

- [Greedy Approach](#greedy-approach)

## **Problem Overview: Task Scheduler**

You are given an array `tasks` representing CPU tasks, each labeled with a capital letter from `'A'` to `'Z'`. The CPU executes one task per interval, and may remain idle if no task can be scheduled. A cooling interval `n` is enforced between two executions of the same task label — meaning that after executing a task `'X'`, you must wait at least `n` intervals before executing `'X'` again.

Your goal is to determine the **minimum number of intervals** the CPU will take to complete all tasks.

### Input

- `tasks`: List of uppercase English letters representing tasks.
- `n`: Non-negative integer representing the cooling interval between identical tasks.

### Output

- An integer representing the minimum number of CPU intervals required to finish all tasks.

### Examples

**Example 1**

```text
Input: tasks = ["A","A","A","B","B","B"], n = 2
Output: 8
Explanation: A possible sequence is A → B → idle → A → B → idle → A → B
```

**Example 2**

Input: tasks = ["A","C","A","B","D","B"], n = 1
Output: 6
Explanation: A possible sequence is A → B → C → D → A → B

**Example 3**

Input: tasks = ["A","A","A","B","B","B"], n = 3
Output: 10
Explanation: A possible sequence is A → B → idle → idle → A → B → idle → idle → A → B

### Constraints

- `1 <= tasks.length <= 10^4`
- `tasks[i]` is an uppercase English letter `'A'` to `'Z'`
- `0 <= n <= 100`

### Notes

- Tasks can be executed in any order.
- The CPU may remain idle if no task is eligible for execution due to the cooling constraint.
- The optimal strategy minimizes idle time while respecting the cooling interval.

# Greedy Approach

## **Intuition**

The total number of CPU intervals consists of **busy slots** (where tasks are executed) and **idle slots** (where the CPU waits due to cooling constraints). Since every task must be executed once, the number of busy slots is simply `len(tasks)`.

The challenge is to **minimize idle slots** caused by the cooling interval `n` between identical tasks.

Let `f_max` be the frequency of the most common task. In the worst case, we need to space out these `f_max` instances with at least `n` intervals between them. This gives a **maximum idle time** of:

```sh
idle_time ≤ (f_max - 1) * n
```

However, this idle time can be reduced by **filling idle slots with other tasks**. The greedy idea is to prioritize scheduling the most frequent tasks first, then use less frequent tasks to fill the gaps.

## **Algorithm**

1. **Count Frequencies**  
   Create an array `freq` of size 26 to count the frequency of each task (A–Z).

2. **Sort Frequencies**  
   Sort `freq` in descending order. Let `f_max = freq[0]`.

3. **Initial Idle Time**  
   Compute the initial idle time:
   ```
   idle_time = (f_max - 1) * n
   ```

4. **Fill Idle Slots Greedily**  
   For each remaining frequency `f` in `freq[1:]`, reduce `idle_time` by:
   ```
   idle_time -= min(f_max - 1, f)
   ```
   This ensures we only fill up to `f_max - 1` gaps per task.

5. **Clamp Idle Time**  
   Idle time cannot be negative:
   ```
   idle_time = max(0, idle_time)
   ```

6. **Return Total Time**  
   The total time is:
   ```
   total_intervals = len(tasks) + idle_time
   ```

### Example

```text
tasks = ["A","A","A","B","B","B"], n = 2

freq = [3, 3] → f_max = 3
idle_time = (3 - 1) * 2 = 4

Fill idle slots:
- B fills 2 slots → idle_time -= 2 → idle_time = 2

Total time = 6 (tasks) + 2 (idle) = 8
```

### **Pseudocode**

```sh
function leastInterval(tasks, n):
    # Step 1: Count frequency of each task
    freq = array of size 26 initialized to 0
    for task in tasks:
        index = ASCII value of task - ASCII value of 'A'
        freq[index] += 1

    # Step 2: Sort frequencies in descending order
    sort freq in descending order

    # Step 3: Identify max frequency
    f_max = freq[0]

    # Step 4: Calculate initial idle time
    idle_time = (f_max - 1) * n

    # Step 5: Fill idle slots with other tasks
    for i from 1 to 25:
        if freq[i] == 0:
            break
        idle_time -= min(f_max - 1, freq[i])

    # Step 6: Clamp idle time to zero
    idle_time = max(0, idle_time)

    # Step 7: Return total intervals
    return length of tasks + idle_time
```

## **Implementation**

### Java

```java
import java.util.Arrays;

class Solution {
  public int leastInterval(char[] tasks, int n) {
    // Step 1: Count frequency of each task
    int[] freq = new int[26];
    for (char task : tasks) {
      freq[task - 'A']++;
    }

    // Step 2: Sort frequencies in descending order
    Arrays.sort(freq);

    // Step 3: Get the max frequency
    int f_max = freq[25];

    // Step 4: Calculate initial idle time
    int idle_time = (f_max - 1) * n;

    // Step 5: Fill idle slots with other tasks
    for (int i = 24; i >= 0 && idle_time > 0; i--) {
      idle_time -= Math.min(f_max - 1, freq[i]);
    }

    // Step 6: Clamp idle time to zero
    idle_time = Math.max(0, idle_time);

    // Step 7: Return total intervals
    return tasks.length + idle_time;
  }
}
```
