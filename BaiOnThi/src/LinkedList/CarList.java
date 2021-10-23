
package LinkedList;

public class CarList {

    Node head, tail;
    int size;

    boolean isEmpty() {
        return (head == null);
    }

    public CarList() {
        head = tail = null;
        size = 0;
    }

    void display() {
        Node cur = head;
        while (cur != null) {
            if (cur.next == null) {
                System.out.print(cur.value);
            } else {
                System.out.print(cur.value);
            }
            cur = cur.next;
        }
        System.out.println("");
    }

    void addFirst(String name, double price) {
        Node node = new Node(new Car(name, price));
        if (isEmpty()) {
            head = tail = node;
        } else {
            node.next = head;
            head = node;
        }
        size++;
    }

    void addLast(String name, double price) {
        Node node = new Node(new Car(name, price));
        if (isEmpty()) {
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        size++;
    }

    void deleteFirst() {
        if (isEmpty()) {
            return;
        }
        head = head.next;
        size--;

    }

    void deleteLast() {
        if (isEmpty()) {
            return;
        }
        Node cur = head;

        while (cur.next.next != null) {
            cur = cur.next;
        }

        cur.next = null;
        tail = cur;
        size--;
    }

    void deleteIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }

        if (index == 0) {
            deleteFirst();
            return;
        }
        if (index == size - 1) {
            deleteLast();
            return;
        }
        int count = 0;
        Node cur = head;
        while (count != index - 1) {
            cur = cur.next;
            count++;
        }

        cur.next = cur.next.next;
        size--;
    }
//===========================================================================================
// f1:  addLast (name, Price): nếu tên Car bắt đầu bằng chữ B hoặc giá >100 thì không làm gì

    public void addLast1(String name, double price) {
        Node node = new Node(new Car(name, price));
        if (name.startsWith("B") || price > 100) {
            return;
        }
        if (isEmpty()) {
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        size++;
    }

    public void f1() {
        addFirst("A", 9);
        addLast1("C", 7);
        addLast1("D", 2);
        addLast1("F", 4);
        addLast1("B", 20); // vi phạm điều kiện
        addLast1("E", 6);
        addLast1("A", 101); // vi phạm điều kiện
        display();
    }

//  f2: AddFirst đối tượng x (Owner, price): Add new Car (name, price) vào list
    public void f2() {
        addFirst("C", 9);
        addLast("D", 6);
        addLast("E", 8);
        addLast("F", 2);
        addLast("I", 6);
        display();
        addFirst("X", 1);
        display();
    }

//    f3:  DeleteIndex (): Xóa bỏ phần tử Car đầu tiên trong list mà có giá là 5
    public void f3() {
        addFirst("C", 9);
        addLast("D", 5);
        addLast("E", 3);
        addLast("F", 5);
        addLast("I", 6);
        display();
        Node cur = head;
        for (int i = 0; i < size; i++) {
            if (cur.value.price == 5) {
                deleteIndex(i);
                break;
            }
            cur = cur.next;
        }
        display();
    }
//    f4:Sort ()- Sort list theo giá

    public void f4() {
        addFirst("C", 9);
        addLast("D", 6);
        addLast("E", 5);
        addLast("F", 13);
        addLast("I", 2);
        addLast("J", 1);
        display();

        for (Node cur = head; cur != null; cur = cur.next) {
            for (Node cur1 = cur.next; cur1 != null; cur1 = cur1.next) {
                if (cur.value.price > cur1.value.price) {
                    Node tmp = new Node(cur.value);
                    cur.value = cur1.value;
                    cur1.value = tmp.value;
                }
            }
        }
        display();
    }

}
