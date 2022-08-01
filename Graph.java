import java.util.HashMap;
import java.util.LinkedList;

/**
 * Graph Implementation using an adjacency Map
 */
public class Graph <E>{
    // Graph uses node maps to a linkedlist of all its neighbors
    private HashMap<Node<Integer>, LinkedList<Node<Integer>>> adjacencyMap;
    private boolean directed; // Whether Graph is directed or undirected    

    public Graph(boolean directed){
        this.directed = directed;
        adjacencyMap = new HashMap<>();
    }

    /**
     * Checks for possible duplicate edges, before adding an edge
     * containg the Nodes u -> v, 
     * @param u The origin node of the edge
     * @param v The destination node of the edge
     */
    private void validateEdge(Node<E> u, Node<E> v) {

    }

    /**
     * Adds the edge with nodes u & v in the Graph.
     * @param u The origin node of the edge
     * @param v The destination node of the edge
     */
    public void addEdge(Node<E> u, Node<E> v){

    }

    /**
     * @returns True if the graph contains the edge with nodes u and v,
     *          false otherwise
     */
    public boolean containsEdge(Node<E> u, Node<E> v){
        return adjacencyMap.containsKey(u) && 
            adjacencyMap.get(u).contains(v);
    }
}
