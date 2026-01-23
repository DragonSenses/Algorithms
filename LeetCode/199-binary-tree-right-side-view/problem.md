# 199. Binary Tree Right Side View

<p>Given the <code>root</code> of a binary tree, imagine yourself standing on the <strong>right side</strong> of it, return <em>the values of the nodes you can see ordered from top to bottom</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">root = [1,2,3,null,5,null,4]</span></p>

<p><strong>Output:</strong> <span class="example-io">[1,3,4]</span></p>

<p><strong>Explanation:</strong></p>

<p><img alt="" style="width: 400px; height: 207px;" src="img/199-1.jpg"></p>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">root = [1,2,3,4,null,null,null,5]</span></p>

<p><strong>Output:</strong> <span class="example-io">[1,3,4,5]</span></p>

<p><strong>Explanation:</strong></p>

<p><img alt="" style="width: 400px; height: 214px;" src="img/199-2.jpg"></p>
</div>

<p><strong class="example">Example 3:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">root = [1,null,3]</span></p>

<p><strong>Output:</strong> <span class="example-io">[1,3]</span></p>
</div>

<p><strong class="example">Example 4:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">root = []</span></p>

<p><strong>Output:</strong> <span class="example-io">[]</span></p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
  <li>The number of nodes in the tree is in the range <code>[0, 100]</code>.</li>
  <li><code>-100 &lt;= Node.val &lt;= 100</code></li>
</ul>

---

# Solution

