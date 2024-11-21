/**
 * Class representing a tree node.
 */
class TreeNode {
  val: number;
  left: TreeNode | null;
  right: TreeNode | null;

  /**
   * Creates an instance of TreeNode.
   * @param {number} [val=0] - The value of the node.
   * @param {TreeNode | null} [left=null] - The left child of the node.
   * @param {TreeNode | null} [right=null] - The right child of the node.
   */
  constructor(val?: number, left?: TreeNode | null, right?: TreeNode | null) {
    this.val = val === undefined ? 0 : val;
    this.left = left === undefined ? null : left;
    this.right = right === undefined ? null : right;
  }
}

/**
 * Performs an iterative postorder traversal of a binary tree.
 * @param {TreeNode | null} root - The root node of the binary tree.
 * @returns {number[]} - The postorder traversal of the tree.
 */
function postorderTraversal(root: TreeNode | null): number[] {
  const answer: number[] = [];
  if (!root) {
    return answer;
  }

  // Stack to traverse the tree
  const stack: TreeNode[] = [];
  // Output stack to reverse the order
  const output: TreeNode[] = [];

  // Start with the root node
  stack.push(root);

  // Traverse the tree
  while (stack.length) {
    // Pop the current node from the stack
    const currNode = stack.pop()!;
    // Push the current node to the output stack
    output.push(currNode);

    // Push the left child to the stack if it exists
    if (currNode.left) {
      stack.push(currNode.left);
    }
    // Push the right child to the stack if it exists
    if (currNode.right) {
      stack.push(currNode.right);
    }
  }

  // Collect nodes in postorder from the output stack
  while (output.length) {
    answer.push(output.pop()!.val);
  }

  return answer;
}
