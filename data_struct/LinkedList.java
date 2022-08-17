package Algorithms_DataStruct.DataStruct;

class SNode {
    public int data;
    public SNode next;

    public SNode(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LinkedList {
    SNode head;
    SNode tail;

    public void addHead(int data) {
        if (head == null) {
            head = new SNode(data);
            tail = head;
        } else {
            SNode node = new SNode(data);
            node.next = head;
            head = node;
        }
    }

    public void addTail(int data) {
        if (head == null) {
            head = new SNode(data);
            tail = head;
        } else {
            SNode node = new SNode(data);
            tail.next = node;
        }
    }

    public void show() {
        SNode node = head;
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public int size() {
        int res = 0;
        SNode node = head;
        while (node != null) {
            res++;
            node = node.next;
        }
        return res;
    }

    public void insert(int pos, int data) {
        if (pos < 0 || pos > size()) {
            return;
        } else {
            SNode node = new SNode(data);
            SNode temp = head;
            for (int i = 0; i < pos - 1; i++) {
                temp = temp.next;
            }

            node.next = temp.next;
            temp.next = node;
        }
    }

    public void remove(int pos) {
        if (pos < 0 || pos > size()) {
            return;
        } else {
            SNode temp = head;
            for (int i = 0; i < pos - 1; i++) {
                temp = temp.next;
            }
            temp.next = temp.next.next;
        }
    }


    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.addHead(10);
        list.addHead(11);
        list.show();
        list.addHead(5);
        list.addTail(15);
        list.show();

        list.insert(2, 2);
        list.insert(3, 3);
        list.show();
        list.remove(3);
        list.show();
    }
}
