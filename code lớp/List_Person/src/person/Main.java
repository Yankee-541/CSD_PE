package person;

public class Main {

    public static void main(String[] args) {
        PersonList s = new PersonList();

//        a: Kiểm tra tên bắt đầu bằng nguyên âm thì do nothing, không thì addfirst trong list
//        s.addFirst1("1", "Dang", 10);
//        s.addFirst1("2", "Tran", 11);
//        s.addFirst1("3", "Hue", 12);
//        s.addLast("4", "Oanh", 13);
//        s.addLast("5", "Tien", 14);
//        s.addLast("6", "Haha", 15);
//        s.addFirst1("7", "Trang", 16);
//        s.display();

//        b: Xóa bỏ trong list toàn bộ những node có tên kết thúc bằng phụ âm
        s.addFirst1("1", "Dang", 10);
        s.addFirst1("2", "Tran", 11);
        s.addFirst1("3", "Hue", 12);
        s.addLast("4", "Oanh", 13);
        s.addLast("5", "Tien", 14);
        s.addLast("6", "Haha", 15);
        s.display();
        s.deletePerson();

//        c:  Sort tất cả các phần tử tăng dần của tên, nếu tên trùng nhau thì sort tăng dần của ID
//        s.addFirst1("1", "Dang", 10);
//        s.addFirst1("2", "Tran", 11);
//        s.addFirst1("3", "Hue", 12);
//        s.addLast("4", "Oanh", 13);
//        s.addLast("5", "Tien", 14);
//        s.addLast("6", "Haha", 15);
//        s.display();
//        s.Sort();

//        d.    Tìm và xóa person có tuổi lớn hơn (bé) nhất, sau đó add vào cuối (đầu) của list
//         s.addFirst1("1", "Dang", 10);
//        s.addFirst1("2", "Tran", 11);
//        s.addFirst1("3", "Hue", 12);
//        s.addLast("4", "Oanh", 13);
//        s.addLast("5", "Tien", 14);
//        s.addLast("6", "Haha", 15);
//        s.display();
//        s.deleteAge();

//        e: Tính độ tuổi trung bình của list
//        s.addFirst1("1", "Dang", 10);
//        s.addFirst1("2", "Tran", 11);
//        s.addFirst1("3", "Hue", 12);
//        s.addLast("4", "Oanh", 13);
//        s.addLast("5", "Tien", 14);
//        s.addLast("6", "Haha", 15);
//        s.display();
//        s.averageAge();
    }

}
