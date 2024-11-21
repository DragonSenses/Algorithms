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

function postorderTraversal(root: TreeNode | null): number[] {
  const answer: number[] = [];
  if (!root) {
    return answer;
  }

  const stack: TreeNode[] = [];
  const output: TreeNode[] = [];

  stack.push(root);

  while (stack.length) {
    const currNode = stack.pop()!;
    output.push(currNode);

    if (currNode.left) {
      stack.push(currNode.left);
    }
    if (currNode.right) {
      stack.push(currNode.right);
    }
  }

  while (output.length) {
    answer.push(output.pop()!.val);
  }

  return answer;
}