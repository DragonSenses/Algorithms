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
  
}

/*
 * Decodes your encoded data to tree.
 */
function deserialize(data: string): TreeNode | null {

};
