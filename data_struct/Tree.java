package Algorithms_DataStruct.DataStruct;

class Node {
    public int data;
    public Node left;
    public Node right;

    public Node(int data) {
        this.data = data;
        this.right = this.left = null;
    }
}

public class Tree {
    Node root;

    private Node addRecursive(Node current, int data) {
        if (current == null) {
            return new Node(data);
        }

        if (data < current.data) {
            current.left = addRecursive(current.left, data);
        } else if (data > current.data) {
            current.right = addRecursive(current.right, data);
        } else {
            // value already exists
            return current;
        }

        return current;
    }

    private void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.data + " ");
            inorderRec(root.right);
        }
    }

    private int findMaxRec(Node current) {
        if (current.right == null) {
            return current.data;
        }
        return findMaxRec(current.right);
    }

    private int findMinRec(Node current) {
        if (current.left == null) {
            return current.data;
        }
        return findMinRec(current.left);
    }

    private Node deleteRec(Node current, int key) {
        if (current == null) {
            return current;
        }
        if (key < current.data)
            current.left = deleteRec(current.left, key);
        else if (key > current.data)
            current.right = deleteRec(current.right, key);
        else {
            // node with only one child or no child
            if (current.left == null)
                return current.right;
            else if (current.right == null)
                return current.left;

            // node with two children: Get the inorder successor (smallest in the right subtree)
            current.data = findMinRec(current.right);
            // Delete the inorder successor
            current.right = deleteRec(current.right, current.data);
        }
        return current;
    }

    private boolean searchRec(Node current, int key) {
        if (current == null) {
            return false;
        }
        if (key == current.data) {
            return true;
        }
        if (key < current.data) {
            return searchRec(current.left, key);
        } else {
            return searchRec(current.right, key);
        }
    }

    public void add(int x) {
        root = addRecursive(root, x);
    }

    public void inorder() {
        inorderRec(root);
    }

    public boolean search(int key) {
        return searchRec(root, key);
    }

    public int max() {
        return findMaxRec(root);
    }

    public int min() {
        return findMinRec(root);
    }

    public void delete(int key) {
        root = deleteRec(root, key);
    }

    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.add(5);
        tree.add(7);
        tree.add(1);
        tree.add(2);
        tree.add(0);
        tree.add(9);
        tree.add(8);

        tree.inorder();
        System.out.println();

        tree.delete(7);
        tree.inorder();
        System.out.println();

        System.out.println(tree.search(5));

        System.out.println("max = " + tree.max());
        System.out.println("min = " + tree.min());
    }
}