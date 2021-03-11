package baitap;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Hydro {
	private static int max(int arr[], int start, int end) {
		// TODO Auto-generated method stub
		int index = start;
		int max = arr[start];
		for (int i = start; i < end; i++) {
			if (max < arr[i]) {
				index = i;
				max = arr[i];
			}
		}
		return index;
	}

	private static int hydroDam(int arr[]) {
		// TODO Auto-generated method stub
		int res = 0;
		int len = arr.length;
		int start = 0;
		int end = len;
		int mid = max(arr, start, end);
		// tính lượng nước từng khoảng từ start đến mid
		for (int i = 0; i < mid; i++) {
			if (arr[i] > arr[i + 1]) {
				res += arr[i] - arr[i + 1];
				arr[i + 1] = arr[i];
			}
		}
		// tính lượng nước từng khoảng từ end đến mid
		for (int i = end - 1; i > mid; i--) {
			if (arr[i] > arr[i - 1]) {
				res += arr[i] - arr[i - 1];
				arr[i - 1] = arr[i];
			}
		}

		return res;
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("hydro.txt"));

		Scanner sc = new Scanner(System.in);
		int tCase = sc.nextInt();
		for (int i = 1; i <= tCase; i++) {
			// nhập
			int n = sc.nextInt();
			int arr[] = new int[n];
			for (int j = 0; j < arr.length; j++) {
				arr[j] = sc.nextInt();
			}
			// kết quả
			int res = hydroDam(arr);
			// xuất
			System.out.println("#" + i + " " + res);
		}
	}
}
