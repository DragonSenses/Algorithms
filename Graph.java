import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Set;

/**
 * Graph Implementation using an adjacency Map
 */
public class Graph <E>{
    // Graph uses node maps to a LinkedList of all its neighbors
    private HashMap<Node<E>, LinkedList<Node<E>>> adjacencyMap;
    private boolean directed; // Whether Graph is directed or undirected    

    public Graph(boolean directed){
        this.directed = directed;
        adjacencyMap = new HashMap<>();
    }

    public Graph(Boolean directed){
        this.directed = directed;
        adjacencyMap = new HashMap<>();
    }

    /**
     * Returns the set of Nodes, or keys, of the internal HashMap adjacency map
     * @return the set of Nodes, or keys, of the HashMap
     */
    public Set<Node<E>> getNodes(){
        return adjacencyMap.keySet();
    }

    /**
     * Returns the LinkedList of neighbors connected to this node
     * @param n Node to get list of neighbors from
     * @return a list of edges incident to the parameter node
     */
    public LinkedList<Node<E>> getNeighbors(Node<E> n){
        return adjacencyMap.get(n);
    }

    /**
     * Checks for possible duplicate edges, before adding an edge.
     * containg the Nodes u -> v, then update the list of neighbors
     * @param u The origin node of the edge
     * @param v The destination node of the edge
     */
    private void validateEdge(Node<E> u, Node<E> v) {
        // Create a temperorary reference to thhe list of neighbors
        LinkedList<Node<E>> list = adjacencyMap.get(u);
        // If list is non-null, and Node u already contains its own list of neighbors
        if(list != null) {
            // Attempt to remove the existing edge containing Node v
            list.remove(v);
        } else { // If list was already null, then initialize a new list of neighbors
            list = new LinkedList<>();
        }
        list.add(v); // Add the destination node to the list of neighbors of u
        adjacencyMap.put(u,list); // Add the LinkedList within the adjacency Map for node u
    }

    /**
     * Adds the edge with nodes u & v in the Graph.
     * @param u The origin node of the edge
     * @param v The destination node of the edge
     */
    public void addEdge(Node<E> u, Node<E> v){
        // 1. If adjacency map does not contain Node u, then put it in
        if(!adjacencyMap.keySet().contains(u)) {
            adjacencyMap.put(u,null);
        }

        // 2. Likewise, if adjacency map does not contain Node v, then put it in
        if(!adjacencyMap.keySet().contains(v)){
            adjacencyMap.put(v,null);
        }

        // 3. Validate the Edge, adding to their List of neighbors
        validateEdge(u,v);

        // 4. If Graph is undirected, add the edge in reverse, from destination to origin
        if(!directed) {
            validateEdge(v,u);
        }
    }

    /**
     * @returns True if the graph contains the edge with nodes u and v,
     *          false otherwise
     */
    public boolean containsEdge(Node<E> u, Node<E> v){
        return adjacencyMap.containsKey(u) && 
            adjacencyMap.get(u).contains(v);
    }

    /**
     * Resets all the Nodes visited field to false. 
     * Allows for future visits and searches.
     */
    public void reset(){
        for(Node<E> node: adjacencyMap.keySet()){
            node.clear();
        }
    }

    @Override
    public String toString(){
        return "Graph";
    }

    public void print(){
        for(Node<E> n: adjacencyMap.keySet()){
            System.out.print(n.toString() + " has an edge towards:\t");
            for(Node<E> neighbor: adjacencyMap.get(n)){
                System.out.print(neighbor.toString() + " ");
            }
            System.out.println();
        }
    }

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
    public void DFS(Node<E> root) {
        Deque<Node<E>> stack = new ArrayDeque<>();
        Deque<Node<E>> aux = new ArrayDeque<>(); // for output
        aux.push(root);
        stack.push(root);
        Node<E> curr;
        while(!stack.isEmpty()){
            curr = stack.pop();
            curr.visit();

            LinkedList<Node<E>> neighbors = adjacencyMap.get(root);
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
    public void DFScomplete(Node<E> root){
        DFS(root);

        for(Node<E> node: adjacencyMap.keySet()){
            if(!node.isVisited()){
                DFS(node);
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
    public Deque<Node<E>> DepthFirstSearch(Node<E> root){
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
                LinkedList<Node<E>> neighbors = adjacencyMap.get(curr);
                if(neighbors == null) { continue; } // Skip this iteration

                // 3. Add unvisited adjacent nodes
                // For every node that forms an edge with current node
                for(Node<E> node : adjacencyMap.get(curr)) {
                    // If Node has not been visited, push it within the stack
                    if(!node.isVisited()){
                        stack.push(node);
                    }
                }
            }
        }
        // Create meaningful output
        output(aux);
        return result;
    }

    /**
     * Depth First Search algorithm that allows to completely search
     * a Graph with unconnected edges
     * @param root starting node to begin search in
     */
    public void DepthFirstSearchComplete(Node<E> root){
        DepthFirstSearch(root);

        for(Node<E> node: adjacencyMap.keySet()){
            if(!node.isVisited()){
                DepthFirstSearch(node);
            }
        }
    }

    public void DFSRecursive(Node<E> root){
        root.visit();
        System.out.print(root.toString() + " ");

        LinkedList<Node<E>> neighbors = adjacencyMap.get(root);
        // Check if list is null to prevent NullPointerException
        if(neighbors == null) {
            return; // skip iteration
        }

        // Otherwise add every unvisited node
        for(Node<E> node: neighbors){
            if(!node.isVisited()){
                DFSRecursive(node);
            }
        }
    }

    

    public static void simpleTestDFS(){
        Graph<Integer> graph = new Graph<>(true);
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
        graph.DFSRecursive(one);
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
      graph.DepthFirstSearch(seven); 
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

        graph.DFS(three);
        //Final output: [3, 5, 1, 2, 8, 25, 12, 6, 4, 9, 10]
        
    }

    public static void main(String[] args){


        boolean DFS = false;
        if(DFS) simpleTestDFS();
    }
}
