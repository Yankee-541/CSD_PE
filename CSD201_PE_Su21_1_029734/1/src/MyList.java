/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
import java.util.*;
import java.io.*;

public class MyList {

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

    void loadData(int k) { //do not edit this function
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
/* 
   Khong su dung tieng Viet co dau de viet ghi chu.
   Neu dung khi chay truc tiep se bao loi va nhan 0 diem
     */
    void addLast(String xPlace, int xDepth, int xType) {
        //You should write here appropriate statements to complete this function.
        if (xPlace.charAt(0) == 'A' || xDepth < 0 || xType < 0) {
            return;
        }
        Castor cas = new Castor(xPlace, xDepth, xType);
        Node node = new Node(cas);
        if (isEmpty()) {
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;
        }

    }

    //You do not need to edit this function. Your task is to complete the addLast function above only.
    void f1() throws Exception {
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

    void addFirst(Castor value) {
        Node node = new Node(value);
        if (isEmpty()) {
            head = tail = node;
        } else {
            node.next = head;
            head = node;
        }
    }

    void addIndex(Castor value, int index) {
        if (index <= 0) {
            addFirst(value);
        }
        if (index >= size()) {
            addLast(value.place, value.type, value.type);
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
//==================================================================

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
        Castor x, y;
        x = new Castor("X", 1, 2);
        y = new Castor("Y", 3, 4);
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        addIndex(x, 2);
        addFirst(y);
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

//==================================================================
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

    int size() {
        Node node = head;
        int count = 0;
        while (node != null) {
            count++;
            node = node.next;
        }
        return count;
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
        int value = head.info.type;
        Node cur = head.next;
        int post = 0;
        while (cur != null) {
            int max = cur.info.type;
//            System.out.println(max);
            if (value < max) {
                value = max;
            }
            cur = cur.next;
        }
        Node cur1 = head;
        for (int i = 0; i < size(); i++) {
            if (cur1.info.type == value) {
                post = i;
                break;
            }
            cur1 = cur1.next;
        }
        deleteIndex(post);
        Castor yy = new Castor("YY", 5, 8);
        addIndex(yy, 3);

        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

//==================================================================
    int size2() {
        Node node = head;
        int count = 0;
        while (node != null) {
            count++;
            node = node.next;
        }
        return count;
    }

    void deleteLast2() {
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

    void addFirst2(Castor x) {
        Node node = new Node(x);
        if (isEmpty()) {
            head = tail = node;
        } else {
            node.next = head;
            head = node;
        }
//        size++;
    }

    void addLast2(Castor x) {
        Node node = new Node(x);
        if (isEmpty()) {
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
//        size++;
    }

    void addIndex2(Castor x, int index) {
        if (index <= 0) {
            addFirst2(x);
            return;
        }
        if (index >= size()) {
            addLast2(x);
            return;
        }
        int count = 0;
        Node cur = head;
        while (cur != null && count != index - 1) {
            count++;
            cur = cur.next;
        }

        Node node = new Node(x);
        node.next = cur.next;
        cur.next = node;
    }

    Node findNode(int index) {
        Node cur = head;
        for (int i = 0; i < size(); i++) {
            if (i == index) {
                return cur;
            }
            cur = cur.next;
        }
        return null;
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
        ftraverse(f);
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        int index = 3;

        int i = 0;
        while ( i <5 ) {
            Node swap = findNode(index);

            addIndex2(swap.info, i);
            i++;
        }
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

}
