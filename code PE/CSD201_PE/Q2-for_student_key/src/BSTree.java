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
    void deleteByCopying(Node p) { // copy left
        if (p == null || p.left == null) {
            return;
        }
        if (p.left.right == null) {
            p.info = p.left.info;
            p.left = p.left.left;
        } else {
            Node father = p.left;
            Node cur = p.left.right;
            while (cur.right != null) {
                father = cur;
                cur = cur.right;
            }
            p.info = cur.info;
            father.right = cur.left;
        }
    }

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
//===========================================================================

    public void insert(Car x) {
        Node p = new Node(x);
        if (isEmpty()) {
            root = p;
            return;
        }
        Node f = null;
        Node q = root;
        while (q != null) {
            if (q.info.size == x.size) {
                return;
            } else if (q.info.size > x.size) {
                f = q;
                q = q.left;
            } else {
                f = q;
                q = q.right;
            }
        }
        if (f.info.size > x.size) {
            f.left = p;
        } else {
            f.right = p;
        }
    }

    void insert(String xOwner, int xColor, int xsize) {//You should insert here statements to complete this function
        if (xOwner.charAt(0) == 'A') {
            return;
        }
        Car c = new Car(xOwner, xColor, xsize);
        insert(c);
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
    static int count = 1;

    void preOrder2(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        fvisit2(p, f);
        preOrder2(p.left, f);
        preOrder2(p.right, f);
    }
    void preOrder(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        fvisit(p, f);
        preOrder(p.left, f);
        preOrder(p.right, f);
    }
    void fvisit2(Node p, RandomAccessFile f) throws Exception {
        if (p != null && count < 6) {
            f.writeBytes(p.info + " ");
            count++;
        }
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
        preOrder2(root, f);
        //------------------------------------------------------------------------------------
        //--------------------------------------------------------
        f.writeBytes("\r\n");
        f.close();
    }

//=============================================================
//=============================================================
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

    int findMaxColor() {
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
