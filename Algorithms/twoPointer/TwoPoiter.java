package twoPointer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TwoPoiter {

    private static int sum1(int arr[], int sum) {
        //Tong day con lien tiep co tong >= sum
        //  O(N^2)
        int res = 0;
        int n = arr.length;
        int j = 0;
        for (int i = 0; i < n; i++) {
            int run = 0;
            for (j = i; j < n; j++) {
                run += arr[j];
                if (run >= sum) break;
            }
            res += n - j;
        }
        return res;
    }

    private static int sum(int arr[], int sum) {
        //1 2 5 4 2
        int n = arr.length;
        int res = 0;
        int pos = 0;
        int run = 0;
        for (int i = 0; i < n; i++) {
            run += arr[i];
            while (run - arr[pos] >= sum) {
                run -= arr[pos];
                pos++;
            }
            if (run >= sum) {
                res += pos + 1;
            }
        }

        return res;
    }

    private static int sum2(int arr[], int sum) {
        //1 2 5 4 2
        //  O(N)
        int res = 0;
        int n = arr.length;
        int pos = 0;
        int run = 0;
        for (int i = 0; i < n; i++) {
            run -= (i > 0) ? arr[i - 1] : 0;
            while (pos < n && run + arr[pos] < sum) {
                run += arr[pos];
                pos++;
            }
            res += (n - pos);
        }
        return res;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileInputStream("input.txt"));

        //input
        int n = sc.nextInt();
        int sum = sc.nextInt();
        int input[] = new int[n];
        for (int i = 0; i < n; i++) {
            input[i] = sc.nextInt();
        }
        //xu ly
        int res = sum1(input, sum);
        int res1 = sum(input, sum);
        int res2 = sum2(input, sum);
        //ouput
        System.out.println(res);
        System.out.println(res1);
        System.out.println(res2);
    }
}
