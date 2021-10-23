package MyTree;


public class MyQueue {
    NodeQueue head, tail;
    
    public MyQueue(){
        head = tail = null;
    }
    
    boolean isEmty(){
        return  head == null;
    }
    
    void EnQueue (Node value){
        NodeQueue node = new NodeQueue(value);
        if (isEmty()) {             //ban chat la addLast
            head = tail = node;
        }else {                     
            tail.next = node;
            tail = node;
        }
    }
    
    Node deQueue(){             // ban chat la delete First
        if (isEmty()) {
            return null;
        }
        Node node = head.value;
        head = head.next;
        return node;
    }

}

class NodeQueue {

    Node value;
    NodeQueue next;

    public NodeQueue() {
    }
    
    public NodeQueue(Node value){
        this.value = value;
        next = null;
    }

}
