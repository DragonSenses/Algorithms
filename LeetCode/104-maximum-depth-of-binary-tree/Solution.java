import java.util.Stack;

public class Solution {
  /**
   * Finds the maximum depth of a binary tree using an iterative approach.
   *
   * @param root The root node of the binary tree.
   * @return The maximum depth of the binary tree.
   */
  public int maxDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }

    Stack<Pair<TreeNode, Integer>> stack = new Stack<>();
    stack.push(new Pair<>(root, 1));
    int maxDepth = 0;

    while (!stack.isEmpty()) {
      Pair<TreeNode, Integer> current = stack.pop();
      TreeNode currentNode = current.getKey();
      int currentDepth = current.getValue();

      if (currentNode != null) {
        maxDepth = Math.max(maxDepth, currentDepth);
        stack.push(new Pair<>(currentNode.left, currentDepth + 1));
        stack.push(new Pair<>(currentNode.right, currentDepth + 1));
      }
    }

    return maxDepth;
  }
}

// Auxiliary class to store tree node and its depth
class Pair<K, V> {
  private final K key;
  private final V value;

  public Pair(K key, V value) {
    this.key = key;
    this.value = value;
  }

  public K getKey() {
    return key;
  }

  public V getValue() {
    return value;
  }
}