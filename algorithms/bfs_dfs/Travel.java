import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Travel {
    static long oo = 20000000010000L;
    static int n, m, k;
    static int matrix[][];
    static int travel[];
    static boolean visited[];
    static long d[][];
    static long sMin = oo;

    static long result = -1L;

    static void init() {
        matrix = new int[1001][1001];
        travel = new int[1001];
        visited = new boolean[1001];
        d = new long[1001][1001];
        result = -1;
        sMin = oo;
    }

    static void findShortestWay(int start) {
        //  input matrix ---> output d
        boolean[] checked = new boolean[1001];
        //init
        for (int i = 1; i <= n; i++) {
            d[start][i] = oo;
        }
        int count = 0;
        d[start][start] = 0;
        while (count < n) {
            //find min
            int u = 0;
            long du = oo;
            for (int i = 1; i <= n; i++) {
                if (!checked[i] && du > d[start][i]) {
                    u = i;
                    du = d[start][i];
                }
            }

            checked[u] = true;
            count++;
            //find d
            for (int v = 1; v <= n; v++) {
                if (matrix[u][v] != 0) {
                    long uv = matrix[u][v];
                    if (d[start][v] > du + uv) {
                        d[start][v] = du + uv;
                    }
                }
            }
        }
    }

    static void dfs(int start, long sum, int count) {
        if (count == k) {
            if (d[start][1] < oo && (result > sum + d[start][1] || result == -1)) {
                result = sum + d[start][1];
            }
            return;
        }

        for (int i = 0; i < k; i++) {
            if (!visited[i] && (sum + d[start][travel[i]] + (k - count) * sMin < result || result == -1)) {
                visited[i] = true;
                dfs(travel[i], sum + d[start][travel[i]], count + 1);
                visited[i] = false;
            }
        }
    }

    static void showOutput() {
        System.out.println("# " + result);
    }

    static void showAway() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(d[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileInputStream("input.txt"));

        int numberTest = sc.nextInt();
        for (int testCase = 1; testCase <= numberTest; testCase++) {
            init();
            //input
            n = sc.nextInt();
            m = sc.nextInt();
            k = sc.nextInt();
            for (int i = 0; i < k; i++) {
                travel[i] = sc.nextInt();
            }

            for (int i = 0; i < m; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                int z = sc.nextInt();
                matrix[x][y] = z;
            }

            //===============
            for (int i = 1; i <= n; i++) {
                findShortestWay(i);
            }
            //find sMin
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (i != j && d[i][j] < sMin) {
                        sMin = d[i][j];
                    }
                }
            }
            dfs(1, 0, 0);
            showOutput();
        }
    }
}
