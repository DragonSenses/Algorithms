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

function inorderTraversal(root: TreeNode | null): number[] {
  const result: number[] = [];
  let current: TreeNode | null = root;

  while (current !== null) {
    if (current.left === null) {
      result.push(current.val);
      current = current.right;
    } else {
      let predecessor = current.left;
      while (predecessor.right !== null && predecessor.right !== current) {
        predecessor = predecessor.right;
      }

      if (predecessor.right === null) {
        predecessor.right = current;
        current = current.left;
      } else {
        predecessor.right = null;
        result.push(current.val);
        current = current.right;
      }
    }
  }

  return result;
}
