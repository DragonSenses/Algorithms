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
    queue.push(node.left);
    queue.push(node.right);
  }

  return out.join(DELIM);
};

/*
 * Decodes the BFS string back into a tree.
 */
function deserialize(data: string): TreeNode | null {
  if (data.length === 0) return null;

  const tokens = data.split(DELIM);
  if (tokens[0] === NULL_MARKER) return null;

  const root = new TreeNode(Number(tokens[0]));
  const queue: TreeNode[] = [root];

  let index = 1;

  while (queue.length > 0 && index < tokens.length) {
    const parent = queue.shift()!;

    // Left child
    const leftToken = tokens[index++];
    const leftNode = new TreeNode(Number(leftToken));
    parent.left = leftNode;
    queue.push(leftNode);

  }

};
