/**
 * Definition for a binary tree node.
 */
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

/**
 * Perform level-order traversal of a binary tree.
 * @param root - The root node of the binary tree.
 * @returns A two-dimensional array where each sub-array contains the values of nodes at a specific tree level.
 */
function levelOrder(root: TreeNode | null): number[][] {
  // Initialize an array to store node values grouped by their tree level.
  const levels: number[][] = [];

  // Handle the edge case where the tree is empty (root is null).
  if (root === null) {
    return levels; // Return an empty array for an empty tree.
  }

  /**
   * Recursive helper function to populate the levels array.
   * @param node - The current node being processed.
   * @param level - The level of the tree where the node resides.
   */
  const traverseLevels = (node: TreeNode | null, level: number): void => {
    // Base case: Stop recursion if the current node is null.
    if (node === null) {
      return;
    }

    // Ensure the levels array has a sublist for the current level.
    if (levels.length === level) {
      levels.push([]); // Create a new sublist for the current level.
    }

    // Add the current node's value to its corresponding level's sublist.
    levels[level].push(node.val);

    // Recursively process the left subtree, incrementing the level.
    traverseLevels(node.left, level + 1);

    // Recursively process the right subtree, incrementing the level.
    traverseLevels(node.right, level + 1);
  };

  // Begin traversal from the root node at level 0.
  traverseLevels(root, 0);

  return levels; // Return the populated levels array.
};
