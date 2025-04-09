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
 * Returns the zigzag level order traversal of a binary tree.
 * In zigzag traversal, the nodes at each level are traversed in alternating left-to-right and right-to-left order.
 * 
 * @param root - The root node of the binary tree.
 * @returns A 2D array where each subarray contains the values of the nodes at a specific level.
 */
function zigzagLevelOrder(root: TreeNode | null): number[][] {
  // Handle the edge case where the tree is empty
  if (root === null) {
    return [];
  }

  // Initialize the result array to store level order values
  const result: number[][] = [];
  
  // Use a queue to facilitate level order traversal
  const queue: TreeNode[] = [root];
  
  // A flag to control the zigzag direction, starting with left-to-right
  let leftToRight = true;

  // Continue until there are nodes to process
  while (queue.length > 0) {
    const levelSize = queue.length; // Number of nodes at the current level
    const levelValues: number[] = []; // Array to store values of the current level

    // Traverse all nodes at the current level
    for (let i = 0; i < levelSize; i++) {
      // Remove the first node from the queue
      const currentNode = queue.shift()!;
      
      // Add the node's value to the level array based on the current direction
      if (leftToRight) {
        levelValues.push(currentNode.val);
      } else {
        levelValues.unshift(currentNode.val); // Reverse order
      }

      // Enqueue the left and right children, if they exist
      if (currentNode.left) {
        queue.push(currentNode.left);
      }
      if (currentNode.right) {
        queue.push(currentNode.right);
      }
    }

    // Add the current level's values to the result array
    result.push(levelValues);

    // Toggle the direction for the next level
    leftToRight = !leftToRight;
  }

  // Return the final zigzag level order traversal
  return result;
}