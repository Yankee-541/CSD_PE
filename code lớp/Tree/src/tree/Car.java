package tree;

public class Car {
    String name;
    int price;

    public Car() {
    }

    public Car(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "(" + name + "," + price + ')';
    }

}
