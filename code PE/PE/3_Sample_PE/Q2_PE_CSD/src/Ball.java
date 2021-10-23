// ======= DO NOT EDIT THIS FILE ============

class Ball {

    String owner;
    int price;
    int radius;
    boolean type;

    public Ball(String xOwner, int xPrice, int xRadius, boolean xType) {
        this.owner = xOwner;
        this.price = xPrice;
        this.radius = xRadius;
        this.type = xType;
    }

    
    
    Ball(String xOwner, int xPrice, int xRadius) {
        owner = xOwner;
        price = xPrice;
        radius = xRadius;
    }

    public String toString() {
        return ("(" + owner + "," + price + "," + radius + ")");
    }
}
