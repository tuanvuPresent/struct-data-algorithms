package Algorithms_DataStruct.DataStruct;

public class Stack {
    private int stack[];
    private int top;

    Stack(int n) {
        top = -1;
        stack = new int[n];
    }

    public void push(int x) {
        top++;
        stack[top] = x;
    }

    public int peek() {
        return stack[top];
    }

    public int pop() {
        int res = stack[top];
        top--;
        return res;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public int size() {
        return top + 1;
    }

    public void show() {
        for (int i = 0; i < size(); i++) {
            System.out.print(stack[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Stack stack = new Stack(10);
        stack.push(1);
        stack.push(2);
        stack.push(5);

        stack.pop();
        stack.show();
    }
}
