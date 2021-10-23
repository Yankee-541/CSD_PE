
import java.util.ArrayList;


public class PersonList {

    Person head, tail;
    int size = 0;

    boolean isEmpty() {
        return (head == null);
    }

    public PersonList() {
        head = tail = null;
        size = 0;
    }

    public void display() {
        Person cur = head;
        while (cur != null) {
            System.out.print(cur + ",");
            cur = cur.next;

        }
        System.out.println("\b");
    }

    public void addFirst(String ID, String name, int age) {
        Person node = new Person(ID, name, age);
        if (isEmpty()) {
            head = tail = node;
        } else {
            node.next = head;
            head = node;
        }
        size++;
    }

    public void addLast(String ID, String name, int age) {
        Person node = new Person(ID, name, age);
        if (isEmpty()) {
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        size++;
    }

    public void deleteFirst() {
        if (isEmpty()) {
            return;
        }
        head = head.next;
        size--;

    }

    public void deleteLast() {
        if (isEmpty()) {
            return;
        }
        Person cur = head;

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
        Person cur = head;
        while (count != index - 1) {
            cur = cur.next;
            count++;
        }

        cur.next = cur.next.next;
        size--;
    }

    public void checkName(String ID, String name, int age) {
        if (name.startsWith("E") || name.startsWith("U") || name.startsWith("O") || name.startsWith("A") || name.startsWith("I")) {
            return;
        } else {
            addFirst(ID, name, age);
        }
    }
//Xóa bỏ trong list toàn bộ những node có tên kết thúc bằng phụ âm

    public void deletePerson() {
        Person cur = head;
        for (int i = 0; i < size; i++) {
            if (cur.name.endsWith("g")) {
                deleteIndex(i);
                i--;
            }
            cur = cur.next;
        }
        display();
    }

//    Person swap = new Person(cur.id)
    
    
    void MaxAge() {
        if (isEmpty()) {
            return;
        }

        Person cur = head;
        int count = 0;
        double tmpMaxAge = head.age;
//        int numberOfMaxPrice = 0;
        while (cur.next != null) {
            count++;
            if (tmpMaxAge < cur.next.age) {
                tmpMaxAge = cur.next.age;
                cur = cur.next;
            } else {
                cur = cur.next;
            }
        }
//        System.out.println("MAX price: " + tmpMaxPrice);
        cur = head;
        count = 0;
        ArrayList<Person> listMaxPrice = new ArrayList<>();
        while (cur != null) {

            if (cur.age == tmpMaxAge) {
                listMaxPrice.add(cur);
                deleteIndex(count);
                count--;
                cur = cur.next;
            } else {
                cur = cur.next;
            }
            count++;
        }
        count = 0;
        while (count < listMaxPrice.size()) {
            addFirst(listMaxPrice.get(count).name, listMaxPrice.get(count).age);
            count++;
        }
        display();
        count = 0;
        while (count < listMaxPrice.size()) {
            deleteFirst();
            addLast(listMaxPrice.get(count).name, listMaxPrice.get(count).age);
            count++;
        }
        display();
    }

    public double AvgAge() {
        Person cur = head;
        double avg = 0;
        for (int i = 0; i < cur.age; i++) {
            avg = avg + cur.age;
        }
        avg = avg / cur.age;
        System.out.println(avg);
        return avg;
    }


}
