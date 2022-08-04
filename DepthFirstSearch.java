import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
/**
 * Work In Progress
 */
public class DepthFirstSearch {
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
     * Iterative Approach DFS rooted at incoming parameter node
     * @param root node to start search with
     */
    public static <E> void DFS(Graph<E> graph, Node<E> root) {
        Deque<Node<E>> stack = new ArrayDeque<>();
        Deque<Node<E>> aux = new ArrayDeque<>(); // for output
        aux.push(root);
        stack.push(root);
        Node<E> curr;
        while(!stack.isEmpty()){
            curr = stack.pop();
            curr.visit();

            LinkedList<Node<E>> neighbors = graph.getNeighbors(root);
            // Check if list is null to prevent NullPointerException
            if(neighbors == null) {
                continue; // skip iteration
            }

            // Otherwise add every unvisited node
            for(Node<E> node: neighbors){
                if(!node.isVisited()){
                    stack.push(node);
                    aux.push(node);
                }
            }
        }
        
        //Create meaningful output
        output(aux);
    }

    // For graphs with unconnected edges, completely searches
    public static <E> void DFScomplete(Graph<E> graph, Node<E> root){
        DFS(graph,root);

        for(Node<E> node: graph.getNodes()){
            if(!node.isVisited()){
                DFS(graph,node);
            }
        }
    }

    /**
     * A Depth First Search without Recursion, an iterative approach
     * While Stack is not Empty
     *  1) Visit Current Node
     *  2) Perform Operation during visit
     *  3) Push unvisited adjacent nodes/vertices
     * @param root The first node to begin the search
     * @returns A doubly ended queue that contains the order of DepthFirstSearch
     * of the nodes of thhe graph rooted at the incoming parameter vertex
     */
    public static <E> Deque<Node<E>> depthFirstSearch(Graph<E> graph, Node<E> root){
        Deque<Node<E>> aux = new ArrayDeque<>();
        Deque<Node<E>> result = new ArrayDeque<>();
        Deque<Node<E>> stack = new ArrayDeque<>();
        stack.push(root);

        Node<E> curr;    // Keep track of current node
        while(!stack.isEmpty()) { // While Stack is non-empty
            curr = stack.pop(); 
            if(!(curr.isVisited())){
                curr.visit();   // 1. Visit the current node
                // 2. Perform the operation
                result.push(curr);
                aux.push(curr);

                // Check if neighbors is null
                LinkedList<Node<E>> neighbors = graph.getNeighbors(curr);
                if(neighbors == null) { continue; } // Skip this iteration

                // 3. Add unvisited adjacent nodes
                // For every node that forms an edge with current node
                for(Node<E> node : graph.getNeighbors(curr)) {
                    // If Node has not been visited, push it within the stack
                    if(!node.isVisited()){
                        stack.push(node);
                    }
                }
            }
        }

        // Attempt with For-Loop
        // for(; !stack.isEmpty(); curr = stack.pop()){
        //     if(!(curr.isVisited())) {
        //         curr.visit();

        //         result.push(curr);
        //         aux.push(curr);

        //         // Check if neighbors is null
        //         LinkedList<Node<E>> neighbors = graph.getNeighbors(curr);
        //         if(neighbors == null) { continue; } // Skip this iteration

        //         // 3. Add unvisited adjacent nodes
        //         // For every node that forms an edge with current node
        //         for(Node<E> node : graph.getNeighbors(curr)) {
        //             // If Node has not been visited, push it within the stack
        //             if(!node.isVisited()){
        //                 stack.push(node);
        //             }
        //         }
        //     }
        // }
        // Create meaningful output
        output(aux);
        return result;
    }

    /**
     * Depth First Search algorithm that allows to completely search
     * a Graph with unconnected edges
     * @param root starting node to begin search in
     */
    public static <E> void DepthFirstSearchComplete(Graph<E> graph, Node<E> root){
        depthFirstSearch(graph, root);

        for(Node<E> node: graph.getNodes()){
            if(!node.isVisited()){
                depthFirstSearch(graph,node);
            }
        }
    }

