import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PassGen {
    static int arr[] = new int[8];
    static int index = 0;


    public static void passGen() {
        int sub = 1;
        while (true) {
            arr[index] -= sub;
            if (arr[index] <= 0) {
                arr[index] = 0;
                index = (index + 8 + 1) % 8;
                return;
            }

            index = (index + 8 + 1) % 8;
            sub = (sub < 5) ? sub + 1 : 1;
        }
    }

    public static void output() {
        int loop = 8;
        while (loop > 0) {
            System.out.print(arr[index] + " ");
            index = (index + 8 + 1) % 8;
            loop--;
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("input"));
        for (int tCase = 0; tCase < 10; tCase++) {
            index = 0;
            int n = sc.nextInt();
            for (int i = 0; i < 8; i++) {
                arr[i] = sc.nextInt();
            }

            passGen();
            System.out.print("#" + tCase + " ");
            output();
            System.out.println();
        }
    }
}
