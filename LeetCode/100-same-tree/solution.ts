/**
 * Definition for a binary tree node.
 */
class TreeNode {
  val: number;
  left: TreeNode | null;
  right: TreeNode | null;

  constructor(val?: number, left?: TreeNode | null, right?: TreeNode | null) {
    this.val = val === undefined ? 0 : val;
    this.left = left === undefined ? null : left;
    this.right = right === undefined ? null : right;
  }
}

function isEqual(p: TreeNode | null, q: TreeNode | null): boolean {
  // Both nodes are null
  if (p === null && q === null) return true;
  // One of the nodes is null
  if (p === null || q === null) return false;
  // Node values are not equal
  if (p.val !== q.val) return false;
  return true;
}

function isSameTree(p: TreeNode | null, q: TreeNode | null): boolean {
  // Check if both trees are initially empty
  if (p === null && q === null) return true;
  // Check if the initial nodes are not equal
  if (!isEqual(p, q)) return false;

  // Initialize queues to store nodes for comparison
  const queueP: (TreeNode | null)[] = [];
  const queueQ: (TreeNode | null)[] = [];
  queueP.push(p);
  queueQ.push(q);

  // Iterate while there are nodes to compare
  while (queueP.length > 0) {
    p = queueP.shift()!;
    q = queueQ.shift()!;

    // If nodes are not equal
    if (!isEqual(p, q)) return false;
    // If current nodes are not null, add their children to the queues
    if (p !== null && q !== null) {
      queueP.push(p.left);
      queueQ.push(q.left);
      queueP.push(p.right);
      queueQ.push(q.right);
    }
  }
  return true;
};
