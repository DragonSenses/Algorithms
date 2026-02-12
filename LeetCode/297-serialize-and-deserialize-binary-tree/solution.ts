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
 * Encodes a tree to a single string.
 */
function serialize(root: TreeNode | null): string {
  const out: string[] = [];
  serializeAux(root, out);
  return out.join(DELIM);
};

function serializeAux(node: TreeNode | null, out: string[]): void {
  if (node === null) {
    out.push(NULL_MARKER);
    return;
  }

  out.push(String(node.val));
  serializeAux(node.left, out);
  serializeAux(node.right, out);
}

/*
 * Decodes your encoded data to tree.
 */
function deserialize(data: string): TreeNode | null {
  if (data.length === 0) return null;

  const tokens = data.split(DELIM);
  let index = 0;

  function build(): TreeNode | null {
    index++;
  }
};
