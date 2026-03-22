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

const NULL_MARKER = "#";
const DELIM = ",";

/*
 * Encodes a tree to a single string using BFS level order.
 */
function serialize(root: TreeNode | null): string {
  if (root === null) return NULL_MARKER;

  const out: string[] = [];
  const queue: Array<TreeNode | null> = [root];

  while (queue.length > 0) {
    const node = queue.shift()!;

    if (node === null) {
      out.push(NULL_MARKER);
      continue;
    }

    out.push(String(node.val));
  }

};

/*
 * Decodes the BFS string back into a tree.
 */
function deserialize(data: string): TreeNode | null {

};
