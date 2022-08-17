package baitap;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PersonSort {
	public static void sort(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				if (arr[i] > arr[j]) {
					int temp = arr[j];
					arr[j] = arr[i];
					arr[i] = temp;
				}
			}
		}
	}

	private static void show(int arr[]) {
		// TODO Auto-generated method stub
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("personSort.txt"));

		Scanner sc = new Scanner(System.in);
		int tCase = sc.nextInt();

		for (int i = 1; i <= tCase; i++) {
			// nhap
			int n = sc.nextInt();
			int arrHight[] = new int[n];// chieu cao cua nguoi
			for (int j = 0; j < n; j++) {
				arrHight[j] = sc.nextInt();
			}
			int index[] = new int[1000];// so nguoi cao hon dung truoc
			for (int j = 0; j < n; j++) {
				index[arrHight[j]] = sc.nextInt();
			}

			sort(arrHight);
			// ket qua
			int output[] = new int[n];
			for (int j = 0; j < arrHight.length; j++) {
				// dien tung nguoi vao mang output
				int count = index[arrHight[j]];
				for (int k = 0; k < output.length; k++) {
					// neu count =0 thi dien vao mang output
					if (count == 0 && output[k] == 0) {
						output[k] = arrHight[j];
						break;
					}
					// neu output[j] chua dien thi count -1
					if (output[k] == 0)
						count--;
				}
			}
			// xuat
			System.out.println("#" + i + " ");
			show(output);
		}
	}
}
