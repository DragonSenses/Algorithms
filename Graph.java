public class Graph {
    // Graph uses node maps to a linkedlist of all its neighbors
    private HashMap<Node, LinkedList<Node>> adjacencyMap;
    private boolean directed; // Whether Graph is directed or undirected    

    public Graph(boolean directed){
        this.directed = directed;
        adjacencyMap = new HashMap<>();
    }
}
