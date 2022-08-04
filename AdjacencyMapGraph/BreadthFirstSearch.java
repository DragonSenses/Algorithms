package AdjacencyMapGraph;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class BreadthFirstSearch {

    /**
     * A Breadth-First Search algorithm searches the graph by sending out multiple
     * explorers collectively, taking one step at a time in all directions. This
     * search proceeds in rounds and subdivides the nodes into levels. Level 0 is 
     * the starting node u. Maintains a set of visited vertices and stores the 
     * search within a map. 
     * @param g - The graph to search
     * @param u - The vertex to start search with
     * @param visited - A set that contains nodes that have already been visited
     * @param map - the map that stores explored paths
     */
    public static <V,E> void BFS(Graph<V,E> g, Vertex<V> u,
        Set<Vertex<V>> visited, Map<Vertex<V>,Edge<E>> map) {
        // 0. Make a List reference to the next level and the endpoint vertex
        LinkedPositionalList<Vertex<V>> nextLevel; // Stores next list of vertices of the next level
        Vertex<V> v2;
        // 1. Make a List of Vertexes that represent each level of depth to explore
        LinkedPositionalList<Vertex<V>> level = new LinkedPositionalList<>();
        // 2. Add the starting node u to the set of visited nodes
        visited.add(u); 
        // 3. Add the first level which includes the first node
        level.addLast(u);
        // 4. While the queue of the current level is not empty
        while(!level.isEmpty()) {
            nextLevel = new LinkedPositionalList<>(); 
            // For each vertex in the current level
            for(Vertex<V> v : level.eIterable()) {
                // For each edge connected to that vertex
                for(Edge<E> e : g.outgoingEdges(v)){
                    // Get the other endpoint of vertex v, to get v2
                    v2 = g.opposite(v,e);
                    // If the set of visited nodes does not contain v2
                    if(!visited.contains(v2)){
                        visited.add(v2); // Add v2 to the set
                        map.put(v2,e);   // Put v2 in the explored map
                        nextLevel.addLast(v2); // Add v2 to the nextLevel
                    }
                }
            
            }
            level = nextLevel; // After the end of the current level, move up to next level
        }// end of while loop
    }

    public static Graph<String,String> sample(){
        Graph<String, String> graph = new Graph<>(true);
        /** First Row **/
        graph.insertEdge(graph.insertVertex("A"),
            graph.insertVertex("B"), "AB");

        graph.insertEdge(graph.insertVertex("B"),
            graph.insertVertex("C"), "BC");

        graph.insertEdge(graph.insertVertex("C"),
            graph.insertVertex("D"), "CD");
        
        /** Second Row */

        graph.insertEdge(graph.insertVertex("A"),
            graph.insertVertex("E"), "AE");

        graph.insertEdge(graph.insertVertex("A"),
            graph.insertVertex("F"), "AF");

        graph.insertEdge(graph.insertVertex("E"),
            graph.insertVertex("A"), "EA");

        graph.insertEdge(graph.insertVertex("F"),
            graph.insertVertex("A"), "FA");

        graph.insertEdge(graph.insertVertex("C"),
            graph.insertVertex("G"), "CG");
        
        graph.insertEdge(graph.insertVertex("D"),
            graph.insertVertex("G"), "DG");

        graph.insertEdge(graph.insertVertex("D"),
            graph.insertVertex("H"), "DH");

        /** Third Row **/

        graph.insertEdge(graph.insertVertex("E"),
            graph.insertVertex("F"), "EF");

        /** Fourth Row  **/

        graph.insertEdge(graph.insertVertex("E"),
            graph.insertVertex("I"), "EI");

        graph.insertEdge(graph.insertVertex("F"),
            graph.insertVertex("I"), "FI");

        graph.insertEdge(graph.insertVertex("G"),
            graph.insertVertex("J"), "GJ");

        graph.insert("G","K","GK");
        graph.insert("G","L","GL");
        graph.insert("H","L","HL");

        /** Fifth Row **/
        graph.insert("I","J","IJ");
        graph.insert("J","K","JK");

        /** Sixth Row **/
        graph.insert("I","M","IM");
        graph.insert("I","N","IN");
        graph.insert("K","N","KN");
        graph.insert("K","O","KO");
        graph.insert("L","P","LP");

        /** Seventh Row **/
        graph.insert("M","N","MN");

        return graph;
    }

    public static void main(String[] args){
        /** Create a Larger Sample Graph **/
        Graph<String, String> graph = sample();
        /**
         * A - B - C - D
         * | \ |   | / | 
         * E - F   G   H
         * |  /  / | \ |
         * I - J - K   L
         * | \    /|   |
         * M - N   O   P
         */
        //public static <V,E> void BreadthFirstSearch(Graph<V,E> g, Vertex<V> u,
        // Set<Vertex<V>> visited, Map<Vertex<V>,Edge<E>> map) {

        // LinkedHashSet() preserves the insertion order, which is the path the Search takes
        Set<Vertex<String>> visited = new LinkedHashSet<>(); 
        Map<Vertex<String>,Edge<String>> map = new HashMap<>();

        System.out.println(graph.first());
        System.out.println(graph.last());
        BFS(graph,graph.first(),visited,map);
        
        StringBuilder sb = new StringBuilder("[");
        for(Vertex<String> v : visited){
            sb.append(v.getElement().toString());
            sb.append(", ");
        }
        // Remove the last comma and space ", " from the StringBuilder
        System.out.println(sb.substring(sb.length()-2));
        sb.replace(sb.length()-2, sb.length(),""); 
        sb.append("]");
        System.out.println(sb.toString());
    }
}
