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

function isSameTree(p: TreeNode | null, q: TreeNode | null): boolean {
  // Base case: Both trees are null
  if (p == null && q == null) {
    return true;
  }
  // Base case: One tree is null and the other is not
  if (p == null || q == null) {
    return false;
  }
  // If the values of the nodes are not equal
  if (p.val != q.val) {
    return false;
  }
  // Recursively check the left and right subtrees
  return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
};
