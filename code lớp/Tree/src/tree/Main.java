package tree;

public class Main {

    public static void main(String[] args) {
        MyTree my = new MyTree();

        //f1
//        my.insert("A", 5);
//        my.insert("C", 2);
//        my.insert("E", 4);
//        my.insert("G", 3);
//        my.insert("D", 6);
//        my.insert("F", 7);
//        my.preOrder();
//        System.out.println("");
//       my.InOrder();
//        System.out.println("");
        //f2
//        my.add(new Car("C", 6));
//        my.add(new Car("D", 2));
//        my.add(new Car("F", 4));
//        my.add(new Car("H", 3));
//        my.add(new Car("I", 5));
//        my.add(new Car("E", 8));
//        my.add(new Car("G", 7));
//        my.preOrder();
//        System.out.println("");
//        my.preOrder2();
//        System.out.println("");
//f3

//        my.add(new Car("C", 8));
//        my.add(new Car("D", 6));
//        my.add(new Car("E", 9));
//        my.add(new Car("F", 2));
//        my.add(new Car("G", 7));
//        my.add(new Car("H", 1));
//        my.add(new Car("I", 3));
//        my.add(new Car("J", 5));
//        my.add(new Car("K", 4));
//        my.preOrder();
//        System.out.println("");
//        my.breadth2();
//        System.out.println("");

//f4
        my.add(new Car("C", 8));
        my.add(new Car("D", 6));
        my.add(new Car("E", 9));
        my.add(new Car("F", 2));
        my.add(new Car("G", 7));
        my.add(new Car("H", 1));
        my.add(new Car("I", 3));
        my.add(new Car("J", 5));
        my.add(new Car("K", 4));
        my.preOrder();
        my.breadth3();
    }

}
