/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;
import java.io.*;
import java.util.*;

class BSTree {

    Node root;

    BSTree() {
        root = null;
    }

    boolean isEmpty() {
        return (root == null);
    }

    void clear() {
        root = null;
    }

    void fvisit(Node p, RandomAccessFile f) throws Exception {
        if (p != null) {
            f.writeBytes(p.info + " ");
        }
    }

    void preOrder(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        fvisit(p, f);
        preOrder(p.left, f);
        preOrder(p.right, f);
    }

    void inOrder(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        inOrder(p.left, f);
        fvisit(p, f);
        inOrder(p.right, f);
    }

    void postOrder(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        postOrder(p.left, f);
        postOrder(p.right, f);
        fvisit(p, f);
    }

    void breadth(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        BQueue q = new BQueue();
        q.enqueue(p);
        Node r;
        while (!q.isEmpty()) {
            r = q.dequeue();
            fvisit(r, f);
            if (r.left != null) {
                q.enqueue(r.left);
            }
            if (r.right != null) {
                q.enqueue(r.right);
            }
        }
    }

    void loadData(int k) //do not edit this function
    {
        String[] a = Lib.readLineToStrArray("data.txt", k);
        int[] b = Lib.readLineToIntArray("data.txt", k + 1);
        int[] c = Lib.readLineToIntArray("data.txt", k + 2);
        int n = a.length;
        for (int i = 0; i < n; i++) {
            insert(a[i], b[i], c[i]);
        }
    }

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
    void add(Car value) {
        Node node = new Node(value);
        if (isEmpty()) {
            root = node;
            return;
        }

        Node cur = root;
        Node father = null;

        while (cur != null) {
            if (cur.info.size == value.size) {
                return;
            }

            father = cur;
            if (cur.info.size < value.size) {
                cur = cur.right;
            } else {
                cur = cur.left;
            }
        }
        if (father.info.size < value.size) {
            father.right = node;
        } else {
            father.left = node;
        }

    }

    void insert(String xOwner, int xColor, int xsize) {//You should insert here statements to complete this function
        if (xOwner.startsWith("A")) {
            return;
        }
        Car car = new Car(xOwner, xColor, xsize);
        Node x = new Node(car);
        if (isEmpty()) {
            root = x;
        } else {
            add(car);
        }

    }

    void f1() throws Exception {/* You do not need to edit this function. Your task is to complete insert  function
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
        preOrder(root, f);
        f.writeBytes("\r\n");
        inOrder(root, f);
        f.writeBytes("\r\n");
        f.close();
    }

//=============================================================
    void preOrder2(Node p, RandomAccessFile f, int count) throws Exception {
        count++;
        if (count == 5) {
            return;
        }
        
        if (p == null) {
            return;
        }
        
        fvisit(p, f);
        preOrder2(p.left, f, count);
        preOrder2(p.right, f, count);
    }

    void f2() throws Exception {
        clear();
        loadData(5);
        String fname = "f2.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        preOrder(root, f);
        f.writeBytes("\r\n");
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        preOrder2(root, f, 0);
        //------------------------------------------------------------------------------------
        //--------------------------------------------------------
        f.writeBytes("\r\n");
        f.close();
    }

// f.writeBytes(" k = " + k + "\r\n");
//=============================================================
//=============================================================
    Node getParent(Node p) {
        if (p == root) {
            return null;
        }
        Node father = null, cur = root;

        while (cur != null && cur.info.size != p.info.size) {
            father = cur;
            if (cur.info.size < p.info.size) {
                cur = cur.right;
            } else {
                cur = cur.left;
            }
        }

        if (cur == null) { // khong tim thay p trong tree
            return null;
        }

        return father;
    }

    Node rotateLeft(Node p) {
        if (p == null || p.right == null) {
            return null;
        }
        Node parent = getParent(p);
        Node child = p.right;
        p.right = child.left;
        child.left = p;
        if (parent == null) {
            root = child;
        } else {
            parent.right = child;
        }
        return child;
    }
//------------------------------------------------------------------------------------

    void f3() throws Exception {
        clear();
        loadData(9);
        String fname = "f3.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        breadth(root, f);
        f.writeBytes("\r\n");
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        BQueue q = new BQueue();
        Node p = root;
        q.enqueue(p);
        Node r;
        while (!q.isEmpty()) {
            r = q.dequeue();
            if (r.right != null && r.left == null) {
                rotateLeft(r);
                break;
            }
            if (r.left != null) {
                q.enqueue(r.left);
            }
            if (r.right != null) {
                q.enqueue(r.right);
            }
        }

        //------------------------------------------------------------------------------------
        //--------------------------------------------------------
        breadth(root, f);
        f.writeBytes("\r\n");
        f.close();
    }
//------------------------------------------------------------------------------------
    int findMaxColor(){
        BQueue q = new BQueue();
        Node p = root;
        q.enqueue(p);
        Node r;
        int maxColor = root.info.color;
        while (!q.isEmpty()) {
            r = q.dequeue();
            if (r.info.color > maxColor) {
                maxColor = r.info.color;
            }
            if (r.left != null) {
                q.enqueue(r.left);
            }
            if (r.right != null) {
                q.enqueue(r.right);
            }
        }
        return maxColor;
    }
    void f4() throws Exception {
        clear();
        loadData(13);
        String fname = "f4.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        breadth(root, f);
        f.writeBytes("\r\n");
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        BQueue q = new BQueue();
        Node p = root;
        q.enqueue(p);
        Node r;
        
//        System.out.println(findMaxColor());
        while (!q.isEmpty()) {
            r = q.dequeue();
            if (r.info.color == findMaxColor()) {
                r.info.owner = "Y";
                break;
            }
            
            if (r.left != null) {
                q.enqueue(r.left);
            }
            if (r.right != null) {
                q.enqueue(r.right);
            }
        }
        
        //------------------------------------------------------------------------------------
        //--------------------------------------------------------
        breadth(root, f);
        f.writeBytes("\r\n");
        f.close();
    }
}
