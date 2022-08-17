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

import java.util.Scanner;

public class DfsRecursion {
    static boolean visited[] = new boolean[101];
    static int matrix[][] = new int[101][101];
    static int n;

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

    static void dfs(int x, int n) {
        System.out.println(x + " ");
        visited[x] = true;
        for (int i = 1; i <= n; i++) {
            if (!visited[i] && matrix[x][i] == 1) {
                dfs(i, n);
            }
        }
    }

    public static void main(String[] args) {
        input();
        dfs(1, n);
    }
}
