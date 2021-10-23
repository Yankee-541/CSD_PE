package tree;

public class Node {
    Car value;
    Node left, right;

    public Node() {
    }

    public Node(Car value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public Node(String name, int price) {
        this. value = new Car(name, price);
        this.left = null;
        this.right = null;
    }

    
    
    
    
}
