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

/**
 * Computes the right-side view of a binary tree using a depth-first search.
 * The traversal visits right children before left children so the first node
 * encountered at each depth becomes the visible node from the right side.
 *
 * @param root - The root of the binary tree, or null if the tree is empty.
 * @returns An array of node values representing the rightmost node at each depth.
 */
function rightSideView(root: TreeNode | null): number[] {
  const rightside: number[] = [];
  dfs(root, 0, rightside);
  return rightside;
}

/**
 * Performs a right-first depth-first traversal of the tree.
 * Records the first node encountered at each depth, which corresponds
 * to the rightmost visible node for that level.
 *
 * @param node - The current node being visited.
 * @param depth - The current depth in the tree (root starts at depth 0).
 * @param rightside - The array accumulating the right-side view values.
 */
function dfs(node: TreeNode | null, depth: number, rightside: number[]): void {
  if (node === null) return;

  // If this is the first time reaching this depth, record the node's value
  if (depth === rightside.length) {
    rightside.push(node.val);
  }

  // Visit right subtree first to ensure rightmost nodes are seen first
  dfs(node.right, depth + 1, rightside);
  dfs(node.left, depth + 1, rightside);
}