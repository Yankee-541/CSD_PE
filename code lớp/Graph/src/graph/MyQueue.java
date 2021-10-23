package graph;

public class MyQueue {
    Node head, tail;
    
    public MyQueue(){
        head = tail = null;
    }
    
    boolean isEmpty(){
        return  head == null;
    }
    
    void EnQueue (int value){
        Node node = new Node(value);
        if (isEmpty()) {             //ban chat la addLast
            head = tail = node;
        }else {                     
            tail.next = node;
            tail = node;
        }
    }
    
    int deQueue(){             // ban chat la delete First
        if (isEmpty()) {
            return -1;
        }
        int value = head.value;
        head = head.next;
        return value;
    }

}

