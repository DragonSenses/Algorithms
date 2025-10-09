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

function buildTree(preorder: number[], inorder: number[]): TreeNode | null {
  let preorderIndex = 0;
  const inorderIndexMap = new Map<number, number>();

  for (let i = 0; i < inorder.length; i++) {
    inorderIndexMap.set(inorder[i], i);
  }

  function arrayToTree(left: number, right: number): TreeNode | null {
    // Base Case: Empty Subtree
    if (left > right) return null;

    const rootValue = preorder[preorderIndex++];
    const root = new TreeNode(rootValue);

    const rootIndex = inorderIndexMap.get(rootValue)!;

    root.left = arrayToTree(left, rootIndex - 1);
    root.right = arrayToTree(rootIndex + 1, right);

  }

}
