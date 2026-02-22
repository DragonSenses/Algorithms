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

/**
 * Serializes a binary tree into a comma‑delimited preorder string.
 *
 * Uses preorder DFS (node → left → right) and inserts an explicit
 * null marker for absent children to ensure lossless reconstruction.
 *
 * @param root The root of the binary tree.
 * @returns A serialized string representation of the tree.
 */
function serialize(root: TreeNode | null): string {
  const out: string[] = [];
  serializeAux(root, out);
  return out.join(DELIM);
}

/**
 * Recursively appends node values or null markers to the output array.
 * Preorder traversal ensures deterministic token ordering.
 *
 * @param node Current node being visited.
 * @param out Accumulator for serialized tokens.
 */
function serializeAux(node: TreeNode | null, out: string[]): void {
  if (node === null) {
    out.push(NULL_MARKER);
    return;
  }

  out.push(String(node.val));
  serializeAux(node.left, out);
  serializeAux(node.right, out);
}

/**
 * Deserializes a comma‑delimited preorder string back into a binary tree.
 *
 * Splits the serialized data into tokens and reconstructs the tree
 * using a recursive builder that consumes tokens in preorder.
 *
 * @param data Serialized tree data.
 * @returns The reconstructed binary tree root.
 */
function deserialize(data: string): TreeNode | null {
  if (data.length === 0) return null;

  // Token stream produced by preorder serialization
  const tokens = data.split(DELIM);

  // Shared cursor into the token array; captured by the builder closure
  let index = 0;

  /**
   * Recursively rebuilds the tree by consuming tokens in preorder.
   * Each call advances the shared index, ensuring deterministic traversal.
   *
   * @returns The reconstructed subtree root.
   */
  function build(): TreeNode | null {
    const token = tokens[index];
    index++; // Move to next token for subsequent recursive calls

    // Null marker represents an absent child
    if (token === NULL_MARKER) {
      return null;
    }

    // Construct node from token and recursively build children
    const node = new TreeNode(Number(token));
    node.left = build();
    node.right = build();
    return node;
  }

  return build();
}