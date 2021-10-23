
package car;

public class CarList {

    Car head, tail;
    int size = 0;

    boolean isEmpty() {
        return (head == null);
    }

    CarList() {
        head = tail = null;
        size = 0;
    }

    void display() {
        Car cur = head;
        while (cur != null) {
            System.out.print(cur);
            cur = cur.next;
        }
        System.out.println();
    }

    void addFirst(String name, double price) {
        Car node = new Car(name, price);
        if (isEmpty()) {
            head = tail = node;
        } else {
            node.next = head;
            head = node;
        }
        size++;
    }

// addLast (name, Price) : nếu tên Car bắt đầu bằng chữ B hoặc giá >100 thì không làm gì. Ngược lại thì add new car vào cuối của list.
    void addLast(String name, double price) {
        Car node = new Car(name, price);

        if (!name.startsWith("B") && price < 100) {

            if (isEmpty()) {
                head = tail = node;
            } else {
                tail.next = node;
                tail = node;
            }
            size++;
        }
    }

// AddIndex(Name, price,value): Add new Car(name, price) vào list ở vị trí phía sau phần tử đầu tiên có giá nhỏ hơn value đã cho
    void addIndex(String name, double price, double value) {
        if (size == 1) {
            if (price < value) {
                addLast(name, price);
            }
        }

        double count = 0;
        Car cur = head;
        while (cur != null && count != price) {
            count = cur.price;
            if (count < value) {
                break;
            }
            cur = cur.next;
        }
        if (cur == null) {
            return;
        } else {
            Car node = new Car(name, price);
            node.next = cur.next;
            cur.next = node;
        }
        size++;
    }
}
