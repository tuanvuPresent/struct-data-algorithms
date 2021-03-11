package Algorithms_DataStruct.DataStruct;

public class Queue {
    private int queue[];
    private int last, first;

    Queue(int n) {
        queue = new int[n];
        last = first = 0;
    }

    public int size() {
        return last;
    }

    public int peek() {
        return queue[first];
    }

    public int pop() {
        int temp = first;
        first++;
        return queue[temp];
    }

    public void push(int x) {
        queue[last] = x;
        last++;
    }

    public boolean isEmpty() {
        return last == first;
    }

    public void show() {
        for (int i = first; i < size(); i++) {
            System.out.print(queue[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Queue q = new Queue(10);
        q.push(1);
        q.push(12);
        q.push(16);

        q.pop();
        q.show();
    }
}
