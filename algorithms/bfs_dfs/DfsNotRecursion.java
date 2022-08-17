import java.util.Scanner;

/*
        input:
            7 7
            1 2
            1 3
            1 5
            2 4
            2 6
            3 7
            5 6
        output:
            1
            2
            4
            6
            5
            3
            7
 */
public class DfsNotRecursion {
    static int stack[] = new int[101];
    static int top;
    static int matrix[][] = new int[101][101];
    static int n;
    static boolean visited[] = new boolean[101];

    static void initStack() {
        top = -1;
    }

    static void push(int x) {
        top++;
        stack[top] = x;
    }

    static int peek() {
        return stack[top];
    }

    static int pop() {
        int res = stack[top];
        top--;
        return res;
    }

    static boolean isEmpty() {
        return top == -1;
    }

    static void input() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            matrix[x][y] = 1;
            matrix[y][x] = 1;
        }
    }


    static void dfs(int x) {
        initStack();
        push(x);
        visited[x] = true;
        System.out.println(x);
        while (!isEmpty()) {
            boolean check = true; //check to pop in stack

            int u = peek();
            for (int i = 1; i <= n; i++) {
                if (!visited[i] && matrix[u][i] == 1) {
                    System.out.println(i);

                    push(i);
                    visited[i] = true;
                    check = false;
                    break;
                }
            }
            if (check) {
                pop();
            }
        }
    }


    public static void main(String[] args) {
        input();
        dfs(1);
    }
}
