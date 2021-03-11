public class Stair {
    static int f[] = new int[201];
    static int g[] = new int[201];

    private static void stair(int n) {
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if (i < 2) {
                    f[j] = 0;
                } else if (j > i) {
                    int x = g[j];
                    int y = g[j - i];
                    if ((j - i <= i * (i - 1) / 2) && (j - i < i)) {
                        y += 1;
                    }
                    f[j] = x + y;
                } else {
                    f[j] = g[j];
                }
            }
            g = f.clone();
        }
    }

    public static void main(String[] args) {
        int n = 200;
        stair(n);
        System.out.println(f[n]);
    }
}
