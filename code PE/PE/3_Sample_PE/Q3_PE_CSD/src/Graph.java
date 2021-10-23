/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)============================================
import java.io.*;
import java.util.*;
//-------------------------------------------------------------------------------
class Graph {
    
    int[][] a;
    int n;
    char v[];
    int[] d;
    
    Graph() {
        v = "ABCDEFGHIJKLMNOP".toCharArray();
        d = new int[20];
        a = new int[20][20];
        n = 0;
    }
    
    void loadData(int k) { //do not edit this function
        RandomAccessFile f;
        int i, j, x;
        String s;
        StringTokenizer t;
        a = new int[20][20];
        try {
            f = new RandomAccessFile("data.txt", "r");
            for (i = 0; i < k; i++) {
                f.readLine();
            }
            s = f.readLine();
            s = s.trim();
            n = Integer.parseInt(s);
            for (i = 0; i < n; i++) {
                s = f.readLine();
                s = s.trim();
                t = new StringTokenizer(s);
                for (j = 0; j < n; j++) {
                    x = Integer.parseInt(t.nextToken().trim());
                    a[i][j] = x;
                }
            }
            f.close();
        } catch (Exception e) {
        }
    }
    
    void dispAdj() {
        int i, j;
        for (i = 0; i < n; i++) {
            System.out.println();
            for (j = 0; j < n; j++) {
                System.out.printf("%4d", a[i][j]);
            }
        }
    }
    
    void fvisit(int i, RandomAccessFile f) throws Exception {
        f.writeBytes(" " + v[i]);
    }
    
    void fdispAdj(RandomAccessFile f) throws Exception {
        int i, j;
        f.writeBytes("n= " + n + "\r\n");
        for (i = 0; i < n; i++) {
            f.writeBytes("\r\n");
            for (j = 0; j < n; j++) {
                f.writeBytes(" " + a[i][j]);
            }
        }
        f.writeBytes("\r\n");
    }
    
    void breadth(boolean[] en, int i, RandomAccessFile f) throws Exception {
        Queue q = new Queue();
        int r, j;
        q.enqueue(i);
        en[i] = true;
        while (!q.isEmpty()) {
            r = q.dequeue();
            fvisit(r, f);
            for (j = 0; j < n; j++) {
                if (!en[j] && a[r][j] > 0) {
                    q.enqueue(j);
                    en[j] = true;
                }
            }
        }
    }
    
    void breadth(int k, RandomAccessFile f) throws Exception {
        boolean[] en = new boolean[20];
        int i;
        for (i = 0; i < n; i++) {
            en[i] = false;
        }
        breadth(en, k, f);
        for (i = 0; i < n; i++) {
            if (!en[i]) {
                breadth(en, i, f);
            }
        }
    }
    
    void depth(boolean[] visited, int k, RandomAccessFile f) throws Exception {
        fvisit(k, f);
        visited[k] = true;
        for (int i = 0; i < n; i++) {
            if (!visited[i] && a[k][i] > 0) {
                depth(visited, i, f);
            }
        }
    }
    
    void depth(int k, RandomAccessFile f) throws Exception {
        boolean[] visited = new boolean[20];
        int i;
        for (i = 0; i < n; i++) {
            visited[i] = false;
        }
        depth(visited, k, f);
        for (i = 0; i < n; i++) {
            if (!visited[i]) {
                depth(visited, i, f);
            }
        }
    }
//===========================================================================
//(2)===YOU CAN EDIT OR EV//        
//    }EN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
    void depth2(boolean[] visited, int k, RandomAccessFile f) throws Exception {
        fvisit2(k, f);
        visited[k] = true;
        for (int i = 0; i < n; i++) {
            if (!visited[i] && a[k][i] > 0) {
                depth2(visited, i, f);
            }
        }
    }
    
    void depth2(int k, RandomAccessFile f) throws Exception {
        boolean[] visited = new boolean[20];
        for (int i = 0; i < n; i++) {
            visited[i] = false;
        }
        depth2(visited, k, f);
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                depth2(visited, i, f);
            }
        }
    }
    
    int count = 0;
    void fvisit2(int i, RandomAccessFile f) throws Exception {
        if (count == 7) {
            return;
        }
        if (count != 0) {
            f.writeBytes(" " + v[i]);
        }
        count++;
    }
    
    void f1() throws Exception {
        loadData(1);
        String fname = "f1.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        depth(3, f);
        f.writeBytes("\r\n");
        //-------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        depth2(3, f);
        //-------------------------------------------------------------------------------------
        f.writeBytes("\r\n");
        f.close();
    }
