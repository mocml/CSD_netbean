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
class Node {

    Person info;
    Node left;
    Node right;

    public Node() {
    }

    public Node(Person info, Node left, Node right) {
        this.info = info;
        this.left = left;
        this.right = right;
    }

    Node(Person info) {
        this.info = info;
        left = right = null;
    }

}
