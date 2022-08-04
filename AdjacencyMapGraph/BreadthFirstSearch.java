package AdjacencyMapGraph;

public class BreadthFirstSearch {
    public static void main(String[] args){
        /** Create a Larger Sample Graph **/
        Graph<String, String> graph = new Graph<>(true);
        /**
         * A - B - C - D
         * | \ |   | / | 
         * E - F   G   H
         * |  /  / | \ |
         * I - J - K   L
         * | \    /|   |
         * M - N   O   P
         */

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

        System.out.println(graph.toString());
    }
}
