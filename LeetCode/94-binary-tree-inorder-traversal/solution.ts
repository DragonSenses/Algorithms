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
 * Performs in-order traversal of a binary tree.
 * @param root - The root of the binary tree.
 * @returns An array containing the in-order traversal of the tree.
 */
function inorderTraversal(root: TreeNode | null): number[] {
  const result: number[] = [];
  const stack: TreeNode[] = [];
  let current: TreeNode | null = root;

  while (current !== null || stack.length > 0) {
    // Traverse the left subtree
    while (current !== null) {
      stack.push(current);
      current = current.left;
    }

    // Visit the node
    current = stack.pop()!;
    result.push(current.val);

    // Traverse the right subtree
    current = current.right;
  }

  return result;
}
