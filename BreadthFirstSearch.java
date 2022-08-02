import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class BreadthFirstSearch <E> {

    /**
     * Creates meaningful output of the search by consuming the 
     * auxiliary ArrayDeque that results from the search
     * @param aux auxiliary data structure that stores the nodes
     * in the search
     */
    public static <E> void output(Deque<Node<E>> aux){
        StringBuilder output = new StringBuilder("[");
        while(!aux.isEmpty()){
            Node<E> n = aux.pop();
            output.append(n.getData().toString());
            //Add comma in between if not last element
            if(!aux.isEmpty()){ 
                output.append(", ");
            }
        }
        output.append("]");
        System.out.println(output.toString());
    }

    /**
     * An iterative approach to BreadthFirstSearch, which searches
     * through the graph through levels. We process nodes in the
     * order we visit them, processing nodes closer to the root
     * first, whereas nodes furthest from root will be processed lost
     * 
     * @param root Node to start search in
     */
    public void BFS(Graph<E> g, Node<E> root) {
        if (root == null) {
            return;
        }

        // Create a queue that represent levels of nodes close to root
        Deque<Node<E>> queue = new ArrayDeque<>();
        queue.add(root);

        // auxiliary que that helps print the output
        Deque<Node<E>> aux = new ArrayDeque<>();

        Node<E> curr;
        while (!queue.isEmpty()) {
            curr = queue.poll(); // Remove the first element of the queue

            // If the current node has already been visited
            if (curr.isVisited()) {
                continue; // Skip this iteration of the loop
            }

            curr.visit(); // Visit the node
            // Perform an Operation
            aux.add(curr);

            LinkedList<Node<E>> neighbors = g.getNeighbors(curr);

            // If the current node has no neighbors
            if (neighbors == null) { // for each loop throws exception if null
                continue; // skip this iteration of the loop
            }

            // Add unvisited neighbors to the queue
            for (Node<E> node : neighbors) {
                if (!node.isVisited()) {
                    queue.add(node);
                }
            }
        }
        // Use auxiliary queue to create meaningful output
        output(aux);
    }

    /**
     * A BreadthFirstSearch algorithm that modifies above by
     * allowing for graphs with unconnected edges to be completely
     * searched
     * 
     * @param root the node to begin searched rooted at this node
     */
    public void BreadthFirstSearchComplete(Graph<E> g, Node<E> root) {
        BFS(g, root); // Call Search Once
        // Continue calling Search for each node with unconnected edge
        for (Node<E> n : g.getNodes()) {
            if (!n.isVisited()) {
                BFS(g, n);
            }
        }
    }

    public static void testBFS() {
        Graph<Integer> graph = new Graph<Integer>(false);
        Node<Integer> a = new Node<>(0);
        Node<Integer> b = new Node<>(1);
        Node<Integer> c = new Node<>(2);
        Node<Integer> d = new Node<>(3);
        Node<Integer> e = new Node<>(4);

        graph.addEdge(a, d); // 0->3
        graph.addEdge(a, b); // 0->1
        graph.addEdge(a, c); // 0->2
        graph.addEdge(c, d); // 2->3

        System.out.println("======== [Graph 1] Breadth First Search ========");
        // We pass in 1 as root node
        graph.BreadthFirstSearch(b); // result should be 1, 0, 3, 2

        // Graph 2 Tests what happens with an unconnected graph
        System.out.println("======== [Graph 2] Breadth First Search ========");
        graph.reset(); // Reset visited nodes
        graph = new Graph<>(false);
        graph.addEdge(a, d); // 0->3
        graph.addEdge(a, b); // 0->1
        graph.addEdge(c, e); // 2->4
        System.out.println("Breadth First Search, one pass in Unconnected Graph");
        graph.BreadthFirstSearch(a); // Start w/ root node "0", output: [0, 3, 1]
        graph.reset();
        System.out.println("Breadth First Search, complete pass in Unconnected Graph");
        graph.BreadthFirstSearchComplete(a); // output: [0, 3, 1] abd [4, 2]
    }

    public static void main(String[] args){
        boolean test = true;
        if(test) { testBFS(); }
    }
}
