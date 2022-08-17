package twoPointer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AllocationBus {
    /*
    That is, two players i and j (i≠j)(i≠j)will not ride in a same bus if |Ai−Aj|≤K is true.
     */
    public static void quickSort(int arr[], int left, int right) {
        int i = left, j = right;
        int mid = i + (j - i) / 2;
        int key = arr[mid];

        while (i <= j) {
            while (arr[i] < key) {
                i++;
            }
            while (arr[j] > key) {
                j--;
            }
            if (i <= j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
        if (j > left) {
            quickSort(arr, left, j);
        }
        if (i < right) {
            quickSort(arr, i, right);
        }
    }


    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileInputStream("input_phanboxebus"));

//        Scanner sc = new Scanner(System.in);
        int numTest = sc.nextInt();
        for (int tCase = 1; tCase <= numTest; tCase++) {
            //input
            int n = sc.nextInt();
            int k = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            //handle
            //1 3 5 7 9  --- k = 3
            quickSort(arr, 0, n - 1);
            int res = 0;
            int j = 0;
            for (int i = 0; i < n; i++) {

                while (j < n && arr[j] - arr[i] <= k) {
                    j++;
                }
                res = (res > j - i) ? res : j - i;
            }
            //ouput
            System.out.println("Case #" + tCase);
            System.out.println(res);
        }
    }
}
