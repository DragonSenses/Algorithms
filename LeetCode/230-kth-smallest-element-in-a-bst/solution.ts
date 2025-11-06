/**
 * Class representing a tree node.
 */
class TreeNode {
  val: number;
  left: TreeNode | null;
  right: TreeNode | null;

  /**
   * Creates an instance of TreeNode.
   * @param {number} [val=0] - The value of the node.
   * @param {TreeNode | null} [left=null] - The left child of the node.
   * @param {TreeNode | null} [right=null] - The right child of the node.
   */
  constructor(val?: number, left?: TreeNode | null, right?: TreeNode | null) {
    this.val = val === undefined ? 0 : val;
    this.left = left === undefined ? null : left;
    this.right = right === undefined ? null : right;
  }
}

function kthSmallest(root: TreeNode | null, k: number): number {
  let count = 0;
  let result = -1;

  function inorder(node: TreeNode | null): void {
    if (!node) return;


}
