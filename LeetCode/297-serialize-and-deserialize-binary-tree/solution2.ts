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

};

/*
 * Decodes the BFS string back into a tree.
 */
function deserialize(data: string): TreeNode | null {

};
