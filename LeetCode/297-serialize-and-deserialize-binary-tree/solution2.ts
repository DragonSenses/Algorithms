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
 * Serializes a binary tree into a comma‑delimited string
 * using BFS (level‑order) traversal.
 *
 * Each node is emitted in level order, and null children
 * are represented using a NULL_MARKER token. This ensures
 * the structure can be reconstructed unambiguously.
 *
 * @param root - The root of the binary tree
 * @returns A serialized BFS string representation of the tree
 */
function serialize(root: TreeNode | null): string {
  // Empty tree → return null marker
  if (root === null) return NULL_MARKER;

  const out: string[] = [];
  const queue: Array<TreeNode | null> = [root];

  // Standard BFS traversal
  while (queue.length > 0) {
    const node = queue.shift()!;

    if (node === null) {
      // Explicitly encode missing children
      out.push(NULL_MARKER);
      continue;
    }

    // Emit node value
    out.push(String(node.val));

    // Enqueue children (may be null)
    queue.push(node.left);
    queue.push(node.right);
  }

  return out.join(DELIM);
};

/**
 * Deserializes a BFS‑encoded string back into a binary tree.
 *
 * The token stream is consumed level‑by‑level. Each parent
 * node pulls its left and right child tokens in order, and
 * non‑null children are enqueued for further expansion.
 *
 * @param data - The serialized BFS string
 * @returns The reconstructed binary tree root
 */
function deserialize(data: string): TreeNode | null {
  // Empty input → empty tree
  if (data.length === 0) return null;

  const tokens = data.split(DELIM);

  // First token represents the root
  if (tokens[0] === NULL_MARKER) return null;

  // Create root node
  const root = new TreeNode(Number(tokens[0]));
  const queue: TreeNode[] = [root];

  let index = 1;

  // BFS reconstruction: assign children level by level
  while (queue.length > 0 && index < tokens.length) {
    const parent = queue.shift()!;

    // ----- Left child -----
    const leftToken = tokens[index++];
    if (leftToken !== NULL_MARKER) {
      const leftNode = new TreeNode(Number(leftToken));
      parent.left = leftNode;
      queue.push(leftNode);
    }

    // ----- Right child -----
    // Right token may not exist if the stream ends on a left child
    if (index < tokens.length) {
      const rightToken = tokens[index++];
      if (rightToken !== NULL_MARKER) {
        const rightNode = new TreeNode(Number(rightToken));
        parent.right = rightNode;
        queue.push(rightNode);
      }
    }
  }

  return root;
};
