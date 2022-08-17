package twoPointer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SubArray {
    /*
            Dãy con liên tiếp ngắn nhất có tổng > s
            Khi được đưa ra một chuỗi bao gồm N số tự nhiên và số tự nhiên S,
        vấn đề liên quan đến việc tính toán các phân đoạn nhỏ nhất trong số các chuỗi con
        của các chuỗi trong đó tổng bằng hoặc lớn hơn S.

        Ví dụ, khi chuỗi 5, 1, 3, 5, 10, 7, 4, 9, 2, 8 được đưa ra và S là 15,
        đoạn nhỏ nhất là khi tổng của [10, 7] bằng hoặc lớn hơn S. Do đó câu trả lời trở thành 2.

     */
    public static void main(String[] args) throws FileNotFoundException {

        System.setIn(new FileInputStream("input_sub_array"));
        Scanner sc = new Scanner(System.in);
        int numTest = sc.nextInt();
        for (int tCase = 1; tCase <= numTest; tCase++) {
            //input
            int n = sc.nextInt();
            int s = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            //handle
            int res = 100001;
            int sum = arr[0];
            int count = 1;
            for (int i = 1; i < n; i++) {
                sum += arr[i];
                count++;
                if (sum > s) {
                    while (sum - arr[i - count + 1] > s) {
                        sum -= arr[i - count + 1];
                        count--;
                    }

                    if (res > count) {
                        res = count;
                    }
                }
            }
            if (res == 100001) {
                res = 0;
            }
            //ouput
            System.out.println("#testcase" + tCase);
            System.out.println(res);
        }
    }
}
