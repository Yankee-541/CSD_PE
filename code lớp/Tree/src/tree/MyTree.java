package tree;

public class MyTree {

    Node root;

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
                System.out.print("Khong ther add " + value + " vaof trong tree!");
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
        preOrder(p.left);
        preOrder(p.right);
        visit(p);
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
        if (p == null) {
            return;
        }
        queue.EnQueue(p);
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
        if (p.left == null && p.right == null) {  // khong co con trai thi copy con phai
            p = null;
            return;
        }
        if (p.left == null) {  // khong co con trai thi copy con phai
            deleteByCopyR(p);
            return;
        }
        if (p.left.right == null) { // neu p chi co con trai
            p.value = p.left.value;
            p.left = p.left.left; // thang giau nhat cua con trai la chinh no
            return;
        } else {
            Node father = p.left; // father se quan ly node cha cua node ngoai cung ben phai cua con ben trai
//            Node cur = p.left.right;
            Car tmp;
            while (father.right.right != null) {
                father = father.right;
                tmp = father.right.value;

            }

            if (father.right.left == null) {
                p.value = father.right.value;

                father.right = null;
                return;
            } else if (father.right.left != null) {
                p.value = father.right.value;
                father.right = father.right.left;
            }
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
//f1

    void insert(String xOwner, int xPrice) {
        if (xOwner.charAt(0) == 'B' || xPrice > 100) {
            return;
        }
        Car value = new Car(xOwner, xPrice);
        Node node = new Node(value);
        if (isEmty()) {
            root = node;
            return;
        }
        Node cur = root;
        Node father = null;
        while (cur != null) {
            if (cur.value.price == value.price) {
                System.out.print("K the add " + value + " vao trong tree");
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
//f2

    void preOrder2(Node p) {
        if (p == null) {
            return;
        }
        if (p.value.price >= 3 && p.value.price <= 5) {
            visit(p);
        }
        preOrder2(p.left);
        preOrder2(p.right);
    }

    void preOrder2() {
        preOrder2(root);
    }

    //f3
    void breadth2(Node p) {
        MyQueue q = new MyQueue();
        if (isEmty()) {
            return;
        }
        q.EnQueue(p);
        Node r;
        while (!q.isEmty()) {
            Node node = q.deQueue();
            if (node.left != null && node.right != null && node.value.price < 7) {
                deleteByCopyL(node);
                break;
            }
            if (node.left != null) {
                q.EnQueue(node.left);
            }
            if (node.right != null) {
                q.EnQueue(node.right);
            }
//            visit(p);
        }
    }

    void breadth2() {
        breadth2(root);
        BreadthFirstOrder();
    }

    void deleteByMerging(Node p) {
        Node father = getParent(p);
        if (father == null) {
            if (p.value.price != root.value.price) { // khong co p trong tree
                System.out.print("Node " + p + " not exist!");
                return;
            }
            if (root.left == null) { // khong co con trai thif xoa con phai
                root = root.right;
                return;
            }
            if (root.right == null) {      // gia tri ngoai bên trái con bên phải
                root = root.left;
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
            } else { //node xoa nam ben phai cha
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
        Node cur = root;
        while (cur != null) {
            if (cur.value.price == p.value.price) {
                break;
            }
            cur = cur.value.price < p.value.price ? cur.right : cur.left;
        }
        cur = p.left;
        p.left = cur.right;
        cur.right = p;
//        p = null;
        p = cur;
        root.left = p;
        return p;
    }
    Node rotateLeft(Node p) {
        if (p.left == null) {
            return null;
        }
        Node child = p.left;
        p.left = child.right;
        child.right = p;
//        root = child;
        return child;
    }
//f4
    void breadth3(Node p) {
        MyQueue q = new MyQueue();
        if (isEmty()) {
            return;
        }
        if (p == null) {
            return;
        }
        q.EnQueue(p);
        while (!q.isEmty()) {
            Node node = q.deQueue();
            if (node.left != null && node.value.price < 7) {
                p = rotateRight(root.left);
                break;
            }
            if (node.left != null) {
                q.EnQueue(node.left);
            }
            if (node.right != null) {
                q.EnQueue(node.right);
            }
        }
    }
    void breadth3() {
        System.out.println("");
        breadth3(root);
        BreadthFirstOrder();
        System.out.println("");
    }
}
