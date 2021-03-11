package Algorithms_DataStruct.Algorithms.BFS_DFS;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Pass2 {
    static private int stack[] = new int[1000];
    static private int top = -1;

    static public void push(int x) {
        top++;
        stack[top] = x;
    }

    static public int peek() {
        return stack[top];
    }

    static public int pop() {
        int res = stack[top];
        top--;
        return res;
    }

    static public boolean isEmpty() {
        return top == -1;
    }

    static public int size() {
        return top + 1;
    }

    static public void show() {
        for (int i = 0; i < size(); i++) {
            System.out.print(stack[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("input"));
        for (int tCase = 1; tCase < 10; tCase++) {
            top = -1;
            int n = sc.nextInt();
            char arr[] = sc.nextLine().toCharArray();
            for (int i = 1; i <= n; i++) {
                int x = arr[i] - '0';
                if (!isEmpty() && x == peek()) {
                    pop();
                } else {
                    push(x);
                }
            }
            show();
        }
    }
}
