package Graphs;
public class Node <E> {
    private E data;
    public boolean visited; // Tracks when a node has been visited

    public Node(E data) {
        this.data = data;
        visited = false;
    }

    public E getData(){
        return data;
    }

    public boolean isVisited(){
        return visited;
    }

    public void visit() {
        visited = true;
    }

    public void clear(){
        visited = false;
    }

    @Override
    public String toString(){
        return "Node " + data.toString();
    }
}
