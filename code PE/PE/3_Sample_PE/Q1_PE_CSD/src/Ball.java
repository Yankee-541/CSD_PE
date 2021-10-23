
class Ball {

    String owner;
    int price;
    int radius;

    Ball(String xOwner, int xPrice, int xRadius) {
        owner = xOwner;
        price = xPrice;
        radius = xRadius;
    }

    public String toString() {
        return ("(" + owner + "," + price+"," + radius + ")");
    }
}
