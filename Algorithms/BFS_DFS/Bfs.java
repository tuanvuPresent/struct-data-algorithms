package Algorithms_DataStruct.Algorithms.BFS_DFS;

import java.util.Scanner;

//BFS
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
    Output:
        1
        2
        3
        5
        4
        6
        7
    */
public class Bfs {
    //queue
    static int q[];
    static int last, first;
    public static boolean visited[] = new boolean[101];
    public static int matrix[][] = new int[101][101];
    static int n;

    public static void initQueue() {
        q = new int[101];
        last = first = 0;
    }

    public static int pop() {
        int temp = first;
        first++;
        return q[temp];
    }

    public static void push(int x) {
        q[last] = x;
        last++;
    }

    public static boolean isEmpty() {
        return last == first;
    }


    public static void bfs(int v, int n) {
        initQueue();
        push(v);
        visited[v] = true;
        while (!isEmpty()) {
            int u = pop();
            System.out.println(u);

            for (int i = 1; i <= n; i++) {
                if (!visited[i] && matrix[u][i] == 1) {
                    push(i);
                    visited[i] = true;
                }
            }
        }
    }

    private static void input() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            matrix[x][y] = 1;
        }
    }

    public static void main(String[] args) {
        input();
        bfs(1, n);
    }
}
