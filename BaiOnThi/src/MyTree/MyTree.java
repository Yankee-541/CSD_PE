package MyTree;

public class MyTree {

    Node root;
//    Node nodecanxoa;

    public MyTree() {

    }

    boolean isEmty() {
        return root == null;
    }

    void add(Car value) {
        Node node = new Node(value);
        if (isEmty()) {
            root = node;
            return;
        }

        Node cur = root;
        Node father = null;

        while (cur != null) {
            if (cur.value.price == value.price) {
                System.out.println("Khong ther add " + value + " vaof trong tree!");
                return;
            }

            father = cur;
            if (cur.value.price < value.price) {
                cur = cur.right;
            } else {
                cur = cur.left;
            }
        }
        if (father.value.price < value.price) {
            father.right = node;
        } else {
            father.left = node;
        }

    }

    void visit(Node p) {
        System.out.print(p.value);
    }

    void preOrder(Node p) {
        if (p == null) {
            return;
        }
        visit(p);
        preOrder(p.left);
        preOrder(p.right);
    }

    void preOrder() {
        preOrder(root);
    }

    void postrOrder(Node p) {
        if (p == null) {
            return;
        }
        postrOrder(p.left);
        postrOrder(p.right);
        visit(p);
    }

    void postOrder() {
        postrOrder(root);
    }

    void InOrder(Node p) {
        if (p == null) {
            return;
        }

        InOrder(p.left);
        visit(p);
        InOrder(p.right);
    }

    void InOrder() {
        InOrder(root);
    }

    void BreadthFirstOrder() {
        BreadthFirstOrder(root);
    }

    void BreadthFirstOrder(Node p) {
        MyQueue queue = new MyQueue();

        if (isEmty()) {
            return;
        }

        queue.EnQueue(root);
        while (!queue.isEmty()) {          // dk sai  
            Node node = queue.deQueue();
            if (node.left != null) {
                queue.EnQueue(node.left);
            }

            if (node.right != null) {
                queue.EnQueue(node.right);
            }

            visit(node);
        }
    }

    void deleteByCopyL(Node p) { // xoa node p trong con trai
        if (p == null) {
            return;
        }
        if (p.left == null) {  // khong co con trai thi copy con phai
            return;
        }

        if (p.left.right == null) { // neu p chi co con trai
            p.value = p.left.value;
            p.left = p.left.left; // thang giau nhat cua con trai la chinh no
            return;
        } else {
            Node father = p.left; // father se quan ly node cha cua node ngoai cung ben phai cua con ben trai
//            Node cur = p.left.right;
            while (father.right.right != null) {
                father = father.right;
            }

            p.value = father.right.value;
            if (father.right.left == null) {
                father.right = null;
                return;
            }

            father.right = father.right.left;
        }
    }

    void deleteByCopyR(Node p) { // xoa node p trong con phai
        Node curR = root;
        Node preCur = curR;

        if (p == null) {
            return;
        }
        if (p.left == null && p.right == null) {
            while (curR != null) {

                if (curR.value.price == p.value.price) {
                    break;
                }
                preCur = curR;
                curR = curR.value.price < p.value.price ? curR.right : curR.left;
            }
            if (preCur.left != null && preCur.left.value.price == p.value.price) {
                preCur.left = null;
            }
            if (preCur.right != null && preCur.right.value.price == p.value.price) {
                preCur.right = null;
            }
            return;
        }
        if (p.right == null) {  // khong co con phai thi copy con trai
            deleteByCopyL(p);
            return;
        }

        if (p.left == null) { // neu p chi co con phai
            p.value = p.right.value;
            p.right = p.right.right; // thang giau nhat cua con trai la chinh no
            return;
        } else {
            Node father = p.right; // father se quan ly node cha cua node ngoai cung ben phai cua con ben trai
            Node cur = p.right.left;
            while (father.left.left == null) {
                father = father.left;
                cur.value = father.left.value;
            }
            if (father.left.right == null) {
                father.left = null;
                return;
            }
            father.left = father.left.right;
        }
        curR = p;

    }

    Node getParent(Node p) {
        if (p == root) {
            return null;
        }
        Node father = null, cur = root;

        while (cur != null && cur.value.price != p.value.price) {
            father = cur;
            if (cur.value.price < p.value.price) {
                cur = cur.right;
            } else {
                cur = cur.left;
            }
        }

        if (cur == null) { // khong tim thay p trong tree
            return null;
        }

        return father;
    }

    Node findNode(int key) { // tim node bat ky de xoa
        Node cur = root;

        while (cur != null) {
            if (cur.value.price == key) {
                return cur;
            }
            cur = cur.value.price < key ? cur.right : cur.left;
        }

        return null;
    }

    void deleteByMerging(Node p) {
        Node father = getParent(p);
        if (father == null) {
            if (p.value.price != root.value.price) { // khong co p trong tree
                System.out.println("Node " + p + " not exist!");
            }

            if (root.left == null) { // khong co con trai thif xoa con phai
                root = root.right;
                return;
            }

            if (root.left.right == null) {      // gia tri ngoai cung cua con ben phai cua con ben trai chinh la con ben trai
                root.left.right = root.right;
                root = root.left;
                return;
            }

            Node q = root.left;
            while (q.right != null) {
                q = q.right;
            }

            q.right = p.right;
            root = p.left;
            return;
        }

        Car c = p.value;
        if (p.left == null) {
            if (c.price < father.value.price) { // node xoa nam o ben trai cua cha
                father.left = p.right;
            } else {
                father.right = p.left;
            }
            return;
        }

        Node q = p.left;
        while (q.right != null) {
            q = q.right; // q la not ngoai cung ben phai cua con trai p
        }

        q.right = p.right; // gan toan bo con ben cua node can xoa vao
        // ben phai cua gai tri ngoai cung ben phai cua con ben trai ( node can xoa)
        if (c.price < father.value.price) { // node can xoa nam o ben trai cua cha
            father.left = p.left;
        } else {
            father.right = p.right;
        }
    }

