/*
 * Copyright(C) 2021 ,FPT UNIVERSITY
 * 
 * DATE        Version         Author          DESCRIPTION
 * 15/08/2021    1.0            Vanhv   
 */
package BSTree1;

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

    Node search(Node p, int info) {
        if (p == null) {
            return null;
        }
        if (p.info == info) {
            return p;
        }
        if (info < p.info) {
            return search(p.left, info);
        } else {
            return search(p.right, info);
        }
    }

    void insert(int info) {
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
            if (info < p.info) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        if (info < f.info) {
            f.left = new Node(info);
        } else {
            f.right = new Node(info);
        }
    }

    void insertMany(int[] a) {
        for (int i = 0; i < a.length; i++) {
            insert(a[i]);
        }
    }

    void visit(Node p) {
        if (p != null) {
            System.out.print(p.info + " ");
        }
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
     * browse by previous
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
     * browse by between
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
     * browse by next
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
    
}
