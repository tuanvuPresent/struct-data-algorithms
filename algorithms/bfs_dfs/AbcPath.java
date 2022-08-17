import java.util.Scanner;

public class AbcPath {
    static int row, col;
    static char matrix[][] = new char[51][51];
    static int data[] = new int[51];
    static boolean isFind = false;
    static boolean visited[][] = new boolean[51][51];
    static int result = -1;

    static int directX[] = {-1, -1, -1, 0, 1, 1, 1, 0};
    static int directY[] = {-1, 0, 1, 1, 1, 0, -1, -1};

    public static void input() {
        Scanner sc = new Scanner(System.in);
        row = sc.nextInt();
        col = sc.nextInt();
        for (int i = 0; i < row; i++) {
            matrix[i] = sc.next().toCharArray();
        }

        sc.nextInt();
        sc.nextInt();
    }

    public static void dfs(int x, int y, int count) {
        data[count] = matrix[x][y];
        visited[x][y] = true;

        for (int i = 0; i < 8; i++) {
            int dx = x + directX[i];
            int dy = y + directY[i];
            if (dx >= 0 && dy >= 0 && dx < row && dy < col && !visited[dx][dy] && data[count] + 1 == matrix[dx][dy]) {
                dfs(dx, dy, count + 1);
                visited[dx][dy] = false;
            }
        }

        if (result < count) {
            result = count;
        }
    }

    public static void output() {
        for (int i = 0; i <= result; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
        System.out.println(result + 1);
    }

    public static void main(String[] args) {
        input();
        dfs(0, 0, 0);
        output();
    }

}
