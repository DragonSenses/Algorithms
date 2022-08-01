import java.util.ArrayDeque;
import java.util.Deque;
// import java.util.Stack;

public class DepthFirstSearch <E> {
    
    /**
     * A Depth First Search without Recursion
     * @param root The first node to begin the search
     */
    public void DepthFirstSearchIterative(Node<E> root){
        Deque<Node<E>> stack = new ArrayDeque<>();
        stack.push(root);

        Node<E> curr;    // Keep track of current node
        while(!stack.isEmpty()) { // While Stack is non-empty
            curr = stack.pop(); 
            if(!(curr.isVisited())){
                curr.visit();   // Visit the current node
                // For every node
                for(Node<E> node : adjacencyMap.get(curr) )
            }
        }
    }
}
