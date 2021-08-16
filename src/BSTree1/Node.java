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
class Node {

    int info;
    Node left, right;

    public Node() {
    }

    public Node(int info, Node left, Node right) {
        this.info = info;
        this.left = left;
        this.right = right;
    }

    Node(int info) {
        this.info = info;
        left = right = null;
    }

}
