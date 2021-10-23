/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
import java.io.*;
import java.util.*;

class BSTree
  {Node root;
   BSTree() {root=null;}
   boolean isEmpty()
      {return(root==null);
      }
   void clear()
      {root=null;
      }
   void fvisit(Node p, RandomAccessFile f) throws Exception
     {if(p != null) f.writeBytes(p.info + " ");
     }
   void preOrder(Node p, RandomAccessFile f) throws Exception
     {if(p==null) return;
      fvisit(p,f);
      preOrder(p.left,f);
      preOrder(p.right,f);
     }
   void inOrder(Node p, RandomAccessFile f) throws Exception
     {if(p==null) return;
      inOrder(p.left,f);
      fvisit(p,f);
      inOrder(p.right,f);
     }
   void postOrder(Node p, RandomAccessFile f) throws Exception
     {if(p==null) return;
      postOrder(p.left,f);
      postOrder(p.right,f);
      fvisit(p,f);
     }
  void breadth(Node p, RandomAccessFile f) throws Exception
    {if(p==null) return;
     Queue q = new Queue();
     q.enqueue(p);Node r;
     while(!q.isEmpty())
       {r = q.dequeue();
        fvisit(r,f);
        if(r.left!=null) q.enqueue(r.left);
        if(r.right!=null) q.enqueue(r.right);
       }
    }
   void loadData(int k)  //do not edit this function
     {String [] a = Lib.readLineToStrArray("data.txt", k);
      int [] b = Lib.readLineToIntArray("data.txt", k+1);
      int n = a.length;
      for(int i=0;i<n;i++) insert(a[i],b[i]);
     }

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
   void preOrder2(Node p, RandomAccessFile f) throws Exception
     {if(p==null) return;
      int price = p.info.price;
      if (price >= 3 && price <= 5) {
          fvisit(p,f);
      }
      preOrder2(p.left,f);
      preOrder2(p.right,f);
     }
      
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
    
    Node getParent(Node n) {
        if (n == root) {
            return null;
        }
        Node father = null;
        Node cur = root;
        while (cur != null && cur.info.price != n.info.price) {
            father = cur;
            if (cur.info.price < n.info.price) {
                cur = cur.right;
            } else {
                cur = cur.left;
            }
        }
        return father;
    }
    
    void rightRotate(Node p) {
        Node grandpa = getParent(p);
        Node child;
        if (p == null || p.left == null) {
            return;
        } else {
            child = p.left;
            p.left = child.right;
            child.right = p;
        }
        if (grandpa != null) {
            if (grandpa.info.price < p.info.price) {
                grandpa.right = child;
            } else {
                grandpa.left = child;
            }
        } else {
            root = child;
        }
    }
//===========================================================================
  void insert(String xOwner, int xPrice)
     {//You should insert here statements to complete this function
    if (xOwner.charAt(0) == 'B' || xPrice > 100 || xPrice < 0) {
        return;
    }
    Node node = new Node(new Car(xOwner, xPrice));
    if (isEmpty()) {
        root = node;
    } else {
        Node father = null, cur = root;
        while (cur != null) {
            int price = cur.info.price;
            if (price == xPrice) {
                return;
            }
            father = cur;
            if (price > xPrice) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        if (father.info.price > xPrice) {
            father.left = node;
        } else {
            father.right = node;
        }
    }
     }

  void f1() throws Exception
    {/* You do not need to edit this function. Your task is to complete insert  function
        above only.
     */
     clear();
     loadData(1);
     String fname = "f1.txt";
     File g123 = new File(fname);
     if(g123.exists()) g123.delete();
     RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
     preOrder(root,f);
     f.writeBytes("\r\n");
     inOrder(root,f);
     f.writeBytes("\r\n");
     f.close();
    }  
  
//=============================================================
  void f2() throws Exception
    {clear();
     loadData(4);
     String fname = "f2.txt";
     File g123 = new File(fname);
     if(g123.exists()) g123.delete();
     RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
     preOrder(root,f);
     f.writeBytes("\r\n");
    //------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/

    preOrder2(root, f);

    //------------------------------------------------------------------------------------
     f.writeBytes("\r\n");
     f.close();
    }  

// f.writeBytes(" k = " + k + "\r\n");
//=============================================================
  void f3() throws Exception
    {clear();
     loadData(7);
     String fname = "f3.txt";
     File g123 = new File(fname);
     if(g123.exists()) g123.delete();
     RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
     breadth(root,f);
     f.writeBytes("\r\n");
    //------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
     Node p = root;
    Queue q = new Queue();
    q.enqueue(p);
    Node r;
    while (!q.isEmpty()) {
        r = q.dequeue();
        if (r.left != null && r.right != null && r.info.price < 7) {
            deleteByCopying(r);
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
     breadth(root,f);
     f.writeBytes("\r\n");
     f.close();
    }  

//=============================================================
  void f4() throws Exception
    {clear();
     loadData(10);
     String fname = "f4.txt";
     File g123 = new File(fname);
     if(g123.exists()) g123.delete();
     RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
     breadth(root,f);
     f.writeBytes("\r\n");
    //------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
    Node p = root;
    Queue q = new Queue();
    q.enqueue(p);
    Node r;
    while (!q.isEmpty()) {
        r = q.dequeue();
        if (r.left != null && r.right != null && r.info.price < 7) {
            rightRotate(r);
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
     breadth(root,f);
     f.writeBytes("\r\n");
     f.close();
    }  

 }
