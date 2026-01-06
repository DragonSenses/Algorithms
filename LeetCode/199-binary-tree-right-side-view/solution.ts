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

function rightSideView(root: TreeNode | null): number[] {
  const rightside: number[] = [];
  if (root === null) return rightside;

  let nextLevel: TreeNode[] = [root];

  while (nextLevel.length > 0) {
    const currLevel = nextLevel;
    nextLevel = [];
    let node: TreeNode | null = null;

    for (let i = 0; i < currLevel.length; i++) {
      node = currLevel[i];

      if (node.left) {
        nextLevel.push(node.left);
      }
      if (node.right) {
        nextLevel.push(node.right);
      }
    }

    if (node) {
      rightside.push(node.val);
    }
  }

  return rightside;
}