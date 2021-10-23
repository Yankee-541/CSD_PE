/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
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
        Queue q = new Queue();
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

//    void loadData(int k) //do not edit this function
//    {
//        String[] a = Lib.readLineToStrArray("data.txt", k);
//        int[] b = Lib.readLineToIntArray("data.txt", k + 1);
//        int n = a.length;
//        for (int i = 0; i < n; i++) {
//            insert(a[i], b[i]);
//        }
//    }
    void loadData(int k) //do not edit this function
    {
        String[] a = Lib.readLineToStrArray("data.txt", k);
        int[] b = Lib.readLineToIntArray("data.txt", k + 1);
        int[] c = Lib.readLineToIntArray("data.txt", k+2);
        int n = a.length;
        for (int i = 0; i < n; i++) {
            insert(a[i], b[i], c[i]);
        }
    }
//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
    void insert(String xMaker, int xType, int xRadius) {//You should insert here statements to complete this function
        Node q = new Node(new Ball(xMaker, xType, xRadius));
        if (xMaker.charAt(0) == 'B') {
            return;
        }

        if (isEmpty()) {
            root = q;
            return;
        } else {
            Node f, p;
            f = null;
            p = root;
            while (p != null) {
                if (p.info.type == q.info.type) {
                    return;
                }

                f = p;
                if (q.info.type < p.info.type) {
                    p = p.left;
                } else {
                    p = p.right;
                }
            }

            if (q.info.type < f.info.type) {
                f.left = q;
            } else {
                f.right = q;
            }
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
    void postOrder2(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        postOrder2(p.right, f);
        postOrder2(p.right, f);
        if (p.info.radius < 5) {
            fvisit(p, f);
        }
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
        preOrder(root, f);
        f.writeBytes("\r\n");
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/

        postOrder2(root, f);
        //------------------------------------------------------------------------------------
        f.writeBytes("\r\n");
        f.close();
    }

// f.writeBytes(" k = " + k + "\r\n");
//=============================================================
    void deleteByCopy(Node p) {
        if (isEmpty()) {
            return;
        }
        if (p == null) {
            System.out.println("Key does not exist, deletion falied");
            return;
        }
        // Find node f where f is father of p

        Node f = null;
        Node q = root;
        while (q != p) {
            if (q.info.type > p.info.type) {
                f = q;
                q = q.left;
            } else {
                f = q;
                q = q.right;
            }
        }
        // 4. Both of right and left child
        if (p.left != null && p.right != null) {
            f = null;
            Node rp = p.left;
            while (rp.right != null) {
                f = rp;
                rp = rp.right;
            }

            p.info = rp.info;
            if (f == null) { // rp has no right child
                p.left = rp.left;
            } else {
                f.right = rp.left;
            }
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
        breadth(root, f);
        f.writeBytes("\r\n");
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        Node node = root;
        while (node != null) {
            if (node != root) {
                deleteByCopy(node);
                break;
            } else {
                node = node.left;
            }
        }
        //------------------------------------------------------------------------------------
        breadth(root, f);
        f.writeBytes("\r\n");
        f.close();
    }

//=============================================================
    // get node father
    Node father(int xType) {
        Node f, p;
        f = null;
        p = root;
        while (p != null) {
            if (p.info.type == xType) {
                break;
            }

            f = p;
            if (xType < p.info.type) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        return (f);
    }
//    Node getParent(Node p) {
//        if (p == root) {
//            return null;
//        }
//        Node father = null, cur = root;
//
//        while (cur != null && cur.value.price != p.value.price) {
//            father = cur;
//            if (cur.value.price < p.value.price) {
//                cur = cur.right;
//            } else {
//                cur = cur.left;
//            }
//        }
//
//        if (cur == null) { // khong tim thay p trong tree
//            return null;
//        }
//
//        return father;
//    } // do ko tin tuong code thay nen toi cop ca phan nay vao
    
    // rotate left root
    Node rotateToLeft(Node p){
        if (p == null || p.right == null) {
            return (p);
        }
        
//        Node parent = getParent(p);
//        Node child = p.right;
//        p.right = child.left;
//        child.left = p;
//        if (parent == null) {
//            root = child;
//        } else {
//            parent.right = child;
//        }
//        return child; // cung ko tin tuong code thay nen lay doan nay :))
        Node q = p.right;
        p.right = q.left;
        q.left = p;
        return q;
    }
    
    // rotate any node
    public  void rotateNodifier(Node node){
        Node nodeRotate = rotateToLeft(node);
        Node nodeFather = father(node.info.type);
        if (nodeFather == null) {
            root = nodeRotate;
        } else {
            if (nodeFather.left == node) {
                nodeFather.left = node;
            }else {
                nodeFather.right = node;
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
        breadth(root, f);
        f.writeBytes("\r\n");
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        Node node = root;
        while (root != null) {            
            if (node != root && node.left != null && node.right != null) {
                rotateNodifier(node);
            } else{
                node = node.left;
            }
        }
        //------------------------------------------------------------------------------------
        breadth(root, f);
        f.writeBytes("\r\n");
        f.close();
    }

}
