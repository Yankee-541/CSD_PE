/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
import java.util.*;
import java.io.*;

class MyList {

    Node head, tail;

    MyList() {
        head = tail = null;
    }

    boolean isEmpty() {
        return (head == null);
    }

    void clear() {
        head = tail = null;
    }

    void fvisit(Node p, RandomAccessFile f) throws Exception {
        if (p != null) {
            f.writeBytes(p.info + " ");
        }
    }

    void ftraverse(RandomAccessFile f) throws Exception {
        Node p = head;
        while (p != null) {
            fvisit(p, f); // You will use this statement to write information of the node p to the file
            p = p.next;
        }
        f.writeBytes("\r\n");
    }

    void loadData(int k) //do not edit this function
    {
        String[] a = Lib.readLineToStrArray("data.txt", k);
        int[] b = Lib.readLineToIntArray("data.txt", k + 1);
        int[] c = Lib.readLineToIntArray("data.txt", k+2);
        int n = a.length;
        for (int i = 0; i < n; i++) {
            addLast(a[i], b[i], c[i]);
        }
    }
//    void loadData(int k) //do not edit this function
//    {
//        String[] a = Lib.readLineToStrArray("data.txt", k);
//        int[] b = Lib.readLineToIntArray("data.txt", k + 1);
//        int n = a.length;
//        for (int i = 0; i < n; i++) {
//            addLast(a[i], b[i]);
//        }
//    }

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
    void addLast(String xMaker, int xType, int xRadius) {//You should write here appropriate statements to complete this function.
        Node q = new Node(new Ball(xMaker, xType, xRadius));
        if (xMaker.charAt(0) == 'A') {
            return;
        }
        if (isEmpty()) {
            head = tail = q;
            return;
        } else {
            tail.next = q;
            tail = q;
        }
    }

    void f1() throws Exception {/* You do not need to edit this function. Your task is to complete the addLast  function
        above only.
         */
        clear();
        loadData(1);
        String fname = "f1.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        f.close();
    }

//==================================================================
    public void insertPositionK(Ball x, int Position) {
        if (isEmpty()) {
            head = tail = new Node(x);
        }

        int count = 1;
        Node p = head;
        while (p != null && count < Position) {
            p = p.next;
            count++;
        }

        Node temp = p.next;
        p.next = new Node(x, temp);
    }

    void f2() throws Exception {
        clear();
        loadData(4);
        String fname = "f2.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
//        Ball x = new Ball("X", 1); // tôi fix cho giống với đề
        Ball x, y;
        x = new Ball("X", 1, 2);
        y = new Ball("Y", 3, 4);
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        insertPositionK(y, 2);
        insertPositionK(x, 3);

        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

//==================================================================
    public int size() {
        Node p = head;
        int c = 0;
        while (p != null) {
            c++;
            p = p.next;
        }
        return c;
    }
    
    public Node getNode(int k){
        int c = 0;
        Node p = head;
        while (p != null && c < k) {            
            p = p.next;
            c++;
        }
        return p;
    }
    
    void deleteNode(Node node){
        Node temp = null;
        Node cur = head;
        if (cur == null) {
            return;
        }
        
        while (cur != null) {            
            if (cur == node) {
                break;
            }
            temp = cur;
            cur = cur.next;
        }
        
        if (temp == null) {
            head = head.next;
            if (head == null) {
                tail = null;
            }
            return;
        }
        
        temp.next = cur.next;
        if (temp.next == null) {
            tail = temp;
        }
    }
    
    public  void removeSecond(){
        if (isEmpty()) {
            return;
        }
        
        Node cur = head;
        Node maxRadius = null;
        Node temp = head;
        int max = head.info.radius;
        
        while (temp != null) {            
            if (temp.info.radius > max) {
                maxRadius = temp;
                max = temp.info.radius;
            }
            temp = temp.next;
        }
        
        int count = 0;
        
        while (cur != null) {            
            if (cur.info.radius == max) {
                count++;
                if (count == 2) {
                    deleteNode(cur);
                    break;
                }
            }
            cur = cur.next;
        }
    }

    void f3() throws Exception {
        clear();
        loadData(7);
        String fname = "f3.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        removeSecond();
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

//==================================================================
   // sort 3 phan tu dau tien
    public void sort(){ // interchange
       Node pi, pj;
       pi = head;
       int count = 0;
       
        while (pi != null) {            
            count ++;
            pj = pi.next;
            int count1 = 0;
            while (pj != null) {                
                count1 ++;
                if (pi.info.radius < pj.info.radius) {
                    Ball t = pi.info;
                    pi.info = pj.info;
                    pj.info = t;
                }
                pj = pj.next;
                if (count1 == 4 - count) { // sort 4 first element
                    break;
                }
            }
            pi = pi.next;
            if (count == 3) {
                break;
            }
        }
   }
    void f4() throws Exception {
        clear();
        loadData(10);
        String fname = "f4.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        sort();
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

}
