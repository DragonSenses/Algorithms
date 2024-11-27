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

function inorderTraversal(root: TreeNode | null): number[] {
  const answer: number[] = [];

  function inorder(node: TreeNode | null): void {
    if (node === null) {
      return;
    }
    inorder(node.left);  // Visit left subtree first
    answer.push(node.val);  // Visit root node
    inorder(node.right);  // Visit right subtree last
  }

  inorder(root);
  return answer;
};