package Algorithms_DataStruct.Algorithms.BFS_DFS;

import java.io.FileInputStream;
import java.util.Scanner;

public class GridAcid {
    static int numberTest, row, col, x, y;
    static int count1 = 0, count2 = 0;
    static int matrix[][] = new int[3001][3001];
    static boolean visited[][] = new boolean[3001][3001];
    static int dxCellC, dyCellC;
    //queue
    static int[] queueX = new int[10000001];
    static int[] queueY = new int[10000001];
    static int[] queueZ = new int[10000001];
    static int front = 0, end = 0;
    static int dx, dy, dz;

    static void pop() {
        dx = queueX[front];
        dy = queueY[front];
        dz = queueZ[front];
        front++;
    }

    static void push(int x, int y, int z) {
        queueX[end] = x;
        queueY[end] = y;
        queueZ[end] = z;
        end++;
    }

    static boolean isEmpty() {
        return front == end;
    }

    private static void bfs(int x, int y) {
        front = end = 0;
        count1 = count2 = -1;
        visited = new boolean[3001][3001];

        push(x, y, 1);
        visited[x][y] = true;
        while (!isEmpty()) {
            pop();
            if (matrix[dx][dy] != 1) continue;
            matrix[dx][dy] = -1;
            count2 = dz;

            if (dx + 1 <= row && !visited[dx + 1][dy]) {
                push(dx + 1, dy, dz + 1);
                visited[dx + 1][dy] = true;
            }

            if (dy + 1 <= col && !visited[dx][dy + 1]) {
                push(dx, dy + 1, dz + 1);
                visited[dx][dy + 1] = true;
            }

            if (dx - 1 >= 1 && !visited[dx - 1][dy]) {
                push(dx - 1, dy, dz + 1);
                visited[dx - 1][dy] = true;
            }

            if (dy - 1 >= 1 && !visited[dx][dy - 1]) {
                push(dx, dy - 1, dz + 1);
                visited[dx][dy - 1] = true;
            }

            //check cell type C
            if (matrix[dxCellC][dyCellC] == 2 && visited[dxCellC + 1][dyCellC] && visited[dxCellC][dyCellC + 1]
                    && visited[dxCellC - 1][dyCellC] && visited[dxCellC][dyCellC - 1]) {
                count1 = dz + 1;
                matrix[dxCellC][dyCellC] = -1;
            }
        }
    }

    static boolean isGridFull() {
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                if (matrix[i][j] == 1) return false;
            }
        }
        return true;
    }

    private static void showOutput(int testCase) {
        if (!isGridFull())
            count2 = -1;
        if (count1 == -1)
            count2 = -1;


        System.out.println("Case #" + testCase);
        System.out.println(count1 + " " + count2);
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new FileInputStream("input"));
        numberTest = sc.nextInt();
        for (int testCase = 1; testCase <= numberTest; testCase++) {
            //input
            row = sc.nextInt();
            col = sc.nextInt();
            x = sc.nextInt();
            y = sc.nextInt();
            for (int i = 1; i <= row; i++) {
                for (int j = 1; j <= col; j++) {
                    matrix[i][j] = sc.nextInt();
                    if (matrix[i][j] == 2) {
                        dxCellC = i;
                        dyCellC = j;
                    }
                }
            }

            bfs(x, y);
            showOutput(testCase);
        }
    }
}
