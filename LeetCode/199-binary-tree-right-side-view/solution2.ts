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
  dfs(root, 0, rightside);
}

function dfs(node: TreeNode | null, depth: number, rightside: number[]): void {
  if (node === null) return;

  if (depth === rightside.length) {
    rightside.push(node.val);
  }

  dfs(node.right, depth + 1, rightside);
  dfs(node.left, depth + 1, rightside);
}