/**
 * Represents a node in a binary tree.
 */
class TreeNode {
  val: number;
  left: TreeNode | null;
  right: TreeNode | null;

  constructor(val: number, left?: TreeNode | null, right?: TreeNode | null) {
    this.val = val;
    this.left = left === undefined ? null : left;
    this.right = right === undefined ? null : right;
  }
}

/**
 * Performs Morris in-order traversal on the binary tree and returns the in-order traversal as an array of numbers.
 *
 * Morris Traversal is an in-order traversal algorithm with O(1) space complexity.
 *
 * @param root - The root node of the binary tree.
 * @returns An array of numbers representing the in-order traversal of the binary tree.
 */
function inorderTraversal(root: TreeNode | null): number[] {
  const result: number[] = [];
  let current: TreeNode | null = root;

  // Traverse the tree
  while (current !== null) {
    if (current.left === null) {
      // If there is no left child, visit this node and move to the right
      result.push(current.val);
      current = current.right;
    } else {
      // Find the inorder predecessor of current
      let predecessor = current.left;
      while (predecessor.right !== null && predecessor.right !== current) {
        predecessor = predecessor.right;
      }

      if (predecessor.right === null) {
        // Establish the link to return to the current node
        predecessor.right = current;
        current = current.left;
      } else {
        // Remove the established link and visit this node
        predecessor.right = null;
        result.push(current.val);
        current = current.right;
      }
    }
  }

  return result;
}
