# 147. Insertion Sort List

<p>Given the <code>head</code> of a singly linked list, sort the list using <strong>insertion sort</strong>, and return <em>the sorted list's head</em>.</p>

<p>The steps of the <strong>insertion sort</strong> algorithm:</p>

<ol>
  <li>Insertion sort iterates, consuming one input element each repetition and growing a sorted output list.</li>
  <li>At each iteration, insertion sort removes one element from the input data, finds the location it belongs within the sorted list and inserts it there.</li>
  <li>It repeats until no input elements remain.</li>
</ol>

<p>The following is a graphical example of the insertion sort algorithm. The partially sorted list (black) initially contains only the first element in the list. One element (red) is removed from the input data and inserted in-place into the sorted list with each iteration.</p>
<img alt="" src="img/147-3.gif" style="height: 180px; width: 300px;">
<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="img/147-1.jpg" style="width: 422px; height: 222px;">
<pre><strong>Input:</strong> head = [4,2,1,3]
<strong>Output:</strong> [1,2,3,4]
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="img/147-2.jpg" style="width: 542px; height: 222px;">
<pre><strong>Input:</strong> head = [-1,5,3,4,0]
<strong>Output:</strong> [-1,0,3,4,5]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
  <li>The number of nodes in the list is in the range <code>[1, 5000]</code>.</li>
  <li><code>-5000 &lt;= Node.val &lt;= 5000</code></li>
</ul>

<br>

---

# Solution
- [Insertion Sort](#insertion-sort)


## Insertion Sort List Overview

[**Insertion sort**](https://en.wikipedia.org/wiki/Insertion_sort) is an intuitive, yet less efficient sorting algorithm compared to quicksort or merge sort.

While typically applied to arrays, this problem requires performing insertion sort on a linked list, adding complexity.

This article offers tricks to simplify linked list manipulation for easier implementation.

# Insertion Sort

## **Intuition**

## Intuition

Let's review the idea of the insertion sort algorithm, which can be broken down into the following steps:

1. **Create an empty list** to hold the sorted elements.

2. **Iterate through each element** in the input list:
    - For each element, find the correct position in the sorted list to insert it, maintaining the order.

3. Once the iteration completes, you will have a sorted list.

### Example Walkthrough:

Given the input list `input = [4, 3, 5]`:

1. Start with an empty sorted list: `result = []`.

2. **First element (4)**:
    - Insert 4 into the empty sorted list.
    - `result = [4]`.

![](img/147-4.jpg)

3. **Second element (3)**:
    - Find the correct position for 3 in the sorted list.
    - Insert 3 before 4.
    - `result = [3, 4]`.

![](img/147-5.jpg)

4. **Third element (5)**:
    - Find the correct position for 5 in the sorted list.
    - Insert 5 at the end.
    - `result = [3, 4, 5]`.

![](img/147-6.jpg)

After these steps, the input list is sorted as `result = [3, 4, 5]`.

