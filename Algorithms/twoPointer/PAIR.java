package twoPointer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PAIR {
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

    static final int N = 1000000007;

    public static void main(String[] args) throws FileNotFoundException {

        Scanner sc = new Scanner(new FileInputStream("input_pair"));
        //input
        int n = sc.nextInt();
        int sum = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        //handle
        quickSort(arr, 0, n - 1);
        long res = 0;
        int j = 1;
        // 1 2 3 4 5 6
        for (int i = 0; i < n; i++) {
            if (arr[i] + arr[j] <= sum) {
                while (j < n && arr[j] + arr[i] <= sum) {
                    j++;
                }
                j--;
            } else {
                while (j > i && arr[j] + arr[i] > sum) {
                    j--;
                }
            }
            if (i >= j) {
                break;
            }
            res += (j - i);
        }
        //output
        System.out.println(res);
    }
}
