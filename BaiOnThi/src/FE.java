
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author admin
 */
public class FE {

    int fun(int n) {
        if (n == 0) {
            return 1;
        } else {
            System.out.println(fun(n));
            return (fun(n-1) + fun(n / 2));
        }

//    void printOut(int n) {
//        if (n == 0) {
//            return;
//        }
//
//        System.out.print(n);
//
//        printOut(n - 1);
//
//        System.out.print(n);
//    }
//    int fun(int n) {
//        if (n == 1 || n == 2) {
//            return (1);
//        } else {
//            return (fun(n - 1) + 3 * fun(n - 2));
//        }
//
//    }
//    void fun(int n, int k) {
//        if (n > 0) {
//
//            System.out.print(" " + n % k);
//
//            fun(n/k,k);
//
//        }
//
//    }
//    void fun(int n) {
//        int m = n / 2;
//        int k = n % 2;
//        if (m > 0) {
//            fun(m);
////            System.out.println(m);
//        }
//        System.out.println(k + " ");
//        
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
//        int k = sc.nextInt();
        FE f = new FE();
        f.fun(n);
        System.out.println(f.fun(n));

//        f.printOut(n);
    }
}
