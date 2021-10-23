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
        int[] c = Lib.readLineToIntArray("data.txt", k + 2);
        int n = a.length;
        for (int i = 0; i < n; i++) {
            addLast(a[i], b[i], c[i]);
        }
    }

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
    void addLast(String xOwner, int xColor, int xsize) {//You should write here appropriate statements to complete this function.
        if (xOwner.charAt(0) == 'A' || xColor < 0 || xsize < 0) {
            return;
        }
        Car ball = new Car(xOwner, xColor, xsize);
        Node node = new Node(ball);
        if (isEmpty()) {
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;
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
//    int size() {
//        Node node = head;
//        int count = 0;
//        while (node != null) {
//            count++;
//            node = node.next;
//        }
//        return count;
//    }

    void addFirst(Car value) {
        Node node = new Node(value);
        if (isEmpty()) {
            head = tail = node;
        } else {
            node.next = head;
            head = node;
        }
    }

    void addIndex(Car value, int index) {
        if (index <= 0) {
            addFirst(value);
        }
        if (index >= size()) {
            addLast(value.owner, value.color, value.size);
        }
        int count = 0;
        Node cur = head;
        while (cur != null && count != index - 1) { // lap cho den index-1 ~> cur = cur tai vi tri index
            count++;
            cur = cur.next;
        }

        Node node = new Node(value);
        node.next = cur.next;
        cur.next = node;
    }

    void delete(int index) {
        if (index == 0) {
            head = head.next;
        }
        if (index == size() - 1) {
            Node beforeTail = head;
            while (beforeTail.next != tail) {
                beforeTail = beforeTail.next;
            }
            beforeTail.next = null;
            tail = beforeTail;

        }
        if (index > 0 && index < size() - 1) {
            int count = 0;
            Node cur = head;
            while (count != index - 1) {
                cur = cur.next;
                count++;
            }
            cur.next = cur.next.next;
        }
    }

    Node get(int index) {
        if (index == 0) {
            return head;
        }
        if (index == size() - 1) {
            return tail;
        }
        if (index > 0 && index < size() - 1) {
            int i = 0;
            Node cur = head;
            while (i != index) {
                cur = cur.next;
                i++;
            }
            return cur;
        } else {
            return null;
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
        ftraverse(f);
        Car x = new Car("X", 10, 5);

        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        addIndex(x, 3);

        //------------------------------------------------------------------------------------
        //--------------------------------------------------------
        ftraverse(f);
        f.close();
    }
int size() {
        Node node = head;
        int count = 0;
        while (node != null) {
            count++;
            node = node.next;
        }
        return count;
    }

    void deleteFirst() {
        if (isEmpty()) {
            return;
        }
        head = head.next;
//        size--;

    }

    void deleteLast() {
        if (isEmpty()) {
            return;
        }
        Node cur = head;

        while (cur.next.next != null) {
            cur = cur.next;
        }

        cur.next = null;
        tail = cur;
//        size--;
    }

    void deleteIndex(int index) {
        if (index < 0 || index >= size()) {
            return;
        }

        if (index == 0) {
            deleteFirst();
            return;
        }
        if (index == size() - 1) {
            deleteLast();
            return;
        }
        int count = 0;
        Node cur = head;
        while (count != index - 1) {
            cur = cur.next;
            count++;
        }

        cur.next = cur.next.next;
//        size()--;
    }
//==================================================================
    void f3() throws Exception {
        clear();
        loadData(9);
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

        //------------------------------------------------------------------------------------
int value = head.info.color + head.info.size;
        Node cur = head.next;
        int post = 0;
        while (cur != null) {
            int max = cur.info.color + cur.info.size;
//            System.out.println(max);
            if (value < max) {
                value = max;
            }
            cur = cur.next;
        }
        Node cur1 = head;
        for (int i = 0; i < size(); i++) {
            if (cur1.info.color + cur1.info.size == value) {
                post = i;
                break;
            }
            cur1 = cur1.next;
        }
        deleteIndex(post);
        //--------------------------------------------------------
        ftraverse(f);
        f.close();
    }

//==================================================================
//  void addFirst(Car x)
//   {head=new Node(x,head);
//    if(tail==null) tail=head;
//   }
//       void preOrderf2(Node p, RandomAccessFile f) throws Exception
//     {
//      if(p==null) return;
//      if(p.info.price < 7){
//        fvisit(p,f);
//      }
//      preOrderf2(p.left,f);
//      preOrderf2(p.right,f);
//     }
    void f4() throws Exception {
        clear();
        loadData(13);
        String fname = "f4.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);

        //------------------------------------------------------------------------------------
        

//8--------------------------------------------------------------------------------
        //--------------------------------------------------------
        ftraverse(f);
        f.close();
    }

}
