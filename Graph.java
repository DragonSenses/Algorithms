import java.util.HashMap;
import java.util.LinkedList;

public class Graph <E>{
    // Graph uses node maps to a linkedlist of all its neighbors
    private HashMap<Node<Integer>, LinkedList<Node<Integer>>> adjacencyMap;
    private boolean directed; // Whether Graph is directed or undirected    

    public Graph(boolean directed){
        this.directed = directed;
        adjacencyMap = new HashMap<>();
    }

    private void validateEdge(Node<E> u, Node<E> v) {

    }

    public void addEdge(Node<E> u, Node<E> v){

    }
}