    public static <E> void DFSRecursive(Graph<E> graph, Node<E> root){
        root.visit();
        System.out.print(root.toString() + " ");

        LinkedList<Node<E>> neighbors = graph.getNeighbors(root);
        // Check if list is null to prevent NullPointerException
        if(neighbors == null) {
            return; // skip iteration
        }

        // Otherwise add every unvisited node
        for(Node<E> node: neighbors){
            if(!node.isVisited()){
                DFSRecursive(graph, node);
            }
        }
    }

    

    public static void simpleTestDFS(){
        Graph<Integer> graph = new Graph<>(false);
        // Create Nodes
        Node<Integer> zero = new Node<>(0);
        Node<Integer> one = new Node<>(1);
        Node<Integer> two = new Node<>(2);
        Node<Integer> three = new Node<>(3);
        Node<Integer> four = new Node<>(4);

        graph.addEdge(zero,one);
        graph.addEdge(zero,two);
        graph.addEdge(two,one);
        graph.addEdge(four,three); // Unconnected

        // Starting at node 1, output should be [1, 0, 2, 4, 3]
        DFS(graph, one);
    }

    public static void testDFS(){
      Graph<Integer> graph = new Graph<>(true);
      // Create Nodes
      Node<Integer> zero = new Node<>(0);
      Node<Integer> one = new Node<>(1);
      Node<Integer> two = new Node<>(2);
      Node<Integer> three = new Node<>(3);
      Node<Integer> four = new Node<>(4);
      Node<Integer> five = new Node<>(5);
      Node<Integer> six = new Node<>(6);
      Node<Integer> seven = new Node<>(7);
      Node<Integer> eight = new Node<>(8);

      graph.addEdge(one,zero);
      graph.addEdge(three,one);
      graph.addEdge(two,seven);
      graph.addEdge(two,four);
      graph.addEdge(five,two);
      graph.addEdge(five,zero);
      graph.addEdge(six,five);
      graph.addEdge(six,three);
      graph.addEdge(six,eight);
      graph.addEdge(seven,five);
      graph.addEdge(seven,six);
      graph.addEdge(seven,eight);

      // The first deep path graph takes when root is node 7
      // is 7, 5, 2, 4
      // then trace back to 5 and continue with edge 5 -> 0
      // then trace back the path to root 7, and continue with edge 7 -> 6
      // 6, 3, 1
      // then trace back the path to root 7 and continue with hedge 7 -> 8
      // so output should be [7, 5, 2 , 4, 0, 6, 3, 1, 8]
      DFSRecursive(graph,seven); 
    }

    public static void test2DFS(){
        Graph<Integer> graph = new Graph<>(true);

        // Create Nodes
        Node<Integer> three = new Node<>(3);
        Node<Integer> five = new Node<>(5);
        Node<Integer> one = new Node<>(1);
        Node<Integer> two = new Node<>(2);
        Node<Integer> eight = new Node<>(8);
        Node<Integer> twentyFive = new Node<>(25);
        Node<Integer> twelve = new Node<>(12);
        Node<Integer> six = new Node<>(6);
        Node<Integer> four = new Node<>(4);
        Node<Integer> nine = new Node<>(9);
        Node<Integer> ten = new Node<>(10);

        // 1st Path: 3->5->1
        graph.addEdge(three,five);
        graph.addEdge(five,one);

        // 2nd Path: 5->2
        graph.addEdge(five,two);

        // 3rd Path: 3->8
        graph.addEdge(three,eight);

        // 4th Path: 3-> 25 -> 12 -> 6 -> 4
        graph.addEdge(three,twentyFive);
        graph.addEdge(twentyFive,twelve);
        graph.addEdge(twelve,six);
        graph.addEdge(six,four);

        // 5th Path: 6->9
        graph.addEdge(six,nine);

        // 6th Path: 25 -> 10
        graph.addEdge(twentyFive,ten);

        DFS(graph,three);
        //Final output: [3, 5, 1, 2, 8, 25, 12, 6, 4, 9, 10]
        
    }

    public static void main(String[] args){


        boolean DFS = true;
        if(DFS) simpleTestDFS(); // 1 0 2 4 3


        // int i = 1;
        // for(; i <4; i++){
        //     System.out.println(i);
        // }
    }
}