- [Breadth-First Search Approach: Two Queues](#breadth-first-search-approach-two-queues)
  - **Time Complexity**: `O(n)`
  - **Space Complexity**: `O(n)`
- [Depth-First Search Approach](#depth-first-search-approach)
  - **Space Complexity**: `O(h)`

## **Problem Overview: Binary Tree Right Side View**

Given the `root` of a binary tree, imagine standing on the **right side** of the tree. From this perspective, only certain nodes are visible. Your task is to return the **values of the visible nodes**, ordered from **top to bottom**.

This is essentially asking for the **rightmost node at each depth level** of the tree.

## Key Idea

A binary tree can have multiple nodes at each depth, but when viewed from the right side, only the **last node** at each level is visible.

Two common strategies solve this:

### 1. Level-Order Traversal (BFS)
- Traverse the tree level by level.
- At each level, record the **last node** encountered.

### 2. Depth-First Search (DFS)
- Traverse the tree prioritizing the **right child first**.
- The first node visited at each depth is the visible one.

## Examples

### Example 1
**Input:**  
`root = [1,2,3,null,5,null,4]`

**Output:**  
`[1,3,4]`

This corresponds to the rightmost nodes at each level.

### Example 2
**Input:**  
`root = [1,2,3,4,null,null,null,5]`

**Output:**  
`[1,3,4,5]`

### Example 3
**Input:**  
`root = [1,null,3]`

**Output:**  
`[1,3]`

### Example 4
**Input:**  
`root = []`

**Output:**  
`[]`

## Constraints
- Number of nodes: `[0, 100]`
- Node values: `-100 <= Node.val <= 100`

# Breadth-First Search Approach: Two Queues

## **Intuition**

This method uses **two queues** to process the tree level by level.  
One queue holds all nodes of the **current level**, while the other collects nodes for the **next level**.

As we dequeue nodes from the current level, we enqueue their children into the next‑level queue.  
When the current level becomes empty, the **last node we processed** is exactly the node visible from the right side at that depth.

This works because BFS guarantees we process nodes left‑to‑right within each level, so the final node encountered is the rightmost one.

## **Algorithm**

1. Initialize an empty list `rightside` to store the right‑side view.

2. Create two queues:
   - `currLevel` — initially empty  
   - `nextLevel` — initially containing only `root` (if it exists)

3. While `nextLevel` is not empty:
   - Assign `currLevel = nextLevel` and reset `nextLevel` to empty.
   - While `currLevel` is not empty:
     - Dequeue a node `node` from `currLevel`.
     - Enqueue `node.left` and then `node.right` into `nextLevel` (if they exist).
   - After `currLevel` becomes empty, the last processed `node` is the rightmost node of this level. Append its value to `rightside`.

4. Return `rightside`.

### **Pseudocode**

```plaintext
function rightSideView(root):
  if root is null:
    return empty list

  rightside = empty list
  nextLevel = queue containing root

  while nextLevel is not empty:
    currLevel = nextLevel
    nextLevel = empty queue

    while currLevel is not empty:
      node = dequeue(currLevel)

      if node.left is not null:
        enqueue(nextLevel, node.left)

      if node.right is not null:
        enqueue(nextLevel, node.right)

    append node.value to rightside

  return rightside
```

## **Implementation**

### Java

```java
class Solution {
  public List<Integer> rightSideView(TreeNode root) {
    List<Integer> rightside = new ArrayList<>();
    if (root == null) return rightside;

    Queue<TreeNode> nextLevel = new LinkedList<>();
    nextLevel.add(root);

    while (!nextLevel.isEmpty()) {
      Queue<TreeNode> currLevel = nextLevel;
      nextLevel = new LinkedList<>();
      TreeNode node = null;

      while (!currLevel.isEmpty()) {
        node = currLevel.poll();

        if (node.left != null) {
          nextLevel.add(node.left);
        }
        if (node.right != null) {
          nextLevel.add(node.right);
        }
      }

      if (node != null) {
        rightside.add(node.val);
      }
    }

    return rightside;
  }
}
```

### TypeScript

```typescript
function rightSideView(root: TreeNode | null): number[] {
  const rightside: number[] = [];
  if (root === null) return rightside;

  let nextLevel: TreeNode[] = [root];

  while (nextLevel.length > 0) {
    const currLevel = nextLevel;
    nextLevel = [];
    let node: TreeNode | null = null;

    for (let i = 0; i < currLevel.length; i++) {
      node = currLevel[i];

      if (node.left) {
        nextLevel.push(node.left);
      }
      if (node.right) {
        nextLevel.push(node.right);
      }
    }

    if (node) {
      rightside.push(node.val);
    }
  }

  return rightside;
}
```

## **Complexity Analysis**

### **Assumptions**
- `n` is the number of nodes in the binary tree.
- Each node is visited exactly once.
- The queue used for BFS may hold up to an entire level of the tree.

### **Time Complexity**: `O(n)`
- **Single Pass Over All Nodes**: Each node is enqueued and dequeued exactly once.
- **Constant Work Per Node**: Processing a node involves only pointer checks and queue operations.

### **Space Complexity**: `O(n)`
- **Level-Order Queue Growth**: In the worst case (e.g., a complete binary tree), the queue may contain up to `n/2` nodes at the widest level.
- **Output List Scales With Height**: The result list stores one value per depth level, which is at most `O(n)` in a skewed tree.

# Depth-First Search Approach

## **Intuition**

The right‑side view depends on seeing the **first node encountered at each depth when exploring rightward before leftward**.  
DFS gives you this naturally:  
- Visit `right` first so the earliest node at a given depth is the visible one.  
- Track the current depth.  
- When you reach a depth you haven't seen before, record that node's value.  
Everything else is just traversal order.

## **Algorithm**

1. Maintain an array `rightside` to store the first node seen at each depth.  
2. Define a recursive function `dfs(node, depth)`.  
3. If `node` is null, return.  
4. If `depth` equals `rightside.length`, this is the first node at this depth -> append its value.  
5. Recurse into `node.right` with `depth + 1`.  
6. Then recurse into `node.left` with `depth + 1`.  
7. Start with `dfs(root, 0)` and return `rightside`.

### **Pseudocode**

```
function rightSideViewDFS(root):
  rightside = empty list

  function dfs(node, depth):
    if node is null:
      return

    if depth == length(rightside):
      append node.value to rightside

    dfs(node.right, depth + 1)
    dfs(node.left, depth + 1)

  dfs(root, 0)
  return rightside
```

## **Implementation**

### Java

```java
class Solution {
  public List<Integer> rightSideView(TreeNode root) {
    List<Integer> rightside = new ArrayList<>();
    dfs(root, 0, rightside);
    return rightside;
  }

  private void dfs(TreeNode node, int depth, List<Integer> rightside) {
    if (node == null) return;

    if (depth == rightside.size()) {
      rightside.add(node.val);
    }

    dfs(node.right, depth + 1, rightside);
    dfs(node.left, depth + 1, rightside);
  }
}
```

### TypeScript

```typescript
function rightSideView(root: TreeNode | null): number[] {
  const rightside: number[] = [];
  dfs(root, 0, rightside);
  return rightside;
}

function dfs(node: TreeNode | null, depth: number, rightside: number[]): void {
  if (node === null) return;

  if (depth === rightside.length) {
    rightside.push(node.val);
  }

  dfs(node.right, depth + 1, rightside);
  dfs(node.left, depth + 1, rightside);
}
```

## **Complexity Analysis**

### **Assumptions**
- `n` is the total number of nodes in the binary tree.
- DFS visits each node exactly once.
- The recursion stack depth depends on the tree's height.

### **Space Complexity**: `O(h)`
- **Recursion Stack Depth**: DFS uses call stack space proportional to the tree height `h`.  
  - Worst case (skewed tree): `h = n` -> `O(n)` space.  
  - Best case (balanced tree): `h = log n` -> `O(log n)` space.
- **Output List Scales With Depth**: The result stores one value per depth level, contributing up to `O(h)` additional space.