    Node rotateRight(Node p) {
        if (p == null || p.left == null) {
            return null;
        }
        Node parent = getParent(p);
        Node child = p.left;
        p.left = child.right;
        child.right = p;

        if (parent == null) {
            root = child;
        } else {
            parent.left = child;
        }
        return child;
    }

    Node rotateLeft(Node p) {
        if (p == null || p.right == null) {
            return null;
        }
        Node parent = getParent(p);
        Node child = p.right;
        p.right = child.left;
        child.left = p;
        if (parent == null) {
            root = child;
        } else {
            parent.right = child;
        }
        return child;
    }

//    ======================================================================================================================================================================
    //    f1:  insert (string xOwner, int xPrice), check nếu xOwner.charA(0)=”B” hay xPrice>100 thì do nothing, 
//            ngược lại thì insert new car với owner=xOwner, price=xPrice vảo tree
    void insert(String xOwner, int xPrice) {
        if (xOwner.charAt(0) == 'B' || xPrice > 100) {
            return;
        }

        Car value = new Car(xOwner, xPrice);
        Node p = new Node(value);

        if (isEmty()) {
            root = p;
            return;
        }

        Node cur = root;
        Node father = null;
        while (cur != null) {
            if (cur.value.price == value.price) {
                System.out.println("Khong ther add " + value + " vaof trong tree!");
                return;
            }

            father = cur;
            if (cur.value.price < value.price) {
                cur = cur.right;
            } else {
                cur = cur.left;
            }
        }
        if (father.value.price < value.price) {
            father.right = p;
        } else {
            father.left = p;
        }
    }

    public void f1() {
        insert("A", 5);
        insert("C", 2);
        insert("B", 7); // vi phạm điều kiện
        insert("E", 4);
        insert("G", 3);
        insert("HH", 101); // vi phạm điều kiện
        insert("F", 6);
        insert("F", 7);
        preOrder();
        System.out.println();
        InOrder();
        System.out.println("");
    }

//  f2: Thực hiện PreOrder từ root nhưng display f2 các nodes có giá trong khoảng [3.5] 
//    (thực hiện bằng cách copy hàm preOrder() thành hàm preorder2() và sửa nó.
    void preOder2(Node p) {
        if (p == null) {
            return;
        }
        if (3 <= p.value.price && p.value.price <= 5) {
            visit(p);
        }
        preOder2(p.left);
        preOder2(p.right);
    }

    public void f2() {
        add(new Car("C", 6));
        add(new Car("D", 2));
        add(new Car("F", 4));
        add(new Car("H", 3));
        add(new Car("I", 5));
        add(new Car("E", 8));
        add(new Car("G", 7));
        preOrder();
        System.out.println("");
        preOder2(root);
        System.out.println("");
    }

    // f3: Thực hiện Breadth-First từ root và delete by copying node đầu tiên có 2 con và giá <7
    void breadth2(Node p) {
        MyQueue queue = new MyQueue();

        if (isEmty()) {
            return;
        }

        queue.EnQueue(p);
        while (!queue.isEmty()) {          // dk sai  
            Node node = queue.deQueue();
            if (node.left != null && node.right != null && node.value.price < 7) {
                deleteByCopyL(node);
                break;
            }
            if (node.left != null) {
                queue.EnQueue(node.left);
            }

            if (node.right != null) {
                queue.EnQueue(node.right);
            }
        }
    }

    public void f3() {
        add(new Car("C", 8));
        add(new Car("D", 6));
        add(new Car("E", 9));
        add(new Car("F", 2));
        add(new Car("G", 7));
        add(new Car("H", 1));
        add(new Car("I", 3));
        add(new Car("J", 5));
        add(new Car("K", 4));
        BreadthFirstOrder();
        System.out.println("");

        breadth2(root);
        BreadthFirstOrder();
        System.out.println("");
    }

//      f4: Thực hiện Breadth-First từ  root và tìm node p có con trái và giá nhỏ hơn 7. Quay p sang phải với con trái của nó
    void breadth3(Node p) {
        MyQueue queue = new MyQueue();
        if (isEmty()) {
            return;
        }

        queue.EnQueue(p);
        while (!queue.isEmty()) {          // dk sai  
            Node node = queue.deQueue();
            if (node.left != null && node.value.price < 7) {
                p = rotateRight(node);
                break;
            }
            if (node.left != null) {
                queue.EnQueue(node.left);
            }

            if (node.right != null) {
                queue.EnQueue(node.right);
            }
        }
    }

    public void f4() {
        add(new Car("C", 8));
        add(new Car("D", 6));
        add(new Car("E", 9));
        add(new Car("F", 2));
        add(new Car("G", 7));
        add(new Car("H", 1));
        add(new Car("I", 3));
        add(new Car("J", 5));
        add(new Car("K", 4));
        BreadthFirstOrder();
        System.out.println("");
        breadth3(root);
        BreadthFirstOrder();
        System.out.println("");
    }

}
