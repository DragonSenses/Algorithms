import java.util.HashMap;
import java.util.LinkedList;

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
}
