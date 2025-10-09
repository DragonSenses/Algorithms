/**
 * Definition for a binary tree node.
 */
class TreeNode {
  val: number;
  left: TreeNode | null;
  right: TreeNode | null;

  /**
   * Constructs a new TreeNode.
   * @param val - The value of the node.
   * @param left - The left child node.
   * @param right - The right child node.
   */
  constructor(val?: number, left?: TreeNode | null, right?: TreeNode | null) {
    this.val = val === undefined ? 0 : val;
    this.left = left === undefined ? null : left;
    this.right = right === undefined ? null : right;
  }
}

/**
 * Builds a binary tree from preorder and inorder traversal arrays.
 *
 * @param preorder - The preorder traversal of the tree (root → left → right).
 * @param inorder - The inorder traversal of the tree (left → root → right).
 * @returns The root node of the reconstructed binary tree.
 *
 * @remarks
 * This function uses a recursive helper to construct the tree by:
 * - Picking the current root from the preorder array.
 * - Finding its index in the inorder array to split left and right subtrees.
 * - Recursively building left and right subtrees.
 */
function buildTree(preorder: number[], inorder: number[]): TreeNode | null {
  // Tracks the current index in preorder traversal
  let preorderIndex = 0;

  // Maps each value in inorder traversal to its index for quick lookup
  const inorderIndexMap = new Map<number, number>();
  for (let i = 0; i < inorder.length; i++) {
    inorderIndexMap.set(inorder[i], i);
  }

  /**
   * Recursively constructs the binary tree from preorder and inorder slices.
   *
   * @param left - Left boundary index in the inorder array.
   * @param right - Right boundary index in the inorder array.
   * @returns The root node of the subtree.
   */
  function arrayToTree(left: number, right: number): TreeNode | null {
    // Base case: no elements to construct the subtree
    if (left > right) return null;

    // Select the current root value from preorder traversal
    const rootValue = preorder[preorderIndex++];
    const root = new TreeNode(rootValue);

    // Find the index of the root in inorder traversal
    const rootIndex = inorderIndexMap.get(rootValue)!;

    // Recursively build the left subtree
    root.left = arrayToTree(left, rootIndex - 1);

    // Recursively build the right subtree
    root.right = arrayToTree(rootIndex + 1, right);

    return root;
  }

  // Initiate the recursive tree construction
  return arrayToTree(0, inorder.length - 1);
}