import java.util.Scanner;

/*
2

5 7
0 0 0 0 0 0 0
0 3 0 0 0 1 0
0 0 0 0 0 0 0
0 1 0 0 0 1 0
0 0 0 0 0 0 0

5 15
0 0 0 0 2 0 2 0 0 0 0 1 2 0 1
0 0 0 1 0 2 0 2 2 0 1 2 0 0 0
2 1 0 2 0 1 0 2 0 0 0 0 0 0 0
0 0 0 1 0 2 0 0 1 2 0 0 2 0 0
0 2 1 0 2 0 0 0 0 0 3 0 0 0 0

output:
8
38

 */
public class CleanRobot {
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
    static final int[] dx = {-1, 0, 1, 0};
    static final int[] dy = {0, 1, 0, -1};
    static int row, col;
    static int startX, startY;

    static int oo;
    static int[][] matrix;
    static int result;
    static int[][] cleanList;
    static int countClean;

    static int[][] step = new int[101][101];
    static int[][] space = new int[101][101];
    static boolean[] visited = new boolean[10001];

    public static void init() {
        oo = 1000000001;
        matrix = new int[101][101];
        cleanList = new int[10001][2];
        result = -1;
        countClean = 0;
    }

    public static void bfs(int x, int y, int index) {
        step = new int[101][101];
        step[x][y] = 0;

        initQueue();
        push(x, y);
        while (!isEmpty()) {
            pop();

            for (int i = 0; i < 4; i++) {
                x = qX + dx[i];
                y = qY + dy[i];
                if (x < row && y < col && x >= 0 && y >= 0 && matrix[x][y] != 2 && step[x][y] == 0) {
                    push(x, y);
                    step[x][y] = step[qX][qY] + 1;
                }
            }
        }

        int count = 1;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 1) {
                    space[index][count] = step[i][j];
                    count++;
                }
            }
        }
    }

    public static void findShortestAway() {
        bfs(startX, startY, 0);
        for (int i = 0; i < countClean; i++) {
            int x = cleanList[i][0];
            int y = cleanList[i][1];
            bfs(x, y, i + 1);
        }
    }

    public static void dfs(int start, int count, int sum) {
        if (count == countClean) {
            if (result > sum || result == -1) {
                result = sum;
            }
            return;
        }

        for (int next = 1; next <= countClean; next++) {
            if (!visited[next] && space[start][next] != 0) {
                visited[next] = true;
                dfs(next, count + 1, sum + space[start][next]);
                visited[next] = false;
            }
        }
    }

    // show some output
    public static void showOutput() {
        System.out.println("# " + result);
    }

    public static void showListClean() {
        for (int i = 0; i < countClean; i++) {
            System.out.print(cleanList[i][0] + " " + cleanList[i][1] + " ");
        }
        System.out.println();
    }

    public static void showListSpace() {
        for (int i = 0; i <= countClean; i++) {
            for (int j = i + 1; j <= countClean; j++) {
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
        for (int testCase = 1; testCase <= numberTest; testCase++) {
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
                        cleanList[countClean][0] = i;
                        cleanList[countClean][1] = j;
                        countClean++;
                    }
                }
            }

            findShortestAway();
            dfs(0, 0, 0);
            showOutput();
        }
    }
}
