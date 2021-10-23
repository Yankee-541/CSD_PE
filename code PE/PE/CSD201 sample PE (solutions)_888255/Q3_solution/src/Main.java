
import java.util.Scanner;

public class Main {

    public static void main(String args[]) throws Exception {
        Graph t = new Graph();
        int choice;
        Scanner sca = new Scanner(System.in);
        System.out.println();
        System.out.println(" 1. Test f1 (1 mark)");
        System.out.println(" 2. Test f2 (1 mark)");
        System.out.println(" 3. Test f3 (1 mark)");
        System.out.print("    Your selection (1 -> 3): ");
        choice = sca.nextInt();
        sca.nextLine();
        switch (choice) {
            case 1:
                t.f1();
                System.out.println("Your output:");
                Lib.viewFile("f1.txt");
                break;
            case 2:
                t.f2();
                System.out.println("Your output:");
                Lib.viewFile("f2.txt");
                break;
            case 3:
                t.f3();
                System.out.println("Your output:");
                Lib.viewFile("f3.txt");
                break;
            default:
                System.out.println("Wrong selection");
        }
        System.out.println();
    }
}
