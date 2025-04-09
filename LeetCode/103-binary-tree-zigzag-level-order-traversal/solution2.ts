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

function zigzagLevelOrder(root: TreeNode | null): number[][] {
  if (root === null) {
    return [];
  }

  const result: number[][] = [];
  const queue: TreeNode[] = [root];
  let leftToRight = true;

  while (queue.length > 0) {
    const levelSize = queue.length;
    const levelValues: number[] = [];

    for (let i = 0; i < levelSize; i++) {
      const currentNode = queue.shift()!;
      
      // Add value to level based on direction
      if (leftToRight) {
        levelValues.push(currentNode.val);
      } else {
        levelValues.unshift(currentNode.val);
      }

    }

  }

  return result;
}