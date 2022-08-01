public class Node <E> {
    E data;
    boolean visited; // Tracks when a node has been visited

    public Node(E data) {
        this.data = data;
        visited = false;
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
