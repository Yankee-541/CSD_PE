
package car;

import java.text.DecimalFormat;

public class Car {
    String name;
    double price;
    Car next;
    public Car() {
    }

    public Car(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        DecimalFormat format = new DecimalFormat("0.#");
        return "(" + name + "," + format.format(price) + ")";
    }
    
    
}
