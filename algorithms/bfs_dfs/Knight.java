import java.util.Scanner;

/*
2

5 41
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 1 0 0 1 0 0 0 0 3 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0 1 0 0 1 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0

4 5
0 0 3 0 0
0 0 0 0 1
0 0 1 0 0
0 0 0 0 1

output:
25
3

 */
public class Knight {
    //queue
    static int queueX[] = new int[10001];
    static int queueY[] = new int[10001];
    static int last, first;
    static int qX, qY;

    public static void initQueue() {
        last = first = 0;
    }

    public static void pop() {
        qX = queueX[first];
        qY = queueY[first];
        first++;
    }

    public static void push(int x, int y) {
        queueX[last] = x;
        queueY[last] = y;
        last++;
    }

    public static boolean isEmpty() {
        return last == first;
    }

    //program
    static final int[] dx = {-1, -2, -2, -1, 1, 2, 2, 1};
    static final int[] dy = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int row, col;
    static int startX, startY;

    static int oo;
    static int[][] matrix;
    static int result;
    static int[][] listEnemy;
    static int countEnemy;

    static int[][] step = new int[101][101];
    static int[][] space = new int[101][101];
    static boolean[] visitedEnemy = new boolean[10001];

    public static void init() {
        oo = 1000000001;
        matrix = new int[101][101];
        listEnemy = new int[10001][2];
        result = oo;
        countEnemy = 0;
    }

    public static int findItemInListEnemy(int x, int y) {
        for (int i = 0; i < countEnemy; i++) {
            int sx = listEnemy[i][0];
            int sy = listEnemy[i][1];
            if (sx == x && sy == y) {
                return i;
            }
        }
        return -1;
    }

    public static void bfs(int x, int y, int index) {
        step = new int[101][101];
        step[x][y] = 0;

        initQueue();
        push(x, y);
        while (!isEmpty()) {
            pop();

            for (int i = 0; i < 8; i++) {
                x = qX + dx[i];
                y = qY + dy[i];
                if (x < row && y < col && x >= 0 && y >= 0 && step[x][y] == 0) {
                    push(x, y);
                    step[x][y] = step[qX][qY] + 1;

                    //save to array space
                    int pos = findItemInListEnemy(x, y);
                    if (matrix[x][y] == 1) {
                        space[index][pos + 1] = step[qX][qY] + 1;
                    }
                }
            }
        }
    }

    public static void findShortestAway() {
        bfs(startX, startY, 0);
        for (int i = 0; i < countEnemy; i++) {
            int x = listEnemy[i][0];
            int y = listEnemy[i][1];
            bfs(x, y, i + 1);
        }
    }

    public static void dfs(int start, int count, int sum) {
        if (count == countEnemy) {
            if (result > sum) {
                result = sum;
            }
            return;
        }

        for (int next = 1; next <= countEnemy; next++) {
            if (!visitedEnemy[next] && space[start][next] != 0) {
                visitedEnemy[next] = true;
                dfs(next, count + 1, sum + space[start][next]);
                visitedEnemy[next] = false;
            }
        }
    }

    // show some output
    public static void showOutput() {
        System.out.println("# " + result);
    }

    public static void showListEnemy() {
        for (int i = 0; i < countEnemy; i++) {
            System.out.print(listEnemy[i][0] + " " + listEnemy[i][0] + " ");
        }
        System.out.println();
    }

    public static void showListSpace() {
        for (int i = 0; i <= countEnemy; i++) {
            for (int j = i + 1; j <= countEnemy; j++) {
                System.out.println(i + " -> " + j + ": " + space[i][j]);
            }
        }
    }

    public static void showMatrix() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numberTest = sc.nextInt();
        for (int testCase = 0; testCase < numberTest; testCase++) {
            init();
            //input
            row = sc.nextInt();
            col = sc.nextInt();
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    matrix[i][j] = sc.nextInt();

                    if (matrix[i][j] == 3) {
                        startX = i;
                        startY = j;
                    }

                    if (matrix[i][j] == 1) {
                        listEnemy[countEnemy][0] = i;
                        listEnemy[countEnemy][1] = j;
                        countEnemy++;
                    }
                }
            }

            findShortestAway();
            dfs(0, 0, 0);
            showOutput();
        }
    }
}
