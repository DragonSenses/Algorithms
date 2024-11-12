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

function preorderTraversal(root: TreeNode | null): number[] {
  const answer: number[] = [];
  const stack: (TreeNode | null)[] = [];

  if (root !== null) {
    stack.push(root);
  }

  while (stack.length > 0) {
    const currNode = stack.pop();
    if (currNode !== null) {
      answer.push(currNode.val);
      if (currNode.right !== null) {
        stack.push(currNode.right);
      }
      if (currNode.left !== null) {
        stack.push(currNode.left);
      }
    }
  }

  return answer;
};
