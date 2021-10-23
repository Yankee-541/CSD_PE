package graph;

public class Node {
    int value;
    Node next;
    
    public Node(){
    }

    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
//        this.pre = pre;
    }

    public Node(int value) {
        this.value = value;
        next = null;
    }
}
