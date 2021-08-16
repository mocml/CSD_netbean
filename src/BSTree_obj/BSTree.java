/*
 * Copyright(C) 2021 ,FPT UNIVERSITY
 * 
 * DATE        Version         Author          DESCRIPTION
 * 15/08/2021    1.0            Vanhv   
 */
package BSTree_obj;

/**
 *
 * @author vanhv
 */
public class BSTree {

    Node root;

    public BSTree() {
        root = null;
    }

    void clear() {
        root = null;
    }

    boolean isEmpty() {
        return root == null;
    }

    Node search(Node p, Person info) {
        if (p == null) {
            return null;
        }
        if (p.info.name.equals(info.name)) {
            return p;
        }
        if (p.info.name.compareTo(info.name) > 0) {
            return search(p.left, info);
        } else {
            return search(p.right, info);
        }
    }

    void insert(Person info) {
        if (isEmpty()) {
            root = new Node(info);
            return;
        }
        Node f, p;
        f = null;
        p = root;
        while (p != null) {
            if (p.info == info) {
                System.out.println("The key " + info + " already exists !");
                return;
            }
            f = p;
            if (p.info.name.compareTo(info.name) > 0) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        if (f.info.name.compareTo(info.name) > 0) {
            f.left = new Node(info);
        } else {
            f.right = new Node(info);
        }
    }

    void insertMany(String[] name, int[] age, boolean[] gender, String[] address, String[] phone) {
        for (int i = 0; i < name.length; i++) {
            insert(new Person(name[i], age[i], gender[i % 2], address[i], phone[i]));
        }
    }

    void visit(Node p) {
        if (p != null) {
            System.out.print(p.info + " ");
        }
        System.out.println();
    }

    //add entity to queue tree
    void breath(Node p) {
        if (p == null) {
            return;
        }
        MyQueue q = new MyQueue();
        q.enqueue(p);
        Node r;
        while (!q.isEmpty()) {
            r = q.dequeue();
            visit(r);
            if (r.left != null) {
                q.enqueue(r.left);
            }
            if (r.right != null) {
                q.enqueue(r.right);
            }
        }
        System.out.println();
    }

    /**
     * browse by previous root -> left -> right
     *
     * @param p
     */
    void preOrder(Node p) {
        if (p == null) {
            return;
        }
        visit(p);
        preOrder(p.left);
        preOrder(p.right);
    }

    /**
     * browse by between left -> root -> right
     *
     * @param p
     */
    void inOrder(Node p) {
        if (p == null) {
            return;
        }
        inOrder(p.left);
        visit(p);
        inOrder(p.right);
    }

    /**
     * browse by next left -> right -> root
     *
     * @param p
     */
    void postOrder(Node p) {
        if (p == null) {
            return;
        }
        postOrder(p.left);
        postOrder(p.right);
        visit(p);
    }

    void deleteByCopy(String name) {
        Node f, p;
        f = null;
        p = root;
        while (p != null) {
            if (p.info.name.equals(name)) {
                break;
            }
            f = p;
            if (p.info.name.compareTo(name) > 0) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        //not found
        if (p == null) {
            return;
        }
        //p is leaf-node
        if (p.left == null && p.right == null) {
            if (f == null) { //p = root
                root = null;
            } else {
                if (f.left == p) {
                    f.left = null;
                } else {
                    f.right = null;
                }
                return;
            }
        }
        //p has left son only.
        if (p.left != null && p.right == null) {
            if (f == null) { //p = root
                root = p.left;
            } else {
                if (f.left == p) {
                    f.left = p.left;
                } else {
                    f.right = p.left;
                }
            }
            return;
        }
        //p has right son only.
        if (p.left == null && p.right != null) {
            if (f == null) { //p = root
                root = p.right;
            } else {
                if (f.left == p) {
                    f.left = p.right;
                } else {
                    f.right = p.right;
                }
            }
            return;
        }
        //p has both sons
        if (p.left != null && p.right != null) {
            //find the right-most node in the left sub-tree
            Node q = p.left;
            Node frp, rp;
            frp = null;
            rp = q;
            while (rp.right != null) {
                frp = rp;
                rp = rp.right;
            }
            //rp now is the right-most node
            p.info = rp.info;
            if (frp == null) {//q is the right-most node
                p.left = q.left;
            } else {
                frp.right = rp.left;
            }
        }
    }

}
