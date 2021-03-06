package person;

import java.util.ArrayList;

public class PersonList {

    Person head, tail;
    int size;

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

    public void addFirst(String id, String name, int age) {
        name = name.replace("\\s+", " ");
        Person node = new Person(id, name.trim(), age);
        if (isEmpty()) {
            head = tail = node;
        } else {
            node.next = head;
            head = node;
        }
        size++;
    }

    public void addIndex(String id, String name, int age, int index) {
        if (index < 0 || index > size) {
            return;
        }

        if (index == 0) {
            addFirst(id, name, age);
            return;
        }

        if (index == size) {
            addLast(id, name, age);
            return;
        }

        Person cur = head;
        for (int i = 0; i < index - 1; i++) {
            cur = cur.next;
        }
        name = name.replace("\\s+", " ");
        Person node = new Person(id, name.trim(), age);
        node.next = cur.next;
        cur.next = node;
        size++;
    }

    public void addLast(String id, String name, int age) {
        name = name.replace("\\s+", " ");
        Person node = new Person(id, name.trim(), age);
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

//    ============================================================================================================================
//      a.     Ki???m tra t??n b???t ?????u b???ng nguy??n ??m th?? do nothing, kh??ng th?? addfirst trong list
    public void addFirst1(String id, String name, int age) {
        if (name.startsWith("a") || name.startsWith("A")
                || name.startsWith("e") || name.startsWith("E")
                || name.startsWith("U") || name.startsWith("u")
                || name.startsWith("o") || name.startsWith("O")
                || name.startsWith("i") || name.startsWith("I")) {
            return;
        } else {
            addFirst(id, name, age);
        }
    }

//      b.    X??a b??? trong list to??n b??? nh???ng node c?? t??n k???t th??c b???ng ph??? ??m
    public void deletePerson() {
        Person cur = head;
        for (int i = 0; i < size; i++) {
            if (cur.name.endsWith("a") || cur.name.endsWith("A")
                    || cur.name.endsWith("U") || cur.name.endsWith("u")
                    || cur.name.endsWith("o") || cur.name.endsWith("O")
                    || cur.name.endsWith("i") || cur.name.endsWith("I")
                    || cur.name.endsWith("e") || cur.name.endsWith("E")) {
                deleteIndex(i);
                i--;
            }

                cur = cur.next;
            
        }
        display();
    }

//    c.    Sort t???t c??? c??c ph???n t??? t??ng d???n c???a t??n, n???u t??n tr??ng nhau th?? sort t??ng d???n c???a ID
    public void Sort() {
        for (Person cur = head; cur.next != null; cur = cur.next) { // s???p x???p t??ng d???n theo t??n
            for (Person cur2 = cur.next; cur2.next != null; cur2 = cur2.next) {
                if (cur.name.compareToIgnoreCase(cur2.name) >= 0) {
                    Person swap = new Person(cur.id, cur.name, cur.age);
                    cur.id = cur2.id;
                    cur.name = cur2.name;
                    cur.age = cur2.age;
                    cur2.id = swap.id;
                    cur2.name = swap.name;
                    cur2.age = swap.age;
                }
            }
        }

        for (Person cur = head; cur.next != null; cur = cur.next) {
            for (Person cur2 = cur.next; cur2.next != null; cur2 = cur2.next) { // n???u tr??ng t??n th?? sort t??ng theo ID
                if (cur.name.compareToIgnoreCase(cur2.name) == 0
                        && cur.id.compareToIgnoreCase(cur2.id) >= 0) {
                    Person swap = new Person(cur.id, cur.name, cur.age);
                    cur.id = cur2.id;
                    cur.name = cur2.name;
                    cur.age = cur2.age;
                    cur2.id = swap.id;
                    cur2.name = swap.name;
                    cur2.age = swap.age;
                }
            }
        }
        display();
    }

//    d.    T??m v?? x??a person c?? tu???i l???n h??n (b??) nh???t, sau ???? add v??o cu???i (?????u) c???a list.
    public void deleteAge() {
        int maxAge = head.age;
        int minAge = head.age;
        ArrayList<Person> max = new ArrayList<>();
        ArrayList<Person> min = new ArrayList<>();
        Person cur = head;
        for (int i = 0; i < size; i++) {
            if (cur.age > maxAge) {
                maxAge = cur.age;
            }
            if (cur.age < minAge) {
                minAge = cur.age;
            }
            cur = cur.next;
        }

        Person cur1 = head;
        for (int i = 0; i < size; i++) {
            if (cur1.age == maxAge) {
                max.add(cur1);
                deleteIndex(i);
                i--;
            }
            if (cur1.age == minAge) {
                min.add(cur1);
                deleteIndex(i);
                i--;
            }
            cur1 = cur1.next;
        }

        // add max age vao dau danh sach
        for (int i = 0; i < max.size(); i++) {
            addFirst(max.get(i).id, max.get(i).name, max.get(i).age);
        }
        // add min age vao cuoi danh sach
        for (int i = 0; i < min.size(); i++) {
            addLast(min.get(i).id, min.get(i).name, min.get(i).age);
        }

        display();
    }

//    e.    T??nh ????? tu???i trung b??nh c???a list
    public void averageAge() {
        Person cur = head;
        double average = 0;
        for (int i = 0; i < size; i++) {
            average += cur.age;
            cur = cur.next;
        }

        System.out.printf("The average age: %.1f\n", average / size);
    }

}
