package graph;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MyGraph {

    int[][] a;
    int size;

    char Convert(int x) {
        return (char) (x + 65);
    }

    public MyGraph() throws IOException {
        size = 12;
        a = new int[size][size];
        RandomAccessFile raf;
        try {
            raf = new RandomAccessFile("C:\\Users\\admin\\Documents\\ky_2\\ky3\\CSD\\Graph\\src\\graph\\Graph2.txt", "r");
                      
            String s = "";
            int i = 0;
            while ((s = raf.readLine()) != null) {
                if(size==0){
                    size = s.split("\\s+").length;
                    a = new  int[size] [size];
                }
                String[] s1 = s.split("\\s+");
                for (int j = 0; j < s1.length; j++) {
                    a[i][j] = Integer.parseInt(s1[j]);
                }
                i++;
            }
        } catch (FileNotFoundException e) {
            Logger.getLogger(MyGraph.class.getName()).log(Level.SEVERE, null, e);
        } catch (IOException ex) {
            Logger.getLogger(MyGraph.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void display() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.print("\b");
            System.out.println("");
        }
    }

    public void BreadthFirst(int x) {
        boolean[] b = new boolean[size];
        Arrays.fill(b, true);
        MyQueue queue = new MyQueue();
        queue.EnQueue(x);
        b[x] = false;
        while (!queue.isEmpty()) {
            int p = queue.deQueue();
            for (int i = 0; i < size; i++) {
                if (a[i][p] != 0 && b[i]) {
                    b[i] = false;
                    queue.EnQueue(i);
                }
            }
            System.out.print(Convert(p) + "->");
        }
        System.out.println("\b\b");
    }

    public void depthFirst(int x) {
        boolean[] b = new boolean[size];
        Arrays.fill(b, true);
        depthFirst(b, x);
        for (int i = 0; i < size; i++) {
            if (b[i]) {
                depthFirst(b, i);
            }
        }
    }

    public void depthFirst(boolean[] b, int x) {
        System.out.print(Convert(x) + "-->");
        b[x] = false;
        for (int i = 0; i < size; i++) {
            if (a[i][x] != 0 && b[i]) {
                depthFirst(b, i);
            }
        }
    }

}
