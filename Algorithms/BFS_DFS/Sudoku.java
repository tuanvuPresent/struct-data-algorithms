package Algorithms_DataStruct.Algorithms.BFS_DFS;

import java.util.Scanner;

public class Sudoku {
    public static int matrix[][] = new int[9][9];
    public static boolean isFind = false;

    private static void input() {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
    }

    public static boolean check(int key, int x, int y) {
        // kiểm tra hàng
        for (int j = 0; j < 9; j++) {
            if (matrix[x][j] == key && j != y)
                return false;
        }
        // kiểm tra cột
        for (int i = 0; i < 9; i++) {
            if (matrix[i][y] == key && i != x)
                return false;
        }
        // kiểm tra vùng 3x3
        int a = x / 3;
        int b = y / 3;
        for (int i = 3 * a; i < 3 * a + 3; i++) {
            for (int j = 3 * b; j < 3 * b + 3; j++) {
                if (matrix[i][j] == key && (i != x || j != y))
                    return false;
            }
        }
        return true;
    }

    public static void solveSudoku(int x, int y) {
        if (x == 9) {
            isFind = true;
            return;
        }
        if (matrix[x][y] == 0) {
            for (int i = 1; i <= 9; i++) {
                if (check(i, x, y)) {
                    matrix[x][y] = i;
                    if (y == 8) {
                        solveSudoku(x + 1, 0);
                    } else {
                        solveSudoku(x, y + 1);
                    }
                    if (isFind) {
                        return;
                    }
                    matrix[x][y] = 0;
                }
            }
        } else {
            if (y == 8) {
                solveSudoku(x + 1, 0);
            } else {
                solveSudoku(x, y + 1);
            }
        }
    }

    public static void show() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        input();
        solveSudoku(0, 0);
        if (isFind) {
            show();
        } else {
            System.out.println("No solution");
        }
    }
}
