package MyTree;


public class Main {

    public static void main(String[] args) {
        MyTree my = new MyTree();

//            f1: 
//        my.insert("A", 5);
//        my.insert("C", 2);
//        my.insert("B", 7); // vi phạm điều kiện
//        my.insert("E", 4);
//        my.insert("G", 3);
//        my.insert("HH", 101); // vi phạm điều kiện
//        my.insert("F", 6);
//        my.insert("F", 7);
//        my.preOrder();
//        System.out.println();
//        my.InOrder();
//        System.out.println("");
//          f2:
//        my.add(new Car("C", 6));
//        my.add(new Car("D", 2));
//        my.add(new Car("F", 4));
//        my.add(new Car("H", 3));
//        my.add(new Car("I", 5));
//        my.add(new Car("E", 8));
//        my.add(new Car("G", 7));
//        my.preOrder();
//        System.out.println("");
//        my.f2();
//       

//            f3:
//        my.add(new Car("C", 8));
//        my.add(new Car("D", 6));
//        my.add(new Car("E", 9));
//        my.add(new Car("F", 2));
//        my.add(new Car("G", 7));
//        my.add(new Car("H", 1));
//        my.add(new Car("I", 3));
//        my.add(new Car("j", 5));
//        my.add(new Car("K", 4));
//        my.BreadthFirstOrder();
//        System.out.println("");
//        my.f3();

//        f4:
        my.add(new Car("C", 8));
        my.add(new Car("D", 6));
        my.add(new Car("E", 9));
        my.add(new Car("F", 2));
        my.add(new Car("G", 7));
        my.add(new Car("H", 1));
        my.add(new Car("I", 3));
        my.add(new Car("j", 5));
        my.add(new Car("K", 4));
        my.BreadthFirstOrder();
        System.out.println("");
        my.f4();
        
    }

}
