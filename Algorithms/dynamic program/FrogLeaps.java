package DynamicProgram;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FrogLeaps {

    private static int input[];
    private static int output[];

    private static int getResult(int n) {
        return output[n - 1];
    }

    private static void solve(int n, int dump) {
        //initial
        output = new int[n];
        if (input[0] <= dump) {
            output[0] = 1;
        } else {
            output[n - 1] = -1;
            return;
        }
        //
        for (int i = 1; i < n; i++) {
            if (input[i] - input[i - 1] <= dump) {
                //tim min
                int j = i - 1;
                int min = (input[i] - dump <= 0) ? 0 : output[j];
                while (j > 0 && input[i] - input[j] <= dump) {
                    if (min > output[j]) {
                        min = output[j];
                    }
                    j--;
                }
                //tinh ouput
                output[i] = min + 1;
            } else {
                output[n - 1] = -1;
                break;
            }
        }

        //show
//        for (int i = 0; i < n; i++) {
//            System.out.print(output[i] + " ");
//        }
//        System.out.println();
    }

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("input_frog_leaps"));

        Scanner sc = new Scanner(System.in);
        int numTest = sc.nextInt();
        for (int tCase = 1; tCase <= numTest; tCase++) {
            //input
            int n = sc.nextInt();
            input = new int[n];
            for (int i = 0; i < n; i++) {
                input[i] = sc.nextInt();
            }
            int dummp = sc.nextInt();
            //handle
            solve(n, dummp);
            int res = getResult(n);
            //output
            System.out.println("Case #" + tCase);
            System.out.println(res);
        }
    }


}
