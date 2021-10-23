
package car;

public class Main {

    public static void main(String[] args) {
        CarList car = new CarList();
        car.addFirst("A", 14);
        car.addLast("C", 15);
        car.addFirst("D", 17);
        car.addLast("E", 18);
        car.addFirst("A", 120);
        car.display();
        car.addIndex("F", 30, 20);
        System.out.println("After add index: ");
        car.display();
    }
}
