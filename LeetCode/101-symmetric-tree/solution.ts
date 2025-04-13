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

/**
 * Determines whether a binary tree is symmetric around its center.
 *
 * @param root - The root of the binary tree.
 * @returns True if the tree is symmetric, false otherwise.
 */
function isSymmetric(root: TreeNode | null): boolean {
  if (root === null) {
      return true; // An empty tree is symmetric
  }
  return isMirror(root.left, root.right);
}

/**
* Helper function that checks whether two subtrees are mirror reflections of each other.
*
* @param left - The root of the left subtree.
* @param right - The root of the right subtree.
* @returns True if the subtrees are mirror reflections, false otherwise.
*/
function isMirror(left: TreeNode | null, right: TreeNode | null): boolean {
  // Base cases
  if (left === null && right === null) {
      return true; // Both subtrees are empty
  }
  if (left === null || right === null) {
      return false; // Only one subtree is empty
  }
  if (left.val !== right.val) {
      return false; // Values of the nodes do not match
  }

  // Recursively check for mirror symmetry
  return isMirror(left.left, right.right) && isMirror(left.right, right.left);
}