//===========================================================================

    void dijkstra(int u, int z, RandomAccessFile f) throws IOException, Exception {
        boolean[] c = new boolean[n];
        int[] d = new int[n];
        int[] t = new int[n];
        int INF = 99;
        for (int i = 0; i < n; i++) {
            this.d[i] = a[u][i];
            t[i] = u;
        }
        int curr = u;
        while (curr != z) {            
            int min = INF;
            int k = -1;
            for (int i = 0; i < n; i++) {
                if (!c[i] && this.d[i] < min) {
                    min = this.d[i];
                    k = i;
                }
            }
            if (min == INF) {
                System.out.println("Sortest path does not exists");
                return;              
            }
            c[k] = true;
            curr = k;
            for (int i = 0; i < n; i++) {
                if (this.d[i] > this.d[k] + a[k][i] && !c[i]) {
                    this.d[i] = this.d[k] + a[k][i];
                    t[i] = k;
                }
            }
        }
        int[] h = new int[n];
        int hn = 0;
        h[hn] = z;
        int x, y = z;
        while (u != z) {
            z = t[z];
            h[++hn] = z;
        }
        int[] w = new int[n];
        int wn = -1;
        for (int i = hn; i >= 0; i--) {
            x = y;
            y = h[i];
            w[++wn] = a[x][y];
        }
        int k = 0;
        for (int i = hn; i >= 0; i--) {
            f.writeBytes(v[h[i]] + " ");
        }
    }
    
    void dijkstra2(int u, int z, RandomAccessFile f) throws IOException, Exception {
        boolean[] c = new boolean[n];
        int[] d = new int[n];
        int[] t = new int[n];
        int INF = 99;
        for (int i = 0; i < n; i++) {
            this.d[i] = a[u][i];
            t[i] = u;
        }
        int curr = u;
        while (curr != z) {
            int min = INF;
            int k = -1;
            for (int i = 0; i < n; i++) {
                if (!c[i] && this.d[i] < min) {
                    min = this.d[i];
                    k = i;
                }
            }
            if (min == INF) {
                System.out.println("Sortest path does not exists");
                return;
            }
            c[k] = true;
            curr = k;
            for (int i = 0; i < n; i++) {
                if (this.d[i] > this.d[k] + a[k][i] && !c[i]) {
                    this.d[i] = this.d[k] + a[k][i];
                    t[i] = k;
                }
            }
        }
        int[] h = new int[n];
        int hn = 0;
        h[hn] = z;
        int x, y = z;
        while (u != z) {
            z = t[z];
            h[++hn] = z;
        }
        int[] w = new int[n];
        int wn = -1;
        for (int i = hn; i >= 0; i--) {
            x = y;
            y = h[i];
            w[++wn] = a[x][y];
        }
        int k = 0;
        for (int i = hn - 3; i >= 0; i--) {
            f.writeBytes(v[h[i]] + ", " + this.d[h[i]] + " ");
        }
    }
    
    void dijkstra3(int u, int z, RandomAccessFile f) throws IOException, Exception {
        boolean[] c = new boolean[n];
        int[] d = new int[n];
        int[] t = new int[n];
        int INF = 99;
        for (int i = 0; i < n; i++) {
            this.d[i] = a[u][i];
            t[i] = u;
        }
        int curr = u;
        while (curr != z) {
            int min = INF;
            int k = -1;
            for (int i = 0; i < n; i++) {
                if (!c[i] && this.d[i] < min) {
                    min = this.d[i];
                    k = i;
                }
            }
            if (min == INF) {
                System.out.println("Sortest path does not exists");
                return;
            }
            c[k] = true;
            curr = k;
            for (int i = 0; i < n; i++) {
                if (this.d[i] > this.d[k] + a[k][i] && !c[i]) {
                    this.d[i] = this.d[k] + a[k][i];
                    t[i] = k;
                }
            }
        }
        int[] h = new int[n];
        int hn = 0;
        h[hn] = z;
        int x, y = z;
        while (u != z) {
            z = t[z];
            h[++hn] = z;
        }
        int[] w = new int[n];
        int wn = -1;
        for (int i = hn; i >= 0; i--) {
            x = y;
            y = h[i];
            w[++wn] = a[x][y];
        }
        int k = 0;
        for (int i = hn - 5; i >= 0; i--) {
            f.writeBytes(v[h[i]] + ", " + this.d[h[i]] + " ");
        }
    }
   
    void f2() throws Exception {
        loadData(12);
        String fname = "f2.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        //-------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        f.writeBytes("\r\n");
        dijkstra(2, 5, f);
        f.writeBytes("\r\n");
        dijkstra2(0, 5, f);
        dijkstra3(0, 6, f);
        f.writeBytes("\r\n");
        dijkstra(0, 6, f);
        //-------------------------------------------------------------------------------------
        f.writeBytes("\r\n");
        f.close();
    }
    
}
