package LinkedList;

public class Node {
    Car value;
    Node next, pre;
    
    public Node(){
    }

    public Node(Car value, Node next, Node pre) {
        this.value = value;
        this.next = next;
        this.pre = pre;
    }

    public Node(Car value) {
        this.value = value;
        next = null;
    }
}
